package com.deanveloper.kotlintest

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

/**
 * Example Listener (Click a stick, get its name)
 *
 * @author Dean B
 */
object KotlinListener: Listener {
    @EventHandler
    public fun onStickClick(e: PlayerInteractEvent) {
        if(e.action == Action.PHYSICAL) return;

        if(e.item?.type == Material.STICK) {
            e.player.sendMessage("You clicked a stick named [${e.item.itemMeta?.displayName ?: "Unnamed"}]")
        }
    }
}