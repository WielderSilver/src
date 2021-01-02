/**
 * 
 */
package com.wieldersilver.scmcraft.tools.weapons;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;

/**
 * @author gusjg
 *
 */
public class StoneGreatswordItem extends GreatswordItem {

	/**
	 * @param tier
	 * @param builder
	 */
	public StoneGreatswordItem(IItemTier tier, Properties builder) {
		super(tier, builder);
		
	}
	
	@SuppressWarnings("resource")
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
	{
		
		Minecraft.getInstance().particles.addParticleEmitter(target, ParticleTypes.FLAME);
		stack.damageItem(1, attacker, (p_220045_0_) -> {
	         p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
	      });
		
		return false;
	}

}
