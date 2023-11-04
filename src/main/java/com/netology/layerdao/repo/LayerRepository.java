package com.netology.layerdao.repo;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStreamReader;
@Repository
@Transactional
@AllArgsConstructor
public class LayerRepository {
    private final String PATH = "select.sql";
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Map<String, Object> getProductName(String customerName)
    {
        String sql = read(PATH);
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", customerName);
        return namedParameterJdbcTemplate.queryForMap(sql, params);
    }
}
