/**
 * 
 */
package com.wieldersilver.scmcraft.entities;

import com.wieldersilver.scmcraft.init.EntityInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
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
public class BlizzardProjectile extends DamagingProjectileEntity {

	/**
	 * @param p_i50173_1_
	 * @param p_i50173_2_
	 */
	public BlizzardProjectile(EntityType<? extends DamagingProjectileEntity> p_i50173_1_, World p_i50173_2_) {
		super(p_i50173_1_, p_i50173_2_);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param p_i50175_1_
	 * @param p_i50175_2_
	 * @param p_i50175_3_
	 * @param p_i50175_5_
	 * @param p_i50175_7_
	 * @param p_i50175_9_
	 */
	public BlizzardProjectile(EntityType<? extends DamagingProjectileEntity> p_i50175_1_, LivingEntity p_i50175_2_,
			double p_i50175_3_, double p_i50175_5_, double p_i50175_7_, World p_i50175_9_) {
		super(p_i50175_1_, p_i50175_2_, p_i50175_3_, p_i50175_5_, p_i50175_7_, p_i50175_9_);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param p_i50174_1_
	 * @param p_i50174_2_
	 * @param p_i50174_4_
	 * @param p_i50174_6_
	 * @param p_i50174_8_
	 * @param p_i50174_10_
	 * @param p_i50174_12_
	 * @param p_i50174_14_
	 */
	public BlizzardProjectile(EntityType<? extends DamagingProjectileEntity> p_i50174_1_, double p_i50174_2_,
			double p_i50174_4_, double p_i50174_6_, double p_i50174_8_, double p_i50174_10_, double p_i50174_12_,
			World p_i50174_14_) {
		super(p_i50174_1_, p_i50174_2_, p_i50174_4_, p_i50174_6_, p_i50174_8_, p_i50174_10_, p_i50174_12_,
				p_i50174_14_);
		// TODO Auto-generated constructor stub
	}
	
	protected Vec3d initialMotion;
	
	public BlizzardProjectile(World world, LivingEntity shooter)
	{
		super(EntityInit.BLIZZARD_PROJECTILE, shooter, 0, 0, 0, world);
		
		this.accelerationX = 0;
		this.accelerationY = 0;
		this.accelerationZ = 0;
		
		Vec3d eyePos = shooter.getEyePosition(1);
		this.setPosition(eyePos.x, eyePos.y, eyePos.z);
		
		float yaw = shooter.rotationYaw;
		float pitch = shooter.rotationPitch;
		
		this.setRotation(yaw, pitch);
		
		initialMotion = this.getLook(1).scale(this.getMotionFactor());
		
		this.setMotion(initialMotion);
	}
	
	@Override
    public void tick()
    {
		if(initialMotion == null)
		{
			initialMotion = this.getLook(1).scale(this.getMotionFactor());
		}
		this.setMotion(initialMotion);
		super.tick();
    }
	
	@Override
    protected void onImpact(RayTraceResult result) 
    {
       super.onImpact(result);
       if (!this.world.isRemote) 
       {
          if (result.getType() == RayTraceResult.Type.ENTITY) 
          {
             Entity entity = ((EntityRayTraceResult)result).getEntity();
             
             
             entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, this.shootingEntity), 3.0f);
             
             if(entity instanceof LivingEntity)
             {
            	 ((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 40, 1));
             }
          } 
          else if (this.shootingEntity == null || !(this.shootingEntity instanceof MobEntity) || net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.shootingEntity)) 
          {
             BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)result;
             BlockPos blockpos = blockraytraceresult.getPos().offset(blockraytraceresult.getFace());
             
             if (this.world.isAirBlock(blockpos)) 
             {
                this.world.setBlockState(blockpos, Blocks.SNOW.getDefaultState());
             }
          }

          this.remove();
       }
    }
    
	/**
     * Return the motion factor for this projectile. The factor is multiplied by the original motion.
     */
    @Override
    protected float getMotionFactor() {
       return 0.5f;
    }
}
