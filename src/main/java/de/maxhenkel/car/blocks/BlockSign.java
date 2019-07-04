package de.maxhenkel.car.blocks;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.maxhenkel.car.Main;
import de.maxhenkel.car.ModCreativeTabs;
import de.maxhenkel.car.blocks.tileentity.TileEntitySign;
import de.maxhenkel.car.gui.ContainerSign;
import de.maxhenkel.car.gui.TileEntityContainerProvider;
import de.maxhenkel.tools.BlockTools;
import de.maxhenkel.tools.IItemBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IEnviromentBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Map;

public class BlockSign extends BlockBase implements ITileEntityProvider, IItemBlock {

    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);

    public BlockSign() {
        super(Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(20F).sound(SoundType.METAL));
        setRegistryName(new ResourceLocation(Main.MODID, "sign"));

        setDefaultState(stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public Item toItem() {
        return new BlockItem(this, new Item.Properties().group(ModCreativeTabs.TAB_CAR)).setRegistryName(this.getRegistryName());
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        TileEntity te = worldIn.getTileEntity(pos);

        if (!(te instanceof TileEntitySign)) {
            return false;
        }
        TileEntitySign sign = (TileEntitySign) te;
        if (player instanceof ServerPlayerEntity) {
            TileEntityContainerProvider.openGui((ServerPlayerEntity) player, sign, (i, playerInventory, playerEntity) -> new ContainerSign(i, sign));
        }
        return true;
    }

    private static final VoxelShape SHAPE_NORTH_SOUTH = Block.makeCuboidShape(0D, 3D, 7.5D, 16D, 13D, 8.5D);
    private static final VoxelShape SHAPE_EAST_WEST = Block.makeCuboidShape(7.5D, 3D, 0D, 8.5D, 13D, 16D);
    private static final VoxelShape SHAPE_POST = Block.makeCuboidShape(7.5D, 0D, 7.5D, 8.5D, 3D, 8.5D);

    private static final Map<Direction, VoxelShape> SHAPES = Maps.newEnumMap(ImmutableMap.of(
            Direction.NORTH,
            BlockTools.combine(SHAPE_NORTH_SOUTH, SHAPE_POST),
            Direction.SOUTH,
            BlockTools.combine(SHAPE_NORTH_SOUTH, SHAPE_POST),
            Direction.EAST,
            BlockTools.combine(SHAPE_EAST_WEST, SHAPE_POST),
            Direction.WEST,
            BlockTools.combine(SHAPE_EAST_WEST, SHAPE_POST)
    ));

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES.get(state.get(FACING));
    }

    @Override
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
    }

    @Override
    public boolean doesSideBlockRendering(BlockState state, IEnviromentBlockReader world, BlockPos pos, Direction face) {
        return false;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntitySign();
    }
}
