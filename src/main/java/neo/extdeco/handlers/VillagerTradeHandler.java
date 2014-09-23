package neo.extdeco.handlers;

import java.util.Random;

import neo.extdeco.blocks.BlocksExtDeco;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class VillagerTradeHandler implements IVillageTradeHandler {

	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
		//recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1),new ItemStack(BlocksExtDeco.whiteMarbleBlock, 4, 4)));
		//recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1),new ItemStack(BlocksExtDeco.blackMarble, 4, 4)));
		//recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1),new ItemStack(BlocksExtDeco.yellowMarble, 4, 4)));
	}
}