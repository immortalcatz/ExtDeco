package neo.extdeco.blocks;

import neo.extdeco.init.ExtDeco;
import neo.extdeco.items.ItemMarbleBrickSlab;
import neo.extdeco.items.ItemMarbleSlab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlocksExtDeco {
	
	public static Block marble,marbleSlabSingle,marbleSlabDouble,marbleBrick,marbleBrickSlabSingle,marbleBrickSlabDouble,freezer,freezerOn;
	public static BlockFence whiteMarbleFence;

	public void init() {
		
		//Normal and half
		marble = new BlockMarble().setHardness(1.2F).setStepSound(Block.soundTypeStone).setBlockName("marble").setBlockTextureName(ExtDeco.MODID + ":" + "marble");
		GameRegistry.registerBlock(marble, "marble");
		
		marbleSlabSingle = new BlockMarbleSlabs(false, Material.rock, 3, marbleSlabSingle, marble, 0).setBlockName(ExtDeco.MODID + ":" + "marbleSlabSingle");
		marbleSlabDouble = new BlockMarbleSlabs(true, Material.rock, 3, marbleSlabSingle, marble, 0).setBlockName(ExtDeco.MODID + ":" + "marbleSlabDouble");
	    
	    GameRegistry.registerBlock(marbleSlabSingle, ItemMarbleSlab.class, marbleSlabSingle.getLocalizedName().substring(3));
	    GameRegistry.registerBlock(marbleSlabDouble, ItemMarbleSlab.class, marbleSlabDouble.getLocalizedName().substring(3));
	    
	    
	    //Brick's
	    marbleBrick = new BlockMarbleBrick().setHardness(2.2F).setStepSound(Block.soundTypeStone).setBlockName("marbleBrick").setBlockTextureName(ExtDeco.MODID + ":" + "marbleBrick");
		GameRegistry.registerBlock(marbleBrick, "marbleBrick");
		
		marbleBrickSlabSingle = new BlockMarbleSlabs(false, Material.rock, 6, marbleBrickSlabSingle, marbleBrick, 0).setLightOpacity(3).setBlockName(ExtDeco.MODID + ":" + "marbleBrickSlabSingle");
		marbleBrickSlabDouble = new BlockMarbleSlabs(true, Material.rock, 6, marbleBrickSlabSingle, marbleBrick, 0).setLightOpacity(3).setBlockName(ExtDeco.MODID + ":" + "marbleBrickSlabDouble");
	    
	    GameRegistry.registerBlock(marbleBrickSlabSingle, ItemMarbleBrickSlab.class, marbleBrickSlabSingle.getUnlocalizedName().substring(6));
	    GameRegistry.registerBlock(marbleBrickSlabDouble, ItemMarbleBrickSlab.class, marbleBrickSlabDouble.getUnlocalizedName().substring(6));
	    
	    
	    //Fences
	    whiteMarbleFence = new BlockMarbleFence("marbleWhite", "whiteMarbleFence", Material.rock);
	    GameRegistry.registerBlock(whiteMarbleFence, "whiteMarbleFence");
		
	    
		//Freezer
		freezer= new BlockFreezer("freezer", 2F, false).setCreativeTab(ExtDeco.tabExtDeco);;
		GameRegistry.registerBlock(freezer, "freezer");		
				
		freezerOn = new BlockFreezer("freezer", 2F, true);
		GameRegistry.registerBlock(freezerOn, "freezerOn");
	}
}