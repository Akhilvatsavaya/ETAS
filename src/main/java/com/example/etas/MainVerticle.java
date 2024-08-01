package com.example.etas;

import com.typesafe.config.ConfigFactory;
import io.vertx.reactivex.core.AbstractVerticle;

import com.typesafe.config.Config;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.jdbc.JDBCClient;
import io.vertx.core.Promise;


public class MainVerticle extends AbstractVerticle {

  private JDBCClient jdbcClient;

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    Config config = ConfigFactory.load();

    JsonObject dbConfig = new JsonObject()
      .put("url", config.getString("database.url"))
      .put("driver_class", config.getString("database.driver"))
      .put("user", config.getString("database.user"))
      .put("password", config.getString("database.password"))
      .put("max_pool_size", config.getInt("database.maxPoolSize"));

    jdbcClient = JDBCClient.createShared(vertx, dbConfig);

    vertx.rxDeployVerticle(new HttpServerVerticle(jdbcClient, config))
      .subscribe(
        id -> {
          System.out.println("HttpServer Verticle deployed with id: " + id);
          startPromise.complete();
        }, startPromise::fail
      );

  }

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.rxDeployVerticle(new MainVerticle())
      .subscribe(id -> System.out.println("Main Verticle deployed with id: " + id),
        Throwable::printStackTrace);
  }

}
