package dao


import entity.Product
import output.Consola


interface IProductDAO {
    fun createProduct(product: Product, consola: Consola):Product?

}