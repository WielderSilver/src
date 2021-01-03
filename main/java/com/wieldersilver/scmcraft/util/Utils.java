package com.wieldersilver.scmcraft.util;

import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Utils {
	
	@OnlyIn(Dist.CLIENT)
	@Nullable
	public static LivingEntity getExtendedRangeTarget(double distance) {
		Minecraft mc = Minecraft.getInstance();
		
		Entity player = mc.getRenderViewEntity();
		RayTraceResult objectMouseOver = null;
	      
        objectMouseOver = player.func_213324_a(distance, 1, false);
        Vec3d vec3d = player.getEyePosition(1);
        double distanceSq = distance * distance;
        if (objectMouseOver != null) 
        {
        	distanceSq = objectMouseOver.getHitVec().squareDistanceTo(vec3d);
        }

        Vec3d vec3d1 = player.getLook(1.0F);
        Vec3d vec3d2 = vec3d.add(vec3d1.scale(distance));
        
        AxisAlignedBB axisalignedbb = player.getBoundingBox().expand(vec3d1.scale(distance)).grow(1.0D, 1.0D, 1.0D);
        
        EntityRayTraceResult entityraytraceresult = ProjectileHelper.func_221273_a(player, vec3d, vec3d2, axisalignedbb, (p_215312_0_) -> {
        	return !p_215312_0_.isSpectator() && p_215312_0_.canBeCollidedWith() && p_215312_0_ instanceof LivingEntity;
        }, distanceSq);
        
        if (entityraytraceresult != null) 
        {
        	Entity entity1 = entityraytraceresult.getEntity();
        	Vec3d vec3d3 = entityraytraceresult.getHitVec();
        	double d2 = vec3d.squareDistanceTo(vec3d3);
        	
        	if (d2 <= distanceSq || objectMouseOver == null) 
        	{
        	   return (LivingEntity) entity1;
        	}
        }

	           
		return null;
	}
}
