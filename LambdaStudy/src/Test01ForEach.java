import java.util.List;

public class Test01ForEach {

	public static void main(String[] args) {
		List<Person> ps=Person.createShortList();
		System.out.println("\n=== Western Phone List ===");
		ps.forEach(p -> p.printWesternName());
		
		System.out.println("\n=== Eastern Phone List ===");
		ps.forEach(Person::printEasternName);
		
		System.out.println("\n=== Custom Phone List===");
		ps.forEach(p -> System.out.println(p.printCunstom(r -> "Name:"+r.getGivenName()+" "+r.getAge())));
		
	}

}
