package neo.extdeco.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemOtherStuff extends ItemBlock {

	public ItemOtherStuff(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";
		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "BrickIce";
			break;
		}
		case 1: {
			name = "IceSmooth";
			break;
		}
		case 2: {
			name = "BrickSnow";
			break;
		}
		default:
			name = "broken";
		}
		return "extdeco:otherStuff" + name;
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}