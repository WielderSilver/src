/**
 * 
 */
package com.wieldersilver.scmcraft.recipes;

import java.util.Optional;

import javax.annotation.Nullable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.wieldersilver.scmcraft.scmcraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IIngredientSerializer;
import net.minecraftforge.common.crafting.NBTIngredient;

/**
 * @author gusjg
 *
 */
public class SpellIngredient extends NBTIngredient 
{

	protected NonNullList<ItemStack> stacks;
	
	/**
	 * @param stack
	 */
	public SpellIngredient(ItemStack stack) {
		super(stack);
		this.stacks = NonNullList.from(ItemStack.EMPTY, stack);
		// TODO Auto-generated constructor stub
	}
	
	public SpellIngredient(NonNullList<ItemStack> stacks)
	{
		super(ItemStack.EMPTY);
		this.stacks = stacks;
	}
	
	@Override
    public boolean test(@Nullable ItemStack input)
    {
        if (input == null)
            return false;
        
        //System.out.println("them: " + input.getItem().toString());
        
        CompoundNBT inputNBT = input.getOrCreateTag();
        
        for(ItemStack stack : stacks)
        {
        	System.out.println("me: " + stack.getItem().toString());
        	
	        CompoundNBT stackNBT = stack.getOrCreateTag();
	        
	        boolean noSpells = true;
	        boolean flag = true;
	        
	        for(int i = 0; i < 3; i++)
	        {
	        	String key = "SCM_spell_" + i;
		        if(stackNBT.contains(key))
		        {
		        	noSpells = false;
		        	flag = flag && stackNBT.getString(key).toLowerCase().equals(inputNBT.getString(key).toLowerCase());
		        }
	        }
	        
	        //If the recipe item doesn't have spells
	        if(noSpells)
	        {
	        	return stack.getItem().equals(input.getItem());
	        }
	        
	        return flag && stack.getItem().equals(input.getItem());
	        
        }
        
        //Can't use areItemStacksEqualUsingNBTShareTag because it compares stack size as well
        //return this.stacks.getItem() == input.getItem() && flag;
        return false;
    }
	
	/**
	 * Should only be used for result.
	 * @return
	 */
	public ItemStack getItemStack()
	{
		return stacks.get(0);
	}
	
	@Override
    public IIngredientSerializer<? extends Ingredient> getSerializer()
    {
        return Serializer.INSTANCE;
    }
	
	@Override
	public JsonElement serialize()
	{
		JsonArray json = new JsonArray();
		for(ItemStack stack : stacks)
		{
			JsonObject object = new JsonObject();
			
			object.addProperty("item", stack.getItem().getRegistryName().toString());
			
			CompoundNBT nbt = stack.getOrCreateTag();
			String spell0 = nbt.getString("SCM_spell_0");
			String spell1 = nbt.getString("SCM_spell_1");
			String spell2 = nbt.getString("SCM_spell_2");
			if(spell0.equals(spell1) && spell1.equals(spell2) && !spell0.equals(""))
			{
				object.addProperty("spell", scmcraft.MOD_ID + spell0);
			}
			else
			{
				if(!spell0.equals(""))
				{
					object.addProperty("spell0", scmcraft.MOD_ID + spell0);
				}
				if(!spell1.equals(""))
				{
					object.addProperty("spell1", scmcraft.MOD_ID + spell1);
				}
				if(!spell2.equals(""))
				{
					object.addProperty("spell2", scmcraft.MOD_ID + spell2);
				}
			}
			
			json.add(object);
		}
		
		JsonObject object = new JsonObject();
		object.add("data", json);
		
		return object;
	}
	
	
	
	public static class Serializer implements IIngredientSerializer<SpellIngredient>
    {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public SpellIngredient parse(PacketBuffer buffer) {
        	NonNullList<ItemStack> stacks = NonNullList.create();
        	int size = buffer.readInt();
        	
        	for(int i = 0; i < size; i++)
        	{
        		stacks.add(buffer.readItemStack());
        	}
        	
            return new SpellIngredient(stacks);
        }
        
        public SpellIngredient parse(JsonArray json)
        {
        	NonNullList<ItemStack> list = NonNullList.create();
        	for(JsonElement e : json)
        	{
        		JsonObject obj = e.getAsJsonObject();
        		//ResourceLocation r = new ResourceLocation(obj.get("item").getAsString());
        		
        		Optional<Item> item = Registry.ITEM.getValue(new ResourceLocation(obj.get("item").getAsString()));
        		if(item.isPresent())
        		{
        			ItemStack stack = new ItemStack(item.get());
        			
        			CompoundNBT nbt = stack.getOrCreateTag();
        			if(obj.has("spell"))
        			{
        				String spell = obj.get("spell").getAsString();
        				nbt.putString("SCM_spell_0", spell);
        				nbt.putString("SCM_spell_1", spell);
        				nbt.putString("SCM_spell_2", spell);
        			}
        			else
        			{
        				if(obj.has("spell0"))
        				{
        					nbt.putString("SCM_spell_0", obj.get("spell0").getAsString());
        				}
        				if(obj.has("spell1"))
        				{
        					nbt.putString("SCM_spell_1", obj.get("spell1").getAsString());
        				}
        				if(obj.has("spell2"))
        				{
        					nbt.putString("SCM_spell_2", obj.get("spell2").getAsString());
        				}
        			}
        			
        			stack.setTag(nbt);
        			list.add(stack);
        		}
        		else
        		{
        			list.add(ItemStack.EMPTY);
        		}
        	}
        	
            return new SpellIngredient(list);
        }

        @Override
        public SpellIngredient parse(JsonObject json) 
        {
        	JsonArray arr = json.get("data").getAsJsonArray();
        	
        	return parse(arr);
        }

        @Override
        public void write(PacketBuffer buffer, SpellIngredient ingredient) 
        {
        	buffer.writeInt(ingredient.stacks.size());
        	for(ItemStack stack : ingredient.stacks)
        	{
        		buffer.writeItemStack(stack);
        	}
        }
    }

}
