package com.deanveloper.kotlintest

import org.bukkit.Location
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

    @EventHandler
    public fun onMove(e: PlayerMoveEvent) {
        //prevent too many calculations from being calculated by only checking when players change blocks
        if(!(e.from equalsBlock e.to)) { // infix function equalsBlock shown above
            e.player.damage(0.0);
        }
    }
}