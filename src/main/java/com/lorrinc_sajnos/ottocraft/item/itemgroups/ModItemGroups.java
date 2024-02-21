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
    public static final ModItemGroup MOD_INGREDIENTS = new ModItemGroup("otc_ingredients", () -> new ItemStack(ModItems.RUBY_INGOT));
}
