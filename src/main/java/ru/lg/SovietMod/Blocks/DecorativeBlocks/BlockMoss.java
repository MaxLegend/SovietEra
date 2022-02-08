package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMoss extends BlockDirectional {
	
	public static final PropertyBool DEF = PropertyBool.create("default");
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");
	public static final PropertyBool DOWN = PropertyBool.create("down");
	public static final PropertyBool UP = PropertyBool.create("up");
	
	public BlockMoss(final Material materialIn, final String name, float hardness,float resistanse, SoundType soundtype,CreativeTabs cTab) {
		super(Material.GRASS);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setSoundType(soundtype);
		this.setHardness(hardness);
		this.setResistance(resistanse);
		this.setCreativeTab(cTab);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
	
	}
//	@Override
//    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
//    {
//    	EnumFacing facing = EnumFacing.getFacingFromVector(pos.getX(), pos.getY(), pos.getZ());
//    	if(world.isBlockFullCube(pos.offset(facing))) {
//    		world.setBlockState(pos, state.withProperty(FACING, facing));
//    	} else return;
//	
//    }
    
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }
    public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid)
    {
        return false;
    }
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
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

		public static BlockMoss.EnumAxis fromFacingAxis(EnumFacing.Axis axis)
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
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }
    

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
    }

@Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((EnumFacing)state.getValue(FACING)).getIndex();

        return i;
    }


	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING});
	}

	protected ItemStack getSilkTouchDrop(IBlockState state)
	{
		return new ItemStack(Item.getItemFromBlock(this));
	}
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, facing);
	}

}

