package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockWithCustomModel;


public class BioStillage extends BasicBlockWithCustomModel {
	//сделать чтобы вращалось по xz  было три актуалстейта дойн мидл ап

	public static final PropertyBool DEFAULT = PropertyBool.create("def");
	public static final PropertyBool DOWN = PropertyBool.create("down");
	public static final PropertyBool MIDDLE = PropertyBool.create("middle");
	public static final PropertyBool UP = PropertyBool.create("up");
	public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.<EnumFacing.Axis>create("axis", EnumFacing.Axis.class);
	
	public BioStillage(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(DEFAULT, Boolean.TRUE));
	}
	  @SideOnly(Side.CLIENT)
	    public BlockRenderLayer getBlockLayer()
	    {
	        return BlockRenderLayer.CUTOUT_MIPPED;
	    }
	  
	  public static enum EnumAxis implements IStringSerializable {
			X("x"),
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

			public static EnumAxis fromFacingAxis(EnumFacing.Axis axis)
			{
				switch (axis)
				{
				case X:
					return X;
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
		public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
		{
			EnumFacing facing = EnumFacing.fromAngle(placer.getRotationYawHead());
			EnumFacing.Axis axis = facing.getAxis();
			world.setBlockState(pos, state.withProperty(AXIS, axis));
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



	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
	
		state = state.withProperty(AXIS, state.getValue(AXIS))
				.withProperty(DEFAULT, (!this.attachesToBlock(state, worldIn, pos.down()) && !this.attachesToBlock(state, worldIn, pos.up())))
				.withProperty(DOWN, (!this.attachesToBlock(state, worldIn, pos.down()) && this.attachesToBlock(state, worldIn, pos.up())))
				.withProperty(MIDDLE, (this.attachesToBlock(state, worldIn, pos.down()) && this.attachesToBlock(state, worldIn, pos.up())))
				.withProperty(UP, (this.attachesToBlock(state, worldIn, pos.down()) && !this.attachesToBlock(state, worldIn, pos.up())));
		

		return state;

	}
	
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {AXIS,DEFAULT,UP,DOWN,MIDDLE});
	}
	
	private boolean attachesToBlock(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		IBlockState statePos = world.getBlockState(pos);
		Block statePosBlock = world.getBlockState(pos).getBlock();

			return statePosBlock instanceof BioStillage;	

		

	}

}



