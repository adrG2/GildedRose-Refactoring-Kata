package com.gildedrose

data class Item(var name: String, var sellIn: Int, var quality: Int)

val Item.isAgedBrie: Boolean
    get() = name == "Aged Brie"

val Item.isBackstage: Boolean
    get() = name == "Backstage passes to a TAFKAL80ETC concert"

val Item.isSulfuras: Boolean
    get() = name == "Sulfuras, Hand of Ragnaros"

fun Item.incrementQuality() = quality + 1
fun Item.decrementQuality() = quality - 1
fun Item.decrementSellIn() = sellIn - 1

fun Item.isSellInExpired() = sellIn < 0
fun Item.expireInTenDaysOrLess() = sellIn < 11
fun Item.expireInSixDaysOrLess() = sellIn < 6