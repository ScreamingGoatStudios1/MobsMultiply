package com.jake.mobsmultiply;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MobsMultiply extends JavaPlugin {
    public static MobsMultiply plugin;

    public static boolean isStarted = false;

    @Override
    public void onEnable() {
        getCommand("mobsmultiply").setExecutor(new StartCommand());
        Bukkit.getPluginManager().registerEvents(new MobHitListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
