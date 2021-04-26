/**
 * 
 */
package com.wieldersilver.scmcraft.blocks;

import com.wieldersilver.scmcraft.gui.ContainerSpellStation;
import com.wieldersilver.scmcraft.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiContainerEvent;

/**
 * @author gusjg
 *
 */
public class SpellStation extends Block implements INamedContainerProvider
{
	
	
	/**
	 * @param properties
	 */
	public SpellStation(Properties properties) 
	{
		super(properties);
	}
	
	/**
	 * This is the onBlockActivated method.
	 * @param blockState
	 * @param world
	 * @param blockPos
	 * @param player
	 * @param hand
	 * @param rayTraceResult
	 */
	@Override
	public ActionResultType func_225533_a_(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) 
	{
		if(!world.isRemote)
		{
			player.openContainer(blockState.getContainer(world, blockPos));
			
			System.out.println("Woot woot");
		}
		return ActionResultType.SUCCESS;
	}
	
	@Override
	public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos)
	{
		return this;
		/*return new SimpleNamedContainerProvider((id, playerInventory, player) -> {
	         return new ContainerSpellStation(id, playerInventory, IWorldPosCallable.of(worldIn, pos));
	      }, text);*/
		
		//return null;
	}

	@Override
	public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity p_createMenu_3_) {
		// TODO Auto-generated method stub
		return new ContainerSpellStation(id, playerInventory);
	}

	@Override
	public ITextComponent getDisplayName() {
		// TODO Auto-generated method stub
		return new TranslationTextComponent(BlockInit.spell_station.getTranslationKey());
	}
}

