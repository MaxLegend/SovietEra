package ru.lg.SovietMod.Liquid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class SwampWater extends Fluid
{
 
   public SwampWater(String fluidName, String still, String flowing)
   {
       super(fluidName, new ResourceLocation("soviet", "blocks/liquid/" + still), new ResourceLocation("soviet", "blocks/liquid/" + flowing));
   }

}