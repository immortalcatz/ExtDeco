package neo.extdeco.handlers;

import neo.extdeco.blocks.BlocksExtDeco;
import neo.extdeco.recipes.RecipesFreezer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingHandler {
	
	private BlocksExtDeco blocks = new BlocksExtDeco();
	private RecipesFreezer recipesFreezer = new RecipesFreezer();
	
	public void init() {
		
		initMarbleRecipes();
		initBrickRecipes();
		initFreezerRecipes();
	}
	private void initMarbleRecipes() {
		
		//White Marble
		GameRegistry.addRecipe(new ItemStack(blocks.marbleSlabSingle, 2, 0), new Object[]{
	    	"M",
	    	'M', new ItemStack(blocks.marbleSlabDouble, 1, 0)
		});
		
		//Black Marble
		GameRegistry.addRecipe(new ItemStack(blocks.marbleSlabSingle, 2, 1), new Object[]{
			   "M",
			   'M', new ItemStack(blocks.marbleSlabDouble, 1, 1)
		});
		
		//Yellow Marble
		GameRegistry.addRecipe(new ItemStack(blocks.marbleSlabSingle, 2, 2), new Object[]{
			   "M",
			   'M', new ItemStack(blocks.marbleSlabDouble, 1, 2)
		});
	}
	
    private void initBrickRecipes() {
    	
    	//White Marble Brick
    	GameRegistry.addRecipe(new ItemStack(blocks.marbleBrickSlabDouble, 2, 0), new Object[]{
    			"MM",
    			"MM",
    			'M', new ItemStack(blocks.marbleSlabDouble, 1, 0)
    	});
    	GameRegistry.addRecipe(new ItemStack(blocks.marbleBrickSlabSingle, 2, 0), new Object[]{
			    "M",
			    'M', new ItemStack(blocks.marbleBrickSlabDouble, 1, 0)
	    });
    	
    	//Black Marble Brick
    	GameRegistry.addRecipe(new ItemStack(blocks.marbleBrickSlabDouble, 2, 1), new Object[]{
    			"MM",
    			"MM",
    			'M', new ItemStack(blocks.marbleSlabDouble, 1, 1)
    	});
    	GameRegistry.addRecipe(new ItemStack(blocks.marbleBrickSlabSingle, 2, 1), new Object[]{
			    "M",
			    'M', new ItemStack(blocks.marbleBrickSlabDouble, 1, 1)
	    });
    	
    	//Yellow Marble Brick
    	GameRegistry.addRecipe(new ItemStack(blocks.marbleBrickSlabDouble, 2, 2), new Object[]{
    			"MM",
    			"MM",
    			'M', new ItemStack(blocks.marbleSlabDouble, 1, 2)
    	});
    	GameRegistry.addRecipe(new ItemStack(blocks.marbleBrickSlabSingle, 2, 2), new Object[]{
			    "M",
			    'M', new ItemStack(blocks.marbleBrickSlabDouble, 1, 2)
	    });
    	
    	//Ice Brick
    	GameRegistry.addRecipe(new ItemStack(blocks.marbleBrickSlabDouble, 2, 3), new Object[]{
			   "MM",
			   "MM",
			    'M', Blocks.ice
	    });
    	
    	//Ice Smooth
    	GameRegistry.addRecipe(new ItemStack(blocks.marbleBrickSlabDouble, 2, 4), new Object[]{
			  "MFM",
			  "MFM",
			    'M', new ItemStack(blocks.marbleBrickSlabDouble, 1, 3),
			    'F', Items.flint
	    });
    	
    	//Snow Brick
    	GameRegistry.addRecipe(new ItemStack(blocks.marbleBrickSlabDouble, 2, 5), new Object[]{
			   "MM",
			   "MM",
			     'M', Blocks.snow
	    });   	
	}
	
	private void initFreezerRecipes() {
		
		GameRegistry.addRecipe(new ItemStack(blocks.freezer), new Object[]{
	    	"SSS",
	    	"SIS",
	    	"SSS",
	    	'S', Blocks.cobblestone, 'I', Blocks.ice
		});		
		recipesFreezer.addRecipe(Items.water_bucket, new ItemStack(Blocks.ice), 0.4F);
	}
}