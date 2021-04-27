/**
 * 
 */
package com.wieldersilver.scmcraft.recipes;

import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.wieldersilver.scmcraft.scmcraft;
import com.wieldersilver.scmcraft.gui.InventorySpellStation;
import com.wieldersilver.scmcraft.init.RecipeInit;
import com.wieldersilver.scmcraft.util.Utils;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.item.crafting.ShapelessRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

/**
 * @author gusjg
 *
 */
public class SpellRecipe implements IRecipe<InventorySpellStation> 
{
	private final ResourceLocation id;
	private final String group;
	private final SpellIngredient inputItem;
	private final SpellIngredient spell1;
	private final SpellIngredient spell2;
	private final SpellIngredient spell3;
	private final SpellIngredient result;
	
	public static boolean spellRecipeConstructorCalled = false;
	public static boolean serializerReadBufferCalled = false;
	
	
	public static final IRecipeType<SpellRecipe> TYPE = new IRecipeType<SpellRecipe>() 
	{
		public String toString() { return scmcraft.MOD_ID + ":spell_recipe"; }
	};
	
	/**
	 * 
	 */
	public SpellRecipe(ResourceLocation id, String group, SpellIngredient inputItem, SpellIngredient spell1, SpellIngredient spell2, SpellIngredient spell3, SpellIngredient result) 
	{
		this.id = id;
		this.group = group;
		this.inputItem = inputItem;
		this.spell1 = spell1;
		this.spell2 = spell2;
		this.spell3 = spell3;
		this.result = result;
		
		spellRecipeConstructorCalled = true;
		
		System.out.println("This is a recipe: " + id.toString());
	}

	@Override
	public boolean canFit(int width, int height) 
	{
		return width <= 4 && height == 1;
	}

	@Override
	public ItemStack getRecipeOutput() 
	{
		return this.result.getItemStack();
	}

	@Override
	public ResourceLocation getId() 
	{
		return this.id;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() 
	{
		return RecipeInit.SPELL_RECIPE;
	}

	@Override
	public IRecipeType<?> getType() 
	{
		return TYPE;
	}

	@Override
	public boolean matches(InventorySpellStation inv, World worldIn) 
	{
		System.out.println("recipe check: " + id.toString());
		
		return inputItem.test(inv.getStackInSlot(0)) && spell1.test(inv.getStackInSlot(1)) && spell2.test(inv.getStackInSlot(2)) && spell3.test(inv.getStackInSlot(3));
	}

	@Override
	public ItemStack getCraftingResult(InventorySpellStation inv) 
	{
		return this.getRecipeOutput().copy();
	}
	
	public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<SpellRecipe>
	{
		private static final ResourceLocation NAME = new ResourceLocation(scmcraft.MOD_ID, "spell_crafting");
		
		public Serializer()
		{
			
		}
		
		@Override
		public SpellRecipe read(ResourceLocation recipeId, JsonObject json) 
		{
			
			
			String group = JSONUtils.getString(json, "group", "");
			Map<String, SpellIngredient> map = Utils.deserializeKey(JSONUtils.getJsonObject(json, "key"));


			SpellIngredient input = map.get(JSONUtils.getString(json, "input"));
			
			SpellIngredient spell1 = map.get(JSONUtils.getString(json, "spell1"));
			
			SpellIngredient spell2 = map.get(JSONUtils.getString(json, "spell2"));
			
			SpellIngredient spell3 = map.get(JSONUtils.getString(json, "spell3"));
			
			SpellIngredient result = map.get(JSONUtils.getString(json, "result"));
			
			
			return new SpellRecipe(recipeId, group, input, spell1, spell2, spell3, result);
		}

		@Override
		public SpellRecipe read(ResourceLocation recipeId, PacketBuffer buffer) 
		{
			SpellRecipe.serializerReadBufferCalled = true;
			
			String group = buffer.readString(32767);
			
			SpellIngredient input = SpellIngredient.Serializer.INSTANCE.parse(buffer);
			SpellIngredient spell1 = SpellIngredient.Serializer.INSTANCE.parse(buffer);
			SpellIngredient spell2 = SpellIngredient.Serializer.INSTANCE.parse(buffer);
			SpellIngredient spell3 = SpellIngredient.Serializer.INSTANCE.parse(buffer);
			SpellIngredient result = SpellIngredient.Serializer.INSTANCE.parse(buffer);
			
			return new SpellRecipe(recipeId, group, input, spell1, spell2, spell3, result);
		}

		@Override
		public void write(PacketBuffer buffer, SpellRecipe recipe) 
		{
			System.out.println("start");
			
			buffer.writeString(recipe.group);
	        
			SpellIngredient.Serializer.INSTANCE.write(buffer, recipe.inputItem);
			SpellIngredient.Serializer.INSTANCE.write(buffer, recipe.spell1);
			SpellIngredient.Serializer.INSTANCE.write(buffer, recipe.spell2);
			SpellIngredient.Serializer.INSTANCE.write(buffer, recipe.spell3);
			SpellIngredient.Serializer.INSTANCE.write(buffer, recipe.result);
			
			System.out.println("end");
		}
		
	}

}
