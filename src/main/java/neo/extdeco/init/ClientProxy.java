package neo.extdeco.init;

import neo.extdeco.blocks.BlockPottery;
import neo.extdeco.blocks.BlocksExtDeco;
import neo.extdeco.tileentitys.TileEntityPottery;
import neo.extdeco.tileentitys.TileEntityPotteryRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends ServerProxy {
	
	@Override
	public void registerRenderThings() {
		System.out.println("ClientProxy: " + BlockPottery.potteryTextureAndName);
		ClientRegistry.registerTileEntity(TileEntityPottery.class, "PotterytileEntity", new TileEntityPotteryRenderer());
	}
}