package com.gildedrose

data class Item(var name: String, var sellIn: Int, var quality: Int)

val Item.isAgedBrie: Boolean
    get() = name == "Aged Brie"

val Item.isBackstage: Boolean
    get() = name == "Backstage passes to a TAFKAL80ETC concert"

val Item.isSulfuras: Boolean
    get() = name == "Sulfuras, Hand of Ragnaros"

val Item.isConjured: Boolean
    get() = name == "Conjured Mana Cake"

const val QUALITY_MAX = 50
fun Item.add(unit: Int = 1) =
    (quality + unit).let {
        if (it >= QUALITY_MAX) QUALITY_MAX else it
    }

fun Item.incrementQuality(unit: Int = 1) {
    quality = (quality + unit).let {
        if (it >= QUALITY_MAX) QUALITY_MAX else it
    }
}

const val QUALITY_MIN = 0
fun Item.minus(unit: Int = 1): Int =
    (quality - unit).let {
        if (it <= QUALITY_MIN) QUALITY_MIN else it
    }

fun Item.decrementQuality(unit: Int = 1) {
    quality = (quality - unit).let {
        if (it <= QUALITY_MIN) QUALITY_MIN else it
    }
}

fun Item.decrementSellIn() = sellIn--

fun Item.isSellInExpired() = sellIn < 0
fun Item.expireInTenDaysOrLess() = sellIn < 11
fun Item.expireInFiveDaysOrLess() = sellIn < 6