package com.wieldersilver.scmcraft.spells;

import com.wieldersilver.scmcraft.init.SpellInit;
import com.wieldersilver.scmcraft.tools.ModItemTier;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Tome extends Item 
{
	private Spell spell = SpellInit.FIRE;
	
	public Tome(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context) 
	{
		return ActionResultType.SUCCESS;
	}
	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		ItemStack stack = playerIn.getHeldItem(handIn);
		spell.activate(worldIn, stack, playerIn);
		
		/* Quick notes about ActionResultType
		 * 
		 * func...a = success
		 * func...b = consume
		 * func...c = pass
		 * func...d = fail
		 */
		
		return ActionResult.func_226248_a_(stack);
	}
}
