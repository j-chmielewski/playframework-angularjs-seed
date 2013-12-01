package controllers

import play.api._
import play.api.mvc._
import play.api.libs.functional.syntax._
import play.api.libs.json.Json

object Api extends Controller {

  // get current time
  def time = Action {
    request =>
      Ok(Json.toJson(Map("time" -> scala.compat.Platform.currentTime)))
  }

  // simple echo service
  def echo = Action {
    request =>
      request.body.asJson.map {
        json =>
          (json \ "echo").asOpt[String].map {
            echo =>
              Ok(Json.toJson(Map("echo" -> echo)))
          }.getOrElse {
            BadRequest("Missing parameter [echo]")
          }
      }.getOrElse {
        BadRequest("Expecting Json data")
      }

  }

}
