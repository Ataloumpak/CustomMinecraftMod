package block;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Ataloumpak on 24/08/2017.
 */
public class ModBlocks {

    @GameRegistry.ObjectHolder("modtut:firstblock")
    public static FirstBlock firstBlock = new FirstBlock();

    @GameRegistry.ObjectHolder("modtut:datablock")
    public static DataBlock dataBlock = new DataBlock();

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        dataBlock.initModel();
    }
}