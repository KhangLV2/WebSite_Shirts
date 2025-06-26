package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "ChiTietHoaDon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietHoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdHoaDon")
    private HoaDon idHoaDon;

    @ManyToOne
    @JoinColumn(name = "IdCTSP")
    private ChiTietSanPham idCTSP;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Column(name = "HDCT_Old")
    private Integer hdct_old;

}
