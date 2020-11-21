package ru.lg.SovietMod.Liquid;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import ru.lg.SovietMod.SovietCore;

public class SwampWaterBlock extends BlockFluidClassic
{
   public SwampWaterBlock(Fluid fluid, String name)
   {
       super(fluid, Material.WATER);
  
       setUnlocalizedName(name);
       setCreativeTab(SovietCore.tabItems);
       setRegistryName(name);
   }
   
   public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entity)
   {
	  if(entity instanceof EntityLivingBase) {
		  entity.attackEntityFrom(DamageSource.HOT_FLOOR, 0.6F);
	  }
   }
   @Override
   public void onBlockAdded(World world, BlockPos pos, IBlockState state)
   {
       super.onBlockAdded(world, pos, state);
       mergerFluids(pos, world);
   }

   @Override
   public void neighborChanged(IBlockState state, World world,  BlockPos pos,  Block neighborBlock,  BlockPos neighbourPos)
   {
       super.neighborChanged(state, world, pos, neighborBlock, neighbourPos);
       mergerFluids(pos, world);
   }

   private void mergerFluids(BlockPos pos, World world)
   {
       for(EnumFacing facing : EnumFacing.values())
       {
           Block block = world.getBlockState(pos.offset(facing)).getBlock();

           if(block == Blocks.WATER || block == Blocks.FLOWING_WATER)
           {
              
           }
       }
   }
}