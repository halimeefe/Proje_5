package Mortgage;


public class HousePrices extends Users {
    public HousePrices(String username, String whichCondtiton, String houseType, int roomCount, int downPayment, int longTerm, StatesTax statesTax) {
        super(username, whichCondtiton, houseType, roomCount, downPayment, longTerm,statesTax);
    }


      /*

        HousesPrices class inin sadece bir attribute u vardir ve private dır, bu int sınıfından olmalıdır,
    değişken adına "price" diyebilirsiniz.

     */

    private int price;
    

   private void PriceTotal(int price){
    this.price=price;


    /*

        Bir constructor tanimlayalim, ebeveyn sinifin tüm attributelarini parametresinde alsın ve super anahtari ile
    eşitleyebilsin.

    Daha sonra ise satilacak evin ücretlerini hesaplamamiz icin gerekli methodlari da constructor icerisinde calistirmaliyiz.

    Ücreti hesaplarken evdeki oda sayisina, ev tipine, vb. göre ayarliyacağız. Yani... suanlik ücreti hesaplama methodlarimizi yazalim ve
    daha sonra constructor icerisinde calistiralim.


    --------------

    Eğer ki tüm hesaplama methodlarini ayarladiysaniz, constuctor icerisinde sırasıyla calistirmai unutmayin...

    ipucu = vergi hesaplama methodunu en başta calistirirsaniz, hesabiniz doğru bir şekilde olmayacaktır...

     */

       //--------------------------------------------------------------
       // ->Constructor
       //--------------------------------------------------------------



       //    Evdeki ücreti belirlerken oda sayisina dikkat etmeliyiz.
//    Bunun icin roomCountToPrice() adinda bir method oluşturalim
//            - Return tipi void
//            - Parametre almiyacak
//    Bu method icerisindeki tanimlamalarimiz su sekilde olmalidir

//       (int roomCount attribute u burada kullanılacak)
//       -Eğer 0 odaya sahipse ev ücreti 10000 artmalı,
//               - 1 oda icin 20000 artmalı
//               - 2 oda icin 30000 artmalı
//               - 3 oda icin 40000 artmalı
//               - 4 oda icin 50000 artmalı
//               - 5 oda icin 60000 artmalı
//
//               */

       //--------------------------------------------------------------
       // -> Method
       //--------------------------------------------------------------

   }
   public void roomCountToPrice(){
    if (getRoomCount()==1 ){
        price+=20000;

    } else if (getRoomCount()==2) {
        price+=30000;

    } else if (getRoomCount()==3) {
        price+=40000;

    } else if (getRoomCount()==4) {
        price+=50000;

    }else if (getRoomCount()==5) {
        price+=60000;

    }else if (getRoomCount()==6) {
        price+=70000;

    } else if (getRoomCount()==0) {
        price+=10000;

    }

 }

 /*

        Öncelikle conditionToPrice() adinda bir method acalim,
            - Return tipi void
            - Parametre olmayacak

     Bu methodun amacina gelirsek... Evin bir kondisyonu olmalı, yani kaç yıllık olduğu gibi bir değer verilmeli...

    (String whichCondition attribute'u burada kullanilacak.)
    Fakat burada farkli bir şekilde yapacağız.
        -Eğer ki evin kondisyonu "new" ise, ücreti 50000 artacak,
        -Eğer ki evin kondisyonu "like new" ise, ücreti 40000 artacak,
        -Eğer ki evin kondisyonu "old" ise, ücreti 30000 artacak,
        -Eğer ki evin kondisyonu "renew required" ise, ücreti 15000 artacak

     */

    //--------------------------------------------------------------
    // -> Method
    //--------------------------------------------------------------

    public void conditionToPrice() {

    if (getWhichCondtiton().equalsIgnoreCase("new")) {
        price+=50000;

    } else if (getWhichCondtiton().equalsIgnoreCase("like new")) {
        price+=40000;

    }else if (getWhichCondtiton().equalsIgnoreCase("old")) {
        price+=30000;

    }else if (getWhichCondtiton().equalsIgnoreCase("renew required")) {
        price+=15000;

    }

}


/*
        Evin tipine göre de bir hesaplama methodumuz olmalı... Bu methoda ise houseTypeToPrice() adini verebiliriz.
            - Return tipi void
            - Parametre kullanılmayacak

        (String houseType attribute u burada kullanılacak)
            - Eğer ki evin tipi "apartment" ise ücreti 20000 artacak,
            - Eğer ki evin tipi "condo" ise ücreti 30000 artacak,
            - Eğer ki evin tipi "house" ise ücreti 40000 artacak

     */

    //--------------------------------------------------------------
    // -> Method
    //--------------------------------------------------------------
    public void houseTypeToPrice() {

        if (getHouseType().equalsIgnoreCase("Apartment")) {
            price+=20000;

        } else if (getHouseType().equalsIgnoreCase("condo")) {
            price+=30000;

        } else if (getHouseType().equalsIgnoreCase("house")) {
            price+=40000;

        }

    }

      /*

        Vergiyi hesaplayan bir method yazalım adi calculateTax() olabilir.
        -Return tipi yok
        -Parametre olmayacak

        vergiyi bulmanın formulü = (toplam para * vergi miktari) * 100

       */


 public void calculateTax() {

 }

  /*

        Ücreti döndüren basit bir getter method yazalim cünkü price attribute un access i private.

    */

    //--------------------------------------------------------------
    // -> Method
    //--------------------------------------------------------------
    public int getPriceTotal() {
        this.roomCountToPrice();
        this.conditionToPrice();
        this.houseTypeToPrice();


        price=price+((price*getStatesTax().getTax())/100);

        return price;
    }


    /*

        Toplam ay başına düşen ücreti hesaplamak icin bir method yazmalıyız. Adina getPriceEachMonth() diyebiliriz.
        -Return tipi int olmalıdır.
        -Parametreye gerek yok.


        Ay başına düşen toplam ücret hesaplanirken, int longTerm yani vade süresine bölmeliyiz, tabi onden önce de
        peşinati ana paradan cikarmayi unutmayalim... (peşinat = downPayment)

    */
    //--------------------------------------------------------------
    // -> Method
    //--------------------------------------------------------------
    public int getPriceEachMonth() {
    int a=price;
    int b =getDownPayment();
    int c = getLongTerm();
    int d=(a-b)/c;


    return d;
}
  

  
}




