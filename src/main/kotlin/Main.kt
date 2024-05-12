import dao.ProductDAO
import db_connection.DataSourceFactory
import entity.Product
import output.Consola

fun main() {
    val dataSource = DataSourceFactory.getDS(DataSourceFactory.DataSourceType.HIKARI)

    val consola =Consola()

    val product = Product(2, "Smartphone", 999.99f, "The latest smartphone model", "Apple", "Electronics")

    val productId = ProductDAO(dataSource).createProduct(product,consola)

    println("Product ID: $productId")

}