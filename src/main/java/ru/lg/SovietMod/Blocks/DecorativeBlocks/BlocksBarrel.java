package ru.lg.SovietMod.Blocks.DecorativeBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.SovietCore;
import ru.lg.SovietMod.API.BasicMetadataBlock;
import ru.lg.SovietMod.Blocks.Basic.BasicBlockLogWCM;
import ru.lg.SovietMod.Blocks.Basic.BasicLogBlock;

public class BlocksBarrel extends BasicMetadataBlock {
	public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.<EnumFacing.Axis>create("axis", EnumFacing.Axis.class);
	public static final PropertyInteger LEVEL = PropertyInteger.create("level", 0, 3);
	public BlocksBarrel(Material materialIn, String name, float hardness, float resistanse, SoundType soundtype) {
		super(materialIn, name, hardness, resistanse, soundtype, SovietCore.tabInsDeco);


	}
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(AXIS, facing.getAxis());
	}
	public void setWaterLevel(World worldIn, BlockPos pos, IBlockState state, int level)
	{
		worldIn.setBlockState(pos, state.withProperty(LEVEL, Integer.valueOf(MathHelper.clamp(level, 0, 3))), 2);
		worldIn.updateComparatorOutputLevel(pos, this);
	}
	public static enum EnumAxis implements IStringSerializable {
		X("x"),
		Y("y"),
		Z("z"),
		NONE("none");

		private final String name;

		private EnumAxis(String name)
		{
			this.name = name;
		}

		public String toString()
		{
			return this.name;
		}

		public static EnumAxis fromFacingAxis(EnumFacing.Axis axis)
		{
			switch (axis)
			{
			case X:
				return X;
			case Y:
				return Y;
			case Z:
				return Z;
			default:
				return NONE;
			}
		}

		public String getName()
		{
			return this.name;
		}
	}
	@Override
	public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis)
	{
		IBlockState state = world.getBlockState(pos);
		for (net.minecraft.block.properties.IProperty<?> prop : state.getProperties().keySet())
		{
			if (prop.getName().equals("axis"))
			{
				world.setBlockState(pos, state.cycleProperty(prop));
				return true;
			}
		}
		return false;
	}

	public IBlockState withRotation(IBlockState state, Rotation rot)
	{
		switch (rot)
		{
		case COUNTERCLOCKWISE_90:
		case CLOCKWISE_90:

			switch ((EnumFacing.Axis)state.getValue(AXIS))
			{
			case X:
				return state.withProperty(AXIS, EnumFacing.Axis.Z);
			case Z:
				return state.withProperty(AXIS, EnumFacing.Axis.X);
			default:
				return state;
			}

		default:
			return state;
		}
	}
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		ItemStack itemstack = playerIn.getHeldItem(hand);

		if (itemstack.isEmpty())
		{
			return true;
		}
		else
		{
			int i = ((Integer)state.getValue(LEVEL)).intValue();
			Item item = itemstack.getItem();

			if (item == Items.WATER_BUCKET)
			{
				if (i < 3 && !worldIn.isRemote)
				{
					if (!playerIn.capabilities.isCreativeMode)
					{
						playerIn.setHeldItem(hand, new ItemStack(Items.BUCKET));
					}

					playerIn.addStat(StatList.CAULDRON_FILLED);
					this.setWaterLevel(worldIn, pos, state, i + 1);
					worldIn.playSound((EntityPlayer)null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
				}

				return true;
			}
			else if (item == Items.BUCKET)
			{
				if (i == 3 && !worldIn.isRemote)
				{
					if (!playerIn.capabilities.isCreativeMode)
					{
						itemstack.shrink(1);

						if (itemstack.isEmpty())
						{
							playerIn.setHeldItem(hand, new ItemStack(Items.WATER_BUCKET));
						}
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET)))
						{
							playerIn.dropItem(new ItemStack(Items.WATER_BUCKET), false);
						}
					}

					playerIn.addStat(StatList.CAULDRON_USED);
					this.setWaterLevel(worldIn, pos, state, i - 1);
					worldIn.playSound((EntityPlayer)null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
				}

				return true;
			}
			else if (item == Items.GLASS_BOTTLE)
			{
				if (i > 0 && !worldIn.isRemote)
				{
					if (!playerIn.capabilities.isCreativeMode)
					{
						ItemStack itemstack3 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
						playerIn.addStat(StatList.CAULDRON_USED);
						itemstack.shrink(1);

						if (itemstack.isEmpty())
						{
							playerIn.setHeldItem(hand, itemstack3);
						}
						else if (!playerIn.inventory.addItemStackToInventory(itemstack3))
						{
							playerIn.dropItem(itemstack3, false);
						}
						else if (playerIn instanceof EntityPlayerMP)
						{
							((EntityPlayerMP)playerIn).sendContainerToPlayer(playerIn.inventoryContainer);
						}
					}

					worldIn.playSound((EntityPlayer)null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
					this.setWaterLevel(worldIn, pos, state, i - 1);
				}

				return true;
			}
			else if (item == Items.POTIONITEM && PotionUtils.getPotionFromItem(itemstack) == PotionTypes.WATER)
			{
				if (i < 3 && !worldIn.isRemote)
				{
					if (!playerIn.capabilities.isCreativeMode)
					{
						ItemStack itemstack2 = new ItemStack(Items.GLASS_BOTTLE);
						playerIn.addStat(StatList.CAULDRON_USED);
						playerIn.setHeldItem(hand, itemstack2);

						if (playerIn instanceof EntityPlayerMP)
						{
							((EntityPlayerMP)playerIn).sendContainerToPlayer(playerIn.inventoryContainer);
						}
					}

					worldIn.playSound((EntityPlayer)null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
					this.setWaterLevel(worldIn, pos, state, i + 1);
				}

				return true;
			}



			{
				return false;
			}
		}
	}
	@Override
	protected IProperty<?>[] createBlockProperties() {

		return new IProperty<?>[] {AXIS, LEVEL};
	}
	@Override
	protected IBlockState createDefaultState() {
		return this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Y).withProperty(LEVEL, Integer.valueOf(0));
	}
}

