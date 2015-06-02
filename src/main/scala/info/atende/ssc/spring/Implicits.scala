package info.atende.ssc.spring

import org.springframework.web.context.request.async.DeferredResult

import scala.concurrent.Future
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * @author Giovanni Silva 
 *         02/06/15.
 */
object Implicits {

  implicit def futureToDeferredResult[T](future: Future[T]) = {
    val deferredResult = new DeferredResult[T]()
    future.onComplete {
      case Success(n) => deferredResult.setResult(n)
      case Failure(e) => deferredResult.setErrorResult(e)
    }
    deferredResult
  }
}
