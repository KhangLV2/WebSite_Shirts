package com.example.demo.repository;

import com.example.demo.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon,Integer> {

    @Query(value = "SELECT COUNT(*) FROM dbo.HoaDon",nativeQuery = true)
    Integer countHoaDon();

}
