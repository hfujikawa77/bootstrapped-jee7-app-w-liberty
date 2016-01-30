##はじめに
WAS Liberty ProfileとMavenを使った自動自動式Java EE7アプリケーションの雛形です。  
必要ソフトウェアの収集と利用可能化、アプリケーション始動を1つのコマンドで完了します。  
書いたプログラムをすぐ動かせるので技術検証や学習用途に最適です。  

##前提
JDK(1.8 or Later)がインストールされていること。

##使い方

下記コマンドを実行します。

```cmd
mvnw package liberty:run-server
```

フォアグラウンドでLiberty サーバが起動します。

```cmd
[INFO] [AUDIT   ] CWWKT0016I: Web アプリケーションが使用可能です (default_host): http://localhost:8080/
[INFO] [AUDIT   ] CWWKZ0001I: アプリケーション bootstrapped-jee7-app-w-liberty が 31.252 秒で開始しました。
```

新しいコマンドプロンプトを起動して下記のコマンドを実行します。

```cmd
curl http://localhost:8080/rest/book/myTitle/myAuthor -X PUT
```

下記のようにDBに登録済データが表示されたら成功です。

```cmd
[{"bookId":1,"author":"myAuthor","title":"myTitle"}]
```

##アプリケーション概要
本の情報を登録、照会できるRest API。本の情報はDBに保持します。  
登録：  http://localhost:8080/rest/book/{title}/{author} -X PUT  
照会：  http://localhost:8080/rest/book/  

##実行構成
cURL -> JAX-RS -> CDI -> JPA -> DB(組み込みDerby)

##カスタマイズ
フィーチャー追加はserver.xmlの下記箇所に追記します。

```xml
  <!-- アプリケーションが利用するJava EEフィーチャを指定。JAX-RS, JPA, CDIを指定 -->
  <featureManager>
    <!-- <feature>javaee-7.0</feature> -->
    <!-- <feature>localConnector-1.0</feature> -->
    <feature>jaxrs-2.0</feature>
    <feature>jpa-2.1</feature>
    <feature>cdi-1.2</feature>
  </featureManager>
```
