package info.atende.ssc.rest

import scala.concurrent.Future

import info.atende.ssc.database.DataAccess
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{RequestMapping, RestController}
import org.springframework.web.context.request.async.DeferredResult

import scala.util.Success
import scala.util.Failure
import scala.concurrent.ExecutionContext.Implicits.global
import info.atende.ssc.spring.Implicits._

/**
 * @author Giovanni Silva 
 *         02/06/15.
 */
@RestController
class ScalaRest @Autowired()(val dataAccess: DataAccess) {

  @RequestMapping(Array("/scala-hello"))
  def helloFromScala: DeferredResult[String] = {
    val backendResult = dataAccess.getAll().map(o => o.map(_._3).mkString(","))
    backendResult.onComplete {
        case Success(n) => {
          println(n)

        }
        case Failure(e) => println(e.getMessage)
    }
    backendResult
  }
}
