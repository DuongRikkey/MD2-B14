package JAVA8.BaiTap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EX1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập mảng ban đầu");
        int n=Integer.parseInt(sc.nextLine());
        int[] arr=new int[n];
        Random rand=new Random();
        for (int i = 0; i < n; i++) {
            arr[i]=rand.nextInt(100)+1;

        }
        System.out.println("Mang ban dau"+ Arrays.toString(arr));
        int max=Arrays.stream(arr).max().getAsInt();
        System.out.println("So lon nhat trong mang"+max);

        System.out.println("Mời bạn nhập threshold");
        int threshold=Integer.parseInt(sc.nextLine());
        List<Integer> list1=Arrays.stream(arr).filter(a->a>threshold).boxed().collect(Collectors.toList());
        System.out.println("lỌC"+threshold+list1);


        List<Integer> list=Arrays.stream(arr).filter(a->a%2==0).boxed().collect(Collectors.toList());
        int Total=Arrays.stream(arr).reduce(0,(a,b) ->a+b);
        System.out.println("Total trong mang "+Total);
        //C2
        // int Total1=Arrays.stream(arr).reduce(0,Integer::sum);
        boolean hasEven=Arrays.stream(arr).anyMatch(a->a%2==0);
        System.out.println(hasEven);
        System.out.println("Mời bạn nhập khoảng giá trị ban đâu");
        int start=Integer.parseInt(sc.nextLine());
        System.out.println("Mời bạn nhập khoảng sau");
        int end=Integer.parseInt(sc.nextLine());
        // range(a,b)
        //a lay ca a, b thi chi lay b-1
        List<Integer> range= IntStream.range(start,end+1).boxed().collect(Collectors.toList());
        System.out.println("Bắt đầu"+start+","+end +range);


        List<String> words=Arrays.asList("Avc","def","sww","JKL");
        List<String>sorted=words.stream().sorted().collect(Collectors.toList());
        System.out.println("Sắp xếp theo tên"+sorted);

        List<String> toUpperCase=words.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Phương thức map để chuyển đổi thành chữ in hoa"+toUpperCase);




    }
}
