package block;

import com.example.examplemod.ExampleMod;
import handlers.EnumHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Ataloumpak on 24/08/2017.
 */
public class FirstBlock extends Block
{
    public static final String NAME = "firstblock";
    public static final PropertyEnum TYPE = PropertyEnum.create("type", EnumHandler.ChipTypes.class);
    //public static final PropertyDirection FACING = PropertyDirection.create("facing");

    {
    }

    public FirstBlock()
    {
        super(Material.ROCK);
        setUnlocalizedName(ExampleMod.MODID + "." + NAME);     // Used for localization (en_US.lang)
        setRegistryName(NAME);        // The unique name (within your mod) that identifies this blocks
        //this.setDefaultState(blockState.getBaseState().withProperty(TYPE, EnumHandler.ChipTypes.BASIC).withProperty(FACING, EnumFacing.NORTH));
        this.setDefaultState(blockState.getBaseState().withProperty(TYPE, EnumHandler.ChipTypes.BASIC));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        EnumHandler.ChipTypes type = (EnumHandler.ChipTypes) state.getValue(TYPE);
        return type.getID();
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
        super.onBlockClicked(worldIn, pos, playerIn);
        worldIn.setBlockState(pos.add(0,1,0), getDefaultState());
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return super.getDefaultState().withProperty(TYPE, EnumHandler.ChipTypes.values()[meta]);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        //worldIn.setBlockState(pos, state.withProperty(FACING, EnumFacing.NORTH));
        worldIn.setBlockState(pos, state);
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[]{TYPE});
    }
}