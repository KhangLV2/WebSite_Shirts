package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "DiaChi")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiaChi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdHoaDon")
    private HoaDon idHoaDon;

    @Column(name = "DiaChiChiTiet")
    private String diaChiChiTiet;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "SdtNguoiNhan")
    private String sdtNguoiNhan;

    @Column(name = "IdPhuongXa")
    private String idPhuongXa;

    @Column(name = "IdQuanHuyen")
    private String idQuanHuyen;

    @Column(name = "IdTinhThanh")
    private String idTinhThanh;

    @Column(name = "NgayShip")
    private LocalDateTime ngayShip;

    @Column(name = "NgayNhan")
    private LocalDateTime ngayNhan;

    @Column(name = "PhiShip")
    private BigDecimal phiShip;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Column(name = "GhiChu")
    private String ghiChu;

}
