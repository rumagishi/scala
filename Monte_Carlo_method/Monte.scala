import scala.util.Random
import math.pow

def MonteCarlo(N: Int, p: Int): Double = N match {
  case 100000 => 4.0*1.0*1.0*p/N
  case _ => { 
    val x = new Random().nextDouble()
    val y = new Random().nextDouble()
    if (pow(x,2)+pow(y,2)<=1.0) MonteCarlo(N+1, p+1) else MonteCarlo(N+1, p)
  }
}

