package info.atende.ssc.database

import javax.sql.DataSource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import slick.jdbc.JdbcBackend.Database
/**
 * @author Giovanni Silva 
 *         02/06/15.
 */
@Component
class DBProducer @Autowired()(val dataSource: DataSource) {
  @Bean
  def createDatabase: Database = Database.forDataSource(dataSource)
}
