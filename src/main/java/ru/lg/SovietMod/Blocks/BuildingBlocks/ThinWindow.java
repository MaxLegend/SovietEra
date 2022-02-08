package ru.lg.SovietMod.Blocks.BuildingBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.Blocks.Basic.BasicBlock;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockLogWCM;
import ru.lg.SovietMod.Blocks.Basic.BasicLogBlock;
import ru.lg.SovietMod.Blocks.DecorativeBlocks.BiolabTableUp.EnumState;

public class ThinWindow extends BasicBlockLogWCM {
	
	public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.<EnumFacing.Axis>create("axis", EnumFacing.Axis.class);
	

	
	public ThinWindow(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);

	}
	
	public static enum EnumAxis implements IStringSerializable {
		X("x"),
		Y("y"),
		Z("z"),
		NONE("none");

		private final String name;

		private EnumAxis(String name)
		{
			this.name = name;
		}

		public String toString()
		{
			return this.name;
		}

		public static ThinWindow.EnumAxis fromFacingAxis(EnumFacing.Axis axis)
		{
			switch (axis)
			{
			case X:
				return X;
			case Y:
				return Y;
			case Z:
				return Z;
			default:
				return NONE;
			}
		}

		public String getName()
		{
			return this.name;
		}
	}
	@Override
	public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis)
	{
		IBlockState state = world.getBlockState(pos);
		for (net.minecraft.block.properties.IProperty<?> prop : state.getProperties().keySet())
		{
			if (prop.getName().equals("axis"))
			{
				world.setBlockState(pos, state.cycleProperty(prop));
				return true;
			}
		}
		return false;
	}

	public IBlockState withRotation(IBlockState state, Rotation rot)
	{
		switch (rot)
		{
		case COUNTERCLOCKWISE_90:
		case CLOCKWISE_90:

			switch ((EnumFacing.Axis)state.getValue(AXIS))
			{
			case X:
				return state.withProperty(AXIS, EnumFacing.Axis.Z);
			case Z:
				return state.withProperty(AXIS, EnumFacing.Axis.X);
			default:
				return state;
			}

		default:
			return state;
		}
	}
	public IBlockState getStateFromMeta(int meta)
	{
		EnumFacing.Axis enumfacing$axis = EnumFacing.Axis.Y;
		int i = meta & 12;

		if (i == 4)
		{
			enumfacing$axis = EnumFacing.Axis.X;
		}
		else if (i == 8)
		{
			enumfacing$axis = EnumFacing.Axis.Z;
		}

		return this.getDefaultState().withProperty(AXIS, enumfacing$axis);
	}

	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		EnumFacing.Axis enumfacing$axis = (EnumFacing.Axis)state.getValue(AXIS);

		if (enumfacing$axis == EnumFacing.Axis.X)
		{
			i |= 4;
		}
		else if (enumfacing$axis == EnumFacing.Axis.Z)
		{
			i |= 8;
		}

		return i;
	}
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {AXIS});
	}
}
