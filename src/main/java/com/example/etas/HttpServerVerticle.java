package com.example.etas;

import com.example.etas.controllers.BookingController;
import com.example.etas.controllers.CabController;
import com.example.etas.controllers.EmployeeController;
import com.example.etas.repositories.BookingRepository;
import com.example.etas.repositories.CabRepository;
import com.example.etas.repositories.EmployeeRepository;
import com.example.etas.services.BookingService;
import com.example.etas.services.CabService;
import com.example.etas.services.EmployeeService;
import com.typesafe.config.Config;
import io.reactivex.Completable;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.ext.jdbc.JDBCClient;
import io.vertx.reactivex.ext.web.Router;

public class HttpServerVerticle extends AbstractVerticle {

  private final JDBCClient jdbcClient;
  private final Config config;

  public HttpServerVerticle(JDBCClient jdbcClient, Config config) {
    this.jdbcClient = jdbcClient;
    this.config = config;
    System.out.println("HttpServerVerticle constructor started");
  }

  @Override
  public Completable rxStart() {
    System.out.println("Starting HttpServerVerticle");
    Router router = Router.router(vertx);

    EmployeeRepository employeeRepository = new EmployeeRepository(jdbcClient);
    EmployeeService employeeService = new EmployeeService(employeeRepository);
    EmployeeController employeeController = new EmployeeController(employeeService);

    employeeController.mount(router);

    CabRepository cabRepository = new CabRepository(jdbcClient);
    CabService cabService = new CabService(cabRepository);
    CabController cabController = new CabController(cabService);

    cabController.mount(router);

    BookingRepository bookingRepository = new BookingRepository(jdbcClient);
    BookingService bookingService = new BookingService(bookingRepository, cabRepository);
    BookingController bookingController = new BookingController(bookingService);

    bookingController.mount(router);

    System.out.println("Routes mounted");

    return vertx.createHttpServer()
      .requestHandler(router)
      .rxListen(config.getInt("server.port"))
      .doOnSubscribe(disposable -> System.out.println("HTTP server is starting on port " + config.getInt("server.port")))
      .doOnSuccess(server -> System.out.println("HTTP server started on port " + config.getInt("server.port")))
      .doOnError(error -> System.err.println("Failed to start HTTP server: " + error.getMessage()))
      .ignoreElement();
  }

}
