package dao


import entity.Libro

import output.Consola


interface IBibliotecaDAO {
    fun create(libro: Libro, consola: Consola):Libro?

    fun getAllLibros(consola: Consola):MutableList<String>?

    fun delete(titulo: String, aniopubli: String,consola: Consola):Boolean?

    fun getById(autor: String, consola: Consola): MutableList<String>?

    fun update(libro: Libro, consola: Consola): Libro?
}