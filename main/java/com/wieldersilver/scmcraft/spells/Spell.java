package com.wieldersilver.scmcraft.spells;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

public abstract class Spell extends ForgeRegistryEntry<Spell> 
{
	protected final String name;
	protected final int level;
	protected final int cooldown;
	
	protected Spell(String name, int level, int cooldown)
	{
		this.name = name;
		this.level = level;
		this.cooldown = cooldown;
	}
	
	public abstract void activate(World world, ItemStack item, PlayerEntity player);
}
