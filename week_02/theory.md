# Analysis

## Bài 1

Dưới đây là kết quả phân tích số lần gọi hàm `op()`:

**1.**
* Ký hiệu tilde (~): ~ 1/2 n
* Ký hiệu Big Theta (Θ): Θ(n)

**2.**
* Ký hiệu tilde (~): ~ 3 log2(n)
* Ký hiệu Big Theta (Θ): Θ(log n)

**3.**
* Ký hiệu tilde (~): ~ 100n
* Ký hiệu Big Theta (Θ): Θ(n)

**4.**
* Ký hiệu tilde (~): ~ √n log3(n)
* Ký hiệu Big Theta (Θ): Θ(√n log n)

**5.**
* Ký hiệu tilde (~): ~ n log2(n)
* Ký hiệu Big Theta (Θ): Θ(n log n)

**6.**
* Ký hiệu tilde (~): ~ 50 n^3
* Ký hiệu Big Theta (Θ): Θ(n^3)

---

## Bài 2

**Đáp án đúng:** Chọn ô tròn thứ 4: **~ n^4 log2(n)**

---

## Bài 3

* **O(n^2)**.
* **Ω(n^2)**. 

---

## Bài 4

Mỗi nút (`Node`) trong cây tiêu thụ bộ nhớ như sau:

* *Object overhead:* 16 bytes
* *5 tham chiếu (`key`, `value`, `parent`, `left`, `right`):* 5 x 8 = 40 bytes
* *1 biến nguyên `count`:* 4 bytes
* *Tham chiếu ngầm định của inner class:* 8 bytes

**Tổng cộng:** 16 + 40 + 4 + 8 = 68 bytes
**Làm tròn lên bội số của 8 (Padding):** 72 bytes

---

## Bài 5

**Đáp án đúng:** Chọn ô tròn thứ 2: **~ 50n^2**

**Phép tính:**

1. *Hai vòng lặp ngoài (i và j):*
* Vòng lặp i chạy từ 1 đến n. Với mỗi i, vòng lặp j giảm từ n xuống i (tổng cộng chạy n - i + 1 lần). 
* Đây là cấu trúc lặp tam giác, số lần lặp tổng cộng là: ~ 1/2 * n^2

2. *Vòng lặp trong cùng (k):* 
* Vòng lặp tăng k với bước nhảy là n/100 từ 1 đến n. 
* Số lần lặp cố định là: n / (n / 100) = 100

3. *Tổng số lần in từ "hello":* 
* Nhân kết quả của các vòng lặp lại với nhau:
      (1/2 * n^2) * 100 = 50n^2

---

## Bài 6

**Đáp án đúng:** **O(n√n)**

---
