package JAVA8.BaiTap;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class EX2 {
    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        System.out.println("Giờ tại America/Sao_Paulo là: "+zdt);

        ZonedDateTime zdt1 = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Giờ tại Asia/Tokyo là "+ zdt1);

        ZonedDateTime zdt2 = ZonedDateTime.now(ZoneId.of("Australia/Sydney"));
        System.out.println("Giờ tại Australia/Sydney là "+ zdt1);

        //2.Lấy thời gian hiện tại
        LocalTime time= LocalTime.now();
        System.out.println("Thời gian hiện tại"+time);
        //3. số ngày trong tháng hiện tại
        YearMonth yearMonth= YearMonth.now();
        int daysInMonth= yearMonth.lengthOfMonth();
        System.out.println("Ngày trong tháng "+daysInMonth);
        //4. số ngày trong năm hiện tại
        Year year= Year.now();
        int daysinYear=year.length();
        System.out.println("Số ngày trong năm "+daysinYear);
        //để chuyển đổi một chuỗi ngày sang một đối tượng LocalDate.
        String dateStr="28/07/2001";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dateStr, dtf);
        System.out.println("CovertDate"+localDate);

        LocalDate date = LocalDate.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateStr2=date.format(dtf2);
        System.out.println("FormatDate2 "+dateStr2);
        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dateStr3=localDateTime.format(dtf3);
        System.out.println("FormatDate3 "+dateStr3);
        //So sánh 2 localDate
        LocalDate date1 = LocalDate.of(2024, 8,29);
        LocalDate date2 = LocalDate.of(2024, 8, 30);
        int compare = date1.compareTo(date2);
        System.out.println(compare);
        //So sánh 2 h
        LocalTime time1 = LocalTime.of(10,30);
        LocalTime time2 = LocalTime.of(10,31);
        int compare1 = time1.compareTo(time2);

        System.out.println("Thời gian so sánh"+compare1);

        //Viết chương trình để thêm hoặc bớt một số ngày, giờ, phút, giây hoặc mili giây vào một ngày hoặc thời gian nhập vào.
        LocalDateTime localDateTime1 = LocalDateTime.now();
        //Thêm số ngày
        LocalDateTime newDateTime = localDateTime1.plusDays(1);
        System.out.println("After adding 1 ngày"+newDateTime);
        newDateTime = localDateTime1.minusDays(1);
        System.out.println("Bớt đi 1 ngày"+newDateTime);
        newDateTime = localDateTime1.plusHours(1);
        System.out.println("Thêm 1 giờ"+newDateTime);
        newDateTime = localDateTime1.minusHours(1);
        System.out.println("Bớt đi 1 giờt"+newDateTime);

        // tính toán ngày tiếp theo
        LocalDate today = LocalDate.now();
        LocalDate nextDay = today.plusDays(1);
        System.out.println("Next day"+nextDay);
        LocalDate periousDay = today.minusDays(1);
        System.out.println("Perious day"+periousDay);

    }
}
