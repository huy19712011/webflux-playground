package org.example.webfluxplayground.tests.sec08;

import org.example.webfluxplayground.sec08.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class ProductsUploadDownloadTest {

    private static final Logger log = LoggerFactory.getLogger(ProductsUploadDownloadTest.class);
    private final ProductClient productClient = new ProductClient();

    @Test
    public void upload() {
        var flux = Flux.range(1, 10)
                .map(i -> new ProductDto(null, "product-" + i, i))
                .delayElements(Duration.ofSeconds(2));

        //var flux = Flux.range(1, 10)
        //        .map(i -> new ProductDto(null, "product-" + i, i));

        this.productClient.uploadProducts(flux)

                .doOnNext(r -> log.info("received: {}", r))
                //.doOnNext(r -> log.info("received: {}", r))

                .then()
                .as(StepVerifier::create)
                .expectComplete()
                .verify();
    }

}
