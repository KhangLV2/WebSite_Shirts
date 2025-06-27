package com.example.demo.repository;

import com.example.demo.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon,Integer> {

    final static int HOA_DON_OFF = 0;
    final static int HOA_DON_ON = 1;

    @Query(value = "SELECT COUNT(*) FROM dbo.HoaDon",nativeQuery = true)
    Integer countHoaDon();

    @Query("select hd from HoaDon hd where hd.idKhachHang.id=?1 and hd.loaiHoaDon=?2 and hd.trangThai=?3")
    HoaDon findByKHandLoaiHDandTrangThai(Integer idKH,Integer idLoaiHD,Integer trangThai);

}
