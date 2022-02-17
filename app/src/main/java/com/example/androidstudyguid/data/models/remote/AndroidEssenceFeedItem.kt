package com.example.androidstudyguid.data.models.remote

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "entry", strict = false)
data class AndroidEssenceFeedItem(
    @field:Element(name = "title")
    @param:Element(name = "title")
    val title: String? = null,

    @field:Element(name = "id")
    @param:Element(name = "id")
    val id: String? = null,

    @field:Element(name = "author")
    @param:Element(name = "author")
    val author: AndroidEssenceAuthor? = null,

    @field:Element(name = "link")
    @param:Element(name = "link")
    val link: AndroidEssenceLink? = null
)
