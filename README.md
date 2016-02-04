#Kotlin makes things easier
Let's take a look at each basic plugin subsystem...

-----
###Listeners
Listeners are pretty similar to how we do them in Java. Although in some events, `null` is very common and very annoying to handle, a great example being in PlayerInteractEvent. With Kotlin, its null-safety makes everything much easier. The following in Java:
```
String s = null;
if(e.hasItem() && e.getItem().hasItemMeta() && e.getItem().getItemMeta().hasDisplayName()) {
    s = e.getItem().getItemMeta().getDisplayName();
}
``` 
can be condensed all the way down to a single line of code:
```
val s = e.item?.itemMeta?.displayName
```
(File for reference: [KotlinListener.kt](https://github.com/unon1100/KotlinPlugin/blob/master/src/main/java/com/deanveloper/kotlintest/KotlinListener.kt))

------
###Commands
Commands are now also much easier. An echo command can be made in one line without use of other external libraries (such as google guava's `Joiner` class). In Kotlin, we can just do `sender!!.sendMessage(args?.joinToString(separator=" "))` to echo the arguments back to the sender.
(File for reference: [KotlinEchoCmd.kt](https://github.com/unon1100/KotlinPlugin/blob/master/src/main/java/com/deanveloper/kotlintest/KotlinEchoCmd.kt))

Also, Kotlin has safe casting as well. This makes running player-specific funtions on a `CommandSender` very easy!
```
(sender as? Player)?.chat("I just ran the /player command!") ?: sender?.sendMessage("You aren't a player :(")
```
(File for reference: [KotlinPlayerCmd.kt](https://github.com/unon1100/KotlinPlugin/blob/master/src/main/java/com/deanveloper/kotlintest/KotlinPlayerCmd.kt))

-------
###Main Plugin
#####Registering Listeners or CommandExecutors
Registering a `Listener` or `CommandExecutor` is now much easier as well! Because they are both singletons where we create the instance ourselves, we can define them as an `object` instead of a `class`, which means that we can reference the instance of the singleton by simply typing the object's name instead of needing to store the instance manually. This means that we can register a command using `getCommand("echo").setExecutor(KotlinEchoCmd)`, or shorten it even further by using `getCommand("echo").executor = KotlinEchoCmd`. Registering listeners looks like `Bukkit.getPluginManager().registerEvents(KotlinListener, this)`

#####Getting values from the config
Really this isn't that much different other than how you type `config` instead of `getConfig()`. Also, the null safety makes everything pretty easy with configs as well.

(File for reference: [KotlinPlugin.kt](https://github.com/unon1100/KotlinPlugin/blob/master/src/main/java/com/deanveloper/kotlintest/KotlinPlugin.kt))

----------
###Epilogue
I hope you found this useful! Kotlin is very useful for creating Bukkit plugins, and I hope to see some really cool plugins in the future made with this language. If you found this useful, feel free to star the repo and check it out whenever you want. I'll definitely add more to it, including things like how `infix` functions can be used!
