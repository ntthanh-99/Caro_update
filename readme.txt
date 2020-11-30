Môi trường
    - jdk 10.0.2
    - IDE: NetBean 12.1

Dự án: Caro LAN

Giao diện: Java Swing Đơn giản

Kết nối: Nhiều người trong cùng 1 mạng LAN
    -Server: tạo server tại cổng 1107
    -Client: kết nối với server qua địa chỉ IP và Port 1107
		khi ghép đôi thì mở tại cổng 1108

Luật chơi: chỉ cần 5 nước là thắng
    - ván đầu: ai đánh trc cũng đc
    - các ván sau: thua đánh trước
    - Cầu hòa: người cầu hòa đánh sau
    - Xin thua: người thua đánh trc
    - chưa xử lí khi đánh hết cờ thì hòa

LT mạng:
    - TCP/IP
    - DataInput/OutputStream : ReadUTF/WriteUTF

Update:
    - Sửa lỗi đánh nhầm nước
    - Sửa lỗi người dùng thoát k báo trc = việc xử lí ngoại lệ
	khi gửi dữ liệu sang bên kia
    - Server đứng trung gian với 2 chức năng: ghép + tạo bàn
    - Fix cứng kích thước Button -> giao diện nhìn khá hơn
    - Thêm tỉ số khi chơi
    - Thêm tên người chơi, để phân biệt nhau LAN ( đóng gói Object)
    - Thêm tính năng cầu hòa và xin thua và yêu cầu nhận từ đối thủ
