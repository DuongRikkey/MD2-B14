package JAVA8.RA.inf;

public interface IOFILE {
    void inputData();//nhập vào dữ liệu
    void displayData();//in ra dữ liệu
    //sinh ra phương thức mặc định các lớp con ko cần ghi đè mà chỉ khi cần mới phải ghi đè nó ra
//    default void printf() {
//
//    }
    //phương thức mặc định
    default int sum(int a, int b) {
        return a + b;
    }
    //phương thức tĩnh của interface ko cho các lớp con(triển khai khai và sử dụng phhương thức này)
    static void printf() {
        System.out.println("hhi");
    }


}
