import dao.BibliotecaDAO
import db_connection.DataSourceFactory
import entity.Libro
import output.Consola

fun main() {
    val dataSource = DataSourceFactory.getDS(DataSourceFactory.DataSourceType.HIKARI)

    val consola =Consola()

    val libro1 = Libro("Los campeones","Mario Tamayo",2024)


    val libro1Id=BibliotecaDAO(dataSource).createProduct(libro1,consola)

    println(libro1Id)

}