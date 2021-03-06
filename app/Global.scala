import play.api._
import play.api.mvc._
import play.api.mvc.Results._
import scala.concurrent.Future

object Global extends GlobalSettings {
	override def onStart(app: Application) {
		Logger info "Application has started"
	}

	override def onStop(app: Application) {
		Logger info "Application shutdown..."
	}

	override def onError(request: RequestHeader, ex: Throwable) = {
		Future.successful(InternalServerError(
			views.html.errorPage("TimeWasterz- Something Went Wrong...")
		))
	}

	override def onHandlerNotFound(request: RequestHeader) = {
		Future.successful(NotFound(
			views.html.notFoundPage(request.path)
		))
	}
}