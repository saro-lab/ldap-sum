package me.saro.ldap.jum.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource


@Configuration
class DBConfig {

    @Value("\${datadir}") lateinit var datadir: String

    @Bean
    fun dataSource(): DataSource {
        var conf = HikariDataSource()
        conf.driverClassName = "org.h2.Driver"
        conf.jdbcUrl = "jdbc:h2:$datadir/ldap"
        conf.username = "ldap-user"
        conf.password = "ldap-pass"
        return conf
    }
}



