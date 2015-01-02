import scala.math._
object Newton {
  val epsilon = 0.000001
  def newton(a:Double, f:Double=>Double, f_dash:Double=>Double):Double = {
    val b = a - f(a) / f_dash(a)
    if (abs(b-a) < epsilon) b else newton(b,f,f_dash)
  }
  def main(args: Array[String]) {
    val x = newton(8.0, x=>x+tan(x), x=>1+(1/pow(cos(x),2)))
    println("x is " + x)
    println("the minimum value is " + -x*sin(x))
  }
}
