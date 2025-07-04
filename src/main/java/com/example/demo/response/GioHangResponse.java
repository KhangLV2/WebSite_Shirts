package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GioHangResponse {

    private Integer idHoaDonChiTiet;
    private Integer idHoaDon;
    private String tenMau;
    private String kichThuoc;
    private String tenSanPham;
    private Integer soLuong;
    private BigDecimal donGia;
    private String img;

}
