/**
 * 
 */
package com.wieldersilver.scmcraft.tabs;

import com.wieldersilver.scmcraft.scmcraft;
import com.wieldersilver.scmcraft.init.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

/**
 * @author gusjg
 *
 */
@Mod(scmcraft.MOD_ID)
public class Tabs 
{
	public static final ItemGroup SPELLS = new ItemGroup("scm_spells")
	{
		@Override
		public ItemStack createIcon() 
		{
			return new ItemStack(ItemInit.tome);
		}
	};
	
}
