package ru.lg.SovietMod.Blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.SovietCore;

public class VibroWireB extends Block
{
	 public static final PropertyBool DEFAULT = PropertyBool.create("default");

	  public static final PropertyBool POWERED = PropertyBool.create("powered");
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
	private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.3D, 0D, 0.3D, 0.7D, 1D, 0.7D)
		
	};

    public VibroWireB(String name, float hardness)
    {
        super(Material.IRON);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		 this.setTickRandomly(true);
		this.setHardness(hardness);
        this.setDefaultState(this.blockState.getBaseState().withProperty(DEFAULT, Boolean.valueOf(false)).withProperty(POWERED, false));
        this.setCreativeTab(SovietCore.tabMain);
    }
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return SIDE_AABB[0];
		
	}
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (!worldIn.isRemote)
		{	 
			if(worldIn.isBlockPowered(pos)) {

				playerIn.attackEntityFrom(DamageSource.CACTUS, 4.0F);
				return true;
			}
		}
		return false;
	}   
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
	{
		if (!worldIn.isRemote)
		{	 
			if(worldIn.isBlockPowered(pos)) {

				playerIn.attackEntityFrom(DamageSource.CACTUS, 4.0F);

			}
		}
	}

	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{
		if (!worldIn.isRemote)
		{	 
			if(worldIn.isBlockPowered(pos)) {
				if(entityIn instanceof EntityLivingBase) {

					entityIn.attackEntityFrom(DamageSource.CACTUS, 4.0F);
				}
			}
		} 
	}

	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
	
		if(worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(fromPos)) {
	
			worldIn.setBlockState(pos, state.withProperty(POWERED, true));
		} else {
			worldIn.setBlockState(pos, state.withProperty(POWERED, false));
			
		}

		}

    public boolean canProvidePower(IBlockState state)
    {
        return true;
    }





    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    /**
     * Determines if an entity can path through this block
     */
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return false;
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }



    public int damageDropped(IBlockState state)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return side == EnumFacing.DOWN ? super.shouldSideBeRendered(blockState, blockAccess, pos, side) : true;
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState();
    }

    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }

    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {

        return state
        		.withProperty(DEFAULT, Boolean.valueOf(true))
        		.withProperty(NORTH, canBeConnectedTo(worldIn, pos, EnumFacing.NORTH))
        		.withProperty(EAST, canBeConnectedTo(worldIn, pos, EnumFacing.EAST))
        		.withProperty(SOUTH, canBeConnectedTo(worldIn, pos, EnumFacing.SOUTH))
        		.withProperty(WEST, canBeConnectedTo(worldIn, pos, EnumFacing.WEST));
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {DEFAULT, NORTH, EAST, WEST, SOUTH, POWERED});
    }

    public BlockFaceShape getBlockFaceShape(IBlockAccess p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_, EnumFacing p_193383_4_)
    {
        return p_193383_4_ != EnumFacing.UP && p_193383_4_ != EnumFacing.DOWN ? BlockFaceShape.MIDDLE_POLE_THICK : BlockFaceShape.CENTER_BIG;
    }

    

    @Override
    public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing)
    {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof VibroWireB && !state.getBlock().isSideSolid(state, world, pos, facing))
        {
            Block connector = world.getBlockState(pos.offset(facing)).getBlock();
          
            return connector instanceof VibroWireB  || connector instanceof VibroWire || connector == RegBlocks.beton_wall || connector == RegBlocks.vibro_wire_lever;
        } else
        return false;
    }



    

    
}

