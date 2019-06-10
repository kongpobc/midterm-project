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
    
    public void dish_amount(int totaldish){
        this.dish+=totaldish;
    }

    //get Menu name and price
    Menu(String n, int p){
        name=n;
        price=p;
    } 
    
    public int compareToIgnoreCase(Menu p){
        int comparePrice = ((Menu) p).getPrice();
        return comparePrice - this.price;
    }
   
    //normalprint
    public void report(){
    System.out.printf("Dish name: %-30s  Dish price : %d\n",name,price);
}
   
    @Override
    public int compareTo(Menu o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}