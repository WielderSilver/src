package com.wieldersilver.scmcraft.net;

import com.wieldersilver.scmcraft.scmcraft;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class SCMPacketHandler {
	
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel
	(
		new ResourceLocation(scmcraft.MOD_ID, "main"), 
		() -> PROTOCOL_VERSION, 
		PROTOCOL_VERSION::equals, 
		PROTOCOL_VERSION::equals
	);
	public static int index = 0; 
			

	public SCMPacketHandler() 
	{
		INSTANCE.registerMessage(index++, MessageExtendedReachAttack.class, MessageExtendedReachAttack::encode, MessageExtendedReachAttack::new, MessageExtendedReachAttack::handle);
		INSTANCE.registerMessage(index++, MessageSpellCast.class, MessageSpellCast::encode, MessageSpellCast::new, MessageSpellCast::handle);
	}

}
