package com.wieldersilver.scmcraft.init;

import com.mojang.datafixers.types.Type;
import com.wieldersilver.scmcraft.scmcraft;
import com.wieldersilver.scmcraft.blocks.*;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
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
	public static final Block ruby_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("ruby_block");
	public static final Block amethyst_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("amethyst_block");
	public static final Block topaz_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("topaz_block");
	public static final Block sapphire_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("sapphire_block");
	public static final Block mythril_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("mythril_block");
	
	public static final Block ruby_ore = new SCMOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("ruby_ore");
	public static final Block amethyst_ore = new SCMOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("amethyst_ore");;
	public static final Block topaz_ore = new SCMOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("topaz_ore");
	public static final Block sapphire_ore = new SCMOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("sapphire_ore");
	public static final Block mythril_ore = new SCMOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("mythril_ore");
	
	public static final Block spell_station = new SpellStation(Block.Properties.create(Material.WOOD).hardnessAndResistance(5.0f, 1200.0f).sound(SoundType.WOOD).harvestLevel(0).harvestTool(ToolType.PICKAXE)).setRegistryName("spell_station");
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) 
	{
		event.getRegistry().register(ruby_block);
		event.getRegistry().register(amethyst_block);
		event.getRegistry().register(topaz_block);
		event.getRegistry().register(sapphire_block);
		event.getRegistry().register(mythril_block);
		
		event.getRegistry().register(ruby_ore);
		event.getRegistry().register(amethyst_ore);
		event.getRegistry().register(topaz_ore);
		event.getRegistry().register(sapphire_ore);
		event.getRegistry().register(mythril_ore);
		
		event.getRegistry().register(spell_station);
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().register(new BlockItem(ruby_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("ruby_block"));
		event.getRegistry().register(new BlockItem(sapphire_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("sapphire_block"));
		event.getRegistry().register(new BlockItem(topaz_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("topaz_block"));
		event.getRegistry().register(new BlockItem(amethyst_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("amethyst_block"));
		event.getRegistry().register(new BlockItem(mythril_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("mythril_block"));
		
		event.getRegistry().register(new BlockItem(ruby_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("ruby_ore"));
		event.getRegistry().register(new BlockItem(sapphire_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("sapphire_ore"));
		event.getRegistry().register(new BlockItem(topaz_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("topaz_ore"));
		event.getRegistry().register(new BlockItem(amethyst_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("amethyst_ore"));
		event.getRegistry().register(new BlockItem(mythril_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("mythril_ore"));

		event.getRegistry().register(new BlockItem(spell_station, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("spell_station"));
	}
}
