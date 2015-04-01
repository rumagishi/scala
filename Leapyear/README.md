####西暦からうるう年かどうか判定するプログラム


```
val hoge = new java.util.GregorianCalendar
val year = 1994
hoge.isLeapYear(year)

```
とかすれば簡単らしいですよっと．

ライブラリも要チェックなようですね．



Unit型だと再帰できないものと勘違いしてたけど，ちゃんと型をメソッドの後ろに書けばいいのね．

それから，[模範解答](http://vipprog.net/wiki/%E7%B7%B4%E7%BF%92%E5%95%8F%E9%A1%8C/%E8%A7%A3%E7%AD%94%E4%BE%8B/Scala.html#xd158eb1)の

```
printf("%dはうるう年%s\n", y,
      if (cal.isLeapYear(y)) "です" else "ではありません")
```
な使い方は新鮮だった．
