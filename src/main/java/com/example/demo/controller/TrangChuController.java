package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("cua-hang")
public class TrangChuController {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Autowired
    private HinhAnhRepository hinhAnhRepository;

    @Autowired
    private ChatLieuRepository chatLieuRepository;

    @Autowired
    private KichThuocRepository kichThuocRepository;

    @Autowired
    private KieuTayRepository kieuTayRepository;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepository;

    private Integer idChiTietSanPham;

    public TrangChuController() {
        idChiTietSanPham=0;
    }

    @GetMapping()
    public String index(Model model){

        List<HinhAnh> hinhAnhList = hinhAnhRepository.findAll();
        model.addAttribute("hinhAnhList",hinhAnhList);

        List<ChatLieu> listChatLieu = chatLieuRepository.findAll();
        List<KichThuoc> listKichThuoc = kichThuocRepository.findAll();
        List<KieuTay> listKieuTay = kieuTayRepository.findAll();
        List<MauSac> listMauSac = mauSacRepository.findAll();
        model.addAttribute("listChatLieu",listChatLieu);
        model.addAttribute("listKichThuoc",listKichThuoc);
        model.addAttribute("listKieuTay",listKieuTay);
        model.addAttribute("listMauSac",listMauSac);

        return "shop";
    }

    @GetMapping("/detail-product/{idProduct}")
    public String detailProduct(@PathVariable Integer idProduct,
                                Model model){

        int gioHang = chiTietHoaDonRepository.countChiTietHoaDon();
        model.addAttribute("gioHang",gioHang);

        idChiTietSanPham= idProduct;
        Optional<ChiTietSanPham> chiTietSanPham = chiTietSanPhamRepository.findById(idProduct);
        model.addAttribute("chiTietSanPham",chiTietSanPham.get());

        List<KichThuoc> listKichThuoc = kichThuocRepository.findAll();
        List<MauSac> listMauSac = mauSacRepository.findAll();
        model.addAttribute("listKichThuoc",listKichThuoc);
        model.addAttribute("listMauSac",listMauSac);
        return "shop_details";
    }

    @PostMapping("/them-vao-gio")
    public String themSanPhamVaoGioHang(@RequestParam("kichThuoc") String kichThuoc,
                                        @RequestParam("mauSac") String mauSac,
                                        @RequestParam("idSanPham") Integer idSanPham,
                                        @RequestParam("soLuong") String soLuong,
                                        RedirectAttributes redirectAttributes){
          int sl = Integer.parseInt(soLuong);

        System.out.println("----------------SL----------"+sl);

        System.out.println("----------------------------"+kichThuoc);
        System.out.println("----------------------------"+mauSac);
        System.out.println("----------------------------"+idSanPham);
        int count = hoaDonRepository.countHoaDon();
        //Lấy ra sản phẩm chi tiết

        KichThuoc kichThuoc1 = kichThuocRepository.findByTen(kichThuoc);
        MauSac mauSac1 = mauSacRepository.findByTen(mauSac);

        //Lỗi chưa lấy được từng kích thước và màu của sản phẩm chi tiết
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findCTSPBySP_MauSac_KichThuoc(idSanPham, kichThuoc1.getId(), mauSac1.getId());

        List<ChiTietHoaDon> listChiTietHoaDon = chiTietHoaDonRepository.findAll();
        List<ChiTietSanPham> listCTSP = chiTietSanPhamRepository.findAll();


        boolean flag = false;
        int idHDCT = 0;

        for (ChiTietHoaDon cthd: listChiTietHoaDon){
            if (chiTietSanPham.getId()==cthd.getIdCTSP().getId()){
                idHDCT = cthd.getId();
                flag = true;
                break;
            }
        }

        if (flag){
            ChiTietHoaDon cthd = chiTietHoaDonRepository.findByIdHDCT(idHDCT);
            cthd.setSoLuong(cthd.getSoLuong()+sl);
            cthd.setDonGia(cthd.getDonGia());
            cthd.setTrangThai(cthd.getTrangThai());
            chiTietHoaDonRepository.save(cthd);


//    - Đối với bán hàng online thì khi nào thành toán mới trừ sl trong kho còn thêm vào giỏ hàng thì số lượng vẫn giữ nguyên

//            int slMoi = 0;
//            for (ChiTietSanPham ctsp: listCTSP){
//                if (cthd.getIdCTSP().getId()==ctsp.getId()){
//                    slMoi = ctsp.getSoLuong()-sl;
//                }
//            }
//            ChiTietSanPham chiTietSanPham1 = chiTietSanPhamRepository.findByIdCTSP(idChiTietSanPham);
//            chiTietSanPham1.setSoLuong(slMoi);
//            chiTietSanPham1.setMoTa(chiTietSanPham1.getMoTa());
//            chiTietSanPham1.setTrangThai(chiTietSanPham1.getTrangThai());
//            chiTietSanPhamRepository.save(chiTietSanPham1);

            redirectAttributes.addFlashAttribute("successMessage","Thêm sản phẩm vào giỏ hàng thành công");

        }else {


            try {
                //Tạo hóa đơn
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMa("HD" + (count + 001));
                hoaDon.setPhuongThucThanhToan(1);
                KhachHang khachHang = new KhachHang();
                khachHang.setId(1);
                hoaDon.setIdKhachHang(khachHang);
                hoaDon.setNgayTao(LocalDateTime.now().withNano(0));
                hoaDon.setTrangThai(1);
                hoaDonRepository.save(hoaDon);

                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                chiTietHoaDon.setIdHoaDon(hoaDon);
                chiTietHoaDon.setIdCTSP(chiTietSanPham);
                chiTietHoaDon.setSoLuong(sl);
                chiTietHoaDon.setDonGia(chiTietSanPham.getGiaBan());
                chiTietHoaDon.setTrangThai(1);
                chiTietHoaDonRepository.save(chiTietHoaDon);
                redirectAttributes.addFlashAttribute("successMessage", "Thêm sản phẩm vào giỏ hàng thành công");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "redirect:/cua-hang/detail-product/"+ idChiTietSanPham;
    }


    @GetMapping("/xem-chi-tiet-gio-hang")
    public String xemChiTietGioHang(){
        return "shopping_cart";
    }

}
