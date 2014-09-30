package neo.extdeco.recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesFreezer {

	private static final RecipesFreezer SMELTING_BASE = new RecipesFreezer();

	private Map smeltingList = new HashMap();
	private Map experienceList = new HashMap();

	public static RecipesFreezer smelting() {
		return SMELTING_BASE;
	}
	
	public RecipesFreezer(){

	}
	
	/**
	 * 
	 * @param block
	 * @param itemstack
	 * @param experience
	 */
	public void addRecipe(Block block, ItemStack itemstack, float experience) {
		this.addListsBlocks(block, itemstack, experience);			
	}
	
	public void addListsBlocks(Block block, ItemStack itemstack, float experience){
		this.putLists(new ItemStack(block, 1, 32767), itemstack, experience);
	}
	
	/**
	 * 
	 * @param item
	 * @param itemstack
	 * @param experience
	 */
	public void addRecipe(Item item, ItemStack itemstack, float experience){
		
		this.addListsItems(item, itemstack, experience);		
	}
	
	public void addListsItems(Item item, ItemStack itemstack, float experience){
		this.putLists(new ItemStack(item, 1, 32767), itemstack, experience);
	}
	
	public void putLists(ItemStack itemstack, ItemStack itemstack2, float experience){
		this.smeltingList.put(itemstack, itemstack2);
		this.experienceList.put(itemstack2, Float.valueOf(experience));
	}

	public ItemStack getSmeltingResult(ItemStack itemstack) {
		Iterator iterator = this.smeltingList.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}
			entry = (Entry) iterator.next();
		} while (!canBeSmelted(itemstack, (ItemStack) entry.getKey()));
		return (ItemStack) entry.getValue();
	}

	private boolean canBeSmelted(ItemStack itemstack, ItemStack itemstack2) {
		return itemstack2.getItem() == itemstack.getItem() && (itemstack2.getItemDamage() == 32767 || itemstack2.getItemDamage() == itemstack.getItemDamage());
	}
	
	public float giveExperience(ItemStack itemstack){
		Iterator iterator = this.experienceList.entrySet().iterator();
		Entry entry;
		
		do{
			if(!iterator.hasNext()){
				return 0.0f;
			}
			
			entry = (Entry) iterator.next();
		}
		while(!this.canBeSmelted(itemstack, (ItemStack) entry.getKey()));
		
		if(itemstack.getItem().getSmeltingExperience(itemstack) != -1){
				return itemstack.getItem().getSmeltingExperience(itemstack);
		}
		
		return ((Float) entry.getValue()).floatValue();
	}
}