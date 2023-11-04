package com.netology.layerdao.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.netology.layerdao.repo.LayerRepository;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class LayerController {
    private final LayerRepository repository;

    @GetMapping("/products/fetch-product")
    public ResponseEntity<Map<String, Object>> getProductName(@RequestParam(value = "name") String customerName)
    {
        Map<String, Object> map = repository.getProductName(customerName);
        return ResponseEntity.ok(map);
    }

}
