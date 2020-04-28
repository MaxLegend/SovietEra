package ru.lg.SovietMod.Blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.RegItems;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class PO_2 extends BasicBlockSideWithCustomModel{
	boolean upOrFalse;
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0.25D, 1D, 1D, 0.75D),
			new AxisAlignedBB(0D, 0D, 0.25D, 1D, 1D, 0.75D),
			new AxisAlignedBB(0.25D, 0D, 0D, 0.75D, 1D, 1D),
			new AxisAlignedBB(0.25D, 0D, 0D, 0.75D, 1D, 1D)
	};
	public PO_2(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype,boolean upOrFalse) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.upOrFalse = upOrFalse;
	}
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		if(state == RegBlocks.po_2_up.getDefaultState()) {
			return new ItemStack(RegBlocks.po_2_down);
		}
		return new ItemStack(RegBlocks.po_2_down);

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
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		if (!world.isRemote)
		{
	
			if(world.isAirBlock(pos.up())) {
			
				if(!upOrFalse)
				world.setBlockState(pos.up(), RegBlocks.po_2_up.getDefaultState().withProperty(FACING, state.getValue(FACING)));
				
			}
			if(state.getValue(FACING) == EnumFacing.SOUTH ||state.getValue(FACING) == EnumFacing.NORTH) {
				
				world.setBlockState(pos.east(), RegBlocks.fantom_block.getDefaultState());
				world.setBlockState(pos.west(), RegBlocks.fantom_block.getDefaultState());
			

			}
			if(state.getValue(FACING) == EnumFacing.WEST ||state.getValue(FACING) == EnumFacing.EAST) {

				world.setBlockState(pos.south(), RegBlocks.fantom_block.getDefaultState().withProperty(FACING, EnumFacing.EAST));
				world.setBlockState(pos.north(), RegBlocks.fantom_block.getDefaultState().withProperty(FACING, EnumFacing.EAST));
			

			}
		}
	}
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		if(world.isAirBlock(pos.east()) && world.isAirBlock(pos.west()) && world.isAirBlock(pos.up()) && world.isAirBlock(pos.south()) && world.isAirBlock(pos.north()) && world.isAirBlock(pos.up())) {
			EnumFacing facing = EnumFacing.fromAngle(placer.getRotationYawHead());
			
				world.setBlockState(pos, state.withProperty(FACING, facing));
				}
	//		}
			
	//	}
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(state == RegBlocks.po_2_up.getDefaultState()) {
			return Item.getItemFromBlock(RegBlocks.po_2_down);
		}
		return Item.getItemFromBlock(RegBlocks.po_2_down);

	}
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		if (!world.isRemote)
		{
			if(world.getBlockState(pos.up()).getBlock() == RegBlocks.po_2_up) {
				world.destroyBlock(pos.up(), false);
			}
			if(world.getBlockState(pos.down()).getBlock() == RegBlocks.po_2_down) {
				world.destroyBlock(pos.down(), false);
			}
			if(state.getValue(FACING) == EnumFacing.SOUTH ||state.getValue(FACING) == EnumFacing.NORTH) {
				if(world.getBlockState(pos.east()).getBlock() == RegBlocks.fantom_block) {
				world.destroyBlock(pos.east(), false);
				}
				if(world.getBlockState(pos.west()).getBlock() == RegBlocks.fantom_block) {
				world.destroyBlock(pos.west(), false);
				}
			}
			if(state.getValue(FACING) == EnumFacing.WEST ||state.getValue(FACING) == EnumFacing.EAST) {

				if(world.getBlockState(pos.south()).getBlock() == RegBlocks.fantom_block) {
					world.destroyBlock(pos.south(), false);
					}
					if(world.getBlockState(pos.north()).getBlock() == RegBlocks.fantom_block) {
					world.destroyBlock(pos.north(), false);
					}
			}
		}
	}
}
