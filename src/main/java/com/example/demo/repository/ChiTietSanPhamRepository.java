package com.example.demo.repository;

import com.example.demo.model.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham,Integer> {

    @Query("SELECT ctsp from ChiTietSanPham ctsp where ctsp.idSanPham.id =?1 and ctsp.idKichThuoc.id=?2 and ctsp.idMauSac.id=?3")
    ChiTietSanPham findCTSPBySP_MauSac_KichThuoc(Integer idSP,Integer idKichThuoc,Integer idMauSac);


    @Query("select ctsp from ChiTietSanPham ctsp where ctsp.id=?1")
    ChiTietSanPham findByIdCTSP(Integer idCTSP);

}
