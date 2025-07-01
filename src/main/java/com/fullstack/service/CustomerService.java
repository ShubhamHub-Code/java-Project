package com.fullstack.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerService {

	Connection connection = null;

	Scanner scanner = new Scanner(System.in);
	private long accNo;
	private int generatedOPT;

	public CustomerService() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub

		// db connection
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapplication?useSSL=false ", "root",
				"root");
	}

	public void signUp() throws SQLException {

		System.out.println("\n Please enter acc no, name, address, acc bal, contact number, email, & pwd: ");

		long accNumber = scanner.nextLong();

		String name = scanner.next();

		String address = scanner.next();

		double accBal = scanner.nextDouble();

		long contactNumber = scanner.nextLong();

		String email = scanner.next();

		String password = scanner.next();

		PreparedStatement preparedStatement = connection.prepareStatement(
				"insert into customer(custaccnumber, custname, custaddress, custaccbalance, custcontactnumber, custemailid, custPass)values(?, ?, ?, ?, ?, ?, ?)");

		preparedStatement.setLong(1, accNumber);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, address);
		preparedStatement.setDouble(4, accBal);
		preparedStatement.setLong(5, contactNumber);
		preparedStatement.setString(6, email);
		preparedStatement.setString(7, password);

		preparedStatement.executeUpdate();

		System.out.println("Data Inserted into DB");

	}

	public boolean signIn() throws SQLException {

		boolean flag = false;

		System.out.println("\n Please enter acc no & pwd: ");

		accNo = scanner.nextLong();

		String password = scanner.next();

		PreparedStatement preparedStatement = connection
				.prepareStatement("select * from customer where custaccnumber=? and custPass=?");

		preparedStatement.setLong(1, accNo);
		preparedStatement.setString(2, password);

		ResultSet resultSet = preparedStatement.executeQuery();

		flag = resultSet.next();

		return flag;
	}

	public void deposit() throws SQLException {

		double custAccountBalance;
		PreparedStatement preparedStatement = connection
				.prepareStatement("select custaccbalance from customer where custaccnumber=?");
		preparedStatement.setLong(1, accNo);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			custAccountBalance = resultSet.getDouble("custaccbalance");
			System.out.println("Current available Account Balance : " + custAccountBalance);
			System.out.println("Enter deposit Amount");
			double amount = scanner.nextDouble();

			custAccountBalance = custAccountBalance + amount;

			System.out.println("after Deposit account balance : " + custAccountBalance);

			PreparedStatement statement = connection
					.prepareStatement("update customer set custaccbalance=? where custaccnumber=?");
			statement.setDouble(1, custAccountBalance);
			statement.setLong(2, accNo);

			int result = statement.executeUpdate();
			if (result > 0) {
				System.out.println("customer account balance updated successfully");
			} else {
				System.out.println("Database update failed");
			}
		} else {
			System.out.println("Account balance not fetched");
		}
	}

	public void withdraw() throws SQLException {

		double custAccountBalance;
		PreparedStatement preparedStatement = connection
				.prepareStatement("select custaccbalance from customer where custaccnumber=?");
		preparedStatement.setLong(1, accNo);

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			custAccountBalance = resultSet.getDouble("custaccbalance");
			System.out.println("Current available account balance : " + custAccountBalance);
			System.out.println("enter withdraw amount");
			double amount = scanner.nextDouble();
			if (amount <= custAccountBalance) {
				custAccountBalance = custAccountBalance - amount;

				PreparedStatement stetement = connection
						.prepareStatement("update customer set custaccbalance=? where custaccnumber=?");
				stetement.setDouble(1, custAccountBalance);
				stetement.setLong(2, accNo);
				int result = stetement.executeUpdate();

				System.out.println("After withdrow available account balance : " + custAccountBalance);

				if (result > 0) {
					System.out.println("customer account balance updated successfully");
				} else {
					System.out.println("Database update failed ");
				}
			} else {
				System.out.println("insufficent Fund!!!");
			}
		} else {
			System.out.println("Account balance not found");
		}

	}

	public void transfer() throws SQLException {

		double custAccountBalance;
		int opt;
		PreparedStatement preparedStatement = connection
				.prepareStatement("select custaccbalance from customer where custaccnumber=? ");
		preparedStatement.setLong(1, accNo);

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			custAccountBalance = resultSet.getLong("custaccbalance");

			System.out.println("Current Account balance availabel : " + custAccountBalance);

			System.out.println("Enter transfer amount");
			double amount = scanner.nextDouble();

			if (amount <= custAccountBalance) {
				generatedOPT = getGenerateOPT();
				System.out.println("Generated OTP : " + generatedOPT);
				System.out.println("Enter OPT");
				opt = scanner.nextInt();

				if (opt == generatedOPT) {
					custAccountBalance = custAccountBalance - amount;
					PreparedStatement stetement = connection
							.prepareStatement("update customer set custaccbalance=? where custaccnumber=? ");
					stetement.setDouble(1, custAccountBalance);
					stetement.setLong(2, accNo);

					System.out.println("after transfer Available account balance :" + custAccountBalance);

					int result = stetement.executeUpdate();
					if (result > 0) {
						System.out.println("customer account balance updated successfully");
					} else {
						System.out.println("Database update failed ");
					}

				} else {
					System.out.println("Invalid OPT");
				}

			} else {
				System.out.println("Insufficent fund");
			}
		} else {
			System.out.println("customer Accounnt balance not available");
		}
	}

	public void logOut() {
		System.out.println("Logout successfully");
		System.exit(0);
	}

	int getGenerateOPT() {
		return (int) (Math.random() * 9000 + 1000);
	}
}
