package com.wieldersilver.scmcraft.net;

import com.wieldersilver.scmcraft.tools.weapons.IExtendedReach;

import java.util.function.Supplier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class MessageExtendedReachAttack {
	
	private final int entityID;

	public MessageExtendedReachAttack(PacketBuffer buf) {
		entityID = buf.readInt();
		// TODO Auto-generated constructor stub
	}
	
	public MessageExtendedReachAttack(int entityID)
	{
		this.entityID = entityID;
	}
	
	public void encode(PacketBuffer buf)
	{
		buf.writeInt(entityID);
	}
	
	public void handle(Supplier<NetworkEvent.Context> context)
	{
		System.out.println("Message received");
		
		ServerPlayerEntity sender = context.get().getSender();
		sender.getServer().deferTask(
			new Runnable()
			{

				@SuppressWarnings("deprecation")
				@Override
				public void run() {
					Entity target = sender.world.getEntityByID(entityID);
					
					//validate entity
					if(target == null)
					{
						return;
					}
					
					//validate entity loadedness
					if(!target.world.isBlockLoaded(target.getPosition()))
					{
						return;
					}
					
					//validate player mainhand item
					Item item = sender.getHeldItemMainhand().getItem();
					if(item == null)
					{
						return;
					}
					
					//Finally to the actual code
					if(item instanceof IExtendedReach)
					{
						IExtendedReach weapon = (IExtendedReach) item;
						
						double distanceSq = sender.getDistanceSq(target);
						double reachSq = weapon.getReach() * weapon.getReach();
						
						if(distanceSq <= reachSq)
						{
							sender.attackTargetEntityWithCurrentItem(target);
						}
					}
				}
				
			}
		);
		
		context.get().setPacketHandled(true);
		
	}
}
