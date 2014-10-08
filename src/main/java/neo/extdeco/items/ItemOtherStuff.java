package neo.extdeco.items;

import neo.extdeco.blocks.BlocksExtDeco;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;

public class ItemOtherStuff extends ItemSlab {
	public ItemOtherStuff(Block block) {
		super(block, (BlockSlab) BlocksExtDeco.otherStuffSlabSingle, (BlockSlab) BlocksExtDeco.otherStuffSlabDouble, false);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
}