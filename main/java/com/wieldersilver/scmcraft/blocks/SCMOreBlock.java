/**
 * 
 */
package com.wieldersilver.scmcraft.blocks;

import java.util.Random;

import com.wieldersilver.scmcraft.init.BlockInit;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

/**
 * @author gusjg
 *
 */
public class SCMOreBlock extends OreBlock 
{

	public SCMOreBlock(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Calculate probability of different exp drops
	 */
	@Override
	protected int func_220281_a(Random p_220281_1_) 
	{
		if(this == BlockInit.ruby_ore)
		{
			return MathHelper.nextInt(p_220281_1_, 3, 7);
		}
		if(this == BlockInit.amethyst_ore)
		{
			return MathHelper.nextInt(p_220281_1_, 3, 7);
		}
		if(this == BlockInit.topaz_ore)
		{
			return MathHelper.nextInt(p_220281_1_, 3, 7);
		}
		if(this == BlockInit.sapphire_ore)
		{
			return MathHelper.nextInt(p_220281_1_, 3, 7);
		}
		if(this == BlockInit.mythril_ore)
		{
			return MathHelper.nextInt(p_220281_1_, 5, 9);
		}
		return 0;
	}
}
