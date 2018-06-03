# Kotlin makes things easier
Let's take a look at each basic plugin subsystem...

-----
### Listeners

##### Null Safety
Listeners are pretty similar to how we do them in Java. Although in some events, `null` is very common and very annoying to handle, a great example being in PlayerInteractEvent. With Kotlin, its null-safety makes everything much easier. The following in Java:
```Java
String s = "Unnamed";
if(e.hasItem() && e.getItem().hasItemMeta() && e.getItem().getItemMeta().hasDisplayName()) {
    s = e.getItem().getItemMeta().getDisplayName();
}
``` 
can be condensed all the way down to a single line of code:
```Kotlin
val s = e.item?.itemMeta?.displayName ?: "Unnamed"
```

##### Infix Functions
Infix functions makes code look much cleaner. Take a common operation done in PlayerMoveEvent, making it so that the calculation is only done if the player moves a block. Normally what you would see is...
```Java
Location from = e.getFrom();
Location to = e.getTo();
if(!(from.getBlockX() == to.getBlockX() && from.getBlockY() == to.getBlockY() && from.getBlockZ() == to.getBlockZ())) {
    e.getPlayer().damage(0.0);
}
```
Some people would make it look a bit cleaner by doing this...
```Java
public boolean equalsBlock(Location from, Location to) {
    return from.getBlockX() == to.getBlockX() && from.getBlockY() == to.getBlockY() && from.getBlockZ() == to.getBlockZ()
}
public void onMove(PlayerMoveEvent e) {
    if(!equalsBlock(e.getFrom(), e.getTo()) {
        e.getPlayer().damage(0.0);
    }
}
```
But with Kotlin, we can make it look even CLEANER with an infix function!
```Kotlin
infix fun Location.equalsBlock(other: Location) =
        this.blockX == other.blockX && this.blockY == other.blockY && this.blockZ == other.blockZ

public fun onMove(e: PlayerMoveEvent) {
    if(!(e.from equalsBlock e.to)) {
        e.player.damage(0.0);
    }
}
```

**(File for reference: [KotlinListener.kt](https://github.com/unon1100/KotlinPlugin/blob/master/src/main/java/com/deanveloper/kotlintest/KotlinListener.kt))**

------
### Commands

##### Echo
Commands are now also much easier. An echo command can be made in one line without use of other external libraries (such as google guava's `Joiner` class). In Kotlin, we can just do `sender!!.sendMessage(args?.joinToString(separator=" "))` to echo the arguments back to the sender.

**(File for reference: [KotlinEchoCmd.kt](https://github.com/unon1100/KotlinPlugin/blob/master/src/main/java/com/deanveloper/kotlintest/KotlinEchoCmd.kt))**

##### Safe Casting
Also, Kotlin has safe casting as well. This makes running player-specific funtions on a `CommandSender` very easy!
```Kotlin
(sender as? Player)?.chat("I just ran the /player command!") ?: sender?.sendMessage("You aren't a player :(")
```
**(File for reference: [KotlinPlayerCmd.kt](https://github.com/unon1100/KotlinPlugin/blob/master/src/main/java/com/deanveloper/kotlintest/KotlinPlayerCmd.kt))**

-----
##### Before you say I missed something...
Check out the [wiki](https://github.com/unon1100/KotlinPlugin/wiki)
### Epilogue
I hope you found this useful! Kotlin is very useful for creating Bukkit plugins, and I hope to see some really cool plugins in the future made with this language. If you found this useful, feel free to star the repo and check it out whenever you want. I'll definitely add more to it in the future!
