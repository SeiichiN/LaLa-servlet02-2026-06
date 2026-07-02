<style>
.my-text {
background-color: #f5f5f5;
padding: 10px;
margin-left: 30%;
}
</style>

<div class="my-text">
数当てゲームというアプリを考えています。
コンピュータに1〜99のランダムな数字を決めさせ、
ユーザーがその数を当てるというゲームアプリです。
ユーザーの送信した数に対して、コンピュータは、
"大きすぎます"、"小さすぎます"、"アタリです" という返答をします。
コンピュータは、自分の数字をセッションスコープに保存しているので、
ユーザーは"アタリ"まで数を送信できます。

さた、このゲームに Javaビーンズを導入しようと考えました。
次の2つのクラスが思い浮かびました。

(1) データの入れ物としてのクラス

```
public class Kazu {
  private int com;
  private int user;
  private String msg;
  public Kasu() {}
  
  ...(以下、com、user、msg のゲッター、セッター)
}
```

(2) 機能つきのクラス

```
public class Kazu {
  private int com;
  private int user;
  private String msg;
  public Kasu() {}

  public void setNumber() {
    this.number = (int)(Math.random() * 99) + 1;
  }
  public void judge(int user) {
    // com と user を比較して、msg を設定する。
  } 
  
  ...(以下、com、user、msg のゲッター、セッター)
}
```

僕の考えでは、ビーンズとしては、(1) のフィールド主体の設計にしておいて、
com の値を決める、userの値と比べて判定文字列を作成する、という処理は、
ロジッククラス、もしくはサービスクラスを作成し、それに担当させたほうが
MVCモデルっぽいのではと思うのです。
自分の考えに何か不充分な点があるでしょうか？
</div>

---

結論から言うと、**あなたの考え方のほうが、現在のMVCの考え方には近い**です。

実は、このような設計の違いは、Javaの歴史とも関係があります。

---

## JavaBeansとは本来何か

JavaBeansは本来、

* フィールドを持つ
* getter/setterを持つ
* 引数なしコンストラクタを持つ
* シリアライズ可能（場合による）

という「部品」の規約です。

つまり、

```java
public class Kazu {
    private int com;
    private int user;
    private String msg;

    public Kazu() {}

    public int getCom() { ... }
    public void setCom(int com) { ... }

    ...
}
```

このような「データの入れ物」であることが基本です。

---

## (2)でも間違いではない

一方で、

```java
public void judge(int user) {
    ...
}
```

のようなメソッドを持つBeanも昔からたくさんあります。

例えば

```java
public class CalculatorBean {

    private int a;
    private int b;

    public int add() {
        return a + b;
    }
}
```

このようなBeanは珍しくありません。

ですから、

> JavaBeansにはロジックを書いてはいけない

という決まりはありません。

---

## しかしMVCで考えると…

MVCでは責務を分離します。

### Model

データ

```
Kazu
```

* com
* user
* msg

だけ持つ。

---

### Service

ゲームのルール

```
KazuService
```

例えば

```java
public class KazuService {

    public void init(Kazu kazu) {
        kazu.setCom((int)(Math.random() * 99) + 1);
    }

    public void judge(Kazu kazu) {

        if (kazu.getUser() > kazu.getCom()) {
            kazu.setMsg("大きすぎます");
        } else if (...) {
            ...
        }
    }
}
```

ゲームのルールは全部ここ。

---

### Servlet

サーブレットは

```
入力を受け取る
        ↓
Serviceを呼ぶ
        ↓
JSPへ渡す
```

だけ。

例えば

```java
Kazu kazu = (Kazu)session.getAttribute("kazu");

kazu.setUser(Integer.parseInt(request.getParameter("num")));

service.judge(kazu);

request.getRequestDispatcher(...);
```

こうすると役割が非常に明確になります。

---

## この設計の利点

例えば将来、

* 当たりを1〜999に変更
* ヒント機能追加
* 残り回数追加
* 難易度追加

となっても、

**Serviceだけ**直せばよくなります。

Beanは全く変更不要です。

---

## Beanにjudge()を書いた場合

Beanが

```java
public void judge()
```

を持つと、

Beanは

* データ
* ゲームルール

両方を知ることになります。

つまり責務が2つになります。

小さいプログラムでは問題ありませんが、

ゲームが大きくなるほど

```
Bean = データ + ロジック
```

になり肥大化しやすくなります。

---

## ただし「オブジェクト指向」では別の考え方もある

実は純粋なオブジェクト指向では、

```java
kazu.judge();
```

のほうが自然だ、と考える人もいます。

理由は

> データを持っているオブジェクトが、そのデータを操作する責任も持つ

という考え方だからです。

例えば

```java
class BankAccount {

    private int balance;

    public void deposit(int money) {
        balance += money;
    }

    public void withdraw(int money) {
        ...
    }
}
```

残高を操作する処理を外部の`BankAccountService`に書くより、`BankAccount`自身が持つほうが自然です。

このため、ドメインモデルを重視する設計では、データとそれに密接に関わる振る舞いを同じクラスに持たせることがあります。

---

## 今回の数当てゲームなら

今回の規模で、教材としてサーブレット・JSPやMVCを学ぶのであれば、

```
Kazu      ← Bean（データだけ）

KazuService ← 判定ロジック

KazuServlet ← 制御
```

という構成はとても分かりやすく、MVCの責務分離も意識できています。

一方で、「Beanには絶対にロジックを書いてはいけない」というわけではありません。ロジックがそのデータと密接に結び付いた振る舞いであれば、Bean（あるいはドメインオブジェクト）に持たせる設計も十分にあり得ます。

したがって、あなたが「まずはBeanをデータの入れ物にして、ゲームのルールはサービスクラスにまとめるほうがMVCらしい」と考えたのは、サーブレット/JSPの学習段階として非常に良い設計方針だと思います。将来的にオブジェクト指向設計を深く学ぶと、「データと振る舞いを一緒に持たせる」という別の設計思想にも出会うはずです。そのときに両者の違いを比較すると、設計の幅がさらに広がるでしょう。



<!-- 修正時刻: Fri 2026/07/03 06:24:29 -->
