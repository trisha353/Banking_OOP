package Banking;

public class Account {
    private double balance;
    
    public Account(double balance){
        if (balance > 0.0){
            this.balance = balance;
        }else{
            this.balance = 0.0;
        }
    }
    
    public double getBalance(){
        return balance;
    }
    
    public boolean deposit(double amt){
        if (amt > 0.0){
            this.balance += amt;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(double amt){
        if (amt <= this.balance){
            this.balance -= amt;
            return true;
        }
        return false;
    }

    public void transfer(Account ac, double amount){
        if(this.withdraw(amount))
            ac.deposit(amount);
    }
}
