/**
 * 
 */
package com.wieldersilver.scmcraft.init;

import com.wieldersilver.scmcraft.scmcraft;
import com.wieldersilver.scmcraft.recipes.SpellRecipe;

import net.minecraft.block.Block;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

/**
 * @author gusjg
 *
 */
@ObjectHolder(scmcraft.MOD_ID)
@Mod.EventBusSubscriber(modid = scmcraft.MOD_ID, bus = Bus.MOD)
public class RecipeInit {

	public static final IRecipeSerializer<SpellRecipe> SPELL_RECIPE = (IRecipeSerializer<SpellRecipe>) new SpellRecipe.Serializer().setRegistryName("spell_recipe");
	
	
	@SubscribeEvent
	public static void registerSerializers(final RegistryEvent.Register<IRecipeSerializer<?>> event) 
	{
		event.getRegistry().register(SPELL_RECIPE);
	}

}
