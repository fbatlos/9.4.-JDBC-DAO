package dao


import entity.Libro

import output.Consola


interface IBibliotecaDAO {
    fun createProduct(libro: Libro, consola: Consola):Libro?

    fun getAllLibros(consola: Consola):MutableList<String>?

}