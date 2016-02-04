#Kotlin makes things easier
Let's take a look at each basic plugin subsystem...
###Listeners
Listeners are pretty similar to how we do them in Java. Although in some events, `null` is very common and very annoying to handle, a great example being in PlayerInteractEvent. With Kotlin, its null-safety makes everything much easier, condensing `if(e.hasItem() && e.getItem().hasItemMeta() && e.getItem().getItemMeta().hasDisplayName()) { e.getItem().getItemMeta().getDisplayName() }` all the way down to `e.item?.itemMeta?.displayName`
