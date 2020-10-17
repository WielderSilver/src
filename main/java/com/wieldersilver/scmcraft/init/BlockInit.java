package com.wieldersilver.scmcraft.init;

import com.wieldersilver.scmcraft.scmcraft;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(scmcraft.MOD_ID)
@Mod.EventBusSubscriber(modid = scmcraft.MOD_ID, bus = Bus.MOD)
public class BlockInit 
{
	public static final Block ruby_block = null;
	public static final Block amethyst_block = null;
	public static final Block topaz_block = null;
	public static final Block sapphire_block = null;
	public static final Block mythril_block = null;
	public static final Block ruby_ore = null;
	public static final Block amethyst_ore = null;
	public static final Block topaz_ore = null;
	public static final Block sapphire_ore = null;
	public static final Block mythril_ore = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) 
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("ruby_block"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("amethyst_block"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("sapphire_block"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("topaz_block"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("mythril_block"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("ruby_ore"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("amethyst_ore"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("sapphire_ore"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("topaz_ore"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("mythril_ore"));

	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().register(new BlockItem(ruby_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("ruby_block"));
		event.getRegistry().register(new BlockItem(amethyst_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("amethyst_block"));
		event.getRegistry().register(new BlockItem(topaz_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("topaz_block"));
		event.getRegistry().register(new BlockItem(sapphire_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("sapphire_block"));
		event.getRegistry().register(new BlockItem(mythril_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("mythril_block"));
		event.getRegistry().register(new BlockItem(ruby_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("ruby_ore"));
		event.getRegistry().register(new BlockItem(amethyst_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("amethyst_ore"));
		event.getRegistry().register(new BlockItem(topaz_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("topaz_ore"));
		event.getRegistry().register(new BlockItem(sapphire_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("sapphire_ore"));
		event.getRegistry().register(new BlockItem(mythril_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("mythril_ore"));

	}
}
