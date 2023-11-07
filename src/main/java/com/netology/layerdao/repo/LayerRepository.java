package com.netology.layerdao.repo;

import java.util.List;

public interface LayerRepository {
    List<String> getProductName(String customerName);
}
