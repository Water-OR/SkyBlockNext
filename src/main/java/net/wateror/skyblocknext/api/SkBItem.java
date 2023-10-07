package net.wateror.skyblocknext.api;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;

public abstract class SkBItem {
  public final String registerName;
  public final String name;
  public final SkBRarity rarity;
  public final ItemStack stack;
  
  public static final String NBT_KEY_NAME = "Name";
  
  public SkBItem(String registerName, String name, ItemStack stack, SkBRarity rarity) {
    this.registerName = registerName;
    this.name = name;
    this.stack = stack;
    this.rarity = rarity;
    NAME_ITEM_MAP.put(this.registerName, this);
  }
  
  private static final HashMap<String, SkBItem> NAME_ITEM_MAP = new HashMap<>();
  
  /**
   * Returns all the items
   * @return Collection of all the items
   */
  @Contract(pure = true)
  public static @NotNull Collection<SkBItem> getItems() { return NAME_ITEM_MAP.values(); }
  
  public static SkBItem getItem(String name) { return NAME_ITEM_MAP.get(name); }
  
  public static boolean hasItem(String  name) { return NAME_ITEM_MAP.containsKey  (name); }
  public static boolean hasItem(SkBItem item) { return NAME_ITEM_MAP.containsValue(item); }
}
