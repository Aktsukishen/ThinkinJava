import java.util.List;
import java.util.stream.Collectors;

public class Test03toList {

	public static void main(String[] args) {
		List<Person> ps=Person.createShortList();
		SearchCriteria search=SearchCriteria.getInstance();
		
		List<Person> piloList=ps.stream()
				                .filter(search.getCriteria("allPilots"))
				                .collect(Collectors.toList());
		piloList.forEach(Person::printEasternName);
	}

}
