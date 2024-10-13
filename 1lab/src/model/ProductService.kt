package com.nikolgortez

import com.nikolgortez.model.Product
import com.nikolgortez.model.ProductCatalogView

object ProductService {

    fun Product.toCatalogView(): ProductCatalogView {
        return ProductCatalogView(
            id = this.getId(),
            name = this.getName(),
            price = this.getPrice(),
            imageUrl = this.getImageUrls().firstOrNull(),
        ).apply {
            copy(this.createdAt, this.updatedAt, this.publishedAt, this.archivedAt)
            update()
        }
    }

}