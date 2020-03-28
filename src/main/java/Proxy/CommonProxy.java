package Proxy;

import block.FirstBlock;
import block.ModBlocks;
import block.SecondBlock;
import handlers.EnumHandler;
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

import java.util.Objects;

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
        event.getRegistry().register(new FirstBlock());
        event.getRegistry().register(new SecondBlock());
        //event.getRegistry().register(new DataBlock());
        //GameRegistry.registerTileEntity(DataTileEntity.class, ExampleMod.MODID + "_datablock");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        //event.getRegistry().register(new ItemBlock(ModBlocks.firstBlock).setRegistryName(ModBlocks.firstBlock.getRegistryName()));
        RegisterItemBlockofBlock(event, ModBlocks.firstBlock, FirstBlock.NAME);
        //RegisterVariantItemBlockofBlock(event, ModBlocks.firstBlock, FirstBlock.NAME, "");
        RegisterItemBlockofBlock(event, ModBlocks.secondBlock, SecondBlock.NAME);
        //event.getRegistry().register(new FirstItem());
        //event.getRegistry().register(new ItemBlock(ModBlocks.dataBlock).setRegistryName(ModBlocks.dataBlock.getRegistryName()));
    }

    private static void RegisterItemBlockofBlock(RegistryEvent.Register<Item> event, Block block, String blockName)
    {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        ForgeRegistries.ITEMS.register(itemBlock);
        event.getRegistry().register(itemBlock);
        ModelResourceLocation chinaModelResourceLocation = new ModelResourceLocation(MODID + ":" + blockName, RESOURCE_INVENTORY);
        final int DEFAULT_ITEM_SUBTYPE = 0;
        ModelLoader.setCustomModelResourceLocation(itemBlock, DEFAULT_ITEM_SUBTYPE, chinaModelResourceLocation);
    }

    private static void RegisterVariantItemBlockofBlock(RegistryEvent.Register<Item> event, Block block, String blockName, String variant)
    {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        ForgeRegistries.ITEMS.register(itemBlock);
        event.getRegistry().register(itemBlock);
        ModelResourceLocation chinaModelResourceLocation = new ModelResourceLocation(MODID + ":" + blockName + "#facing=" + "down"+ ",type=" + EnumHandler.ChipTypes.BASIC.getName(), RESOURCE_INVENTORY);
        final int DEFAULT_ITEM_SUBTYPE = 0;
        ModelLoader.setCustomModelResourceLocation(itemBlock, DEFAULT_ITEM_SUBTYPE, chinaModelResourceLocation);
    }
}
