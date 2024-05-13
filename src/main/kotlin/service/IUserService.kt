package service

import entity.Libro
import java.util.*

interface IUserService {
    fun create(libro: Libro): Libro?
    fun getById(titulo:String): MutableList<String>?
    fun update(libro: Libro): Libro?
    fun delete(titulo: String ,aniopubli:String):Boolean?
    fun getAll(): MutableList<String>?
}