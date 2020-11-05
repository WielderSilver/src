package com.wieldersilver.scmcraft.tools;

import java.util.function.Supplier;

import com.wieldersilver.scmcraft.init.ItemInit;
import com.wieldersilver.scmcraft.tools.toolmaterials.RubyToolMaterial;
import com.wieldersilver.scmcraft.tools.toolmaterials.SCMToolMaterial;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum ModItemTier implements IItemTier
{
	//int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial
	RUBY(2, 175, 6.0F, 2.0F, 14, () -> {
		return Ingredient.fromItems(ItemInit.ruby);
	}, new RubyToolMaterial()),
	SAPPHIRE(2, 175, 6.0F, 2.0F, 14, () -> {
		return Ingredient.fromItems(ItemInit.sapphire);
	}, null),
	AMETHYST(2, 175, 6.0F, 2.0F, 14, () -> {
		return Ingredient.fromItems(ItemInit.amethyst);
	}, null),
	TOPAZ(2, 175, 6.0F, 2.0F, 14, () -> {
		return Ingredient.fromItems(ItemInit.topaz);
	}, null),
	MYTHRIL(0, 32, 10.0F, 0.0F, 22, () -> {
		return Ingredient.fromItems(ItemInit.mythril_shard);
	}, null),
	EMERALD(2, 175, 6.0F, 2.0F, 14, () -> {
		return Ingredient.fromItems(Items.EMERALD);
	}, null),
	;
	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyValue<Ingredient> repairMaterial;
	private final SCMToolMaterial specialFunctionHandler;
	
	
	private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int  enchantability, Supplier<Ingredient> repairMaterial, SCMToolMaterial specialFunctionHandler)
	{
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.enchantability = enchantability;
		this.repairMaterial = new LazyValue<Ingredient>(repairMaterial);
		this.specialFunctionHandler = specialFunctionHandler;
		
	}


	@Override
	public int getMaxUses() 
	{
		return this.maxUses;
	}


	@Override
	public float getEfficiency() 
	{
		return this.efficiency;
	}


	@Override
	public float getAttackDamage() 
	{
		return this.attackDamage;
	}


	@Override
	public int getHarvestLevel() 
	{
		return this.harvestLevel;
	}


	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}


	@Override
	public Ingredient getRepairMaterial() 
	{
		return this.repairMaterial.getValue();
	}
	
	public SCMToolMaterial getSpecialFunctionHandler()
	{
		return this.specialFunctionHandler;
	}
}