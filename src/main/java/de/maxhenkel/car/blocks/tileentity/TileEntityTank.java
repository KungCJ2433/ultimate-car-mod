package de.maxhenkel.car.blocks.tileentity;

import de.maxhenkel.car.Main;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nonnull;

public class TileEntityTank extends TileEntityBase implements IFluidHandler, ITickableTileEntity {

    private FluidStack fluid;
    public static final int CAPACITY = 16000;

    public TileEntityTank() {
        super(Main.TANK_TILE_ENTITY_TYPE);
        this.fluid = FluidStack.EMPTY;
    }

    @Override
    public void tick() {
        if (!world.isRemote) {
            if (world.getGameTime() % 20 == 0) {
                synchronize();
            }
        } else {
            updateClientSide();
        }

        if (fluid.isEmpty()) {
            return;
        }

        checkDown();

        for (Direction facing : Direction.Plane.HORIZONTAL) {
            if (fluid.isEmpty()) {
                return;
            }
            checkSide(facing);
        }
    }

    public void checkSide(Direction side) {
        TileEntity te = world.getTileEntity(pos.offset(side));

        if (!(te instanceof TileEntityTank)) {
            return;
        }

        TileEntityTank otherTank = (TileEntityTank) te;

        FluidStack other = otherTank.getFluid();

        if (!(other.getFluid().equals(fluid.getFluid()) || other.isEmpty())) {
            return;
        }

        int dif = other.getAmount() - fluid.getAmount();

        if (dif >= -2) {
            return;
        }

        FluidUtil.tryFluidTransfer(otherTank, this, (-dif) / 2, true);
    }

    public void checkDown() {
        TileEntity te = world.getTileEntity(pos.down());

        if (!(te instanceof TileEntityTank)) {
            return;
        }

        TileEntityTank otherTank = (TileEntityTank) te;

        FluidStack stack = FluidUtil.tryFluidTransfer(otherTank, this, Integer.MAX_VALUE, true);

        if (stack.isEmpty()) {
            return;
        }

        if (!fluid.isEmpty() && fluid.getAmount() <= 0) {
            fluid = FluidStack.EMPTY;
        }
    }

    public float getFillPercent() {
        if (fluid.isEmpty()) {
            return 0F;
        }

        return ((float) fluid.getAmount()) / ((float) CAPACITY);
    }

    public FluidStack getFluid() {
        return fluid;
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        if (!fluid.isEmpty() && fluid.getAmount() > 0) {
            CompoundNBT comp = new CompoundNBT();

            fluid.writeToNBT(comp);

            compound.put("fluid", comp);
        }
        return super.write(compound);
    }

    @Override
    public void read(BlockState blockState, CompoundNBT compound) {
        if (compound.contains("fluid")) {
            CompoundNBT comp = compound.getCompound("fluid");
            fluid = FluidStack.loadFluidStackFromNBT(comp);
        } else {
            fluid = FluidStack.EMPTY;
        }
        super.read(blockState, compound);
    }

    public void setFluid(FluidStack fluid) {
        this.fluid = fluid;
    }


    @Override
    public ITextComponent getTranslatedName() {
        return new TranslationTextComponent("block.car.tank");
    }

    @Override
    public IIntArray getFields() {
        return new IntArray(0);
    }

    private boolean[] sides = new boolean[Direction.values().length];

    private boolean[] sidesFluid = new boolean[Direction.values().length];

    @OnlyIn(Dist.CLIENT)
    private void recalculateSides() {
        for (Direction facing : Direction.values()) {
            sides[facing.getIndex()] = isTankConnectedCalc(facing);
            sidesFluid[facing.getIndex()] = isFluidConnectedCalc(facing);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private boolean isFluidConnectedCalc(Direction facing) {
        TileEntity te = world.getTileEntity(pos.offset(facing));
        if (te instanceof TileEntityTank) {
            TileEntityTank tank = (TileEntityTank) te;
            if (tank.fluid.isEmpty() || fluid.isEmpty()) {
                return false;
            }

            if (tank.fluid.getFluid().equals(fluid.getFluid())) {
                if (facing.equals(Direction.UP)) {
                    if (fluid.getAmount() >= CAPACITY) {
                        return true;
                    } else {
                        return false;
                    }
                }
                return true;
            }
        }

        BlockState s = world.getBlockState(pos.offset(facing));
        if (s.isNormalCube(world, pos.offset(facing))) {
            if (facing.equals(Direction.UP)) {
                return fluid.getAmount() >= CAPACITY;
            }
            return true;
        }
        return false;
    }


    @OnlyIn(Dist.CLIENT)
    private boolean isTankConnectedCalc(Direction facing) {
        TileEntity te = world.getTileEntity(pos.offset(facing));
        if (te instanceof TileEntityTank) {
            TileEntityTank tank = (TileEntityTank) te;
            if (tank.fluid.isEmpty() && fluid.isEmpty()) {
                return true;
            }

            if (tank.fluid.isEmpty() || fluid.isEmpty()) {
                return true;
            }

            return tank.fluid.getFluid().equals(fluid.getFluid());
        }
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    private void updateClientSide() {
        recalculateSides();
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isTankConnectedTo(Direction facing) {
        return sides[facing.getIndex()];
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isFluidConnected(Direction facing) {
        return sidesFluid[facing.getIndex()];
    }

    @Override
    public int getTanks() {
        return 1;
    }

    @Nonnull
    @Override
    public FluidStack getFluidInTank(int tank) {
        return fluid;
    }

    @Override
    public int getTankCapacity(int tank) {
        return CAPACITY;
    }

    @Override
    public boolean isFluidValid(int tank, @Nonnull FluidStack stack) {
        return true;
    }

    @Override
    public int fill(FluidStack resource, FluidAction action) {
        if (fluid.isEmpty()) {
            int amount = Math.min(resource.getAmount(), CAPACITY);

            if (action.execute()) {
                fluid = new FluidStack(resource.getFluid(), amount);
                markDirty();
            }

            return amount;
        } else if (resource.getFluid().equals(fluid.getFluid())) {
            int amount = Math.min(resource.getAmount(), CAPACITY - fluid.getAmount());

            if (action.execute()) {
                fluid.setAmount(fluid.getAmount() + amount);
                markDirty();
            }

            return amount;
        }
        return 0;
    }

    @Nonnull
    @Override
    public FluidStack drain(FluidStack resource, FluidAction action) {
        if (fluid.isEmpty()) {
            return FluidStack.EMPTY;
        }

        if (fluid.getFluid().equals(resource.getFluid())) {
            int amount = Math.min(resource.getAmount(), fluid.getAmount());

            Fluid f = fluid.getFluid();

            if (action.execute()) {
                fluid.setAmount(fluid.getAmount() - amount);
                if (fluid.getAmount() <= 0) {
                    fluid = FluidStack.EMPTY;
                }
                markDirty();
            }

            return new FluidStack(f, amount);
        }

        return FluidStack.EMPTY;
    }

    @Nonnull
    @Override
    public FluidStack drain(int maxDrain, FluidAction action) {
        if (fluid.isEmpty()) {
            return FluidStack.EMPTY;
        }

        int amount = Math.min(maxDrain, fluid.getAmount());

        Fluid f = fluid.getFluid();

        if (action.execute()) {
            fluid.setAmount(fluid.getAmount() - amount);
            if (fluid.getAmount() <= 0) {
                fluid = FluidStack.EMPTY;
            }
            markDirty();
        }

        return new FluidStack(f, amount);
    }

}
