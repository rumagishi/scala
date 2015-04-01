####西暦からうるう年かどうか判定するプログラム


```
val hoge = new java.util.GregorianCalendar
val year = 1994
hoge.isLeapYear(year)

```
とかすれば簡単らしいですよっと．

ライブラリも要チェックなようですね．



Unit型だと再帰できないものと勘違いしてたけど，ちゃんと型をメソッドの後ろに書けばいいのね．

それから，模範解答の

```
printf("%dはうるう年%s\n", y,
      if (cal.isLeapYear(y)) "です" else "ではありません")
```
な使い方は新鮮だった．
