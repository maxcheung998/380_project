package com.ouhk.webforum.dao;

import com.ouhk.webforum.model.ForumUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumUserRepository extends JpaRepository<ForumUser, String> {
}