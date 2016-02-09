package com.deanveloper.kotlintest

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

/**
 * Example Kotlin Plugin
 *
 * @author Dean B
 */
class KotlinPlugin: JavaPlugin() {
    //while this is singleton, a class must be initialized by Bukkit, so we can't use 'object'
    companion object {
        var instance: KotlinPlugin? = null;
        private set;
    }

    override fun onEnable() {
        getCommand("echo").executor = KotlinEchoCmd
        getCommand("player").executor = KotlinPlayerCmd
        getCommand("jarjar").executor = KotlinTestRunnable
        Bukkit.getPluginManager().registerEvents(KotlinListener, this)

        Bukkit.getLogger().info("Config Val: ${config.getString("configVal") ?: "[no val listed]"}")

        instance = this;

        Bukkit.getLogger().info("Enabled!")
    }
}