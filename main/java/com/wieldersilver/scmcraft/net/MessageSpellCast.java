package com.wieldersilver.scmcraft.net;

import java.util.function.Supplier;

import com.wieldersilver.scmcraft.spells.SpellCaster;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

public class MessageSpellCast {
	
	private final int button;

	public MessageSpellCast(PacketBuffer buf) {
		button = buf.readInt();
		// TODO Auto-generated constructor stub
	}
	
	public MessageSpellCast(int entityID)
	{
		this.button = entityID;
	}
	
	public void encode(PacketBuffer buf)
	{
		buf.writeInt(button);
	}
	
	public void handle(Supplier<NetworkEvent.Context> context)
	{
		System.out.println("Message received");
		
		ServerPlayerEntity sender = context.get().getSender();
		sender.getServer().deferTask(
			new Runnable()
			{

				@Override
				public void run() {
					ItemStack stack = sender.getHeldItemMainhand();
					
					CompoundNBT nbt;
				    if (stack.hasTag())
				    {
				        nbt = stack.getTag();
				    }
				    else
				    {
				        return;
				    }
				    
				    //only cast if verified
				    if(nbt.contains("SCM_spell_" + button))
				    {
				    	String spellName = nbt.get("SCM_spell_" + button).getString();
				    	World world = sender.getEntityWorld();
				    	SpellCaster.cast(spellName, world, stack, sender);
				    }
				}
				
			}
		);
		
		context.get().setPacketHandled(true);
		
	}
}
