import java.util.List;
import java.util.OptionalDouble;

public class Test04Map {

	public static void main(String[] args) {
		List<Person> ps=Person.createShortList();
		SearchCriteria search=SearchCriteria.getInstance();
		System.out.println("\n=== Calc Old Style ===");
		int sum=0;
		int count=0;
		for(Person p:ps){
			if(p.getAge()>=23 && p.getAge()<=65){
				sum+=p.getAge();
				count++;
			}
		}
		
		long average=sum/count;
		System.out.println("Total Ages:"+sum);
		System.out.println("Average age:"+average);
		
		System.out.println("\n=== Calc New Style ===");
		long totalAge=ps.stream()
						.filter(search.getCriteria("allPilots"))
						.mapToInt(p -> p.getAge())
						.sum();
		
		//Get average of ages
		OptionalDouble averageAge=ps.parallelStream()
									.filter(search.getCriteria("allPilots"))
									.mapToDouble(p -> p.getAge())
									.average();
		System.out.println("Total Ages:"+totalAge);
		System.out.println("Average age:"+averageAge.getAsDouble());
	}

}
