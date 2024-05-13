package dao

import entity.Libro
import output.Consola
import javax.sql.DataSource


class BibliotecaDAO(private val dataSource: DataSource) : IBibliotecaDAO {

    override fun createProduct(libro: Libro, consola: Consola): Libro? {
        val sql = "INSERT INTO biblioteca (TITULO , AUTOR , ANIOPUBLI ) VALUES (?, ?, ?)"
        return  try {
            dataSource.connection.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, libro.titulo)
                    stmt.setString(2, libro.autor)
                    stmt.setString(3, libro.anioPubli.toString())
                    val rs = stmt.executeUpdate()
                    if (rs ==1){
                        libro
                    }else{
                        consola.showMenssage("Algo no fue bien!! (${rs})",true)
                        null
                    }
                }
            }
        }catch (e:Exception){
            consola.showMenssage("Algo no fue bien!! (${e.message})",true)
            null
        }
    }

    override fun getAllLibros(consola: Consola):MutableList<String>? {
        return try {
            val libros = mutableListOf<String>()
            dataSource.connection.use { conn ->
                conn.createStatement().use { stmt ->
                    stmt.executeQuery("SELECT * FROM biblioteca").use { rs ->
                        while (rs.next()) {
                            libros.add(rs.getString("*"))
                        }
                    }
                }
            }
            libros
        } catch (e: Exception) {
            consola.showMenssage("Algo no fue bien!! (${e.message})", true)
            null
        }
    }
}
