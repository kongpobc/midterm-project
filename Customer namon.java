import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eric
 */
public class Customer implements Comparable<Customer>{
    Customer(String n){
        this.name=n;
//        this.array=array_in;
    }
    
    
    protected String name;
    protected int point;
    protected int [] array = {0,0,0,0,0};
    protected void processOrder(int menu1, int price1,int menu2, int price2, int menu3, int price3,int menu4, int price4, int menu5, int price5,int cheap, Menu [] menu){
        array[0]+=menu1;
        array[1]+=menu2;
        array[2]+=menu3;
        array[3]+=menu4;
        array[4]+=menu5;
        menu[0].setdish(menu1);
        menu[1].setdish(menu2);
        menu[2].setdish(menu3);
        menu[3].setdish(menu4);

        int order_bill = array[0]*price1+array[1]*price2+array[2]*price3+array[3]*price4+array[4]*price5;
        menu[4].setdish(menu5+order_bill/1000);       
        
        
        int points = (int)(order_bill*0.1+0.5);
        
        
               this.point=(points);
               
               System.out.printf("\n\norder bill = %6d, current points = %5d, free %s = %2d\n",
                       order_bill,points,menu[cheap].getMenu(),order_bill/1000);

               /*               for(int z=0;z<menu.length;z++){
                    menu[z].set_total_dish((char)(z+i*2));          
    }*/
               
               
               
               int currentpt=point-500;
               if(point>499){
                   System.out.printf("final bill = %6d current points = %5d \n\n\n", (int)(order_bill*0.95+40), currentpt);
               }
               else{
                   System.out.printf("final bill = %6d current points = %5d \n\n\n", (int)(order_bill+40), point);
               }
    }
    
    
    public void setPoint(int p){
        this.point=p;
    }
    
    public int getPoint(){
        return point;
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public int compareTo(Customer am){
        int comparepoint=((Customer)am).getPoint();
        return comparepoint-this.point;
    }
}
