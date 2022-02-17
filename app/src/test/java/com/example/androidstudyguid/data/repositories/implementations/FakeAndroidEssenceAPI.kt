package com.example.androidstudyguid.data.repositories.implementations

import com.example.androidstudyguid.data.apis.AndroidEssenceAPI
import com.example.androidstudyguid.data.models.remote.AndroidEssenceFeed

class FakeAndroidEssenceAPI : AndroidEssenceAPI {
    private lateinit var mockedFeed: AndroidEssenceFeed
    override suspend fun getFeed(): AndroidEssenceFeed {
        return mockedFeed
    }

    fun setMockedFeed(feed: AndroidEssenceFeed) {
        this.mockedFeed = feed
    }
}
