/**
 * 
 */
package com.wieldersilver.scmcraft.entities;

import com.wieldersilver.scmcraft.init.EntityInit;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
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
	}
	
	public FireProjectile(World world, LivingEntity shooter)
	{
		super(EntityInit.FIRE_PROJECTILE, shooter, 0, 0, 0, world);
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
    	if(this.target != null)
    	{
    		Vec3d pos = this.getPositionVec();
    		Vec3d vel = this.getMotion();
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
    }

}
