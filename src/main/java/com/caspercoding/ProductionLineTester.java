/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caspercoding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author oghomwen.aigbedion
 */
public class ProductionLineTester {

    private final ProductVerifier verifier;

    ProductionLineTester(ProductVerifier verifier) {
        this.verifier = verifier;
    }

    ProductLineTestReport test(Stream<Product> products) {
        ProductLineTestReport report = new ProductLineTestReport(0, 0, 0, 0);

        if (products != null) {
            List<Product> productList = products.collect(Collectors.toList());
            if (productList.size() < 1) {
                return report;
            } else {
                products = productList.stream();
            }
        } else {
            return report;
        }

        products.map(p -> p).filter(Objects::nonNull).filter(p -> p.getStatus() != null && !p.getStatus().equalsIgnoreCase("invalid")).distinct().skip(10).limit(20).forEach(p -> {
            try {
                verifier.verify(p);
                report.setCorrectCnt(report.getCorrectCnt() + 1);
            } catch (Exception e) {
                if (e instanceof RuntimeException) {
                    report.setUncheckedExcCnt(report.getUncheckedExcCnt() + 1);
                } else {
                    report.setCheckedExcCnt(report.getCheckedExcCnt() + 1);
                }
            } catch (Error e) {
                report.setOtherExcCnt(report.getOtherExcCnt() + 1);
            }
        });
        return report;
    }
}
