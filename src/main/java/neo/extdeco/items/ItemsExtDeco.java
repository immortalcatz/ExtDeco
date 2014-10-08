package neo.extdeco.items;

import cpw.mods.fml.common.registry.GameRegistry;
import neo.extdeco.blocks.BlocksExtDeco;
import net.minecraft.block.BlockFence;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class ItemsExtDeco {
	
	public static Item buchsItem;
	public static Item emptyPotteryWhite, emptyPotteryBlack;
	
	public static Item yellowFlowerPotteryWhite,yellowFlowerPotteryBlack,orangeFlowerPotteryWhite,orangeFlowerPotteryBlack,redFlowerPotteryWhite, redFlowerPotteryBlack;
	public static Item whiteFlowerPotteryWhite,whiteFlowerPotteryBlack;
	
	public static Item cactusPotteryWhite,cactusPotteryBlack;
	public static Item buchsPotteryWhite,buchsPotteryBlack;
	
	public void init() {
		
		/**Crafting Items */
		buchsItem = new ItemPottery(true, "buchsItem", null);
		GameRegistry.registerItem(buchsItem, "buchsItem");
		
		/**Empty Pottery's */
		emptyPotteryWhite = new ItemPottery(true, "emptyPotteryWhite", null);
		GameRegistry.registerItem(emptyPotteryWhite, "itemEmptyPotteryWhite");		
		emptyPotteryBlack = new ItemPottery(true, "emptyPotteryBlack", null);
		GameRegistry.registerItem(emptyPotteryBlack, "itemEmptyPotteryBlack");
		

		
		/** Yellow Flower Pottery's*/
		yellowFlowerPotteryWhite = new ItemPottery(false, "yellowFlowerPotteryWhite", BlocksExtDeco.yellowFlowerPotteryWhite);
		GameRegistry.registerItem(yellowFlowerPotteryWhite, "itemYellowFlowerPotteryWhite");		
		yellowFlowerPotteryBlack = new ItemPottery(false, "yellowFlowerPotteryBlack", BlocksExtDeco.yellowFlowerPotteryBlack);
		GameRegistry.registerItem(yellowFlowerPotteryBlack, "itemYellowFlowerPotteryBlack");
		
		/** Orange Flower Pottery's*/
		orangeFlowerPotteryWhite = new ItemPottery(false, "orangeFlowerPotteryWhite", BlocksExtDeco.orangeFlowerPotteryWhite);
		GameRegistry.registerItem(orangeFlowerPotteryWhite, "itemOrangeFlowerPotteryWhite");		
		orangeFlowerPotteryBlack = new ItemPottery(false, "orangeFlowerPotteryBlack", BlocksExtDeco.orangeFlowerPotteryBlack);
		GameRegistry.registerItem(orangeFlowerPotteryBlack, "itemOrangeFlowerPotteryBlack");
		
		/** Red Flower Pottery's*/
		redFlowerPotteryWhite = new ItemPottery(false, "redFlowerPotteryWhite", BlocksExtDeco.redFlowerPotteryWhite);
		GameRegistry.registerItem(redFlowerPotteryWhite, "itemRedFlowerPotteryWhite");		
		redFlowerPotteryBlack = new ItemPottery(false, "redFlowerPotteryBlack", BlocksExtDeco.redFlowerPotteryBlack);
		GameRegistry.registerItem(redFlowerPotteryBlack, "itemRedFlowerPotteryBlack");
		
		/** White Flower Pottery's*/
		whiteFlowerPotteryWhite = new ItemPottery(false, "whiteFlowerPotteryWhite", BlocksExtDeco.whiteFlowerPotteryWhite);
		GameRegistry.registerItem(whiteFlowerPotteryWhite, "itemWhiteFlowerPotteryWhite");		
		whiteFlowerPotteryBlack = new ItemPottery(false, "whiteFlowerPotteryBlack", BlocksExtDeco.whiteFlowerPotteryBlack);
		GameRegistry.registerItem(whiteFlowerPotteryBlack, "itemWhiteFlowerPotteryBlack");
		
		
		
		/** Cactus Flower Pottery's*/
		cactusPotteryWhite = new ItemPottery(false, "cactusPotteryWhite", BlocksExtDeco.cactusPotteryWhite);
		GameRegistry.registerItem(cactusPotteryWhite, "itemCactusPotteryWhite");		
		cactusPotteryBlack = new ItemPottery(false, "cactusPotteryBlack", BlocksExtDeco.cactusPotteryBlack);
		GameRegistry.registerItem(cactusPotteryBlack, "itemcactusPotteryBlack");
		
		
		
		/** Buchs Flower Pottery's*/
		buchsPotteryWhite = new ItemPottery(false, "buchsPotteryWhite", BlocksExtDeco.buchsPotteryWhite);
		GameRegistry.registerItem(buchsPotteryWhite, "itemBuchsPotteryWhite");	
		buchsPotteryBlack = new ItemPottery(false, "buchsPotteryBlack", BlocksExtDeco.buchsPotteryBlack);
		GameRegistry.registerItem(buchsPotteryBlack, "itemBuchsPotteryBlack");
	}
}
