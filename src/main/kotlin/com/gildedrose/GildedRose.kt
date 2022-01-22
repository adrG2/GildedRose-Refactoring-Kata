package com.gildedrose

private const val QUALITY_MAX = 50
private const val QUALITY_MIN = 0

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (!items[i].isAgedBrie && !items[i].isBackstage) {
                if (items[i].quality > QUALITY_MIN) {
                    if (!items[i].isSulfuras) {
                        items[i].quality = items[i].decrementQuality()
                    }
                }
            } else {
                if (items[i].quality < QUALITY_MAX) {
                    items[i].quality = items[i].incrementQuality()

                    if (items[i].isBackstage) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < QUALITY_MAX) {
                                items[i].quality = items[i].incrementQuality()
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < QUALITY_MAX) {
                                items[i].quality = items[i].incrementQuality()
                            }
                        }
                    }
                }
            }

            if (!items[i].isSulfuras) {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {
                if (!items[i].isAgedBrie) {
                    if (!items[i].isBackstage) {
                        if (items[i].quality > QUALITY_MIN) {
                            if (!items[i].isSulfuras) {
                                items[i].quality = items[i].decrementQuality()
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < QUALITY_MAX) {
                        items[i].quality = items[i].incrementQuality()
                    }
                }
            }
        }
    }

}

