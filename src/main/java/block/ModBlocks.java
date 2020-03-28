package block;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Ataloumpak on 24/08/2017.
 */
public class ModBlocks {

    @GameRegistry.ObjectHolder("examplemod:firstblock")
    @GameRegistry.ItemStackHolder("examplemod:firstblock")
    public static FirstBlock firstBlock = new FirstBlock();

    @GameRegistry.ObjectHolder("examplemod:secondblock")
    @GameRegistry.ItemStackHolder("examplemod:secondblock")
    public static SecondBlock secondBlock = new SecondBlock();

    //@GameRegistry.ObjectHolder("examplemod:datablock")
    //public static DataBlock dataBlock = new DataBlock();

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        //dataBlock.initModel();
    }
}