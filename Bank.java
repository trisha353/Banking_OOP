package Banking;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers = new ArrayList<>(); //instance variable
    private String bankName; //instance variable
    private static int numberOfCustomers; //class variable

    public Bank(String bankName) {
        this.bankName = bankName;
    }
    
    public void addCustomer(String f, String l){
        customers.add(new Customer(f,l));
        numberOfCustomers++;
    }
    
    public int getNumberOfCustomers(){
        return numberOfCustomers;
    }
    
    public Customer getCustomer(int index){
        return customers.get(index);
    }

    public String getBankName() {
        return bankName;
    }

    public Customer findCustomerByFirstName(String firstName){
        for(Customer c : customers)
            if(c.getFirstName().equalsIgnoreCase(firstName))
                return c;
        System.out.println("Customer " + firstName + " not existing.");
        return null;
    }

    public void deleteCustomer(String firstName){
        Customer c = findCustomerByFirstName(firstName);
        if(c != null) {
            System.out.println("Deleting customer " + c.getFirstName() + " " + c.getLastName() + " from " + this.bankName + " bank.");
            customers.remove(c);
            numberOfCustomers--;
        } else
           System.out.println("Customers " + firstName + " not found.");
    }

    public void displayCustomers(){
        if (this.getNumberOfCustomers() <= 0)
            System.out.println("No customers yet.");
        System.out.println("Here the list of all customers:");
        for(Customer c : customers) {
            String str = "No account yet.";
            if (c.getAccount() != null)
                str = "Balance: " + c.getAccount().getBalance() + ".";
            System.out.println(c.getFirstName() + " " + c.getLastName() + " - " + str);
        }
    }
}
