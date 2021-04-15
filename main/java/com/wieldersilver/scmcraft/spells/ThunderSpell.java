package com.wieldersilver.scmcraft.spells;

import com.wieldersilver.scmcraft.tools.weapons.IExtendedReach;
import com.wieldersilver.scmcraft.util.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ThunderSpell extends Spell {

	public ThunderSpell() {
		super("thunder", 1, 100);
		
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
		
		
        Vec3d vec3d;
		if(target == null)
		{
			//normalize look vector to be a two-dimensional (x, z) unit vector
			Vec3d look = player.getLook(1);
			look = new Vec3d(look.x, 0, look.z).normalize();
			
			vec3d = player.getEyePosition(1).add(look.scale(reach));
			vec3d = new Vec3d(vec3d.x, player.getPositionVec().y, vec3d.z);
		}
		else
		{
			vec3d = target.getPositionVec();
		}
        
        
		LightningBoltEntity lightning = new LightningBoltEntity(world, vec3d.x, vec3d.y, vec3d.z, false);
		if(!world.isRemote)
		{
			lightning.setCaster((ServerPlayerEntity)player);
			((ServerWorld)world).addLightningBolt(lightning);
		}
	}

}
