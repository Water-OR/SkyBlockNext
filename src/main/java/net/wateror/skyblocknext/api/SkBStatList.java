package net.wateror.skyblocknext.api;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class SkBStatList {
  private final HashMap<SkBStat, Integer> stats = new HashMap<>();
  private final int defaultValue;
  
  public SkBStatList(int defaultValue) {
    this.defaultValue = defaultValue;
    SkBStat.getStats().forEach(stat -> stats.put(stat, this.defaultValue));
  }
  
  public SkBStatList() { this(0); }
  
  @Contract("_ -> new")
  public static @NotNull SkBStatList make(int defaultValue) { return new SkBStatList(defaultValue); }
  
  @Contract(" -> new")
  public static @NotNull SkBStatList make() { return new SkBStatList(); }
  
  public void check(SkBStat key) {
    if (!stats.containsKey(key)) {
      stats.put(key, this.defaultValue);
    }
  }
  
  public Integer get(SkBStat key) {
    check(key);
    return stats.get(key);
  }
  
  @Nullable
  public SkBStatList set(SkBStat key, Integer value) {
    check(key);
    stats.replace(key, value);
    return this;
  }
  
  public SkBStatList reset(SkBStat key) {
    check(key);
    stats.replace(key, 0);
    return this;
  }
  
  public SkBStatList clear() {
    SkBStat.getStats().forEach(this::check);
    stats.replaceAll((stat, integer) -> 0);
    return this;
  }
  
  public SkBStatList forEach(BiConsumer<SkBStat, Integer> action) {
    SkBStat.getStats().forEach(this::check);
    stats.forEach(action);
    return this;
  }
}
