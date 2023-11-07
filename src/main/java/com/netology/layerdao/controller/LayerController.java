package com.netology.layerdao.controller;

import com.netology.layerdao.repo.impl.LayerRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LayerController {
    private final LayerRepositoryImpl repository;

    @GetMapping("/products/fetch-product")
    public ResponseEntity<List<String>> getProductName(@RequestParam(value = "name") String customerName)
    {
        List<String> list = repository.getProductName(customerName);
        return ResponseEntity.ok(list);
    }

}
