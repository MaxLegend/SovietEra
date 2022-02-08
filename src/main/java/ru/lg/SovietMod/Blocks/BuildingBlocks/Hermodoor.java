

package ru.lg.SovietMod.Blocks.BuildingBlocks;

import java.util.Random;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.RegItems;
import ru.lg.SovietMod.RegSounds;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockDoor;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class Hermodoor extends BasicBlockDoor {
    protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.375D);
    protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.625D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.625D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.375D, 1.0D, 1.0D);
	public Hermodoor(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setCreativeTab(null);
	}
	  public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        state = state.getActualState(source, pos);
	        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
	        boolean flag = !((Boolean)state.getValue(OPEN)).booleanValue();
	        boolean flag1 = state.getValue(HINGE) == BasicBlockDoor.EnumHingePosition.RIGHT;

	        switch (enumfacing)
	        {
	            case EAST:
	            default:
	                return EAST_AABB;
	            case SOUTH:
	                return SOUTH_AABB;
	            case WEST:
	                return WEST_AABB;
	            case NORTH:
	                return NORTH_AABB;
	        }
	    }
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(RegItems.hermodoor_item);
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return RegItems.hermodoor_item;
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(!worldIn.isRemote) {


			BlockPos blockpos = state.getValue(HALF) == BasicBlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
			IBlockState iblockstate = pos.equals(blockpos) ? state : worldIn.getBlockState(blockpos);

			if (iblockstate.getBlock() != this)
			{
				return false;
			}
			else
			{
				Item activeItem = playerIn.getHeldItem(hand).getItem();

				if(facing == iblockstate.getValue(FACING).getOpposite()) {
					if(isOpen(combineMetadata(worldIn, pos))) {
						state = iblockstate.cycleProperty(OPEN);
						worldIn.setBlockState(blockpos, state, 10);
						worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
						worldIn.playSound(null, pos, getSound(), SoundCategory.BLOCKS, 0.9F, 1.0F);
						return true;
					}
					if(activeItem == RegItems.wrench) {
						state = iblockstate.cycleProperty(OPEN);
						worldIn.setBlockState(blockpos, state, 10);
						worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
						worldIn.playSound(null, pos, getSound(), SoundCategory.BLOCKS, 0.9F, 1.0F);
						return true;

					}
				}
				else {
					if(facing == iblockstate.getValue(FACING)) {
						state = iblockstate.cycleProperty(OPEN);
						worldIn.setBlockState(blockpos, state, 10);
						worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
						worldIn.playSound(null, pos, getSound(), SoundCategory.BLOCKS, 0.9F, 1.0F);
						return true;
					} else {


					}

				}
			}
		}
		return true;

	}
	@Override
	public SoundEvent getSound() {

		return RegSounds.openhermodoor;
	}



}