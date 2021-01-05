package com.wieldersilver.scmcraft.init;

import com.wieldersilver.scmcraft.scmcraft;
import com.wieldersilver.scmcraft.armor.ModArmorMaterial;
import com.wieldersilver.scmcraft.armor.RubyArmorItem;
import com.wieldersilver.scmcraft.tools.ModItemTier;
import com.wieldersilver.scmcraft.tools.SCMAxeItem;
import com.wieldersilver.scmcraft.tools.SCMHoeItem;
import com.wieldersilver.scmcraft.tools.SCMPickaxeItem;
import com.wieldersilver.scmcraft.tools.SCMShovelItem;
import com.wieldersilver.scmcraft.tools.weapons.DaggerItem;
import com.wieldersilver.scmcraft.tools.weapons.GreatswordItem;
import com.wieldersilver.scmcraft.tools.weapons.LanceItem;
import com.wieldersilver.scmcraft.tools.weapons.NunchuckItem;
import com.wieldersilver.scmcraft.tools.weapons.RapierItem;
import com.wieldersilver.scmcraft.tools.weapons.SCMSwordItem;
import com.wieldersilver.scmcraft.tools.weapons.StoneGreatswordItem;
import com.wieldersilver.scmcraft.tools.weapons.keyblades.KingdomKeyDItem;
import com.wieldersilver.scmcraft.tools.weapons.keyblades.KingdomKeyItem;
import com.wieldersilver.scmcraft.tools.weapons.keyblades.LadyLuckItem;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
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
	
	public static final Item scrawl = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("scrawl");
	public static final Item tome = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("tome");


	//Tools
	public static final Item ruby_sword = new SCMSwordItem(ModItemTier.RUBY, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_sword");
	public static final Item ruby_hoe = new SCMHoeItem(ModItemTier.RUBY, -1.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("ruby_hoe");
	public static final Item ruby_axe = new SCMAxeItem(ModItemTier.RUBY, 6, -3.1F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("ruby_axe");
	public static final Item ruby_shovel = new SCMShovelItem(ModItemTier.RUBY, 1.5F, -3.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("ruby_shovel");
	public static final Item ruby_pickaxe = new SCMPickaxeItem(ModItemTier.RUBY, 1, -2.8F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("ruby_pickaxe");
	public static final Item ruby_greatsword = new GreatswordItem(ModItemTier.RUBY, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_greatsword");
	public static final Item ruby_rapier = new RapierItem(ModItemTier.RUBY, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_rapier");
	public static final Item ruby_dagger = new DaggerItem(ModItemTier.RUBY, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_dagger");
	public static final Item ruby_lance = new LanceItem(ModItemTier.RUBY, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_lance");
	public static final Item ruby_nunchucks = new NunchuckItem(ModItemTier.RUBY, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_nunchucks");

	
	//Armor
	public static final Item ruby_helmet = new RubyArmorItem(EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_helmet");
	public static final Item ruby_chestplate = new RubyArmorItem(EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_chestplate");
	public static final Item ruby_leggings = new RubyArmorItem(EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_leggings");
	public static final Item ruby_boots = new RubyArmorItem(EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("ruby_boots");
	
	//Tools
	public static final Item topaz_sword = new SCMSwordItem(ModItemTier.TOPAZ, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_sword");
	public static final Item topaz_hoe = new SCMHoeItem(ModItemTier.TOPAZ, -1.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("topaz_hoe");
	public static final Item topaz_axe = new SCMAxeItem(ModItemTier.TOPAZ, 6, -3.1F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("topaz_axe");
	public static final Item topaz_shovel = new SCMShovelItem(ModItemTier.TOPAZ, 1.5F, -3.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("topaz_shovel");
	public static final Item topaz_pickaxe = new SCMPickaxeItem(ModItemTier.TOPAZ, 1, -2.8F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("topaz_pickaxe");
	public static final Item topaz_greatsword = new GreatswordItem(ModItemTier.TOPAZ, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_greatsword");
	public static final Item topaz_rapier = new RapierItem(ModItemTier.TOPAZ, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_rapier");
	public static final Item topaz_dagger = new DaggerItem(ModItemTier.TOPAZ, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_dagger");
	public static final Item topaz_lance = new LanceItem(ModItemTier.TOPAZ, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_lance");
	public static final Item topaz_nunchucks = new NunchuckItem(ModItemTier.EMERALD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_nunchucks");

	//Armor
	public static final Item topaz_helmet = new ArmorItem(ModArmorMaterial.TOPAZ, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_helmet");
	public static final Item topaz_chestplate = new ArmorItem(ModArmorMaterial.TOPAZ, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_chestplate");
	public static final Item topaz_leggings = new ArmorItem(ModArmorMaterial.TOPAZ, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_leggings");
	public static final Item topaz_boots = new ArmorItem(ModArmorMaterial.TOPAZ, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("topaz_boots");
	
	//Tools
	public static final Item amethyst_sword = new SCMSwordItem(ModItemTier.AMETHYST, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_sword");
	public static final Item amethyst_hoe = new SCMHoeItem(ModItemTier.AMETHYST, -1.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("amethyst_hoe");
	public static final Item amethyst_axe = new SCMAxeItem(ModItemTier.AMETHYST, 6, -3.1F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("amethyst_axe");
	public static final Item amethyst_shovel = new SCMShovelItem(ModItemTier.AMETHYST, 1.5F, -3.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("amethyst_shovel");
	public static final Item amethyst_pickaxe = new SCMPickaxeItem(ModItemTier.AMETHYST, 1, -2.8F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("amethyst_pickaxe");
	public static final Item amethyst_greatsword = new GreatswordItem(ModItemTier.AMETHYST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_greatsword");
	public static final Item amethyst_rapier = new RapierItem(ModItemTier.AMETHYST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_rapier");
	public static final Item amethyst_dagger = new DaggerItem(ModItemTier.AMETHYST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_dagger");
	public static final Item amethyst_lance = new LanceItem(ModItemTier.AMETHYST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_lance");
	public static final Item amethyst_nunchucks = new NunchuckItem(ModItemTier.AMETHYST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_nunchucks");


	//Armor
	public static final Item amethyst_helmet = new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_helmet");
	public static final Item amethyst_chestplate = new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_chestplate");
	public static final Item amethyst_leggings = new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_leggings");
	public static final Item amethyst_boots = new ArmorItem(ModArmorMaterial.AMETHYST, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("amethyst_boots");

	//Tools
	public static final Item sapphire_sword = new SCMSwordItem(ModItemTier.SAPPHIRE, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_sword");
	public static final Item sapphire_hoe = new SCMHoeItem(ModItemTier.SAPPHIRE, -1.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("sapphire_hoe");
	public static final Item sapphire_axe = new SCMAxeItem(ModItemTier.SAPPHIRE, 6, -3.1F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("sapphire_axe");
	public static final Item sapphire_shovel = new SCMShovelItem(ModItemTier.SAPPHIRE, 1.5F, -3.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("sapphire_shovel");
	public static final Item sapphire_pickaxe = new SCMPickaxeItem(ModItemTier.SAPPHIRE, 1, -2.8F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("sapphire_pickaxe");
	public static final Item sapphire_greatsword = new GreatswordItem(ModItemTier.SAPPHIRE, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_greatsword");
	public static final Item sapphire_rapier = new RapierItem(ModItemTier.SAPPHIRE, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_rapier");
	public static final Item sapphire_dagger = new DaggerItem(ModItemTier.SAPPHIRE, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_dagger");
	public static final Item sapphire_lance = new LanceItem(ModItemTier.SAPPHIRE, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_lance");
	public static final Item sapphire_nunchucks = new NunchuckItem(ModItemTier.SAPPHIRE, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_nunchucks");

	//Armor
	public static final Item sapphire_helmet = new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_helmet");
	public static final Item sapphire_chestplate = new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_chestplate");
	public static final Item sapphire_leggings = new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_leggings");
	public static final Item sapphire_boots = new ArmorItem(ModArmorMaterial.SAPPHIRE, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("sapphire_boots");

	//Tools
	public static final Item emerald_sword = new SCMSwordItem(ModItemTier.EMERALD, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_sword");
	public static final Item emerald_hoe = new SCMHoeItem(ModItemTier.EMERALD, -1.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("emerald_hoe");
	public static final Item emerald_axe = new SCMAxeItem(ModItemTier.EMERALD, 6, -3.1F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("emerald_axe");
	public static final Item emerald_shovel = new SCMShovelItem(ModItemTier.EMERALD, 1.5F, -3.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("emerald_shovel");
	public static final Item emerald_pickaxe = new SCMPickaxeItem(ModItemTier.EMERALD, 1, -2.8F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("emerald_pickaxe");
	public static final Item emerald_greatsword = new GreatswordItem(ModItemTier.EMERALD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_greatsword");
	public static final Item emerald_rapier = new RapierItem(ModItemTier.EMERALD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_rapier");
	public static final Item emerald_dagger = new DaggerItem(ModItemTier.EMERALD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_dagger");
	public static final Item emerald_lance = new LanceItem(ModItemTier.EMERALD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_lance");
	public static final Item emerald_nunchucks = new NunchuckItem(ModItemTier.EMERALD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_nunchucks");

	//Armor
	public static final Item emerald_helmet = new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_helmet");
	public static final Item emerald_chestplate = new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_chestplate");
	public static final Item emerald_leggings = new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_leggings");
	public static final Item emerald_boots = new ArmorItem(ModArmorMaterial.EMERALD, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("emerald_boots");

	//Tools
	public static final Item mythril_sword = new SCMSwordItem(ModItemTier.MYTHRIL, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_sword");
	public static final Item mythril_hoe = new SCMHoeItem(ModItemTier.MYTHRIL, -1.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mythril_hoe");
	public static final Item mythril_axe = new SCMAxeItem(ModItemTier.MYTHRIL, 6, -3.1F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mythril_axe");
	public static final Item mythril_shovel = new SCMShovelItem(ModItemTier.MYTHRIL, 1.5F, -3.0F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mythril_shovel");
	public static final Item mythril_pickaxe = new SCMPickaxeItem(ModItemTier.MYTHRIL, 1, -2.8F,new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName("mythril_pickaxe");
	public static final Item mythril_greatsword = new GreatswordItem(ModItemTier.MYTHRIL, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_greatsword");
	public static final Item mythril_rapier = new RapierItem(ModItemTier.MYTHRIL, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_rapier");
	public static final Item mythril_dagger = new DaggerItem(ModItemTier.MYTHRIL, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_dagger");
	public static final Item mythril_lance = new LanceItem(ModItemTier.MYTHRIL, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_lance");
	public static final Item mythril_nunchucks = new NunchuckItem(ModItemTier.MYTHRIL, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_nunchucks");

	//Armor
	public static final Item mythril_helmet = new ArmorItem(ModArmorMaterial.MYTHRIL, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_helmet");
	public static final Item mythril_chestplate = new ArmorItem(ModArmorMaterial.MYTHRIL, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_chestplate");
	public static final Item mythril_leggings = new ArmorItem(ModArmorMaterial.MYTHRIL, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_leggings");
	public static final Item mythril_boots = new ArmorItem(ModArmorMaterial.MYTHRIL, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("mythril_boots");

	//Tools
	public static final Item gold_greatsword = new GreatswordItem(ItemTier.GOLD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("gold_greatsword");
	public static final Item diamond_greatsword = new GreatswordItem(ItemTier.DIAMOND, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("diamond_greatsword");
	public static final Item iron_greatsword = new GreatswordItem(ItemTier.IRON, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("iron_greatsword");
	public static final Item stone_greatsword = new StoneGreatswordItem(ItemTier.STONE, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("stone_greatsword");
	public static final Item wooden_greatsword = new GreatswordItem(ItemTier.WOOD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("wood_greatsword");
	
	public static final Item gold_rapier = new GreatswordItem(ItemTier.GOLD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("gold_rapier");
	public static final Item diamond_rapier = new GreatswordItem(ItemTier.DIAMOND, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("diamond_rapier");
	public static final Item iron_rapier = new GreatswordItem(ItemTier.IRON, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("iron_rapier");
	public static final Item stone_rapier = new StoneGreatswordItem(ItemTier.STONE, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("stone_rapier");
	public static final Item wooden_rapier = new GreatswordItem(ItemTier.WOOD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("wood_rapier");

	//Keyblades
	public static final Item kingdom_key = new KingdomKeyItem(ItemTier.IRON, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("kingdom_key");
	public static final Item kingdom_key_hilt = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("kingdom_key_hilt");
	public static final Item kingdom_key_blade = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("kingdom_key_blade");
	public static final Item kingdom_key_point = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("kingdom_key_point");

	public static final Item kingdom_key_d = new KingdomKeyDItem(ItemTier.IRON, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("kingdom_key_d");
	public static final Item kingdom_key_d_hilt = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("kingdom_key_d_hilt");
	public static final Item kingdom_key_d_blade = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("kingdom_key_d_blade");
	public static final Item kingdom_key_d_point = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("kingdom_key_d_point");
	
	public static final Item lady_luck = new LadyLuckItem(ItemTier.IRON, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("lady_luck");
	public static final Item lady_luck_hilt = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("lady_luck_hilt");
	public static final Item lady_luck_blade = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("lady_luck_blade");
	public static final Item lady_luck_point = new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("lady_luck_point");
	
	//Tools
	public static final Item gold_dagger = new DaggerItem(ItemTier.GOLD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("gold_dagger");
	public static final Item diamond_dagger = new DaggerItem(ItemTier.DIAMOND, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("diamond_dagger");
	public static final Item iron_dagger = new DaggerItem(ItemTier.IRON, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("iron_dagger");
	public static final Item stone_dagger = new DaggerItem(ItemTier.STONE, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("stone_dagger");
	public static final Item wooden_dagger = new DaggerItem(ItemTier.WOOD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("wood_dagger");
	
	public static final Item gold_lance = new LanceItem(ItemTier.GOLD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("gold_lance");
	public static final Item diamond_lance = new LanceItem(ItemTier.DIAMOND, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("diamond_lance");
	public static final Item iron_lance = new LanceItem(ItemTier.IRON, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("iron_lance");
	public static final Item stone_lance = new LanceItem(ItemTier.STONE, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("stone_lance");
	public static final Item wooden_lance = new LanceItem(ItemTier.WOOD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("wood_lance");
	
	public static final Item gold_nunchucks = new NunchuckItem(ItemTier.GOLD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("gold_nunchucks");
	public static final Item diamond_nunchucks = new NunchuckItem(ItemTier.DIAMOND, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("diamond_nunchucks");
	public static final Item iron_nunchucks = new NunchuckItem(ItemTier.IRON, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("iron_nunchucks");
	public static final Item stone_nunchucks = new NunchuckItem(ItemTier.STONE, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("stone_nunchucks");
	public static final Item wooden_nunchucks = new NunchuckItem(ItemTier.WOOD, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("wood_nunchucks");


	
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
		event.getRegistry().register(tome);
		event.getRegistry().register(scrawl);

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
		event.getRegistry().register(mythril_greatsword);
		event.getRegistry().register(iron_greatsword);
		event.getRegistry().register(diamond_greatsword);
		event.getRegistry().register(gold_greatsword);
		event.getRegistry().register(stone_greatsword);
		event.getRegistry().register(wooden_greatsword);
		
		event.getRegistry().register(ruby_rapier);
		event.getRegistry().register(topaz_rapier);
		event.getRegistry().register(sapphire_rapier);
		event.getRegistry().register(amethyst_rapier);
		event.getRegistry().register(emerald_rapier);
		event.getRegistry().register(mythril_rapier);
		event.getRegistry().register(iron_rapier);
		event.getRegistry().register(diamond_rapier);
		event.getRegistry().register(gold_rapier);
		event.getRegistry().register(stone_rapier);
		event.getRegistry().register(wooden_rapier);

		
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
		
		event.getRegistry().register(kingdom_key);
		event.getRegistry().register(kingdom_key_hilt);
		event.getRegistry().register(kingdom_key_blade);
		event.getRegistry().register(kingdom_key_point);
		
		event.getRegistry().register(kingdom_key_d);
		event.getRegistry().register(kingdom_key_d_hilt);
		event.getRegistry().register(kingdom_key_d_blade);
		event.getRegistry().register(kingdom_key_d_point);
		
		event.getRegistry().register(lady_luck);
		event.getRegistry().register(lady_luck_hilt);
		event.getRegistry().register(lady_luck_blade);
		event.getRegistry().register(lady_luck_point);
		
		event.getRegistry().register(ruby_dagger);
		event.getRegistry().register(sapphire_dagger);
		event.getRegistry().register(amethyst_dagger);
		event.getRegistry().register(topaz_dagger);
		event.getRegistry().register(emerald_dagger);
		event.getRegistry().register(mythril_dagger);
		event.getRegistry().register(wooden_dagger);
		event.getRegistry().register(stone_dagger);
		event.getRegistry().register(iron_dagger);
		event.getRegistry().register(gold_dagger);
		event.getRegistry().register(diamond_dagger);
		
		event.getRegistry().register(ruby_lance);
		event.getRegistry().register(sapphire_lance);
		event.getRegistry().register(amethyst_lance);
		event.getRegistry().register(topaz_lance);
		event.getRegistry().register(emerald_lance);
		event.getRegistry().register(mythril_lance);
		event.getRegistry().register(wooden_lance);
		event.getRegistry().register(stone_lance);
		event.getRegistry().register(iron_lance);
		event.getRegistry().register(gold_lance);
		event.getRegistry().register(diamond_lance);
		
		event.getRegistry().register(ruby_nunchucks);
		event.getRegistry().register(sapphire_nunchucks);
		event.getRegistry().register(amethyst_nunchucks);
		event.getRegistry().register(topaz_nunchucks);
		event.getRegistry().register(emerald_nunchucks);
		event.getRegistry().register(mythril_nunchucks);
		event.getRegistry().register(wooden_nunchucks);
		event.getRegistry().register(stone_nunchucks);
		event.getRegistry().register(iron_nunchucks);
		event.getRegistry().register(gold_nunchucks);
		event.getRegistry().register(diamond_nunchucks);
	}
}
