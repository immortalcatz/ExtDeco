package neo.extdeco.containers;

import neo.extdeco.recipes.RecipesFreezer;
import neo.extdeco.tileentitys.TileEntityFreezer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerFreezer extends Container {
	
	private TileEntityFreezer tileFreezer;
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;
	
	public ContainerFreezer(InventoryPlayer player, TileEntityFreezer tileEntityFreezer){
		this.tileFreezer = tileEntityFreezer;
		this.addSlotToContainer(new Slot(tileEntityFreezer, 0, 56, 17));
		this.addSlotToContainer(new Slot(tileEntityFreezer, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnace(player.player, tileEntityFreezer, 2, 116, 35));
		int i;
		
		for(i = 0; i < 3; ++i){
			for(int j = 0; j < 9; ++j){
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(i = 0; i < 9; ++i){
			this.addSlotToContainer(new Slot(player, i , 8 + i * 18 , 142));
		}
	}

	public void addCraftingToCrafters(ICrafting craft){
		super.addCraftingToCrafters(craft);
		craft.sendProgressBarUpdate(this, 0, this.tileFreezer.furnaceCookTime);
		craft.sendProgressBarUpdate(this, 1, this.tileFreezer.furnaceBurnTime);
		craft.sendProgressBarUpdate(this, 2, this.tileFreezer.currentBurnTime);
	}
	
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); ++i){
			ICrafting craft = (ICrafting) this.crafters.get(i);
			
			if(this.lastCookTime != this.tileFreezer.furnaceCookTime){
				craft.sendProgressBarUpdate(this, 0, this.tileFreezer.furnaceCookTime);
			}
			
			if(this.lastBurnTime != this.tileFreezer.furnaceBurnTime){
				craft.sendProgressBarUpdate(this, 1, this.tileFreezer.furnaceBurnTime);
			}
			
			if(this.lastItemBurnTime != this.tileFreezer.currentBurnTime){
				craft.sendProgressBarUpdate(this, 2, this.tileFreezer.currentBurnTime);
			}
		}
		
		this.lastBurnTime = this.tileFreezer.furnaceBurnTime;
		this.lastCookTime = this.tileFreezer.furnaceCookTime;
		this.lastItemBurnTime = this.tileFreezer.currentBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2){
		if(par1 == 0){
			this.tileFreezer.furnaceCookTime = par2;
		}
		
		if(par1 == 1){
			this.tileFreezer.furnaceBurnTime = par2;
		}
		
		if(par1 == 2){
			this.tileFreezer.currentBurnTime = par2;
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.tileFreezer.isUseableByPlayer(player);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int par2){
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);
		
		if(slot != null && slot.getHasStack()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if(par2 == 2){
				if(!this.mergeItemStack(itemstack1, 3, 39, true)){
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}else if(par2 != 1 && par2 != 0){
				if(RecipesFreezer.smelting().getSmeltingResult(itemstack1) != null){
					if(!this.mergeItemStack(itemstack1, 0, 1, false)){
						return null;
					}
				}else if(TileEntityFreezer.isItemFuel(itemstack1)){
					if(!this.mergeItemStack(itemstack1, 1, 2, false)){
						return null;
					}
				}else if(par2 >=3 && par2 < 30){
					if(!this.mergeItemStack(itemstack1, 30, 39, false)){
						return null;
					}
				}else if(par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)){
					return null;
				}
			}else if(!this.mergeItemStack(itemstack1, 3, 39, false)){
				return null;
			}
			if(itemstack1.stackSize == 0){
				slot.putStack((ItemStack)null);
			}else{
				slot.onSlotChanged();
			}
			if(itemstack1.stackSize == itemstack.stackSize){
				return null;
			}
			slot.onPickupFromSlot(player, itemstack1);
		}
		return itemstack;
	}

}