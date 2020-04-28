package ru.lg.SovietMod.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockWithCustomModel;

public class BlockBetonRalling extends BasicBlockWithCustomModel {
	public static final PropertyDirection FACING = PropertyDirection.create("facing");

	protected static final AxisAlignedBB moss_AABB = new AxisAlignedBB(0.7D, 1D, 0.7D, 0.3D, 0.85D, 0.3D);
	private static AxisAlignedBB SIDE_AABB = new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D);
	
	public BlockBetonRalling(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if(entityIn.collidedVertically) {
			 entityIn.attackEntityFrom(DamageSource.CACTUS, 1.0F);
		}
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return this.SIDE_AABB;
		case NORTH:
		default:
			return this.SIDE_AABB;
		case WEST:
			return this.SIDE_AABB;
		case EAST:
			return this.SIDE_AABB;
		case UP:
			return this.SIDE_AABB;
		case DOWN:
			return this.SIDE_AABB;
		}
	}
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;

		switch ((EnumFacing)state.getValue(FACING))
		{
		case EAST:
			i = i | 1;
			break;
		case WEST:
			i = i | 2;
			break;
		case SOUTH:
			i = i | 3;
			break;
		case NORTH:
			i = i | 4;
			break;
		case DOWN:
			i = i | 5;
			break;
		case UP:
		default:
			i = i | 6;
		}

		return i;
	}
	public IBlockState getStateFromMeta(int meta)
	{
		IBlockState iblockstate = this.getDefaultState();

		switch (meta)
		{
		case 1:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.EAST);
			break;
		case 2:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.WEST);
			break;
		case 3:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.SOUTH);
			break;
		case 4:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.NORTH);
			break;
		case 5:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.DOWN);
			break;
		case 6:
		default:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.UP);
		}

		return iblockstate;
	}
	   protected static boolean canPlaceBlock(World worldIn, BlockPos pos, EnumFacing direction)
	    {
	        BlockPos blockpos = pos.offset(direction.getOpposite());
	        IBlockState iblockstate = worldIn.getBlockState(blockpos);
	        boolean flag = iblockstate.getBlockFaceShape(worldIn, blockpos, direction) == BlockFaceShape.SOLID;
	        Block block = iblockstate.getBlock();

	        if (direction == EnumFacing.UP)
	        {
	            return iblockstate.isTopSolid() || !isExceptionBlockForAttaching(block) && flag;
	        }
	        else
	        {
	            return !isExceptBlockForAttachWithPiston(block) && flag;
	        }
	    }
		  @SideOnly(Side.CLIENT)
		    public BlockRenderLayer getBlockLayer()
		    {
		        return BlockRenderLayer.CUTOUT_MIPPED;
		    }
	@Override
	  public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return canPlaceBlock(worldIn, pos, facing) ? this.getDefaultState().withProperty(FACING, facing) : this.getDefaultState().withProperty(FACING, EnumFacing.DOWN);
    }

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING});
	}
}
