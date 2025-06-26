package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "KhachHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "HoTen")
    private String hoTen;

    @Column(name = "GioiTinh")
    private Integer gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "TaiKhoan")
    private String taiKhoan;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "AnhDiaDien")
    private String anhDaiDien;

    @Column(name = "LoaiHoSo")
    private String loaiHoSo;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "NgayCapNhat")
    private LocalDateTime ngayCapNhat;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Column(name = "Email")
    private String email;

}
