create database QLKHO
go
use QLKHO
go
create table Login(
userName varchar (10) primary key,
pass nchar (10)
)
create table NhanVien(
MaNV varchar(8) primary key,
TenNV nvarchar (50) ,
NgaySinh date
 check(datediff(day,dateadd(year,-18,getdate()),NgaySinh)<=0),
DiaChi nvarchar(50) ,
SDT varchar(11) 
constraint  sdt check
(SDT like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' or SDT like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'),
GioiTinh nvarchar(4)
check (GioiTinh in (N'Nam',N'Nữ')) ,
Email varchar(30) 
check (email like '[a-z]%@%'),
Password varchar(10) 
)
go
Set dateformat dmy
insert into Nhanvien
values ('NV01','Hồ Thị Vân Anh ','11/03/2001','Đức Bố 1','0839581138',N'Nữ','Anh@gmail.com','12345'),
       ('NV02','Hồ Thiện Phước ','22/3/2001','Phú Ninh','0373520613',N'Nam','Phuoc@gmail.com','11111'),
	   ('NV03','Hồ Thái Bình ','20/4/2001','Dak Mil','0123456789',N'Nam','Binh@gmail.com','00000'),
	   ('NV04','Trần Đại ','24/01/2001','Quãng Ngãi','0866146741',N'Nam','Dai@gmail.com','22222'),
	   ('NV05','Nguyễn Thị Thoa ','25/03/2001','Thạch Kiều','0397927870',N'Nữ','Thoa@gmail.com','33333')
go
create table DanhMuc(
MaDM varchar(8) ,
TenDM nvarchar(50) ,
)
go
insert into DanhMuc
Values('DM01','Sách Lập Trình'),
	  ('DM02','Sách Nâng Cao'),
	  ('DM03','Sách Toán'),
	  ('DM04','Sách Chính Trị')
go
create table SanPham(
MaSach varchar(8) primary key ,
TenSach nvarchar (20) ,
MaDM varchar(8) ,
Tacgia nvarchar(30) ,
NXB nvarchar(30),
Gia money ,
)
go
insert into SanPham
Values ('S01',N'Lập trình Java 2','DM01',N'Đỗ Phú',N'Kim Đồng','50000'),
	   ('S02',N'Lập trình C','DM02',N'Hoàng Thị Mỹ Lệ','SPKT','90000'),
	   ('S03',N'Toán rời rạc','DM03',N'Khong biet','HCM','100000'),
	   ('S04',N'Kinh Tế Chính Trị','DM04',N'Trần Quân','HCM','60000'),
	   ('S05',N'Lịch Sử Đảng','DM04',N'Đình Nhân','Hà Nội','400000')
go
create table HoaDon(
MaHD varchar(8) primary key,
MaNV varchar(8),
Ngay date ,
TenKH nvarchar (30),
Loai nvarchar(1) ,
FOREIGN KEY (MaNV) REFERENCES Nhanvien(MaNV),
)
go
set dateformat dmy
insert into HoaDon
Values('HD01','NV02','24/05/2019',N'Nguyễn An','N'),
	  ('HD02','NV04','12/09/2020',N'Nguyễn Thúy','N'),
	  ('HD03','NV05','14/05/2018',N'Nguyễn Hà Anh','X'),
	  ('HD04','NV01','12/01/2021',N'Nguyễn Thị Ngọc','N'),
	  ('HD05','NV03','02/03/2018',N'Lương Thị Nguyên Hiền','N'),
	  ('HD06','NV05','04/05/2017',N'Lương Minh Tin','X'),
	  ('HD07','NV02','04/06/2020',N'Bùi Châu Hiền ','X'),
	  ('HD08','NV01','05/07/2017',N'Hồ Lát','X'),
	  ('HD09','NV03','11/12/2020',N'Trần Anh Vệt','N'),
	  ('HD10','NV02','11/11/2020',N'Võ Xuân Hương','N')
go
create table ChiTietHoaDon(
MaHD varchar(8) ,
MaSach varchar(8) ,
SoLuong int 
 check (SoLuong >0 ),
DonGia money
check (DonGia > 0),
FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
FOREIGN KEY (MaSach) REFERENCES SanPham(MaSach),
primary key (MaHD,MaSach),
)
go
insert into ChiTietHoaDon
Values('HD01','S01','20','1'),
	  ('HD02','S03','50','1'),
	  ('HD03','S02','15','1'),
	  ('HD04','S05','2','1'),
	  ('HD05','S03','20','1'),
	  ('HD06','S02','15','1'),
	  ('HD07','S04','10','2'),
	  ('HD08','S01','30','3'),
	  ('HD09','S05','15','1'),
	  ('HD10','S04','16','4')
go
