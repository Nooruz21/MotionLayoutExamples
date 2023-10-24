package com.example.motionlayoutexamples

data class Demo(
    val title: String,
    val type: Types,
    val layout: Int = 0,
    val activity: Class<*> = DemoActivity::class.java
) {
    constructor(
        title: String,
        type: Types,
        activity: Class<*> = DemoActivity::class.java
    ) : this(title, type, 0, activity)
}
