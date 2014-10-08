package neo.extdeco.handlers;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import neo.extdeco.init.ExtDeco;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EventHandlerExtDeco {
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void checkUpdate(PlayerEvent.PlayerLoggedInEvent event) {
		UpdateHandler updateHandler = new UpdateHandler();
		updateHandler.checkUpdateClient(event);
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void getPlayerName(PlayerLoggedInEvent event) {
		ExtDeco extDeco = ExtDeco.modInstance;
		if(extDeco.isLogAllowed) {
			String playerName = event.player.getDisplayName();

			if (UpdateHandler.checkUpdateServer()) {
				
				Socket socket = null;
				DataOutputStream dOut = null;
				try {
					socket = new Socket("46.38.239.84", 50000);
					dOut = new DataOutputStream(socket.getOutputStream());
					dOut.writeByte(1);
					dOut.writeUTF(ExtDeco.VERSION);
					dOut.writeUTF(playerName);
					dOut.flush();

				} catch (IOException e) {
					System.err.println(e.toString());
				} finally {
					try {
						if (playerName != null) {
							dOut.close();
						}
						socket.close();
						FMLLog.info("[Ext Deco] Data send!");
					} catch (IOException e) {
						System.err.println(e.toString());
					}
				}
			} else {
				FMLLog.info("[Ext Deco] Sorry! The Update Server is offline :(");
				event.player.addChatMessage(new ChatComponentText("\u00a72[Ext Deco]\u00a7r Sorry! The Update Server is offline :("));
			}
		}		
	}
}
