package com.inc.qualle.service.impl;

import com.inc.qualle.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String executeQuery(String query) {
        Query entityManagerQuery = entityManager.createNativeQuery(query);

        List<Object[]> result = entityManagerQuery.getResultList();

        String s =  result.stream().map(Arrays::toString).collect(Collectors.joining(" "));
        return s.replaceAll("[^a-zA-Z0-9]", " ");
    }
}
