# student-management
Bài tập L0
"Mô tả: Phần mềm quản lý sinh viên
- Người: gồm các thông tin:
        + Id - số dương - không trùng, tự động tăng
        + Tên - chuỗi < 100 ký tự, không rỗng
        + Ngày sinh - ngày giờ từ năm 1900, không null
        + Địa chỉ - chuỗi < 300 kí tự
        + Chiều cao (đơn vị cm): từ 50.0 - 300.0
        + Cân nặng (đơn vị kg): từ 5.0 - 1000.0

- Sinh viên kế thừa Người, gồm thêm các thông tin:
        + Mã sinh viên - Chuỗi 10 kí tự không trùng, không null
        + Trường đang theo học - chuỗi < 200 kí tự, không null
        + Năm bắt đầu học đại học: số 4 chữ số từ 1900, không null
        + Điểm trung bình tích luỹ - từ 0.0 đến 10.0"		"Yêu cầu cơ bản:
 - Dùng Tiếng Anh.
 - Cần trả lời được các câu hỏi ở mỗi bài
 - Tuân thủ theo các convention code
 - Thao tác với dữ liệu qua Console"	Link lý thuyết L0: https://docs.google.com/spreadsheets/d/13AuZw_BD62FRsz-aIoUPA_hT3UvL2cF9gaFo71RMY64/edit?pli=1#gid=582151293
|**TÀI SẢN TỔNG HỢP CỦA CÔNG TY OCEANTECH, VUI LÒNG KHÔNG COPY DƯỚI MỌI HÌNH THỨC**|||
| - | :- | :- |
|Mô tả: Phần mềm quản lý sinh viên - Người: gồm các thông tin:         + Id - số dương - không trùng, tự động tăng         + Tên - chuỗi < 100 ký tự, không rỗng         + Ngày sinh - ngày giờ từ năm 1900, không null         + Địa chỉ - chuỗi < 300 kí tự         + Chiều cao (đơn vị cm): từ 50.0 - 300.0         + Cân nặng (đơn vị kg): từ 5.0 - 1000.0  - Sinh viên kế thừa Người, gồm thêm các thông tin:         + Mã sinh viên - Chuỗi 10 kí tự không trùng, không null         + Trường đang theo học - chuỗi < 200 kí tự, không null         + Năm bắt đầu học đại học: số 4 chữ số từ 1900, không null         + Điểm trung bình tích luỹ - từ 0.0 đến 10.0|||
|STT|Yêu cầu||
|1|Tạo các class Người và Sinh viên||
|2|Thêm access modifier cho các trường||
|3|Tạo hàm khởi tạo cho class Người và Sinh viên  - Hàm khởi tạo class Sinh viên kế thừa class Người||
|4|Tạo phương thức "toString" in các thông tin cơ bản của người, sinh viên||
|5|Tạo một mảng tĩnh để lưu trữ các sinh viên cho bài tập sau||
|6|Khi nhập dữ liệu sinh viên, mỗi biến có các khoảng dữ liệu khác nhau -> Khai báo trước hằng số đối với các giới hạn này.||
|7|Create (C) sinh viên theo Id  - Yêu cầu dữ liệu phải phù hợp mới lưu - cần thông báo lỗi ra console  - Khi thêm thành công phải in thông tin sinh viên thêm mới thành công ra console  - Lưu trữ sinh viên vào mảng tạo ở bài 6||
|8|Read (R)  - Chức năng tìm kiếm sinh viên theo id  - Hiển thị kết quả:    + Không tìm thấy: Không có dữ liệu phù hợp.    + In kết quả ra console||
|9|Update (U) sinh viên theo id  - Dùng phương thức ở bài 8 để tìm kiếm chính xác sinh viên để cập nhật  - Yêu cầu dữ liệu phải phù hợp mới lưu - cần thông báo lỗi ra console  - Khi thêm thành công phải in thông tin sinh viên sau khi sửa ra console  - Lưu trữ sinh viên vào mảng tạo ở bài 6||
|10|Delete (D) sinh viên theo id  - Xoá sinh viên khỏi mảng tạo ở bài 6  - Nếu không tồn tại sinh  viên cần thông báo lỗi  - Khi mảng lưu trữ ở vị trí 0, 1, 2, 3. Xoá mất sinh viên ở ví trì 1 thì phải kéo các phần tử ở sau lùi về (2 về 1, 3 về 2).||
|11|Dùng mảng tĩnh gặp rất nhiều bất tiện -> Thay mảng ở bài 6 thành mảng động (Trong bài tập chỉ giới hạn đến việc sử dụng mảng, thường trong thực tế để thay lưu trữ và truy xuất  sẽ dùng mảng động, còn CRUD 1 danh sánh hay dùng Linked List để lưu trữ)||
|12|- Thêm trường học lực cho sinh viên - dạng enum - Học lực của sinh viên được tính như sau (dựa vào điểm trung bình):    + Điểm < 3: Kém    + 3 <= điểm < 5: Yếu    + 5 <= điểm < 6.5: Trung bình    + 6.5 <= điểm < 7.5: Khá    + 7.5 <= điểm < 9: giỏi    + Điểm >= 9: xuất sắc - Tự động cập nhật học lực cho sinh viên khi nhập hoặc sửa điểm.||
|13|- Hiển thị % học lực của các sinh viên trong danh sách sắp xếp từ cao xuống thấp||
|14|- Hiển thị % điểm trung bình của các sinh viên trong danh sách Ví dụ có 5 bạn sinh viên có điểm trung bình lần lượt là: 1,2,3,2,4 -> Kết quả đầu ra: 1: 20%, 2: 40%, 3: 20%, 4: 20%.  ( Gợi ý dùng Map)||
|15|- In ra màn hình danh sách các sinh viên tuỳ theo học lực nhập từ bàn phím||
|16|- Lưu trữ danh sách sinh viên vào file khi dừng chương trình.||



||
| - |
|Yêu cầu cơ bản:  - Dùng Tiếng Anh.  - Cần trả lời được các câu hỏi ở mỗi bài  - Tuân thủ theo các convention code  - Thao tác với dữ liệu qua Console|
|Kiến thức liên quan|
|- Biến, các kiểu dữ liệu trong java.  - Kiểu primitive, Wrapper|
|Access modifier trong java|
|- Constructor  - Kế thừa   + Từ khoá this, super|
||
|Mảng trong java|
|Non-access modifier: final|
|Non-access modifier: static|
||
||
||
|Collection trong java|
|Enum trong java|
||
|Map|
||
||


|||
| - | :-: |
|Link lý thuyết L0: https://docs.google.com/spreadsheets/d/13AuZw\_BD62FRsz-aIoUPA\_hT3UvL2cF9gaFo71RMY64/edit?pli=1#gid=582151293|94\.5|
|Câu hỏi cần trả lời|Thời gian dự kiến (giờ)|
|- Có nhiều kiểu dữ liệu về số -> Với Id là số dương nên chọn kiểu dữ liệu nào? Tại sao?  (Tương tự với các trường dữ liệu khác) - Với những trường dữ liệu không bắt buộc -> Có thể trống thì để kiểu dữ liệu nào?|8|
|- Tại sao cần khai báo access modifier cho các trường? - Cấp độ truy cập của từng loại - bắt buộc phải nhớ !!! - Không khai báo access modifier có được không? Vì sao?|2\.5|
|- Điều gì xảy ra khi không khái báo constructer cho class? - Có những loại kế thừa nào? - Java có đa kế thừa không? Vì sao?|8|
|Phương thức toString() trả về chuỗi đại diện của đối tượng. -> Tại sao không viết phương thức toString cho class nhưng vẫn in ra được class qua hàm System.out.println?|2|
|Mảng có kích thước cố định -> Điều gì xảy ra khi cố thao tác vượt quá kích thước mảng?|2|
|- final kết hợp với class, phương thức hoặc biến thì sẽ như thế nào?|2|
|Id - số dương - không trùng, tự động tăng -> Làm thế nào để đạt được điều này? -> Non-access modifier: static - Điều gì xảy ra khi dùng staic với biến, phương thức hoặc class?|16|
|Điều gì xảy ra khi tìm kiếm sinh viên theo trường thông tin không phải là id? - Ví dụ tìm kiếm theo Tên?|6|
||8|
||8|
|- Liệt kê các bất tiện gặp phải khi dùng mảng tĩnh để lưu trữ? - Hệ thống cấp bậc Collection? - Nên dùng loại Collection nào trong trường hợp này? Vì sao?|4|
||4|
||4|
|- Java triển khai như thế nào để Map có thể lưu trữ và truy xuất dữ liệu được dưới dạng key - value? - Ưu điểm của Map so với List, Queue, Set? - Nên sử dụng Map trong các trường hợp nào?|8|
||4|
||8|



||||||
| - | - | - | - | :- |
||||||
|Tài liệu tham khảo|||||
|https://openplanning.net/11571/cac-kieu-du-lieu-trong-java https://viettuts.vn/java/bien-trong-java https://www.javatpoint.com/wrapper-class-in-java|||||
|https://www.javatpoint.com/access-modifiers|||||
|https://niithanoi.edu.vn/tat-tan-tat-ve-constructor-trong-java.html https://techvidvan.com/tutorials/java-inheritance/|||||
||||||
|https://viettuts.vn/java/khai-bao-mang-trong-java|||||
|https://viettuts.vn/java/tu-khoa-final-trong-java|||||
|https://www.baeldung.com/java-static#:~:text=In%20the%20Java%20programming%20language,all%20instances%20of%20the%20class.|||||
||||||
||||||
||||||
|https://viettuts.vn/java-collection  https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html https://www.geeksforgeeks.org/java-collection-tutorial/ https://www.geeksforgeeks.org/collections-in-java-2/?ref=lbp|||||
|https://viettuts.vn/java-new-features/enum-trong-java|||||
||||||
|https://www.geeksforgeeks.org/map-interface-java-examples/?ref=lbp https://viettuts.vn/java-collection/map-trong-java|||||
||||||
|https://www.geeksforgeeks.org/java-io-tutorial/|||||


|||
| - | - |
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||

