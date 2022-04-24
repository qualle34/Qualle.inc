package com.inc.qualle.repository;

import com.inc.qualle.service.ProductService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private ProductService productService;

    @Test
    @Disabled
    public void test() {
        assertEquals(productService.getAllSimple().size(), 36);
    }
}
