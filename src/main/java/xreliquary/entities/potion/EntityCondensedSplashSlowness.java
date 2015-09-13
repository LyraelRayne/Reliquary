package xreliquary.entities.potion;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityCondensedSplashSlowness extends EntityThrownPotion {
    public EntityCondensedSplashSlowness(World par1World) {
        super(par1World);
    }

    public EntityCondensedSplashSlowness(World par1World, EntityPlayer par2EntityPlayer) {
        super(par1World, par2EntityPlayer);
    }

    @SideOnly(Side.CLIENT)
    public EntityCondensedSplashSlowness(World par1World, double par2, double par4, double par6, int par8) {
        this(par1World, par2, par4, par6);
    }

    public EntityCondensedSplashSlowness(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    boolean hasLivingEntityEffect() {
        return true;
    }

    @Override
    void doGroundSplashEffect() {
        // none
    }

    @Override
    void doLivingSplashEffect(EntityLivingBase e) {
        e.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 900, 1));
    }

    @Override
    float getRed() {
        return 0;
    }

    @Override
    float getGreen() {
        return 0.4F;
    }

    @Override
    float getBlue() {
        return 1.0F;
    }
}
