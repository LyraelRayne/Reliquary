package xreliquary.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lib.enderwizards.sandstone.init.ContentInit;
import lib.enderwizards.sandstone.items.ItemToggleable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import xreliquary.Reliquary;
import xreliquary.lib.Names;
import xreliquary.lib.Reference;

@ContentInit
public class ItemInfernalTear extends ItemToggleable {

    @Override
    public IIcon getIcon(ItemStack ist, int renderPass) {
        if (!this.isEnabled(ist) || renderPass != 1)
            return inactiveSprite;
        else
            return this.itemIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    private IIcon inactiveSprite;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        super.registerIcons(iconRegister);
        inactiveSprite = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.infernal_tear_empty);
    }

    public ItemInfernalTear() {
        super(Names.infernal_tear);
        this.setCreativeTab(Reliquary.CREATIVE_TAB);
        this.setMaxStackSize(1);
    }

    @Override
    public void onUpdate(ItemStack ist, World world, Entity e, int i, boolean flag) {
        if (!isEnabled(ist))
            return;
        if (!(e instanceof EntityPlayer))
            return;
        EntityPlayer player = (EntityPlayer)e;
        String ident = ist.getTagCompound().getString("itemID");
    }
}