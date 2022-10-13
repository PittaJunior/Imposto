package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuinte> list = new ArrayList<>();
		
		double totalTaxes = 0;
		
		System.out.print("Enter the number of taxpayers: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Tax payer #"+ i + " data: ");
			System.out.print("Individual or Company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			Double anualIncome = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Health Expenditures: ");
				double HealthExpenditures = sc.nextDouble();
				Contribuinte c = new PessoaFisica(name, anualIncome, HealthExpenditures);
				list.add(c);
				}
			else {
				System.out.print("Number of Employees: ");
				int numberOfEmployees = sc.nextInt();
				Contribuinte c = new PessoaJuridica(name, anualIncome, numberOfEmployees);
				list.add(c);
			}
		}
		System.out.println();
		System.out.println("TAXES PAID: ");
		for (Contribuinte c : list) {
			System.out.println(c.getName()+ ": $ "+ String.format("%.2f", c.tax()));
		}
		for (Contribuinte c : list) {
			totalTaxes += c.tax();
			}
		System.out.println();
		System.out.println("TOTAL TAXES: $ "+ String.format("%.2f",totalTaxes));
		
		sc.close();
	}

}
