package block.Entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Ataloumpak on 24/08/2017.
 */
public class DataTileEntity extends TileEntity {

    private int counter = 0;

    public int decrement() {
        counter--;
        markDirty();
        return counter;
    }

    public int increment() {
        counter++;
        markDirty();
        return counter;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        counter = compound.getInteger("counter");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("counter", counter);
        return compound;
    }
}
