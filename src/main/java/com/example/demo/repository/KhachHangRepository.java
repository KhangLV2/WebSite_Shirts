package com.example.demo.repository;

import com.example.demo.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KhachHangRepository extends JpaRepository<KhachHang,Integer> {

    @Query("select kh from KhachHang kh where kh.taiKhoan=?1 and kh.matKhau=?2")
    KhachHang getByTaiKhoanAndMatKhau(String taiKhoan,String matKhau);

}
