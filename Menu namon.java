/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eric
 */
public class Menu implements Comparable<Menu> {
    
    protected String name;
    protected int price;
    protected int dish=0;
    
    
    public String getMenu(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    
    public int getdish(){
        return dish;
}
    
    public void setdish(int totaldish){
        this.dish+=totaldish;
    }
    
   //class Menu
    //get Menu name and price
    Menu(String n, int p){
        name=n;
        price=p;
    } 
    
    //normalprint
    public void print(){
    System.out.printf("Dish name: %-30s  Dish price : %d\n",name,price);
}
    @Override
    
    
    public int compareTo(Menu p){
        int comparePrice = ((Menu)p).getPrice();
        return comparePrice - this.price;
       // return new Int(this.price).compareTo(new Int(am.price));
    }
}
