package ru.lg.SovietMod.Blocks.Basic;

import javax.annotation.Nullable;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BasicTileEntityBlock<TE extends TileEntity> extends BasicBlock {
	/**
	 * Should the {@link TileEntity} be preserved until after {@link #getDrops} has been called?
	 */
	private final boolean preserveTileEntity;


	public BasicTileEntityBlock(final Material materialIn, final String blockName, final boolean preserveTileEntity) {
		super(materialIn, blockName, 1, 1, SoundType.WOOD);
		this.preserveTileEntity = preserveTileEntity;
	}

	@Override
	public boolean hasTileEntity(final IBlockState state) {
		return true;
	}

	@Override
	public abstract TileEntity createTileEntity(World world, IBlockState state);

	/**
	 * Get the {@link TileEntity} at the specified position.
	 *
	 * @param world The World
	 * @param pos   The position
	 * @return The TileEntity
	 */
	@SuppressWarnings("unchecked")
	@Nullable
	protected TE getTileEntity(final IBlockAccess world, final BlockPos pos) {
		return (TE) world.getTileEntity(pos);
	}

	@Override
	public boolean removedByPlayer(final IBlockState state, final World world, final BlockPos pos, final EntityPlayer player, final boolean willHarvest) {
		// If it will harvest, delay deletion of the block until after getDrops
		return preserveTileEntity && willHarvest || super.removedByPlayer(state, world, pos, player, false);
	}

	@Override
	public void harvestBlock(final World world, final EntityPlayer player, final BlockPos pos, final IBlockState state, @Nullable final TileEntity te, final ItemStack stack) {
		super.harvestBlock(world, player, pos, state, te, stack);

		if (preserveTileEntity) {
			world.setBlockToAir(pos);
		}
	}
}
