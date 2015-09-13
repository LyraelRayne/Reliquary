package xreliquary.lib;

public class Reference {
    // class for all the mod related constants
    public static final String VERSION = "1.2";

    public static final String MOD_ID = "xreliquary";
    public static final String MOD_NAME = "Reliquary";

    public static final String CLIENT_PROXY = "xreliquary.client.ClientProxy";
    public static final String COMMON_PROXY = "xreliquary.common.CommonProxy";

    public static final int WATER_SPRITE = 0;
    public static final int SPLASH_POTION_SPRITE = 1;
    public static final int GRENADE_SPRITE = 12;

    // miscellaneous configurable things
    //public static final int CAPACITY_UPGRADE_INCREMENT = 64;

    public static final String ART_PATH_ENTITIES = "textures/entities/";
    public static final String THROWN_ITEM_SPRITES = "thrownItemsSheet.png";

    public static final String MODEL_TEXTURE_PATH = "textures/models/";

    public static final int ZOMBIE_ZHU_META = 0;
    public static final int SKELETON_ZHU_META = 1;
    public static final int WITHER_SKELETON_ZHU_META = 2;
    public static final int CREEPER_ZHU_META = 3;

    public static final int SKELETON_INGREDIENT_META = 0;
    public static final int WITHER_INGREDIENT_META = 1;
    public static final int SPIDER_INGREDIENT_META = 2;
    public static final int CREEPER_INGREDIENT_META = 3;
    public static final int SLIME_INGREDIENT_META = 4;
    public static final int BAT_INGREDIENT_META = 5;
    public static final int ZOMBIE_INGREDIENT_META = 6;
    public static final int MOLTEN_INGREDIENT_META = 7;
    public static final int STORM_INGREDIENT_META = 8;
    public static final int FERTILE_INGREDIENT_META = 9;
    public static final int FROZEN_INGREDIENT_META = 10;
    public static final int ENDER_INGREDIENT_META = 11;
    public static final int SQUID_INGREDIENT_META = 12;
    public static final int CLAW_INGREDIENT_META = 13;
    public static final int SHELL_INGREDIENT_META = 14;
    public static final int CLOTH_INGREDIENT_META = 15;

    // Potion metadata including legacy potions
    public static final int SPLASH_META = 0;
    public static final int APHRODITE_META = 1;
    public static final int POISON_META = 2;
    public static final int ACID_META = 3;
    public static final int CONFUSION_META = 4;
    public static final int SLOWING_META = 5;
    public static final int WEAKNESS_META = 6;
    public static final int WITHER_META = 7;
    public static final int BLINDING_META = 8;
    public static final int RUINATION_META = 9;
    public static final int FERTILIZER_META = 10;

    public static final int EMPTY_VIAL_META = 11;
    public static final int POTION_META = 12;
    public static final int SPEED_META = 13;
    public static final int DIGGING_META = 14;
    public static final int STRENGTH_META = 15;
    public static final int HEALING_META = 16;
    public static final int BOUNDING_META = 17;
    public static final int REGENERATION_META = 18;
    public static final int RESISTANCE_META = 19;
    public static final int FIRE_WARDING_META = 20;
    public static final int BREATHING_META = 21;
    public static final int INVISIBILITY_META = 22;
    public static final int INFRAVISION_META = 23;
    public static final int PROTECTION_META = 24;
    public static final int POTENCE_META = 25;
    public static final int CELERITY_META = 26;
    public static final int PANACEA_META = 27;
    public static final int STALKER_META = 28;
    public static final int WATER_META = 29;

    public static final String LOAD_SOUND = Reference.MOD_ID + ":xload";
    public static final String SHOT_SOUND = Reference.MOD_ID + ":xshot";
    public static final String BOOK_SOUND = Reference.MOD_ID + ":book";
    public static final String GUST_SOUND = Reference.MOD_ID + ":gust";

//not all of these get used but they're good to keep around.
    public static final int WHITE_WOOL_META = 0;
    public static final int ORAGE_WOOL_META = 1;
    public static final int MAGENTA_WOOL_META = 2;
    public static final int LIGHT_BLUE_WOOL_META = 3;
    public static final int YELLOW_WOOL_META = 4;
    public static final int LIME_WOOL_META = 5;
    public static final int PINK_WOOL_META = 6;
    public static final int GRAY_WOOL_META = 7;
    public static final int LIGHT_GRAY_WOOL_META = 8;
    public static final int CYAN_WOOL_META = 9;
    public static final int PURPLE_WOOL_META = 10;
    public static final int BLUE_WOOL_META = 11;
    public static final int BROWN_WOOL_META = 12;
    public static final int GREEN_WOOL_META = 13;
    public static final int RED_WOOL_META = 14;
    public static final int BLACK_WOOL_META = 15;

    public static final int WHITE_DYE_META = 15;
    public static final int ORAGE_DYE_META = 14;
    public static final int MAGENTA_DYE_META = 13;
    public static final int LIGHT_BLUE_DYE_META = 12;
    public static final int YELLOW_DYE_META = 11;
    public static final int LIME_DYE_META = 10;
    public static final int PINK_DYE_META = 9;
    public static final int GRAY_DYE_META = 8;
    public static final int LIGHT_GRAY_DYE_META = 7;
    public static final int CYAN_DYE_META = 6;
    public static final int PURPLE_DYE_META = 5;
    public static final int BLUE_DYE_META = 4;
    public static final int BROWN_DYE_META = 3;
    public static final int GREEN_DYE_META = 2;
    public static final int RED_DYE_META = 1;
    public static final int BLACK_DYE_META = 0;

    public static final int PLAYER_HANDGUN_SKILL_MAXIMUM = 20;

    public static final int HANDGUN_RELOAD_PITCH_OFFSET = 20;
    public static final int HANDGUN_RELOAD_SKILL_OFFSET = 10;
    // This should never exceed (HANDGUN_RELOAD_SKILL_OFFSET) / 2
    public static final int HANDGUN_RELOAD_ANIMATION_TICKS = 5;

    public static final int HANDGUN_RECOIL_SKILL_OFFSET = 5;
    public static final int HANDGUN_COOLDOWN_SKILL_OFFSET = 5;
    public static final int HANDGUN_KNOCKBACK_SKILL_OFFSET = 0;

    //Shot Type Indexes
    public static final int NEUTRAL_SHOT_INDEX = 1;
    public static final int EXORCISM_SHOT_INDEX = 2;
    public static final int BLAZE_SHOT_INDEX = 3;
    public static final int ENDER_SHOT_INDEX = 4;
    public static final int CONCUSSIVE_SHOT_INDEX = 5;
    public static final int BUSTER_SHOT_INDEX = 6;
    public static final int SEEKER_SHOT_INDEX = 7;
    public static final int SAND_SHOT_INDEX = 8;
    public static final int STORM_SHOT_INDEX = 9;

    //minecraft under-the-hood potion names
    public static final String INVIS = "invisibility";
    public static final String ABSORB = "absorption";
    public static final String HBOOST = "healthBoost";
    public static final String DBOOST = "damageBoost";
    public static final String HARM = "harm";
    public static final String HEAL = "heal";
    public static final String SPEED = "moveSpeed";
    public static final String HASTE = "digSpeed";
    public static final String SLOW = "moveSlowdown";
    public static final String FATIGUE = "digSlowDown";
    public static final String BREATH = "waterBreathing";
    public static final String VISION = "nightVision";
    public static final String RESIST = "resistance";
    public static final String FRESIST = "fireResistance";
    public static final String WEAK = "weakness";
    public static final String JUMP = "jump";
    public static final String NAUSEA = "confusion";
    public static final String HUNGER = "hunger";
    public static final String SATURATION = "saturation";
    public static final String REGEN = "regeneration";
    public static final String POISON = "poison";
    public static final String WITHER = "wither";
    public static final String BLIND = "blindness";
}
