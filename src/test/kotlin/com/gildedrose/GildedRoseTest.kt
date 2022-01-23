package com.gildedrose

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class GildedRoseTest : FreeSpec({

    "it should verify updates for different items" {
        val gildedRose = GildedRose(
            listOf(
                Item("+5 Dexterity Vest", 10, 20),
                Item("Aged Brie", 0, 0),
                Item("Elixir of the Mongoose", 5, 7),
                Item("Sulfuras, Hand of Ragnaros", 0, 80),
                Item("Sulfuras, Hand of Ragnaros", -1, 80),
                Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                Item("Backstage passes to a TAFKAL80ETC concert", 10, 48),
                Item("Backstage passes to a TAFKAL80ETC concert", 5, 47),
                Item("Backstage passes to a TAFKAL80ETC concert", -1, 49),
                Item("+5 Dexterity Vest", 1, 0),
                Item("Conjured Mana Cake", 3, 2),
                Item("Conjured Mana Cake", 5, 1),
                Item("Conjured Mana Cake", -1, 4),
                Item("Conjured Mana Cake", -1, 5),
                Item("+5 Dexterity Vest", -1, 5),
                Item("Aged Brie", 5, 50),
                Item("Aged Brie", 15, 49),
                Item("Aged Brie", -1, 1),
            )
        )
        gildedRose.updateQuality()
        gildedRose.items[0] shouldBe Item("+5 Dexterity Vest", 9, 19)
        gildedRose.items[1] shouldBe Item("Aged Brie", -1, 2)
        gildedRose.items[2] shouldBe Item("Elixir of the Mongoose", 4, 6)
        gildedRose.items[3] shouldBe Item("Sulfuras, Hand of Ragnaros", 0, 80)
        gildedRose.items[4] shouldBe Item("Sulfuras, Hand of Ragnaros", -1, 80)
        gildedRose.items[5] shouldBe Item("Backstage passes to a TAFKAL80ETC concert", 14, 21)
        gildedRose.items[6] shouldBe Item("Backstage passes to a TAFKAL80ETC concert", 9, 50)
        gildedRose.items[7] shouldBe Item("Backstage passes to a TAFKAL80ETC concert", 4, 50)
        gildedRose.items[8] shouldBe Item("Backstage passes to a TAFKAL80ETC concert", -2, 0)
        gildedRose.items[9] shouldBe Item("+5 Dexterity Vest", 0, 0)
        gildedRose.items[10] shouldBe Item("Conjured Mana Cake", 2, 0)
        gildedRose.items[11] shouldBe Item("Conjured Mana Cake", 4, 0)
        gildedRose.items[12] shouldBe Item("Conjured Mana Cake", -2, 0)
        gildedRose.items[13] shouldBe Item("Conjured Mana Cake", -2, 1)
        gildedRose.items[14] shouldBe Item("+5 Dexterity Vest", -2, 3)
        gildedRose.items[15] shouldBe Item("Aged Brie", 4, 50)
        gildedRose.items[16] shouldBe Item("Aged Brie", 14, 50)
        gildedRose.items[17] shouldBe Item("Aged Brie", -2, 3)
    }

})


