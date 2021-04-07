/**
 * 
 */
package com.wieldersilver.scmcraft.init;

import com.wieldersilver.scmcraft.scmcraft;
import com.wieldersilver.scmcraft.entities.FireProjectile;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

/**
 * @author HFF
 *
 */
@ObjectHolder(scmcraft.MOD_ID)
@Mod.EventBusSubscriber(modid = scmcraft.MOD_ID, bus = Bus.MOD)
public class EntityInit 
{
	public static final EntityType<FireProjectile> FIRE_PROJECTILE = EntityType.Builder.<FireProjectile>create(FireProjectile::new, EntityClassification.MISC).size(1.0F, 1.0F).build("fire_projectile");

	@SubscribeEvent
	public static void registerSpells(final RegistryEvent.Register<EntityType<?>> event)
	{
		event.getRegistry().register(FIRE_PROJECTILE.setRegistryName("fire_projectile"));
	}
	

}
