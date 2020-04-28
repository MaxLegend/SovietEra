package ru.lg.SovietMod.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.RegSounds;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockWithCustomModel;

public class IncLamp extends BasicBlockWithCustomModel {
	
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.35D, 0.35D, 1D, 0.65D, 0.65D, 0.65D),
			new AxisAlignedBB(0.35D, 0.35D, 0D, 0.65D, 0.65D, 0.35D),
			new AxisAlignedBB(0.35D, 0.35D, 0.35D, 0D, 0.65D, 0.65D),
			new AxisAlignedBB(0.65D, 0.35D, 0.35D, 1D, 0.65D, 0.65D),

	};
	

	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	private boolean isOn;
	public IncLamp(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype,boolean isOn) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.DOWN));
		this.isOn = isOn;
		
		if (isOn)
		{
			this.setLightLevel(0.8F);
		}
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{

		if(worldIn.isRemote) {
			worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(),  RegSounds.lum_lamp_enable, SoundCategory.BLOCKS, 0.1F, 1.0F, true);
		}
		if (!worldIn.isRemote)
		{

			if(worldIn.getBlockState(pos) == RegBlocks.inc_lamp_true.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
				this.isOn = false;
				worldIn.setBlockState(pos, RegBlocks.inc_lamp_false.getDefaultState().withProperty(FACING, state.getValue(FACING)));
				return true;

			} 

			if(worldIn.getBlockState(pos) == RegBlocks.inc_lamp_false.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
				this.isOn = true;

				worldIn.setBlockState(pos, RegBlocks.inc_lamp_true.getDefaultState().withProperty(FACING, state.getValue(FACING)));

				return true;
			}


		}
		return true;


	}
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(RegBlocks.inc_lamp_false);
	}


	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (!worldIn.isRemote)
		{
			Block neighbor = worldIn.getBlockState(fromPos).getBlock();

			if(neighbor instanceof IncLamp || neighbor instanceof SovietLamp|| neighbor instanceof RedLamp) {
				return;
			} else {
			if(worldIn.isBlockPowered(pos)) {
				isOn = true;
				worldIn.setBlockState(pos, RegBlocks.inc_lamp_true.getDefaultState().withProperty(FACING, state.getValue(FACING)));
			}
			if(!worldIn.isBlockPowered(pos)) {
				isOn = false;
				worldIn.setBlockState(pos, RegBlocks.inc_lamp_false.getDefaultState().withProperty(FACING, state.getValue(FACING)));
			}
			}
		}
	}
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{

		if(worldIn.getBlockState(pos) == RegBlocks.inc_lamp_false.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
			this.isOn = false;
			if(worldIn.isBlockPowered(pos)) {
				isOn = true;
			}
		}
		if(worldIn.getBlockState(pos) == RegBlocks.inc_lamp_true.getDefaultState().withProperty(FACING, state.getValue(FACING))) {
			this.isOn = true;
			if(worldIn.isBlockPowered(pos)) {
				isOn = false;
			}
		}
		worldIn.scheduleBlockUpdate(pos, this, 20, 0);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{

		worldIn.scheduleBlockUpdate(pos, this, 20, 0);
		if(!worldIn.isRemote) {
			if(isOn)
			{
				
			}
			if(isOn && worldIn.isBlockPowered(pos)) { 
				

			}
		}


	}

	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch (state.getValue(FACING))
		{
		case NORTH:
			return this.SIDE_AABB[0];
		case SOUTH:
		default:
			return this.SIDE_AABB[1];
		case EAST:
			return this.SIDE_AABB[2];
		case WEST:
			return this.SIDE_AABB[3];
		case UP:
			return new AxisAlignedBB(0.31D, 0D, 0.31D, 0.69D, 0.42D, 0.69D);
		case DOWN:
			return new AxisAlignedBB(0.31D, 0.6D, 0.31D, 0.69D, 1D, 0.69D);
		}
		
	}
	
	
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {FACING});
	}
	public IBlockState getStateFromMeta(int meta)
	{
		IBlockState iblockstate = this.getDefaultState();

		switch (meta)
		{
		case 1:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.EAST);
			break;
		case 2:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.WEST);
			break;
		case 3:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.SOUTH);
			break;
		case 4:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.NORTH);
			break;
		case 5:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.DOWN);
			break;
		case 6:
		default:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.UP);
		}

		return iblockstate;
	}
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;

		switch ((EnumFacing)state.getValue(FACING))
		{
		case EAST:
			i = i | 1;
			break;
		case WEST:
			i = i | 2;
			break;
		case SOUTH:
			i = i | 3;
			break;
		case NORTH:
			i = i | 4;
			break;
		case DOWN:
			i = i | 5;
			break;
		case UP:
		default:
			i = i | 6;
		}

		return i;
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
		  @SideOnly(Side.CLIENT)
		    public BlockRenderLayer getBlockLayer()
		    {
		        return BlockRenderLayer.CUTOUT_MIPPED;
		    }
	@Override
	  public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return canPlaceBlock(worldIn, pos, facing) ? this.getDefaultState().withProperty(FACING, facing) : this.getDefaultState().withProperty(FACING, EnumFacing.DOWN);
    }
	protected ItemStack getSilkTouchDrop(IBlockState state)
	{
		return new ItemStack(Item.getItemFromBlock(this));
	}


}
