package dao

import entity.Libro
import output.Consola
import javax.sql.DataSource


class BibliotecaDAO(private val dataSource: DataSource) : IBibliotecaDAO {

    override fun create(libro: Libro, consola: Consola): Libro? {
        val sql = "INSERT INTO BIBLIOTECA (TITULO , AUTOR , ANIOPUBLI ) VALUES (?, ?, ?)"
        return try {
            dataSource.connection.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, libro.titulo)
                    stmt.setString(2, libro.autor)
                    stmt.setString(3, libro.anioPubli.toString())
                    val rs = stmt.executeUpdate()
                    if (rs == 1) {
                        libro
                    } else {
                        consola.showMenssage("Algo no fue bien!! (${rs})", true)
                        null
                    }
                }
            }
        } catch (e: Exception) {
            consola.showMenssage("Algo no fue bien!! (${e.message})", true)
            null
        }
    }

    override fun getAllLibros(consola: Consola): MutableList<String>? {
        return try {

            val titulo = mutableListOf<String>()
            dataSource.connection.use { conn ->
                conn.createStatement().use { stmt ->
                    stmt.executeQuery("SELECT TITULO FROM biblioteca").use { rs ->
                        while (rs.next()) {
                            titulo.add(rs.getString("TITULO"))
                        }
                    }
                }
            }
            titulo
        } catch (e: Exception) {
            consola.showMenssage("Algo no fue bien!! (${e.message})", true)
            null
        }
    }

    override fun delete(titulo: String, aniopubli: String, consola: Consola): Boolean? {
        val sql = "DELETE FROM BIBLIOTECA WHERE TITULO = (?) AND ANIOPUBLI = (?)"
        return try {
            dataSource.connection.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, titulo)
                    stmt.setString(2,aniopubli)
                    val rs = stmt.executeUpdate()
                    if (rs == 1) {
                        true
                    } else {
                        consola.showMenssage("Algo no fue bien!! (${rs})", true)
                        null
                    }
                }
            }
        } catch (e: Exception) {
            consola.showMenssage("Algo no fue bien!! (${e.message})", true)
            null
        }
    }

    override fun getById(autor: String, consola: Consola): MutableList<String>? {
        val sql = "SELECT TITULO from BIBLIOTECA where AUTOR like %(?)%"
        val libros= mutableListOf<String>()
        return try {
            dataSource.connection.use { conn ->
                conn.createStatement().use { stmt ->
                    stmt.executeQuery(sql).use { rs ->
                        while (rs.next()) {
                            libros.add(rs.getString("TITULO"))
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

    override fun update(libro: Libro, consola: Consola): Libro? {
        TODO("Not yet implemented")
    }

}


