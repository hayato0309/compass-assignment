# ベースイメージを指定
FROM openjdk:11-slim

# 作業ディレクトリを作成
WORKDIR /app

# MySQL Connector/Jをコピー
COPY /app/lib/mysql-connector-java-8.0.12.jar /app/lib/

# ソースコードをコピー
COPY /app/src/ /app/src/

# # コンパイルしてJARファイルを作成
RUN javac -cp .:/app/lib/mysql-connector-java-8.0.12.jar /app/src/DatabaseConnector.java && \
    jar cf my-java-app.jar -C /app/src/ .

# # アプリケーションを実行
CMD ["java", "-cp", ".:/app/lib/mysql-connector-java-8.0.12.jar:my-java-app.jar", "Main"]
