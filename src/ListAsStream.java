import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ListAsStream {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Person p1 = new Person(10, "Anirudh",200.0);
		Person p2 = new Person(20, "Harsha",3000.0);
		Person p3 = new Person(20, "Arya",300.0);
		
		List<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		//Filter Person using Name
		List<Person> filteredPerson = list.stream().filter(s -> s.name.startsWith("A")).collect(Collectors.toList());
		
		filteredPerson.forEach(p -> System.out.format("name: %s Id: %s\n", p.name,p.id));
		
		//Summing salary
		double salary = (double) list.stream().collect(Collectors.summingDouble(Person::getSalary));	
		System.out.println("Salary:"+salary);
		
		//Average salary
		double averageSalary = list.stream().filter(p -> p.name.startsWith("A")).mapToDouble(Person::getSalary).average().getAsDouble();
        System.out.println("averageSalary:"+averageSalary);
        
      //max salary
      		double maxSalary = list.stream().mapToDouble(Person::getSalary).max().getAsDouble();
            System.out.println("maxSalary:"+maxSalary);
        
	}

}
