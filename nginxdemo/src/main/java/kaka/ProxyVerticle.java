package kaka;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.*;

public class ProxyVerticle extends AbstractVerticle {

    @Override
    public void start() {

        Integer port = config().getInteger("port",9090);

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


        }).listen(port, event -> {
            if (event.succeeded()) {
                System.out.println("启动在"+port+"端口");
            }
        });
    }


}
