package com.acme.app2.repository;

import com.acme.app2.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HomeRepository extends JpaRepository<Home, UUID> {
}