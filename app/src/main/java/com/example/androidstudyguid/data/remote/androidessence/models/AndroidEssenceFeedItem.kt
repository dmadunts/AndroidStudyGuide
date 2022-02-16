package com.example.androidstudyguid.data.remote.androidessence.models

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "entry", strict = false)
data class AndroidEssenceFeedItem(
    @field:Element(name = "title")
    @param:Element(name = "title")
    val title: String = "",

    @field:Element(name = "id")
    @param:Element(name = "id")
    val id: String = "",
)
