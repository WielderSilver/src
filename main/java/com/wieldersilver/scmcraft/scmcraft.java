package com.wieldersilver.scmcraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("scmcraft")
public class scmcraft
{
	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "scmcraft";
    
    public static scmcraft instance;

    public scmcraft() {        
    	instance = this;
    	
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);       
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
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
         
}
