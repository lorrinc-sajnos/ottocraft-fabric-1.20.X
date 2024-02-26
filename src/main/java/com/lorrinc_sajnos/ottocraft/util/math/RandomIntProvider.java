package com.lorrinc_sajnos.ottocraft.util.math;

import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.IntProviderType;
import net.minecraft.util.math.random.Random;

public class RandomIntProvider extends IntProvider {

    public RandomIntProvider(int min, int max) {
        this.min = min;
        this.max = max;
    }

    int min,max;
    @Override
    public int get(Random random) {
        return random.nextBetween(min,max);
    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public int getMax() {
        return max;
    }

    @Override
    public IntProviderType<?> getType() {
        return null;
    }
}
