package com.lorrinc_sajnos.ottocraft.block;

import com.lorrinc_sajnos.ottocraft.util.NuclearUtil;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class UraniumOreBlock extends ModExpBlock{
    public UraniumOreBlock() {
        super(
                FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).luminance(2).emissiveLighting(Blocks::always).strength(6f, 1200f), 6, 10
        );
    }
    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        player.incrementStat(Stats.MINED.getOrCreateStat(this));
        player.addExhaustion(0.005f);

        //If on the server side, and NOT using silk-touch, explode, THEN place item drops!
        if (!world.isClient && EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, tool) == 0) {
            NuclearUtil.nuclearExplosion((ServerWorld) world,pos,12f,5,0.33f);
        }
        Block.dropStacks(state, world, pos, blockEntity, player, tool);
    }
}
