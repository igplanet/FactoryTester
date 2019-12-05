/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caspercoding;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oghomwen.aigbedion
 */
public class ProductVerifierImpl implements ProductVerifier {

    List<Product> products = new ArrayList<>();

    @Override
    public void verify(Product product) throws Exception, Error {
        if (product.getStatus().equalsIgnoreCase("invalid")) {
            throw new Error("invalid product");
        }
        if (products.contains(product)) {
            throw new CustomException();
        } else {
            products.add(product);
        }
    }

    class CustomException extends RuntimeException {

        @Override
        public String getMessage() {
            return "Duplicate Product";
        }

    }
}
