import java.util.Calendar
import java.text.SimpleDateFormat
import java.io.{FileOutputStream, OutputStreamWriter}

object Kozukai {

  def main(args: Array[String]) {
    val hoge = new Reader()
    val content = hoge.reader("./Kozukaitest.csv")
    val balance = content.head.split(" ")(2).toInt
    println("収支金額を入力してください．\n0 : 現在の残高を表示します．")
    print(">>> ")
    try {
      val cash = scala.io.StdIn.readInt
      if(cash==0) {
        println(balance + "円")
        sys.exit()
      } else {
        val value = calculate(cash, balance)
        val str = value._1 + " " + value._2 
        println(str)
        writer("./Kozukaitest.csv", str)
      } 
    } catch {
      case e: java.lang.NumberFormatException => println("数字を入力してください")
    }
  }

  def calculate(value: Int, balance: Int): (String, String) = {
    val cal = Calendar.getInstance()
    val now = (new SimpleDateFormat).format(cal.getTime())
    val newbalance = balance + value
    if(newbalance<0) {
      println("入力ミスか破産してます")
      sys.exit()
    }
    (now, newbalance.toString)
  }

  def writer(file: String, content: String): Unit = {
    val filestream = new FileOutputStream(file, true)
    val writer = new OutputStreamWriter(filestream)
    writer.write(content + "\n")
    writer.close()
  }
}

class Reader {
  def reader(file: String) = {
    val s = scala.io.Source.fromFile(file)
    var list = List[String]()
    try {
      for (element <- s.getLines) list = element :: list
      } finally {
        s.close
      }
      list
  }
}
