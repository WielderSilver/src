package com.wieldersilver.scmcraft.spells;

import com.wieldersilver.scmcraft.init.SpellInit;
import com.wieldersilver.scmcraft.tools.ModItemTier;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Tome extends Item 
{
	public Tome(Properties properties) 
	{
		super(properties);
		// TODO Auto-generated constructor stub
	}
	
	public ItemStack makeTome(String spell) 
	{
		ItemStack stack = new ItemStack(this);
		CompoundNBT nbt = stack.getOrCreateTag();

		nbt.putString("SCM_spell_0", spell);
		nbt.putString("SCM_spell_1", spell);
		nbt.putString("SCM_spell_2", spell);
		
		stack.setTag(nbt);
		
		return stack;
	}
}
