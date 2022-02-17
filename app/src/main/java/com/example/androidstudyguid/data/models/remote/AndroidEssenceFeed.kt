package com.example.androidstudyguid.data.models.remote

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "feed", strict = false)
data class AndroidEssenceFeed(
    @field:ElementList(name = "entry", inline = true)
    @param:ElementList(name = "entry", inline = true)
    val items: List<AndroidEssenceFeedItem>? = null
)
