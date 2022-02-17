package com.example.androidstudyguid.data.models.remote

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "author", strict = false)
data class AndroidEssenceAuthor(
    @field:Element(name = "name")
    @param:Element(name = "name")
    val name: String? = null
)
