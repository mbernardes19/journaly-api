package com.journaly.journaly.repository;

import com.journaly.journaly.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    public List findByUsername(String username) {
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM users WHERE username = ?", User.class);
            query.setParameter(1, username);
            return query.getResultList();
        } catch (Exception err) {
            System.err.println(err);
            return null;
        }
    }
}
