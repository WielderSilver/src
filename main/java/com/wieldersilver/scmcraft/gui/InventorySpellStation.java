/**
 * 
 */
package com.wieldersilver.scmcraft.gui;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.IRecipeHelperPopulator;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.util.NonNullList;

/**
 * @author gusjg
 *
 */
public class InventorySpellStation implements IInventory, IRecipeHelperPopulator
{
	/**
	 * stackList[0] = input
	 * stackList[1-3] = Spell slots 1-3
	 */
	private final NonNullList<ItemStack> stackList;
	private final Container eventHandler;
	
	
	/**
	 * 
	 */
	public InventorySpellStation(Container eventHandlerIn) 
	{
		this.stackList = NonNullList.withSize(4, ItemStack.EMPTY);
		this.eventHandler = eventHandlerIn;
	}

	@Override
	public void clear() 
	{
		this.stackList.clear();

	}

	@Override
	public int getSizeInventory() 
	{
		return this.stackList.size();
	}

	@Override
	public boolean isEmpty() 
	{
		for(ItemStack stack : stackList)
		{
			if(!stack.isEmpty())
			{
				return false;
			}
		}
		
		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index) 
	{
		return index >= this.getSizeInventory() ? ItemStack.EMPTY : this.stackList.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		ItemStack stack = ItemStackHelper.getAndSplit(this.stackList, index, count);
		if(!stack.isEmpty())
		{
			eventHandler.onCraftMatrixChanged(this);
		}
		
		return stack;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		return ItemStackHelper.getAndRemove(this.stackList, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		this.stackList.set(index, stack);
	    this.eventHandler.onCraftMatrixChanged(this);
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isUsableByPlayer(PlayerEntity player) 
	{
		return true;
	}

	@Override
	public void fillStackedContents(RecipeItemHelper helper) 
	{
		for(ItemStack itemstack : this.stackList) 
		{
			helper.accountPlainStack(itemstack);
        }
	}
}
