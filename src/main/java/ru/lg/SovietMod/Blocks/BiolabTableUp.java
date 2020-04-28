package ru.lg.SovietMod.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;
import ru.lg.SovietMod.Blocks.BiolabTableUp.EnumState;

public class BiolabTableUp extends BasicBlockSideWithCustomModel {
	private static AxisAlignedBB AABB = new AxisAlignedBB(0, 0, 0, 1, 1, 1);
	public static final PropertyEnum<EnumState> STATES = PropertyEnum.<EnumState>create("states", EnumState.class);
	public BiolabTableUp(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(STATES, EnumState.DEF));
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos)
    {
		if(state.getValue(FACING) == EnumFacing.EAST) {
			if(world.getBlockState(pos.north()).getBlock() != this && world.getBlockState(pos.south()).getBlock() != this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.DEF);
			} 
			else if(world.getBlockState(pos.north()).getBlock() == this && world.getBlockState(pos.south()).getBlock() == this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.CENTER);
			}
			else if(world.getBlockState(pos.north()).getBlock() == this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.LEFT);
			}
			else if(world.getBlockState(pos.south()).getBlock() == this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.RIGHT);
			}
		}
		if(state.getValue(FACING) == EnumFacing.WEST) {
			if(world.getBlockState(pos.south()).getBlock() != this && world.getBlockState(pos.north()).getBlock() != this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.DEF);
			} 
			else if(world.getBlockState(pos.south()).getBlock() == this && world.getBlockState(pos.north()).getBlock() == this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.CENTER);
			}
			else if(world.getBlockState(pos.south()).getBlock() == this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.LEFT);
			}
			else if(world.getBlockState(pos.north()).getBlock() == this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.RIGHT);
			}
		}
		if(state.getValue(FACING) == EnumFacing.NORTH) {
			if(world.getBlockState(pos.west()).getBlock() != this && world.getBlockState(pos.east()).getBlock() != this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.DEF);
			} 
			else if(world.getBlockState(pos.west()).getBlock() == this && world.getBlockState(pos.east()).getBlock() == this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.CENTER);
			}
			else if(world.getBlockState(pos.west()).getBlock() == this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.LEFT);
			}
			else if(world.getBlockState(pos.east()).getBlock() == this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.RIGHT);
			}
		}
		if(state.getValue(FACING) == EnumFacing.SOUTH) {
			if(world.getBlockState(pos.east()).getBlock() != this && world.getBlockState(pos.west()).getBlock() != this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.DEF);
			} 
			else if(world.getBlockState(pos.east()).getBlock() == this && world.getBlockState(pos.west()).getBlock() == this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.CENTER);
			}
			else if(world.getBlockState(pos.east()).getBlock() == this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.LEFT);
			}
			else if(world.getBlockState(pos.west()).getBlock() == this) {
				return state.withProperty(FACING, state.getValue(FACING)).withProperty(STATES, EnumState.RIGHT);
			}
		}

		return state;
    }
	private boolean attachesToBlock(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		Block block = world.getBlockState(pos).getBlock();
		return block instanceof BiolabTableUp;

	}
	
	public static enum EnumState implements IStringSerializable
	{
		DEF("def"),
		LEFT("left"),
		RIGHT("right"),
		CENTER("center");

		private final String name;

		private EnumState(String name)
		{
			this.name = name;
		}

		public String toString()
		{
			return this.name;
		}

		public String getName()
		{
			return this.name;
		}
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return AABB;
	}

	  @SideOnly(Side.CLIENT)
	    public BlockRenderLayer getBlockLayer()
	    {
	        return BlockRenderLayer.CUTOUT_MIPPED;
	    }
		@Override
	    protected BlockStateContainer createBlockState()
	    {
	        return new BlockStateContainer(this, new IProperty[] {FACING, STATES});
	    }
	  
}