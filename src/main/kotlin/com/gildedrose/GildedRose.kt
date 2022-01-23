package com.gildedrose


class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]
            if (item.isSulfuras) continue
            item.sellIn = item.decrementSellIn()
            if (item.isAgedBrie || item.isBackstage) {
                item.quality = item.incrementQuality()

                if (item.isBackstage) {
                    if (item.expireInTenDaysOrLess()) {
                        item.quality = item.incrementQuality()
                    }

                    if (item.expireInFiveDaysOrLess()) {
                        item.quality = item.incrementQuality()
                    }
                }
            } else {
                if (item.isConjured) {
                    item.quality = item.decrementQuality(2)
                } else {
                    item.quality = item.decrementQuality()
                }
            }

            if (item.isSellInExpired()) {
                when {
                    item.isAgedBrie -> item.quality = item.incrementQuality()
                    item.isBackstage -> item.quality = 0
                    item.isConjured -> item.quality = item.decrementQuality(2)
                    else -> item.quality = item.decrementQuality()
                }
            }
        }
    }
}

