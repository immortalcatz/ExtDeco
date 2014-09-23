package neo.extdeco.handlers;

import neo.extdeco.blocks.BlocksExtDeco;
import neo.extdeco.containers.ContainerFreezer;
import neo.extdeco.guis.GuiFreezer;
import neo.extdeco.tileentitys.TileEntityFreezer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandlerExtDeco implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		switch (id) {
		case 0:
			return new ContainerFreezer(player.inventory, (TileEntityFreezer) tileEntity);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		switch (id) {
		case 0:
			return new GuiFreezer(player.inventory, (TileEntityFreezer) tileEntity);
		}
		return null;
	}
}