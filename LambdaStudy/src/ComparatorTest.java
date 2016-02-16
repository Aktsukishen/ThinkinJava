import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * 使用Lambda表达式时可以进类型的推断：
 * Variable declarations：变量申明
Assignments：赋值
Return statements：返回值推断
Array initializers：数组初始化
Method or constructor arguments：方法或者构造函数初始化
Lambda expression bodies：表达式主体
Conditional expressions ?:额外表达式
Cast expressions：类型转换
 * @author li.shensong
 *
 */
public class ComparatorTest {

	public static void main(String[] args) {
		List<Person> personList=Person.createShortList();
		
		//Sort with Inner Class
		Collections.sort(personList,new Comparator<Person>() {
			public int compare(Person p1,Person p2){
				return p1.getSurName().compareTo(p2.getSurName());
			}
		});
		System.out.println("== Sorted Asc SurName ==");
		for(Person p:personList){
			p.printName();
		}
		
		//Use Lambda instead
		//Print Asc
		System.out.println("== Sorted Asc SurName ==");
		Collections.sort(personList,(Person p1,Person p2) -> p1.getSurName().compareTo(p2.getSurName()));
		for(Person p:personList){
			p.printName();
		}
		
		System.out.println("== Sorted Desc SurName ==");
		Collections.sort(personList,(p1,p2) -> p2.getSurName().compareTo(p1.getSurName()));//变量申明推断
		for(Person p:personList){
			p.printName();
		}
	}

}
