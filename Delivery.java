import java.util.*;
import java.io.*;
import java.nio.file.Files;
        
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery;

/**
 *
 * @author mintn
 */
public class Delivery {
    
    public static void main(String[] args) {
        // TODO code application logic here
        
  
    Menu [] menu = new Menu[5];
    int x=0;
    
    
     int n =1;
    do{
    try{
        System.out.println("1) Please enter the menu file name: ");
         Scanner input  = new Scanner(System.in);
        File  file = new File(input.nextLine());
        input = new Scanner(file);
        int counter=0;
        int min=10000000,temp;
        
        
        while(input.hasNextLine()){
            String line = input.nextLine();
            String [] buffer = line.split(",");
            
            String menu_name = buffer[0];
            int menu_price = Integer.parseInt(buffer[1].trim());
            
            
            
            menu[counter] = new Menu(menu_name, menu_price);
           // menu[counter].print();
            temp=menu_price;
            if(min>temp){
                min=temp;
                x=counter;
            }
             counter++;
        }
        n=2;
        input.close();
        
        
    }catch (Exception e){
        System.out.println("file not found");
    }
    }while(n==1);
   
    
    
    
    int endfile=1;
   
   
   
    do{
    try{
        System.out.println("2) Please enter the order file name: ");
        Scanner input = new Scanner(System.in);
        File  file = new File(input.nextLine());
        input = new Scanner(file);
        ArrayList<Customer> Store_customer = new ArrayList<Customer>();
        int check1=0;
        int check2=0;
        
        
        while(input.hasNextLine())
        {
            String line = input.nextLine();
            String [] buffer = line.split(",");
            String order_name = buffer[0];

            boolean dul=false;
            
            //check Customer exist or not
            for(int i = 0 ;i<Store_customer.size();i++){
                if(Store_customer.get(i).name.equals(order_name)){
                dul=true;
                check1=i;
            }
            }
            
            
            //True dul
            if(dul){
            
               System.out.printf("%7s >> order %s %d %s %d %s %d %s %d %s %d\n" ,
                    order_name,
                    menu[0].getMenu(),Integer.parseInt(buffer[1].trim()),
                    menu[1].getMenu(),Integer.parseInt(buffer[2].trim()),
                    menu[2].getMenu(),Integer.parseInt(buffer[3].trim()),
                    menu[3].getMenu(),Integer.parseInt(buffer[4].trim()),
                    menu[4].getMenu(),Integer.parseInt(buffer[5].trim())
                    
                    );
            
                Store_customer.get(check1).processOrder
                (Integer.parseInt(buffer[1].trim()),menu[0].getPrice(),
                 Integer.parseInt(buffer[2].trim()),menu[1].getPrice(),
                 Integer.parseInt(buffer[3].trim()),menu[2].getPrice(),
                 Integer.parseInt(buffer[4].trim()),menu[3].getPrice(),
                 Integer.parseInt(buffer[5].trim()),menu[4].getPrice(),
                 x, menu);
          
        }
            
            
            
            
            //False Dul
            if(!dul){
               Store_customer.add(new Customer(order_name));
               System.out.printf("%7s >> order %s %d %s %d %s %d %s %d %s %d\n" 
                       ,order_name,
                       menu[0].getMenu(),Integer.parseInt(buffer[1].trim()),
                       menu[1].getMenu(),Integer.parseInt(buffer[2].trim()),
                       menu[2].getMenu(),Integer.parseInt(buffer[3].trim()),
                       menu[3].getMenu(),Integer.parseInt(buffer[4].trim()),
                       menu[4].getMenu(),Integer.parseInt(buffer[5].trim())
               
               );
               
               
               Store_customer.get(check2).processOrder(
                       
                       Integer.parseInt(buffer[1].trim()),menu[0].getPrice(),
                       Integer.parseInt(buffer[2].trim()),menu[1].getPrice(),
                       Integer.parseInt(buffer[3].trim()),menu[2].getPrice(),
                       Integer.parseInt(buffer[4].trim()),menu[3].getPrice(),
                       Integer.parseInt(buffer[5].trim()),menu[4].getPrice(),
                       x, menu);
               check2++;          
            }
        }
        
        
    
        
        
      System.out.print("==== Customer summary ====\n");
    Collections.sort(Store_customer);
    
    
    
    for(int ct=0;ct<Store_customer.size();ct++){
	System.out.printf("%s point = %5d\n",
                Store_customer.get(ct).getName(),
                Store_customer.get(ct).getPoint());
	   }
    
    
    
    System.out.print("\n\n==== Menu summary ====\n");
    Arrays.sort(menu);
    
    
    
    for(int ct=0;ct<menu.length;ct++){
        System.out.printf("%-22s price = %4d total delivery = %3d\n",
                menu[ct].getMenu(),
                menu[ct].getPrice(),
                menu[ct].get_dish());
    }      
    
    
        input.close();
        endfile=2;
        
        
        
        
    }catch (Exception e){
        System.out.println("file not found");
    }
    
    
    //Exercise 6//
    
    
    
}while(endfile==1);

        
}
}
