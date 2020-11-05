package com.wieldersilver.scmcraft.tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SCMPickaxeItem extends PickaxeItem {

	public SCMPickaxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
		// TODO Auto-generated constructor stub
	}

	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving)
	{
		ModItemTier temp = (ModItemTier) this.getTier();
		boolean b = true;
		if(temp.getSpecialFunctionHandler() != null)
		{
			b = temp.getSpecialFunctionHandler().onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
		}
		
		
		return b && super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
	}
	
	public ActionResultType onItemUse(ItemUseContext context)
	{
		ModItemTier temp = (ModItemTier) this.getTier();
		if(temp.getSpecialFunctionHandler() != null)
		{
			return temp.getSpecialFunctionHandler().onItemUse(context);
		}
		
		return super.onItemUse(context);
	}
	
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
	{
		ModItemTier temp = (ModItemTier) this.getTier();
		boolean b = true;
		if(temp.getSpecialFunctionHandler() != null)
		{
			b = temp.getSpecialFunctionHandler().hitEntity(stack, target, attacker);
		}
		
		return b && super.hitEntity(stack, target, attacker);
	}
}
