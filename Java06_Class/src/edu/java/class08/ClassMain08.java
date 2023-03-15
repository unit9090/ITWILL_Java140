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
    	
    	/* 강사님 */
    	// 계좌 생성
    	AccountTeacher account1 = new AccountTeacher(123456, 10000);
    	// 계좌 정보 출력
    	account1.printInfo();
    	
    	double balance = account1.deposit(1000);	// 1,000원 입금
    	System.out.println("잔액: " + balance);	// 입금 후 잔액
    	account1.printInfo();
    	
    	account1.withdraw(5000);	// 5,000원 출금
    	account1.printInfo();
    	
    	AccountTeacher account2 = new AccountTeacher(123000, 10000);
    	account2.printInfo();
    	
    	// account1 계좌에서 account2 계좌로 5,000원을 이체
    	account1.transfer(account2, 5000);
    	account1.printInfo();
    	account2.printInfo();
    }

}
