package ru.lg.SovietMod.Blocks.Basic;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.SovietCore;
import ru.lg.SovietMod.API.BasicMetadataBlock;
import ru.lg.SovietMod.API.MetadataContainer;

public class BasicRotateXZBlock extends BasicMetadataBlock
{
	public BasicRotateXZBlock(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, resistanse, resistanse, soundtype, SovietCore.tabInsDeco);
	//	this.setRegistryName(name);
	//	this.setUnlocalizedName(name);
	//	this.setSoundType(soundtype);
	//	this.setHardness(hardness);
	//	this.setResistance(resistanse);
	//	this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, BasicRotateXZBlock.EnumOrientation.NORTH));
		
	}

	public static final PropertyEnum<BasicRotateXZBlock.EnumOrientation> FACING = PropertyEnum.<BasicRotateXZBlock.EnumOrientation>create("facing", BasicRotateXZBlock.EnumOrientation.class);


	protected static final AxisAlignedBB UP_X_AABB = new AxisAlignedBB(0D, 0D, 0.4D, 1D, 1D, 0.6D);
	protected static final AxisAlignedBB UP_Z_AABB = new AxisAlignedBB(0.4D, 0D, 0D, 0.6D, 1D, 1D);
	protected static final AxisAlignedBB DOWN_X_AABB = new AxisAlignedBB(0D, 0D, 0.4D, 1D, 1D, 0.6D);
	protected static final AxisAlignedBB DOWN_Z_AABB = new AxisAlignedBB(0.4D, 0D, 0D, 0.6D, 1D, 1D);


	    public static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.625D, 0.625D, 1.5D, 1.0D);
	    public static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.375D, 0.375D, 1.5D, 0.625D);
	    public static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.0D, 0.625D, 1.5D, 0.375D);
	    public static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.625D, 0.0D, 0.375D, 1.0D, 1.5D, 0.625D);



	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side)
	{
		return true;
	}

	protected static boolean canAttachTo(World worldIn, BlockPos p_181090_1_, EnumFacing p_181090_2_)
	{
		return canPlaceBlock(worldIn, p_181090_1_, p_181090_2_);
	}
	protected static boolean canPlaceBlock(World worldIn, BlockPos pos, EnumFacing direction)
	{
		BlockPos blockpos = pos.offset(direction.getOpposite());
		IBlockState iblockstate = worldIn.getBlockState(blockpos);
		boolean flag = iblockstate.getBlockFaceShape(worldIn, blockpos, direction) == BlockFaceShape.UNDEFINED;
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

	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		IBlockState iblockstate = this.getDefaultState();

		if (canAttachTo(worldIn, pos, facing))
		{
			
			return iblockstate.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.forFacings(facing, placer.getHorizontalFacing()));
		}
		else
		{
			for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
			{
				if (enumfacing != facing && canAttachTo(worldIn, pos, enumfacing))
				{
					System.out.println("ff" + placer.getHorizontalFacing() + " " + BasicRotateXZBlock.EnumOrientation.forFacings(enumfacing, placer.getHorizontalFacing()));
					return iblockstate.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.forFacings(enumfacing, placer.getHorizontalFacing()));
				}
			}

			
			{
				return iblockstate;
			}
		}
	}



	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch ((BasicRotateXZBlock.EnumOrientation)state.getValue(FACING))
		{
		case EAST:
		default:
			return EAST_AABB;
		case WEST:
			return WEST_AABB;
		case SOUTH:
			return SOUTH_AABB;
		case NORTH:
			return NORTH_AABB;

		case DOWN_X:
			return DOWN_X_AABB;
		case UP_X:
			return UP_X_AABB;
		case DOWN_Z:
			return DOWN_Z_AABB;
		case UP_Z:
			return UP_Z_AABB;
		}
	}

	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		super.breakBlock(worldIn, pos, state);
	}



    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        switch (rot)
        {
            case CLOCKWISE_180:

                switch ((BasicRotateXZBlock.EnumOrientation)state.getValue(FACING))
                {
                    case EAST:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.WEST);
                    case WEST:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.EAST);
                    case SOUTH:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.NORTH);
                    case NORTH:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.SOUTH);
                    default:
                        return state;
                }

            case COUNTERCLOCKWISE_90:

                switch ((BasicRotateXZBlock.EnumOrientation)state.getValue(FACING))
                {
                    case EAST:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.NORTH);
                    case WEST:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.SOUTH);
                    case SOUTH:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.EAST);
                    case NORTH:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.WEST);
                    case UP_Z:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.UP_X);
                    case UP_X:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.UP_Z);
                    case DOWN_X:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.DOWN_Z);
                    case DOWN_Z:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.DOWN_X);
                }

            case CLOCKWISE_90:

                switch ((BasicRotateXZBlock.EnumOrientation)state.getValue(FACING))
                {
                    case EAST:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.SOUTH);
                    case WEST:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.NORTH);
                    case SOUTH:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.WEST);
                    case NORTH:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.EAST);
                    case UP_Z:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.UP_X);
                    case UP_X:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.UP_Z);
                    case DOWN_X:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.DOWN_Z);
                    case DOWN_Z:
                        return state.withProperty(FACING, BasicRotateXZBlock.EnumOrientation.DOWN_X);
                }

            default:
                return state;
        }
    }

	public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	{
		return state.withRotation(mirrorIn.toRotation(((BasicRotateXZBlock.EnumOrientation)state.getValue(FACING)).getFacing()));
	}


	
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	{
		return BlockFaceShape.UNDEFINED;
	}

    public static enum EnumOrientation implements IStringSerializable
    {
        DOWN_X(0, "down_x", EnumFacing.DOWN),
        EAST(1, "east", EnumFacing.EAST),
        WEST(2, "west", EnumFacing.WEST),
        SOUTH(3, "south", EnumFacing.SOUTH),
        NORTH(4, "north", EnumFacing.NORTH),
        UP_Z(5, "up_z", EnumFacing.UP),
        UP_X(6, "up_x", EnumFacing.UP),
        DOWN_Z(7, "down_z", EnumFacing.DOWN);

        private static final BasicRotateXZBlock.EnumOrientation[] META_LOOKUP = new BasicRotateXZBlock.EnumOrientation[values().length];
        private final int meta;
        private final String name;
        private final EnumFacing facing;

        private EnumOrientation(int meta, String name, EnumFacing facing)
        {
            this.meta = meta;
            this.name = name;
            this.facing = facing;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public EnumFacing getFacing()
        {
            return this.facing;
        }

        public String toString()
        {
            return this.name;
        }

        public static BasicRotateXZBlock.EnumOrientation byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public static BasicRotateXZBlock.EnumOrientation forFacings(EnumFacing clickedSide, EnumFacing entityFacing)
        {
        	
        	System.out.println("clickedSide " + clickedSide + " entityFacing " + entityFacing);
            switch (clickedSide)
            {
                case DOWN:

                    switch (entityFacing.getAxis())
                    {
                        case X:
                            return DOWN_X;
                        case Z:
                            return DOWN_Z;
                        default:
                            throw new IllegalArgumentException("Invalid entityFacing " + entityFacing + " for facing " + clickedSide);
                    }

                case UP:

                    switch (entityFacing.getAxis())
                    {
                        case X:
                            return UP_X;
                        case Z:
                            return UP_Z;
                        default:
                            throw new IllegalArgumentException("Invalid entityFacing " + entityFacing + " for facing " + clickedSide);
                    }

                case NORTH:
                	System.out.println("north");
                    return NORTH;
                case SOUTH:
                	System.out.println("south");
                    return SOUTH;
                case WEST:
                    return WEST;
                case EAST:
                    return EAST;
                default:
                    throw new IllegalArgumentException("Invalid facing: " + clickedSide);
            }
        }

        public String getName()
        {
            return this.name;
        }

        static
        {
            for (BasicRotateXZBlock.EnumOrientation BasicRotateXZBlock$enumorientation : values())
            {
                META_LOOKUP[BasicRotateXZBlock$enumorientation.getMetadata()] = BasicRotateXZBlock$enumorientation;
            }
        }
    }

	@Override
	protected IProperty<?>[] createBlockProperties() {
		
		return new IProperty<?>[] {FACING};
	}

	@Override
	protected IBlockState createDefaultState() {
		
		return this.blockState.getBaseState().withProperty(FACING, BasicRotateXZBlock.EnumOrientation.NORTH);
	}
}