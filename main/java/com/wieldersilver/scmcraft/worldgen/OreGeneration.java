/**
 * 
 */
package com.wieldersilver.scmcraft.worldgen;

import com.wieldersilver.scmcraft.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * @author gusjg
 * This is gonna generate SCM Ores
 */
@SuppressWarnings("rawtypes")
public class OreGeneration 
{
	private static final BlockState RUBY_ORE = BlockInit.ruby_ore.getDefaultState();
	private static final BlockState AMETHYST_ORE = BlockInit.amethyst_ore.getDefaultState();
	private static final BlockState TOPAZ_ORE = BlockInit.topaz_ore.getDefaultState();
	private static final BlockState SAPPHIRE_ORE = BlockInit.sapphire_ore.getDefaultState();
	
	@SuppressWarnings("unused")
	private static final BlockState MYTHRIL_ORE = BlockInit.mythril_ore.getDefaultState();
	
	private static final ConfiguredPlacement ELEMENTAL_CONFIG = Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(5, 0, 0, 64));
	
	private static final ConfiguredPlacement MYTHRIL_CONFIG = Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(2, 0, 0, 32));
	
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
