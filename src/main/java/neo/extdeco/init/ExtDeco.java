package neo.extdeco.init;

import neo.extdeco.blocks.BlocksExtDeco;
import neo.extdeco.handlers.CraftingHandler;
import neo.extdeco.handlers.EventHandlerExtDeco;
import neo.extdeco.items.ItemsExtDeco;
import neo.extdeco.world.WorldExtDeco;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = ExtDeco.MODID, version = ExtDeco.VERSION,
dependencies = "after:ForgeMultipart;after:ExtraUtilities;after:ProjectRed")
public class ExtDeco {
	
	public static boolean isDebug = true;
	public static final String MODID = "extdeco";
	public static final String VERSION = "1.7.10-0.6_b2";
	
	@SidedProxy(clientSide = "neo.extdeco.init.ClientProxy", serverSide = "neo.extdeco.init.ServerProxy")			
    public static ServerProxy sProxy;

	@Instance
	public static ExtDeco modInstance = new ExtDeco();
	
	public boolean oldMod, isPeaceful, isLogAllowed, genWhiteMarble, genBlackMarble, genYellowMarble;

    public static CreativeTabs tabExtDeco = new CreativeTabs("extDeco") {

		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(BlocksExtDeco.marble);
		}
	};

	@EventHandler
    public void preinit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
        config.load();
        
		oldMod = config.get(Configuration.CATEGORY_GENERAL, "OldModBlocks", true).getBoolean(true);
		isPeaceful = config.get(Configuration.CATEGORY_GENERAL, "PeacefulMode", false).getBoolean(false);
		isLogAllowed = config.get(Configuration.CATEGORY_GENERAL, "SendPlayerNameToAuthor", true).getBoolean(true);
		genWhiteMarble = config.get(Configuration.CATEGORY_GENERAL, "GenWhiteMarble", true).getBoolean(true);
		genBlackMarble = config.get(Configuration.CATEGORY_GENERAL, "GenBlackMarble", true).getBoolean(true);
		genYellowMarble = config.get(Configuration.CATEGORY_GENERAL, "GenYellowMarble", true).getBoolean(true);
				
		config.save();

		BlocksExtDeco.init();
		if (oldMod) {
    		BlocksExtDeco.oldInit();    		
    	}
		ItemsExtDeco.init();       
		
		sProxy.registerTileEntities();
        sProxy.registerRenderThings();
	}	
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		CraftingHandler.init();
    	if (isPeaceful) {
    		CraftingHandler.peacefulInit();
		}
		if (oldMod) {
			CraftingHandler.oldInit();
    	}	
		Side side = event.getSide();
		if (side == side.CLIENT) {
			EventHandlerExtDeco events = new EventHandlerExtDeco();	        
			FMLCommonHandler.instance().bus().register(events);
	        MinecraftForge.EVENT_BUS.register(events);			
		} else if (side == side.SERVER) {
			FMLLog.info("[Ext Deco] Server Side startet!");
		}
        sProxy.registerNetwork();
		GameRegistry.registerWorldGenerator(new WorldExtDeco(), 0);
	}
}