package com.example.demo.repository;

import com.example.demo.model.ChiTietHoaDon;
import com.example.demo.response.GioHangResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon,Integer> {

    @Query(value = "SELECT COUNT(*) FROM ChiTietHoaDon hdct where hdct.idHoaDon.idKhachHang.id=?1 and hdct.trangThai=?2")
    Integer countChiTietHoaDon(Integer idKH,Integer trangThai);

    @Query("select cthd from ChiTietHoaDon cthd where cthd.id=?1")
    ChiTietHoaDon findByIdHDCT(Integer id);

    @Query("SELECT new com.example.demo.response.GioHangResponse( " +
            "cthd.id,cthd.idHoaDon.id ,ctsp.idMauSac.ten, ctsp.idKichThuoc.ten, ctsp.idSanPham.ten, " +
            "cthd.soLuong, cthd.donGia, img.hinhAnh1) " +
            "FROM ChiTietHoaDon cthd " +
            "JOIN ChiTietSanPham ctsp ON cthd.idCTSP.id = ctsp.id " +
            "JOIN HinhAnh img ON ctsp.id = img.idCTSP.id " +
            "JOIN HoaDon hd on hd.id = cthd.idHoaDon.id " +
            "WHERE hd.idKhachHang.id =?1 and hd.trangThai = ?2")
    List<GioHangResponse> getAllGioHang(Integer idKH ,Integer trangThai);


    @Query("select cthd from ChiTietHoaDon cthd where cthd.idHoaDon.id =?1")
    List<ChiTietHoaDon> findByIdHoaDon(Integer idHoaDon);

    @Query("select SUM(hdct.donGia*hdct.soLuong) from ChiTietHoaDon hdct where hdct.idHoaDon=?1")
    BigDecimal tongTienTrongGioHang(Integer idHoaDon);

}
