package com.example.demo.repository;

import com.example.demo.model.KichThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc,Integer> {

    @Query("select kt from KichThuoc kt where kt.ten=?1")
    KichThuoc findByTen(String tenKichThuoc);

}
