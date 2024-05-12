package dao

import entity.Product
import output.Consola
import output.IOutputiinfo
import java.sql.SQLException
import java.util.*
import javax.sql.DataSource


class ProductDAO(private val dataSource: DataSource) : IProductDAO {

    override fun createProduct(product: Product, consola: Consola): Product? {
        val sql = "INSERT INTO products (id, name, price, description ,brand ,category ) VALUES (?, ?, ? , ? , ? ,?)"
        return  try {
            dataSource.connection.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, product.id.toString())
                    stmt.setString(2, product.name)
                    stmt.setString(3, product.price.toString())
                    stmt.setString(4, product.description)
                    stmt.setString(5, product.brand)
                    stmt.setString(6, product.category)
                    val rs = stmt.executeUpdate()
                    if (rs ==1){
                        product
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

}
//