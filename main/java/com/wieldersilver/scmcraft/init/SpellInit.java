package com.wieldersilver.scmcraft.init;

import com.wieldersilver.scmcraft.scmcraft;
import com.wieldersilver.scmcraft.spells.*;

import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.RegistryBuilder;

@Mod.EventBusSubscriber(modid = scmcraft.MOD_ID, bus = Bus.MOD)
@ObjectHolder(scmcraft.MOD_ID)
public class SpellInit 
{
	public static IForgeRegistry<Spell> SPELLS;
	
	public static final Spell THUNDER = new ThunderSpell().setRegistryName("thunder");
	public static final Spell FIRE = new FireSpell().setRegistryName("fire");
	public static final Spell BLIZZARD = new BlizzardSpell().setRegistryName("blizzard");
	
	@SubscribeEvent
	public static void registerRegistry(final RegistryEvent.NewRegistry event)
	{
		
		
		RegistryBuilder<Spell> registryBuilder = new RegistryBuilder().setName(ResourceLocations.SPELLS).setType(Spell.class).setMaxID(Integer.MAX_VALUE - 1);
		SPELLS = registryBuilder.create();
		
	}

	@SubscribeEvent
	public static void registerSpells(final RegistryEvent.Register<Spell> event)
	{
		event.getRegistry().register(THUNDER);
		event.getRegistry().register(FIRE);
		event.getRegistry().register(BLIZZARD);
		
	}
	
	

}
