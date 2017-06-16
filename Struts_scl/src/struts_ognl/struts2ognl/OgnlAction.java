package struts_ognl.struts2ognl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import lombok.Getter;
import lombok.Setter;
import struts_ognl.ognlvaluestack.Student;
import struts_ognl.ognlvaluestack.Teacher;

@Getter@Setter
public class OgnlAction extends ActionSupport {

	private static final long serialVersionUID =1L;
	private String greeting;
	private List<Person> persons =new ArrayList<Person>();
	
	private void initData() {
		Address address1=new Address("中国","合肥","滨湖区11");
		Address address2=new Address("中国","上海","浦东区22");
		Address address3=new Address("中国","北京","朝阳区33");
	
		String[] alias1={"zhangdan","三儿"};
		String[] alias2={"lisi","四儿"};
		String[] alias3={"阿斯达","五儿"};
		
		List<String> email1=new ArrayList<String>();
		email1.add("zhangsan@163.com");
		email1.add("zhangsan@qq.com");
		List<String> email2=new ArrayList<String>();
		email1.add("lisi@163.com");
		email1.add("lisi@qq.com");
		List<String> email3=new ArrayList<String>();
		email1.add("wangwu@163.com");
		email1.add("wangwu@qq.com");
		
		Map<String, String> phone1=new HashMap<String,String>();
		phone1.put("home", "11111111");
		phone1.put("office", "1111111112");
		Map<String, String> phone2=new HashMap<String,String>();
		phone2.put("home", "22222222");
		phone2.put("office", "222222223");
		Map<String, String> phone3=new HashMap<String,String>();
		phone3.put("home", "333333333");
		phone3.put("office", "3333333334");
		
		Person person1=new Person("张三",33,3333,address1,alias1,email1,phone1);
		Person person2=new Person("李四",44,4444,address2,alias2,email2,phone2);
		Person person3=new Person("王五",55,5555,address3,alias3,email3,phone3);
	
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);	
	}
	
	@SuppressWarnings({"unchecked","rawtypes"})
	@Override
	public String execute(){
		initData();
		valueStack();
		ActionContext actionContext=ActionContext.getContext();
		Map request=actionContext.getContextMap();
		Map session=actionContext.getSession();
		Map application=actionContext.getApplication();
		request.put("personName", persons.get(0).getName());
		session.put("personName", persons.get(1).getName());
		application.put("personName", persons.get(2).getName());
		
		return SUCCESS;
	}

	private void valueStack() {
		Student stu=new Student("Jack", 20);
		Teacher tea=new Teacher("Scott", 40);
		
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		valueStack.push(stu);
		System.out.println(valueStack.findValue("name"));
		valueStack.push(tea);
		System.out.println(valueStack.findValue("name"));
		System.out.println("==========================");
		System.out.println(valueStack.findValue("score"));
		System.out.println(valueStack.findValue("salary"));
		
		System.out.println("==========================");
		valueStack.setValue("name", "Rose");
		System.out.println(valueStack.findValue("name"));
		valueStack.setValue("score", "80");
		System.out.println(valueStack.findValue("score"));
		System.out.println("==========================");
		
	} 
	
}
