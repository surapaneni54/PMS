
package com.infinira.pms.models;
import com.infinira.pms.service.ServiceUtil;
 
public class Customer{
    private  long    customerId;
	private  String  customerName;
	private  String  ProjectExecutive;
	private  String  projectManager;
	
    public  Customer(String customerName){
        if (customerName == null){
            ServiceUtil.throwException("PMS-0011", null,customerName);
        }
        this.customerName = customerName;
    } 
    
    //Getter Methods.
	public long getCustomerId(){
		return customerId;
	}
	public String getCustomerName(){
		return customerName;
	}
	public String getProjectExecutive() {
        return ProjectExecutive;
	}
	public String getProjectManager() {
		return projectManager;
	}
    
    //Setter Methods.
     
    
    public void setCustomerId(long customerId){
        if (customerId <= 0L) {
            ServiceUtil.throwException("PMS-0010", null,customerId);            
        }
		this.customerId=customerId;
	}
    
    public void setProjectExecutive(String ProjectExecutive) {
        if (ProjectExecutive == null) {
            ServiceUtil.throwException("PMS-0012", null,ProjectExecutive);
        }
        this.ProjectExecutive = ProjectExecutive;
	}
	public void setProjectManager(String projectManager) {
        if (projectManager == null) {
            ServiceUtil.throwException("PMS-0013", null,projectManager);
        }
		this.projectManager = projectManager;
	}
    public String toString() {  
        StringBuilder sb =  new StringBuilder();
        sb.append(customerId).append(":");
        sb.append(customerName).append(":");
        sb.append(ProjectExecutive).append(":");
        sb.append(projectManager).append(":");  
        return sb.toString();
    }
	
 
 }
 