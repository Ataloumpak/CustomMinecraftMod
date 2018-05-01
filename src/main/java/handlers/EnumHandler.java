package handlers;

import net.minecraft.util.IStringSerializable;

/**
 * Created by Ataloumpak on 01/05/2018.
 */
public class EnumHandler
{
    public static enum ChipTypes implements IStringSerializable{
        BASIC("basic", 0),
        ADVANCED("advanced", 1);

        private int ID;
        private String name;

        private ChipTypes(String name, int ID)
        {
            this.ID = ID;
            this.name = name;
        }

        @Override
        public String toString()
        {
            return getName();
        }


        @Override
        public String getName()
        {
            return name;
        }

        public int getID()
        {
            return ID;
        }


    }
}
