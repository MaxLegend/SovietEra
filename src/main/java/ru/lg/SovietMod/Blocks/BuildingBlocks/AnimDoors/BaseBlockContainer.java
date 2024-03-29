package ru.lg.SovietMod.Blocks.BuildingBlocks.AnimDoors;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;
import ru.lg.SovietMod.API.MetadataContainer;

public abstract class BaseBlockContainer extends Block implements ITileEntityProvider {
	 protected final MetadataContainer overrideBlockState;
		protected BaseBlockContainer(Material materialIn)
	    {
	        this(materialIn, materialIn.getMaterialMapColor());
	    }

	    protected BaseBlockContainer(Material materialIn, MapColor color)
	    {
	        super(materialIn, color);
	        this.hasTileEntity = true;
	        overrideBlockState = (MetadataContainer) blockState;
	        setDefaultState(createDefaultState());
	    }
	    @Override
	    protected BlockStateContainer createBlockState() {
	        return new MetadataContainer(this, createBlockProperties());
	    }

	    protected abstract IProperty<?>[] createBlockProperties();

	    protected abstract IBlockState createDefaultState();

	    @Override
	    public final int getMetaFromState(IBlockState state) {
	        return overrideBlockState.getMetaFromState(state);
	    }

	    @Override
	    public final IBlockState getStateFromMeta(int meta) {
	        return overrideBlockState.getStateFromMeta(meta);
	    }
	    
	    
	    protected boolean isInvalidNeighbor(World worldIn, BlockPos pos, EnumFacing facing)
	    {
	        return worldIn.getBlockState(pos.offset(facing)).getMaterial() == Material.CACTUS;
	    }

	    protected boolean hasInvalidNeighbor(World worldIn, BlockPos pos)
	    {
	        return this.isInvalidNeighbor(worldIn, pos, EnumFacing.NORTH) || this.isInvalidNeighbor(worldIn, pos, EnumFacing.SOUTH) || this.isInvalidNeighbor(worldIn, pos, EnumFacing.WEST) || this.isInvalidNeighbor(worldIn, pos, EnumFacing.EAST);
	    }

	
	    public EnumBlockRenderType getRenderType(IBlockState state)
	    {
	        return EnumBlockRenderType.INVISIBLE;
	    }

	
	    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	    {
	        super.breakBlock(worldIn, pos, state);
	        worldIn.removeTileEntity(pos);
	    }


	    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
	    {
	        if (te instanceof IWorldNameable && ((IWorldNameable)te).hasCustomName())
	        {
	            player.addStat(StatList.getBlockStats(this));
	            player.addExhaustion(0.005F);

	            if (worldIn.isRemote)
	            {
	                return;
	            }

	            int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
	            Item item = this.getItemDropped(state, worldIn.rand, i);

	            if (item == Items.AIR)
	            {
	                return;
	            }

	            ItemStack itemstack = new ItemStack(item, this.quantityDropped(worldIn.rand));
	            itemstack.setStackDisplayName(((IWorldNameable)te).getName());
	            spawnAsEntity(worldIn, pos, itemstack);
	        }
	        else
	        {
	            super.harvestBlock(worldIn, player, pos, state, (TileEntity)null, stack);
	        }
	    }

	    /**
	     * Called on server when World#addBlockEvent is called. If server returns true, then also called on the client. On
	     * the Server, this may perform additional changes to the world, like pistons replacing the block with an extended
	     * base. On the client, the update may involve replacing tile entities or effects such as sounds or particles
	     */
	    public boolean eventReceived(IBlockState state, World worldIn, BlockPos pos, int id, int param)
	    {
	        super.eventReceived(state, worldIn, pos, id, param);
	        TileEntity tileentity = worldIn.getTileEntity(pos);
	        return tileentity == null ? false : tileentity.receiveClientEvent(id, param);
	    }
	
}
