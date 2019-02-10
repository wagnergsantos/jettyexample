package com.ifen.web.dao;


import com.ifen.web.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao {
    User getUser(int id);
}
