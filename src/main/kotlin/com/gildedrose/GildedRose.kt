package com.gildedrose


class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]
            if (item.isSulfuras) continue
            when {
                item.isAgedBrie || item.isBackstage -> {
                    item.incrementQuality()

                    if (item.isBackstage) {
                        if (item.expireInTenDaysOrLess()) {
                            item.incrementQuality()
                        }

                        if (item.expireInFiveDaysOrLess()) {
                            item.incrementQuality()
                        }
                    }
                }
                item.isConjured -> item.decrementQuality(2)
                else -> item.decrementQuality()
            }

            item.decrementSellIn()
            if (item.isSellInExpired()) {
                when {
                    items[i].isAgedBrie -> items[i].incrementQuality()
                    items[i].isBackstage -> items[i].quality = 0
                    items[i].isConjured -> items[i].decrementQuality(2)
                    else -> items[i].decrementQuality()
                }
            }
        }
    }

    private fun Item.update() {
        decrementSellIn()
        when(name) {
            "Aged Brie" -> {
                incrementQuality()
                if (sellIn < 0) incrementQuality()
            }
            "Backstage passes to a TAFKAL80ETC concert" -> {
                when  {
                    sellIn < 0 -> quality = 0
                    sellIn in 0..5 -> incrementQuality(3)
                    sellIn in 6..10 -> incrementQuality(2)
                    else -> incrementQuality()
                }
            }
            "Sulfuras, Hand of Ragnaros" -> {}
            "Conjured Mana Cake" -> {
                decrementQuality(2)
                if (sellIn < 0) decrementQuality(2)
            }
            else -> {
                decrementQuality()
                if (sellIn < 0) decrementQuality()
            }
        }
    }
}


