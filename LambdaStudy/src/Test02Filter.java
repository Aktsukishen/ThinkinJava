import java.util.List;

public class Test02Filter {

	public static void main(String[] args) {
		List<Person> ps=Person.createShortList();
		SearchCriteria search=SearchCriteria.getInstance();
		System.out.println("\n=== Western Pilot Phone List ===");
		ps.stream().filter(search.getCriteria("allPilots")).forEach(Person::printWesternName);
		
		System.out.println("\n=== Eastern Pilot Phone List ===");
		ps.stream().filter(search.getCriteria("allDraftees")).forEach(Person::printEasternName);
	}

}
