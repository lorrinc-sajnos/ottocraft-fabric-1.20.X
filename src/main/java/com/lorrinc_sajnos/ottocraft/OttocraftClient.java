package com.lorrinc_sajnos.ottocraft;

import net.fabricmc.api.ClientModInitializer;

import static com.lorrinc_sajnos.ottocraft.block.ModBlocks.registerRenderLayers;

public class OttocraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        registerRenderLayers();
    }
}
