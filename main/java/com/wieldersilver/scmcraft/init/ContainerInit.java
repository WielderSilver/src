/**
 * 
 */
package com.wieldersilver.scmcraft.init;

import com.wieldersilver.scmcraft.scmcraft;
import com.wieldersilver.scmcraft.gui.ContainerSpellStation;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

/**
 * @author gusjg
 *
 */
@ObjectHolder(scmcraft.MOD_ID)
@Mod.EventBusSubscriber(modid = scmcraft.MOD_ID, bus = Bus.MOD)
public class ContainerInit 
{
	@SuppressWarnings("unchecked")
	public static final ContainerType<ContainerSpellStation> SPELL_STATION = (ContainerType<ContainerSpellStation>) IForgeContainerType.create(ContainerSpellStation::new).setRegistryName("spell_gui");
	
	
	@SubscribeEvent
	public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event)
	{
		
		
		event.getRegistry().register(SPELL_STATION);
	}

}
