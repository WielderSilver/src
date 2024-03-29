/**
 * 
 */
package com.wieldersilver.scmcraft.tools.weapons.keyblades;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * @author Silverbeam
 *
 */
public class KeybladeItem extends TieredItem {
	
	private static final float ATTACK_DAMAGE = 2f;
	private static final float ATTACK_SPEED = 10f;
	private static final float BOUNCE_SPEED = 0.5f;
	
	private final float attackDamage;
	
	
	public KeybladeItem(IItemTier tier, Item.Properties builder)
	{
		super(tier, builder);
		
		this.attackDamage = ATTACK_DAMAGE + this.getTier().getAttackDamage();
	}

	
	public float getAttackDamage() {
	      return attackDamage;
	   }

	   public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
	      return !player.isCreative();
	   }

	   public float getDestroySpeed(ItemStack stack, BlockState state) {
	      Block block = state.getBlock();
	      if (block == Blocks.COBWEB) {
	         return 15.0F;
	      } else {
	         Material material = state.getMaterial();
	         return material != Material.PLANTS && material != Material.TALL_PLANTS && material != Material.CORAL && !state.isIn(BlockTags.LEAVES) && material != Material.GOURD ? 1.0F : 1.5F;
	      }
	   }

	   /**
	    * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
	    * the damage on the stack.
	    */
	   public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
	      stack.damageItem(1, attacker, (p_220045_0_) -> {
	         p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
	      });
	      
	      attacker.addVelocity(0, BOUNCE_SPEED, 0);
	      attacker.velocityChanged = true;
	      
	      //Direction d = attacker.getAdjustedHorizontalFacing().getOpposite();
	      Vec3d targetVec = target.getPositionVector();
	      Vec3d attackerVec = attacker.getPositionVector();
	      float multiplier = -0.1f;
	      
	      float xVel = (float) (targetVec.getX() - attackerVec.getX());
	      float zVel = (float) (targetVec.getZ() - attackerVec.getZ());
	      
	      target.addVelocity(xVel * multiplier, target.onGround ? 0 : BOUNCE_SPEED, zVel * multiplier);
	      target.velocityChanged = true;
	      
	      return true;
	   }

	   /**
	    * Called when a Block is destroyed using this Item. Return true to trigger the "Use Item" statistic.
	    */
	   public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
	      if (state.getBlockHardness(worldIn, pos) != 0.0F) {
	         stack.damageItem(2, entityLiving, (p_220044_0_) -> {
	            p_220044_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
	         });
	      }

	      return true;
	   }

	   /**
	    * Check whether this Item can harvest the given Block
	    */
	   public boolean canHarvestBlock(BlockState blockIn) {
	      return blockIn.getBlock() == Blocks.COBWEB;
	   }

	   /**
	    * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
	    */
	   public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
	      Multimap<String, AttributeModifier> multimap = HashMultimap.create();
	      if (equipmentSlot == EquipmentSlotType.MAINHAND) {
	         multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.getAttackDamage(), AttributeModifier.Operation.ADDITION));
	         multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)ATTACK_SPEED, AttributeModifier.Operation.ADDITION));
	      }

	      return multimap;
	   }
	
	

	

}
