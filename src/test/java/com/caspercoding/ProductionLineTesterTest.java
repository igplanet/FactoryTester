/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caspercoding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oghomwen.aigbedion
 */
public class ProductionLineTesterTest {

    public ProductionLineTesterTest() {
    }
    private final ProductVerifier verifier = new ProductVerifierImpl();
    ProductionLineTester tester = new ProductionLineTester(verifier);

    @Test
    public void testEmptyStream() {
        Stream<Product> productStream = Stream.empty();
        ProductLineTestReport report = tester.test(productStream);
        assertTrue(report.getCheckedExcCnt() == 0 && report.getCorrectCnt() == 0 && report.getOtherExcCnt() == 0 && report.getUncheckedExcCnt() == 0);
    }

    @Test
    public void testFilterAllNullValues() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(4, "valid"));
        productList.add(new Product(5, "valid"));
        productList.add(new Product(6, "valid 4"));
        productList.add(new Product(7, "valid 5"));
        productList.add(new Product(8, "valid 6"));
        productList.add(new Product(9, "valid 6"));
        productList.add(new Product(10, "valid 6"));
        productList.add(new Product(11, "valid 6"));
        productList.add(new Product(12, "valid 6"));
        productList.add(new Product(13, "valid 6"));
        productList.add(null);
        productList.add(null);
        productList.add(null);
        productList.add(null);
        productList.add(new Product(14, "valid 6"));

        Stream<Product> productStream = productList.stream();
        ProductLineTestReport report = tester.test(productStream);
        assertFalse(report.getCheckedExcCnt() == 1 && report.getCorrectCnt() == 0 && report.getOtherExcCnt() == 0 && report.getUncheckedExcCnt() == 0);
    }

    @Test
    public void testFilterInvalidStatus() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(4, "valid"));
        productList.add(new Product(5, "valid"));
        productList.add(new Product(6, "valid 4"));
        productList.add(new Product(7, "valid 5"));
        productList.add(new Product(8, "valid 6"));
        productList.add(new Product(9, "valid 6"));
        productList.add(new Product(10, "valid 6"));
        productList.add(new Product(11, "valid 6"));
        productList.add(new Product(12, "valid 6"));
        productList.add(new Product(13, "valid 6"));
        productList.add(null);
        productList.add(null);
        productList.add(null);
        productList.add(null);
        productList.add(new Product(14, "valid 6"));
        productList.add(new Product(15, "invalid"));
        productList.add(new Product(16, "invalid"));
        productList.add(new Product(17, "invalid"));

        Stream<Product> productStream = productList.stream();
        ProductLineTestReport report = tester.test(productStream);
        assertFalse(report.getCheckedExcCnt() == 1 && report.getCorrectCnt() == 0 && report.getOtherExcCnt() == 0 && report.getUncheckedExcCnt() == 0);
    }

    @Test
    public void testLeaveOnlyUniqueValues() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(4, "valid"));
        productList.add(new Product(5, "valid"));
        productList.add(new Product(6, "valid 4"));
        productList.add(new Product(7, "valid 5"));
        productList.add(new Product(8, "valid 6"));
        productList.add(new Product(9, "valid 6"));
        productList.add(new Product(10, "valid 6"));
        productList.add(new Product(11, "valid 6"));
        productList.add(new Product(12, "valid 6"));
        productList.add(new Product(13, "valid 6"));
        productList.add(null);
        productList.add(null);
        productList.add(null);
        productList.add(null);
        productList.add(new Product(14, "valid 6"));
        productList.add(new Product(14, "valid 6"));
        productList.add(new Product(14, "valid 6"));
        productList.add(new Product(14, "valid 6"));

        Stream<Product> productStream = productList.stream();
        ProductLineTestReport report = tester.test(productStream);
        assertFalse(report.getCheckedExcCnt() == 1 && report.getCorrectCnt() == 0 && report.getOtherExcCnt() == 0 && report.getUncheckedExcCnt() == 0);
    }

    @Test
    public void testIgnoreFirstTenProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(4, "valid"));
        productList.add(new Product(5, "valid"));
        productList.add(new Product(6, "valid 4"));
        productList.add(new Product(7, "valid 5"));
        productList.add(new Product(8, "valid 6"));
        productList.add(new Product(9, "valid 6"));
        productList.add(new Product(10, "valid 6"));
        productList.add(new Product(11, "valid 6"));
        productList.add(new Product(12, "valid 6"));
        productList.add(new Product(13, "valid 6"));

        Stream<Product> productStream = productList.stream();
        ProductLineTestReport report = tester.test(productStream);
        assertTrue(report.getCheckedExcCnt() == 0 && report.getCorrectCnt() == 0 && report.getOtherExcCnt() == 0 && report.getUncheckedExcCnt() == 0);
    }

    public void testProcessOnly20Products() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(4, "valid"));
        productList.add(new Product(5, "valid"));
        productList.add(new Product(6, "valid 4"));
        productList.add(new Product(7, "valid 5"));
        productList.add(new Product(8, "valid 6"));
        productList.add(new Product(9, "valid 6"));
        productList.add(new Product(10, "valid 6"));
        productList.add(new Product(11, "valid 6"));
        productList.add(new Product(12, "valid 6"));
        productList.add(new Product(13, "valid 6"));
        productList.add(null);
        productList.add(null);
        productList.add(null);
        productList.add(null);
        productList.add(new Product(14, "valid 6"));
        productList.add(new Product(15, "valid 6"));
        productList.add(new Product(16, "valid 6"));
        productList.add(new Product(17, "valid 6"));
        productList.add(new Product(18, "valid 6"));
        productList.add(new Product(19, "valid 6"));
        productList.add(new Product(20, "valid 6"));
        productList.add(new Product(21, "valid 6"));
        productList.add(new Product(22, "valid 6"));
        productList.add(new Product(23, "valid 6"));
        productList.add(new Product(24, "valid 6"));
        productList.add(new Product(25, "valid 6"));
        productList.add(new Product(26, "valid 6"));
        productList.add(new Product(27, "valid 6"));
        productList.add(new Product(28, "valid 6"));
        productList.add(new Product(29, "valid 6"));
        productList.add(new Product(30, "valid 6"));
        productList.add(new Product(31, "valid 6"));
        productList.add(new Product(32, "valid 6"));
        productList.add(new Product(33, "valid 6"));
        productList.add(new Product(34, "valid 6"));
        productList.add(new Product(35, "valid 6"));
        productList.add(new Product(36, "valid 6"));
        productList.add(new Product(37, "valid 6"));
        productList.add(new Product(38, "valid 6"));
        productList.add(new Product(39, "valid 6"));
        productList.add(new Product(40, "valid 6"));
        productList.add(new Product(41, "valid 6"));
        productList.add(new Product(42, "valid 6"));
        productList.add(new Product(43, "valid 6"));
        productList.add(new Product(44, "valid 6"));

        Stream<Product> productStream = productList.stream();
        ProductLineTestReport report = tester.test(productStream);
        assertFalse(report.getCheckedExcCnt() == 20 && report.getCorrectCnt() == 0 && report.getOtherExcCnt() == 0 && report.getUncheckedExcCnt() == 0);
    }
}
