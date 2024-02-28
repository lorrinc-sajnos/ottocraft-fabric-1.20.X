package com.lorrinc_sajnos.ottocraft.block;

import com.lorrinc_sajnos.ottocraft.Ottocraft;
import com.lorrinc_sajnos.ottocraft.item.ModItems;
import com.lorrinc_sajnos.ottocraft.item.itemgroups.ModItemGroup;
import com.lorrinc_sajnos.ottocraft.item.itemgroups.ModItemGroups;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ModBlocks {
    public static final Block URANIUM_ORE = registerBlock("uranium_ore", new UraniumOreBlock(), ModItemGroups.MOD_INGREDIENTS);
    public static final Block NUCLEAR_DUST_BLOCK = registerBlockNoItem("nuclear_dust_block", new NuclearDustBlock(),RenderLayer.getTranslucent());





    private static HashMap<String, Item> blockItems = new HashMap<>();
    private static List<Pair<Block,RenderLayer>> blockRenderLayers;

    private static Block registerBlock(String name, Block block, ModItemGroup group){
        registerBlockNoItem(name,block);
        registerBlockItem(name,block,group);
        return block;
    }
    private static Block registerBlock(String name, Block block, ModItemGroup group, RenderLayer renderLayer){
        registerBlockLayer(block,renderLayer);
        registerBlockNoItem(name,block,renderLayer);
        registerBlockItem(name,block,group);
        return block;
    }

    private static Block registerBlockNoItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Ottocraft.MOD_ID, name), block);
    }
    private static Block registerBlockNoItem(String name, Block block, RenderLayer renderLayer) {
        registerBlockLayer(block,renderLayer);

        return registerBlockNoItem(name,block);
    }



    private static void registerBlockItem(String name, Block block, ModItemGroup group){
        Item item = ModItems.registerItem(name, new BlockItem(block, new FabricItemSettings()),group);

        //Null-guard idk why this happens, it is frustating and I have no other idea, I guess it slowes down item registration
        //a bit, but I guess it's no big deal
        if(blockItems==null)
            blockItems=new HashMap<>();

        blockItems.put(name, item);
    }

    private static void registerBlockLayer(Block block, RenderLayer layer){
        //No clue why I neeed this but okay
        if(blockRenderLayers==null)
            blockRenderLayers=new LinkedList<>();

        blockRenderLayers.add(new Pair<>(block,layer));

    }

    public static Item getItem(String name){
        return blockItems.get(name);
    }



    public static void registerModBlocks() {
        Ottocraft.LOGGER.info("Registering mod BLOCKS for Ottocraft");
        blockItems = new HashMap<>();
    }

    public static void registerRenderLayers() {
        for(Pair<Block,RenderLayer> pair : blockRenderLayers){
            Block block = pair.getLeft();
            RenderLayer layer = pair.getRight();
            BlockRenderLayerMap.INSTANCE.putBlock(block,layer);
        }
    }
}
