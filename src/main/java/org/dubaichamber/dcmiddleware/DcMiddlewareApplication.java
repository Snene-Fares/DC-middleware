package org.dubaichamber.dcmiddleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DcMiddlewareApplication {

    public static void main(String[] args) {
        SpringApplication.run(DcMiddlewareApplication.class, args);
    }

}
