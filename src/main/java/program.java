import com.sun.istack.internal.NotNull ;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class program {
     public  static   class hanghoa{
        @NotNull
        private int id ;
        @NotNull
        private String name;
        @NotNull

        private  int price;
         @NotNull
         private Date nxs,hsd;

         public int getId() {
             return id;
         }

         public void setId(int id) {
             this.id = id;
         }

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public int getPrice() {
             return price;
         }

         public void setPrice(int price) {
             this.price = price;
         }

         public Date getNxs() {
             return nxs;
         }

         public void setNxs(Date nxs) {
             this.nxs = nxs;
         }

         public Date getHsd() {
             return hsd;
         }

         public void setHsd(Date hsd) {
             this.hsd = hsd;
         }
         public  hanghoa(){

        }
         public hanghoa(int id, String name, int price, Date nxs, Date hsd){
             this.id = id;
             this.name = name;
             this.price = price;
             this.nxs = nxs;
             this.hsd = hsd;
        }

        public boolean ktGiaTien(int price){
             if(price < 0 ) {
                 System.out.println("Gia tien phai lon hon 0 ");
                 return true;
             }
             return  false;
        }
         public void setNSX(int year, int month, int day) {
             Calendar calendar = Calendar.getInstance();
             calendar.set(year, month - 1, day);
             this.nxs = calendar.getTime();
         }
         public void setHSD(int year, int month, int day) {
             Calendar calendar = Calendar.getInstance();
             calendar.set(year, month - 1, day);
             this.hsd = calendar.getTime();
         }
        public boolean ktNgay(){
             if(this.getNxs().compareTo(this.hsd) < 0){
                return false;
             }else {
                 System.out.println("Ngày sản xuất không được nhỏ hơn hạn sử dụng: ");
                 return true;
             }
        }
        public  boolean ktrahsd(){
            Date today = new Date();
            today.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String st = simpleDateFormat.format(today);
            if (this.getHsd().compareTo(today) < 0) {
                System.out.println("Hôm nay là ngày " + st + ", hàng hóa đã hết hạn ");
                return  false;
            }else {
                System.out.println("Hôm nay là ngày " + st + ", hàng hóa vẫn còn hạn ");
                return true;
            }
        }
        public String show(){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String str1 = simpleDateFormat.format(nxs);
            String str2 = simpleDateFormat.format(hsd);
            return "Thông tin về thực phẩm: \n" +
                    "Mã hàng : " + id +
                    "\nTên hàng : " + name +
                    "\nĐơn giá : " + price +
                    "\nNgày sản xuất : " + str1 +
                    "\nHạn sử dụng : " + str2
                    ;
        }



    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        hanghoa hh = new hanghoa();
        System.out.println("Nhập mã hàng : ");
        hh.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập tên hàng : ");
        hh.setName(scanner.nextLine());
        do{
            System.out.println("Nhập đơn giá : ");
            hh.setPrice(scanner.nextInt());
        }while (hh.ktGiaTien(hh.getPrice()));
        do {
            System.out.println("Nhập năm,tháng,ngày sản xuất : ");
            hh.setNSX(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            System.out.println("nhập năm,tháng,ngày hết hạn : ");
            hh.setHSD(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }while (hh.ktNgay());
        System.out.println(hh.show());
        hh.ktrahsd();
    }
}
