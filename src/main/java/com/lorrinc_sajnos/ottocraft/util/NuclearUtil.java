package com.lorrinc_sajnos.ottocraft.util;

import com.lorrinc_sajnos.ottocraft.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class NuclearUtil {

    public static void applyRadiation(World world, LivingEntity livingEntity){

        livingEntity.damage(world.getDamageSources().magic(), 1.0f);

        livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100));
        livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 60));
        livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 100));
    }

    public static void nuclearExplosion(ServerWorld world, BlockPos pos, float power, int falloutRadius, float dustChance) {
        //The idea is, that when broken, the ore spawns dust around it, with a given chance (of course if it can be placed)
        //  [][][]
        //[][][][][]
        //[][]><[][]
        //[][][][][]
        //  [][][]

        //When center, place dust
        Random random = world.random;
        Vec3d expPos = pos.toCenterPos();
        world.createExplosion(null, expPos.x, expPos.y, expPos.z, power, false, World.ExplosionSourceType.BLOCK);

        for (int dx = -falloutRadius; dx <= falloutRadius; dx++) {
            for (int dz = -falloutRadius; dz <= falloutRadius; dz++) {
                //Roll the dice
                double chance = random.nextDouble();
                if (chance > dustChance) continue;

                BlockPos currPos = pos.add(dx, falloutRadius, dz);
                for (int dy = falloutRadius; dy >= -falloutRadius; dy--) {
                    BlockState currBlock = world.getBlockState(currPos);
                    BlockState under = world.getBlockState(currPos.down());
                    if (currBlock.isReplaceable() && under.isSolidBlock(world, pos)) {
                        world.setBlockState(currPos, ModBlocks.NUCLEAR_DUST_BLOCK.getDefaultState());
                        //world.playSound(currPos.getX(), currPos.getY(), currPos.getZ(), SoundEvents.BLOCK_SAND_PLACE, SoundCategory.BLOCKS, 4.0f, (1.0F + (random.nextFloat() - random.nextFloat()) * 0.2F) * 0.7F, false);
                        break;
                    }
                    currPos = currPos.down();
                }
            }
        }
    }
}
