package com.wieldersilver.scmcraft.init;

import com.wieldersilver.scmcraft.scmcraft;
import com.wieldersilver.scmcraft.armor.ModArmorMaterial;
import com.wieldersilver.scmcraft.tools.ModItemTier;
import com.wieldersilver.scmcraft.tools.weapons.GreatswordItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = scmcraft.MOD_ID, bus = Bus.MOD)
@ObjectHolder(scmcraft.MOD_ID)
public class ItemInit 
{
	
	public static final Item ruby = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("ruby");
	public static final Item topaz = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("topaz");
	public static final Item amethyst = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("amethyst");
	public static final Item sapphire = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("sapphire");
	public static final Item mythril_shard = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("mythril_shard");
	public static final Item pole = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("pole");

	//Tools
	public static final Item ruby_sword = new SwordItem(ModItemTier.RUBY, 4, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_sword");
	public static final Item ruby_hoe = new HoeItem(ModItemTier.RUBY, -1.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("ruby_hoe");
	public static final Item ruby_axe = new AxeItem(ModItemTier.RUBY, 7, -3.1F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("ruby_axe");
	public static final Item ruby_shovel = new ShovelItem(ModItemTier.RUBY, 2.5F, -3.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("ruby_shovel");
	public static final Item ruby_pickaxe = new PickaxeItem(ModItemTier.RUBY, 2, -2.8F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("ruby_pickaxe");
	public static final Item ruby_greatsword = new GreatswordItem(ModItemTier.RUBY, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_greatsword");

	
	//Armor
	public static final Item ruby_helmet = new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_helmet");
	public static final Item ruby_chestplate = new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_chestplate");
	public static final Item ruby_leggings = new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_leggings");
	public static final Item ruby_boots = new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_boots");
	
	//Tools
	public static final Item topaz_sword = new SwordItem(ModItemTier.TOPAZ, 4, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_sword");
	public static final Item topaz_hoe = new HoeItem(ModItemTier.TOPAZ, -1.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("topaz_hoe");
	public static final Item topaz_axe = new AxeItem(ModItemTier.TOPAZ, 7, -3.1F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("topaz_axe");
	public static final Item topaz_shovel = new ShovelItem(ModItemTier.TOPAZ, 2.5F, -3.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("topaz_shovel");
	public static final Item topaz_pickaxe = new PickaxeItem(ModItemTier.TOPAZ, 2, -2.8F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("topaz_pickaxe");
	public static final Item topaz_greatsword = new GreatswordItem(ModItemTier.TOPAZ, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_greatsword");

	//Armor
	public static final Item topaz_helmet = new ArmorItem(ModArmorMaterial.TOPAZ, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_helmet");
	public static final Item topaz_chestplate = new ArmorItem(ModArmorMaterial.TOPAZ, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_chestplate");
	public static final Item topaz_leggings = new ArmorItem(ModArmorMaterial.TOPAZ, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_leggings");
	public static final Item topaz_boots = new ArmorItem(ModArmorMaterial.TOPAZ, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_boots");
	
	//Tools
	public static final Item amethyst_sword = new SwordItem(ModItemTier.AMETHYST, 4, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_sword");
	public static final Item amethyst_hoe = new HoeItem(ModItemTier.AMETHYST, -1.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("amethyst_hoe");
	public static final Item amethyst_axe = new AxeItem(ModItemTier.AMETHYST, 7, -3.1F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("amethyst_axe");
	public static final Item amethyst_shovel = new ShovelItem(ModItemTier.AMETHYST, 2.5F, -3.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("amethyst_shovel");
	public static final Item amethyst_pickaxe = new PickaxeItem(ModItemTier.AMETHYST, 2, -2.8F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("amethyst_pickaxe");
	public static final Item amethyst_greatsword = new GreatswordItem(ModItemTier.AMETHYST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_greatsword");

	//Armor
	public static final Item amethyst_helmet = new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_helmet");
	public static final Item amethyst_chestplate = new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_chestplate");
	public static final Item amethyst_leggings = new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_leggings");
	public static final Item amethyst_boots = new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_boots");

	//Tools
	public static final Item sapphire_sword = new SwordItem(ModItemTier.SAPPHIRE, 4, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_sword");
	public static final Item sapphire_hoe = new HoeItem(ModItemTier.SAPPHIRE, -1.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("sapphire_hoe");
	public static final Item sapphire_axe = new AxeItem(ModItemTier.SAPPHIRE, 7, -3.1F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("sapphire_axe");
	public static final Item sapphire_shovel = new ShovelItem(ModItemTier.SAPPHIRE, 2.5F, -3.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("sapphire_shovel");
	public static final Item sapphire_pickaxe = new PickaxeItem(ModItemTier.SAPPHIRE, 2, -2.8F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("sapphire_pickaxe");
	public static final Item sapphire_greatsword = new GreatswordItem(ModItemTier.SAPPHIRE, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_greatsword");

	//Armor
	public static final Item sapphire_helmet = new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_helmet");
	public static final Item sapphire_chestplate = new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_chestplate");
	public static final Item sapphire_leggings = new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_leggings");
	public static final Item sapphire_boots = new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_boots");

	//Tools
	public static final Item emerald_sword = new SwordItem(ModItemTier.EMERALD, 4, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_sword");
	public static final Item emerald_hoe = new HoeItem(ModItemTier.EMERALD, -1.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("emerald_hoe");
	public static final Item emerald_axe = new AxeItem(ModItemTier.EMERALD, 7, -3.1F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("emerald_axe");
	public static final Item emerald_shovel = new ShovelItem(ModItemTier.EMERALD, 2.5F, -3.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("emerald_shovel");
	public static final Item emerald_pickaxe = new PickaxeItem(ModItemTier.EMERALD, 2, -2.8F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("emerald_pickaxe");
	public static final Item emerald_greatsword = new GreatswordItem(ModItemTier.EMERALD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_greatsword");

	//Armor
	public static final Item emerald_helmet = new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_helmet");
	public static final Item emerald_chestplate = new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_chestplate");
	public static final Item emerald_leggings = new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_leggings");
	public static final Item emerald_boots = new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_boots");

	//Tools
	public static final Item mythril_sword = new SwordItem(ModItemTier.MYTHRIL, 4, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_sword");
	public static final Item mythril_hoe = new HoeItem(ModItemTier.MYTHRIL, -1.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mythril_hoe");
	public static final Item mythril_axe = new AxeItem(ModItemTier.MYTHRIL, 7, -3.1F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mythril_axe");
	public static final Item mythril_shovel = new ShovelItem(ModItemTier.MYTHRIL, 2.5F, -3.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mythril_shovel");
	public static final Item mythril_pickaxe = new PickaxeItem(ModItemTier.MYTHRIL, 2, -2.8F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mythril_pickaxe");
	public static final Item mythril_greatsword = new GreatswordItem(ModItemTier.MYTHRIL, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_greatsword");

	//Armor
	public static final Item mythril_helmet = new ArmorItem(ModArmorMaterial.MYTHRIL, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_helmet");
	public static final Item mythril_chestplate = new ArmorItem(ModArmorMaterial.MYTHRIL, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_chestplate");
	public static final Item mythril_leggings = new ArmorItem(ModArmorMaterial.MYTHRIL, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_leggings");
	public static final Item mythril_boots = new ArmorItem(ModArmorMaterial.MYTHRIL, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_boots");

	//Tools
	public static final Item gold_greatsword = new GreatswordItem(ItemTier.GOLD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("gold_greatsword");
	public static final Item diamond_greatsword = new GreatswordItem(ItemTier.DIAMOND, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("diamond_greatsword");
	public static final Item iron_greatsword = new GreatswordItem(ItemTier.IRON, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("iron_greatsword");

	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		//Materials
		event.getRegistry().register(ruby);
		event.getRegistry().register(sapphire);
		event.getRegistry().register(topaz);
		event.getRegistry().register(amethyst);
		event.getRegistry().register(mythril_shard);
		event.getRegistry().register(pole);

		event.getRegistry().register(ruby_sword);
		event.getRegistry().register(sapphire_sword);
		event.getRegistry().register(emerald_sword);
		event.getRegistry().register(topaz_sword);
		event.getRegistry().register(amethyst_sword);
		event.getRegistry().register(mythril_sword);
		
		event.getRegistry().register(ruby_greatsword);
		event.getRegistry().register(topaz_greatsword);
		event.getRegistry().register(sapphire_greatsword);
		event.getRegistry().register(amethyst_greatsword);
		event.getRegistry().register(emerald_greatsword);
		event.getRegistry().register(iron_greatsword);
		event.getRegistry().register(diamond_greatsword);
		event.getRegistry().register(gold_greatsword);
		
		event.getRegistry().register(ruby_helmet);
		event.getRegistry().register(ruby_chestplate);
		event.getRegistry().register(ruby_leggings);
		event.getRegistry().register(ruby_boots);
		
		event.getRegistry().register(sapphire_helmet);
		event.getRegistry().register(sapphire_chestplate);
		event.getRegistry().register(sapphire_leggings);
		event.getRegistry().register(sapphire_boots);
		
		event.getRegistry().register(emerald_helmet);
		event.getRegistry().register(emerald_chestplate);
		event.getRegistry().register(emerald_leggings);
		event.getRegistry().register(emerald_boots);
		
		event.getRegistry().register(topaz_helmet);
		event.getRegistry().register(topaz_chestplate);
		event.getRegistry().register(topaz_leggings);
		event.getRegistry().register(topaz_boots);
		
		event.getRegistry().register(amethyst_helmet);
		event.getRegistry().register(amethyst_chestplate);
		event.getRegistry().register(amethyst_leggings);
		event.getRegistry().register(amethyst_boots);
		
		event.getRegistry().register(mythril_helmet);
		event.getRegistry().register(mythril_chestplate);
		event.getRegistry().register(mythril_leggings);
		event.getRegistry().register(mythril_boots);
		
		event.getRegistry().register(ruby_shovel);
		event.getRegistry().register(ruby_pickaxe);
		event.getRegistry().register(ruby_axe);
		
		event.getRegistry().register(sapphire_shovel);
		event.getRegistry().register(sapphire_pickaxe);
		event.getRegistry().register(sapphire_axe);
		
		event.getRegistry().register(emerald_shovel);
		event.getRegistry().register(emerald_pickaxe);
		event.getRegistry().register(emerald_axe);
		
		event.getRegistry().register(topaz_shovel);
		event.getRegistry().register(topaz_pickaxe);
		event.getRegistry().register(topaz_axe);
		
		event.getRegistry().register(amethyst_shovel);
		event.getRegistry().register(amethyst_pickaxe);
		event.getRegistry().register(amethyst_axe);
		
		event.getRegistry().register(mythril_shovel);
		event.getRegistry().register(mythril_pickaxe);
		event.getRegistry().register(mythril_axe);
		
		event.getRegistry().register(ruby_hoe);
		event.getRegistry().register(sapphire_hoe);
		event.getRegistry().register(emerald_hoe);
		event.getRegistry().register(topaz_hoe);
		event.getRegistry().register(amethyst_hoe);
		event.getRegistry().register(mythril_hoe);
	}
}
