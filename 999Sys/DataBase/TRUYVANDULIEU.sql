﻿USE ORANGESYS
GO
-- Bảng câu truy vấn dữ liệu

-- Bảng VAITRO
/*
	DELETE FROM VAITRO WHERE (MAVAITRO = '1')

	UPDATE VAITRO SET TENVAITRO =, TRANGTHAI = WHERE (MAVAITRO = '1')

	INSERT INTO VAITRO (MAVAITRO, TENVAITRO, TRANGTHAI) VALUES (,,)

SELECT * FROM   VAITRO

*/

-- Bảng TAIKHOAN
/*
	SELECT * FROM TAIKHOAN

	SELECT MAVAITRO, HOTEN, MATKHAU, NGAYSINH, GIOITINH, EMAIL, SDT, DIACHI, ANHDAIDIEN, NGAYTAO, TRANGTHAI FROM   TAIKHOAN WHERE (MANV = '1')

	DELETE FROM TAIKHOAN WHERE (MANV = '1')

	UPDATE TAIKHOAN SET MAVAITRO =, HOTEN =, MATKHAU =, NGAYSINH =, GIOITINH =, EMAIL =, SDT =, DIACHI =, ANHDAIDIEN =, NGAYTAO =, TRANGTHAI = WHERE (MANV = '1')

	INSERT INTO TAIKHOAN (MANV, MAVAITRO, HOTEN, MATKHAU, NGAYSINH, GIOITINH, EMAIL, SDT, DIACHI, ANHDAIDIEN, NGAYTAO, TRANGTHAI)
	VALUES (,,,,,,,,,,,)
*/

-- Bảng LOAIKHACHHANG
/*
	DELETE FROM LOAIKHACHHANG WHERE (MALOAIKH = '?')

	UPDATE LOAIKHACHHANG SET TENLOAIKH =, TRANGTHAI = WHERE (MALOAIKH = '?')

	INSERT INTO LOAIKHACHHANG (MALOAIKH, TENLOAIKH) VALUES (?,?)

	SELECT  * FROM   LOAIKHACHHANG
*/

-- Bảng KHACHHANG
/*
	DELETE FROM KHACHHANG WHERE (MAKH = '?')

	UPDATE KHACHHANG SET MALOAIKH =, HOTEN =, NGAYSINH =, GIOITINH =, EMAIL =, SDT =, DIACHI =, NGAYTAO =, TRANGTHAI = WHERE (MAKH = '?')

	INSERT INTO KHACHHANG (MAKH, MALOAIKH, HOTEN, NGAYSINH, GIOITINH, EMAIL, SDT, DIACHI, NGAYTAO) VALUES (,,,,,,,,)

	SELECT * FROM   KHACHHANG

	SELECT MALOAIKH, HOTEN, NGAYSINH, GIOITINH, EMAIL, SDT, DIACHI, NGAYTAO, TRANGTHAI FROM   KHACHHANG WHERE (MAKH = '?')
*/

-- Bảng DONVITINH
/*
	UPDATE DONVITINH SET TENDVT =, TRANGTHAI = WHERE MADVT = ?

	INSERT INTO DONVITINH (TENDVT) VALUES ()

	SELECT TENDVT, TRANGTHAI FROM   DONVITINH WHERE (MADVT = ?)

	SELECT * FROM   DONVITINH
*/

-- Bảng MAUSAC
/*
	UPDATE MAUSAC SET TENMAU =, TRANGTHAI = WHERE MAMAU = ?

	INSERT INTO MAUSAC (TENMAU) VALUES ()

	SELECT TENMAU, TRANGTHAI FROM   MAUSAC WHERE (MAMAU = ?)

	SELECT * FROM   MAUSAC
*/

-- Bảng DANHMUC
/*
	UPDATE DANHMUC SET TENDANHMUC =, TRANGTHAI = WHERE MADM = ?

	INSERT INTO DANHMUC (TENDANHMUC) VALUES ()

	SELECT TENDANHMUC, TRANGTHAI FROM   DANHMUC WHERE (MADM = ?)

	SELECT * FROM   DANHMUC

	SELECT TENDANHMUC,TRANGTHAI FROM DANHMUC WHERE MADM = ?
*/

-- Bảng SIZE
/*
	UPDATE SIZE SET TENSIZE =, TRANGTHAI = WHERE MASIZE = ?

	INSERT INTO SIZE (TENSIZE) VALUES ()

	SELECT TENSIZE, TRANGTHAI FROM   SIZE WHERE (MASIZE = ?)

	SELECT * FROM   SIZE
*/

-- Bảng CHATLIEU
/*
	UPDATE CHATLIEU SET TENCHATLIEU =, TRANGTHAI = WHERE MACHATLIEU = ?

	INSERT INTO SIZE (TENCHATLIEU) VALUES ()

	SELECT TENCHATLIEU, TRANGTHAI FROM   CHATLIEU WHERE (MACHATLIEU = ?)

	SELECT * FROM CHATLIEU
*/

-- Bảng SANPHAM
/*
	DELETE FROM SANPHAM WHERE MASP = ?

	UPDATE SANPHAM SET MADM =?, MAVACH =?, ANHSANPHAM =?, GIANHAP =?, GIABAN =?, SOLUONG =?, NGAYNHAP =?, APDUNGKM =?, MADVT =?, MAMAU =?, MASIZE =?, MACHATLIEU =?, TRANGTHAI =? WHERE MASP = ?

	INSERT INTO SANPHAM ( MASP, MADM, MAVACH, ANHSANPHAM, GIANHAP, GIABAN, SOLUONG, NGAYNHAP, APDUNGKM, MADVT, MAMAU, MASIZE, MACHATLIEU) VALUES (,,,,,,,,,,,,)

	SELECT MADM, MAVACH, ANHSANPHAM, GIANHAP, GIABAN, SOLUONG, NGAYNHAP, APDUNGKM, MADVT, MAMAU, MASIZE, MACHATLIEU, TRANGTHAI FROM   SANPHAM WHERE (MASP = ?)

	SELECT * FROM   SANPHAM
*/

-- Bảng KHUYENMAI
/*
	DELETE FROM KHUYENMAI WHERE MAKM = ?

	UPDATE KHUYENMAI SET MASP =, TENKM =, HINHTHUCAD =, GIAMTOIDA =, NGAYBATDAU =, NGAYKETTHUC =, GIATRI =, TRANGTHAI = WHERE MAKM = ?

	INSERT INTO KHUYENMAI (MAKM, MASP, TENKM, HINHTHUCAD, GIAMTOIDA, NGAYBATDAU, NGAYKETTHUC, GIATRI) VALUES (,,,,,,,)

	SELECT MAKM, MASP, TENKM, HINHTHUCAD, GIAMTOIDA, NGAYBATDAU, NGAYKETTHUC, GIATRI TRANGTHAI FROM   KHUYENMAI WHERE (MAKM = ?)

	SELECT KHUYENMAI.* FROM   KHUYENMAI
*/

-- Bảng HOADON
/*
	DELETE FROM HOADON WHERE MAHOADON

	UPDATE HOADON SET MANV =, MAKH =, NGAYMUA =, GIAMGIA =, NGAYGIAOHANG =, TIENSHIP =, THANHTIEN =, TRANGTHAI = WHERE MAHOADON = ?

	INSERT INTO HOADON (MANV, MAKH, NGAYMUA, GIAMGIA, NGAYGIAOHANG, TIENSHIP, THANHTIEN, TRANGTHAI, MAHOADON) VALUES (,,,,,,,,)

	SELECT MANV, MAKH, NGAYMUA, GIAMGIA, NGAYGIAOHANG, TIENSHIP, THANHTIEN, TRANGTHAI FROM   HOADON WHERE (MAHOADON = ?)

	SELECT HOADON.* FROM   HOADON
*/

-- Bảng CTHOADON
/*
	DELETE FROM CT_HOADON WHERE (MAHD = 1)

	UPDATE CT_HOADON SET MASP =, SOLUONG =, GHICHU =, TRANGTHAI = WHERE (MAHD = 1)

	INSERT INTO CT_HOADON (MASP, SOLUONG, GHICHU, MAHD) VALUES (,,,)

	SELECT MASP, SOLUONG, GHICHU, TRANGTHAI FROM   CT_HOADON WHERE (MAHD = 1)

	SELECT CT_HOADON.* FROM   CT_HOADON
*/