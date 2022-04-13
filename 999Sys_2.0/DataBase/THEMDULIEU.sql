USE [ORANGESYS]
GO
SET IDENTITY_INSERT [dbo].[VAITRO] ON 
GO
INSERT [dbo].[VAITRO] ([MAVAITRO], [TENVAITRO], [TRANGTHAI]) VALUES (101, N'Trưởng Phòng', 1)
GO
INSERT [dbo].[VAITRO] ([MAVAITRO], [TENVAITRO], [TRANGTHAI]) VALUES (102, N'Nhân viên thu ngân', 1)
GO
SET IDENTITY_INSERT [dbo].[VAITRO] OFF
GO
INSERT [dbo].[TAIKHOAN] ([MANV], [MAVAITRO], [HOTEN], [MATKHAU], [NGAYSINH], [GIOITINH], [EMAIL], [SDT], [DIACHI], [ANHDAIDIEN], [NGAYTAO], [TRANGTHAI]) VALUES (N'admin', 101, N'Nguyễn Văn A', N'1234', CAST(N'2002-07-07' AS Date), 1, N'vontph18623@fpt.edu.vn', N'0335138102', N'Hà Nội', N'mama.jpg', CAST(N'2022-01-01' AS Date), 1)
GO
INSERT [dbo].[TAIKHOAN] ([MANV], [MAVAITRO], [HOTEN], [MATKHAU], [NGAYSINH], [GIOITINH], [EMAIL], [SDT], [DIACHI], [ANHDAIDIEN], [NGAYTAO], [TRANGTHAI]) VALUES (N'user01', 102, N'Nguyễn Văn B', N'123', CAST(N'2002-07-07' AS Date), 1, N'thanhmxph18759@fpt.edu.vn', N'0335138102', N'Hà Nội', N'mama.jpg', CAST(N'2022-01-01' AS Date), 1)
GO
INSERT [dbo].[TAIKHOAN] ([MANV], [MAVAITRO], [HOTEN], [MATKHAU], [NGAYSINH], [GIOITINH], [EMAIL], [SDT], [DIACHI], [ANHDAIDIEN], [NGAYTAO], [TRANGTHAI]) VALUES (N'user02', 102, N'Nguyễn Văn C', N'123', CAST(N'2002-07-07' AS Date), 1, N'thanhmxph18759@fpt.edu.vn', N'0335138102', N'Hà Nội', N'joker.png', CAST(N'2022-01-01' AS Date), 1)
GO
INSERT [dbo].[TTGIAOCA] ([MATT], [TENTT]) VALUES (0, N'Thất bại')
GO
INSERT [dbo].[TTGIAOCA] ([MATT], [TENTT]) VALUES (1, N'Thành công')
GO
INSERT [dbo].[TTGIAOCA] ([MATT], [TENTT]) VALUES (2, N'Chờ giao ca')
GO
INSERT [dbo].[TTGIAOCA] ([MATT], [TENTT]) VALUES (3, N'Chờ nhận ca')
GO
SET IDENTITY_INSERT [dbo].[GIAOCA] ON 
GO
INSERT [dbo].[GIAOCA] ([MAGIAOCA], [MANVGIAOCA], [MANVNHANCA], [GIONHANCA], [GIOGIAOCA], [TIENCOSO], [TIENPHATSINH], [DOANHTHUCA], [TONGTIEN], [GHICHUGIAO], [GHICHUNHAN], [MATT]) VALUES (1, N'user01', N'admin', CAST(N'2022-04-06T16:27:00.680' AS DateTime), NULL, 1000000.0000, 0.0000, 0.0000, 1000000.0000, NULL, NULL, 1)
GO
INSERT [dbo].[GIAOCA] ([MAGIAOCA], [MANVGIAOCA], [MANVNHANCA], [GIONHANCA], [GIOGIAOCA], [TIENCOSO], [TIENPHATSINH], [DOANHTHUCA], [TONGTIEN], [GHICHUGIAO], [GHICHUNHAN], [MATT]) VALUES (18, N'admin', N'user01', CAST(N'2022-04-07T21:42:54.150' AS DateTime), CAST(N'2022-04-07T11:21:00.000' AS DateTime), 1000000.0000, 100000.0000, 8802129.0000, 9902129.0000, N'ảo ma vcl', N'bug', 1)
GO
INSERT [dbo].[GIAOCA] ([MAGIAOCA], [MANVGIAOCA], [MANVNHANCA], [GIONHANCA], [GIOGIAOCA], [TIENCOSO], [TIENPHATSINH], [DOANHTHUCA], [TONGTIEN], [GHICHUGIAO], [GHICHUNHAN], [MATT]) VALUES (19, N'user01', NULL, CAST(N'2022-04-07T23:23:16.117' AS DateTime), NULL, 1000000.0000, 0.0000, 0.0000, 1000000.0000, NULL, NULL, 0)
GO
INSERT [dbo].[GIAOCA] ([MAGIAOCA], [MANVGIAOCA], [MANVNHANCA], [GIONHANCA], [GIOGIAOCA], [TIENCOSO], [TIENPHATSINH], [DOANHTHUCA], [TONGTIEN], [GHICHUGIAO], [GHICHUNHAN], [MATT]) VALUES (20, N'user02', NULL, CAST(N'2022-04-07T23:32:10.173' AS DateTime), NULL, 1000000.0000, 0.0000, 0.0000, 1000000.0000, NULL, NULL, 0)
GO
INSERT [dbo].[GIAOCA] ([MAGIAOCA], [MANVGIAOCA], [MANVNHANCA], [GIONHANCA], [GIOGIAOCA], [TIENCOSO], [TIENPHATSINH], [DOANHTHUCA], [TONGTIEN], [GHICHUGIAO], [GHICHUNHAN], [MATT]) VALUES (21, N'admin', N'user01', CAST(N'2022-04-07T23:52:25.953' AS DateTime), CAST(N'2022-04-10T10:41:00.000' AS DateTime), 1000000.0000, 5000000.0000, 0.0000, 6000000.0000, N'oke', N'oke', 1)
GO
INSERT [dbo].[GIAOCA] ([MAGIAOCA], [MANVGIAOCA], [MANVNHANCA], [GIONHANCA], [GIOGIAOCA], [TIENCOSO], [TIENPHATSINH], [DOANHTHUCA], [TONGTIEN], [GHICHUGIAO], [GHICHUNHAN], [MATT]) VALUES (22, N'user01', N'admin', CAST(N'2022-04-10T10:52:19.867' AS DateTime), CAST(N'2022-04-10T11:09:00.000' AS DateTime), 6000000.0000, -1000000.0000, 0.0000, 5000000.0000, N'123', N'oke', 1)
GO
INSERT [dbo].[GIAOCA] ([MAGIAOCA], [MANVGIAOCA], [MANVNHANCA], [GIONHANCA], [GIOGIAOCA], [TIENCOSO], [TIENPHATSINH], [DOANHTHUCA], [TONGTIEN], [GHICHUGIAO], [GHICHUNHAN], [MATT]) VALUES (23, N'admin', N'user01', CAST(N'2022-04-10T10:56:43.987' AS DateTime), CAST(N'2022-04-10T02:23:00.000' AS DateTime), 1000000.0000, 5555555.0000, 0.0000, 6555555.0000, N'oke', N'ke', 1)
GO
INSERT [dbo].[GIAOCA] ([MAGIAOCA], [MANVGIAOCA], [MANVNHANCA], [GIONHANCA], [GIOGIAOCA], [TIENCOSO], [TIENPHATSINH], [DOANHTHUCA], [TONGTIEN], [GHICHUGIAO], [GHICHUNHAN], [MATT]) VALUES (24, N'admin', N'user01', CAST(N'2022-04-10T11:13:29.023' AS DateTime), NULL, 5000000.0000, 0.0000, 0.0000, 1000000.0000, NULL, N'', 1)
GO
INSERT [dbo].[GIAOCA] ([MAGIAOCA], [MANVGIAOCA], [MANVNHANCA], [GIONHANCA], [GIOGIAOCA], [TIENCOSO], [TIENPHATSINH], [DOANHTHUCA], [TONGTIEN], [GHICHUGIAO], [GHICHUNHAN], [MATT]) VALUES (25, N'user01', N'admin', CAST(N'2022-04-10T14:24:24.067' AS DateTime), CAST(N'2022-04-10T02:30:00.000' AS DateTime), 6555555.0000, -1000000.0000, 0.0000, 5555555.0000, N'ke', N'oke', 1)
GO
INSERT [dbo].[GIAOCA] ([MAGIAOCA], [MANVGIAOCA], [MANVNHANCA], [GIONHANCA], [GIOGIAOCA], [TIENCOSO], [TIENPHATSINH], [DOANHTHUCA], [TONGTIEN], [GHICHUGIAO], [GHICHUNHAN], [MATT]) VALUES (26, N'admin', NULL, CAST(N'2022-04-10T14:31:44.670' AS DateTime), NULL, 5555555.0000, 0.0000, 0.0000, 0.0000, NULL, NULL, 0)
GO
INSERT [dbo].[GIAOCA] ([MAGIAOCA], [MANVGIAOCA], [MANVNHANCA], [GIONHANCA], [GIOGIAOCA], [TIENCOSO], [TIENPHATSINH], [DOANHTHUCA], [TONGTIEN], [GHICHUGIAO], [GHICHUNHAN], [MATT]) VALUES (27, N'admin', N'user01', CAST(N'2022-04-11T00:43:51.087' AS DateTime), CAST(N'2022-04-11T12:44:00.000' AS DateTime), 1000000.0000, 500000.0000, 0.0000, 1500000.0000, N'à', N'ok', 1)
GO
INSERT [dbo].[GIAOCA] ([MAGIAOCA], [MANVGIAOCA], [MANVNHANCA], [GIONHANCA], [GIOGIAOCA], [TIENCOSO], [TIENPHATSINH], [DOANHTHUCA], [TONGTIEN], [GHICHUGIAO], [GHICHUNHAN], [MATT]) VALUES (28, N'admin', N'user01', CAST(N'2022-04-11T00:44:38.363' AS DateTime), CAST(N'2022-04-12T09:06:00.000' AS DateTime), 1000000.0000, 0.0000, 0.0000, 1000000.0000, N'', N'oke
', 1)
GO
INSERT [dbo].[GIAOCA] ([MAGIAOCA], [MANVGIAOCA], [MANVNHANCA], [GIONHANCA], [GIOGIAOCA], [TIENCOSO], [TIENPHATSINH], [DOANHTHUCA], [TONGTIEN], [GHICHUGIAO], [GHICHUNHAN], [MATT]) VALUES (32, N'admin', NULL, CAST(N'2022-04-12T09:24:17.313' AS DateTime), NULL, 1000000.0000, 0.0000, 0.0000, 1000000.0000, NULL, NULL, 2)
GO
SET IDENTITY_INSERT [dbo].[GIAOCA] OFF
GO
SET IDENTITY_INSERT [dbo].[LOAIKHACHHANG] ON 
GO
INSERT [dbo].[LOAIKHACHHANG] ([MALOAIKH], [TENLOAIKH], [TRANGTHAI]) VALUES (1, N'Thân thiết', 1)
GO
INSERT [dbo].[LOAIKHACHHANG] ([MALOAIKH], [TENLOAIKH], [TRANGTHAI]) VALUES (2, N'Vip', 1)
GO
SET IDENTITY_INSERT [dbo].[LOAIKHACHHANG] OFF
GO
INSERT [dbo].[KHACHHANG] ([MAKH], [MALOAIKH], [HOTEN], [TICHDIEM], [NGAYSINH], [GIOITINH], [EMAIL], [SDT], [DIACHI], [NGAYTAO], [TRANGTHAI]) VALUES (N'KH01', 1, N'Nguyễn Thị Hương', 1000, CAST(N'2002-03-05' AS Date), 0, N'huong@gmail.com', N'0987674342', N'Thanh Trì', CAST(N'2022-03-20' AS Date), 1)
GO
INSERT [dbo].[KHACHHANG] ([MAKH], [MALOAIKH], [HOTEN], [TICHDIEM], [NGAYSINH], [GIOITINH], [EMAIL], [SDT], [DIACHI], [NGAYTAO], [TRANGTHAI]) VALUES (N'KH02', 2, N'Bùi Phương Linh', 1000, CAST(N'2002-11-02' AS Date), 0, N'linh@gmail.com', N'0987364534', N'Sóc Sơn', CAST(N'2022-03-20' AS Date), 1)
GO
INSERT [dbo].[KHACHHANG] ([MAKH], [MALOAIKH], [HOTEN], [TICHDIEM], [NGAYSINH], [GIOITINH], [EMAIL], [SDT], [DIACHI], [NGAYTAO], [TRANGTHAI]) VALUES (N'KH03', 2, N'Nguyễn Tiến Võ', 4000, CAST(N'1997-04-15' AS Date), 1, N'vontph18623@fpt.edu.vn', N'0866843341', N'Hà Nội', CAST(N'2022-03-20' AS Date), 0)
GO
SET IDENTITY_INSERT [dbo].[TT_HOADON] ON 
GO
INSERT [dbo].[TT_HOADON] ([MATT], [TENTT]) VALUES (1, N'Chờ Thanh Toán')
GO
INSERT [dbo].[TT_HOADON] ([MATT], [TENTT]) VALUES (2, N'Đã Thanh Toán')
GO
INSERT [dbo].[TT_HOADON] ([MATT], [TENTT]) VALUES (3, N'Hủy')
GO
INSERT [dbo].[TT_HOADON] ([MATT], [TENTT]) VALUES (4, N'Hoàn Trả')
GO
INSERT [dbo].[TT_HOADON] ([MATT], [TENTT]) VALUES (5, N'Đang giao hàng')
GO
INSERT [dbo].[TT_HOADON] ([MATT], [TENTT]) VALUES (6, N'Chờ giao hàng')
GO
SET IDENTITY_INSERT [dbo].[TT_HOADON] OFF
GO
SET IDENTITY_INSERT [dbo].[HOADON] ON 
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10001, N'admin', N'KH01', 3, CAST(N'2022-04-08T03:37:27.000' AS DateTime), 0.0000, 500000.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10002, N'user01', N'KH02', 2, CAST(N'2022-02-22T00:00:00.000' AS DateTime), 12345.0000, 876543.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10003, N'user02', N'KH03', 3, CAST(N'2022-03-22T00:00:00.000' AS DateTime), 60000.0000, 888888.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10004, N'admin', N'KH02', 2, CAST(N'2022-03-21T00:00:00.000' AS DateTime), 20000.0000, 666666.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10005, N'admin', N'KH01', 2, CAST(N'2022-04-07T21:43:00.000' AS DateTime), 0.0000, 7567567.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10006, N'admin', N'KH01', 2, CAST(N'2022-04-07T21:44:00.000' AS DateTime), 456789.0000, 1234562.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10007, N'admin', N'KH01', 2, CAST(N'2022-03-09T00:00:00.000' AS DateTime), 0.0000, 343433.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10008, N'admin', N'KH01', 2, CAST(N'2022-03-01T00:00:00.000' AS DateTime), 123567.0000, 453245.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10009, N'admin', N'KH02', 2, CAST(N'2022-03-02T00:00:00.000' AS DateTime), 123567.0000, 342456.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10010, N'user01', N'KH03', 2, CAST(N'2022-03-03T00:00:00.000' AS DateTime), 1.0000, 2345432.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10011, N'user02', N'KH01', 2, CAST(N'2022-03-04T00:00:00.000' AS DateTime), 0.0000, 456744.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10012, N'user01', N'KH02', 2, CAST(N'2022-03-05T00:00:00.000' AS DateTime), 0.0000, 666666.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10013, N'user02', N'KH03', 2, CAST(N'2022-03-06T00:00:00.000' AS DateTime), 0.0000, 876453.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10014, N'admin', N'KH01', 2, CAST(N'2022-03-10T00:00:00.000' AS DateTime), 0.0000, 986789.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10015, N'admin', N'KH03', 2, CAST(N'2022-03-07T00:00:00.000' AS DateTime), 0.0000, 1111111.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10017, N'admin', N'KH02', 2, CAST(N'2022-03-14T00:00:00.000' AS DateTime), 0.0000, 45445445.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10018, N'admin', N'KH03', 6, CAST(N'2022-04-08T02:51:42.000' AS DateTime), 0.0000, 200000.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10019, N'admin', N'KH01', 3, CAST(N'2022-04-08T04:01:04.000' AS DateTime), 0.0000, 100000.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10020, N'admin', N'KH03', 3, CAST(N'2022-04-08T04:02:41.000' AS DateTime), 0.0000, 20000.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10021, N'admin', N'KH01', 3, CAST(N'2022-04-08T04:23:04.000' AS DateTime), 0.0000, 100000.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10022, N'admin', N'KH03', 3, CAST(N'2022-04-08T04:29:02.000' AS DateTime), 0.0000, 100000.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10023, N'admin', N'KH03', 3, CAST(N'2022-04-08T04:34:54.000' AS DateTime), 0.0000, 100000.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10024, N'admin', N'KH01', 3, CAST(N'2022-04-08T07:38:07.000' AS DateTime), 0.0000, 100000.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10025, N'admin', N'KH01', 3, CAST(N'2022-04-08T07:43:30.000' AS DateTime), 0.0000, 100000.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10026, N'admin', N'KH03', 6, CAST(N'2022-04-08T07:47:14.000' AS DateTime), 0.0000, 100000.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10027, N'admin', NULL, 1, NULL, 0.0000, 0.0000, NULL)
GO
INSERT [dbo].[HOADON] ([MAHOADON], [MANV], [MAKH], [MATT], [NGAYMUA], [GIAMGIA], [THANHTIEN], [GHICHU]) VALUES (10028, N'admin', N'KH01', 1, NULL, 0.0000, 0.0000, NULL)
GO
SET IDENTITY_INSERT [dbo].[HOADON] OFF
GO
SET IDENTITY_INSERT [dbo].[DONVITINH] ON 
GO
INSERT [dbo].[DONVITINH] ([MADVT], [TENDVT], [TRANGTHAI]) VALUES (1, N'Cái', 1)
GO
INSERT [dbo].[DONVITINH] ([MADVT], [TENDVT], [TRANGTHAI]) VALUES (2, N'Chiếc', 1)
GO
INSERT [dbo].[DONVITINH] ([MADVT], [TENDVT], [TRANGTHAI]) VALUES (3, N'Lô', 0)
GO
SET IDENTITY_INSERT [dbo].[DONVITINH] OFF
GO
SET IDENTITY_INSERT [dbo].[MAUSAC] ON 
GO
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU], [TRANGTHAI]) VALUES (1, N'Đỏ', 1)
GO
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU], [TRANGTHAI]) VALUES (2, N'Vàng', 1)
GO
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU], [TRANGTHAI]) VALUES (3, N'Xanh Dương', 1)
GO
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU], [TRANGTHAI]) VALUES (4, N'Green', 1)
GO
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU], [TRANGTHAI]) VALUES (5, N'Đen', 1)
GO
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU], [TRANGTHAI]) VALUES (6, N'Trắng', 1)
GO
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU], [TRANGTHAI]) VALUES (7, N'Đen Trắng', 1)
GO
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU], [TRANGTHAI]) VALUES (8, N'Vàng Đen', 1)
GO
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU], [TRANGTHAI]) VALUES (9, N'Xanh Trắng', 1)
GO
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU], [TRANGTHAI]) VALUES (10, N'Đỏ Đen', 1)
GO
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU], [TRANGTHAI]) VALUES (11, N'Tím', 1)
GO
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU], [TRANGTHAI]) VALUES (12, N'Hồng', 1)
GO
INSERT [dbo].[MAUSAC] ([MAMAU], [TENMAU], [TRANGTHAI]) VALUES (13, N'Hồng Cánh Sen', 1)
GO
SET IDENTITY_INSERT [dbo].[MAUSAC] OFF
GO
SET IDENTITY_INSERT [dbo].[DANHMUC] ON 
GO
INSERT [dbo].[DANHMUC] ([MADM], [TENDANHMUC], [NGAYTHEM], [TRANGTHAI]) VALUES (100, N'Áo Sơ Mi', CAST(N'2022-03-20' AS Date), 1)
GO
INSERT [dbo].[DANHMUC] ([MADM], [TENDANHMUC], [NGAYTHEM], [TRANGTHAI]) VALUES (101, N'Quần Jean Nam', CAST(N'2022-03-20' AS Date), 1)
GO
INSERT [dbo].[DANHMUC] ([MADM], [TENDANHMUC], [NGAYTHEM], [TRANGTHAI]) VALUES (103, N'Áo Phông Không Cổ', CAST(N'2022-03-20' AS Date), 1)
GO
INSERT [dbo].[DANHMUC] ([MADM], [TENDANHMUC], [NGAYTHEM], [TRANGTHAI]) VALUES (104, N'Áo Phông Có Cổ', CAST(N'2022-03-20' AS Date), 1)
GO
INSERT [dbo].[DANHMUC] ([MADM], [TENDANHMUC], [NGAYTHEM], [TRANGTHAI]) VALUES (105, N'Quần Âu', CAST(N'2022-03-20' AS Date), 1)
GO
INSERT [dbo].[DANHMUC] ([MADM], [TENDANHMUC], [NGAYTHEM], [TRANGTHAI]) VALUES (106, N'Quần Short', CAST(N'2022-03-20' AS Date), 1)
GO
SET IDENTITY_INSERT [dbo].[DANHMUC] OFF
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'27', N'Quần', 1)
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'28', N'Quần', 1)
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'29', N'Quần', 1)
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'30', N'Quần', 1)
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'31', N'Quần', 1)
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'32', N'Quần', 1)
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'33', N'Quần', 1)
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'38', N'Quần', 1)
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'39', N'áo', 1)
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'L', N'Áo', 1)
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'M', N'Áo', 1)
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'S', N'Áo', 1)
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'XL', N'Áo', 1)
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'XS', N'Áo', 1)
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'XXL', N'Áo', 1)
GO
INSERT [dbo].[SIZE] ([MASIZE], [LOAISIZE], [TRANGTHAI]) VALUES (N'XXXL', N'Áo', 1)
GO
SET IDENTITY_INSERT [dbo].[CHATLIEU] ON 
GO
INSERT [dbo].[CHATLIEU] ([MACHATLIEU], [TENCHATLIEU], [TRANGTHAI]) VALUES (1, N'Cotton', 1)
GO
INSERT [dbo].[CHATLIEU] ([MACHATLIEU], [TENCHATLIEU], [TRANGTHAI]) VALUES (2, N'Tự nhiên', 1)
GO
INSERT [dbo].[CHATLIEU] ([MACHATLIEU], [TENCHATLIEU], [TRANGTHAI]) VALUES (3, N'Tơ tằm', 1)
GO
SET IDENTITY_INSERT [dbo].[CHATLIEU] OFF
GO
SET IDENTITY_INSERT [dbo].[SANPHAM] ON 
GO
INSERT [dbo].[SANPHAM] ([MASP], [MADM], [MAVACH], [TENSP], [ANHSANPHAM], [GIANHAP], [GIABAN], [SOLUONG], [NGAYNHAP], [APDUNGKM], [MADVT], [MAMAU], [MASIZE], [MACHATLIEU], [TRANGTHAI]) VALUES (1000, 100, N'0000111', N'Áo Sơ Mi Nam', N'ao.jpg', 50000.0000, 100000.0000, 198, CAST(N'2022-03-20' AS Date), 1, 1, 1, N'M', 1, 1)
GO
INSERT [dbo].[SANPHAM] ([MASP], [MADM], [MAVACH], [TENSP], [ANHSANPHAM], [GIANHAP], [GIABAN], [SOLUONG], [NGAYNHAP], [APDUNGKM], [MADVT], [MAMAU], [MASIZE], [MACHATLIEU], [TRANGTHAI]) VALUES (1002, 100, N'0000112', N'Sơ Mi Trắng', NULL, 50000.0000, 100000.0000, 202, CAST(N'2022-03-20' AS Date), 1, 1, 1, N'S', 1, 1)
GO
INSERT [dbo].[SANPHAM] ([MASP], [MADM], [MAVACH], [TENSP], [ANHSANPHAM], [GIANHAP], [GIABAN], [SOLUONG], [NGAYNHAP], [APDUNGKM], [MADVT], [MAMAU], [MASIZE], [MACHATLIEU], [TRANGTHAI]) VALUES (1003, 101, N'0000113', N'Áo phông đen', NULL, 20000.0000, 75000.0000, 500, CAST(N'2022-03-20' AS Date), 0, 2, 2, N'XL', 2, 1)
GO
INSERT [dbo].[SANPHAM] ([MASP], [MADM], [MAVACH], [TENSP], [ANHSANPHAM], [GIANHAP], [GIABAN], [SOLUONG], [NGAYNHAP], [APDUNGKM], [MADVT], [MAMAU], [MASIZE], [MACHATLIEU], [TRANGTHAI]) VALUES (1004, 101, NULL, N'Quần Jean đen', NULL, 75000.0000, 20000.0000, 998, CAST(N'2022-03-20' AS Date), 1, 2, 2, N'XXL', 2, 1)
GO
INSERT [dbo].[SANPHAM] ([MASP], [MADM], [MAVACH], [TENSP], [ANHSANPHAM], [GIANHAP], [GIABAN], [SOLUONG], [NGAYNHAP], [APDUNGKM], [MADVT], [MAMAU], [MASIZE], [MACHATLIEU], [TRANGTHAI]) VALUES (1005, 100, NULL, N'Áo gió', NULL, 12000.0000, 500000.0000, 5, CAST(N'2022-03-03' AS Date), 1, 1, 2, N'XXL', 1, 1)
GO
INSERT [dbo].[SANPHAM] ([MASP], [MADM], [MAVACH], [TENSP], [ANHSANPHAM], [GIANHAP], [GIABAN], [SOLUONG], [NGAYNHAP], [APDUNGKM], [MADVT], [MAMAU], [MASIZE], [MACHATLIEU], [TRANGTHAI]) VALUES (1007, 101, N'', N'Quần ', NULL, 30000.0000, 80000.0000, 10, CAST(N'2022-03-26' AS Date), 1, 1, 2, N'S', 2, NULL)
GO
INSERT [dbo].[SANPHAM] ([MASP], [MADM], [MAVACH], [TENSP], [ANHSANPHAM], [GIANHAP], [GIABAN], [SOLUONG], [NGAYNHAP], [APDUNGKM], [MADVT], [MAMAU], [MASIZE], [MACHATLIEU], [TRANGTHAI]) VALUES (1008, 101, N'', N'Áo', NULL, 50000.0000, 100000.0000, 15, CAST(N'2022-03-26' AS Date), 1, 1, 1, N'L', 1, 1)
GO
INSERT [dbo].[SANPHAM] ([MASP], [MADM], [MAVACH], [TENSP], [ANHSANPHAM], [GIANHAP], [GIABAN], [SOLUONG], [NGAYNHAP], [APDUNGKM], [MADVT], [MAMAU], [MASIZE], [MACHATLIEU], [TRANGTHAI]) VALUES (1009, 100, N'0000118', N'Áo', NULL, 10000.0000, 123000.0000, 51, CAST(N'2022-03-26' AS Date), 1, 1, 1, N'L', 1, 1)
GO
INSERT [dbo].[SANPHAM] ([MASP], [MADM], [MAVACH], [TENSP], [ANHSANPHAM], [GIANHAP], [GIABAN], [SOLUONG], [NGAYNHAP], [APDUNGKM], [MADVT], [MAMAU], [MASIZE], [MACHATLIEU], [TRANGTHAI]) VALUES (1010, 100, N'0000119', N'Áo Sơ Mi Nam', N'noImage.jpg', 50000.0000, 100000.0000, 200, CAST(N'2022-04-04' AS Date), 1, 1, 1, N'M', 1, 1)
GO
INSERT [dbo].[SANPHAM] ([MASP], [MADM], [MAVACH], [TENSP], [ANHSANPHAM], [GIANHAP], [GIABAN], [SOLUONG], [NGAYNHAP], [APDUNGKM], [MADVT], [MAMAU], [MASIZE], [MACHATLIEU], [TRANGTHAI]) VALUES (1011, 100, N'0000110', N'Sơ Mi Trắng', N'noImage.jpg', 50000.0000, 100000.0000, 200, CAST(N'2022-04-04' AS Date), 1, 1, 1, N'S', 1, 1)
GO
INSERT [dbo].[SANPHAM] ([MASP], [MADM], [MAVACH], [TENSP], [ANHSANPHAM], [GIANHAP], [GIABAN], [SOLUONG], [NGAYNHAP], [APDUNGKM], [MADVT], [MAMAU], [MASIZE], [MACHATLIEU], [TRANGTHAI]) VALUES (1012, 101, N'0000002', N'Áo phông đen', N'noImage.jpg', 20000.0000, 75000.0000, 500, CAST(N'2022-04-04' AS Date), 1, 2, 2, N'XL', 2, 1)
GO
INSERT [dbo].[SANPHAM] ([MASP], [MADM], [MAVACH], [TENSP], [ANHSANPHAM], [GIANHAP], [GIABAN], [SOLUONG], [NGAYNHAP], [APDUNGKM], [MADVT], [MAMAU], [MASIZE], [MACHATLIEU], [TRANGTHAI]) VALUES (1013, 101, N'0000003', N'Quần Jean đen', N'noImage.jpg', 75000.0000, 20000.0000, 1000, CAST(N'2022-04-04' AS Date), 1, 2, 2, N'XXL', 2, 1)
GO
INSERT [dbo].[SANPHAM] ([MASP], [MADM], [MAVACH], [TENSP], [ANHSANPHAM], [GIANHAP], [GIABAN], [SOLUONG], [NGAYNHAP], [APDUNGKM], [MADVT], [MAMAU], [MASIZE], [MACHATLIEU], [TRANGTHAI]) VALUES (1014, 100, N'0000004', N'Áo gió', N'noImage.jpg', 12000.0000, 500000.0000, 5, CAST(N'2022-04-04' AS Date), 1, 1, 2, N'XXL', 1, 1)
GO
INSERT [dbo].[SANPHAM] ([MASP], [MADM], [MAVACH], [TENSP], [ANHSANPHAM], [GIANHAP], [GIABAN], [SOLUONG], [NGAYNHAP], [APDUNGKM], [MADVT], [MAMAU], [MASIZE], [MACHATLIEU], [TRANGTHAI]) VALUES (1015, 101, N'0000005', N'Áo', N'noImage.jpg', 50000.0000, 100000.0000, 15, CAST(N'2022-04-04' AS Date), 1, 1, 1, N'L', 1, 1)
GO
SET IDENTITY_INSERT [dbo].[SANPHAM] OFF
GO
SET IDENTITY_INSERT [dbo].[KHUYENMAI] ON 
GO
INSERT [dbo].[KHUYENMAI] ([MAKM], [MASP], [TENKM], [LOAIKM], [HINHTHUCAD], [GIATRI], [HDTOITHIEU], [GIAMTOIDA], [NGAYBATDAU], [NGAYKETTHUC], [TRANGTHAI]) VALUES (1, 1000, N'8/3', 1, 1, 50000.0000, NULL, 50000.0000, CAST(N'2022-03-21' AS Date), CAST(N'2022-03-31' AS Date), 0)
GO
INSERT [dbo].[KHUYENMAI] ([MAKM], [MASP], [TENKM], [LOAIKM], [HINHTHUCAD], [GIATRI], [HDTOITHIEU], [GIAMTOIDA], [NGAYBATDAU], [NGAYKETTHUC], [TRANGTHAI]) VALUES (5, 1000, N'27/3', 1, 0, 20.0000, NULL, 100000.0000, CAST(N'2022-03-24' AS Date), CAST(N'2022-03-31' AS Date), 0)
GO
INSERT [dbo].[KHUYENMAI] ([MAKM], [MASP], [TENKM], [LOAIKM], [HINHTHUCAD], [GIATRI], [HDTOITHIEU], [GIAMTOIDA], [NGAYBATDAU], [NGAYKETTHUC], [TRANGTHAI]) VALUES (7, 1002, N'27/03', 1, 0, 20.0000, NULL, 100000.0000, CAST(N'2022-03-24' AS Date), CAST(N'2022-03-31' AS Date), 0)
GO
INSERT [dbo].[KHUYENMAI] ([MAKM], [MASP], [TENKM], [LOAIKM], [HINHTHUCAD], [GIATRI], [HDTOITHIEU], [GIAMTOIDA], [NGAYBATDAU], [NGAYKETTHUC], [TRANGTHAI]) VALUES (8, NULL, N'thích', 0, 1, 10000.0000, 199999.0000, 30000.0000, CAST(N'2022-04-09' AS Date), CAST(N'2022-04-12' AS Date), 1)
GO
INSERT [dbo].[KHUYENMAI] ([MAKM], [MASP], [TENKM], [LOAIKM], [HINHTHUCAD], [GIATRI], [HDTOITHIEU], [GIAMTOIDA], [NGAYBATDAU], [NGAYKETTHUC], [TRANGTHAI]) VALUES (9, NULL, N'thích', 0, 0, 20.0000, 199999.0000, 30000.0000, CAST(N'2022-04-09' AS Date), CAST(N'2022-04-12' AS Date), 1)
GO
SET IDENTITY_INSERT [dbo].[KHUYENMAI] OFF
GO
SET IDENTITY_INSERT [dbo].[CT_HOADON] ON 
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (10, 10001, 1000, 3, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (11, 10001, 1002, 2, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (12, 10002, 1002, 3, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (13, 10002, 1003, 4, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (14, 10003, 1004, 8, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (15, 10003, 1003, 450, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (16, 10004, 1004, 400, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (17, 10004, 1000, 50, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (18, 10005, 1002, 10, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (19, 10006, 1003, 1, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (20, 10007, 1002, 1, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (21, 10008, 1000, 1, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (22, 10009, 1004, 10, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (23, 10010, 1000, 10, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (24, 10011, 1003, 10, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (25, 10012, 1002, 10, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (26, 10013, 1003, 1, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (27, 10014, 1004, 1, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (28, 10015, 1003, 1, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (29, 10017, 1002, 13, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (30, 10018, 1000, 2, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (31, 10019, 1002, 1, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (32, 10020, 1004, 1, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (33, 10021, 1000, 1, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (34, 10022, 1000, 1, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (35, 10023, 1000, 1, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (36, 10024, 1000, 1, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (37, 10025, 1000, 1, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (38, 10026, 1000, 1, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (39, 10027, 1000, 1, 0.0000, NULL, 1)
GO
INSERT [dbo].[CT_HOADON] ([MACTHD], [MAHD], [MASP], [SOLUONG], [GIABAN], [GHICHU], [TRANGTHAI]) VALUES (40, 10028, 1004, 2, 0.0000, NULL, 1)
GO
SET IDENTITY_INSERT [dbo].[CT_HOADON] OFF
GO
SET IDENTITY_INSERT [dbo].[GIAOHANG] ON 
GO
INSERT [dbo].[GIAOHANG] ([MAGIAOHANG], [MAHOADON], [TENKHACHHANG], [SDT], [DIACHI], [NGAYGIAOHANG], [TIENSHIPHANG], [GHICHU], [MATT]) VALUES (1, 10018, N'Nguyễn Tiến Võ', N'0866843341', N'Hà Nội', CAST(N'2022-04-08T00:00:00.000' AS DateTime), 0.0000, N'', 6)
GO
INSERT [dbo].[GIAOHANG] ([MAGIAOHANG], [MAHOADON], [TENKHACHHANG], [SDT], [DIACHI], [NGAYGIAOHANG], [TIENSHIPHANG], [GHICHU], [MATT]) VALUES (2, 10001, N'Nguyễn Thị Hương', N'0987674342', N'Thanh Trì', CAST(N'2022-04-08T00:00:00.000' AS DateTime), 0.0000, N'', 3)
GO
INSERT [dbo].[GIAOHANG] ([MAGIAOHANG], [MAHOADON], [TENKHACHHANG], [SDT], [DIACHI], [NGAYGIAOHANG], [TIENSHIPHANG], [GHICHU], [MATT]) VALUES (4, 10019, N'Nguyễn Thị Hương', N'0987674342', N'Thanh Trì', CAST(N'2022-04-08T00:00:00.000' AS DateTime), 0.0000, N'', 3)
GO
INSERT [dbo].[GIAOHANG] ([MAGIAOHANG], [MAHOADON], [TENKHACHHANG], [SDT], [DIACHI], [NGAYGIAOHANG], [TIENSHIPHANG], [GHICHU], [MATT]) VALUES (5, 10020, N'Nguyễn Tiến Võ', N'0866843341', N'Hà Nội', CAST(N'2022-04-08T00:00:00.000' AS DateTime), 0.0000, N'', 3)
GO
INSERT [dbo].[GIAOHANG] ([MAGIAOHANG], [MAHOADON], [TENKHACHHANG], [SDT], [DIACHI], [NGAYGIAOHANG], [TIENSHIPHANG], [GHICHU], [MATT]) VALUES (6, 10021, N'Nguyễn Thị Hương', N'0987674342', N'Thanh Trì', CAST(N'2022-04-08T00:00:00.000' AS DateTime), 0.0000, N'', 3)
GO
INSERT [dbo].[GIAOHANG] ([MAGIAOHANG], [MAHOADON], [TENKHACHHANG], [SDT], [DIACHI], [NGAYGIAOHANG], [TIENSHIPHANG], [GHICHU], [MATT]) VALUES (7, 10022, N'Nguyễn Tiến Võ', N'0866843341', N'Hà Nội', CAST(N'2022-04-08T00:00:00.000' AS DateTime), 0.0000, N'', 3)
GO
INSERT [dbo].[GIAOHANG] ([MAGIAOHANG], [MAHOADON], [TENKHACHHANG], [SDT], [DIACHI], [NGAYGIAOHANG], [TIENSHIPHANG], [GHICHU], [MATT]) VALUES (8, 10023, N'Nguyễn Tiến Võ', N'0866843341', N'Hà Nội', CAST(N'2022-04-08T00:00:00.000' AS DateTime), 0.0000, N'', 3)
GO
INSERT [dbo].[GIAOHANG] ([MAGIAOHANG], [MAHOADON], [TENKHACHHANG], [SDT], [DIACHI], [NGAYGIAOHANG], [TIENSHIPHANG], [GHICHU], [MATT]) VALUES (9, 10024, N'Nguyễn Thị Hương', N'0987674342', N'Thanh Trì', CAST(N'2022-04-08T00:00:00.000' AS DateTime), 0.0000, N'', 3)
GO
INSERT [dbo].[GIAOHANG] ([MAGIAOHANG], [MAHOADON], [TENKHACHHANG], [SDT], [DIACHI], [NGAYGIAOHANG], [TIENSHIPHANG], [GHICHU], [MATT]) VALUES (10, 10025, N'Nguyễn Thị Hương', N'0987674342', N'Thanh Trì', CAST(N'2022-04-08T00:00:00.000' AS DateTime), 0.0000, N'', 3)
GO
INSERT [dbo].[GIAOHANG] ([MAGIAOHANG], [MAHOADON], [TENKHACHHANG], [SDT], [DIACHI], [NGAYGIAOHANG], [TIENSHIPHANG], [GHICHU], [MATT]) VALUES (11, 10026, N'Nguyễn Tiến Võ', N'0866843341', N'Hà Nội', CAST(N'2022-04-08T00:00:00.000' AS DateTime), 0.0000, N'', 6)
GO
SET IDENTITY_INSERT [dbo].[GIAOHANG] OFF
GO
