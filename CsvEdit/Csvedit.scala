import scala.io.Source
import java.io.PrintWriter
import java.io.File

object Csvedit {

  def main(args: Array[String]) {
    val output = new PrintWriter("editedcsv.txt")
    val s = Source.fromFile("./sample_9_csv.log")
    try {
      for (lines <- s.getLines) {
        output.println(lines)
      }
      } finally {
        s.close
        output.close
      }
  }

}
