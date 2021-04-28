package com.wieldersilver.scmcraft.spells;

import javax.annotation.Nullable;

import com.wieldersilver.scmcraft.init.SpellInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

public abstract class Spell extends ForgeRegistryEntry<Spell> 
{
	protected final String name;
	protected final int level;
	protected final int cooldown;
	
	@Nullable
	private String translationKey;
	
	protected Spell(String name, int level, int cooldown)
	{
		this.name = name;
		this.level = level;
		this.cooldown = cooldown;
	}
	
	/**
	 * Specify this for any spell implemented
	 * @param world
	 * @param item
	 * @param player
	 */
	public abstract void activate(World world, ItemStack item, PlayerEntity player);
	
	public String getTranslationKey()
	{
		if(this.translationKey == null)
		{
			this.translationKey = Util.makeTranslationKey("spell", SpellInit.SPELLS.getKey(this));
		}
		
		return translationKey;
	}
}
