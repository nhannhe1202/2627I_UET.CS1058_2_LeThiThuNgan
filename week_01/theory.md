# Union-Find

## Bài 1
Chọn $n = 3 \implies leader[] = [0, 1, 2]$

**Thao tác biến đổi:**
* `union(0, 1)` $\implies leader[] = [0, 0, 2]$
* `union(0, 2)` $\implies leader[] = [2, 0, 2]$

**Chứng minh mâu thuẫn:**
Chọn $i = 0, j = 1$:
* Thực tế tra cứu: $\text{find}(0) = 2$ và $\text{find}(1) = 0 \implies \text{find}(0) \neq \text{find}(1)$ $(1)$
* Logic thuật toán: Vì đã `union(0, 1)` $\implies \text{find}(0) = \text{find}(1)$ $(2)$

Từ $(1)$ và $(2)$ $\implies 2 = 0$ (Mâu thuẫn). **Vậy cách cài đặt này sai.**

---

## Bài 4

Các giá trị `parent[8]` có thể nhận là: 0, 4, 8.

**Giải thích:**
Thuật toán *Weighted Quick Union* luôn thực hiện nối *Gốc với Gốc* và cây có kích thước *nhỏ hơn trỏ vào cây lớn hơn*.

Từ mảng `parent[]`, ta xác định được cấu trúc các cây hiện tại:
* Cây gốc 0: kích thước 4 (gồm {0, 1, 2, 3})
* Cây gốc 4: kích thước 4 (gồm {4, 5, 6, 7})
* Nhóm của 8: kích thước 2 (gồm {8, 9}), trong đó *8 là gốc*.

**Xét các trường hợp hợp lệ cho `parent[8]`:**
* `parent[8] = 8`: Cây gốc 8 đứng độc lập độc lập (chưa `union` với cây khác).
* `parent[8] = 0`: Cây gốc 8 (size 2) `union` vào cây gốc 0 (size 4). Gốc nhỏ trỏ vào gốc lớn (Hợp lệ).
* `parent[8] = 4`: Cây gốc 8 (size 2) `union` vào cây gốc 4 (size 4). Gốc nhỏ trỏ vào gốc lớn (Hợp lệ).

**Tại sao các giá trị khác (như 5) không được?**
* Không phải gốc: Số 5 không phải là gốc (gốc của nó là 4). Phép `union` chỉ cho phép gốc trỏ vào gốc, không thể trỏ vào nút trung gian.

---