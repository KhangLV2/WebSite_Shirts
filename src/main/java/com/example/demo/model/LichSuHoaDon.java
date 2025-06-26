package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "LichSuHoaDon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LichSuHoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdHoaDon")
    private HoaDon idHoaDon;

    @ManyToOne
    @JoinColumn(name = "IdNhanVien")
    private NhanVien idNhanVien;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

    @Column(name = "NgayCapNhat")
    private LocalDateTime ngayCapNhat;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Column(name = "Ghichu")
    private String ghiChu;

    @Column(name = "NgayChoXacNhan")
    private LocalDateTime ngayChoXacNhan;

    @Column(name = "NgayChoGiaoHang")
    private LocalDateTime ngayChoGiaoHang;

    @Column(name = "NgayDangGiaoHang")
    private LocalDateTime ngayDangGiaoHang;

    @Column(name = "NgayHoanThanh")
    private LocalDateTime ngayHoanThanh;

}
