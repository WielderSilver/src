package com.wieldersilver.scmcraft.tools.toolmaterials;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface SCMToolMaterial 
{
	public abstract boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving);
	public abstract ActionResultType onItemUse(ItemUseContext context);
	public abstract boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker);
}
