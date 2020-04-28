package ru.lg.SovietMod;



import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class RegConfig
{
   public static Configuration config;
   public static int chanceGeneration1;
   public static int chanceGeneration2;
   public static boolean enableLabGenerator;
//   public static float volume_change_megalamp;
//   public static float volume_change_sovietlamp;

   public static void register(FMLPreInitializationEvent e)
   {
       config = new Configuration(e.getSuggestedConfigurationFile());
       config.load();
       chanceGeneration1 = config.getInt("chanceGeneration1", "World gens", 20, 2, 100,  "config.chanceGeneration1", "config.chanceGeneration1.name");
       chanceGeneration2 = config.getInt("chanceGeneration2", "World gens", 18, 4, 100, "config.chanceGeneration2", "config.chanceGeneration2.name");
       enableLabGenerator = config.getBoolean("enableGeneration", "Customization", true, "config.debugGeneration", "config.debugGeneration.name");

      // volume_change_megalamp = config.getFloat("vol_megalamp", "blocks", 3.0F, 0.5F, 5.0F, I18n.translateToLocal("config.vol_megalamp"), "config.vol_megalamp.name");
    //   volume_change_sovietlamp = config.getFloat("vol_sovietlamp", "blocks", 3.0F, 0.5F, 5.0F, I18n.translateToLocal("config.vol_sovietlamp"), "config.vol_sovietlamp.name");

       config.save();
   }
}