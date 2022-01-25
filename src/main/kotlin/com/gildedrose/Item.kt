package com.gildedrose

data class Item(var name: String, var sellIn: Int, var quality: Int)

//TODO In case there are a lot of items it might be necessary to make this mutable by performance
fun Item.update(): Item = (sellIn - 1).let { currentSellIn ->
    when (name) {
        "Aged Brie" -> copy(
            sellIn = currentSellIn,
            quality = if (currentSellIn < 0) qualityIncreaseIn(2) else qualityIncreaseIn(1)
        )
        "Backstage passes to a TAFKAL80ETC concert" -> when {
            currentSellIn < 0 -> copy(sellIn = currentSellIn, quality = 0)
            currentSellIn in 0..5 -> copy(sellIn = currentSellIn, quality = qualityIncreaseIn(3))
            currentSellIn in 6..10 -> copy(sellIn = currentSellIn, quality = qualityIncreaseIn(2))
            else -> copy(sellIn = currentSellIn, quality = qualityIncreaseIn(1))
        }
        "Sulfuras, Hand of Ragnaros" -> this
        "Conjured Mana Cake" -> copy(
            sellIn = currentSellIn,
            quality = if (currentSellIn < 0) qualityDecreaseIn(4) else qualityDecreaseIn(2)
        )
        else -> copy(
            sellIn = currentSellIn,
            quality = if (currentSellIn < 0) qualityDecreaseIn(2) else qualityDecreaseIn(1)
        )
    }
}

private const val QUALITY_MAX = 50
private fun Item.qualityIncreaseIn(unit: Int) = (quality + unit).let {
    if (it >= QUALITY_MAX) QUALITY_MAX else it
}

private const val QUALITY_MIN = 0
private fun Item.qualityDecreaseIn(unit: Int) = (quality - unit).let {
    if (it <= QUALITY_MIN) QUALITY_MIN else it
}