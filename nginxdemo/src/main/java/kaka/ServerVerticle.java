package kaka;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class ServerVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        /*HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);
        router.get("/hello").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            HttpServerRequest requeat = routingContext.request();;
            response.end("hello hello world");
        });

        router.post("/hello").handler(BodyHandler.create()).handler(routingContext->{
            JsonObject json = routingContext.getBodyAsJson();
            routingContext.response().end(json.getString("name"));
        });

        server.requestHandler(router).listen(8080,event -> {
            if (event.succeeded()){
                System.out.println("启动在8080端口");
            }
        });*/
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.get("/hello").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            HttpServerRequest request = routingContext.request();
            response.end("hello world");
        });

        router.post("/hello")
                .handler(BodyHandler.create())
                .handler(routingContext -> {
                    JsonObject json = routingContext.getBodyAsJson();
                    routingContext.response().end(json.getString("name"));
                });

        router.errorHandler(500, rc -> {
            rc.failure().printStackTrace();
            rc.response().setStatusCode(500).end("i am wrong :" + rc.failure().getMessage());
        });

        server.requestHandler(router).listen(8080, event -> {
            if (event.succeeded()) {
                System.out.println("启动在8080端口");
            }
        });

    }
}













