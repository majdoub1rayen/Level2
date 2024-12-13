package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Level2 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();

		// TO DO 1: Retourner le nombre des employés dont le nom commence avec n
		long nbr = employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("n"))
				.count();
		System.out.println("Nombre d'employés dont le nom commence avec 'n': " + nbr);

		// TO DO 2: Retourner la somme des salaires de tous les employés (hint: mapToInt)
		long sum = employees.stream()
				.mapToLong(Employee::getSalary)
				.sum();
		System.out.println("Somme des salaires: " + sum);

		// TO DO 3: Retourner la moyenne des salaires des employés dont le nom commence avec s
		double average = employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.mapToLong(Employee::getSalary)
				.average()
				.orElse(0.0);
		System.out.println("Moyenne des salaires des employés dont le nom commence avec 's': " + average);

		// TO DO 4: Retourner la liste de tous les employés
		List<Employee> emps = employees.stream()
				.collect(Collectors.toList());
		System.out.println("Liste de tous les employés: " + emps);

		// TO DO 5: Retourner la liste des employés dont le nom commence par s
		List<Employee> emps2 = employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.collect(Collectors.toList());
		System.out.println("Liste des employés dont le nom commence avec 's': " + emps2);

		// TO DO 6: Retourner true si il y a au min un employé dont le salaire > 1000, false si non
		boolean test = employees.stream()
				.anyMatch(employee -> employee.getSalary() > 1000);
		System.out.println("Existe-t-il un employé avec un salaire > 1000? " + test);

		// TO DO 7: Afficher le premier employé dont le nom commence avec s avec deux manières différentes
		// First way
		Optional<Employee> firstEmployee = employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.findFirst();
		firstEmployee.ifPresent(employee -> System.out.println("Premier employé (1st way): " + employee));

		// Second way
		employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.limit(1)
				.forEach(employee -> System.out.println("Premier employé (2nd way): " + employee));

		// TO DO 8: Afficher le second employé dont le nom commence avec s
		employees.stream()
				.filter(employee -> employee.getName().toLowerCase().startsWith("s"))
				.skip(1)
				.findFirst()
				.ifPresent(employee -> System.out.println("Second employé: " + employee));
	}
}