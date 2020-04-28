package ru.lg.SovietMod.Event;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.lg.SovietMod.RegItems;
import ru.lg.SovietMod.API.IHasModel;

public class RegistryEvents {
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
			
	/*		if(RegItems.lab_coat instanceof IHasModel)
			{
				((IHasModel)RegItems.lab_coat).registerModels();
			}*/
		
		
	}
}
