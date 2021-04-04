package com.wieldersilver.scmcraft.spells;

import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ThunderSpell extends Spell {

	public ThunderSpell() {
		super("thunder", 2, 100);
		
	}

	@Override
	public void activate(World world, ItemStack item, PlayerEntity player) {
		
		
        Vec3d vec3d = player.getPositionVec().add(player.getLook(1f).scale(3f)).add(player.getMotion().scale(4f));
		
		LightningBoltEntity lightning = new LightningBoltEntity(world, vec3d.getX(), player.getPosition().getY(), vec3d.getZ(), false);
		if(world instanceof ServerWorld)
		{
			((ServerWorld)world).addLightningBolt(lightning);
		}
	}

}
