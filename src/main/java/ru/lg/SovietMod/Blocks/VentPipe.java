package ru.lg.SovietMod.Blocks;


import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.RegSounds;
import ru.lg.SovietMod.SovietCore;

public class VentPipe extends Block
{
	 public static final PropertyBool DEFAULT = PropertyBool.create("default");
 
    public static final PropertyBool DOWN = PropertyBool.create("down");
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");

   
    public VentPipe(String name, float hardness)
    {
        super(Material.IRON);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setHardness(hardness);
        this.setDefaultState(this.blockState.getBaseState().withProperty(DEFAULT, Boolean.valueOf(false)));
        
        this.setCreativeTab(SovietCore.tabMain);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        state = this.getActualState(state, source, pos);
        return new AxisAlignedBB(0.2D, 0.63D, 0.2D, 0.8D, 0.87D, 0.8D);
    }



    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        blockState = this.getActualState(blockState, worldIn, pos);
        return new AxisAlignedBB(0.2D, 0.63D, 0.2D, 0.8D, 0.87D, 0.8D);
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

    public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos, EnumFacing facing)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        BlockFaceShape blockfaceshape = iblockstate.getBlockFaceShape(worldIn, pos, facing);
        Block block = iblockstate.getBlock();
        boolean flag = blockfaceshape == BlockFaceShape.MIDDLE_POLE && (iblockstate.getMaterial() == this.blockMaterial || block instanceof VentPipe);
        return  blockfaceshape == BlockFaceShape.SOLID || flag;
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
        		.withProperty(WEST, canBeConnectedTo(worldIn, pos, EnumFacing.WEST))
        		.withProperty(DOWN, canBeConnectedTo(worldIn, pos, EnumFacing.DOWN));
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {DEFAULT, DOWN, NORTH, EAST, WEST, SOUTH});
    }

    public BlockFaceShape getBlockFaceShape(IBlockAccess p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_, EnumFacing p_193383_4_)
    {
        return p_193383_4_ != EnumFacing.UP && p_193383_4_ != EnumFacing.DOWN ? BlockFaceShape.MIDDLE_POLE_THICK : BlockFaceShape.CENTER_BIG;
    }

    

    @Override
    public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing)
    {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof VentPipe && !state.getBlock().isSideSolid(state, world, pos, facing))
        {
            Block connector = world.getBlockState(pos.offset(facing)).getBlock();
            return connector instanceof VentPipe || connector instanceof LabGlassCase|| connector instanceof FantomSlabD|| connector == RegBlocks.vent_pipe_base|| connector == RegBlocks.wood_labshelf_upper|| connector == RegBlocks.wood_labshelf_upper_break;
        } else
        return false;
    }



    

    
}
