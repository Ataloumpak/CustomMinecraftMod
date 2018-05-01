package block;

import block.Entity.DataTileEntity;
import com.example.examplemod.ExampleMod;
import handlers.EnumHandler;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Ataloumpak on 24/08/2017.
 */
public class FirstBlock extends Block{
    public static final PropertyEnum TYPE = PropertyEnum.create("type", EnumHandler.ChipTypes.class);
    public static final PropertyDirection FACING = PropertyDirection.create("facing");
    {
    }

    public FirstBlock() {
        super(Material.ROCK);
        setUnlocalizedName(ExampleMod.MODID + ".firstblock");     // Used for localization (en_US.lang)
        setRegistryName("firstblock");        // The unique name (within your mod) that identifies this block
        this.setDefaultState(blockState.getBaseState().withProperty(TYPE, EnumHandler.ChipTypes.BASIC).withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        EnumHandler.ChipTypes type = (EnumHandler.ChipTypes) state.getValue(TYPE);
        return type.getID();
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
        worldIn.setBlockState(pos, state.withProperty(FACING, EnumFacing.NORTH));
    }

    @Override protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {TYPE, FACING});
    }
}