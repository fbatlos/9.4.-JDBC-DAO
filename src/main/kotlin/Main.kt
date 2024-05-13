import dao.BibliotecaDAO
import db_connection.DataSourceFactory
import entity.Libro
import output.Consola

fun main() {
    val dataSource = DataSourceFactory.getDS(DataSourceFactory.DataSourceType.HIKARI)

    val consola =Consola()

    BibliotecaDAO(dataSource).createProduct(Libro("Los campeones","Mario Tamayo",2024),consola)

    BibliotecaDAO(dataSource).createProduct(Libro("Prog","Jose Pepe",2000),consola)

    BibliotecaDAO(dataSource).getAllLibros(consola)?.forEach { println(it) }



}