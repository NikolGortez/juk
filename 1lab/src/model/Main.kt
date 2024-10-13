package com.nikolgortez

import com.nikolgortez.PrinterService.printEqualsResultForProducts
import com.nikolgortez.PrinterService.printProductInfo
import com.nikolgortez.ProductService.toCatalogView
import com.nikolgortez.model.Product

fun main() {
    // full constructor
    val product1 = Product(
        id = 1,
        name = "Продукт полный",
        description = null,
        price = 0.0,
        discountPrice = null,
        stockBalance = 0,
        reserveBalance = 0,
        categoryId = 999,
        imageUrls = listOf()
    )
    // short constructor
    val product2 = Product(
        id = 2,
        name = "Продукт базовый",
        price = 14.0,
        stockBalance = 1000
    ).apply { setReserveBalance(5) }
    // скопировали данные в другую модель через внешнюю статическую функцию (спасибо котлин)
    val productCatalogFrom1 = product1.toCatalogView()

    printProductInfo(product1)
    printProductInfo(product2)
    printEqualsResultForProducts(product1, product2)

}