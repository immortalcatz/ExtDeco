package neo.extdeco.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import neo.extdeco.init.ExtDeco;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UpdateHandler {

	 /**
     * Start Update Checker for the CLIENT Side
	 * @return 
     */
	@SideOnly(Side.CLIENT)
    public void checkUpdateClient(PlayerLoggedInEvent event) {    	   	   	
    	if (checkUpdateServer()) {
    		try {
	            URL urlVersion = new URL("http://46.38.239.84/neo/updater/ExtDecoUpdate");
	            URL urlInfo = new URL("http://46.38.239.84/neo/updater/ExtDecoUpdateInfo");
	            BufferedReader readerVersion = new BufferedReader(new InputStreamReader(urlVersion.openStream()));
	            BufferedReader readerInfo = new BufferedReader(new InputStreamReader(urlInfo.openStream()));
	            String updateInfo = readerInfo.readLine();
	            String clientVersion = ExtDeco.VERSION;
	            
	            String updateVersion;

	            while ((updateVersion = readerVersion.readLine()) != null) 
	            {
	                if (updateVersion.endsWith(clientVersion)) {	                	
	                    FMLLog.info("[Ext Deco] Your version is UpToDate: v" + updateVersion);
	                } else {
	                    FMLLog.info("[Ext Deco] A new version is available: v" + updateVersion);
	                    event.player.addChatMessage(new ChatComponentText("\u00a72[Ext Deco]\u00a7r A new version is available: " + updateVersion));
	                    event.player.addChatMessage(new ChatComponentText("\u00a72[Ext Deco]\u00a7r New features of " + updateVersion + ": " + updateInfo));
	                    event.player.addChatMessage(new ChatComponentText("\u00a72[Ext Deco]\u00a7r Your version is: " + clientVersion));
	                }
	            }
	            readerVersion.close();
	            readerInfo.close();
	        }
	        catch (Exception e) {
	        	e.printStackTrace();
	        }
    	} else {
    		FMLLog.info("[Ext Deco] Sorry! The Update Server is offline :(");
    		event.player.addChatMessage(new ChatComponentText("\u00a72[Ext Deco]\u00a7r Sorry! The Update Server is offline :("));
    	}
    }

	/**
	 * Check if Update Server Online
	 * 
	 * @return : Network status
	 */
	private boolean checkUpdateServer() {
		InputStreamReader inputStreamReader = null;
		try {
			URL url = new URL("http://46.38.239.84/neo/updater/ExtDecoUpdate");
			inputStreamReader = new InputStreamReader(url.openStream());
			if (inputStreamReader.ready()) {
				inputStreamReader.close();
				return true;
			}
			inputStreamReader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}