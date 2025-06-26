package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "HinhAnh")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HinhAnh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "IdCTSP")
    private ChiTietSanPham idCTSP;

    @Column(name = "HinhAnh1")
    private String hinhAnh1;

    @Column(name = "HinhAnh2")
    private String hinhAnh2;

    @Column(name = "HinhAnh3")
    private String hinhAnh3;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Column(name = "NgayTao")
    private LocalDateTime ngayTao;

}
