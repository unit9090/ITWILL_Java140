package edu.java.class08;

public class ClassMain08 {

    public static void main(String[] args) {
    	Account acc1 = new Account(1000, 50000);
    	acc1.printInfo();
    	
    	Account acc2 = new Account(1001, 20000);
    	acc2.printInfo();
    	
    	// 2000원 입금
    	acc1.deposit(2000);
    	acc1.printInfo();
    	
    	// 3000원 출금
    	acc1.withdraw(3000);
    	acc1.printInfo();
    	
    	// 5000원 이체
    	acc1.transfer(acc2, 5000);
    	acc1.printInfo();
    	acc2.printInfo();
    }

}
