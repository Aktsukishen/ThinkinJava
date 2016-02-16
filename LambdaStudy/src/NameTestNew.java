import java.util.List;
import java.util.function.Function;

public class NameTestNew {

	public static void main(String[] args) {
		System.out.println("\n=== NameTestNew02 ===");
		List<Person> ps=Person.createShortList();
		//Print Custom First Name and e-mail
		System.out.println("=== Custom List ====");
		for(Person person:ps){
			System.out.println(
					person.printCunstom(p -> "Name:"+p.getGivenName()+" Email:"+p.geteMail())
					);
		}
		
		//Define　Western and Eastern Lambdas
		Function<Person,String> westernStyle=p -> {return "Name:"+p.getGivenName()+" "+p.getSurName();};
		Function<Person,String> easternStyle=p -> {return "Name:"+p.getSurName()+" "+p.getGivenName();};
		System.out.println("\n=== Western List ===");
		for(Person p:ps){
			System.out.println(p.printCunstom(westernStyle));
		}
		System.out.println("\n=== Eastern List ===");
		for(Person p:ps){
			System.out.println(p.printCunstom(easternStyle));
		}
	}

}
