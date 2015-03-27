import math.pow

object Sosuu {

  def furui(list: (List[Int], List[Int]), listlast: Int): List[Int] = {
    val head = list._1.head
    head match {
      case 1 => furui((list._1.tail, List()), listlast)
      case _ =>
        if(pow(listlast,0.5)>head) 
          furui((list._1.filter(_%head!=0), (head :: list._2.reverse).reverse), listlast) 
        else
          list._2 ++ list._1
    }
  }

  def main(args: Array[String]) {
    val list = (1 to 30).toList
    println(furui((list, List()), list.last))
  }

}


