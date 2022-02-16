package com.example.androidstudyguid.data.remote.androidessence.models

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "link", strict = false)
data class AndroidEssenceLink(
    @field:Attribute(name = "href")
    @param:Attribute(name = "href")
    val href: String = ""
)
