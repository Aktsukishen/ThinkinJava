import java.util.List;

public class RoboContactMethods2 {

	public void callDrivers(List<Person> ps){
		for(Person p:ps){
			if(isDriver(p)){
				roboCall(p);
			}
		}
	}
	
	private boolean isDriver(Person p){
		return p.getAge()>16;
	}
	
	public void emailDraftees(List<Person> ps){
		for(Person p:ps){
			if(isDraftee(p)){
				roboEmail(p);
			}
		}
	}
	
	private boolean isDraftee(Person p){
		return p.getAge()>=18 && p.getAge()<=25 && p.getGender()==Gender.MALE;
	}
	
	public void emailPliots(List<Person> ps){
		for(Person p:ps){
			if( isPliot(p)){
				roboMail(p);
			}
		}
	}
	
	private boolean isPliot(Person p){
		return p.getAge()>=23 && p.getAge()<=65;
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
