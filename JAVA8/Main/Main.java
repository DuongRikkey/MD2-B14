package JAVA8.Main;

import JAVA8.RA.inf.Animals;
import JAVA8.RA.inf.IOFILE;
import JAVA8.RA.model.Calculator;
import JAVA8.RA.model.Person;
import JAVA8.RA.model.Student;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println( s1.sum(2,3));
        //Các lớp triển khai interface có thể kế thừa hoặc ghi đè hoặc sử dụng các phương thức mặc định
        IOFILE.printf();
        //lớp nặc danh chỉ có thể sử dụng 1 lần duy nhất
//        IOFILE iofile=new IOFILE() {
//            @Override
//            public void inputData() {
//
//            }
//
//            @Override
//            public void displayData() {
//
//            }
//        }


//        Animals animals=new Animals() {
//            @Override
//            public void move() {
//
//            }
//        };
        //Vì functional interface Animals chỉ có duy nhất 1 phương thức trừu tượng nên có thể khai báo ArrowFunction
        Animals animals=(s)-> "heeeê";
        //Biểu thức lamda phải có dạng tương tự phương thức trừu tượng duy nhất của Functional Interface

        List<Student> studentsList= Arrays.asList(new Student(1,"HEEE",12),new Student(2,"HEEE",103),new Student(3,"HEEE",55),new Student(4,"HEEE",66));
        Comparator<Student> comparator=(o1,o2)->o1.getAge()-o2.getAge();
        Collections.sort(studentsList,comparator);
        Collections.sort(studentsList,Comparator.comparing(Student::getAge));
        System.out.println("TUOI TANG DAN");
        System.out.println(studentsList);
        // khơi tạo đối tượng Calculator
        Calculator cal=new Calculator();
        //4 loại funcitonal Interface
        //Consumer: void accept(T t)
        Consumer<Integer> consumer=(t)-> {
            System.out.println(t);
        };
        //Function: R apply(T t)
        //Chuyển đổi từ student sang người chỉ lấy mỗi tên người
        Function<Student, Person> function=(s)->new Person(s.getName());
        //Predicate: boolean test(T t)
        //trả về đúng sai
        //v đại diện cho student
        Predicate<Student> predicate=cal::isEnoughThan18;
        //Supplier: T get();
        Supplier<Integer> supplier=()->new Random().nextInt(50)+50;
        //-------------------Stream Api------------------
        //Là một tinh năng cho phép duyệt qua lần lượt các phần tử danh sách, hoặc mảng, hoặc luồng đầu vào mà ko thay đổi nguổn ban đâu
        //Các thành phần trong Stream
        //soure: tài nguyên sử dụng trong stream bất biến
        //Các thao tác trung gian: là các thao tác trả về một Stream mới và có thể thức hiện các thao tác khác ví dụ: filter,sort,map,sorted,limit
        //Các thao tác đầu cuói: không trả về Stream mà trả về 1 giá trị hoặc không trả về VD: forEach,sum,collect

        //BT1:HAY TINH TONG CUA MANG
        int []A={1,2,3,4,5,6,7,8,9};
        // ỨNG DỤNG STREAM
        int sum= Arrays.stream(A).sum();
        System.out.println("Sum "+sum);
        //Hàm tích giá trị theo phép toán trả về lũy reduce
        int reduce= Arrays.stream(A).reduce(1,(multi,currentvalue)->multi*currentvalue);
        System.out.println(reduce);

        //ứng dụng:
        // lọc dữ liệu
        List<String> names=Arrays.asList("Duong","Dinh","Dai","Hai","Tuan","Tu");
        //hãy lọc và đếm xem có bao nhiêu học sinh có chữ D đầu tiên
//        List<String> listSearch=names.stream().filter(str->str.startsWith("D")).collect(Collectors.toList());
//        System.out.println(listSearch);
        //long vì dữ liệu nó lớn
         long count = names.stream().
                 filter(str->str.startsWith("D")).// lọc các phần tử ký hiệu D
                 count();// Đếm số lượng xuất hiện
         System.out.println(count);
         // sử dụng Consumer nhận vào đối tượng T và ko làm gì hết
        //hãy in ra các tên ký tự h trong tên dưới dạng in hoa
        // forEach thuộc về List
        names.forEach(s ->{ //duyệt qua từng phần tử trong list
            if(s.toLowerCase().contains("d"))
        {
            System.out.println(s.toUpperCase());
        }
        }
        );
        // Function hãy chuyển đổi danh học sinh thm 1 danh sách người
        // chuyển đổi đối tượng phải dùng map
        List<Person> personList=studentsList.stream()//chuyển danh sách thành 1 stream mới
                .map(s->new Person(s.getName()))// tạo ra stream mới gồm những đối tượng Person có tên là tên học sinh
                .collect(Collectors.toList());//Chuyển stream thành danh sách
        System.out.println(personList);
        //Hãy tạo 1000 số ngẫy nhiên từ 1-9999; ko trùng lặp
        //        Supplier ko nhận vào gì hết nhưng trả về 1 đối tượng
        //distinct loại bỏ phần tử trung lap
        // lấy số lượng giới hạn phần tử
        //    collect(Collectors.toList()) chuyển stream thành 1 danh sách
        //        sorted((a,b)->b-a) sắp xếp theo chiều giảm dần
        Random rand=new Random();
        List<Integer> randomInt=Stream.generate(()->rand.nextInt(9998)+1).distinct().limit(1000).sorted(Calculator::minus).collect(Collectors.toList());
        System.out.println(randomInt);
        System.out.println(randomInt.size());
        // tạo danh sách người từ danh sách tên (method reference)
        List<Person> people=names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(people);

        //Date time: - ngày tháng, giờ
        LocalDate localDate= LocalDate.now();//thời gian hiện tai
        LocalDate localDate1=localDate.of(1945,9,2);
        System.out.println("Ngay hnay"+localDate);
        System.out.println("Ngay hnay"+localDate1);

        //Ngày quốc khánh 100 năm sau sử dụng ChronoUnit phải tạo đối tượng mới nó ko ghi đè
//        LocalDate localDate2=localDate1.plus(100, ChronoUnit.YEARS);
//        System.out.println("Ngày quốc khánh 100 năm sau"+localDate2);
//        LocalTime localTime=LocalTime.now();
//        System.out.println(localTime);
//        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("hh:mm:ss");
//        System.out.println(LocalTime.now().format(dateTimeFormatter));

//        //Lấy ngày tháng năm và giờ phút giây
//        LocalDateTime localDateTime=LocalDateTime.now();
//        System.out.println(localDateTime);
//        System.out.println(localTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
//        //ep tu 1 chuoi ve ngay thang nam
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate date = LocalDate.parse("28-07-2001", formatter);
//        System.out.println(date);
//        // Zoned đại diện cho múi giờ trên thế giới
//        ZonedDateTime zonedDateTimeJapan= ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
//        System.out.println("Ngày giờ của Tokyo"+zonedDateTimeJapan);



        //Optional kiểm tra xem đối tượng có null hay ko dùng để xử lý null
        //1. isPresent: kiểm tra optional có null không
        //2. ifPresent: xử lý khi optinal khác null
        //3. orElse(), orElseThrow(), xử lý các trường hợp khác

        //cho danh sách số nguyên
        int[] intArr={1,3,111,11,31};
        //hãy tính tổng các số chẵn nếu ko có số chẵn nào thì trả về ko
        OptionalInt optionalInt=Arrays.stream(intArr).filter(a->a%2==0).reduce((total,current)->total+current);
        int sumEven=optionalInt.orElse(0);// trả về tổng nếu tồn tại phần tử chẵn
        System.out.println(sumEven);


    }
}
