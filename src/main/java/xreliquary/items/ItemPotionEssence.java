package xreliquary.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lib.enderwizards.sandstone.init.ContentInit;
import lib.enderwizards.sandstone.items.ItemBase;
import net.minecraft.item.ItemStack;
import xreliquary.lib.Colors;
import xreliquary.lib.Names;

/**
 * Created by Xeno on 11/8/2014.
 */
@ContentInit
public class ItemPotionEssence extends ItemBase {

    public ItemPotionEssence() {
        super(Names.potion_essence);
        this.setMaxStackSize(64);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack ist, int renderPass) {
        if (renderPass == 1)
            return getColor(ist);
        else
            return Integer.parseInt(Colors.PURE, 16);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    public int getColor(ItemStack itemStack) {
        return Integer.parseInt(Colors.PURE, 16);
    }

}
