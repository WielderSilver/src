/**
 * 
 */
package com.wieldersilver.scmcraft.spells;

import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/**
 * @author gusjg
 *
 */
public class FireSpell extends Spell {

	/**
	 * Default constructor.
	 * @param name
	 * @param level
	 * @param cooldown
	 */
	public FireSpell(String name, int level, int cooldown) {
		super(name, level, cooldown);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void activate(World world, ItemStack item, PlayerEntity player) 
	{
        
	}

}
