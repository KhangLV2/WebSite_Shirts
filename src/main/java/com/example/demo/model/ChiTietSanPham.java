package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ChiTietSanPham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac idMauSac;

    @ManyToOne
    @JoinColumn(name = "IdKichThuoc")
    private KichThuoc idKichThuoc;

    @ManyToOne
    @JoinColumn(name = "IdKieuTay")
    private KieuTay idKieuTay;

    @ManyToOne
    @JoinColumn(name = "IdSanPham")
    private SanPham idSanPham;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
