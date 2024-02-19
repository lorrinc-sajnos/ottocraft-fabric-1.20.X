package com.lorrinc_sajnos.ottocraft.item.itemgroups;

import com.lorrinc_sajnos.ottocraft.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.lorrinc_sajnos.ottocraft.Ottocraft.MOD_ID;

public class ModItemGroups {
    public static final ItemGroup MOD_INGREDIENTS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MOD_ID,"otc_ingredients"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroups.otc_ingredients"))
                    .icon(() -> new ItemStack(ModItems.RAW_URANIUM_ORE))
                    .entries( ((displayContext, entries) -> {

                    }))
                    .build()
    );
}
