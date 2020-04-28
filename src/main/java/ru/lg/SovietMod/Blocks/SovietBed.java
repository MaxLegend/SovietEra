package ru.lg.SovietMod.Blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.RegItems;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;

public class SovietBed extends BasicBlockSideWithCustomModel{

	public static final PropertyEnum<SovietBed.EnumHalf> PART = PropertyEnum.<SovietBed.EnumHalf>create("half", SovietBed.EnumHalf.class);

	protected static final AxisAlignedBB BED_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5625D, 1.0D);
	public SovietBed(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(PART, EnumHalf.FOOT));
	}
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		if (!world.isRemote)
		{

		}
	}
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	public void onLanded(World worldIn, Entity entityIn)
	{
		if (entityIn.isSneaking())
		{
			super.onLanded(worldIn, entityIn);
		}
		else if (entityIn.motionY < 0.0D)
		{
			entityIn.motionY = -entityIn.motionY * 0.6600000262260437D;

			if (!(entityIn instanceof EntityLivingBase))
			{
				entityIn.motionY *= 0.8D;
			}
		}
	}
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

		if (state.getValue(PART) == SovietBed.EnumHalf.FOOT)
		{
			if (worldIn.getBlockState(pos.offset(enumfacing)).getBlock() != this)
			{
				worldIn.setBlockToAir(pos);
			}
		}
		else if (worldIn.getBlockState(pos.offset(enumfacing.getOpposite())).getBlock() != this)
		{
			if (!worldIn.isRemote)
			{
				this.dropBlockAsItem(worldIn, pos, state, 0);
			}

			worldIn.setBlockToAir(pos);
		}
	}  
	 public IBlockState withRotation(IBlockState state, Rotation rot)
	    {
	        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	    }

	    /**
	     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
	     * blockstate.
	     */
	    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	    {
	        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	    }

	    /**
	     * Convert the BlockState into the correct metadata value
	     */
	    public int getMetaFromState(IBlockState state)
	    {
	        int i = 0;
	        i = i | ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();

	        if (state.getValue(PART) == SovietBed.EnumHalf.HEAD)
	        {
	            i |= 8;

	         
	        }

	        return i;
	    }


	    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	    {
	        return BlockFaceShape.UNDEFINED;
	    }
	    
	    public IBlockState getStateFromMeta(int meta)
	    {
	        EnumFacing enumfacing = EnumFacing.getHorizontal(meta);
	        return (meta & 8) > 0 ? this.getDefaultState().withProperty(PART, EnumHalf.HEAD).withProperty(FACING, enumfacing) : this.getDefaultState().withProperty(PART, EnumHalf.FOOT).withProperty(FACING, enumfacing);
	    }

	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        if (state.getValue(PART) == SovietBed.EnumHalf.FOOT)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.offset((EnumFacing)state.getValue(FACING)));

            if (iblockstate.getBlock() == this)
            {
      
            }
        }

        return state;
    }
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance)
	{
		super.onFallenUpon(worldIn, pos, entityIn, fallDistance * 0.5F);
	}
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		BlockPos blockpos = pos;

		if (state.getValue(PART) == SovietBed.EnumHalf.FOOT)
		{
			blockpos = pos.offset((EnumFacing)state.getValue(FACING));
		}


		
		return new ItemStack(RegItems.soviet_bed_item, 1);
	}
	  public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
	    {
	        if (player.capabilities.isCreativeMode && state.getValue(PART) == SovietBed.EnumHalf.FOOT)
	        {
	            BlockPos blockpos = pos.offset((EnumFacing)state.getValue(FACING));

	            if (worldIn.getBlockState(blockpos).getBlock() == this)
	            {
	                worldIn.setBlockToAir(blockpos);
	            }
	        }
	    }
	@Nullable
	private EntityPlayer getPlayerInBed(World worldIn, BlockPos pos)
	{
		for (EntityPlayer entityplayer : worldIn.playerEntities)
		{
			if (entityplayer.isPlayerSleeping() && entityplayer.bedLocation.equals(pos))
			{
				return entityplayer;
			}
		}

		return null;
	}
	  public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return state.getValue(PART) == SovietBed.EnumHalf.FOOT ? Items.AIR : RegItems.soviet_bed_item;
	    }

	    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        return BED_AABB;
	    }

	    @SideOnly(Side.CLIENT)
	    public boolean hasCustomBreakingProgress(IBlockState state)
	    {
	        return true;
	    }
	
	public static enum EnumHalf implements IStringSerializable
	{
		HEAD("front"),
		FOOT("back");

		private final String name;

		private EnumHalf(String name)
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
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		if (!world.isRemote)
		{

		}
	}
	@Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING, PART});
    }
}
