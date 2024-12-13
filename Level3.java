package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;

import java.util.*;
import java.util.stream.Collectors;

public class Level3 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();

		// TO DO 1: Retourner une chaîne de caractère qui contient tous les noms des employés
		String names = employees.stream()
				.map(Employee::getName) // Extract names
				.reduce("", (a, b) -> a + b); // Concatenate names

		// TO DO 2: Retourner une chaîne de caractère qui contient tous les noms des employés en majuscule séparés par #
		String namesMajSplit = employees.stream()
				.map(emp -> emp.getName().toUpperCase()) // Convert names to uppercase
				.collect(Collectors.joining("#")); // Join with #

		// TO DO 3: Retourner un set d'employés
		Set<Employee> emps = employees.stream()
				.collect(Collectors.toSet()); // Collect as a Set

		// TO DO 4: Retourner une TreeSet d'employés (tri par nom)
		TreeSet<Employee> emps2 = employees.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getName))));

		// TO DO 5: Retourner une Map qui regroupe les employés par salaire
		Map<Integer, List<Employee>> map = employees.stream()
				.collect(Collectors.groupingBy(Employee::getSalary)); // Group by salary

		// TO DO 6: Retourner une Map qui regroupe les noms des employés par salaire
		Map<Integer, String> mm = employees.stream()
				.collect(Collectors.groupingBy(
						Employee::getSalary,
						Collectors.mapping(Employee::getName, Collectors.joining(", ")) // Collect names as comma-separated string
				));

		// TO DO 7: Retourner le min, max, average, sum, count des salaires
		String s = employees.stream()
				.mapToInt(Employee::getSalary)
				.summaryStatistics() // Collect salary statistics
				.toString(); // Convert to string representation

		// Print the results for verification
		System.out.println("Names: " + names);
		System.out.println("Names (Uppercase, # separated): " + namesMajSplit);
		System.out.println("Set of Employees: " + emps);
		System.out.println("TreeSet of Employees: " + emps2);
		System.out.println("Map of Employees by Salary: " + map);
		System.out.println("Map of Names by Salary: " + mm);
		System.out.println("Salary Stats: " + s);
	}
}
