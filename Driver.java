package Banking;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args){

        Bank bk = new Bank("BCA");
        boolean run = true;
        Scanner scnr = new Scanner(System.in);

        while(run) {
            System.out.println("Welcom to " + bk.getBankName() + " bank.\nPlease choose, from 1 to 3, what you would like to do.");
            System.out.println("1. Bank Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");

            int choice = scnr.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Please choose between:");
                    System.out.println("1. Add Customer");
                    System.out.println("2. Search Customer");
                    System.out.println("3. Delete Customer");
                    System.out.println("4. Display Customers");
                    System.out.println("5. Create Account");

                    int ch = scnr.nextInt();
                    switch (ch) {
                        case 1:
                            System.out.println("Enter First Name: ");
                            String f = scnr.next();
                            System.out.println("Enter Last Name: ");
                            String l = scnr.next();
                            bk.addCustomer(f, l);
                            System.out.println("Customer " + f + " " + l + " added.");
                            break;

                        case 2:
                            System.out.print("Enter First Name: ");
                            String r = scnr.next();
                            Customer c = bk.findCustomerByFirstName(r);
                            if (c == null)
                                break;
                            c.displayAccountDetails();
                            break;

                        case 3:
                            System.out.print("Enter First Name: ");
                            String d = scnr.next();
                            bk.deleteCustomer(d);
                            break;

                        case 4:
                            bk.displayCustomers();
                            break;

                        case 5:
                            System.out.print("Enter First Name: ");
                            String name = scnr.next();
                            Customer ctm = bk.findCustomerByFirstName(name);
                            if (ctm != null) {
                                System.out.print("Put Initial Balance: ");
                                double bal = scnr.nextDouble();
                                ctm.setAccount(new Account(bal));
                                System.out.println("Account created.");
                            } else
                                System.out.println("Customer not found.");
                            break;
                    }
                    break;



                case 2:
                    if (bk.getNumberOfCustomers() <= 0){
                        System.out.println("No customers yet.");
                        break;
                    }
                    System.out.print("Enter First Name: ");
                    String name = scnr.next();
                    Customer cust = bk.findCustomerByFirstName(name);

                    if(cust == null || cust.getAccount() == null)
                        break;

                    System.out.println("Please choose a service:");
                    System.out.println("1. Balance Inquiry");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Transfer");

                    int s = scnr.nextInt();

                    switch(s) {

                        case 1:
                            System.out.println("Balance: " + cust.getAccount().getBalance());
                            break;

                        case 2:
                            System.out.print("Amount: ");
                            double dep = scnr.nextDouble();
                            cust.getAccount().deposit(dep);
                            break;

                        case 3:
                            System.out.print("Amount: ");
                            double wit = scnr.nextDouble();
                            cust.getAccount().withdraw(wit);
                            break;

                        case 4:
                            System.out.print("Transfer to (First Name): ");
                            String targetName = scnr.next();
                            Customer target = bk.findCustomerByFirstName(targetName);

                            if (target != null && target.getAccount() != null) {
                                System.out.print("Amount: ");
                                double amt = scnr.nextDouble();
                                if (cust.getAccount() == null || cust.getAccount().getBalance() < amt) {
                                    System.out.println("Balance insufficient.");
                                    break;
                                }
                                cust.getAccount().transfer(target.getAccount(), amt);
                                System.out.println("Transfering amount of " + amt + " to " + targetName);
                            } else {
                                System.out.println("Customer not found.");
                            }
                            break;

                    }
                    break;
                case 3:
                    run = false;
                    break;
            }
        }



        /*
            Simulate a simple system that would be able to do the following transactions:
        
        Bank Admin
            1. Add Customer
            2. Search Customer (by First Name)and Display Customer Details
            3. Delete a Customer
            4. Dispay customers
            5. Create an account for a customer
        
        Customer
            1. Balance Inquiry
            2. Deposit
            3. Withdraw
            4. Transfer (to a different account)
        
        [Note: program only terminates once the admin or customer quits it]
        
        Save the files in a gitHub repo and send to jude.j.l.martinez@gmail.com on or before midnight today
        */

    }
}
