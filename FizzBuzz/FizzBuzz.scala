def cycle(seq: Seq[String]) = 
  Stream.continually(seq).flatten

val fizz = cycle(List("", "", "Fizz"))
val buzz = cycle(List("", "", "", "", "Buzz"))


def reply(numbers: List[Int]) {
  val zippedTuple = (numbers, fizz, buzz).zipped.toList
  for (z <- zippedTuple) {
    if(z._2.length==0 && z._3.length==0) println(z._1)
    else println(z._2 + z._3)
  }
}

def call(n: Int) {
  reply((1 to n).toList)
}
