package com.wieldersilver.scmcraft.armor;

import com.wieldersilver.scmcraft.init.ItemInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class RubyArmorItem extends ArmorItem {
	
	private static final EffectInstance effect = new EffectInstance(Effects.FIRE_RESISTANCE, 10, 0, true, false);

	public RubyArmorItem(EquipmentSlotType slot, Properties builder) {
		super(ModArmorMaterial.RUBY, slot, builder);
		
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * onArmorTick runs for each equipped piece of armor, each frame. As such, we need
	 * to minimize the amount of code that runs as much as possible.
	 */
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
	{
		//By limiting this to one piece of armor, we reduce the lag by 75%
		if(stack.getItem().equals(ItemInit.ruby_helmet))
		{
			Iterable<ItemStack> list = player.getArmorInventoryList();
			int i = 0;
			boolean b = true;
			
			//simple iteration
			for(ItemStack item : list)
			{
				i++;
				if(item != null && item.getItem() instanceof ArmorItem)
				{
					ArmorItem cast = (ArmorItem)item.getItem();
					//checking if all equipped armor is of the desired material
					//NOTE: in theory, this could be used for creating custom armor
					//combinations.
					b = b && cast.getArmorMaterial().equals(ModArmorMaterial.RUBY);
				}
				else
				{
					b = false;
				}
				
			}
			//if a piece of armor is missing
			if(i < 4) b = false;
			
			//APPLY ARMOR EFFECT
			if(b)
			{
				player.addPotionEffect(effect);
			}
		}
	}
	
}
