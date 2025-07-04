package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.response.GioHangResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
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

    @Autowired
    private KhachHangRepository khachHangRepository;

    private Integer idChiTietSanPham;
    private String tenKhachHang;
    private Integer idKhachHang;

    public TrangChuController() {
        idChiTietSanPham=0;
        idKhachHang = 0;
        tenKhachHang = "";
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
        model.addAttribute("tenKH",tenKhachHang);

        // Hiển thị thông tin sản phẩm lên giỏ hàng
        List<GioHangResponse> gioHangResponses = chiTietHoaDonRepository.getAllGioHang(idKhachHang,1);
        model.addAttribute("gioHang",gioHangResponses);

        int slGioHang = chiTietHoaDonRepository.countChiTietHoaDon(idKhachHang,1);
        model.addAttribute("slGioHang",slGioHang);

        BigDecimal tongTienNew = BigDecimal.ZERO;
        for(GioHangResponse listGH: gioHangResponses){
            tongTienNew = tongTienNew.add(listGH.getDonGia().multiply(BigDecimal.valueOf(listGH.getSoLuong())));

        }

        System.out.println("------------------------Tổng tiền--------------------------------"+tongTienNew);
        model.addAttribute("tongTien",tongTienNew);

        return "shop";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "form";
    }

    @PostMapping("/submit-login")
    public String submitLogin(@RequestParam String taiKhoan,
                              @RequestParam String matKhau,
                              RedirectAttributes redirectAttributes,
                              Model model){
        System.out.println("-----------Tài khoàn---------------"+taiKhoan);
        System.out.println("-----------Mật khẩu---------------"+matKhau);

        KhachHang khachHang = khachHangRepository.getByTaiKhoanAndMatKhau(taiKhoan, matKhau);
        KhachHang findTenKH = khachHangRepository.checkTaiKhoan(taiKhoan);
        tenKhachHang = findTenKH.getHoTen();
        idKhachHang = findTenKH.getId();

        if(khachHang==null) {
            model.addAttribute("mess", "Tài khoản hoặc mật khẩu không chính xác");
            return "form";
        }else {
            return "redirect:/cua-hang";
        }

    }

    @PostMapping("/register")
    public String dangKy(@RequestParam String hoTen,
                         @RequestParam String sdt,
                         @RequestParam String email,
                         @RequestParam String taiKhoan,
                         @RequestParam String matKhau){

        KhachHang checkKH = khachHangRepository.checkTaiKhoan(taiKhoan);

        if (checkKH==null){
            KhachHang khachHang = new KhachHang();
            khachHang.setHoTen(hoTen);
            khachHang.setSdt(sdt);
            khachHang.setEmail(email);
            khachHang.setTaiKhoan(taiKhoan);
            khachHang.setMatKhau(matKhau);
            khachHangRepository.save(khachHang);
            return "redirect:/cua-hang";
        }

        if (checkKH!=null && taiKhoan.equals(checkKH.getTaiKhoan())){
            return "redirect:/cua-hang/login";
        }

        return "redirect:/cua-hang";
    }

    @GetMapping("/detail-product/{idProduct}")
    public String detailProduct(@PathVariable Integer idProduct,
                                Model model){

        int slGioHang = chiTietHoaDonRepository.countChiTietHoaDon(idKhachHang,1);
        model.addAttribute("slGioHang",slGioHang);

        idChiTietSanPham= idProduct;
        Optional<ChiTietSanPham> chiTietSanPham = chiTietSanPhamRepository.findById(idProduct);
        model.addAttribute("chiTietSanPham",chiTietSanPham.get());

        HinhAnh hinhAnh = hinhAnhRepository.findByHinhAnhTheoIdCTSP(idProduct);
        model.addAttribute("hinhAnh",hinhAnh);

        // Hiển thị thông tin sản phẩm lên giỏ hàng
        List<GioHangResponse> gioHangResponses = chiTietHoaDonRepository.getAllGioHang(idKhachHang,1);
        model.addAttribute("gioHang",gioHangResponses);

        BigDecimal tongTienNew = BigDecimal.ZERO;
        for(GioHangResponse listGH: gioHangResponses){
            tongTienNew = tongTienNew.add(listGH.getDonGia().multiply(BigDecimal.valueOf(listGH.getSoLuong())));

        }

        System.out.println("------------------------Tổng tiền--------------------------------"+tongTienNew);
        model.addAttribute("tongTien",tongTienNew);

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
        System.out.println("-------------------id khách hàng-------------------"+idKhachHang);
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

        HoaDon hoaDonKH = hoaDonRepository.findByKHandLoaiHDandTrangThai(idKhachHang,HoaDonRepository.HOA_DON_ON,1);
//        System.out.println("-----------------------Hóa đơn khách hàng---------------------------"+hoaDonKH.getId());
        //Nếu khách hàng chưa có hóa đơn thì tạo hóa đơn mới cho khách hàng
        if (hoaDonKH==null){

            try {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMa("HD" + (count + 001));
                hoaDon.setPhuongThucThanhToan(1);
                KhachHang khachHang = new KhachHang();
                khachHang.setId(idKhachHang);
                hoaDon.setIdKhachHang(khachHang);
                hoaDon.setNgayTao(LocalDateTime.now().withNano(0));
                hoaDon.setTrangThai(1);
                hoaDon.setLoaiHoaDon(1);
                hoaDonRepository.save(hoaDon);

                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                chiTietHoaDon.setIdHoaDon(hoaDon);
                chiTietHoaDon.setIdCTSP(chiTietSanPham);
                chiTietHoaDon.setSoLuong(sl);
                chiTietHoaDon.setDonGia(chiTietSanPham.getGiaBan());
                chiTietHoaDon.setTrangThai(1);
                chiTietHoaDonRepository.save(chiTietHoaDon);
                redirectAttributes.addFlashAttribute("successMessage", "Thêm sản phẩm vào giỏ hàng thành công");
            }catch (Exception e){
                e.printStackTrace();
            }

        }else { //Nếu hóa đơn có rồi thì thêm sản phẩm vào giỏ hàng
            // Đối với sản phẩm có rồi thì cộng dồn số lượng
            boolean flag = false;
            int idHDCT = 0;
            List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonRepository.findByIdHoaDon(hoaDonKH.getId());
            for (ChiTietHoaDon cthd: chiTietHoaDons){
                if (chiTietSanPham.getId()==cthd.getIdCTSP().getId()){
                    idHDCT = cthd.getId();
                    flag = true;
                    break;
                }
            }

            if (flag){
                try {
                    ChiTietHoaDon cthd = chiTietHoaDonRepository.findByIdHDCT(idHDCT);
                    cthd.setSoLuong(cthd.getSoLuong()+sl);
                    cthd.setDonGia(cthd.getDonGia());
                    cthd.setTrangThai(cthd.getTrangThai());
                    chiTietHoaDonRepository.save(cthd);

                    redirectAttributes.addFlashAttribute("successMessage","Thêm sản phẩm vào giỏ hàng thành công");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else { //Check sản phẩm chưa có trong giỏ hàng thì thêm mới

                try {

                    ChiTietHoaDon chiTietHoaDonMoi = new ChiTietHoaDon();
                    chiTietHoaDonMoi.setIdHoaDon(hoaDonKH);
                    chiTietHoaDonMoi.setIdCTSP(chiTietSanPham);
                    chiTietHoaDonMoi.setSoLuong(sl);
                    chiTietHoaDonMoi.setDonGia(chiTietSanPham.getGiaBan());
                    chiTietHoaDonMoi.setTrangThai(1);
                    chiTietHoaDonRepository.save(chiTietHoaDonMoi);
                    redirectAttributes.addFlashAttribute("successMessage","Thêm sản phẩm vào giỏ hàng thành công");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }

        return "redirect:/cua-hang/detail-product/"+ idChiTietSanPham;
    }

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


    @GetMapping("/xem-chi-tiet-gio-hang")
    public String xemChiTietGioHang(){
        // test git trên web xem có đc không
        return "shopping_cart";
    }

    @GetMapping("/xoa-product-gio-hang/{idHDCT}")
    public String xoaProductCard(@PathVariable Integer idHDCT){

        chiTietHoaDonRepository.deleteById(idHDCT);
        return "redirect:/cua-hang/detail-product/"+ idChiTietSanPham;
    }

}
