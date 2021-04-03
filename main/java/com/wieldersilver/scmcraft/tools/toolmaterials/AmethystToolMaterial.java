/**
 * 
 */
package com.wieldersilver.scmcraft.tools.toolmaterials;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author Silverbeam
 *
 */
public class AmethystToolMaterial implements SCMToolMaterial {

	/**
	 * @see com.wieldersilver.scmcraft.tools.toolmaterials.SCMToolMaterial#onBlockDestroyed(net.minecraft.item.ItemStack, net.minecraft.world.World, net.minecraft.block.BlockState, net.minecraft.util.math.BlockPos, net.minecraft.entity.LivingEntity)
	 */
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos,
			LivingEntity entityLiving) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * @see com.wieldersilver.scmcraft.tools.toolmaterials.SCMToolMaterial#onItemUse(net.minecraft.item.ItemUseContext)
	 */
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		// TODO Auto-generated method stub
		return ActionResultType.SUCCESS;
	}

	/**
	 * @see com.wieldersilver.scmcraft.tools.toolmaterials.SCMToolMaterial#hitEntity(net.minecraft.item.ItemStack, net.minecraft.entity.LivingEntity, net.minecraft.entity.LivingEntity)
	 */
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		// TODO Auto-generated method stub
		
		attacker.heal(1);
		return true;
	}

}
