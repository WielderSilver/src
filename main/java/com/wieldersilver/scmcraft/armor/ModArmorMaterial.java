package com.wieldersilver.scmcraft.armor;

import java.util.function.Supplier;

import com.wieldersilver.scmcraft.scmcraft;
import com.wieldersilver.scmcraft.init.ItemInit;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum ModArmorMaterial implements IArmorMaterial
{
	RUBY(scmcraft.MOD_ID + ":ruby",5, new int[] {2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0F, () ->  {
		return Ingredient.fromItems(ItemInit.ruby);
	}),
	SAPPHIRE(scmcraft.MOD_ID + ":sapphire",5, new int[] {2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0F, () ->  {
		return Ingredient.fromItems(ItemInit.sapphire);
	}),
	TOPAZ(scmcraft.MOD_ID + ":topaz",5, new int[] {2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0F, () ->  {
		return Ingredient.fromItems(ItemInit.topaz);
	}),
	AMETHYST(scmcraft.MOD_ID + ":amethyst",5, new int[] {2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0F, () ->  {
		return Ingredient.fromItems(ItemInit.sapphire);
	}),
	EMERALD(scmcraft.MOD_ID + ":emerald",5, new int[] {2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0F, () ->  {
		return Ingredient.fromItems(ItemInit.sapphire);
	}),
	MYTHRIL(scmcraft.MOD_ID + ":mythril",5, new int[] {2, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0F, () ->  {
		return Ingredient.fromItems(ItemInit.mythril_shard);
	});
	
	;
	
	
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[] {16, 16, 16, 16 };
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final LazyValue<Ingredient> repairMaterial;
	
	private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn,float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
		this.name = nameIn;
		this.maxDamageFactor = maxDamageFactorIn;
		this.damageReductionAmountArray = damageReductionAmountIn;
		this.enchantability = enchantabilityIn;
		this.soundEvent = soundEventIn;
		this.toughness = toughnessIn;
		this.repairMaterial = new LazyValue<>(repairMaterialIn);
	}

	@Override
	public int getDurability(EquipmentSlotType slotIn) 
	{
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) 
	{
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return this.soundEvent;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return this.repairMaterial.getValue();
	}

	@Override
	public String getName() 
	{
		return this.name;
	}

	@Override
	public float getToughness() 
	{
		return this.toughness;
	}
}