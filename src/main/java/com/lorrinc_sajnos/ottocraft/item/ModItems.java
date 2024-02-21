package com.lorrinc_sajnos.ottocraft.item;

import com.lorrinc_sajnos.ottocraft.Ottocraft;
import com.lorrinc_sajnos.ottocraft.item.itemgroups.ModItemGroup;
import com.lorrinc_sajnos.ottocraft.item.itemgroups.ModItemGroups;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;


public class ModItems {


    public static final Item RAW_URANIUM_ORE = registerItem("raw_uranium_ore", new ModItem(), ModItemGroups.MOD_INGREDIENTS);
    public static final Item POLISHED_LUNAR_CRYSTAL = registerItem("polished_lunar_crystal", new ModItem(), ModItemGroups.MOD_INGREDIENTS);
    public static final Item RUBY_INGOT = registerItem("ruby_ingot", new ModItem(), ModItemGroups.MOD_INGREDIENTS);
    public static final Item CHEESE = registerItem("cheese", new ModItem(), ModItemGroups.MOD_INGREDIENTS);




    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Ottocraft.MOD_ID, name), item);
    }

    public static Item registerItem(String name, Item item, ModItemGroup group) {
        Item result = registerItem(name, item);
        group.addItem(result);
        return result;
    }

    public static void registerModItems() {
        Ottocraft.LOGGER.info("Registering mod ITEMS for Ottocraft");

    }
}
