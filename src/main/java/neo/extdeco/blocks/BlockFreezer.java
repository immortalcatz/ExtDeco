package neo.extdeco.blocks;

import java.util.Random;

import neo.extdeco.entitys.ParticleFreezer;
import neo.extdeco.init.ExtDeco;
import neo.extdeco.tileentitys.TileEntityFreezer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFreezer extends BlockContainer  {
	
	@SideOnly(Side.CLIENT)
	protected IIcon blockIcon,blockIconTop,blockIconFront;
	
	private String rawName;
    
    private final boolean isBurning2;
    private static boolean isBurning;
    private final Random random = new Random();
	
	public BlockFreezer(String rawName, Float hardness, boolean isBurning) {
		super(Material.rock);
		this.rawName = rawName;
		this.setBlockName(ExtDeco.MODID + "_" + rawName);
		this.isBurning2 = isBurning;
		this.setHardness(hardness);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(ExtDeco.MODID + ":" + "freezer/freezer");
		blockIconFront = iconRegister.registerIcon(this.isBurning2 ? ExtDeco.MODID + ":freezer/freezerActive" : ExtDeco.MODID + ":freezer/freezerInactive");
		blockIconTop = iconRegister.registerIcon(ExtDeco.MODID + ":" + "freezer/freezerTop");
	}

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
    	if (meta == 0 && side == 3) {
    		return blockIconFront;
    	}
    	 return side == 1 ? this.blockIconTop : (side == 0 ? this.blockIconTop : (side != meta ? this.blockIcon : this.blockIconFront));
    }
    
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		player.openGui(ExtDeco.modInstance, 0, world, x, y, z);
		return true;
	}

	public Item getItemDropped(int par1, Random random, int par3) {
		return Item.getItemFromBlock(BlocksExtDeco.freezer);
	}
	
	/**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World world, int par2)
    {
        return new TileEntityFreezer();
    }
	
    public void onBlockAdded(World world, int i, int j, int k, EntityLivingBase entity, ItemStack p_149689_6_) {

    	super.onBlockAdded(world, i, j, k);
    	setDefaultDirection(world, i, j, k);
    }
    	
    private void setDefaultDirection(World par1World, int par2, int par3, int par4) {
    	if (!par1World.isRemote) {
    		Block l = par1World.getBlock(par2, par3, par4 - 1);
    		Block i1 = par1World.getBlock(par2, par3, par4 + 1);
    		Block j1 = par1World.getBlock(par2 - 1, par3, par4);
    		Block k1 = par1World.getBlock(par2 + 1, par3, par4);
    		byte b0 = 3;
    		if (l.func_149730_j() && !i1.func_149730_j())
    			b0 = 3;

    		if (i1.func_149730_j() && !l.func_149730_j())
    			b0 = 4;

    		if (j1.func_149730_j() && !k1.func_149730_j())
    			b0 = 2;

    		if (k1.func_149730_j() && !j1.func_149730_j())
    			b0 = 5;

    		par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
    	}
    }
    
    public byte rotateBlock(byte b0, EntityLivingBase entity){
		
		if((entity.rotationYaw>=135&&entity.rotationYaw<=181)||(entity.rotationYaw<=-135&&entity.rotationYaw>=-181)){
			b0 = 3;
		}else if(entity.rotationYaw>-135&&entity.rotationYaw<-45){
			b0 = 4;
		}else if(entity.rotationYaw>=-45&&entity.rotationYaw<=45){
			b0 = 2;
		}else if(entity.rotationYaw>45&&entity.rotationYaw<135){
			b0 = 5;
		}else if(entity.rotationYaw>=181){
			entity.rotationYaw=entity.rotationYaw-360;
			b0=rotateBlock(b0, entity);
		}else if(entity.rotationYaw<=-181){
			entity.rotationYaw=entity.rotationYaw+360;
			b0=rotateBlock(b0, entity);
		}
		return b0;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
		int direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (direction == 0)
        {
        	world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (direction == 1)
        {
        	world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (direction == 2)
        {
        	world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (direction == 3)
        {
        	world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if (itemstack.hasDisplayName())
        {
            ((TileEntityFreezer)world.getTileEntity(x, y, z)).freezerName(itemstack.getDisplayName());
        }
    }		

	public static void updateFreezerBlockState(boolean burning, World world, int x, int y, int z) {
		int direction = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		isBurning = true;

		if (burning) {
			world.setBlock(x, y, z, BlocksExtDeco.freezerOn);
		} else {
			world.setBlock(x, y, z, BlocksExtDeco.freezer);
		}

		isBurning = false;
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);

		if (tileentity != null) {
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity);
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (!isBurning) {
			TileEntityFreezer tileentitytutfurnace = (TileEntityFreezer) world.getTileEntity(x, y, z);

			if (tileentitytutfurnace != null) {
				for (int i = 0; i < tileentitytutfurnace.getSizeInventory(); ++i) {
					ItemStack itemstack = tileentitytutfurnace.getStackInSlot(i);

					if (itemstack != null) {
						float f = this.random.nextFloat() * 0.6F + 0.1F;
						float f1 = this.random.nextFloat() * 0.6F + 0.1F;
						float f2 = this.random.nextFloat() * 0.6F + 0.1F;

						while (itemstack.stackSize > 0) {
							int j = this.random.nextInt(21) + 10;

							if (j > itemstack.stackSize) {
								j = itemstack.stackSize;
							}

							itemstack.stackSize -= j;
							EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

							if (itemstack.hasTagCompound()) {
								entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
							}

							float f3 = 0.025F;
							entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
							entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
							entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
							world.spawnEntityInWorld(entityitem);
						}
					}
				}
				world.func_147453_f(x, y, z, block);
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}

	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        if (this.isBurning2)
        {
        	EffectRenderer effect = FMLClientHandler.instance().getClient().effectRenderer;
            int l = world.getBlockMetadata(x, y, z);
            float f = (float)x + 0.5F;
            float f1 = (float)y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)z + 0.5F;
            float f3 = 0.52F;
            float f4 = random.nextFloat() * 0.6F - 0.3F;

            if (l == 4)
            {           	
            	effect.addEffect(new ParticleFreezer(world, (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D));
            }
            else if (l == 5)
            {
            	effect.addEffect(new ParticleFreezer(world, (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D));
            }
            else if (l == 2)
            {
            	effect.addEffect(new ParticleFreezer(world, (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D));
            }
            else if (l == 3)
            {
            	effect.addEffect(new ParticleFreezer(world, (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D));
            }
        }
    }

}