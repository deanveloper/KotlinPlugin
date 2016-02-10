package com.deanveloper.kotlintest

import com.deanveloper.kotlintest.command.EchoCmd
import com.deanveloper.kotlintest.command.PlayerCmd
import com.deanveloper.kotlintest.command.SillyCmd
import com.deanveloper.kotlintest.command.AsyncTaskCmd
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
        var instance: KotlinPlugin? = null
        private set;
    }

    override fun onEnable() {
        getCommand("echo").executor = EchoCmd
        getCommand("player").executor = PlayerCmd
        getCommand("jarjar").executor = AsyncTaskCmd
        getCommand("silly").executor = SillyCmd
        Bukkit.getPluginManager().registerEvents(KotlinListener, this)
        Bukkit.getPluginManager().registerEvents(PlayerData, this)

        Bukkit.getLogger().info("Config Val: ${config.getString("configVal") ?: "[no val listed]"}")

        instance = this;

        Bukkit.getLogger().info("Enabled!")
    }
}