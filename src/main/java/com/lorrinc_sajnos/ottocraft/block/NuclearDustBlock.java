package com.lorrinc_sajnos.ottocraft.block;

import com.lorrinc_sajnos.ottocraft.util.NuclearUtil;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;


public class NuclearDustBlock extends ModFallingBlock{
    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);


    public NuclearDustBlock() {
        super(
                FabricBlockSettings.copyOf(Blocks.MOSS_CARPET).luminance(5).emissiveLighting(Blocks::always).sounds(BlockSoundGroup.SAND).noCollision()
                );
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }


    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity)  {
        if (!entity.bypassesSteppingEffects() && entity instanceof LivingEntity) {

            NuclearUtil.applyRadiation(world,(LivingEntity)entity);

        }
        super.onEntityCollision(state,  world,  pos,  entity);
    }

}
