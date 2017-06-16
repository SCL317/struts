package struts_ognl.ognl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class OgnlBean {
	public static final String staticProperty="This is a static property";
	private String property ="This is a common property";
	private String[] array ={"jack","rose","tom"};
	private List<String> list =new ArrayList<String>();
	private Map<String, String> map = new HashMap<String,String>();
	
	public OgnlBean(){
		list.add("hefei");
		list.add("beijing");
		list.add("shanghai");
		map.put("home", "1111111");
		map.put("office", "2222222");
		map.put("other", "3333333");
	}
	
	public String method() {
		return "This is a common method!";
	}
	public static String staticMethod() {
		return "This is a static method!";
	}
	
}
