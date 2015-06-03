object KnapsackYokubari {
  def main(arg: Array[String]): Unit = {
    //initialize
    val b = 55 //storage of the Knapsack
    val contents: Array[(Double,Double,Int)] = 
      Array((3,7,1), (6,12,2), (5,9,3), (4,7,4), 
        (8,13,5), (5,8,6), (3,4,7), (4,5,8),
        (3,3,9), (5,10,10), (6,7,11), (4,5,12),
        (8,6,13), (7,14,14), (11,5,15), (8,9,16),
        (14,6,17), (6,12,18), (12,5,19), (4,9,20))
    val n = 20 //the number of contents

    val assess = contents.sortBy(a => a._2/a._1).reverse

    println(pack(0,0,List[Int]()).sorted)

    def pack(weight: Double, index: Int, list: List[Int]): List[Int] = {
      val w = weight + assess(index)._1
      if(w < b) {
        if(index==n) {
          return list
        } else {
          pack(w, index+1, assess(index)._3 +: list)
        }
      } else return list
    }
  }
}
