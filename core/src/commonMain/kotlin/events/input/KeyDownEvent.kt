package dev.pengie.kotaro.events.input

import dev.pengie.kotaro.events.Event
import dev.pengie.kotaro.input.Key
import dev.pengie.kotaro.input.Modifier

/**
 * Event relating to the frame when a key is pressed down.
 */
class KeyDownEvent(val key: Key, val modifiers: HashSet<Modifier>) : Event