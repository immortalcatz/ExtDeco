package neo.extdeco.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemMarbleBlock extends ItemBlock{

	public ItemMarbleBlock(Block block) {
		super(block);
		this.setMaxDamage(0);
        this.setHasSubtypes(true);
	}
	
	 public String getUnlocalizedName(ItemStack itemstack)
     {
           String name = "";
           switch(itemstack.getItemDamage())
           {
                  case 0:
                  {
                         name = "1";
                         break;
                  }
                  case 1:
                  {
                         name = "2";
                         break;
                  }
                  case 2:
                  {
                         name = "3";
                         break;
                  }
                  default: name = "broken";
           }
           return "tile.extdeco:marbleSlabSingle." + name;
     }
    
     public int getMetadata(int par1)
     {
           return par1;
     }
}
