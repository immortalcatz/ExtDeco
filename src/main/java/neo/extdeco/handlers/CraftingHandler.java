package neo.extdeco.handlers;

import neo.extdeco.blocks.BlocksExtDeco;
import neo.extdeco.recipes.RecipesFreezer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingHandler {

	private static BlocksExtDeco block = new BlocksExtDeco();
	private static RecipesFreezer recipesFreezer = new RecipesFreezer().smelting();

	public void oldInit() {

		oldInitMarbleRecipes();
		oldInitSlabRecipes();
		oldInitFreezerRecipes();
	}

	public void init() {

	}
	
    private void oldInitMarbleRecipes() {    	
    	/** White Bricks */
    	GameRegistry.addRecipe(new ItemStack(block.marbleBrick, 1, 0), new Object[]{
 		   "MM",
 			'M', new ItemStack(block.marble, 1, 0)
 	    });   	
    	/** Black Bricks */
    	GameRegistry.addRecipe(new ItemStack(block.marbleBrick, 1, 1), new Object[]{
 		   "MM",
 			'M', new ItemStack(block.marble, 1, 1)
 	    });
    	/** Yellow Bricks */
    	GameRegistry.addRecipe(new ItemStack(block.marbleBrick, 1, 2), new Object[]{
 		   "MM",
 			'M', new ItemStack(block.marble, 1, 2)
 	    });
    	/** Ice Bricks */
    	GameRegistry.addRecipe(new ItemStack(block.marbleBrick, 1, 3), new Object[]{
  		   "MM",
  			'M', new ItemStack(Blocks.ice, 1)
  	    });
    	/** Ice Smooth */
    	GameRegistry.addRecipe(new ItemStack(block.marbleBrick, 1, 4), new Object[]{
  		   "MM",
  			'M', new ItemStack(block.marbleBrick, 1, 3)
  	    });
    	/** Snow Bricks */
    	GameRegistry.addRecipe(new ItemStack(block.marbleBrick, 1, 5), new Object[]{
  		   "MM",
  			'M', new ItemStack(Blocks.snow, 1)
  	    });
	}

	private void oldInitSlabRecipes() {
		/** White Bricks */
    	GameRegistry.addRecipe(new ItemStack(block.marbleSlabSingle, 3, 0), new Object[]{
 		  "MMM",
 			'M', new ItemStack(block.marble, 1, 0)
 	    });   	
    	/** Black Bricks */
    	GameRegistry.addRecipe(new ItemStack(block.marbleSlabSingle, 3, 1), new Object[]{
    	  "MMM",
 			'M', new ItemStack(block.marble, 1, 1)
 	    });
    	/** Yellow Bricks */
    	GameRegistry.addRecipe(new ItemStack(block.marbleSlabSingle, 3, 2), new Object[]{
 		  "MMM",
 			'M', new ItemStack(block.marble, 1, 2)
 	    });    	   	
	}

	private void oldInitFreezerRecipes() {
		//Freezer
    	GameRegistry.addRecipe(new ItemStack(block.freezer), new Object[]{
			  "CSC",
			  "SSS",
			  "CSC", 'S', Blocks.snow, 'C', Blocks.cobblestone
	    }); 
    	//Ice Block Recipe
		recipesFreezer.addRecipe(Items.water_bucket, new ItemStack(Blocks.ice), 0.4F);
	}

	public void peacefulInit() {
		
	}
}