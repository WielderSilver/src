/**
 * 
 */
package com.wieldersilver.scmcraft.spells;

import com.wieldersilver.scmcraft.init.SpellInit;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;

/**
 * @author gusjg
 *
 */
public class Scrawl extends Item {

	public Scrawl(Properties properties) 
	{
		super(properties);
		// TODO Auto-generated constructor stub
	}
	
	public ItemStack makeScrawl(String spell) 
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
			String s = spell.getRegistryName().getPath();
			s = s.substring(0, 1).toUpperCase() + s.substring(1);
			
			items.add(makeScrawl(s));
		}
	}

	@Override
	public int getMaxDamage(ItemStack stack)
	{
		return 1;
	}
}
