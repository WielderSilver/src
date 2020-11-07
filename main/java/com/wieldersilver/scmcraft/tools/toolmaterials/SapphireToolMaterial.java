/**
 * 
 */
package com.wieldersilver.scmcraft.tools.toolmaterials;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @author Silverbeam
 *
 */
public class SapphireToolMaterial implements SCMToolMaterial {

	/* (non-Javadoc)
	 * @see com.wieldersilver.scmcraft.tools.toolmaterials.SCMToolMaterial#onBlockDestroyed(net.minecraft.item.ItemStack, net.minecraft.world.World, net.minecraft.block.BlockState, net.minecraft.util.math.BlockPos, net.minecraft.entity.LivingEntity)
	 */
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos,
			LivingEntity entityLiving) {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see com.wieldersilver.scmcraft.tools.toolmaterials.SCMToolMaterial#onItemUse(net.minecraft.item.ItemUseContext)
	 */
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		// TODO Auto-generated method stub
		return ActionResultType.SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.wieldersilver.scmcraft.tools.toolmaterials.SCMToolMaterial#hitEntity(net.minecraft.item.ItemStack, net.minecraft.entity.LivingEntity, net.minecraft.entity.LivingEntity)
	 */
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		// TODO Auto-generated method stub
		
		target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 40, 1));
		return true;
	}

}
