package ru.lg.SovietMod.Blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.lg.SovietMod.RegItems;
import ru.lg.SovietMod.SovietCore;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class BlockRubbish extends BasicBlockSideWithCustomModel{
	protected static final AxisAlignedBB moss_AABB = new AxisAlignedBB(0.7D, 1D, 0.7D, 0.3D, 0.85D, 0.3D);
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0.0D, 0D, 1D, 0.05D, 1D),
			new AxisAlignedBB(0D, 0.0D, 0D, 1D, 0.05D, 1D),
			new AxisAlignedBB(0D, 0.0D, 0D, 1D, 0.05D, 1D),
			new AxisAlignedBB(0D, 0.0D, 0D, 1D, 0.05D, 1D)

	};
	public BlockRubbish(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setCreativeTab(SovietCore.tabMain);
	}
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return RegItems.armature;
    }
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return this.SIDE_AABB[0];
		case NORTH:
		default:
			return this.SIDE_AABB[1];
		case WEST:
			return this.SIDE_AABB[2];
		case EAST:
			return this.SIDE_AABB[3];
		}
	}
}
