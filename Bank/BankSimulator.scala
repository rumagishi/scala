import scala.collection.mutable._
import scala.util.control.Breaks.{break, breakable}

object BankSimulator {
  def main(args: Array[String]) {
    println("///////Bank Test////")
    val okigin = new Bank
    println(okigin.make("kaito"))
    println(okigin.make("odo"))
    println(okigin.make("mtoshi"))

    okigin.users.foreach(x => println(x))
    println(okigin.users.length)

    println(okigin.exist("kaito"))
    println(okigin.exist("まつのすけ"))
    println(okigin.returnAccount("kaito"))

    println(okigin.delete("kaito"))
    println(okigin.exist("kaito"))
    println(okigin.users.length)

    println("/////////Account Test/////////")
    val odo_account = okigin.returnAccount("odo")
    val odo = odo_account.asInstanceOf[Account]
    println(odo.inquiry())
    println(odo.deposit(100))
    println(odo.inquiry())
    println(odo.draw(50))
    println(odo.inquiry())
  }
}


class Bank {

  val users: ListBuffer[(Account, String)] = ListBuffer.empty[(Account, String)]

  def make(username: String) = {
    users += ((new Account, username))
  }

  def delete(username: String) = {
    breakable {
      for (i <- users.indices) {
        if (users(i)._2 == username) {
          users.remove(i)
          break
        }
      }
    }
  }

  def exist(username: String) = {
    def go(iter: Int): Boolean = {
      if (iter == users.length)
        false
      else if (users(iter)._2 == username)
        true
      else go(iter+1)
    }
    go(0)
  }

  def returnAccount(username: String) = {
    val len = users.length
    def go(iter: Int): Account = {
      if (users(iter)._2 == username)
        users(iter)._1
      else
        go(iter-1)
    }
    if (exist(username))
      go(len-1)
    else
      println("そんなのありません")
  }

}

class Account() {

  var balance = 0

  def inquiry() = {
    balance
  }

  def deposit(value: Int) = {
    balance = balance + value
  }

  def draw(value: Int) = {
    if ((balance - value)<0)
      println("引き出せません")
    balance = balance - value
  }

}
