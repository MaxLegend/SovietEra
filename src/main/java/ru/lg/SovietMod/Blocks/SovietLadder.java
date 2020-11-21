package ru.lg.SovietMod.Blocks;

import net.minecraft.block.BlockLadder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.lg.SovietMod.SovietCore;

public class SovietLadder extends BlockLadder {
    protected static final AxisAlignedBB LADDER_EAST_AABB = new AxisAlignedBB(0D, 0.0D, 0.2D, 0.2D, 1.0D, 0.8D);
    protected static final AxisAlignedBB LADDER_WEST_AABB = new AxisAlignedBB(0.8D, 0.0D, 0.2D, 1D, 1.0D, 0.8D);
    protected static final AxisAlignedBB LADDER_SOUTH_AABB = new AxisAlignedBB(0.8D, 0.0D, 0.0D, 0.2D, 1.0D, 0.2D);
    protected static final AxisAlignedBB LADDER_NORTH_AABB = new AxisAlignedBB(0.2D, 0.0D, 0.8D, 0.8D, 1.0D, 1D);
	public SovietLadder(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		
	}
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        switch ((EnumFacing)state.getValue(FACING))
        {
            case NORTH:
                return LADDER_NORTH_AABB;
            case SOUTH:
                return LADDER_SOUTH_AABB;
            case WEST:
                return LADDER_WEST_AABB;
            case EAST:
            default:
                return LADDER_EAST_AABB;
        }
    }
}
