import java.util.Scanner

object Leapyear {
  def judge(): Unit = {
    println("西暦を入力してください")
    val input = new Scanner(System.in).nextLine()
    try {
      val year = input.toInt
      if ((year%4==0 && year%100!=0) || (year%100==0 && year%400==0)) 
        println("うるう年です．\n") 
      else 
        println("うるう年じゃないです．\n")
      } catch {
        case e : java.lang.NumberFormatException => 
          println("数字を入力してください．\n")
      }
      judge()
  }

  def main(args: Array[String]) {
    judge()
  }
}
