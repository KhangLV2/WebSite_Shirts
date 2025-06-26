package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "PhuongThucThanhToan")
    private Integer phuongThucThanhToan;

    @ManyToOne
    @JoinColumn(name = "IdKhuyenMai")
    private KhuyenMai idKhuyenMai;

    @ManyToOne
    @JoinColumn(name = "IdNhanVien")
    private NhanVien idNhanVien;

    @ManyToOne
    @JoinColumn(name = "IdKhachHang")
    private KhachHang idKhachHang;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "NgayThanhToan")
    private LocalDateTime ngayThanhToan;

    @Column(name = "TongTien")
    private BigDecimal tongTien;

    @Column(name = "LoaiHoaDon")
    private Integer loaiHoaDon;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Column(name = "NgayCapNhat")
    private LocalDateTime ngayCapNhat;

    @Column(name = "NgayDaXacNhan")
    private LocalDateTime ngayDaXacNhan;

    @Column(name = "NgayChoGiaoHang")
    private LocalDateTime ngayChoGiaoHang;

    @Column(name = "NgayDangGiaoHang")
    private LocalDateTime ngayDaGiaoHang;


}
