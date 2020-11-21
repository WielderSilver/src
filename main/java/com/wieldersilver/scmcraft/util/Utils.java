package com.wieldersilver.scmcraft.util;

import java.util.ArrayList;
import java.util.List;

import com.wieldersilver.scmcraft.scmcraft;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemFrameEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class Utils {

	public static LivingEntity getTarget(double distance)
	{
		float par1 = 1;
	    Minecraft mc = Minecraft.getInstance();

	    Entity pointedEntity;
	    double d0 = distance;
	    RayTraceResult omo = mc.renderViewEntity.func_213324_a(d0, par1, false);
	    double d1 = d0;
	    Vec3d v0 = mc.renderViewEntity.getPositionVec();
	    Vec3d v1 = mc.renderViewEntity.getLook(par1);
	    Vec3d v2 = new Vec3d(v1.x * d0, v1.y * d0, v1.z * d0);
	    pointedEntity = null;
	    Vec3d v3 = null;
	    AxisAlignedBB bb = mc.renderViewEntity.getBoundingBox().expand(v2.x, v2.y, v2.z);
	    List<Entity> list = mc.world.getEntitiesWithinAABBExcludingEntity(mc.renderViewEntity, bb);
	    double d2 = d1;

	    for (int i = 0; i < list.size(); ++i)
	    {
	        Entity entity = (Entity)list.get(i);
	        
	        

	        if (entity.canBeCollidedWith())
	        {
	            float f2 = entity.getCollisionBorderSize();
	            AxisAlignedBB axisalignedbb = entity.getBoundingBox().expand((double)f2, (double)f2, (double)f2);
	            
	            
	            // TODO make this line work work
	            RayTraceResult RayTraceResult = null; //AxisAlignedBB.rayTrace(temp, v0, v2, entity.getPosition());

	            
	            
	            if (axisalignedbb.contains(v0))
	            {
	            	scmcraft.LOGGER.debug("Point A: " + entity);
	                if (0.0D < d2 || d2 == 0.0D)
	                {
	                    pointedEntity = entity;
	                    v3 = RayTraceResult == null ? v0 : RayTraceResult.getHitVec();
	                    d2 = 0.0D;
	                }
	            }
	            else if (RayTraceResult != null)
	            {
	                double d3 = v0.distanceTo(RayTraceResult.getHitVec());
	                
	                scmcraft.LOGGER.debug("Point B: " + entity);

	                if (d3 < d2 || d2 == 0.0D)
	                {
	                    if (entity == mc.renderViewEntity.getRidingEntity() && !entity.canRiderInteract())
	                    {
	                        if (d2 == 0.0D)
	                        {
	                            pointedEntity = entity;
	                            v3 = RayTraceResult.getHitVec();
	                        }
	                    }
	                    else
	                    {
	                        pointedEntity = entity;
	                        v3 = RayTraceResult.getHitVec();
	                        d2 = d3;
	                    }
	                }
	            }
	        }
	    }
	    if (pointedEntity != null && (d2 < d1 || omo == null))
	    {
	        omo = new EntityRayTraceResult(pointedEntity, v3);

	        if (pointedEntity instanceof LivingEntity || pointedEntity instanceof ItemFrameEntity)
	        {
	            mc.pointedEntity = pointedEntity;
	        }
	    }
	    if (omo != null)
	    {
	        if (omo.getType() == RayTraceResult.Type.ENTITY)
	        {
	        	EntityRayTraceResult durrr = (EntityRayTraceResult) omo;
	            if(durrr.getEntity() instanceof LivingEntity)
	            {
	                return (LivingEntity)durrr.getEntity();
	            }
	        }
	    }
	    return null;
	}
}
