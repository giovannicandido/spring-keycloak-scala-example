package info.atende.ssc.database

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import slick.driver.PostgresDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global
/**
 * @author Giovanni Silva 
 *         02/06/15.
 */
@Component
class DataAccess @Autowired()(val db: Database) {
  val cursoTable = TableQuery[CursoTable]

  def getAll() = {
    val retorno = db.run(cursoTable.result)
    retorno
  }

}

class CursoTable(tag: Tag) extends Table[(Int, Boolean, String, Option[Int], Int)](tag, "curso") {
  def id = column[Int]("id", O.PrimaryKey) // This is the primary key column
  def adicionadoViaWeb = column[Boolean]("adicionadoviaweb")
  def nome = column[String]("nome")
  def faculdade_id = column[Option[Int]]("faculdade_id")
  def unidade_id = column[Int]("unidade_id")
  // Every table needs a * projection with the same type as the table's type parameter
  def * = (id, adicionadoViaWeb, nome, faculdade_id, unidade_id)
}