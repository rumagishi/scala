####転置行列

#####version1 

正方行列ならうまい具合に転置してくれる．

が，正方行列じゃなくなった瞬間
```
java.lang.IndexOutOfBoundsException: 3
```
とか出るので困った困った．

######考察的な

```
    val matrix1 = List(
      List(3,1,4,1)
    , List(2,7,1,8)
    , List(0,5,7,7))
```
を例にとると，iには0から3まで(4つ)の数字が渡されることになって，
それだと，matrix1のありもしない4行目を参照しようとしまい，IndexOutOfBoundsExceptionが発生する．


#####version2

ほとんど答え見てやっちゃいましたが…．


version1は行数数えて，列数を数えるって感じ．

version2は行列の列数を数えて，次に行数を数える…ってかんじ．

要素数をカウントしてから転置するためblah blah Exceptionが出ない．

っていう感じなのかな．
