package com.lorrinc_sajnos.ottocraft.registry;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;

import static com.lorrinc_sajnos.ottocraft.Ottocraft.MOD_ID;

public abstract class AbstractModRegistry<T> {
    private final HashMap<String, T> OBJECTS = new HashMap<>();
    protected Registry<T> registry;
    protected void add(String name, T obj){
        Registry.register(registry, new Identifier(MOD_ID, name), obj);
        OBJECTS.put(name,obj);
    }

    public T get(String name){
        return OBJECTS.get(name);
    }

}
