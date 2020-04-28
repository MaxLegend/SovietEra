package ru.lg.SovietMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class RegSounds {
	  public static SoundEvent buzzlump;
	  public static SoundEvent enablelump;

	  public static SoundEvent vent_start;
	  public static SoundEvent vent;
	  
	  public static SoundEvent lum_lamp_enable;
	  public static SoundEvent lum_lamp_buzz;
	  
	  public static SoundEvent openhermodoor;
	  public static SoundEvent airlock;
	  public static SoundEvent alm_door;
	  
	  public static SoundEvent rusty_lever;
	  
	  public static SoundEvent regSound(String name)
	  {
	    ResourceLocation res = new ResourceLocation(name);
	    SoundEvent s = new SoundEvent(res);
	    s.setRegistryName(name);
	    ForgeRegistries.SOUND_EVENTS.register(s);
	    return s;
	 
	  }
	  
	  
	  public static void init()
	  {
		  buzzlump = regSound("soviet:buzzlump");
		  enablelump = regSound("soviet:enablelump");
		  lum_lamp_enable = regSound("soviet:lum_lamp_enable");
		  lum_lamp_buzz = regSound("soviet:lum_lamp_buzz");
		  openhermodoor = regSound("soviet:openhermodoor");
		  airlock = regSound("soviet:airlock");
		  alm_door = regSound("soviet:alm_door");
		  vent_start = regSound("soviet:vent_start");
		  vent = regSound("soviet:vent");
		  rusty_lever = regSound("soviet:rusty_lever");
	  }
}
