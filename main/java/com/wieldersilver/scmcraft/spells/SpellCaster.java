/**
 * 
 */
package com.wieldersilver.scmcraft.spells;

import com.wieldersilver.scmcraft.scmcraft;
import com.wieldersilver.scmcraft.init.SpellInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
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
		
		ResourceLocation resource;
		if(spellName.contains(":"))
		{
			resource = new ResourceLocation(spellName);
		}
		else
		{
			resource = new ResourceLocation(scmcraft.MOD_ID, spellName);
		}
		if(SpellInit.SPELLS.containsKey(resource))
		{
			SpellInit.SPELLS.getValue(resource).activate(world, item, player);
		}
		/*
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
		}*/
	}
}
