package com.fullstack.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.fullstack.service.CustomerService;

public class CustomerController {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		CustomerService customerService = new CustomerService();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println(" Welcome to Indian Bank ");
			System.out.println("\n please enter your choice: \n 1. SignUp \n 2. SignIn \n 3. Logout");
			int ch = scanner.nextInt();
			switch (ch) {
			case 1: // SignUp
				customerService.signUp();
				break;

			case 2:// SignIn

				if (customerService.signIn()) {

					do {
						System.out.println(" Enter Your choice");
						System.out.println(" 1.deposit\n 2.withdraw\n 3.transfer\n 4.logOut");
						int choice = scanner.nextInt();
						switch (choice) {
						case 1: // Deposit
							customerService.deposit();
							break;

						case 2: // Withdraw
							customerService.withdraw();
							break;

						case 3: // Transfer
							customerService.transfer();
							break;

						case 4: // logout
							customerService.logOut();
							break;
						default:
							break;
						}
					} while (true);

				} else {
					System.out.println("Invalid Credentials plz try again!!!!!");
				}

				break;

			case 3: // logout
				customerService.logOut();

				break;

			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}
}
