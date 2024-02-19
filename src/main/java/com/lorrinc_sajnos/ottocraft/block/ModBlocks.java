package com.lorrinc_sajnos.ottocraft.block;

import com.lorrinc_sajnos.ottocraft.Ottocraft;
import com.lorrinc_sajnos.ottocraft.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block URANIUM_ORE = registerBlock("uranium_ore", new ModBlock());

    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Ottocraft.MOD_ID, name), block);
    }


    public static void registerModItems() {
        Ottocraft.LOGGER.info("Registering mod BLOCKS for Ottocraft");

    }
}
