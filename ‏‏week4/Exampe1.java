/**
 * in this example, we have a class WaterSource and a class Ocean that extends WaterSource.
 * The Ocean class has a method printName that prints the name of the WaterSource and the
 * name of the Ocean.
 * */
class WaterSource{
   String name="Water Source";
}

class Ocean extends WaterSource{
   String name="Ocean";

   void printName(){
       System.out.println(super.name);
       System.out.println(name);
   }
   
   public static void main(String[] args) {
       Ocean sea = new Ocean();
       sea.printName();
   }
}


