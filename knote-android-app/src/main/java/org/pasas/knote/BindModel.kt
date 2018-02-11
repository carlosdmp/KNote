package org.pasas.knote

import kotlin.properties.ObservableProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

abstract class BindModel{
    var changeListeners = mutableListOf<(BindModel) -> Unit>()
    fun addListener(listener : (BindModel) -> Unit){
        changeListeners.add(listener)
    }
    fun onChange(){
        changeListeners.forEach { it.invoke(this) }
    }

    inline fun <T> bind(initialValue: T):
            ReadWriteProperty<Any?, T> = object : ObservableProperty<T>(initialValue) {
        override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) = onChange()
    }
}