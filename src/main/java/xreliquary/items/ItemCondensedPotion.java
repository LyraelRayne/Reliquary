package xreliquary.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lib.enderwizards.sandstone.init.ContentInit;
import lib.enderwizards.sandstone.items.ItemBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import xreliquary.Reliquary;
import xreliquary.entities.potion.*;
import xreliquary.event.ClientEventHandler;
import xreliquary.lib.Colors;
import xreliquary.lib.Names;
import xreliquary.lib.Reference;

import java.util.List;

@ContentInit
public class ItemCondensedPotion extends ItemBase {

    public ItemCondensedPotion() {
        super(Names.condensed_potion);
        this.setCreativeTab(Reliquary.CREATIVE_TAB);
        this.setMaxDamage(0);
        this.setMaxStackSize(16);
        this.setHasSubtypes(true);
        canRepair = false;
    }

//    @Override
//    public ItemStack getContainerItem(ItemStack ist) {
//        return new ItemStack(ContentHandler.getItem(Names.condensed_potion), 1, Reference.EMPTY_VIAL_META);
//    }

    // returns an empty vial when used in crafting recipes, unless it's one of
    // the base potion types.
    @Override
    public boolean hasContainerItem(ItemStack ist) {
        return false;
        //return (ist.getItemDamage() != Reference.POTION_META && ist.getItemDamage() != Reference.SPLASH_META && ist.getItemDamage() != Reference.EMPTY_VIAL_META);
    }

    public int emptyVialMeta() {
        return Reference.EMPTY_VIAL_META;
    }

    public int waterVialMeta() {
        return Reference.WATER_META;
    }

    public int panaceaMeta() {
        return Reference.PANACEA_META;
    }

    public int basePotionMeta() {
        return Reference.POTION_META;
    }

    public int baseSplashMeta() {
        return Reference.SPLASH_META;
    }

    @Override
    public boolean hasEffect(ItemStack stack, int pass) {
        return hasPotionEffect(stack);
    }

    private boolean hasPotionEffect(ItemStack stack) {
        return !(isEmptyVial(stack) || isBaseSplash(stack) || isBasePotion(stack) || isJustWater(stack));
    }

    public boolean isSplash(ItemStack stack) {
        return stack.getItemDamage() > baseSplashMeta() && stack.getItemDamage() < emptyVialMeta();
    }

    public boolean isPotion(ItemStack stack) {
        return stack.getItemDamage() > basePotionMeta() && stack.getItemDamage() < waterVialMeta();
    }

    public boolean isEmptyVial(ItemStack stack) {
        return stack.getItemDamage() == emptyVialMeta();
    }

    public boolean isBaseSplash(ItemStack stack) {
        return stack.getItemDamage() == baseSplashMeta();
    }

    public boolean isBasePotion(ItemStack stack) {
        return stack.getItemDamage() == basePotionMeta();
    }

    public boolean isPanacea(ItemStack stack) {
        return stack.getItemDamage() == panaceaMeta();
    }

    public boolean isJustWater(ItemStack stack) {
        return stack.getItemDamage() == waterVialMeta();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        if (hasEffect(stack))
            return EnumRarity.epic;
        return EnumRarity.common;
    }

    @Override
    public String getUnlocalizedName(ItemStack ist) {
        return "item.potion_" + ist.getItemDamage();
    }

    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
        par3List.add(new ItemStack(par1, 1, 4));
        par3List.add(new ItemStack(par1, 1, 5));
        par3List.add(new ItemStack(par1, 1, 6));
        par3List.add(new ItemStack(par1, 1, 7));
        par3List.add(new ItemStack(par1, 1, 8));
        par3List.add(new ItemStack(par1, 1, 9));
        par3List.add(new ItemStack(par1, 1, 10));
        par3List.add(new ItemStack(par1, 1, 11));
        par3List.add(new ItemStack(par1, 1, 12));
        par3List.add(new ItemStack(par1, 1, 13));
        par3List.add(new ItemStack(par1, 1, 14));
        par3List.add(new ItemStack(par1, 1, 15));
        par3List.add(new ItemStack(par1, 1, 16));
        par3List.add(new ItemStack(par1, 1, 17));
        par3List.add(new ItemStack(par1, 1, 18));
        par3List.add(new ItemStack(par1, 1, 19));
        par3List.add(new ItemStack(par1, 1, 20));
        par3List.add(new ItemStack(par1, 1, 21));
        par3List.add(new ItemStack(par1, 1, 22));
        par3List.add(new ItemStack(par1, 1, 23));
        par3List.add(new ItemStack(par1, 1, 24));
        par3List.add(new ItemStack(par1, 1, 25));
        par3List.add(new ItemStack(par1, 1, 26));
        par3List.add(new ItemStack(par1, 1, 27));
        par3List.add(new ItemStack(par1, 1, 28));
        par3List.add(new ItemStack(par1, 1, 29));
    }

    @Override
    public ItemStack onEaten(ItemStack ist, World world, EntityPlayer player) {
        if (!isPotion(ist))
            return ist;
        if (!player.capabilities.isCreativeMode) {
            --ist.stackSize;
        }
        if (!world.isRemote) {
            for (PotionEffect effect : getPotionEffects(ist)) {
                if (effect == null)
                    continue;
                player.addPotionEffect(effect);
            }
            if (isPanacea(ist)) {
                player.removePotionEffect(Potion.wither.id);
                player.removePotionEffect(Potion.hunger.id);
                player.removePotionEffect(Potion.poison.id);
                player.removePotionEffect(Potion.confusion.id);
                player.removePotionEffect(Potion.digSlowdown.id);
                player.removePotionEffect(Potion.moveSlowdown.id);
                player.removePotionEffect(Potion.blindness.id);
                player.removePotionEffect(Potion.weakness.id);
            }
        }
        if (!player.capabilities.isCreativeMode) {
            if (ist.stackSize <= 0)
                return new ItemStack(this, 1, emptyVialMeta());
            player.inventory.addItemStackToInventory(new ItemStack(this, 1, emptyVialMeta()));
        }
        return ist;
    }

    private Entity getNewPotionEntity(ItemStack ist, World world, EntityPlayer player) {
        int potion = ist.getItemDamage();
        switch (potion) {

            case Reference.APHRODITE_META:
                return new EntityCondensedSplashAphrodite(world, player);
            case Reference.POISON_META:
                return new EntityCondensedSplashPoison(world, player);
            case Reference.ACID_META:
                return new EntityCondensedSplashHarm(world, player);
            case Reference.CONFUSION_META:
                return new EntityCondensedSplashConfusion(world, player);
            case Reference.SLOWING_META:
                return new EntityCondensedSplashSlowness(world, player);
            case Reference.WEAKNESS_META:
                return new EntityCondensedSplashWeakness(world, player);
            case Reference.WITHER_META:
                return new EntityCondensedSplashWither(world, player);
            case Reference.BLINDING_META:
                return new EntityCondensedSplashBlindness(world, player);
            case Reference.RUINATION_META:
                return new EntityCondensedSplashRuin(world, player);
            case Reference.FERTILIZER_META:
                return new EntityCondensedFertility(world, player);
        }

        return null;
    }

    private PotionEffect[] getPotionEffects(ItemStack ist) {
        PotionEffect effects[] = new PotionEffect[2];
        int potion = ist.getItemDamage();
        switch (potion) {
            case Reference.SPEED_META:
                effects[0] = new PotionEffect(Potion.moveSpeed.id, 3600, 1);
                break;
            case Reference.DIGGING_META:
                effects[0] = new PotionEffect(Potion.digSpeed.id, 3600, 1);
                break;
            case Reference.STRENGTH_META:
                effects[0] = new PotionEffect(Potion.damageBoost.id, 3600, 1);
                break;
            case Reference.HEALING_META:
                effects[0] = new PotionEffect(Potion.heal.id, 0, 1);
                break;
            case Reference.BOUNDING_META:
                effects[0] = new PotionEffect(Potion.jump.id, 3600, 1);
                break;
            case Reference.REGENERATION_META:
                effects[0] = new PotionEffect(Potion.regeneration.id, 900, 1);
                break;
            case Reference.RESISTANCE_META:
                effects[0] = new PotionEffect(Potion.resistance.id, 3600, 0);
                break;
            case Reference.FIRE_WARDING_META:
                effects[0] = new PotionEffect(Potion.fireResistance.id, 3600, 0);
                break;
            case Reference.BREATHING_META:
                effects[0] = new PotionEffect(Potion.waterBreathing.id, 3600, 0);
                break;
            case Reference.INVISIBILITY_META:
                effects[0] = new PotionEffect(Potion.invisibility.id, 3600, 0);
                break;
            case Reference.INFRAVISION_META:
                effects[0] = new PotionEffect(Potion.nightVision.id, 3600, 0);
                break;
            case Reference.PROTECTION_META:
                effects[0] = new PotionEffect(Potion.resistance.id, 3600, 1);
                effects[1] = new PotionEffect(Potion.fireResistance.id, 3600, 0);
                break;
            case Reference.POTENCE_META:
                effects[0] = new PotionEffect(Potion.damageBoost.id, 3600, 1);
                effects[1] = new PotionEffect(Potion.digSpeed.id, 3600, 1);
                break;
            case Reference.CELERITY_META:
                effects[0] = new PotionEffect(Potion.jump.id, 3600, 1);
                effects[1] = new PotionEffect(Potion.moveSpeed.id, 3600, 1);
                break;
            case Reference.PANACEA_META:
                effects[0] = new PotionEffect(Potion.heal.id, 0, 1);
                effects[1] = new PotionEffect(Potion.regeneration.id, 900, 1);
                break;
            case Reference.STALKER_META:
                effects[0] = new PotionEffect(Potion.nightVision.id, 3600, 0);
                effects[1] = new PotionEffect(Potion.invisibility.id, 3600, 0);
                break;
        }
        return effects;
    }

    @SideOnly(Side.CLIENT)
    private IIcon iconBaseOverlay;

    @SideOnly(Side.CLIENT)
    private IIcon iconSplash;

    @SideOnly(Side.CLIENT)
    private IIcon iconSplashOverlay;

    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        super.registerIcons(iconRegister);
        iconBaseOverlay = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.condensed_potion_overlay);

        iconSplash = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.condensed_potion_splash);
        iconSplashOverlay = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.condensed_potion_splash_overlay);
    }

    @Override
    public IIcon getIcon(ItemStack itemStack, int renderPass) {
        if (isEmptyVial(itemStack))
            return this.itemIcon;
        if (isPanacea(itemStack) || isPotion(itemStack) || isBasePotion(itemStack) || isJustWater(itemStack)) {
            if (renderPass == 1)
                return iconBaseOverlay;
            else
                return this.itemIcon;
        } else {
            if (renderPass == 1)
                return iconSplashOverlay;
            else
                return iconSplash;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
        if (renderPass == 1)
            return getColor(itemStack);
        else
            return Integer.parseInt(Colors.PURE, 16);
    }

    public int getColor(ItemStack itemStack) {
        String red;
        String green;
        String blue;
        int timeFactor = ClientEventHandler.getTime() % 256;
        if (timeFactor > 127) {
            timeFactor = 255 - timeFactor;
        }
        int potion = itemStack.getItemDamage();
        switch (potion) {
            case Reference.SPEED_META:
                return Integer.parseInt(Colors.SPEED_COLOR, 16);
            case Reference.DIGGING_META:
                return Integer.parseInt(Colors.DIGGING_COLOR, 16);
            case Reference.STRENGTH_META:
                return Integer.parseInt(Colors.STRENGTH_COLOR, 16);
            case Reference.HEALING_META:
                return Integer.parseInt(Colors.HEALING_COLOR, 16);
            case Reference.BOUNDING_META:
                return Integer.parseInt(Colors.BOUNDING_COLOR, 16);
            case Reference.REGENERATION_META:
                return Integer.parseInt(Colors.REGENERATION_COLOR, 16);
            case Reference.RESISTANCE_META:
                return Integer.parseInt(Colors.RESISTANCE_COLOR, 16);
            case Reference.FIRE_WARDING_META:
                return Integer.parseInt(Colors.FIRE_WARDING_COLOR, 16);
            case Reference.BREATHING_META:
                return Integer.parseInt(Colors.BREATHING_COLOR, 16);
            case Reference.INVISIBILITY_META:
                red = Integer.toHexString(timeFactor * 2);
                green = Integer.toHexString(timeFactor * 2);
                blue = Integer.toHexString(timeFactor * 2);
                return Integer.parseInt(String.format("%s%s%s", red, green, blue), 16);
            case Reference.INFRAVISION_META:
                return Integer.parseInt(Colors.INFRAVISION_COLOR, 16);
            case Reference.PROTECTION_META:
                red = Integer.toHexString(timeFactor + 127);
                green = Integer.toHexString(timeFactor + 127);
                blue = Integer.toHexString(timeFactor + 127);
                return Integer.parseInt(String.format("%s%s%s", red, green, blue), 16);
            case Reference.POTENCE_META:
                red = Integer.toHexString(timeFactor + 127);
                green = Integer.toHexString(timeFactor / 4 + 32);
                blue = "00";
                return Integer.parseInt(String.format("%s%s%s", red, green, blue), 16);
            case Reference.CELERITY_META:
                red = "00";
                green = Integer.toHexString(timeFactor * 2);
                blue = "FF";
                return Integer.parseInt(String.format("%s%s%s", red, green, blue), 16);
            case Reference.PANACEA_META:
                red = Integer.toHexString(timeFactor * 2);
                green = "00";
                blue = "FF";
                return Integer.parseInt(String.format("%s%s%s", red, green, blue), 16);
            case Reference.STALKER_META:
                return Integer.parseInt(Colors.STALKER_COLOR, 16);
            case Reference.APHRODITE_META:
                return Integer.parseInt(Colors.APHRODITE_COLOR, 16);
            case Reference.POISON_META:
                return Integer.parseInt(Colors.POISON_COLOR, 16);
            case Reference.ACID_META:
                return Integer.parseInt(Colors.ACID_COLOR, 16);
            case Reference.CONFUSION_META:
                return Integer.parseInt(Colors.CONFUSION_COLOR, 16);
            case Reference.SLOWING_META:
                return Integer.parseInt(Colors.SLOWING_COLOR, 16);
            case Reference.WEAKNESS_META:
                return Integer.parseInt(Colors.WEAKNESS_COLOR, 16);
            case Reference.WITHER_META:
                return Integer.parseInt(Colors.WITHER_COLOR, 16);
            case Reference.BLINDING_META:
                return Integer.parseInt(Colors.BLINDING_COLOR, 16);
            case Reference.RUINATION_META:
                red = Integer.toHexString(timeFactor * 2);
                green = "FF";
                blue = "00";
                return Integer.parseInt(String.format("%s%s%s", red, green, blue), 16);
            case Reference.FERTILIZER_META:
                return Integer.parseInt(Colors.FERTILIZER_COLOR, 16);
            case Reference.WATER_META:
            case Reference.SPLASH_META:
            case Reference.POTION_META:
                return Integer.parseInt(Colors.WATER_COLOR, 16);
        }
        return Integer.parseInt(Colors.PURE, 16);
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 16;
    }

    /**
     * returns the action that specifies what animation to play when the items
     * is being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack ist) {
        if (isPotion(ist))
            return EnumAction.drink;
        return EnumAction.none;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is
     * pressed. Args: itemStack, world, entityPlayer
     */

    @Override
    public ItemStack onItemRightClick(ItemStack ist, World world, EntityPlayer player) {
        if (this.isEmptyVial(ist)) {
            boolean var11 = isEmptyVial(ist);
            MovingObjectPosition mop = this.getMovingObjectPositionFromPlayer(world, player, var11);

            if (mop == null)
                return ist;
            else {
                if (mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                    int var13 = mop.blockX;
                    int var14 = mop.blockY;
                    int var15 = mop.blockZ;
                    if (world.getBlock(var13, var14, var15).getMaterial() == Material.water) {
                        if (--ist.stackSize <= 0)
                            return new ItemStack(this, 1, waterVialMeta());

                        if (!player.inventory.addItemStackToInventory(new ItemStack(this, 1, waterVialMeta()))) {
                            player.entityDropItem(new ItemStack(this, 1, waterVialMeta()), 0.1F);
                        }
                    }
                }
            }
        } else if (!hasPotionEffect(ist))
            return ist;
        else if (isPotion(ist)) {
            player.setItemInUse(ist, this.getMaxItemUseDuration(ist));
        } else if (isSplash(ist)) {
            if (world.isRemote)
                return ist;
            Entity e = getNewPotionEntity(ist, world, player);
            if (e == null)
                return ist;
            if (!player.capabilities.isCreativeMode) {
                --ist.stackSize;
            }
            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            world.spawnEntityInWorld(e);
        }
        return ist;
    }

}
