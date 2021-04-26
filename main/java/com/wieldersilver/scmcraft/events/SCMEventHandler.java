package com.wieldersilver.scmcraft.events;

import com.wieldersilver.scmcraft.scmcraft;
import com.wieldersilver.scmcraft.init.ItemInit;
import com.wieldersilver.scmcraft.net.MessageExtendedReachAttack;
import com.wieldersilver.scmcraft.net.MessageSpellCast;
import com.wieldersilver.scmcraft.net.SCMPacketHandler;
import com.wieldersilver.scmcraft.spells.SpellCaster;
import com.wieldersilver.scmcraft.tools.weapons.IExtendedReach;
import com.wieldersilver.scmcraft.util.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent.ClickInputEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = scmcraft.MOD_ID, bus = Bus.FORGE)
public class SCMEventHandler {

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public static void extendedReachEvent(ClickInputEvent event)
	{
		//scmcraft.LOGGER.debug("Caught click event");
		if(event.isAttack())
		{
			Minecraft mc = Minecraft.getInstance();
			PlayerEntity player = mc.player;
			
			//player validation
			if(player == null)
			{
				return;
			}
			
			Item item = player.getHeldItemMainhand().getItem();
			
			//item validation
			if(item == null)
			{
				return;
			}
			
			if(item instanceof IExtendedReach)
			{
				float reach = ((IExtendedReach)item).getReach();
				
				LivingEntity target = Utils.getExtendedRangeTarget(reach);
				if(target != null && target.hurtResistantTime == 0 && target != player)
				{
					SCMPacketHandler.INSTANCE.sendToServer(new MessageExtendedReachAttack(target.getEntityId()));
					//item.hitEntity(player.getActiveItemStack(), target, player);
					//target.hitByEntity(player);
					player.attackTargetEntityWithCurrentItem(target);
					
					System.out.println("Extended Reach hit");
				}
				
				event.setCanceled(true);
			}
		}
	}
	
	/**
	 * This is called for casting spells.
	 * If the player "left clicks" (attacks), it'll cast the spell
	 * specified by nbt value SCM_spell_0
	 * right click corresponds to SCM_spell_1
	 * middle click corresponds to SCM_spell_2
	 * @param event
	 */
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public static void spellCastEvent(ClickInputEvent event)
	{
		int button;
		if(event.isAttack())
		{
			button = 0;
		}
		else if(event.isUseItem())
		{
			button = 1;
		}
		else
		{
			button = 2;
		}
		
		Minecraft mc = Minecraft.getInstance();
		PlayerEntity player = mc.player;
		
		//player validation
		if(player == null)
		{
			return;
		}
		
		ItemStack stack = player.getHeldItemMainhand();
		
		CompoundNBT nbt;
	    if (stack.hasTag())
	    {
	        nbt = stack.getTag();
	    }
	    else
	    {
	        return;
	    }
	    
	    if(nbt.contains("SCM_spell_" + button))
	    {
	    	String spellName = nbt.get("SCM_spell_" + button).getString();
	    	World world = player.getEntityWorld();
	    	SpellCaster.cast(spellName, world, stack, player);
	    	if(stack.getItem() == ItemInit.scrawl)
	    	{
		    	stack.damageItem(1, player, (p_220045_0_) -> {
			         p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
			      });
	    	}
	    	//System.out.println("boop");
	    	SCMPacketHandler.INSTANCE.sendToServer(new MessageSpellCast(button));
	    }
	}
	
	
	/**
	 * This shows the players what spells are on their current item
	 * @param event
	 */
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public static void spellToolTipEvent(ItemTooltipEvent event)
	{
		ItemStack stack = event.getItemStack();
		
		CompoundNBT nbt;
	    if (stack.hasTag())
	    {
	        nbt = stack.getTag();
	    }
	    else
	    {
	        return;
	    }
	    
	    if(nbt.contains("SCM_spell_0"))
	    {
	    	StringTextComponent tooltip = new StringTextComponent("Spell Slot 1: " + nbt.getString("SCM_spell_0"));
	    	event.getToolTip().add(tooltip);
	    }
	    
	    if(nbt.contains("SCM_spell_1"))
	    {
	    	StringTextComponent tooltip = new StringTextComponent("Spell Slot 2: " + nbt.getString("SCM_spell_1"));
	    	event.getToolTip().add(tooltip);
	    }
	    
	    if(nbt.contains("SCM_spell_2"))
	    {
	    	StringTextComponent tooltip = new StringTextComponent("Spell Slot 3: " + nbt.getString("SCM_spell_2"));
	    	event.getToolTip().add(tooltip);
	    }
	}
}
