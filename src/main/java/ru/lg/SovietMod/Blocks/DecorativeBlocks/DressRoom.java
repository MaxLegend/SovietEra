package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.RegBlocks;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockSideWithCustomModel;
import ru.lg.SovietMod.Util.CollisionHelper;

public class DressRoom extends BasicBlockSideWithCustomModel{ 
	

    private static final AxisAlignedBB SIDE_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.9375, 0.0, 0.0, 1.0, 1.0, 1.0);
    private static final AxisAlignedBB SIDE_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.9375, 0.0, 0.0, 1.0, 1.0, 1.0);
    private static final AxisAlignedBB SIDE_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.9375, 0.0, 0.0, 1.0, 1.0, 1.0);
    private static final AxisAlignedBB SIDE_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.9375, 0.0, 0.0, 1.0, 1.0, 1.0);
    private static final AxisAlignedBB BOTTOM = new AxisAlignedBB(0, 0, 0, 1, 0.2, 1);

    public static final AxisAlignedBB TOP_BOUNDING_BOX = new AxisAlignedBB(0, 0, 0, 1, 1, 1);
    public static final AxisAlignedBB BOTTOM_BOUNDING_BOX = new AxisAlignedBB(0, 0, 0, 1, 1, 1);

	public DressRoom(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype, boolean top) {
		super(materialIn, name, hardness, resistanse, soundtype);
	    if(top) this.setCreativeTab(null);
		
	}
    private List<AxisAlignedBB> getCollisionBoxList(IBlockState state, World world, BlockPos pos)
    {
        List<AxisAlignedBB> list = Lists.newArrayList();
        EnumFacing facing = state.getValue(FACING);

        if(state.getBlock() == RegBlocks.dress_room_down)
        {
            list.add(BOTTOM);
        }
        if(facing == EnumFacing.NORTH || facing == EnumFacing.SOUTH)
        {
     
            list.add(SIDE_WEST);
            list.add(SIDE_EAST);
        }

        if(facing == EnumFacing.EAST || facing == EnumFacing.WEST)
        {
            list.add(SIDE_SOUTH);
            list.add(SIDE_NORTH);
        }


        return list;
    }
    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos)
    {
        return super.canPlaceBlockAt(world, pos) && super.canPlaceBlockAt(world, pos.up());
    }
    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return new ItemStack(RegBlocks.dress_room_down).getItem();
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(RegBlocks.dress_room_down);
    }
    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean p_185477_7_)
    {
        List<AxisAlignedBB> boxes = this.getCollisionBoxList(this.getActualState(state, worldIn, pos), worldIn, pos);
        for(AxisAlignedBB box : boxes)
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, box);
        }
    }
    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        world.destroyBlock(this == RegBlocks.dress_room_down ? pos.up() : pos.down(), false);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
    {
    	 if(entity instanceof EntityPlayer)
         {
             EntityPlayer player = (EntityPlayer) entity;
             boolean top = this == RegBlocks.dress_room_up;

             IBlockState head = world.getBlockState(pos.up(top ? 1 : 2));
 
         }
     }
    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
    
        return state.getBlock() == RegBlocks.dress_room_up ? TOP_BOUNDING_BOX : BOTTOM_BOUNDING_BOX;
    }
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
    	EnumFacing facing = EnumFacing.fromAngle(placer.getRotationYawHead());
        world.setBlockState(pos.up(), RegBlocks.dress_room_up.getDefaultState().withProperty(FACING, facing), 2);
        world.setBlockState(pos, state.withProperty(FACING, facing));
    }
    @Override
    public RayTraceResult collisionRayTrace(IBlockState blockState, World world, BlockPos pos, Vec3d start, Vec3d end)
    {
        List<RayTraceResult> list = Lists.newArrayList();

        for(AxisAlignedBB axisalignedbb : getCollisionBoxList(this.getActualState(blockState, world, pos), world, pos))
        {
            list.add(this.rayTrace(pos, start, end, axisalignedbb));
        }

        RayTraceResult raytraceresult1 = null;
        double d1 = 0.0D;

        for(RayTraceResult raytraceresult : list)
        {
            if(raytraceresult != null)
            {
                double d0 = raytraceresult.hitVec.squareDistanceTo(end);

                if(d0 > d1)
                {
                    raytraceresult1 = raytraceresult;
                    d1 = d0;
                }
            }
        }

        return raytraceresult1;
    }
}
