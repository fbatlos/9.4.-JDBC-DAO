package service


import dao.IBibliotecaDAO
import entity.Libro

import output.Consola


class UserServiceImpl(private val BibliotecaDAO: IBibliotecaDAO, private val consola: Consola) : IUserService {
    override fun create(libro: Libro): Libro? {
        return BibliotecaDAO.create(libro, consola)
    }

    override fun getById(titulo: String): MutableList<String>? {
        return BibliotecaDAO.getById(titulo,consola)
    }

    override fun update(libro: Libro): Libro? {
        return BibliotecaDAO.update(libro,consola)
    }

    override fun delete(titulo: String, aniopubli: String): Boolean? {
        return BibliotecaDAO.delete(titulo,aniopubli,consola)
    }

    override fun getAll(): MutableList<String>? {
        return BibliotecaDAO.getAllLibros(consola)
    }
}