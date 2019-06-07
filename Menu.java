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
    protected int total_dish=0;
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public void set_total_dish(int td){
        this.total_dish+=td;
    }
    public int get_dish(){
        return total_dish;
}
   
    Menu(String n, int p){
        this.name=n;
        this.price=p;
    } 
    public void print(){
    System.out.printf("Dish name : %-30s  Dish price : %d\n",name,price);
}
    @Override
    public int compareTo(Menu am){
        int comparePrice = ((Menu)am).getPrice();
        return comparePrice - this.price;
       // return new Int(this.price).compareTo(new Int(am.price));
    }
}
