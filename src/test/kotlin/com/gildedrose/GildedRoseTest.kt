package com.gildedrose

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class GildedRoseTest : FreeSpec({

    "it should verify one update for different items" {
        val items = listOf(
            Item("+5 Dexterity Vest", 10, 20),
            Item("Aged Brie", 2, 0),
            Item("Elixir of the Mongoose", 5, 7),
            Item("Sulfuras, Hand of Ragnaros", 0, 80),
            Item("Sulfuras, Hand of Ragnaros", -1, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 48),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 47),
            Item("Backstage passes to a TAFKAL80ETC concert", -1, 49),
            Item("+5 Dexterity Vest", 1, 0),
            Item("Conjured Mana Cake", 3, 0),
            Item("+5 Dexterity Vest", -1, 5),
            Item("Aged Brie", -1, 1),
        )
        val gildedRose = GildedRose(items)
        gildedRose.updateQuality()
        gildedRose.items[0] shouldBe Item("+5 Dexterity Vest", 9, 19)
        gildedRose.items[1] shouldBe Item("Aged Brie", 1, 1)
        gildedRose.items[2] shouldBe Item("Elixir of the Mongoose", 4, 6)
        gildedRose.items[3] shouldBe Item("Sulfuras, Hand of Ragnaros", 0, 80)
        gildedRose.items[4] shouldBe Item("Sulfuras, Hand of Ragnaros", -1, 80)
        gildedRose.items[5] shouldBe Item("Backstage passes to a TAFKAL80ETC concert", 14, 21)
        gildedRose.items[6] shouldBe Item("Backstage passes to a TAFKAL80ETC concert", 9, 50)
        gildedRose.items[7] shouldBe Item("Backstage passes to a TAFKAL80ETC concert", 4, 50)
        gildedRose.items[8] shouldBe Item("Backstage passes to a TAFKAL80ETC concert", -2, 0)
        gildedRose.items[9] shouldBe Item("+5 Dexterity Vest", 0, 0)
        gildedRose.items[10] shouldBe Item("Conjured Mana Cake", 2, 5) //todo este debe ser el doble
        gildedRose.items[11] shouldBe Item("+5 Dexterity Vest", -1, 5)
        gildedRose.items[12] shouldBe Item("Aged Brie", -1, 2)
    }

        "assertions throw" - {
            listOf(
                listOf(Item(name = "withQualityMinus1", sellIn = 0, quality = -1)),
                listOf(Item(name = "withQuality50", sellIn = 0, quality = 51)),
            ).forEach {
                val first = it.first()
                "given item with quality ${first.quality} and sellIn ${first.sellIn} when updateQuality then throws" {
                    shouldThrow<IllegalArgumentException> {
                        GildedRose(it).updateQuality()
                    }
                }
            }
        }

    })


