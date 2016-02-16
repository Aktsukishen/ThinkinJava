import java.util.List;
import java.util.function.Predicate;

/**
 * 
 * 将判定与最终的行为剥离！！！！！！
 * @author li.shensong
 *
 */
public class RoboCallTest04 {

	public static void main(String[] args) {
		List<Person> ps=Person.createShortList();
		RoboContactLambda robo=new RoboContactLambda();
		//Predicates
		Predicate<Person> allDrivers=p -> p.getAge()>=16;
		Predicate<Person> allDraftees=p -> p.getAge()>=18 && p.getAge()<=25 && p.getGender()==Gender.MALE;
		Predicate<Person> allPliots=p -> p.getAge()>=23 && p.getAge() <=65;
		
		System.out.println("\n=== Test 04 ===");
		System.out.println("\n=== Calling all Drivers ===");
		robo.phoneContacts(ps, allDrivers);
		System.out.println("\n=== Emailing all Draftees ===");
		robo.emailContacts(ps, allDraftees);
		System.out.println("\n=== Mail all Pilots");
		robo.mailContacts(ps, allPliots);
		
		//Mix and match becomes easy
		System.out.println("\n=== Mail all Draftees ===");
		robo.mailContacts(ps, allDraftees);
		System.out.println("\n=== Call all Pilots ===");
		robo.phoneContacts(ps, allPliots);
		
	}

}
