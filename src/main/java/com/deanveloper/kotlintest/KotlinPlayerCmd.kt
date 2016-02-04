package com.deanveloper.kotlintest

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * Says if you're a player
 *
 * @author Dean B
 */
object KotlinPlayerCmd: CommandExecutor {
    override fun onCommand(sender: CommandSender?, cmd: Command?, lbl: String?, args: Array<out String>?): Boolean {
        (sender as? Player)?.sendMessage("You are a player!") ?: sender?.sendMessage("Not a player")

        return true;
    }

}