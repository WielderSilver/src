/**
 * 
 */
package com.wieldersilver.scmcraft.spells;

import com.wieldersilver.scmcraft.entities.FireProjectile;
import com.wieldersilver.scmcraft.tools.weapons.IExtendedReach;
import com.wieldersilver.scmcraft.util.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
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
	public FireSpell() {
		super("fire", 1, 100);
	}

	@Override
	public void activate(World world, ItemStack item, PlayerEntity player) 
	{
		Minecraft mc = Minecraft.getInstance();
		
		//caution: this is client-side reach
		float reach = mc.playerController.getBlockReachDistance();
		Item itemRef = item.getItem();
		if(itemRef instanceof IExtendedReach)
		{
			reach = Math.max(((IExtendedReach)itemRef).getReach(), reach);
		}
		reach *= 1.5f;
		Entity target = Utils.getExtendedRangeTarget(reach);
		
		FireProjectile fire;
		if(target instanceof LivingEntity)
		{
			fire = new FireProjectile(world, player, (LivingEntity)target);
		}
		else
		{
			fire = new FireProjectile(world, player);
		}
		
		if(!world.isRemote)
		{
			((ServerWorld)world).addEntity(fire);
		}
	}

}
