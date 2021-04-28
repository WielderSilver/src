package com.wieldersilver.scmcraft.spells;

import com.wieldersilver.scmcraft.init.SpellInit;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;

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
	
	@Override
	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items)
	{
		if(!this.isInGroup(group))
		{
			return;
		}
		
		for(Spell spell : SpellInit.SPELLS)
		{
			String s = spell.getRegistryName().toString();
			items.add(makeTome(s));
		}
	}
}
