package db_connection

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource
import java.sql.DriverManager
import java.sql.Wrapper

object DataSourceFactory {
    enum class DataSourceType {
        HIKARI,
        JDBC
    }



    fun getDS(dataSourceType: DataSourceType): DataSource {
        return when (dataSourceType) {
            DataSourceType.HIKARI -> {
                val config = HikariConfig()
                config.jdbcUrl = "jdbc:h2:file:C:\\Users\\Paco\\IdeaProjects\\9.3.-JDBC/default"
                config.username = "user"
                config.password = "user"
                config.driverClassName = "org.h2.Driver"
                config.maximumPoolSize = 10
                config.isAutoCommit = true
                config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
                HikariDataSource(config)
            }

            DataSourceType.JDBC -> {
                TODO()
            }
        }
    }

}