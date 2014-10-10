package neo.extdeco.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemMarbleBlock extends ItemBlock {

	public ItemMarbleBlock(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack) {
		String name = "";
		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "White";
			break;
		}
		case 1: {
			name = "Black";
			break;
		}
		case 2: {
			name = "Yellow";
			break;
		}
		case 3: {
			name = "BrickWhite";
			break;
		}
		case 4: {
			name = "BrickBlack";
			break;
		}
		case 5: {
			name = "BrickYellow";
			break;
		}
		case 6: {
			name = "BrickSnow";
			break;
		}
		default:
			name = "broken";
		}
		return "extdeco:marble" + name;
	}

	@Override
	public int getMetadata(int par1) {
		return par1;
	}
}