package com.infinira.pms.test;

import com.infinira.pms.service.PMSService;
import com.infinira.pms.models.Customer;
public class PMSTest  {

	public static void main (String args[]) {
        Customer    customer    =   new     Customer("microsoft"); 
        customer.setProjectExecutive("Bill Gates");
        customer.setProjectManager("Paul Allen");        
     
        System.out.println("\n\t======================================================");
        System.out.println("\t   Welcome to Project Management System");
        System.out.println("\t======================================================\n");
        System.out.println("\t   Creating new customer \n");
        long customerId = PMSService.getInstance().createCustomer(customer);
        System.out.println("\tSuccessfully created the '"+customer.getCustomerName()+"' customer And your customer id is "+customerId);
        
        System.out.println("\t======================================================\n\n");
        System.out.println("\t   Updating   customer \n");
        customer.setCustomerId(customerId);
        customer.setProjectManager("Allen Paul");
        int updatedCustomes=PMSService.getInstance().updateCustomer(customer);
        if(updatedCustomes==0){
            System.out.println("Failed to updated customer '"+customer.getCustomerName()+"' ");
        } else{
            System.out.println("\tSuccessfully updated customer  '"+customer.getCustomerName()+"'");
        }
        
        System.out.println("\t======================================================\n\n");
        System.out.println("\t   Removing   customer\n");
        int removeCustomer=PMSService.getInstance().removeCustomer(customerId);
        if(removeCustomer==0){
            System.out.println("Failed to remove  customer with customer Id '"+customerId+"'");
        }else{
            System.out.println("\n\t  customer with customer Id '"+customerId+"' removed Successfully!");
        }
        
    }
  

}
