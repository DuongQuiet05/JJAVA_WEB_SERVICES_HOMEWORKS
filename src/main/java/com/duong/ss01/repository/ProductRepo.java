package com.duong.ss01.repository;


import com.duong.ss01.entity.Product;

import java.util.List;

public interface ProductRepo {
    boolean insert (Product product);
    boolean update (Product product);
    boolean delete (Product product);
    List<Product> getAll ();
}
