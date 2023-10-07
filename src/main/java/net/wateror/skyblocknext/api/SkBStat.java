package net.wateror.skyblocknext.api;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;

public class SkBStat {
  public final String registerName;
  public final String name;
  public final char icon;
  public final int capLow;
  public final int capHigh;
  public final ChatColor color;
  public final boolean dungeonImprovable;
  
  public SkBStat(String registerName, String name, char icon, int capLow, int capHigh, ChatColor color, boolean dungeonImprovable) {
    if (hasStat(registerName)) {
      throw new RuntimeException("Stat name already been used:" + registerName);
    }
    this.registerName = registerName;
    this.name = name;
    this.icon = icon;
    this.capLow = capLow;
    this.capHigh = capHigh;
    this.color = color;
    this.dungeonImprovable = dungeonImprovable;
    
    NAME_STAT_MAP.put(this.registerName, this);
  }
  
  @Contract("_, _, _, _, _, _, _ -> new")
  public static @NotNull SkBStat make(String registerName, String name, char icon, int capLow, int capHigh, ChatColor color, boolean dungeonImprovable) {
    return new SkBStat(registerName, name, icon, capLow, capHigh, color, dungeonImprovable);
  }
  
  private static final HashMap<String, SkBStat> NAME_STAT_MAP = new HashMap<>();
  
  @Contract(pure = true)
  public static @NotNull Collection<SkBStat> getStats() { return NAME_STAT_MAP.values(); }
  
  public static SkBStat getStat(String name) { return NAME_STAT_MAP.get(name); }
  
  public static boolean hasStat(String  name) { return NAME_STAT_MAP.containsKey  (name); }
  public static boolean hasStat(SkBStat stat) { return NAME_STAT_MAP.containsValue(stat); }
  
  // COMBAT STATS
  public static final SkBStat HEALTH             = new SkBStat("HEALTH"            , "Health"            , '\u2764', 0, 0x7FFFFFFF, ChatColor.RED     , true);
  public static final SkBStat DEFENCE            = new SkBStat("DEFENCE"           , "Defence"           , '\u2748', 0, 0x7FFFFFFF, ChatColor.GREEN   , true);
  public static final SkBStat STRENGTH           = new SkBStat("STRENGTH"          , "Strength"          , '\u2741', 0, 0x7FFFFFFF, ChatColor.RED     , true);
  public static final SkBStat INTELLIGENCE       = new SkBStat("INTELLIGENCE"      , "Intelligence"      , '\u270E', 0, 0x7FFFFFFF, ChatColor.AQUA    , true);
  public static final SkBStat CRIT_CHANCE        = new SkBStat("CRIT_CHANCE"       , "Crit Chance"       , '\u2623', 0, 0x00000064, ChatColor.BLUE    , true);
  public static final SkBStat CRIT_DAMAGE        = new SkBStat("CRIT_DAMAGE"       , "Crit Damage"       , '\u2620', 0, 0x7FFFFFFF, ChatColor.BLUE    , true);
  public static final SkBStat BONUS_ATTACK_SPEED = new SkBStat("BONUS_ATTACK_SPEED", "Bonus Attack Speed", '\u2694', 0, 0x00000064, ChatColor.YELLOW  , true);
  public static final SkBStat ABILITY_DAMAGE     = new SkBStat("ABILITY_DAMAGE"    , "Ability Damage"    , '\u0E51', 0, 0x7FFFFFFF, ChatColor.RED     , true);
  public static final SkBStat TRUE_DEFENCE       = new SkBStat("TRUE_DEFENCE"      , "True Defence"      , '\u2742', 0, 0x7FFFFFFF, ChatColor.WHITE   , true);
  public static final SkBStat FEROCITY           = new SkBStat("FEROCITY"          , "Ferocity"          , '\u2AFD', 0, 2147483647, ChatColor.RED     , true);
  public static final SkBStat HEALTH_REGEN       = new SkBStat("HEALTH_REGEN"      , "Health Regen"      , '\u2763', 0, 0x7FFFFFFF, ChatColor.RED     , true);
  public static final SkBStat VITALITY           = new SkBStat("VITALITY"          , "Vitality"          , '\u2668', 0, 0x7FFFFFFF, ChatColor.DARK_RED, true);
  public static final SkBStat MENDING            = new SkBStat("MENDING"           , "Mending"           , '\u2604', 0, 0x7FFFFFFF, ChatColor.GREEN   , true);
  public static final SkBStat SWING_RANGE        = new SkBStat("SWING_RANGE"       , "Swing Range"       , '\u24C8', 0, 0x7FFFFFFF, ChatColor.YELLOW  , true);
  
  // GATHERING STATS
  public static final SkBStat MINING_SPEED     = new SkBStat("MINING_SPEED"    , "Mining Speed"    , '\u2E15', 0, 0x7FFFFFFF, ChatColor.GOLD       , false);
  public static final SkBStat MINING_FORTUNE   = new SkBStat("MINING_FORTUNE"  , "Mining Fortune"  , '\u2618', 0, 0x7FFFFFFF, ChatColor.GOLD       , false);
  public static final SkBStat FARMING_FORTUNE  = new SkBStat("FARMING_FORTUNE" , "Farming Fortune" , '\u2618', 0, 0x7FFFFFFF, ChatColor.GOLD       , false);
  public static final SkBStat FORAGING_FORTUNE = new SkBStat("FORAGING_FORTUNE", "Foraging Fortune", '\u2618', 0, 0x7FFFFFFF, ChatColor.GOLD       , false);
  public static final SkBStat PRISTINE         = new SkBStat("PRISTINE"        , "Pristine"        , '\u2727', 0, 0x7FFFFFFF, ChatColor.DARK_PURPLE, false);
  
  // MISC STATS
  public static final SkBStat SPEED               = new SkBStat("SPEED"              , "Speed"              , '\u2726', 1, 0x00000190, ChatColor.WHITE       , true);
  public static final SkBStat MAGIC_FIND          = new SkBStat("MAGIC_FIND"         , "Magic Find"         , '\u272F', 0, 0x7FFFFFFF, ChatColor.AQUA        , false);
  public static final SkBStat PET_LUCK            = new SkBStat("PET_LUCK"           , "Pet Luck"           , '\u2663', 0, 0x7FFFFFFF, ChatColor.LIGHT_PURPLE, false);
  public static final SkBStat SEA_CREATURE_CHANCE = new SkBStat("SEA_CREATURE_CHANCE", "Sea Creature Chance", '\u03B1', 0, 0x00000064, ChatColor.DARK_AQUA   , false);
  public static final SkBStat FISHING_SPEED       = new SkBStat("FISHING_SPEED"      , "Fishing Speed"      , '\u2602', 0, 0x0000012C, ChatColor.AQUA        , false);
  
  // RIFT STATS
  public static final SkBStat RIFT_TIME   = new SkBStat("RIFT_TIME"  , "Rift Time"  , '\u0444', 0, 0x7FFFFFFF, ChatColor.GREEN      , false);
  public static final SkBStat MANA_REGEN  = new SkBStat("MANA_REGEN" , "Mana Regen" , '\u26A1', 0, 0x7FFFFFFF, ChatColor.AQUA       , false);
  public static final SkBStat RIFT_DAMAGE = new SkBStat("RIFT_DAMAGE", "Rift Damage", '\u2741', 0, 0x7FFFFFFF, ChatColor.DARK_PURPLE, false);
  public static final SkBStat HEARTS      = new SkBStat("HEARTS"     , "Hearts"     , '\u2764', 0, 0x7FFFFFFF, ChatColor.RED        , false);
  
  // OTHER STATS
  public static final SkBStat HEAT     = new SkBStat("HEAT"    , "Heat"    , '\u2668', 0, 0x7FFFFFFF, ChatColor.RED      , false);
  public static final SkBStat DAMAGE   = new SkBStat("DAMAGE"  , "Damage"  , '\u2741', 0, 0x7FFFFFFF, ChatColor.RED      , false);
  public static final SkBStat OVERFLOW = new SkBStat("OVERFLOW", "Overflow", '\u02AC', 0, 0x7FFFFFFF, ChatColor.DARK_AQUA, false);
  public static final SkBStat SOULFLOW = new SkBStat("SOULFLOW", "Soulflow", '\u2E0E', 0, 0x7FFFFFFF, ChatColor.DARK_AQUA, false);
}
