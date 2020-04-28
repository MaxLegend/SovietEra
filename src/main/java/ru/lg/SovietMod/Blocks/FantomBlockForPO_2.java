package ru.lg.SovietMod.Blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSide;

public class FantomBlockForPO_2 extends BasicBlockSide{
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0D, 0D, 0.25D, 1D, 1D, 0.75D),
			new AxisAlignedBB(0D, 0D, 0.25D, 1D, 1D, 0.75D),
			new AxisAlignedBB(0.25D, 0D, 0D, 0.75D, 1D, 1D),
			new AxisAlignedBB(0.25D, 0D, 0D, 0.75D, 1D, 1D)
	};
	public FantomBlockForPO_2(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setCreativeTab(null);
	}
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		if (!world.isRemote)
		{
			if(world.getBlockState(pos.east()).getBlock() == RegBlocks.po_2_down ||world.getBlockState(pos.east()).getBlock() == RegBlocks.po_2_up) {
			
				world.destroyBlock(pos.east(), false);
			}
			
			if(world.getBlockState(pos.west()).getBlock() == RegBlocks.po_2_down || world.getBlockState(pos.west()).getBlock() == RegBlocks.po_2_up) {
			
				world.destroyBlock(pos.west(), false);
			}
			
			if(world.getBlockState(pos.south()).getBlock() == RegBlocks.po_2_down ||world.getBlockState(pos.south()).getBlock() == RegBlocks.po_2_up) {
		
				world.destroyBlock(pos.south(), false);
			}
			
			if(world.getBlockState(pos.north()).getBlock() == RegBlocks.po_2_down ||world.getBlockState(pos.north()).getBlock() == RegBlocks.po_2_up) {
				
				world.destroyBlock(pos.north(), false);
			}
			
			
		}
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(RegBlocks.po_2_down);

	}
	@Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
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

	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.INVISIBLE;
	}
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
}
