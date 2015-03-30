import scala.io.Source
import sys.exit

object Shiritori {

  def reader(file: String) = {
    val s = Source.fromFile(file)
    var list = List[String]()
    try {
      for (element <- s.getLines) list = element :: list
      } finally {
        s.close
      }
      list
  }

  def main(args: Array[String]) {
    val dictionary = reader("./dictionary.txt")
    myturn((List[String](), dictionary))
  }

  def myturn(dict: (List[String], List[String])) {

    if (dict._2 == null) {
      println("貴様の負けだ")
      exit()
    }

    val wordword = new java.util.Scanner(System.in)
    println("文字列をくれたまえ" + "\n")
    val word = wordword.nextLine()
    //println(word + "\n")

    if(dict._1.nonEmpty) {
      val computersaid = dict._1.last
      val alphabet = computersaid.splitAt(computersaid.length-1)._2
      if (!(word startsWith alphabet)) {
        println("しりをとっておらんぞ" + "\n")
        myturn(dict)
      }
      if (( for(s <- dict._2; if(s startsWith alphabet)) yield s ).isEmpty) {
        println("貴様の負けだ")
        exit()
      }
    }

    if(dict._1.contains(word)) { 
      println("それは先ほど使ったが？" + "\n")
      myturn(dict)
    }

    //辞書に文字列があるかをチェック
    if (dict._2.contains(word)) {
      val dict_ = dict._2.partition(s => s==word)
      val newList = (dict_._1.head :: dict._1.reverse).reverse
      val newtuple = (newList, dict_._2)
      computersturn(newtuple)
    } else { 
      println("予の辞書に" + word + "という言葉はない" + "\n") 
      myturn(dict)
    }

  }

  def computersturn(dict: (List[String], List[String])) {

    //辞書が空なら終了
    if (dict._2 == null) {
      println("予の負けだ")
      exit()
    }

    val usersaid = dict._1.last
    val alphabet = usersaid.splitAt(usersaid.length-1)._2

    if (( for(s <- dict._2; if(s startsWith alphabet)) yield s ).isEmpty) {
      println("予の負けだ")
      exit()
    }

    val computersay = ( 
      for(w <- dict._2;
           if(w startsWith alphabet) 
             ) yield w).head

    println(computersay + "\n")
    val dict_ = dict._2.partition(s => s==computersay)
    val newList = (dict_._1.head :: dict._1.reverse).reverse
    val newtuple = (newList, dict_._2)
    myturn(newtuple)
  }

}
