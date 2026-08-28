fun main () {
    // B1
    /*
    - Named parameter là một cách gọi hàm khi cho phép developer gọi hàm với các tham số không cần
    theo thứ tự đã khai báo, bằng cách gọi tên chính xác tham số và gán cho một giá trị.
    - Nếu không cung cấp tên tham số mà chỉ truyền value thì hàm sẽ nhận tham số theo đúng thứ tự đã khai báo.
        => createPlayerProfile(7, "orz") -> ❌
        => createPlayerProfile("orz", 7) -> ✅
    - Nếu hàm trả về giá trị là một số nguyên thì phần khai báo hàm cần viết thêm kiểu giá trị trả về và có return để trả giá trị.
    - Kiểu Unit đại diện cho hàm thực hiện hành động nhưng không trả về giá trị để sử dụng, tương tự void trong java.
     */
    createPlayerProfile(level = 7, username = "orz")
    println(createPlayerProfile2(level = 7, username = "orz"))

    // B2
    /*
    - Hàm có thể có nhiều hơn một default param.
    - Default param không nhất định phải là last param. Nó có thể ở bất cứ vị trí nào trong danh sách các tham số.
    */
    greetPerson(name = "orz")
    greetPerson(name = "orz", greeting = "Good morning! ")

    //B3
    /*
    - Nếu lambda chỉ có một tham số thì không cần khai báo tham số vì lambda có tham số mặc định ‘it’ đại diện cho tham số đó.
    - Không cần phải viết return để trả về giá trị trong một biểu thức lambda. Dòng code cuối cùng của lambda chính là giá trị được tự động trả về.
    */
    val sum = sumOfTwoInt(4, 7)
    println("Sum of 4 and 7: $sum")

    // B4
    /* Khi viết hàm mới nên để tham số lambda là last param trong danh sách param vì Kotlin có cấu trúc trailing lamda
    giúp tạo DSL-style code, giúp code gọn gàng và dễ đọc hơn.
    */
    val result = buildString {
        append("Hello ")
        append("World")
    }
    println(result)
}

// B1
fun createPlayerProfile(username: String, level: Int) {
    println("$username: $level")
}

fun createPlayerProfile2(username: String, level: Int): String {
    return "$username: lv$level"
}

// B2
fun greetPerson(message: String = "Hello, ", name: String) {
    println("$message$name.")
}

fun greetPerson(greeting: String = "Hello, ", name: String, message: String = "Welcome to Kotlin world!") {
    println("$greeting$name. $message")
}

// B3
val sumOfTwoInt = {x: Int, y: Int -> x + y}