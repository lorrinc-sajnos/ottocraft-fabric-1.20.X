package com.lorrinc_sajnos.ottocraft.registry;

import net.minecraft.block.Block;

public class ModRegistries {

    public static AbstractModRegistry<Block> MOD_BLOCKS;

    public void declareModRegistries(){
        MOD_BLOCKS = new BlockModRegistry();
    }
}
