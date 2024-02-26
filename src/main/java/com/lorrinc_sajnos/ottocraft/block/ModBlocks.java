package com.lorrinc_sajnos.ottocraft.block;

import com.lorrinc_sajnos.ottocraft.Ottocraft;
import com.lorrinc_sajnos.ottocraft.item.ModItems;
import com.lorrinc_sajnos.ottocraft.item.itemgroups.ModItemGroup;
import com.lorrinc_sajnos.ottocraft.item.itemgroups.ModItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class ModBlocks {
    public static final Block URANIUM_ORE = registerBlock("uranium_ore", new ModExpBlock(FabricBlockSettings.copyOf(Blocks.MAGMA_BLOCK).luminance(5),2,5), ModItemGroups.MOD_INGREDIENTS);





    private static HashMap<String, Item> blockItems = new HashMap<>();
    private static Block registerBlock(String name, Block block, ModItemGroup group){
        registerBlockNoItem(name,block);
        registerBlockItem(name,block,group);
        return block;
    }
    private static Block registerBlockNoItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Ottocraft.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block, ModItemGroup group){
        Item item = ModItems.registerItem(name, new BlockItem(block, new FabricItemSettings()),group);

        //Null-guard 8idk why this happens, it is frustating and I have no other idea, I guess it slowes down item registration
        //a bit, but I guess it's no big deal
        if(blockItems==null)
            blockItems=new HashMap<>();

        blockItems.put(name, item);
    }

    public static Item getItem(String name){
        return blockItems.get(name);
    }

    public static void registerModBlocks() {
        Ottocraft.LOGGER.info("Registering mod BLOCKS for Ottocraft");
        blockItems = new HashMap<>();
    }
}
