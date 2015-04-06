object Transposed {

  def main(args: Array[String]) {
    val matrix = List(
      List(1,2,3)
    , List(4,5,6)
    , List(7,8,9))

    excecute(matrix)

    val matrix1 = List(
      List(3,1,4,1)
    , List(2,7,1,8)
    , List(0,5,7,7))

    excecute(matrix1)

    val matrix2 = List(
      List(3,1)
    , List(2,7)
    , List(0,5))

    excecute(matrix2)
  }

  def excecute(matrix: List[List[Int]]) = {
    val mytranspose = new MyTransposed(matrix)
    //excecution
    output(mytranspose.trans)
    println()
    //answer
    output(matrix.transpose)
  }

  def output(newmatrix: Seq[Seq[Int]]) = {
    for {i <- 0 until newmatrix.length} println(newmatrix(i))
  }

}

class MyTransposed(matrix: List[List[Int]]) {
  def trans() = 
    (0 until matrix(0).length).map(j => (0 until matrix.size).map(i=> matrix(i)(j)))
  
}
