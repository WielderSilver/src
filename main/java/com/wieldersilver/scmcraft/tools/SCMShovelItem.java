package com.wieldersilver.scmcraft.tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SCMShovelItem extends ShovelItem {

	public SCMShovelItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
		// TODO Auto-generated constructor stub
	}
	
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving)
	{
		ModItemTier temp = null; { IItemTier temp2 = this.getTier(); if(temp2 instanceof ModItemTier) temp = (ModItemTier)temp2; }
		boolean b = true;
		if(temp != null && temp.getSpecialFunctionHandler() != null)
		{
			b = temp.getSpecialFunctionHandler().onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
		}
		
		
		return b && super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
	}
	
	public ActionResultType onItemUse(ItemUseContext context)
	{
		ModItemTier temp = null; { IItemTier temp2 = this.getTier(); if(temp2 instanceof ModItemTier) temp = (ModItemTier)temp2; }
		if(temp != null && temp.getSpecialFunctionHandler() != null) {
			return temp.getSpecialFunctionHandler().onItemUse(context);
		}
		
		return super.onItemUse(context);
	}
	
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
	{
		ModItemTier temp = null; { IItemTier temp2 = this.getTier(); if(temp2 instanceof ModItemTier) temp = (ModItemTier)temp2; }
		boolean b = true;
		if(temp != null && temp.getSpecialFunctionHandler() != null)
		{
			b = temp.getSpecialFunctionHandler().hitEntity(stack, target, attacker);
		}
		
		return b && super.hitEntity(stack, target, attacker);
	}

}
