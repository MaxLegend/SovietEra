package ru.lg.SovietMod;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lg.SovietMod.Liquid.SwampWater;

public class RegFluids
{
   /**
    *  Переменные с нашими жидкостями.
    */
   public static Fluid swamp_water = new SwampWater("swamp_water", "swamp_water_still", "swamp_water_flow");

   /**
    * Регистрация нашей жидкости
    */
   public static void register()
   {
       FluidRegistry.registerFluid(swamp_water);

   }

   /**
    * Регистрация модели нашей жидкости
    */
   public static void registerRender()
   {
       modelLoader(RegBlocks.swamp_water, "swamp_water");
   }

   @SideOnly(Side.CLIENT)
   public static void modelLoader(Block block, String variant)
   {
	   ModelResourceLocation loc = new ModelResourceLocation("soviet:fluid", variant);
       Item milk = Item.getItemFromBlock(block);

       ModelBakery.registerItemVariants(milk);
       ModelLoader.setCustomMeshDefinition(milk, stack -> loc);
       ModelLoader.setCustomStateMapper(block, new StateMapperBase()
       {
           protected ModelResourceLocation getModelResourceLocation(IBlockState state)
           {
               return loc;
           }
       });
   }
}
