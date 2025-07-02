<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Đăng nhập / Đăng ký - Shop Áo Sơ Mi Nam</title>
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;600&display=swap" rel="stylesheet">

    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- SweetAlert2 CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">

    <!-- SweetAlert2 JS -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: 'Quicksand', sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background-color: white;
            width: 600px;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
            transition: all 0.3s ease;
        }

        .brand-header {
            text-align: center;
            margin-bottom: 25px;
        }

        .brand-header h2 {
            font-weight: 600;
            color: #222;
        }

        .brand-header p {
            font-size: 14px;
            color: #777;
        }

        .tab-switch {
            display: flex;
            justify-content: space-around;
            margin: 25px 0;
            border-bottom: 1px solid #ddd;
        }

        .tab-switch button {
            background: none;
            border: none;
            font-size: 16px;
            font-weight: 600;
            padding: 10px 0;
            color: #777;
            cursor: pointer;
            border-bottom: 2px solid transparent;
        }

        .tab-switch button.active {
            color: #000;
            border-color: #222;
        }

        .form-content {
            display: none;
            animation: fadeIn 0.3s ease;
        }

        .form-content.active {
            display: block;
        }

        .input-group {
            position: relative;
            margin-bottom: 20px;
        }

        .input-group input {
            width: 100%;
            padding: 12px 40px 12px 15px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
            background-color: #f9f9f9;
        }

        .toggle-password {
            position: absolute;
            right: 12px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
            font-size: 14px;
            color: #555;
        }

        .submit-btn {
            width: 100%;
            background-color: #222;
            color: white;
            padding: 12px;
            font-weight: bold;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 15px;
            transition: 0.3s;
        }

        .submit-btn:hover {
            background-color: #444;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(10px);
            }

            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
</head>

<body>

<div class="form-container">
    <div class="brand-header">
        <h2>MENSHIRT STORE</h2>
        <p>Phong cách lịch lãm cho quý ông</p>
    </div>

    <div class="tab-switch">
        <button class="tab-link active" onclick="switchTab('login')">Đăng nhập</button>
        <button class="tab-link" onclick="switchTab('register')">Đăng ký</button>
    </div>

    <!-- Form Đăng nhập -->
    <form id="form" action="/cua-hang/submit-login" method="post">
        <p class="text-danger">
             ${mess}
        </p>
        <div id="login" class="form-content active">
            <div class="input-group">
                <input type="text" placeholder="Tên đăng nhập"  name="taiKhoan" required>
            </div>
            <div class="input-group">
                <input type="password" placeholder="Mật khẩu" class="password"  name="matKhau" required>
                <span class="toggle-password" onclick="togglePassword(this)">👁️</span>
            </div>
            <button type="submit" class="submit-btn">Đăng nhập</button>
        </div>
    </form>

    <!-- Form Đăng ký -->
    <form action="/cua-hang/register" method="post">
        <div id="register" class="form-content">
            <div class="input-group">
                <input type="text" placeholder="Họ tên" required name="hoTen">
            </div>
            <div class="input-group">
                <input type="text" placeholder="Số điện thoại" required name="sdt">
            </div>
            <div class="input-group">
                <input type="email" placeholder="Email" required name="email">
            </div>
            <div class="input-group">
                <input type="text" placeholder="Tên đăng nhập"  name="taiKhoan" required>
            </div>
            <div class="input-group">
                <input type="password" placeholder="Mật khẩu" class="password" name="matKhau" required>
                <span class="toggle-password" onclick="togglePassword(this)">👁️</span>
            </div>
            <button type="submit" class="submit-btn">Đăng ký</button>
        </div>
    </form>

</div>

<script>
    function switchTab(tabId) {
        document.querySelectorAll('.form-content').forEach(f => f.classList.remove('active'));
        document.getElementById(tabId).classList.add('active');

        document.querySelectorAll('.tab-link').forEach(btn => btn.classList.remove('active'));
        event.target.classList.add('active');
    }

    function togglePassword(el) {
        const input = el.previousElementSibling;
        if (input.type === "password") {
            input.type = "text";
            el.textContent = "🙈";
        } else {
            input.type = "password";
            el.textContent = "👁️";
        }
    }


</script>

</body>

</html>