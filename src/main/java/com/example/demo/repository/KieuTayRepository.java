package com.example.demo.repository;

import com.example.demo.model.KieuTay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KieuTayRepository extends JpaRepository<KieuTay,Integer> {
}
