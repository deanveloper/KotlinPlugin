package com.deanveloper.kotlintest

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import java.util.*

/**
 * Stores Data for each player on the server
 *
 * @author Dean B
 */
data class PlayerData(val id: UUID, val name: String){
    var silly: Boolean = false;
    companion object: Listener {
        private val data = HashMap<UUID, PlayerData>()

        //allows us to do KotlinPlayerData[id]
        operator fun get(id: UUID?) = data[id]
        operator fun get(p: Player) = PlayerData[p.uniqueId]!!

        @EventHandler
        public fun onJoin(e: PlayerJoinEvent) = PlayerData(e.player.uniqueId, e.player.name)

        @EventHandler
        public fun onQuit(e: PlayerQuitEvent) = data.remove(e.player.uniqueId)
    }

    init {
        data[id] = this
    }
}