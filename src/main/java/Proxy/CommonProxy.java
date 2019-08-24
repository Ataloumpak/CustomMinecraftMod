package Proxy;

import block.ModBlocks;
import block.SecondBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static com.example.examplemod.ExampleMod.MODID;

/**
 * Created by Ataloumpak on 24/08/2017.
 */
@Mod.EventBusSubscriber
public class CommonProxy
{

    public static final String RESOURCE_INVENTORY = "inventory";

    public void preInit(FMLPreInitializationEvent e)
    {
    }

    public void init(FMLInitializationEvent e)
    {
    }

    public void postInit(FMLPostInitializationEvent e)
    {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        //event.getRegistry().register(new FirstBlock());
        event.getRegistry().register(new SecondBlock());
        //event.getRegistry().register(new DataBlock());
        //GameRegistry.registerTileEntity(DataTileEntity.class, ExampleMod.MODID + "_datablock");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        //event.getRegistry().register(new ItemBlock(ModBlocks.firstBlock).setRegistryName(ModBlocks.firstBlock.getRegistryName()));
        ItemBlock secondItemBlock = new ItemBlock(ModBlocks.secondBlock);
        secondItemBlock.setRegistryName(ModBlocks.secondBlock.getRegistryName());
        ForgeRegistries.ITEMS.register(secondItemBlock);
        event.getRegistry().register(secondItemBlock);
        ModelResourceLocation chinaModelResourceLocation = new ModelResourceLocation(MODID + ":" + SecondBlock.NAME, RESOURCE_INVENTORY);
        final int DEFAULT_ITEM_SUBTYPE = 0;
        ModelLoader.setCustomModelResourceLocation(secondItemBlock, DEFAULT_ITEM_SUBTYPE, chinaModelResourceLocation);
        //event.getRegistry().register(new FirstItem());
        //event.getRegistry().register(new ItemBlock(ModBlocks.dataBlock).setRegistryName(ModBlocks.dataBlock.getRegistryName()));
    }
}
