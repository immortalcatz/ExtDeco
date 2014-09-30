package neo.extdeco.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;

public class ItemEmptyPottery extends Item {

	public ItemEmptyPottery() {
		super();
	}
	
	@SideOnly(Side.CLIENT)
	public String getTextureFile(){
		return "/ExtDecoMod/items.png";
	}
}