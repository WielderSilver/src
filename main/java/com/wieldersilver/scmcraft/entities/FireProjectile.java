/**
 * 
 */
package com.wieldersilver.scmcraft.entities;

import com.wieldersilver.scmcraft.init.EntityInit;

import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * @author gusjg
 *
 */
public class FireProjectile extends AbstractFireballEntity {

	protected LivingEntity target = null;
	
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
	}
	
	public FireProjectile(World world, LivingEntity shooter)
	{
		super(EntityInit.FIRE_PROJECTILE, shooter, 0, 0, 0, world);
		this.accelerationX = 0;
		this.accelerationY = 0;
		this.accelerationZ = 0;
		this.setMotion(shooter.getLook(1).scale(this.getMotionFactor()));
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
    	
    	Vec3d pos = this.getPositionVec();
		Vec3d vel = this.getMotion();
    	if(!this.world.isRemote && this.target != null)
    	{
    		Vec3d targetPos = target.getPositionVec();
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
    	
    	super.tick();
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
}
