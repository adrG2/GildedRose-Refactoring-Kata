package com.gildedrose


class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].isSulfuras) continue
            if (items[i].isAgedBrie || items[i].isBackstage) {
                items[i].quality = items[i].incrementQuality()

                if (items[i].isBackstage) {
                    if (items[i].expireInTenDaysOrLess()) {
                        items[i].quality = items[i].incrementQuality()
                    }

                    if (items[i].expireInFiveDaysOrLess()) {
                        items[i].quality = items[i].incrementQuality()
                    }
                }
            } else {
                if (items[i].isConjured) {
                    items[i].quality = items[i].decrementQuality(2)
                } else {
                    items[i].quality = items[i].decrementQuality()
                }
            }

            // normales y conjured
            items[i].sellIn = items[i].decrementSellIn()


            if (items[i].isSellInExpired()) {
                if (items[i].isAgedBrie) {
                    items[i].quality = items[i].incrementQuality()
                } else {
                    if (!items[i].isBackstage) {
                        // normales y conjured
                        if (items[i].isConjured) {
                            items[i].quality = items[i].decrementQuality(2)
                        } else {
                            items[i].quality = items[i].decrementQuality()
                        }
                    } else {
                        // Solo backstage
                        items[i].quality = items[i].quality - items[i].quality
                    }
                }
            }
        }
    }

}

