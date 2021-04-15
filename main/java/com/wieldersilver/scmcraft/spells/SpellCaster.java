/**
 * 
 */
package com.wieldersilver.scmcraft.spells;

import com.wieldersilver.scmcraft.init.SpellInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author gusjg
 *
 */
public class SpellCaster 
{
	public static void cast(String spellName, World world, ItemStack item, PlayerEntity player)
	{
		//System.out.println(spellName);
		spellName = spellName.toLowerCase();
		switch(spellName)
		{
			case "thunder":
				SpellInit.THUNDER.activate(world, item, player);
				return;
			case "fire":
				SpellInit.FIRE.activate(world, item, player);
				return;
			default:
				return;
		}
	}
	
	/**
	 * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
	 * update it's contents.
	 */
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) 
	{
	}
}
