package neo.extdeco.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockFence;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class ItemsExtDeco {
	
	public static Item emptyPotteryWhite, emptyPotteryBlack;
	
	public void init() {
		
		/**Empty Pottery's */
		emptyPotteryWhite = new ItemPottery(true, "emptyPotteryWhite", "emptyPotteryWhite", Blocks.bed);
		GameRegistry.registerItem(emptyPotteryWhite, "emptyPotteryWhite");
		
		emptyPotteryBlack = new ItemPottery(true, "emptyPotteryBlack", "emptyPotteryBlack", Blocks.bedrock);
		GameRegistry.registerItem(emptyPotteryBlack, "emptyPotteryBlack");
		
		/**Flower Pottery's */
		
	}
}
