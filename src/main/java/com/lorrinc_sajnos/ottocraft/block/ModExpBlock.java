package com.lorrinc_sajnos.ottocraft.block;

import com.lorrinc_sajnos.ottocraft.util.math.RandomIntProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModExpBlock extends Block {
    public ModExpBlock(Settings settings, IntProvider expProvider) {
        super(settings);
        this.expProvider = expProvider;
    }
    public ModExpBlock(Settings settings, int minXp, int maxXp) {
        this(settings,new RandomIntProvider(minXp,maxXp));
    }

    IntProvider expProvider;

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience) {
        super.onStacksDropped(state, world, pos, tool, dropExperience);
        if (dropExperience) {
            this.dropExperienceWhenMined(world, pos, tool, this.expProvider);
        }
    }
}
