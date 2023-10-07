package net.wateror.skyblocknext.api;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;

public class SkBRarity {
  public final String registerName;
  public final String name;
  public final ChatColor color;
  
  public SkBRarity(String registerName, String name, ChatColor color) {
    if (hasRarity(name)) {
      throw new RuntimeException("Rarity Name already been used:" + registerName);
    }
    this.registerName = registerName;
    this.name = name;
    this.color = color;
    
    NAME_RARITY_MAP.put(registerName, this);
  }
  
  @Contract("_, _, _ -> new")
  public static @NotNull SkBRarity make(String registerName, String name, ChatColor color) { return new SkBRarity(registerName, name, color); }
  
  @Contract("_ -> new")
  public static @NotNull SkBRarity make(String name) { return new SkBRarity(name); }
  
  public SkBRarity(String name) {
    this(name.toUpperCase().replace(' ', '_'), name, ChatColor.WHITE);
  }
  
  private static final HashMap<String, SkBRarity> NAME_RARITY_MAP = new HashMap<>();
  
  @Contract(pure = true)
  public static @NotNull Collection<SkBRarity> getRarities() { return NAME_RARITY_MAP.values(); }
  
  public static SkBRarity getRarity(String name) { return NAME_RARITY_MAP.get(name); }
  
  public static boolean hasRarity(String    name  ) { return NAME_RARITY_MAP.containsKey  (name  ); }
  public static boolean hasRarity(SkBRarity rarity) { return NAME_RARITY_MAP.containsValue(rarity); }
  
  public static final SkBRarity COMMON    = new SkBRarity("COMMON"   , "COMMON"   , ChatColor.WHITE       );
  public static final SkBRarity UNCOMMON  = new SkBRarity("UNCOMMON" , "UNCOMMON" , ChatColor.GREEN       );
  public static final SkBRarity RARE      = new SkBRarity("RARE"     , "RARE"     , ChatColor.DARK_BLUE   );
  public static final SkBRarity EPIC      = new SkBRarity("EPIC"     , "EPIC"     , ChatColor.DARK_PURPLE );
  public static final SkBRarity LEGENDARY = new SkBRarity("LEGENDARY", "LEGENDARY", ChatColor.GOLD        );
  public static final SkBRarity MYTHIC    = new SkBRarity("MYTHIC"   , "MYTHIC"   , ChatColor.LIGHT_PURPLE);
  public static final SkBRarity DIVINE    = new SkBRarity("DIVINE"   , "DIVINE"   , ChatColor.AQUA        );
  
  public static final SkBRarity SPECIAL      = new SkBRarity("SPECIAL"     , "SPECIAL"     , ChatColor.RED);
  public static final SkBRarity VERY_SPECIAL = new SkBRarity("VERY_SPECIAL", "VERY SPECIAL", ChatColor.RED);
  
  public static final SkBRarity ADMIN = new SkBRarity("ADMIN", "ADMIN", ChatColor.DARK_RED);
  
  @Override
  public String toString() {
    return color.toString() + name;
  }
}
