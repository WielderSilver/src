/**
 * 
 */
package com.wieldersilver.scmcraft.gui;

import java.util.Optional;

import javax.annotation.Nullable;

import com.wieldersilver.scmcraft.init.BlockInit;
import com.wieldersilver.scmcraft.init.ContainerInit;
import com.wieldersilver.scmcraft.init.ItemInit;
import com.wieldersilver.scmcraft.recipes.SpellRecipe;
import com.wieldersilver.scmcraft.spells.Scrawl;
import com.wieldersilver.scmcraft.spells.Tome;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.RecipeBookContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SSetSlotPacket;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.world.World;

/**
 * @author gusjg
 *
 */
public class ContainerSpellStation extends RecipeBookContainer<InventorySpellStation>
{
	protected final InventorySpellStation inputInventory = new InventorySpellStation(this);
	protected final CraftResultInventory outputInventory = new CraftResultInventory();
	protected final IWorldPosCallable worldPos;
	protected final PlayerEntity player;
	
	/**
	 * @param type
	 * @param id
	 */
	public ContainerSpellStation(int id, PlayerInventory playerInventory) {
		this(id, playerInventory, IWorldPosCallable.DUMMY);
		
	}
	
	public ContainerSpellStation(int id, PlayerInventory playerInventory, PacketBuffer buffer)
	{
		this(id, playerInventory);
		
	}
	
	
	/**
	 * @param type
	 * @param id
	 */
	public ContainerSpellStation(int id, PlayerInventory playerInventory, IWorldPosCallable worldPos) 
	{
		super(ContainerInit.SPELL_STATION, id);
		//System.out.println("type:" + this.getType().toString());
		//System.out.println("type id: " + Registry.MENU.getId(this.getType()));
		//System.out.println("crafting table id: " + Registry.MENU.getId(ContainerType.CRAFTING));
		this.worldPos = worldPos;
		this.player = playerInventory.player;
		
		/* Slot numbers:
		 * Number | Slots
		 * 0      | inputItem
		 * 1-3    | inputSpells
		 * 4      | output
		 * 5-32   | inventory
		 * 33-42  | hotbar
		 */
		
		this.addSlot(new Slot(this.inputInventory, 0, 48, 17)
		{
			
		});
		
		for(int i = 0; i < 3; i++)
		{
			this.addSlot(new Slot(this.inputInventory, 1 + i, 30 + i * 18, 53)
			{
				
			});
		}
		
		
		
		this.addSlot(new Slot(this.outputInventory, 0, 124, 35)
		{
			public boolean isItemValid(ItemStack stack) 
			{
	            return false;
			}
			
			public ItemStack onTake(PlayerEntity player, ItemStack stack) 
			{
				worldPos.consume((p_216944_1_, p_216944_2_) -> 
	            {
	            	
	            });
				
				ItemStack s;
				
				s = inputInventory.getStackInSlot(0);
				if(s.isStackable())
				{
					s.setCount(s.getCount() - 1);
					
				}
				else
				{
					
					inputInventory.setInventorySlotContents(0, ItemStack.EMPTY);
				}
				
				//inputInventory.setInventorySlotContents(0, ItemStack.EMPTY);
				for(int i = 0; i < 3; i++)
				{
					s = inputInventory.getStackInSlot(i + 1);
					
					if(!(s.getItem() instanceof Tome || s.getItem() instanceof Scrawl))
					{
						
						if(s.isStackable())
						{
							s.setCount(s.getCount() - 1);
						}
						else
						{
							inputInventory.setInventorySlotContents(i + 1, ItemStack.EMPTY);
						}
					}
					else
					{
						s = inputInventory.getStackInSlot(i + 1);
						s.damageItem(1, player, 
						(playerEntity) -> 
						{ 
							playerEntity.sendBreakAnimation(EquipmentSlotType.MAINHAND); 
						});
					}
					
					inventorySlots.get(1 + i).onSlotChanged();
				}
				
	            return stack;
	         }
		});
		
		
		
		for(int i = 0; i < 3; ++i) 
		{
			
	        for(int j = 0; j < 9; ++j) 
	        {
	        	this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
	        }
		}

		for(int i = 0; i < 9; ++i) 
		{
	         this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(worldPos, playerIn, BlockInit.spell_station);
	}

	/**
	 * Callback for when the crafting matrix is changed.
	 */
	public void onCraftMatrixChanged(IInventory inventoryIn) 
	{
		super.onCraftMatrixChanged(inventoryIn);
		
		//System.out.println("shwlop");
	
		//this.worldPos.consume((world, blockPos) -> {
			updateRecipe(this.windowId, this.player.world, this.player, this.inputInventory, this.outputInventory);
		//});
	
	}
	
	protected static void updateRecipe(int windowId, World world, PlayerEntity player, InventorySpellStation inputInventory, CraftResultInventory outputInventory) 
	{
		
		if(!world.isRemote)
		{
			/*
			Collection<IRecipe<?>> temp = world.getServer().getRecipeManager().getRecipes();
			for(IRecipe<?> r : temp)
			{
				if(r instanceof SpellRecipe)
				{
					System.out.println("WE GOT ONE");
				}
			}*/
			ItemStack stack = ItemStack.EMPTY;
			
			Optional<SpellRecipe> optional = world.getServer().getRecipeManager().getRecipe(SpellRecipe.TYPE, inputInventory, world);
			
			//System.out.println("Recipe Constructor called: " + SpellRecipe.spellRecipeConstructorCalled);
			//System.out.println("Read Buffer called: " + SpellRecipe.serializerReadBufferCalled);
			
			if(optional.isPresent())
			{
				SpellRecipe recipe = optional.get();
				
				stack = recipe.getCraftingResult(inputInventory);
			}
			else if(!(inputInventory.getStackInSlot(0).getItem() instanceof Scrawl || inputInventory.getStackInSlot(0).getItem() instanceof Tome) && !inputInventory.getStackInSlot(0).isStackable())
			{
				stack = inputInventory.getStackInSlot(0).copy();
				CompoundNBT nbt = stack.getOrCreateTag();
				
				for(int i = 0; i < 3; i++)
				{
					ItemStack spellStack = inputInventory.getStackInSlot(i + 1);
					if(spellStack.getItem() instanceof Scrawl || spellStack.getItem() instanceof Tome)
					{
						CompoundNBT spellTag = spellStack.getOrCreateTag();
						
						String s = "SCM_spell_" + i;
						if(spellTag.contains(s))
						{
							nbt.putString(s, spellTag.getString(s));
						}
						
					}
				}
			}
			outputInventory.setInventorySlotContents(0, stack);
			
			
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity)player;
			serverPlayer.connection.sendPacket(new SSetSlotPacket(windowId, 4, stack));
		
		}
		
		
		
		
		
		//this.inventorySlots.get(4).onSlotChanged();
	}


	@Override
	public void func_201771_a(RecipeItemHelper p_201771_1_) 
	{
		this.inputInventory.fillStackedContents(p_201771_1_);
		
	}


	@Override
	public void clear() 
	{
		
		this.inputInventory.clear();
		this.outputInventory.clear();
		
	}


	@Override
	public boolean matches(IRecipe<? super InventorySpellStation> recipeIn) 
	{
		return recipeIn.matches(inputInventory, player.world);
	}


	@Override
	public int getOutputSlot() 
	{
		return 0;
	}


	@Override
	public int getWidth() 
	{
		return 3;
	}


	@Override
	public int getHeight() 
	{
		return 1;
	}


	@Override
	public int getSize() 
	{
		return 5;
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot)this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) 
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			int invenSize = 43;
			
			if (index < invenSize) 
			{
				if (!this.mergeItemStack(itemstack1, invenSize, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			}
			else if (!this.mergeItemStack(itemstack1, 0, invenSize, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			}
			else {
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}
	
	@Override
	protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection){
		boolean flag = false;
		int i = startIndex;
		if (reverseDirection) i = endIndex - 1;
		
		if (stack.isStackable()){
			while (stack.getCount() > 0 && (!reverseDirection && i < endIndex || reverseDirection && i >= startIndex)){
				Slot slot = (Slot)this.inventorySlots.get(i);
				ItemStack itemstack = slot.getStack();
				int maxLimit = Math.min(stack.getMaxStackSize(), slot.getSlotStackLimit());
				
				if (itemstack != null && areItemStacksEqual(stack, itemstack)){
					int j = itemstack.getCount() + stack.getCount();
					if (j <= maxLimit){
						stack.setCount(0);
						itemstack.setCount(j);
						slot.onSlotChanged();
						flag = true;
						
					}else if (itemstack.getCount() < maxLimit){
						stack.setCount(stack.getCount() - (maxLimit - itemstack.getCount()));
						itemstack.setCount(maxLimit);
						slot.onSlotChanged();
						flag = true;
					}
				}
				if (reverseDirection){ 
					--i;
				}else ++i;
			}
		}
		if (stack.getCount() > 0){
			if (reverseDirection){
				i = endIndex - 1;
			}else i = startIndex;

			while (!reverseDirection && i < endIndex || reverseDirection && i >= startIndex){
				Slot slot1 = (Slot)this.inventorySlots.get(i);
				ItemStack itemstack1 = slot1.getStack();

				if (itemstack1 == null && slot1.isItemValid(stack)){ // Forge: Make sure to respect isItemValid in the slot.
					if(stack.getCount() <= slot1.getSlotStackLimit()){
						slot1.putStack(stack.copy());
						slot1.onSlotChanged();
						stack.setCount(0);
						flag = true;
						break;
					}else{
						itemstack1 = stack.copy();
						stack.setCount(stack.getCount() - slot1.getSlotStackLimit());
						itemstack1.setCount(slot1.getSlotStackLimit());
						slot1.putStack(itemstack1);
						slot1.onSlotChanged();
						flag = true;
					}					
				}
				if (reverseDirection){
					--i;
				}else ++i;
			}
		}
		return flag;
	}
	
	private static boolean areItemStacksEqual(ItemStack stackA, ItemStack stackB)
	{
		return stackA.getItem().equals(stackB.getItem()) && ItemStack.areItemStackTagsEqual(stackA, stackB);
	}
	
	@Override
	public void onContainerClosed(PlayerEntity player) 
	{
		super.onContainerClosed(player);
		for(int i = 0; i < 4; i++)
		{
			ItemStack stack = inputInventory.getStackInSlot(i);
			if(!stack.isEmpty())
			{
				player.dropItem(stack, false);
				inputInventory.setInventorySlotContents(i, ItemStack.EMPTY);
			}
		}
	}
}
