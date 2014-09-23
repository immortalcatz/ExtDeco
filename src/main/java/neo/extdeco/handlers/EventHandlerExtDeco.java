package neo.extdeco.handlers;

import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class EventHandlerExtDeco {
	
	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event) {
		UpdateHandler updateHandler = new UpdateHandler();
		updateHandler.checkUpdateClient(event);
	}

}
