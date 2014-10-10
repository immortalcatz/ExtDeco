package neo.extdeco.blocks;

import neo.extdeco.init.ExtDeco;
import neo.extdeco.items.ItemMarbleBlock;
import neo.extdeco.items.ItemMarbleSlab;
import neo.extdeco.items.ItemOtherStuff;
import neo.extdeco.items.ItemOtherStuffSlab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlocksExtDeco {
	
	public static Block marble,otherStuff,marbleSlabSingle,marbleSlabDouble,otherStuffSlabSingle,otherStuffSlabDouble,freezer,freezerOn;
	
	public static Block yellowFlowerPotteryWhite,yellowFlowerPotteryBlack,orangeFlowerPotteryWhite,orangeFlowerPotteryBlack,redFlowerPotteryWhite,redFlowerPotteryBlack;
	public static Block whiteFlowerPotteryWhite,whiteFlowerPotteryBlack;
	
	public static Block cactusPotteryWhite,cactusPotteryBlack;
	public static Block buchsPotteryWhite,buchsPotteryBlack;

	public static void oldInit() {
		
		
		
		/** Normal Marble Block */ 
		marble = new BlockMarble().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockName("marble").setBlockTextureName(ExtDeco.MODID + ":" + "marble");
		GameRegistry.registerBlock(marble, ItemMarbleBlock.class, "marble");
	
		otherStuff = new BlockOtherStuff().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeGlass).setBlockName("marble").setBlockTextureName(ExtDeco.MODID + ":" + "otherStuff");
		GameRegistry.registerBlock(otherStuff, ItemOtherStuff.class, "otherStuff");

		/** Brick/Normal and half */
		marbleSlabSingle = new BlockMarbleSlabs(false, Material.rock).setBlockName(ExtDeco.MODID + ":" + "marble");
		marbleSlabDouble = new BlockMarbleSlabs(true, Material.rock).setBlockName(ExtDeco.MODID + ":" + "marble");
		
		GameRegistry.registerBlock(marbleSlabSingle, ItemMarbleSlab.class, "blockMarbleSlabSingle");
		GameRegistry.registerBlock(marbleSlabDouble, ItemMarbleSlab.class, "blockMarbleSlabDouble");
		
		otherStuffSlabSingle = new BlockOtherStuffSlab(false, Material.rock).setStepSound(Block.soundTypeGlass).setBlockName(ExtDeco.MODID + ":" + "otherStuff");
		otherStuffSlabDouble = new BlockOtherStuffSlab(true, Material.rock).setStepSound(Block.soundTypeGlass).setBlockName(ExtDeco.MODID + ":" + "otherStuff");
		
		GameRegistry.registerBlock(otherStuffSlabSingle, ItemOtherStuffSlab.class, "blockOtherStuffSlabSingle");
		GameRegistry.registerBlock(otherStuffSlabDouble, ItemOtherStuffSlab.class, "blockOtherStuffSlabDouble");
	    
		//Freezer
		freezer= new BlockFreezer("freezer", 2F, false).setCreativeTab(ExtDeco.tabExtDeco);;
		GameRegistry.registerBlock(freezer, "freezer");		
				
		freezerOn = new BlockFreezer("freezer", 2F, true);
		GameRegistry.registerBlock(freezerOn, "freezerOn");
	}
	
	public static void init() {
		
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
		
		
		
		/** Buchs Pottery's*/
		buchsPotteryWhite = new BlockPottery(0);
		GameRegistry.registerBlock(buchsPotteryWhite, "buchsPotteryWhite");		
		buchsPotteryBlack = new BlockPottery(1);
		GameRegistry.registerBlock(buchsPotteryBlack, "buchsPotteryBlack");
		
		GameRegistry.addRecipe(new ItemStack(Blocks.bed, 1), new Object[]{
	 		   "MM",
	 			'M', new ItemStack(Blocks.stone)
	 	    });   
	}
	
	
}