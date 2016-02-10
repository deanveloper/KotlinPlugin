package com.deanveloper.kotlintest.command;

import com.deanveloper.kotlintest.KotlinPlugin
import khttp.get
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

/**
 * An example of lambdas in Kotlin
 *
 * @author Dean B
 */
object KotlinTestRunnable: CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, lbl: String, args: Array<String>): Boolean {
        val movie: Int;
        try {
            movie = Integer.getInteger(args[0]);
            assert(movie in 1..7)
        } catch (e: Exception) {
            return false;
        }
        Bukkit.getScheduler().runTaskAsynchronously(KotlinPlugin.instance) {
            val jarjar = get("http://swapi.co/api/people/36").jsonObject
            val films = jarjar.getJSONArray("films");
            if(films.contains("http://swapi.co/api/films/$movie/")) {
                sender.sendMessage("That movie was bad, jarjar was in it")
            } else {
                sender.sendMessage("That movie was fine, jarjar wasn't in it")
            }
        }

        return true;
    }
}
