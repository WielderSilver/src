package com.wieldersilver.scmcraft.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.types.Type;
import com.wieldersilver.scmcraft.scmcraft;
import com.wieldersilver.scmcraft.init.SpellInit;
import com.wieldersilver.scmcraft.recipes.SpellIngredient;
import com.wieldersilver.scmcraft.spells.Scrawl;
import com.wieldersilver.scmcraft.spells.Spell;
import com.wieldersilver.scmcraft.spells.Tome;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.datafix.DataFixesManager;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Utils {
	
	@OnlyIn(Dist.CLIENT)
	@Nullable
	public static LivingEntity getExtendedRangeTarget(double distance) 
	{
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
	
	/**
     * Returns a key json object as a Java HashMap.
     * "Borrowed" from ShapedRecipe.
     */
	public static Map<String, SpellIngredient> deserializeKey(JsonObject json) 
	{
		Map<String, SpellIngredient> map = new HashMap<String, SpellIngredient>();
		
		//Map<String, SpellIngredient> map = Maps.newHashMap();

		for(Entry<String, JsonElement> entry : json.entrySet()) 
		{
			if(entry.getValue().isJsonArray())
			{
				map.put(entry.getKey(), SpellIngredient.Serializer.INSTANCE.parse(entry.getValue().getAsJsonArray()));
			}
			else if(entry.getValue().isJsonObject())
			{
				map.put(entry.getKey(), SpellIngredient.Serializer.INSTANCE.parse(entry.getValue().getAsJsonObject()));
			}
		}

		//map.put(" ", Ingredient.EMPTY);
		return map;
	}
}
