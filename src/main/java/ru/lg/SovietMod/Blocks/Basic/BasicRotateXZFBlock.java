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

public class BasicRotateXZFBlock extends Block
{
	public BasicRotateXZFBlock(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setSoundType(soundtype);
		this.setHardness(hardness);
		this.setResistance(resistanse);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.NORTH));
	}

	public static final PropertyEnum<BasicRotateXZFBlock.EnumOrientation> FACING = PropertyEnum.<BasicRotateXZFBlock.EnumOrientation>create("facing", BasicRotateXZFBlock.EnumOrientation.class);



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

	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		IBlockState iblockstate = this.getDefaultState();

		if (canAttachTo(worldIn, pos, facing))
		{
			return iblockstate.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.forFacings(facing, placer.getHorizontalFacing()));
		}
		else
		{
			for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
			{
				if (enumfacing != facing && canAttachTo(worldIn, pos, enumfacing))
				{
					return iblockstate.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.forFacings(enumfacing, placer.getHorizontalFacing()));
				}
			}

			
			{
				return iblockstate;
			}
		}
	}





	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		super.breakBlock(worldIn, pos, state);
	}

	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.byMetadata(meta & 7));
	}

	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		i = i | ((BasicRotateXZFBlock.EnumOrientation)state.getValue(FACING)).getMetadata();


		i |= 8;


		return i;
	}

    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        switch (rot)
        {
            case CLOCKWISE_180:

                switch ((BasicRotateXZFBlock.EnumOrientation)state.getValue(FACING))
                {
                    case EAST:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.WEST);
                    case WEST:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.EAST);
                    case SOUTH:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.NORTH);
                    case NORTH:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.SOUTH);
                    default:
                        return state;
                }

            case COUNTERCLOCKWISE_90:

                switch ((BasicRotateXZFBlock.EnumOrientation)state.getValue(FACING))
                {
                    case EAST:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.NORTH);
                    case WEST:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.SOUTH);
                    case SOUTH:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.EAST);
                    case NORTH:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.WEST);
                    case UP_Z:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.UP_X);
                    case UP_X:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.UP_Z);
                    case DOWN_X:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.DOWN_Z);
                    case DOWN_Z:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.DOWN_X);
                }

            case CLOCKWISE_90:

                switch ((BasicRotateXZFBlock.EnumOrientation)state.getValue(FACING))
                {
                    case EAST:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.SOUTH);
                    case WEST:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.NORTH);
                    case SOUTH:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.WEST);
                    case NORTH:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.EAST);
                    case UP_Z:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.UP_X);
                    case UP_X:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.UP_Z);
                    case DOWN_X:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.DOWN_Z);
                    case DOWN_Z:
                        return state.withProperty(FACING, BasicRotateXZFBlock.EnumOrientation.DOWN_X);
                }

            default:
                return state;
        }
    }

	public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	{
		return state.withRotation(mirrorIn.toRotation(((BasicRotateXZFBlock.EnumOrientation)state.getValue(FACING)).getFacing()));
	}

	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING});
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

        private static final BasicRotateXZFBlock.EnumOrientation[] META_LOOKUP = new BasicRotateXZFBlock.EnumOrientation[values().length];
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

        public static BasicRotateXZFBlock.EnumOrientation byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public static BasicRotateXZFBlock.EnumOrientation forFacings(EnumFacing clickedSide, EnumFacing entityFacing)
        {
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
                    return NORTH;
                case SOUTH:
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
            for (BasicRotateXZFBlock.EnumOrientation BasicRotateXZBlock$enumorientation : values())
            {
                META_LOOKUP[BasicRotateXZBlock$enumorientation.getMetadata()] = BasicRotateXZBlock$enumorientation;
            }
        }
    }
}
