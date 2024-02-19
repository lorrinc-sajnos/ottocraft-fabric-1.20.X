package com.lorrinc_sajnos.ottocraft.item;

import com.lorrinc_sajnos.ottocraft.Ottocraft;
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
    public enum ModItemGroups {
        INGREDIENT,
        MODTAB;

        private final List<Item> items;
        //private final RegistryKey<ItemGroup> group;
        private ModItemGroups() {
            this(ItemGroups.INGREDIENTS);
        }

        private ModItemGroups(RegistryKey<ItemGroup> group){
            items = new ArrayList<>();

            ItemGroupEvents.modifyEntriesEvent(group).register((FabricItemGroupEntries entry) -> addItemsToGroup(entry, items));
        }
        private static void addItemsToGroup(FabricItemGroupEntries entries, List<Item> group) {
            for (Item item : group) {
                entries.add(item);
            }
        }
        void add(Item item){
            items.add(item);
        }
    }


    public static final Item RAW_URANIUM_ORE = registerItem("raw_uranium_ore", new ModItem(), ModItemGroups.INGREDIENT);
    public static final Item POLISHED_LUNAR_CRYSTAL = registerItem("polished_lunar_crystal", new ModItem(), ModItemGroups.INGREDIENT);
    public static final Item RUBY_INGOT = registerItem("ruby_ingot", new ModItem(), ModItemGroups.INGREDIENT);
    public static final Item CHEESE = registerItem("cheese", new ModItem(), ModItemGroups.INGREDIENT);




    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Ottocraft.MOD_ID, name), item);
    }

    private static Item registerItem(String name, Item item, ModItemGroups group) {
        Item result = registerItem(name, item);
        group.add(result);
        return result;
    }

    public static void registerModItems() {
        Ottocraft.LOGGER.info("Registering mod ITEMS for Ottocraft");

    }
}
