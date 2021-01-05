package com.wieldersilver.scmcraft.spells;

import com.wieldersilver.scmcraft.init.SpellInit;
import com.wieldersilver.scmcraft.tools.ModItemTier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;

public class Tome extends Item 
{
	private Spell spell = SpellInit.THUNDER;
	
	public Tome(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	
	
	public ActionResultType onItemUse(ItemUseContext context)
	{
	   spell.activate(context.getWorld(), context.getItem(), context.getPlayer());
		
		return ActionResultType.SUCCESS;
	}
}
