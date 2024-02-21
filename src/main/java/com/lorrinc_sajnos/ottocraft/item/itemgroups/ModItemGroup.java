package com.lorrinc_sajnos.ottocraft.item.itemgroups;

import com.lorrinc_sajnos.ottocraft.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.lorrinc_sajnos.ottocraft.Ottocraft.MOD_ID;

public class ModItemGroup {
    private final ItemGroup itemGroup;
    private final Supplier<ItemStack> iconSupplier;

    final List<Item> items;

    public ModItemGroup(String name, Supplier<ItemStack> iconSupplier){
        this.iconSupplier = iconSupplier;
        items= new ArrayList<>();
        itemGroup = Registry.register(Registries.ITEM_GROUP,
                new Identifier(MOD_ID,name),
                FabricItemGroup.builder().displayName(Text.translatable("itemgroups."+name))
                        .icon(iconSupplier)
                        .entries((this::registerItems))
                        .build()
        );
    }

    private void registerItems(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries){
        for(Item item : items){
            entries.add(item);
        }
    }

    public void addItem(Item item){
        items.add(item);
    }
    public ItemGroup getItemGroup() {
        return itemGroup;
    }
}
