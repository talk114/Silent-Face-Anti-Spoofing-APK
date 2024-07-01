package com.mv.engine

import android.util.Log


abstract class Component {

    init {
        try {
            Log.wtf("LOAD_LIB", "LOAD COMPONENT engine")
            System.loadLibrary("engine")
            libraryFound = true
        } catch (e: UnsatisfiedLinkError) {
            e.printStackTrace()
        }
    }

    abstract fun createInstance(): Long

    abstract fun destroy()

    companion object {
        var libraryFound: Boolean = false

        const val tag = "Component"
    }
}