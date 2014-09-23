package neo.extdeco.init;

import neo.extdeco.blocks.BlocksExtDeco;
import neo.extdeco.handlers.CraftingHandler;
import neo.extdeco.handlers.EventHandlerExtDeco;
import neo.extdeco.handlers.GuiHandlerExtDeco;
import neo.extdeco.handlers.VillagerTradeHandler;
import neo.extdeco.items.ItemsExtDeco;
import neo.extdeco.recipes.RecipesFreezer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.simpleimpl.SimpleChannelHandlerWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

@Mod(modid = ExtDeco.MODID, version = ExtDeco.VERSION)
public class ExtDeco {
	public static final String MODID = "extdeco";
	public static final String VERSION = "Pre_Alpha 0.3";
	
	@SidedProxy(clientSide = "neo.extdeco.init.ClientProxy", serverSide = "neo.extdeco.init.ServerProxy")
    public static ServerProxy sProxy;

	@Instance
	public static ExtDeco modInstance = new ExtDeco();
	
	public boolean isPeaceful = true;

	private BlocksExtDeco blocks = new BlocksExtDeco();
	private ItemsExtDeco items = new ItemsExtDeco();
	private CraftingHandler crafting = new CraftingHandler();

    public static CreativeTabs tabExtDeco = new CreativeTabs("extDeco") {

		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.bedrock);
		}
	};
	
	private EventHandlerExtDeco events = new EventHandlerExtDeco();

	@EventHandler
    public void preinit(FMLPreInitializationEvent event) {
		
		//blocks.init();
		//items.init();
		
		//sProxy.registerTileEntities();
		//sProxy.registerRenderThings();
	}	
	
	/*@EventHandler
	public void init(FMLInitializationEvent event) {
		
		FMLCommonHandler.instance().bus().register(events);
        MinecraftForge.EVENT_BUS.register(events);
        sProxy.registerNetwork();
        crafting.init();        
		
		if (isPeaceful) {
			VillagerRegistry.instance().registerVillageTradeHandler(3, new VillagerTradeHandler());
		} else {
			GameRegistry.registerWorldGenerator(new WorldGenExtDeco(), 0);			
		}
	}*/
}