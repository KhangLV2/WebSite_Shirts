package com.example.demo.repository;

import com.example.demo.model.ChiTietHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon,Integer> {

    @Query(value = "SELECT COUNT(*) FROM dbo.ChiTietHoaDon",nativeQuery = true)
    Integer countChiTietHoaDon();

    @Query("select cthd from ChiTietHoaDon cthd where cthd.id=?1")
    ChiTietHoaDon findByIdHDCT(Integer id);

}
