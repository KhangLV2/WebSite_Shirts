
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
    <style>
        .bread {
            padding: 8px 15px;
            margin-bottom: 20px;
            list-style: none;
            display: flex;
            background-color: #f5f5f5;
            border-radius: 4px;
        }

        .bread li a {
            padding-right: 8px;
            text-decoration: none;
            color: rgb(51, 104, 175);
        }

        .payment-methods {
            font-family: sans-serif;
            margin: 20px auto;
        }

        .payment-methods h2 {
            font-size: 24px;
            margin-bottom: 20px;
        }

        .payment-option {
            display: flex;
            align-items: center;
            border: 1px solid #ddd;
            padding: 15px;
            margin-bottom: 10px;
            border-radius: 5px;
            cursor: pointer;
            background-color: white;
            transition: background-color 0.3s;
        }

        .payment-option.selected {
            background-color: #f2f2f2;
        }

        .payment-option input {
            margin-right: 15px;
            transform: scale(1.2);
        }


        .payment-content {
            display: flex;
            align-items: center;
            gap: 15px;
        }

        .payment-content img {
            width: 40px;
            height: 40px;
            object-fit: contain;
        }

        /*  */
        .cart-item {
            display: flex;
            align-items: center;
            justify-content: space-between;
            border-bottom: 1px solid #ddd;
            padding: 15px 0;
        }

        .cart-left {
            display: flex;
            gap: 20px;
        }

        .product-img {
            width: 80px;
            height: 100px;
            border-radius: 8px;
            object-fit: cover;
        }

        .product-info {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }

        .product-name {
            font-weight: bold;
            font-size: 16px;
            margin-bottom: 5px;
        }

        .product-variant {
            color: gray;
            font-size: 14px;
            margin-bottom: 10px;
        }

        .variant-selects {
            display: flex;
            gap: 10px;
            margin-bottom: 10px;
        }

        select {
            padding: 6px 12px;
            border: none;
            border-radius: 20px;
            background-color: #f2f2f2;
            font-size: 14px;
        }

        .delete-btn {
            font-size: 14px;
            color: #666;
            cursor: pointer;
            display: flex;
            align-items: center;
            gap: 4px;
        }

        .cart-right {
            display: flex;
            flex-direction: column;
            align-items: flex-end;
            gap: 10px;
        }

        .quantity-control {
            display: flex;
            align-items: center;
            border: 1px solid #ccc;
            border-radius: 20px;
            padding: 5px 10px;
            gap: 10px;
        }

        .quantity-control button {
            border: none;
            background: none;
            font-size: 16px;
            cursor: pointer;
        }

        .quantity-control span {
            min-width: 20px;
            text-align: center;
            font-size: 14px;
        }

        .price {
            font-weight: bold;
            font-size: 18px;
        }

        .old-price {
            font-size: 14px;
            color: #999;
            text-decoration: line-through;
        }
    </style>
</head>

<body>

<div class="container">
    <form action="">
        <div class="row">
            <div class="col-6">
                <h1>X-MEN STORE</h1>
                <ul class="bread">
                    <li style="padding-right: 10px;"><a href="">Giỏ hàng</a> ></li>
                    <li>
                        Thanh toán
                    </li>
                </ul>
                <h5>Thông tin giao hàng</h5>
                <input type="text" class="form-control" placeholder="Họ và tên" style="margin: 15px 0px;">
                <div class="row" style="margin-bottom: 15px;">
                    <div class="col">
                        <input type="text" class="form-control" placeholder="Email">
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" placeholder="Số điện thoại">
                    </div>
                </div>
                <input type="text" class="form-control" placeholder="Địa chỉ" style="margin-bottom: 15px;">
                <div class="row" style="margin-bottom: 15px;">
                    <div class="col-6">
                        <input type="text" class="form-control" placeholder="Chọn Tỉnh/ thành phố">
                    </div>
                    <div class="col-6">
                        <input type="text" class="form-control" placeholder="Chọn Quận/ Huyện">
                    </div>
                    <div class="col-6" style="margin-top: 15px;">
                        <input type="text" class="form-control" placeholder="Phường/ Xã">
                    </div>
                </div>
                <textarea class="form-control" rows="5" id="comment" name="text" placeholder="Ghi chú"></textarea>
                <div class="payment-methods">
                    <h2>Hình thức thanh toán</h2>

                    <label class="payment-option">
                        <input type="radio" name="payment" />
                        <div class="payment-content">
                            <img src="https://cdn-icons-png.flaticon.com/128/891/891419.png" alt="COD">
                            <div>
                                <strong>Thanh toán khi nhận hàng</strong>
                            </div>
                        </div>
                    </label>

                    <label class="payment-option">
                        <input type="radio" name="payment" />
                        <div class="payment-content">
                            <img src="https://vinadesign.vn/uploads/images/2023/05/vnpay-logo-vinadesign-25-12-57-55.jpg"
                                 alt="VNPAY">
                            <div>
                                <strong>Ví điện tử VNPAY</strong><br>
                                <small>Quét QR để thanh toán</small>
                            </div>
                        </div>
                    </label>
                </div>

            </div>
            <div class="col-6" style="margin-top: 40px;">

                <c:forEach var="gioHang" items="${gioHang}">
                    <div class="cart-item">
                        <div class="cart-left">
                            <img src="https://n7media.coolmate.me/uploads/December2024/24CMCW.SM012_-_Be_Kaki_10.jpg?aio=w-300"
                                 alt="Áo sơ mi" class="product-img">
                            <div class="product-info">
                                <div class="product-name">${gioHang.tenSanPham}</div>
                                <div class="product-variant">${gioHang.tenMau} / ${gioHang.kichThuoc}</div>
<%--                                <div class="variant-selects">--%>
<%--                                    <select>--%>
<%--                                        <option>Be Kaki</option>--%>
<%--                                        <option>Trắng</option>--%>
<%--                                        <option>Đen</option>--%>
<%--                                    </select>--%>
<%--                                    <select>--%>
<%--                                        <option>XL</option>--%>
<%--                                        <option>L</option>--%>
<%--                                        <option>M</option>--%>
<%--                                    </select>--%>
<%--                                </div>--%>
                                <div class="delete-btn">
                                    <i class="bi bi-trash3"></i> Xóa
                                </div>
                            </div>
                        </div>
                        <div class="cart-right">
                            <div class="quantity-control">
<%--                                <button>-</button>--%>
<%--                                <span>1</span>--%>
<%--                                <button>+</button>--%>
                                 <div class="input-group-btn">
                                    <a href="/cua-hang/tru-sl-check-out/${gioHang.idHoaDonChiTiet}" class="btn btn-minus" >
                                       -
                                     </a>
                                  </div>
                                 <input type="text" class="form-control bg-light text-center"name="soLuong" disabled value="${gioHang.soLuong}" style="height: 34px;width: 50px; border: none;text-align: center;color: #111111;font-size: 16px;">
                                <div class="input-group-btn">
                                    <a href="/cua-hang/cong-sl-check-out/${gioHang.idHoaDonChiTiet}" class="btn btn-plus">
                                      +
                                    </a>
                                </div>
                            </div>
                            <div class="price">${gioHang.donGia}</div>
                            <div class="old-price">399.000đ</div>
                        </div>
                    </div>
                </c:forEach>

                <div class="code-sales">
                    <div class="row" style="margin-top: 25px;">
                        <div class="col-10"><input type="text" class="form-control" placeholder="Mã giảm giá"></div>
                        <div class="col-2"><button class="btn btn-primary">Sử dụng</button></div>
                    </div>
                    <hr style="color: #999;margin-top: 25px;">
                </div>
                <p style="margin-top: 25px;">Phí vận chuyển <span style="float: right;">120.000đ</span></p>
                <hr style="color: #999;margin-top: 25px;margin-bottom: 25px;">
                <h4>Tổng cộng <span style="float: right;">420.000đ</span></h4>
                <button class="btn btn-primary"
                        style="float: right; margin-top: 25px;padding: 15px 15px;font-size: 16px;font-weight: bold;">Hoàn
                    tất
                    đơn hàng</button>
            </div>
        </div>
    </form>

</div>

</body>
<script>
    const options = document.querySelectorAll('.payment-option');

    options.forEach(option => {
        const input = option.querySelector('input');

        input.addEventListener('change', () => {
            options.forEach(o => o.classList.remove('selected'));
            option.classList.add('selected');
        });
    });
</script>


</html>