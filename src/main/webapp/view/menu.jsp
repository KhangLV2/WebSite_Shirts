<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>


<!-- Header Section Begin -->
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7">
                    <div class="header__top__left">
                        <p>Free shipping, 30-day return or refund guarantee.</p>
                    </div>
                </div>
                <div class="col-lg-6 col-md-5">
                    <div class="header__top__right">
                        <div class="header__top__links">
                            <a href="/cua-hang/login">Sign in</a>
                            <a href="#">${tenKH}</a>
                        </div>
                        <div class="header__top__hover">
                            <span>Usd <i class="arrow_carrot-down"></i></span>
                            <ul>
                                <li>USD</li>
                                <li>EUR</li>
                                <li>USD</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3">
                <div class="header__logo">
                    <a href="./index.html"><img src="img/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <nav class="header__menu mobile-menu">
                    <ul>
                        <li><a href="./index.html">Home</a></li>
                        <li class="active"><a href="./shop.html">Shop</a></li>
                        <li><a href="#">Pages</a>
                            <ul class="dropdown">
                                <li><a href="./about.html">About Us</a></li>
                                <li><a href="./shop-details.html">Shop Details</a></li>
                                <li><a href="./shopping-cart.html">Shopping Cart</a></li>
                                <li><a href="./checkout.html">Check Out</a></li>
                                <li><a href="./blog-details.html">Blog Details</a></li>
                            </ul>
                        </li>
                        <li><a href="./blog.html">Blog</a></li>
                        <li><a href="./contact.html">Contacts</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3 col-md-3">
                <div class="header__nav__option">
                    <a href="#" class="search-switch"><img src="${pageContext.request.contextPath}/img/icon/search.png" alt=""></a>
                    <a href="#"><img src="${pageContext.request.contextPath}/img/icon/heart.png" alt=""></a>
                    <%--                    <a href="#"><img src="${pageContext.request.contextPath}/img/icon/cart.png" alt="">--%>
                    <%--                        <div class="price">Giỏ hàng(${gioHang})</div>--%>
                    <%--                    </a>--%>
                    <!-- Nút giỏ hàng -->
                    <button class="btn" id="btnGioHang">🛒 Giỏ hàng<span style="color: red">(${slGioHang})</span></button>

                    <!-- Modal giỏ hàng -->
                    <div id="gioHangModal" class="modal-cart">
                        <div class="modal-cart-content">
                            <span class="close">&times;</span>
                            <c:if test="${slGioHang==0}">
                                <h5 style="text-align: left;padding-bottom: 8px">GIỎ HÀNG</h5>
                                <p style="text-align: left">Bạn chưa có sản phẩm nào trong giỏ hàng</p>
                            </c:if>
                            <c:if test="${slGioHang!=0}">
                                <h5 style="text-align: left;padding-bottom: 8px">GIỎ HÀNG</h5>
                                <p style="text-align: left">Bạn đang có ${slGioHang} sản phẩm trong giỏ hàng.</p>
                                <hr>
                                <c:forEach var="gioHang" items="${gioHang}">
                                    <div class="row">
                                        <div class="col-3">
                                            <img src="${gioHang.img}" alt="" style="width: 100%">
                                        </div>
                                        <input type="hidden" name="idHD" value="${gioHang.idHoaDon}">
                                        <div class="col-9" style="text-align: left">
                                            <p style="margin-bottom: 5px">	 ${gioHang.tenSanPham} - ${gioHang.tenMau} - ${gioHang.kichThuoc}</p>
                                            <h5 style="margin-bottom: 6px">${gioHang.donGia}đ X ${gioHang.soLuong}</h5>
                                            <a href="/cua-hang/xoa-product-gio-hang/${gioHang.idHoaDonChiTiet}" class="btn btn-light px-2 py-1" style="font-size: 12px;">Xóa</a>
                                        </div>
                                    </div>
                                    <hr>
                                </c:forEach>
                                <hr style="height: 2px;background-color: black;width: 100%;margin: 20px auto">
                                <h4 style="float: left">Tổng tiền tạm tính: <p style="float: right;padding-left: 116px;padding-top: 4px;">${tongTien}đ</p></h4>
                                <button class="btn btn-dark" style="width: 410px">TIẾN HÀNH ĐẶT HÀNG</button>
                                <a href="/cua-hang/xem-chi-tiet-gio-hang"><p style="padding-right: 124px;padding-top: 15px;">Xem chi tiết giỏ hàng
                                    <i class="bi bi-arrow-right"></i></p>
                                </a>
                            </c:if>

                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="canvas__open"><i class="fa fa-bars"></i></div>
    </div>
</header>
<!-- Header Section End -->

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-option">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb__text">
                    <h4>Shop</h4>
                    <div class="breadcrumb__links">
                        <a href="./index.html">Home</a>
                        <span>Shop</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->