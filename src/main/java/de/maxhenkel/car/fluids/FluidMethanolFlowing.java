package de.maxhenkel.car.fluids;

import de.maxhenkel.car.Main;
import de.maxhenkel.car.blocks.ModBlocks;
import de.maxhenkel.car.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class FluidMethanolFlowing extends CarFluid.Flowing {

    public FluidMethanolFlowing() {
        super(new ResourceLocation(Main.MODID, "methanol_flowing"), new ResourceLocation(Main.MODID, "block/methanol_still"), new ResourceLocation(Main.MODID, "block/methanol_flowing"));
    }

    @Override
    public Item getFilledBucket() {
        return ModItems.METHANOL_BUCKET;
    }

    @Override
    public Block getFluidBlock() {
        return ModBlocks.METHANOL;
    }

    @Override
    public Fluid getEquivalent() {
        return ModFluids.METHANOL;
    }
}
