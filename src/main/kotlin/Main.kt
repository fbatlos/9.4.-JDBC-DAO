import dao.BibliotecaDAO
import db_connection.DataSourceFactory
import entity.Libro
import output.Consola
import service.UserServiceImpl

fun main(args: Array<String>) {
    val dataSource = DataSourceFactory.getDS(DataSourceFactory.DataSourceType.HIKARI)

    val consola =Consola()

    val bibliotecaDAO = BibliotecaDAO(dataSource)
   // BibliotecaDAO(dataSource).createProduct(Libro("Los campeones","Mario Tamayo",2024),consola)

   // BibliotecaDAO(dataSource).createProduct(Libro("Prog","Jose Pepe",2000),consola)

    val services = UserServiceImpl(bibliotecaDAO,consola)

    services.getAll()?.forEach { consola.showMenssage(it,true)  }

    consola.showMenssage("----------------------------------",true)

    services.getById("Los campeones")?.forEach { consola.showMenssage(it,true) }

    consola.showMenssage("-----------------------------------------" ,true)

    val borrado = services.delete("Los campeones","2024")

    consola.showMenssage("tes",true)



}