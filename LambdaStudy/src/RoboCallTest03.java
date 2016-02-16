import java.util.List;

public class RoboCallTest03 {

	public static void main(String[] args) {
		List<Person> ps=Person.createShortList();
		RoboContactAnon robo=new RoboContactAnon();
		System.out.println("\n=== Test 03 ===");
		System.out.println("\n=== Calling all Drivers ===");
		robo.phoneCaontacts(ps, new MyTest<Person>() {
			
			@Override
			public boolean test(Person t) {
				return t.getAge()>16;
			}
		});
		
		System.out.println("\n=== Emailing all Draftees ===");
		robo.phoneCaontacts(ps, new MyTest<Person>() {
			
			@Override
			public boolean test(Person t) {
				return t.getAge()>18 && t.getAge()<25 && t.getGender()==Gender.MALE;
			}
		});
		
		System.out.println("\n=== Mailing all Pilots ===");
		robo.phoneCaontacts(ps, new MyTest<Person>() {
			
			@Override
			public boolean test(Person t) {
				return t.getAge()>23 && t.getAge()<=65;
			}
		});
	}

}
