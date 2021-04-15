/**
 * 
 */
package com.wieldersilver.scmcraft.entities;

import com.wieldersilver.scmcraft.init.EntityInit;

import net.minecraft.block.Blocks;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * @author gusjg
 *
 */
public class FireProjectile extends AbstractFireballEntity {

	protected LivingEntity target = null;
	protected float velYaw;
	protected float velPitch;
	
	/**
	 * @param p_i50166_1_
	 * @param p_i50166_2_
	 */
	public FireProjectile(EntityType<? extends AbstractFireballEntity> p_i50166_1_, World p_i50166_2_) {
		super(p_i50166_1_, p_i50166_2_);
		// TODO Auto-generated constructor stub
	}
	
	public FireProjectile(World world, LivingEntity shooter, LivingEntity target)
	{
		super(EntityInit.FIRE_PROJECTILE, shooter, 0, 0, 0, world);
		this.target = target;
		this.accelerationX = 0;
		this.accelerationY = 0;
		this.accelerationZ = 0;
		
		Vec3d eyePos = shooter.getEyePosition(1);
		this.setPosition(eyePos.x, eyePos.y, eyePos.z);
		
		float yaw = shooter.rotationYaw;
		float pitch = shooter.rotationPitch;
		
		this.setRotation(yaw, pitch);
		
		this.setMotion(this.getLook(1).scale(this.getMotionFactor()));
	}
	
	public FireProjectile(World world, LivingEntity shooter)
	{
		//Vec3d eyePos = shooter.getEyePosition(1);
		super(EntityInit.FIRE_PROJECTILE, shooter, 0, 0, 0, world);
		this.accelerationX = 0;
		this.accelerationY = 0;
		this.accelerationZ = 0;
		
		Vec3d eyePos = shooter.getEyePosition(1);
		this.setPosition(eyePos.x, eyePos.y, eyePos.z);
		
		float yaw = shooter.rotationYaw;
		float pitch = shooter.rotationPitch;
		
		this.setRotation(yaw, pitch);
		
		this.setMotion(this.getLook(1).scale(this.getMotionFactor()));
	}
	
	public FireProjectile(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
	      super(EntityInit.FIRE_PROJECTILE, shooter, accelX, accelY, accelZ, worldIn);
	   }
	
    public FireProjectile(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
      super(EntityInit.FIRE_PROJECTILE, x, y, z, accelX, accelY, accelZ, worldIn);
    }
	  
    @Override
    public void tick()
    {
    	if(!this.world.isRemote && this.target != null)
    	{
			//public void lookAt(EntityAnchorArgument.Type p_200602_1_, Vec3d p_200602_2_)
			Vec3d vec3d = EntityAnchorArgument.Type.EYES.apply(this);
			Vec3d targetPos = target.getPositionVec();
			double d0 = targetPos.x - vec3d.x;
			double d1 = targetPos.y - vec3d.y;
			double d2 = targetPos.z - vec3d.z;
			double d3 = (double)MathHelper.sqrt(d0 * d0 + d2 * d2);
			float pitch = MathHelper.wrapDegrees((float)(-(MathHelper.atan2(d1, d3) * (double)(180F / (float)Math.PI))));
			float yaw = MathHelper.wrapDegrees((float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F);
			
			float newPitch = MathHelper.approachDegrees(this.rotationPitch, pitch, this.maxDegreeChange());
			float newYaw = MathHelper.approachDegrees(this.rotationYaw, yaw, this.maxDegreeChange());
			this.setRotation(newYaw, newPitch);
			
			this.setRotationYawHead(this.rotationYaw);
			this.prevRotationPitch = this.rotationPitch;
			this.prevRotationYaw = this.rotationYaw;
			
			this.setMotion(this.getLook(1).scale(this.getMotionFactor()));
    	}
    	
    	super.tick();
		
		/*
		
    	if(!this.world.isRemote && this.target != null)
    	{
    		Vec3d velDiff = vel.add(newVel.scale(-1));
    		
    		//Vec3d targetPos = target.getPositionVec();
    		Vec3d posDiff = targetPos.add(pos.scale(-1));
    		double distance = pos.distanceTo(targetPos);
    		if(pos.add(vel.scale(distance)).distanceTo(targetPos) <= distance)
    		{
    			this.accelerationX = Math.signum(posDiff.x) * 0.1;
    			this.accelerationY = Math.signum(posDiff.y) * 0.1;
    			this.accelerationZ = Math.signum(posDiff.z) * 0.1; 
    		}
    	}
    	
    	this.setMotion(vel.add(this.accelerationX, this.accelerationY, this.accelerationZ).normalize().scale(this.getMotionFactor()));
    	this.accelerationX = 0;
    	this.accelerationY = 0;
    	this.accelerationZ = 0;
    	
    	super.tick();*/
    }
    
    /**
     * Called when this EntityFireball hits a block or entity.
     */
    @Override
    protected void onImpact(RayTraceResult result) 
    {
       super.onImpact(result);
       if (!this.world.isRemote) 
       {
          if (result.getType() == RayTraceResult.Type.ENTITY) 
          {
             Entity entity = ((EntityRayTraceResult)result).getEntity();
             if (!entity.isImmuneToFire()) 
             {
                int i = entity.func_223314_ad();
                entity.setFire(5);
                boolean flag = entity.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 2.0F);
                if (flag) 
                {
                   this.applyEnchantments(this.shootingEntity, entity);
                } 
                else 
                {
                   entity.func_223308_g(i);
                }
             }
          } 
          else if (this.shootingEntity == null || !(this.shootingEntity instanceof MobEntity) || net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.shootingEntity)) 
          {
             BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)result;
             BlockPos blockpos = blockraytraceresult.getPos().offset(blockraytraceresult.getFace());
             if (this.world.isAirBlock(blockpos)) 
             {
                this.world.setBlockState(blockpos, Blocks.FIRE.getDefaultState());
             }
          }

          this.remove();
       }
    }
    
    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    @Override
    public boolean canBeCollidedWith() {
       return false;
    }
    
    /**
     * Return the motion factor for this projectile. The factor is multiplied by the original motion.
     */
    @Override
    protected float getMotionFactor() {
       return 1.5f;
    }
    
    protected float maxDegreeChange() 
    {
    	return 10f;
    }
}
