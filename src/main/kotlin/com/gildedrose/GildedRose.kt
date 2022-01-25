package com.gildedrose

class GildedRose(var items: List<Item>) {
    fun updateQuality() = items.map { it.update() }.let { items = it }
}


