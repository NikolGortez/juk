package com.nikolgortez.model

class ProductCatalogView(
    private val id: Int,
    private var name: String,
    private var price: Double,
    private var imageUrl: String?
) : TimeTrackable() {

    fun getId(): Int = id

    fun getName(): String = name

    fun setName(newName: String) {
        if (newName.isBlank()) {
            throw IllegalArgumentException("Name cannot be empty.")
        }
        name = newName
    }

    fun getPrice(): Double = price

    fun setPrice(newPrice: Double) {
        if (newPrice < 0) {
            throw IllegalArgumentException("Price cannot be negative.")
        }
        price = newPrice
    }

    fun getImageUrl(): String? = imageUrl

    fun setImageUrl(newImageUrl: String?) {
        imageUrl = newImageUrl
    }

}