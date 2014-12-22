import scala.util._

object PassGenerator {
  def main(args: Array[String]) {
    try {
      for ( i <- 1 to 10 ) println(padding(i) + " : " + makePassword(args(0)))
    } catch {
      case ex : java.lang.NumberFormatException => println("the argument only accept a number.")
      case ex : java.lang.ArrayIndexOutOfBoundsException => println("you have to designate a password length that you want to create. for instance,\n% sh PassGenerator.sh 16")
    }
  }
  def padding(i: Int) = {
    val index = i.toString
    " " * (3 - index.length) + i
  } 
  def makePassword(length: String) = {
    val len = length.toInt
    val useableChar = ('!' to 'z').toList
    //new Random(new java.security.SecureRandom()).alphanumeric.take(len).mkString
    new Random(new java.security.SecureRandom()).shuffle(useableChar).take(len).mkString
  }
}

/*
 * Bibliography   : http://qiita.com/suin/items/bfff121c8481990e1507
 *                  http://www.scala-lang.org/old/node/166
 *                  http://d.hatena.ne.jp/sudix/20130619/1371612878
 * */
