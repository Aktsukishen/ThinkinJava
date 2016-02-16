import java.util.List;
import java.util.function.Predicate;

/**
 * 
 * 系统自定义的Predicate接口是一个功能接口，只包含一个test()方法
 * @author li.shensong
 *
 */
public class RoboContactLambda {
	public void phoneContacts(List<Person> ps,Predicate<Person> pred){
		for(Person p:ps){
			if(pred.test(p)){
				roboCall(p);
			}
		}
	}
	
	public void emailContacts(List<Person>ps,Predicate<Person> pred){
		for(Person p:ps){
			if(pred.test(p)){
				roboEmail(p);
			}
		}
	}
	
	public void mailContacts(List<Person> ps,Predicate<Person> pred){
		for(Person p:ps){
			if(pred.test(p)){
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
