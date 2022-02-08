package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockFullRotate;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockWithCustomModel;

public class VentCircle extends BasicBlockFullRotate {
	public static final PropertyDirection FACING = PropertyDirection.create("facing");
		public VentCircle(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.DOWN));
	}

		private static AxisAlignedBB[] SIDE_AABB = new AxisAlignedBB[] {
				new AxisAlignedBB(0.19D, 0.19D, 1D, 0.81D, 0.81D, 0.89D),
				new AxisAlignedBB(0.19D, 0.19D, 0D, 0.81D, 0.81D, 0.11D),
				new AxisAlignedBB(0D, 0.19D, 0.19D, 0.11D, 0.81D, 0.81D),
				new AxisAlignedBB(1D,  0.19D,  0.19D, 0.89D, 0.81D, 0.81D),
				new AxisAlignedBB(0.19D, 0D, 0.19D, 0.81D, 0.11D, 0.81D),
				new AxisAlignedBB(0.19D, 0.89D, 0.19D, 0.81D, 1D, 0.81D),
		};
		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
		{
			switch (state.getValue(FACING))
			{
			case NORTH:
				return SIDE_AABB[0];
			case SOUTH:
			default:
				return SIDE_AABB[1];
			case EAST:
				return SIDE_AABB[2];
			case WEST:
				return SIDE_AABB[3];
			case UP:
				return SIDE_AABB[4];
			case DOWN:
				return SIDE_AABB[5];
			}
			
		}
		
		
	
}
