package com.gildedrose

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class GildedRoseTest: FreeSpec({

    "it should foo" {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        app.items[0].name shouldBe "fixme"
        // assertEquals("fixme", app.items[0].name)
    }
})


