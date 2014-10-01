package neo.extdeco.blocks;

import neo.extdeco.init.ExtDeco;
import neo.extdeco.items.ItemMarbleBlock;
import neo.extdeco.items.ItemMarbleBrickBlock;
import neo.extdeco.items.ItemMarbleBrickSlab;
import neo.extdeco.items.ItemMarbleSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlocksExtDeco {
	
	public static BlockFence whiteMarbleFence;
	public static Block marble,marbleSlabSingle,marbleSlabDouble,marbleBrick,marbleBrickSlabSingle,marbleBrickSlabDouble,freezer,freezerOn;
	
	public static Block yellowFlowerPotteryWhite,yellowFlowerPotteryBlack,orangeFlowerPotteryWhite,orangeFlowerPotteryBlack,redFlowerPotteryWhite,redFlowerPotteryBlack;
	public static Block whiteFlowerPotteryWhite,whiteFlowerPotteryBlack;
	
	public static Block cactusPotteryWhite,cactusPotteryBlack;
	public static Block buchsPotteryWhite,buchsPotteryBlack;

	public void oldInit() {
		
		//Normal and half
		marble = new BlockMarble().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockName("marble").setBlockTextureName(ExtDeco.MODID + ":" + "marble");
		GameRegistry.registerBlock(marble, ItemMarbleBlock.class, marble.getLocalizedName().substring(3));
		
		marbleSlabSingle = new BlockMarbleSlabs(false, Material.rock, 3, marbleSlabSingle, marble, 0);
		marbleSlabDouble = new BlockMarbleSlabs(true, Material.rock, 3, marbleSlabSingle, marble, 0);
	    
	    GameRegistry.registerBlock(marbleSlabSingle, ItemMarbleSlab.class, "marbleSlabSingle");
	    GameRegistry.registerBlock(marbleSlabDouble, ItemMarbleSlab.class, "marbleSlabDouble");
	    
	    //Brick's
		marbleBrick = new BlockMarbleBrick().setHardness(2.2F).setStepSound(Block.soundTypeStone).setBlockName("marbleBrick").setBlockTextureName(ExtDeco.MODID + ":" + "marbleBrick");
	    GameRegistry.registerBlock(marbleBrick, ItemMarbleBrickBlock.class, marbleBrick.getLocalizedName().substring(6));
		
	    marbleBrickSlabSingle = new BlockMarbleSlabs(false, Material.rock, 6, marbleBrickSlabSingle, marbleBrick, 0).setLightOpacity(3).setBlockName(ExtDeco.MODID + ":" + "marbleBrickSlabSingle");
		marbleBrickSlabDouble = new BlockMarbleSlabs(true, Material.rock, 6, marbleBrickSlabSingle, marbleBrick, 0).setLightOpacity(3).setBlockName(ExtDeco.MODID + ":" + "marbleBrickSlabDouble");
	    
	    GameRegistry.registerBlock(marbleBrickSlabSingle, ItemMarbleBrickSlab.class, "marbleBrickSlabSingle");
	    GameRegistry.registerBlock(marbleBrickSlabDouble, ItemMarbleBrickSlab.class, "marbleBrickSlabDouble");	    
	    
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
		yellowFlowerPotteryWhite = new BlockPottery("yellowFlowerPotteryWhite", "white");
		GameRegistry.registerBlock(yellowFlowerPotteryWhite, "yellowFlowerPotteryWhite");		
		yellowFlowerPotteryBlack = new BlockPottery("yellowFlowerPotteryBlack", "black");
		GameRegistry.registerBlock(yellowFlowerPotteryBlack, "yellowFlowerPotteryBlack");
		
		/** Orange Flower Pottery's*/
		orangeFlowerPotteryWhite = new BlockPottery("orangeFlowerPotteryWhite", "white");
		GameRegistry.registerBlock(orangeFlowerPotteryWhite, "orangeFlowerPotteryWhite");		
		orangeFlowerPotteryBlack = new BlockPottery("orangeFlowerPotteryBlack", "black");
		GameRegistry.registerBlock(orangeFlowerPotteryBlack, "orangeFlowerPotteryBlack");
		
		/** Red Flower Pottery's*/
		redFlowerPotteryWhite = new BlockPottery("redFlowerPotteryWhite", "white");
		GameRegistry.registerBlock(redFlowerPotteryWhite, "redFlowerPotteryWhite");		
		redFlowerPotteryBlack = new BlockPottery("redFlowerPotteryBlack", "black");
		GameRegistry.registerBlock(redFlowerPotteryBlack, "redFlowerPotteryBlack");

		/** White Flower Pottery's*/
		whiteFlowerPotteryWhite = new BlockPottery("whiteFlowerPotteryWhite", "white");
		GameRegistry.registerBlock(whiteFlowerPotteryWhite, "whiteFlowerPotteryWhite");		
		whiteFlowerPotteryBlack = new BlockPottery("whiteFlowerPotteryBlack", "black");
		GameRegistry.registerBlock(whiteFlowerPotteryBlack, "whiteFlowerPotteryBlack");
		
		
		
		/** Cactus Flower Pottery's*/
		cactusPotteryWhite = new BlockPottery("cactusPotteryWhite", "white");
		GameRegistry.registerBlock(cactusPotteryWhite, "cactusPotteryWhite");		
		cactusPotteryBlack = new BlockPottery("cactusPotteryBlack", "black");
		GameRegistry.registerBlock(cactusPotteryBlack, "cactusPotteryBlack");
		
		
		
		/** Buchs Flower Pottery's*/
		buchsPotteryWhite = new BlockPottery("buchsPotteryWhite", "white");
		GameRegistry.registerBlock(buchsPotteryWhite, "buchsPotteryWhite");		
		buchsPotteryBlack = new BlockPottery("buchsPotteryBlack", "black");
		GameRegistry.registerBlock(buchsPotteryBlack, "buchsPotteryBlack");
		
		/*for (Block var12: GameRegistry.findBlock(ExtDeco.MODID, Blocks.fence.getUnlocalizedName()) {

    	}
		String vanillaFenceName = Blocks.fence.getLocalizedName();
		Block vanillaFenceBlock = Block.getBlockFromName(vanillaFenceName);
		vanillaFenceBlock = null;*/
	}
}