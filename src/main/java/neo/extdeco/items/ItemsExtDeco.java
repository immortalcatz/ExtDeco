package neo.extdeco.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockFence;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class ItemsExtDeco {
	
	public static Item emptyPotteryWhite, emptyPotteryBlack, redFlowerPotteryWhite, redFlowerPotteryBlack;
	
	public void init() {
		
		/**Empty Pottery's */
		emptyPotteryWhite = new ItemPottery(true, "emptyPottery", "White", null);
		GameRegistry.registerItem(emptyPotteryWhite, "0");
		
		emptyPotteryBlack = new ItemPottery(true, "emptyPottery", "Black", null);
		GameRegistry.registerItem(emptyPotteryBlack, "1");
		
		/**Flower Pottery's */
		redFlowerPotteryWhite = new ItemPottery(false, "redFlowerPottery", "White", Blocks.bedrock);
		redFlowerPotteryBlack = new ItemPottery(false, "redFlowerPottery", "Black", Blocks.dirt);
		GameRegistry.registerItem(redFlowerPotteryWhite, "2");
		GameRegistry.registerItem(redFlowerPotteryBlack, "3");
	}
}
