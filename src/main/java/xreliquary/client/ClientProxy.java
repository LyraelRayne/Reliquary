package xreliquary.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import xreliquary.Reliquary;
import xreliquary.client.render.ItemRendererHandgun;
import xreliquary.client.render.RenderShot;
import xreliquary.client.render.RenderThrown;
import xreliquary.common.CommonProxy;
import xreliquary.entities.*;
import xreliquary.entities.potion.*;
import xreliquary.entities.shot.*;
import xreliquary.event.ClientEventHandler;
import xreliquary.lib.Names;
import xreliquary.lib.Reference;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void init() {
        super.init();
        FMLCommonHandler.instance().bus().register(new ClientEventHandler());
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());

        this.registerRenderers();
    }

    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityBlazeShot.class, new RenderShot());
        RenderingRegistry.registerEntityRenderingHandler(EntityBusterShot.class, new RenderShot());
        RenderingRegistry.registerEntityRenderingHandler(EntityConcussiveShot.class, new RenderShot());
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderShot.class, new RenderShot());
        RenderingRegistry.registerEntityRenderingHandler(EntityExorcismShot.class, new RenderShot());
        RenderingRegistry.registerEntityRenderingHandler(EntityNeutralShot.class, new RenderShot());
        RenderingRegistry.registerEntityRenderingHandler(EntitySeekerShot.class, new RenderShot());
        RenderingRegistry.registerEntityRenderingHandler(EntitySandShot.class, new RenderShot());
        RenderingRegistry.registerEntityRenderingHandler(EntityStormShot.class, new RenderShot());
        RenderingRegistry.registerEntityRenderingHandler(EntityGlowingWater.class, new RenderThrown(0));
        RenderingRegistry.registerEntityRenderingHandler(EntityAttractionPotion.class, new RenderThrown(2));
        RenderingRegistry.registerEntityRenderingHandler(EntityFertilePotion.class, new RenderThrown(11));
        RenderingRegistry.registerEntityRenderingHandler(EntityHolyHandGrenade.class, new RenderThrown(12));
        RenderingRegistry.registerEntityRenderingHandler(EntityKrakenSlime.class, new RenderThrown(13));
        RenderingRegistry.registerEntityRenderingHandler(EntitySpecialSnowball.class, new RenderSnowball(Items.snowball));
        RenderingRegistry.registerEntityRenderingHandler(EntityEnderStaffProjectile.class, new RenderSnowball(Items.ender_pearl));
        MinecraftForgeClient.registerItemRenderer(Reliquary.CONTENT.getItem(Names.handgun), new ItemRendererHandgun());

        // Legacy potions
        RenderingRegistry.registerEntityRenderingHandler(EntityCondensedSplashAphrodite.class, new RenderThrown(Reference.SPLASH_POTION_SPRITE + Reference.APHRODITE_META));
        RenderingRegistry.registerEntityRenderingHandler(EntityCondensedSplashPoison.class, new RenderThrown(Reference.SPLASH_POTION_SPRITE + Reference.POISON_META));
        RenderingRegistry.registerEntityRenderingHandler(EntityCondensedSplashHarm.class, new RenderThrown(Reference.SPLASH_POTION_SPRITE + Reference.ACID_META));
        RenderingRegistry.registerEntityRenderingHandler(EntityCondensedSplashConfusion.class, new RenderThrown(Reference.SPLASH_POTION_SPRITE + Reference.CONFUSION_META));
        RenderingRegistry.registerEntityRenderingHandler(EntityCondensedSplashSlowness.class, new RenderThrown(Reference.SPLASH_POTION_SPRITE + Reference.SLOWING_META));
        RenderingRegistry.registerEntityRenderingHandler(EntityCondensedSplashWeakness.class, new RenderThrown(Reference.SPLASH_POTION_SPRITE + Reference.WEAKNESS_META));
        RenderingRegistry.registerEntityRenderingHandler(EntityCondensedSplashWither.class, new RenderThrown(Reference.SPLASH_POTION_SPRITE + Reference.WITHER_META));
        RenderingRegistry.registerEntityRenderingHandler(EntityCondensedSplashBlindness.class, new RenderThrown(Reference.SPLASH_POTION_SPRITE + Reference.BLINDING_META));
        RenderingRegistry.registerEntityRenderingHandler(EntityCondensedSplashRuin.class, new RenderThrown(Reference.SPLASH_POTION_SPRITE + Reference.RUINATION_META));
        RenderingRegistry.registerEntityRenderingHandler(EntityCondensedFertility.class, new RenderThrown(Reference.SPLASH_POTION_SPRITE + Reference.FERTILIZER_META));
    }

}
