package com.wieldersilver.scmcraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wieldersilver.scmcraft.gui.GUISpellStation;
import com.wieldersilver.scmcraft.init.BlockInit;
import com.wieldersilver.scmcraft.init.ContainerInit;
import com.wieldersilver.scmcraft.init.ItemInit;
import com.wieldersilver.scmcraft.net.SCMPacketHandler;
import com.wieldersilver.scmcraft.worldgen.OreGeneration;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
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
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "scmcraft";
    
    public static scmcraft instance;
    
    @SuppressWarnings({ "unused", "rawtypes" })
	private static final Class[] classes = new Class[] { BlockInit.class, ItemInit.class, OreGeneration.class };

    public scmcraft() {        
    	instance = this;
    	
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);       
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
        MinecraftForge.EVENT_BUS.register(this);
        
        LOGGER.debug("Woot woot, loading stuff up!");
        
        new SCMPacketHandler();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    }

    @SuppressWarnings("deprecation")
	private void doClientStuff(final FMLClientSetupEvent event) 
    {
    	// Register ContainerType Screens
		// ScreenManager.registerFactory is not safe to call during parallel mod loading so we queue it to run later
		DeferredWorkQueue.runLater(() -> 
		{
			ScreenManager.registerFactory(ContainerInit.SPELL_STATION, GUISpellStation::new);
			LOGGER.debug("Registered ContainerType Screens");
		});
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {
    	
    }
}
