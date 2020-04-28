package ru.lg.SovietMod.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.RegItems;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class TurnStileOn extends BasicBlockSideWithCustomModel {
	private static AxisAlignedBB[] COLLIS_SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0.35D, 1D, 1.5D, 0.65D),
			new AxisAlignedBB(0D, 0D, 0.35D, 1D, 1.5D, 0.65D),
			new AxisAlignedBB(0.35D, 0D, 0D, 0.65D, 1.5D, 1D),
			new AxisAlignedBB(0.35D, 0D, 0D, 0.65D, 1.5D, 1D)
	};
	private static AxisAlignedBB[] COLLIS_SIDE_AABB_ON = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0.35D, 0.33D, 1.5D, 0.65D),
			new AxisAlignedBB(0.66D, 0D, 0.35D, 1D, 1.5D, 0.65D),
			new AxisAlignedBB(0.35D, 0D, 0D, 0.65D, 1.5D, 0.33D),
			new AxisAlignedBB(0.35D, 0D, 0.66D, 0.65D, 1.5D, 1D)
	};
	
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0.35D, 1D, 1D, 0.65D),
			new AxisAlignedBB(0D, 0D, 0.35D, 1D, 1D, 0.65D),
			new AxisAlignedBB(0.35D, 0D, 0D, 0.65D, 1D, 1D),
			new AxisAlignedBB(0.35D, 0D, 0D, 0.65D, 1D, 1D)
	};
	
	private static AxisAlignedBB[] SIDE_AABB_ON = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0.35D, 0.33D, 1D, 0.65D),
			new AxisAlignedBB(0.66D, 0D, 0.35D, 1D, 1D, 0.65D),
			new AxisAlignedBB(0.35D, 0D, 0D, 0.65D, 1D, 0.33D),
			new AxisAlignedBB(0.35D, 0D, 0.66D, 0.65D, 1D, 1D)
	};
	public static final PropertyBool ISPOWERED = PropertyBool.create("is_p");
	public TurnStileOn(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ISPOWERED, false));
	}
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING,ISPOWERED});
	}
	  public IBlockState getStateFromMeta(int meta)
	    {
		  return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta)).withProperty(ISPOWERED, Boolean.valueOf((meta & 8) > 0));
	    }

	    /**
	     * Convert the BlockState into the correct metadata value
	     */
	    public int getMetaFromState(IBlockState state)
	    {
	        int i = 0;
	        i = i | ((EnumFacing)state.getValue(FACING)).getIndex();

	        if (((Boolean)state.getValue(ISPOWERED)).booleanValue())
	        {
	            i |= 8;
	        }

	        return i;
	    }
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (!worldIn.isRemote)
		{
			if(!worldIn.isBlockPowered(pos)) {
				worldIn.setBlockState(pos, RegBlocks.turnstile_off.getDefaultState().withProperty(FACING, state.getValue(FACING)));
			}
		}
	}
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (!worldIn.isRemote)
		{
			if(!worldIn.isBlockPowered(pos)) {
				worldIn.setBlockState(pos, RegBlocks.turnstile_off.getDefaultState().withProperty(FACING, state.getValue(FACING)));
			}
		}
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!worldIn.isRemote) {
			if(!state.getValue(ISPOWERED)) 
			{
				worldIn.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(ISPOWERED, true));
			} else if(state.getValue(ISPOWERED))  {
				worldIn.setBlockState(pos, state.withProperty(FACING, state.getValue(FACING)).withProperty(ISPOWERED, false));
			}
			
			return true;
		}
		 return true;
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(RegBlocks.turnstile_off);
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(RegBlocks.turnstile_off);
	}
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
    	if(!state.getValue(ISPOWERED).booleanValue()) {
    		switch (state.getValue(FACING))
    		{
    		case SOUTH:
    			return this.COLLIS_SIDE_AABB[1];
    		case NORTH:
    		default:
    			return this.COLLIS_SIDE_AABB[0];
    		case WEST:
    			return this.COLLIS_SIDE_AABB[3];
    		case EAST:
    			return this.COLLIS_SIDE_AABB[2];
    		}
    		}else {
    			switch (state.getValue(FACING))
    			{
    			case SOUTH:
    				return COLLIS_SIDE_AABB_ON[1];
    			case NORTH:
    			default:
    				return COLLIS_SIDE_AABB_ON[0];
    			case WEST:
    				return COLLIS_SIDE_AABB_ON[3];
    			case EAST:
    				return COLLIS_SIDE_AABB_ON[2];
    			}
    		}
    	
    	
    }
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		if(!state.getValue(ISPOWERED).booleanValue()) {
		switch (state.getValue(FACING))
		{
		case SOUTH:
			return this.SIDE_AABB[1];
		case NORTH:
		default:
			return this.SIDE_AABB[0];
		case WEST:
			return this.SIDE_AABB[3];
		case EAST:
			return this.SIDE_AABB[2];
		}
		}else {
			switch (state.getValue(FACING))
			{
			case SOUTH:
				return SIDE_AABB_ON[1];
			case NORTH:
			default:
				return SIDE_AABB_ON[0];
			case WEST:
				return SIDE_AABB_ON[3];
			case EAST:
				return SIDE_AABB_ON[2];
			}
		}
	}
}
