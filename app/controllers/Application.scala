package controllers

import play.api._
import play.api.mvc._
import play.api.db._
import play.api.Play.current

class Application extends Controller {

  def index = Action {
     var outString = "Number is "
      val conn = DB.getConnection()
      try {
        val stmt = conn.createStatement
        val rs = stmt.executeQuery("SELECT COUNT(*) as CNT FROM TB_USER")
        while (rs.next()) {
          outString += rs.getString("CNT")
        }
      } finally {
        conn.close()
      }
      Ok(outString)
  }

}
