import scala.actors.Actor
import scala.actors.Actor._

class NewActor(n: Int , b: Int, contents: Array[(Int,Int)] ,tuple: (Int, Int)) extends Actor {
  var max = 0
  var max_i = 0
  def act = {
    for(i <- tuple._1 to tuple._2) {
      val binArray = returnBinString(i).split("")
      val ax = for(i <- 0 until n) yield contents(i)._1 * binArray(i).toInt
      val cx = for(i <- 0 until n if(ax.sum <= b)) yield contents(i)._2 * binArray(i).toInt
      val value = cx.sum
      if(max < value) {
        max = value
        max_i = i
      }
    }
    println((max, returnBinString(max_i)))
  }
  def returnBinString(decimal: Int): String = {
    val nextbin = Integer.toBinaryString(decimal)
    "0"*(20-nextbin.length) + nextbin
  }
}


object KnapsackParallel {
  def main(arg: Array[String]): Unit = {
    //initialize
    val b = 55 //storage of the Knapsack
    val contents: Array[(Int,Int)] = 
      Array((3,7), (6,12), (5,9), (4,7), 
        (8,13), (5,8), (3,4), (4,5),
        (3,3), (5,10), (6,7), (4,5),
        (8,6), (7,14), (11,5), (8,9),
        (14,6), (6,12), (12,5), (4,9))
    val n = 20 //the number of contents
    val bin = math.pow(2,n).toInt

    val ma = (new NewActor(n, b, contents, (1,bin/4))).start()
    val mb = (new NewActor(n, b, contents, (bin/4+1,bin/2))).start()
    val mc = (new NewActor(n, b, contents, (bin/2+1,3*bin/4))).start()
    val md = (new NewActor(n, b, contents, (3*bin/4+1,bin))).start()
  }
}


