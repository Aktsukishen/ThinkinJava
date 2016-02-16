import java.util.List;

/**
 * 
 * 
 * 类中callDrivers(),emailDraftees(),emailPliots()都可以搜索出符合要求的数据，然而存在以下缺陷：
 * 1.DRY(Don't Repeat Yourself)没有遵循：
 *    每个方法都重复循环
 *    筛选的准则重写
 * 2.筛选的规则写死，不可维护。
 * @author li.shensong
 *
 */
public class RoboContactMethods {
	public void callDrivers(List<Person> ps){
		for(Person p:ps){
			if(p.getAge()>=16){
				roboCall(p);
			}
		}
	}
	
	public void emailDraftees(List<Person> ps){
		for(Person p:ps){
			if(p.getAge()>=18 && p.getAge()<=25 && p.getGender()==Gender.MALE){
				roboEmail(p);
			}
		}
	}
	
	public void emailPliots(List<Person> ps){
		for(Person p:ps){
			if(p.getAge()>=23 && p.getAge()<=65 ){
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
