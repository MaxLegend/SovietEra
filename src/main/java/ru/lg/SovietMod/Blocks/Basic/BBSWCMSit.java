package ru.lg.SovietMod.Blocks.Basic;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.Util.SittableUtil;

public class BBSWCMSit extends BasicBlockSideWithCustomModel{
	public BBSWCMSit(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		// TODO Auto-generated constructor stub
	}
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0D, 1D, 0.6D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 0.6D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 0.6D, 1D),
			new AxisAlignedBB(0D, 0D, 0D, 1D, 0.6D, 1D)
	};
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!playerIn.isSneaking())
		{
			if(SittableUtil.sitOnBlock(worldIn, pos.getX(), pos.getY(), pos.getZ(), playerIn, 7 * 0.0625))
			{
				worldIn.updateComparatorOutputLevel(pos, this);
				return true;
			}
		}
		return false;
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
