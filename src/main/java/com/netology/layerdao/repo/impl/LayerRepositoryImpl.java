package com.netology.layerdao.repo.impl;

import com.netology.layerdao.dao.OrdersDAO;
import com.netology.layerdao.repo.LayerRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class LayerRepositoryImpl implements LayerRepository {
    private final String script;
    private final String PATH = "select.sql";
    @PersistenceContext
    private EntityManager entityManager;

    public LayerRepositoryImpl() {
        this.script = read(PATH);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getProductName(String customerName) {
        Query query = entityManager.createQuery(script);
        query.setParameter("name", customerName);
        List<OrdersDAO> ordersDAOS = (List<OrdersDAO>) query.getResultList();
        List<String> listResult = ordersDAOS.stream()
                .map(OrdersDAO::toString)
                .collect(Collectors.toList());
        return listResult;
    }
}
