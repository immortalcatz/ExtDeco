package neo.extdeco.init;

import neo.extdeco.handlers.GuiHandlerExtDeco;
import neo.extdeco.tileentitys.TileEntityFreezer;
import neo.extdeco.tileentitys.TileEntityPottery;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy {

	public void registerRenderThings() {

	}
	
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityFreezer.class, "tileEntityFreezer");
		GameRegistry.registerTileEntity(TileEntityPottery.class, "tileEntityPottery");
	}

	public void registerNetwork() {
		NetworkRegistry.INSTANCE.registerGuiHandler(ExtDeco.modInstance, new GuiHandlerExtDeco());
	}
}