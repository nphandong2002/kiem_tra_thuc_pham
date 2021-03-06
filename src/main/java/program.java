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
                 System.out.println("Ng??y s???n xu???t kh??ng ???????c nh??? h??n h???n s??? d???ng: ");
                 return true;
             }
        }
        public  boolean ktrahsd(){
            Date today = new Date();
            today.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String st = simpleDateFormat.format(today);
            if (this.getHsd().compareTo(today) < 0) {
                System.out.println("H??m nay l?? ng??y " + st + ", h??ng h??a ???? h???t h???n ");
                return  false;
            }else {
                System.out.println("H??m nay l?? ng??y " + st + ", h??ng h??a v???n c??n h???n ");
                return true;
            }
        }
        public String show(){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String str1 = simpleDateFormat.format(nxs);
            String str2 = simpleDateFormat.format(hsd);
            return "Th??ng tin v??? th???c ph???m: \n" +
                    "M?? h??ng : " + id +
                    "\nT??n h??ng : " + name +
                    "\n????n gi?? : " + price +
                    "\nNg??y s???n xu???t : " + str1 +
                    "\nH???n s??? d???ng : " + str2
                    ;
        }



    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        hanghoa hh = new hanghoa();
        System.out.println("Nh???p m?? h??ng : ");
        hh.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nh???p t??n h??ng : ");
        hh.setName(scanner.nextLine());
        do{
            System.out.println("Nh???p ????n gi?? : ");
            hh.setPrice(scanner.nextInt());
        }while (hh.ktGiaTien(hh.getPrice()));
        do {
            System.out.println("Nh???p n??m,th??ng,ng??y s???n xu???t : ");
            hh.setNSX(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            System.out.println("nh???p n??m,th??ng,ng??y h???t h???n : ");
            hh.setHSD(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }while (hh.ktNgay());
        System.out.println(hh.show());
        hh.ktrahsd();
    }
}
