package com.wieldersilver.scmcraft;

import org.apache.logging.log4j.LogManager;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wieldersilver.scmcraft.init.ItemInit;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("scmcraft")
public class scmcraft
{
	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "scmcraft";
    public static scmcraft instance;

    public scmcraft() {        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);       
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {

    }
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {
       
    }

    public static class scmItemGroup extends ItemGroup
    {
    	public static final scmItemGroup instance = new scmItemGroup(ItemGroup.GROUPS.length, "scmtab");
    	private scmItemGroup(int index, String label)
    	{
    		super(index, label);
    	}
    	@Override
    public ItemStack createIcon()
    {
    	return new ItemStack(ItemInit.sapphire);
    }
   }
         
}
