import java.util.List;

public class RoboContactAnon {
	public void phoneCaontacts(List<Person> ps,MyTest<Person> aTest){
		for(Person p:ps){
			if(aTest.test(p)){
				roboCall(p);
			}
		}
	}
	
	public void emailContacts(List<Person> ps,MyTest<Person> aTest){
		for(Person p:ps){
			if(aTest.test(p)){
				roboEmail(p);
			}
		}
	}
	
	public void mailContacts(List<Person> ps,MyTest<Person> aTest){
		for(Person p:ps){
			if( aTest.test(p)){
				roboMail(p);
			}
		}
	}
	
	private void roboCall(Person p) {
		System.out.println("Calling "+p.getGivenName()+" "+p.getSurName()+" age "+p.getAge()+" at "+p.getPhone());
	}
	
	private void roboEmail(Person p) {
		System.out.println("EMailing "+p.getGivenName()+" "+p.getSurName()+" age "+p.getAge()+" at "+p.geteMail());
	}
	
	private void roboMail(Person p) {
		System.out.println("Mailing "+p.getGivenName()+" "+p.getSurName()+" age "+p.getAge()+" at "+p.getAddress());
	}
}
