/**
 * 
 */
package com.wieldersilver.scmcraft.worldgen;

import com.wieldersilver.scmcraft.scmcraft;
import com.wieldersilver.scmcraft.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

/**
 * @author gusjg
 * This is gonna generate SCM Ores
 */
@SuppressWarnings("rawtypes")
@ObjectHolder(scmcraft.MOD_ID)
@Mod.EventBusSubscriber(modid = scmcraft.MOD_ID, bus = Bus.MOD)
public class OreGeneration 
{
	private static final BlockState RUBY_ORE = BlockInit.ruby_ore.getDefaultState();
	private static final BlockState AMETHYST_ORE = BlockInit.amethyst_ore.getDefaultState();
	private static final BlockState TOPAZ_ORE = BlockInit.topaz_ore.getDefaultState();
	private static final BlockState SAPPHIRE_ORE = BlockInit.sapphire_ore.getDefaultState();
	
	private static final BlockState MYTHRIL_ORE = BlockInit.mythril_ore.getDefaultState();
	
	private static final ConfiguredPlacement ELEMENTAL_CONFIG = Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(5, 0, 0, 64));
	
	private static final ConfiguredPlacement MYTHRIL_CONFIG = Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(2, 0, 0, 32));
	
	@SubscribeEvent
	public static void setupOreGeneration(FMLLoadCompleteEvent event)
	{
		setupOreGeneration();
	}
	
	public static void setupOreGeneration()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RUBY_ORE, 8)).func_227228_a_(ELEMENTAL_CONFIG));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AMETHYST_ORE, 8)).func_227228_a_(ELEMENTAL_CONFIG));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, TOPAZ_ORE, 8)).func_227228_a_(ELEMENTAL_CONFIG));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, SAPPHIRE_ORE, 8)).func_227228_a_(ELEMENTAL_CONFIG));
			
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, MYTHRIL_ORE, 9)).func_227228_a_(MYTHRIL_CONFIG));
		}
	}
}
