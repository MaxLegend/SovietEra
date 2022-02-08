package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.RegConfig;
import ru.lg.SovietMod.RegSounds;
import ru.lg.SovietMod.SovietCore;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;
import ru.lg.SovietMod.Blocks.Basic.NewBasicXZBlock;
import ru.lg.SovietMod.Blocks.SovietBox.TileEntitySovietBox;
import ru.lg.SovietMod.Network.GuiHandler;

public class SovietLamp extends NewBasicXZBlock {
	private boolean isOn;

	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(1D, 0D, 0.685D, 0D, 0.125D, 0.315D), //upx
			new AxisAlignedBB(0.685D, 0D, 1D, 0.315D, 0.125D, 0D),//upz
			new AxisAlignedBB(0.685D, 1D, 1D, 0.315D, 0.875D, 0D),//downz
			new AxisAlignedBB(1D, 1D, 0.685D, 0D, 0.875D, 0.315D),//downx
			new AxisAlignedBB(0D, 0.315D, 0D, 1D, 0.685D, 0.125D),//south
			new AxisAlignedBB(0D, 0.315D, 0.875D, 1D, 0.685D, 1D), //north
			new AxisAlignedBB(0.875D, 0.315D, 0D, 1D, 0.685D, 1D),//west
			new AxisAlignedBB(0D, 0.315D, 0D, 0.125D, 0.685D, 1D),//east
	};
	

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case UP_X:
			return SIDE_AABB[0];
		case UP_Z:
			return SIDE_AABB[1];
		case DOWN_Z:
			return SIDE_AABB[2];
		case DOWN_X:
			return SIDE_AABB[3];
		case SOUTH:
			return SIDE_AABB[4];
		case NORTH:
		default:
			return SIDE_AABB[5];
		case WEST:
			return SIDE_AABB[6];
		case EAST:
			return SIDE_AABB[7];
		}
	}
	public SovietLamp(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype,boolean isOn) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, NewBasicXZBlock.EnumOrientation.NORTH));
		this.isOn = isOn;

		if (isOn)
		{

			this.setLightLevel(1F);
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{

		if(worldIn.isRemote) {
			if(RegConfig.enableLumpSound) {
				worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(),  RegSounds.enablelump, SoundCategory.BLOCKS, 0.7F, 1.0F, true);
			}
		}
		if (!worldIn.isRemote)
		{

			if(worldIn.getBlockState(pos) == RegBlocks.sovietlamptrue.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
				this.isOn = false;
				worldIn.setBlockState(pos, RegBlocks.sovietlamp.getDefaultState().withProperty(FACING, state.getValue(FACING)));
				return true;

			}  

			if(worldIn.getBlockState(pos) == RegBlocks.sovietlamp.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
				this.isOn = true;

				worldIn.setBlockState(pos, RegBlocks.sovietlamptrue.getDefaultState().withProperty(FACING, state.getValue(FACING)));

				return true;
			}


		}
		return true;


	}
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(RegBlocks.sovietlamp);
	}


	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (!worldIn.isRemote)
		{
			//	worldIn.playSound(null, pos,  RegSounds.enablelump, SoundCategory.BLOCKS, 0.01F, 1.0F);

			Block neighbor = worldIn.getBlockState(fromPos).getBlock();

			if(neighbor instanceof IncLamp || neighbor instanceof SovietLamp|| neighbor instanceof RedLamp) {
				return;
			} else {
				if(worldIn.isBlockPowered(pos)) {
					isOn = true;
					worldIn.setBlockState(pos, RegBlocks.sovietlamptrue.getDefaultState().withProperty(FACING, state.getValue(FACING)));
				}
				if(!worldIn.isBlockPowered(pos)) {
					isOn = false;
					worldIn.setBlockState(pos, RegBlocks.sovietlamp.getDefaultState().withProperty(FACING, state.getValue(FACING)));
				}
			}
		}
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
		if(worldIn.getBlockState(pos) == RegBlocks.sovietlamp.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
			this.isOn = false;
			if(worldIn.isBlockPowered(pos)) {
				isOn = true;
			}
		}
		if(worldIn.getBlockState(pos) == RegBlocks.sovietlamptrue.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
			this.isOn = true;
			if(worldIn.isBlockPowered(pos)) {
				isOn = false;
			}
		}
		worldIn.scheduleBlockUpdate(pos, this, 35, 0);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if(RegConfig.enableLumpSound) {
			worldIn.scheduleBlockUpdate(pos, this, 40, 0);
			if(!worldIn.isRemote) {
				if(isOn)
				{
			//		worldIn.playSound(null,pos, RegSounds.buzzlump, SoundCategory.BLOCKS, 0.7F, 1F);
				}
				if(isOn && worldIn.isBlockPowered(pos)) {
			//		worldIn.playSound(null,pos, RegSounds.buzzlump, SoundCategory.BLOCKS, 0.6F, 1.0F);

				}
			}
		}


	}

}
