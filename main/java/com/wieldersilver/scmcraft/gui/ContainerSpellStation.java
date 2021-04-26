/**
 * 
 */
package com.wieldersilver.scmcraft.gui;

import java.util.Collection;
import java.util.Optional;

import com.wieldersilver.scmcraft.init.BlockInit;
import com.wieldersilver.scmcraft.init.ContainerInit;
import com.wieldersilver.scmcraft.init.ItemInit;
import com.wieldersilver.scmcraft.recipes.SpellRecipe;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.RecipeBookContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

/**
 * @author gusjg
 *
 */
public class ContainerSpellStation extends RecipeBookContainer<InventorySpellStation>
{
	private final InventorySpellStation inputInventory = new InventorySpellStation(this);
	private final CraftResultInventory outputInventory = new CraftResultInventory();
	private final IWorldPosCallable worldPos;
	private final PlayerEntity player;
	
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
				
				inputInventory.setInventorySlotContents(0, ItemStack.EMPTY);
				for(int i = 0; i < 3; i++)
				{
					if(inputInventory.getStackInSlot(i + 1).getItem() != ItemInit.tome)
					{
						inputInventory.setInventorySlotContents(i + 1, ItemStack.EMPTY);
					}
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
			ServerPlayerEntity sPlayer = (ServerPlayerEntity)player;
			ItemStack stack = ItemStack.EMPTY;
			
			/*
			Collection<IRecipe<?>> temp = world.getServer().getRecipeManager().getRecipes();
			for(IRecipe<?> r : temp)
			{
				if(r instanceof SpellRecipe)
				{
					System.out.println("WE GOT ONE");
				}
			}*/
			
			Optional<SpellRecipe> optional = world.getServer().getRecipeManager().getRecipe(SpellRecipe.TYPE, inputInventory, world);
			
			if(optional.isPresent())
			{
				SpellRecipe recipe = optional.get();
				if(outputInventory.canUseRecipe(world, sPlayer, recipe))
				{
					stack = recipe.getCraftingResult(inputInventory);
				}
				System.out.println("bup");
			}
			System.out.println("badup");
			
			outputInventory.setInventorySlotContents(0, stack);
		}
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
}
