package com.nikolgortez

import com.nikolgortez.model.Product

object PrinterService {

    fun printProductInfo(product: Product) {
        println("-----------------")
        println("Информация по продукту '${product.getName()}':")
        println("Short View: ${product.shortInfo()}")
        println("Full View: ${product.fullInfo()}")
        println("-----------------")
    }

    fun printEqualsResultForProducts(product1: Product, product2: Product) {
        val result = when(product1 == product2) {
            true -> "Да"
            else -> "Нет"
        }
        println("Product 1 (${product1.getName()}) == Product 2 (${product2.getName()})?: $result")
    }

}