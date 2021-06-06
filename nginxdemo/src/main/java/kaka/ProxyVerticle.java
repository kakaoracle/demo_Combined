package kaka;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.*;

public class ProxyVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        /*HttpServerOptions serverOptions = new HttpServerOptions();
        serverOptions.setTcpKeepAlive(true);
        HttpServer server = vertx.createHttpServer();

        HttpClientOptions clientOptions = new HttpClientOptions();
//        clientOptions.setDefaultHost("www.baidu.com");
//        clientOptions.setDefaultPort(443);
        clientOptions.setDefaultPort(8080);
        clientOptions.setDefaultHost("127.0.0.1");
        clientOptions.setSsl(true);
        clientOptions.setKeepAlive(true);

        HttpClient client = vertx.createHttpClient(clientOptions);

        server.requestHandler(req ->{
            HttpServerResponse resp = req.response();
            resp.setChunked(true);
            req.pause();

            client.request(req.method(),req.uri(), ar ->{
               if (ar.succeeded()) {
                   HttpClientRequest req2 = ar.result();

                   req.headers().forEach(entry ->{
                       if (entry.getKey().equals("Content-Type")) {
                           req2.putHeader(entry.getKey(),entry.getValue());
                       }
                   });
                    req2.send(req).onSuccess(resp2 -> {
                        resp.setStatusCode(resp2.statusCode());
                        resp2.handler(resp::write);
                        resp.send(resp2);
                    }).onFailure(err -> {
                        resp.setStatusCode(500).end(err.getMessage());
                    });
               } else {
                   resp.setStatusCode(500).end(ar.cause().getMessage());
               }
            });
        }).listen(9090,event -> {
            if (event.succeeded()) {
                System.out.println("启动在9090端口");
            }
        });*/
        HttpServerOptions serverOptions = new HttpServerOptions();
        serverOptions.setTcpKeepAlive(true);
        HttpServer server = vertx.createHttpServer(serverOptions);

        HttpClientOptions clientOptions = new HttpClientOptions();
        // 本地代理
        clientOptions.setDefaultHost("127.0.0.1");
        clientOptions.setDefaultPort(8080);
        // 代理百度之类
//        clientOptions.setDefaultHost("www.baidu.com");
//        clientOptions.setDefaultPort(443);
//        clientOptions.setSsl(true);
//        clientOptions.setKeepAlive(true);

        HttpClient client = vertx.createHttpClient(clientOptions);

        server.requestHandler(req -> {
            HttpServerResponse resp = req.response();
            req.pause();

            client.request(req.method(), req.uri(), ar -> {
                if (ar.succeeded()) {
                    HttpClientRequest req2 = ar.result();
                    req2.headers().setAll(req.headers());

                    req2.send(req).onSuccess(resp2 -> {
                        resp.setStatusCode(resp2.statusCode());
                        resp.headers().setAll(resp2.headers());
                        resp.send(resp2);
                    }).onFailure(err -> {
                        err.printStackTrace();
                        resp.setStatusCode(500).end(err.getMessage());
                    });

                } else {
                    ar.cause().printStackTrace();
                    resp.setStatusCode(500).end(ar.cause().getMessage());
                }
            });


        }).listen(9090, event -> {
            if (event.succeeded()) {
                System.out.println("启动在9090端口");
            }
        });
    }


}
