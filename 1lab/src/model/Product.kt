package com.nikolgortez.model

class Product(
    private val id: Int,
    private var name: String,
    private var description: String?,
    private var price: Double,
    private var discountPrice: Double?,
    private var stockBalance: Int,
    private var reserveBalance: Int,
    private var categoryId: Int?,
    private var imageUrls: List<String>
) : TimeTrackable()  {
    private var availableBalance = stockBalance - reserveBalance

    constructor(id: Int, name: String, price: Double, stockBalance: Int): this(id, name, null, price, null, stockBalance, 0, null, listOf())


    fun getId(): Int = id

    fun getName(): String = name

    fun setName(newName: String) {
        if (newName.isBlank()) {
            throw IllegalArgumentException("Name cannot be empty.")
        }
        name = newName
    }

    fun getDescription(): String? = description

    fun setDescription(newDescription: String) {
        if (newDescription.isBlank()) {
            throw IllegalArgumentException("Name cannot be empty.")
        }
        description = newDescription
    }

    fun getPrice(): Double = price

    fun setPrice(newPrice: Double) {
        if (newPrice < 0) {
            throw IllegalArgumentException("Price cannot be negative.")
        }
        price = newPrice
    }

    fun getDiscountPrice(): Double? = discountPrice

    fun setDiscountPrice(newDiscountPrice: Double) {
        if (newDiscountPrice < 0) {
            throw IllegalArgumentException("Discount Price cannot be negative.")
        }
        discountPrice = newDiscountPrice
    }

    fun getStockBalance(): Int = stockBalance

    fun setStockBalance(newStockBalance: Int) {
        if (newStockBalance < 0) {
            throw IllegalArgumentException("StockBalance cannot be negative.")
        }
        stockBalance = newStockBalance
    }

    fun getReserveBalance(): Int = reserveBalance

    fun setReserveBalance(newReserveBalance: Int) {
        if (newReserveBalance < 0) {
            throw IllegalArgumentException("StockBalance cannot be negative.")
        }
        reserveBalance = newReserveBalance
        update()
        calculateAvailableBalance()
    }

    fun getCategoryId(): Int? = categoryId

    fun setCategoryId(newCategoryId: Int?) {
        categoryId = newCategoryId
    }

    fun getImageUrls(): List<String> = imageUrls

    fun setImageUrls(newImageUrls: List<String>) {
        imageUrls = newImageUrls
    }

    fun getAvailableBalance(): Int = availableBalance

    fun calculateAvailableBalance() {
        val available = stockBalance - reserveBalance
        availableBalance = when (available < 0) {
            true -> 0
            else -> available
        }
        update()
    }


    fun shortInfo(): String {
        return "Product(name='$name', price=$price, availableBalance=$availableBalance)"
    }

    fun fullInfo(): String {
        return "Product(" +
                "id=$id, name='$name', description='$description', " +
                "price=$price, discountPrice=$discountPrice, " +
                "stockBalance=$stockBalance, reserveBalance=$reserveBalance, " +
                "categoryId=$categoryId, imageUrls=$imageUrls, " +
                "createdAt=$createdAt, updatedAt=$updatedAt, publishedAt=$publishedAt, archivedAt=$archivedAt)"
    }

    // Собсна сравнение (без учета дат, потому что они дополнение для продукта, а не сам продукт. Мы сами задаем правила определения сравнения)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Product) return false

        if (this.hashCode() != other.hashCode()) return false

        return id == other.id && name == other.name && description == other.description
                && price == other.price && discountPrice == other.discountPrice
                && stockBalance == other.stockBalance && reserveBalance == other.reserveBalance
                && categoryId == other.categoryId && imageUrls == other.imageUrls
    }

    // Нужно для сравнения (ну и снова без дат, иначе хэшкоды будут разные)
    override fun hashCode(): Int {
        return listOf(id, name, description, price, stockBalance, reserveBalance, categoryId, imageUrls).hashCode()
    }
}