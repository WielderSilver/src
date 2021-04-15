/**
 * 
 */
package com.wieldersilver.scmcraft.spells;

import com.wieldersilver.scmcraft.entities.BlizzardProjectile;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/**
 * @author gusjg
 *
 */
public class BlizzardSpell extends Spell 
{
	
	public BlizzardSpell() 
	{
		super("blizzard", 1, 100);
	}

	@Override
	public void activate(World world, ItemStack item, PlayerEntity player) 
	{
		Minecraft mc = Minecraft.getInstance();

		BlizzardProjectile blizzard = new BlizzardProjectile(world, player);
		if(!world.isRemote)
		{
			((ServerWorld)world).addEntity(blizzard);
			System.out.println("Blizzard");
		}
	}

}
