package neo.extdeco.blocks;

import neo.extdeco.init.ExtDeco;
import neo.extdeco.items.ItemMarbleBlock;
import neo.extdeco.items.ItemMarbleBrickBlock;
import neo.extdeco.items.ItemOtherStuff;
import neo.extdeco.items.ItemMarbleSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlocksExtDeco {
	
	public static BlockFence whiteMarbleFence;
	public static Block marble,marbleSlabSingle,marbleSlabDouble,otherStuffSlabSingle,otherStuffSlabDouble,marbleBrick,marbleBrickSlabSingle,marbleBrickSlabDouble,freezer,freezerOn;
	
	public static Block yellowFlowerPotteryWhite,yellowFlowerPotteryBlack,orangeFlowerPotteryWhite,orangeFlowerPotteryBlack,redFlowerPotteryWhite,redFlowerPotteryBlack;
	public static Block whiteFlowerPotteryWhite,whiteFlowerPotteryBlack;
	
	public static Block cactusPotteryWhite,cactusPotteryBlack;
	public static Block buchsPotteryWhite,buchsPotteryBlack;

	public void oldInit() {
		
		//Brick/Normal and half 
		marble = new BlockMarble().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockName("marble").setBlockTextureName(ExtDeco.MODID + ":" + "marble");
		GameRegistry.registerBlock(marble, ItemMarbleBlock.class, "marble");
		
		marbleSlabSingle = new BlockMarbleSlabs(false, Material.rock).setBlockName(ExtDeco.MODID + ":" + "marble");
		marbleSlabDouble = new BlockMarbleSlabs(true, Material.rock).setBlockName(ExtDeco.MODID + ":" + "marble");
		
		GameRegistry.registerBlock(marbleSlabSingle, ItemMarbleSlab.class, "blockMarbleSlabSingle");
		GameRegistry.registerBlock(marbleSlabDouble, ItemMarbleSlab.class, "blockMarbleSlabDouble");
		
		otherStuffSlabSingle = new BlockOtherStuff(false, Material.rock).setBlockName(ExtDeco.MODID + ":" + "otherStuff");
		otherStuffSlabDouble = new BlockOtherStuff(true, Material.rock).setBlockName(ExtDeco.MODID + ":" + "otherStuff");
		
		GameRegistry.registerBlock(otherStuffSlabSingle, ItemOtherStuff.class, "blockOtherStuffSlabSingle");
		GameRegistry.registerBlock(otherStuffSlabDouble, ItemOtherStuff.class, "blockOtherStuffSlabDouble");
	    
	    //Fences
	    whiteMarbleFence = new BlockMarbleFence("marbleWhite", "whiteMarbleFence", Material.rock);
	    GameRegistry.registerBlock(whiteMarbleFence, "whiteMarbleFence");
	    
		//Freezer
		freezer= new BlockFreezer("freezer", 2F, false).setCreativeTab(ExtDeco.tabExtDeco);;
		GameRegistry.registerBlock(freezer, "freezer");		
				
		freezerOn = new BlockFreezer("freezer", 2F, true);
		GameRegistry.registerBlock(freezerOn, "freezerOn");
	}
	
	public void init() {
		
		/** Yellow Flower Pottery's*/
		yellowFlowerPotteryWhite = new BlockPottery(0);
		GameRegistry.registerBlock(yellowFlowerPotteryWhite, "yellowFlowerPotteryWhite");		
		yellowFlowerPotteryBlack = new BlockPottery(1);
		GameRegistry.registerBlock(yellowFlowerPotteryBlack, "yellowFlowerPotteryBlack");
		
		/** Orange Flower Pottery's*/
		orangeFlowerPotteryWhite = new BlockPottery(0);
		GameRegistry.registerBlock(orangeFlowerPotteryWhite, "orangeFlowerPotteryWhite");		
		orangeFlowerPotteryBlack = new BlockPottery(1);
		GameRegistry.registerBlock(orangeFlowerPotteryBlack, "orangeFlowerPotteryBlack");
		
		/** Red Flower Pottery's*/
		redFlowerPotteryWhite = new BlockPottery(0);
		GameRegistry.registerBlock(redFlowerPotteryWhite, "redFlowerPotteryWhite");		
		redFlowerPotteryBlack = new BlockPottery(1);
		GameRegistry.registerBlock(redFlowerPotteryBlack, "redFlowerPotteryBlack");

		/** White Flower Pottery's*/
		whiteFlowerPotteryWhite = new BlockPottery(0);
		GameRegistry.registerBlock(whiteFlowerPotteryWhite, "whiteFlowerPotteryWhite");		
		whiteFlowerPotteryBlack = new BlockPottery(1);
		GameRegistry.registerBlock(whiteFlowerPotteryBlack, "whiteFlowerPotteryBlack");
		
		
		
		/** Cactus Flower Pottery's*/
		cactusPotteryWhite = new BlockPottery(0);
		GameRegistry.registerBlock(cactusPotteryWhite, "cactusPotteryWhite");		
		cactusPotteryBlack = new BlockPottery(1);
		GameRegistry.registerBlock(cactusPotteryBlack, "cactusPotteryBlack");
		
		
		
		/** Buchs Flower Pottery's*/
		buchsPotteryWhite = new BlockPottery(0);
		GameRegistry.registerBlock(buchsPotteryWhite, "buchsPotteryWhite");		
		buchsPotteryBlack = new BlockPottery(1);
		GameRegistry.registerBlock(buchsPotteryBlack, "buchsPotteryBlack");
		
		/*for (Block var12: GameRegistry.findBlock(ExtDeco.MODID, Blocks.fence.getUnlocalizedName()) {

    	}
		String vanillaFenceName = Blocks.fence.getLocalizedName();
		Block vanillaFenceBlock = Block.getBlockFromName(vanillaFenceName);
		vanillaFenceBlock = null;*/
	}
}