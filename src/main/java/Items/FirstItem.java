package Items;

import com.example.examplemod.ExampleMod;
import net.minecraft.item.Item;

/**
 * Created by Ataloumpak on 24/08/2017.
 */
public class FirstItem extends Item {

    public FirstItem() {
        setRegistryName("firstitem");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(ExampleMod.MODID + ".firstitem");     // Used for localization (en_US.lang)

    }

}