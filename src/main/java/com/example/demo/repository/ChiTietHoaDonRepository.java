package com.example.demo.repository;

import com.example.demo.model.ChiTietHoaDon;
import com.example.demo.response.GioHangResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon,Integer> {

    @Query(value = "SELECT COUNT(*) FROM dbo.ChiTietHoaDon",nativeQuery = true)
    Integer countChiTietHoaDon();

    @Query("select cthd from ChiTietHoaDon cthd where cthd.id=?1")
    ChiTietHoaDon findByIdHDCT(Integer id);

    @Query("SELECT new com.example.demo.response.GioHangResponse( " +
            "cthd.id, ctsp.idMauSac.ten, ctsp.idKichThuoc.ten, ctsp.idSanPham.ten, " +
            "cthd.soLuong, cthd.donGia, img.hinhAnh1) " +
            "FROM ChiTietHoaDon cthd " +
            "JOIN ChiTietSanPham ctsp ON cthd.idCTSP.id = ctsp.id " +
            "JOIN HinhAnh img ON ctsp.id = img.idCTSP.id " +
            "WHERE cthd.trangThai = ?1")
    List<GioHangResponse> getAllGioHang(Integer trangThai);


}
