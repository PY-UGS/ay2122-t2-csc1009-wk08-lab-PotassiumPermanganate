package com.T8;

import java.util.Scanner;

public class CheckingAccount {

    private double balance;
    private int number;

    public static void main(String[] args) {

        // Dummy checking account
        CheckingAccount checkingAccount = new CheckingAccount();
        Scanner scanner = new Scanner(System.in);
        double buffer;

        System.out.print("How much would you like to deposit: ");
        buffer = scanner.nextDouble();
        try {
            checkingAccount.deposit(buffer);
        }catch (IllegalArgumentException e) {
            System.out.println("Deposit amount invalid");
        }

        System.out.print("How much would you like to withdraw: ");
        buffer = scanner.nextDouble();
        try {
            checkingAccount.withdraw(buffer);
        } catch (InsufficientFundsException e) {
            System.out.println("Sorry, but your account is short by: $" + (e.getAmount() - checkingAccount.getBalance()));
        } catch (IllegalArgumentException e) {
            System.out.println("Withdrawal amount invalid");
        }

    }

    public void deposit(double amount) throws IllegalArgumentException{
        if (amount <= 0) throw new IllegalArgumentException();
        this.balance = amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException, IllegalArgumentException{
        if (this.balance < amount) throw new InsufficientFundsException(amount);
        if (amount <= 0) throw new IllegalArgumentException();
        System.out.println("The balance after withdraw is: $"+ (this.balance - amount));
    }

    public double getBalance() {
        return balance;
    }

    public int getNumber() {
        return number;
    }
}
