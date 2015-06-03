object Knapsack3 {
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
    var max = 0
    var max_i = 0

    for(i <- 1 to 1048576) {
      val binArray = returnBinString(i).split("")
      val ax = for(i <- 0 until n) yield contents(i)._1 * binArray(i).toInt
      val cx = for(i <- 0 until n if(ax.sum <= b)) yield contents(i)._2 * binArray(i).toInt
      val value = cx.sum
      if(max < value) {
        max = value
        max_i = i
      }
    }
    println(returnBinString(max_i) + ", " + max)

    //convert a decimal number to a binary number
    def returnBinString(decimal: Int): String = {
      val nextbin = Integer.toBinaryString(decimal)
      "0"*(n-nextbin.length) + nextbin
    }
  }
}
