package com.github.kongchen.swagger.docgen.reader;

import io.swagger.models.Swagger;
import org.apache.maven.plugin.logging.SystemStreamLog;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.testng.AssertJUnit.assertTrue;

public class HttpExchangeSpringMvcApiReaderTest {

    @Test
    public void given_class_and_method_annotated_with_httpexchange_then_concatenate_values() throws Exception {
        SpringMvcApiReader reader = new SpringMvcApiReader(new Swagger(), new SystemStreamLog());
        Swagger swagger = reader.read(Collections.singleton(ExampleController.class));
        boolean hasPath = swagger.getPaths().containsKey("/some/path/search");
        assertTrue(hasPath);
    }

    @HttpExchange("/some/path")
    private static class ExampleController {

        @GetExchange("/search")
        public String search() {
            return null;
        }
    }
}
