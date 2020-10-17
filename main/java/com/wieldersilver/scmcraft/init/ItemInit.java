package com.wieldersilver.scmcraft.init;

import java.util.function.Supplier;
import net.minecraft.item.Items;

import javax.naming.directory.ModificationItem;

import com.wieldersilver.scmcraft.scmcraft;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = scmcraft.MOD_ID, bus = Bus.MOD)
@ObjectHolder(scmcraft.MOD_ID)
public class ItemInit 
{
	
	public static final Item ruby = null;
	public static final Item topaz = null;
	public static final Item amethyst = null;
	public static final Item sapphire = null;
	public static final Item mythril_shard = null;
	public static final Item pole = null;

	//Tools
	public static final Item ruby_sword = null;
	public static final Item ruby_hoe = null;
	public static final Item ruby_axe = null;
	public static final Item ruby_shovel = null;
	public static final Item ruby_pickaxe = null;
	
	
	
	
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("ruby"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("topaz"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("amethyst"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("sapphire"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("mythril_shard"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("pole"));

		//Tools
		event.getRegistry().register(new SwordItem(ModItemTier.RUBY, 2, 2.0F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_sword"));
		event.getRegistry().register(new AxeItem(ModItemTier.RUBY, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.RUBY, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_hoe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.RUBY, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_shovel"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.RUBY, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_pickaxe"));
		
		event.getRegistry().register(new SwordItem(ModItemTier.SAPPHIRE, 2, 2.0F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_sword"));
		event.getRegistry().register(new AxeItem(ModItemTier.SAPPHIRE, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.SAPPHIRE, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_hoe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.SAPPHIRE, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_shovel"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.SAPPHIRE, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_pickaxe"));

		event.getRegistry().register(new SwordItem(ModItemTier.TOPAZ, 2, 2.0F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_sword"));
		event.getRegistry().register(new AxeItem(ModItemTier.TOPAZ, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.TOPAZ, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_hoe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.TOPAZ, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_shovel"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.TOPAZ, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_pickaxe"));

		event.getRegistry().register(new SwordItem(ModItemTier.AMETHYST, 2, 2.0F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_sword"));
		event.getRegistry().register(new AxeItem(ModItemTier.AMETHYST, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.AMETHYST, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_hoe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.AMETHYST, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_shovel"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.AMETHYST, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_pickaxe"));
		
		event.getRegistry().register(new SwordItem(ModItemTier.EMERALD, 2, 2.0F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_sword"));
		event.getRegistry().register(new AxeItem(ModItemTier.EMERALD, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.EMERALD, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_hoe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.EMERALD, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_shovel"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.EMERALD, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_pickaxe"));
		
		event.getRegistry().register(new SwordItem(ModItemTier.MYTHRIL, 2, 2.0F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_sword"));
		event.getRegistry().register(new AxeItem(ModItemTier.MYTHRIL, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.MYTHRIL, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_hoe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.MYTHRIL, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_shovel"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.MYTHRIL, 2, 2.0F,new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_pickaxe"));

	}
	
	public enum ModItemTier implements IItemTier
	{
		//int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial
		RUBY(2, 191, 6.0F, 2.0F, 14, () -> {
			return Ingredient.fromItems(ItemInit.ruby);
		}),
		SAPPHIRE(2, 191, 6.0F, 2.0F, 14, () -> {
			return Ingredient.fromItems(ItemInit.sapphire);
		}),
		AMETHYST(2, 191, 6.0F, 2.0F, 14, () -> {
			return Ingredient.fromItems(ItemInit.amethyst);
		}),
		TOPAZ(2, 191, 6.0F, 2.0F, 14, () -> {
			return Ingredient.fromItems(ItemInit.topaz);
		}),
		MYTHRIL(0, 32, 10.0F, 0.0F, 22, () -> {
			return Ingredient.fromItems(ItemInit.mythril_shard);
		}),
		EMERALD(2, 191, 6.0F, 2.0F, 14, () -> {
			return Ingredient.fromItems(Items.EMERALD);
		}),
		;
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int  enchantability, Supplier<Ingredient> repairMaterial)
		{
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.attackDamage = attackDamage;
			this.efficiency = efficiency;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<Ingredient>(repairMaterial);
			
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
	}
}
