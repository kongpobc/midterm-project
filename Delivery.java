
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

// Returns true if s is a number else false 



public class Delivery {

    public static int main(String[] args) {
        // TODO code application logic here

        int count = 0;
        Menu[] menu = new Menu[5];
        boolean correct_mfile = true;
        boolean correct_file = true;

        do {
            try {
                System.out.println("1) Please enter the menu file name: ");
                Scanner input = new Scanner(System.in);
                File file = new File(input.nextLine());
                input = new Scanner(file);
                
                
                int order_count = 0; // counter
                int temp;

                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] buffer = line.split(",");

                    //send viable to menu
                    String menu_name = buffer[0];
                    int menu_price = Integer.parseInt(buffer[1].trim());
                    
                    for(int i=0;i<5;i++) 
                        {
                
                        String [] buf = line.split(",");
                
                
                        String menu1 = buf[0];
                        int price1  = Integer.parseInt(buf[1].trim());
                
                        String menu2 = buf[2];
                        int price2  = Integer.parseInt(buf[3].trim());
                
                        String menu3 = buf[4];
                        int price3  = Integer.parseInt(buf[5].trim());
                
                        String menu4 = buf[6];
                        int price4  = Integer.parseInt(buf[7].trim());
                
                        String menu5 = buf[8];
                        int price5  = Integer.parseInt(buf[9].trim());
                        }
                    
                    
                    //put the name/price to menu 
                    // but how to put in buff and can use in the processorder?
                    menu[order_count] = new Menu(menu_name, menu_price);
                     
                   
                    
                    temp = menu_price;
                    if (temp<=0) {
                    } else {
                        count = order_count;
                    }
                    order_count++;

                }
                correct_mfile = false;
                input.close();

            } catch (Exception e) {
                System.out.println("file not found");
                
                System.err.println(e);
            }
        } while (correct_mfile);
        
        
        

        do {
            try {
                System.out.println("2) Please enter the order file name: ");
                Scanner input = new Scanner(System.in);
                File file = new File(input.nextLine());
                input = new Scanner(file);
                
                //create the first customer 
                ArrayList<Customer> Customerlist = new ArrayList<Customer>();
                int check1 = 0;
                int check2 = 0;
                

                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] buffer = line.split(",");
                    String customer_name = buffer[0];
                    /*int order1 = Integer.parseInt(buffer[1].trim());
                    int order2 = Integer.parseInt(buffer[2].trim());
                    int order3 = Integer.parseInt(buffer[3].trim());
                    int order4 = Integer.parseInt(buffer[4].trim());
                    int order5 = Integer.parseInt(buffer[5].trim());*/
                    int [] order = new int[buffer.length-1];
                    for(int j=1; j<buffer.length;j++)
                    { order[j-1] = Integer.parseInt(buffer[j].trim());
                    
                    int x=0;
                    if(order[j-1]>=0){
                        return 1;
                    } else order[j-1]=x;
                    
                    
                    boolean same_person = false;

                    //compare if customer name is the same or not
                    for (int i = 0; i < Customerlist.size(); i++) {

                        if (Customerlist.get(i).name.equalsIgnoreCase(customer_name)) {
                            same_person = true;
                            check1 = i;
                        }
                    }

                    //Show what the Customer order
                    if (same_person) {

                        System.out.printf("\n%7s >> order\n %s %d \n%s %d\n %s %d\n %s %d\n %s %d\n",
                                customer_name,
                                menu[0].getMenu(), order[0],
                                menu[1].getMenu(), order[1],
                                menu[2].getMenu(), order[2],
                                menu[3].getMenu(), order[3],
                                menu[4].getMenu(), order[4]
                        );
                        
                        
                        //send viable to Customer java
                        Customerlist.get(check1).processOrder(order[0], menu[0].getPrice(),
                                order[1], menu[1].getPrice(),
                                order[2], menu[2].getPrice(),
                                order[3], menu[3].getPrice(),
                                order[4], menu[4].getPrice(),
                                count, menu);

                    } //False 
                    
                    
                    
                    else {
                        
                        //Create new Array list, show  Customer order
                        Customerlist.add(new Customer(customer_name));
                        System.out.printf("\n%7s >> order\n %s %d\n %s %d\n %s %d\n %s %d\n %s %d\n",
                                 customer_name,
                                menu[0].getMenu(), order[0],
                                menu[1].getMenu(), order[1],
                                menu[2].getMenu(), order[2],
                                menu[3].getMenu(), order[3],
                                menu[4].getMenu(), order[4]
                        );
                        
                        //send viable to Customer java
                        Customerlist.get(check2).processOrder(
                                order[0], menu[0].getPrice(),
                                order[1], menu[1].getPrice(),
                                order[2], menu[2].getPrice(),
                                order[3], menu[3].getPrice(),
                                order[4], menu[4].getPrice(),
                                count, menu);
                        check2++;
                    }
                }
                }
                System.out.print("==== Customer summary ====\n");
                
                //print all of list in customer.
                Collections.sort(Customerlist);

                
                for (int ct = 0; ct < Customerlist.size(); ct++) {
                    System.out.printf("%s point = %7d\n",
                            Customerlist.get(ct).getName(),
                            Customerlist.get(ct).getPoint());
                }

                System.out.print("\n\n==== Menu summary ====\n");
                
                //print all of list in Arrays.
                Arrays.sort(menu);

                for (int ct = 0; ct < menu.length; ct++) {
                    System.out.printf("%-22s price = %4d total delivery = %3d\n",
                            menu[ct].getMenu(),
                            menu[ct].getPrice(),
                            menu[ct].getdish());
                }
                correct_file = false;
                input.close();

            } catch (Exception e) {
                System.out.println("file not found");
                
                System.err.println(e);
            
            }
            
            

            //Exercise 6//
        } while (correct_file);
        return 0;

    }
}