package net.wateror.skyblocknext;

import org.bukkit.plugin.java.JavaPlugin;

public final class SkyBlockNext extends JavaPlugin {
  public static final String PLUGIN_KEY = "SkyBlockNext";
  
  @Override
  public void onEnable() {
    // Plugin startup logic
    print("======Welcome to SkyBlock Next======");
    print("|                                  |");
    print("|    ()()()   {}{}{}     []    []  |");
    print("|  ()         {}    {}   []  [][]  |");
    print("|    ()()     {}{}{}     [][]  []  |");
    print("|        ()   {}    {}   []    []  |");
    print("|  ()()()     {}{}{}     []    []  |");
    print("|                                  |");
    print("====================================");
  }
  
  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
  
  public static void print(String message) {
    System.out.println("[Sky Block Next]" + message);
  }
  
  public static void print(String message, Object... objects) {
    print(String.format(message, objects));
  }
}
