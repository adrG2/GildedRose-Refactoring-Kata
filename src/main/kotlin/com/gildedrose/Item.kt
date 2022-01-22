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