# Student Management API (IT209_Session10_BTTH)

Hệ thống Spring Boot RESTful API quản lý sinh viên (Student) kết nối MySQL Database, sử dụng **Gradle**, chạy độc lập hoặc triển khai qua Docker & Docker Compose.

---

## 1. Thông tin sinh viên mẫu

- **Họ và tên**: Hồ Khánh Linh
- **Ngày sinh**: 31/05/2002
- **Giới tính**: Nữ
- **Số điện thoại**: 0123456789
- **GPA**: 3.0

---

## 2. Công nghệ sử dụng

- **Build Tool**: Gradle 8.7
- **Java**: 17
- **Spring Boot**: 3.2.5 (Spring Web, Spring Data JPA, Lombok, Validation)
- **Database**: MySQL 8.0
- **Containerization**: Docker, Docker Compose

---

## 3. Cấu hình biến môi trường (`.env`)

Sao chép `.env.example` thành `.env` (hoặc chỉnh sửa trực tiếp `.env`):
```env
MYSQL_HOST=mysql-db
MYSQL_PORT=3306
MYSQL_DATABASE=student_db
MYSQL_ROOT_PASSWORD=rootpassword
MYSQL_USER=student_user
MYSQL_PASSWORD=studentpass
APP_PORT=8080
```

---

## 4. Hướng dẫn chạy ứng dụng

### Cách 1: Chạy bằng Docker Compose (Khuyên dùng)
```bash
docker compose up --build -d
```
Ứng dụng API sẽ khởi chạy tại: `http://localhost:8080`

### Cách 2: Chạy trực tiếp từ mã nguồn với Gradle
1. Khởi động MySQL và tạo database `student_db`.
2. Cập nhật thông tin kết nối trong `src/main/resources/application.yml` hoặc set biến môi trường.
3. Chạy lệnh:
```bash
./gradlew bootRun
```

---

## 5. Danh sách API (`/api/v1/students`)

| Phương thức | Endpoint | Mô tả |
|---|---|---|
| `GET` | `/api/v1/students` | Lấy danh sách (hỗ trợ `keyword`, `page`, `size`, `sortBy`, `sortDir`) |
| `GET` | `/api/v1/students/{id}` | Lấy thông tin chi tiết sinh viên theo ID |
| `POST` | `/api/v1/students` | Thêm mới sinh viên |
| `PUT` | `/api/v1/students/{id}` | Cập nhật thông tin sinh viên |
| `DELETE` | `/api/v1/students/{id}` | Xóa sinh viên theo ID |

### Body mẫu khi tạo mới (`POST /api/v1/students`):
```json
{
  "studentCode": "SV2026001",
  "fullName": "Hồ Khánh Linh",
  "dateOfBirth": "2002-05-31",
  "gender": "Nữ",
  "phoneNumber": "0123456789",
  "gpa": 3.0
}
```
