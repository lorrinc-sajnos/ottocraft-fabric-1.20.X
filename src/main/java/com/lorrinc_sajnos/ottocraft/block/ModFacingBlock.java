package com.lorrinc_sajnos.ottocraft.block;

import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;

public class ModFacingBlock extends ModBlock{

    public static final DirectionProperty FACING = Properties.FACING;
    public ModFacingBlock(Settings settings) {
        super(settings);
    }
}
