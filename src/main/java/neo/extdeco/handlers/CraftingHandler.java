package neo.extdeco.handlers;

import neo.extdeco.blocks.BlocksExtDeco;
import neo.extdeco.init.ExtDeco;
import neo.extdeco.recipes.RecipesFreezer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingHandler {

	private static RecipesFreezer recipesFreezer = new RecipesFreezer().smelting();

	public static void oldInit() {

		oldInitMarbleRecipes();
		oldInitSlabRecipes();
		oldInitFreezerRecipes();
	}

	public static void init() {

	}
	
    private static void oldInitMarbleRecipes() {
    	/** White Bricks */
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.marble, 1, 3), new Object[]{
  		   "MM",
  			'M', new ItemStack(BlocksExtDeco.marble, 1, 0)
  	    });
    	/** Black Bricks */
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.marble, 1, 4), new Object[]{
 		   "MM",
 			'M', new ItemStack(BlocksExtDeco.marble, 1, 1)
 	    });
    	/** Yellow Bricks */
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.marble, 1, 5), new Object[]{
 		   "MM",
 			'M', new ItemStack(BlocksExtDeco.marble, 1, 2)
 	    });
    	
    	
    	/** Ice Bricks */
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.otherStuff, 1, 0), new Object[]{
  		   "MM",
  			'M', Blocks.ice
  	    });
    	/** Ice Smooth */
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.otherStuff, 1, 1), new Object[]{
  		   "MM",
  			'M', new ItemStack(BlocksExtDeco.otherStuff, 1, 0)
  	    });
    	/** Snow Bricks */
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.marble, 1, 6), new Object[]{
  		   "MM",
  			'M', Blocks.snow
  	    });
	}

	private static void oldInitSlabRecipes() {
		/** White Marble Slab */
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.marbleSlabSingle, 3, 0), new Object[]{
 		  "MMM",
 			'M', new ItemStack(BlocksExtDeco.marble, 1, 0)
 	    });   	
    	/** Black Marble Slab */
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.marbleSlabSingle, 3, 1), new Object[]{
    	  "MMM",
 			'M', new ItemStack(BlocksExtDeco.marble, 1, 1)
 	    });
    	/** Yellow Marble Slab */
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.marbleSlabSingle, 3, 2), new Object[]{
 		  "MMM",
 			'M', new ItemStack(BlocksExtDeco.marble, 1, 2)
 	    });
    	
    	
    	/** White Brick Marble Slab */
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.marbleSlabSingle, 3, 3), new Object[]{
 		  "MMM",
 			'M', new ItemStack(BlocksExtDeco.marble, 1, 3)
 	    });
    	/** Black Brick Marble Slab */
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.marbleSlabSingle, 3, 4), new Object[]{
 		  "MMM",
 			'M', new ItemStack(BlocksExtDeco.marble, 1, 4)
 	    });
    	/** Yellow Brick Marble Slab */
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.marbleSlabSingle, 3, 5), new Object[]{
 		  "MMM",
 			'M', new ItemStack(BlocksExtDeco.marble, 1, 5)
 	    });
    	
    	
    	/** Ice Slab */
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.otherStuffSlabSingle, 3, 0), new Object[]{
 		  "MMM",
 			'M', new ItemStack(BlocksExtDeco.otherStuff, 1, 0)
 	    });
    	/** Smooth Ice Slab */
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.otherStuffSlabSingle, 3, 1), new Object[]{
 		  "MMM",
 			'M', new ItemStack(BlocksExtDeco.otherStuff, 1, 1)
 	    });
    	/** Snow Brick Slab */
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.otherStuffSlabSingle, 3, 2), new Object[]{
 		  "MMM",
 			'M', new ItemStack(BlocksExtDeco.marble, 1, 6)
 	    });
	}

	private static void oldInitFreezerRecipes() {
		//Freezer
    	GameRegistry.addRecipe(new ItemStack(BlocksExtDeco.freezer), new Object[]{
			  "CSC",
			  "SSS",
			  "CSC", 'S', Blocks.snow, 'C', Blocks.cobblestone
	    }); 
    	//Ice Block Recipe
		recipesFreezer.addRecipe(Items.water_bucket, new ItemStack(Blocks.ice), 0.4F);
	}

	public static void peacefulInit() {
		
	}
}