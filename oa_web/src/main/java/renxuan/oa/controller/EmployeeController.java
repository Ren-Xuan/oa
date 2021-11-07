package renxuan.oa.controller;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import renxuan.oa.biz.DepartmentBiz;
import renxuan.oa.biz.EmployeeBiz;
import renxuan.oa.entity.Employee;
import renxuan.oa.global.Contant;


@Controller("employeeController")
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeBiz employeeBiz;
	
	@Autowired
	private DepartmentBiz departmentBiz;
	
	
	@RequestMapping("/list")
	public String list(Map<String, Object> map) {
		map.put("list", employeeBiz.getAll());
		return "employee_list";//employee_list.jsp
	}
	
	@RequestMapping("/to_add")
	public String toAdd(Map<String, Object>map) {
		//为了满足使用SpringMCV的 form标签
		map.put("employee", new Employee());
		map.put("dlist", departmentBiz.getAll());
		map.put("plist", Contant.getPosts());
		return "employee_add";
	}
	
	@RequestMapping("/add")
	public String add(Employee employee) {
		employeeBiz.add(employee);
		return "redirect:list";
	}
	
	@RequestMapping("/to_update")
	public String toUpdate(@Param("sn")String sn,Map<String, Object>map) {
		
		map.put("employee", employeeBiz.get(sn));
		map.put("dlist", departmentBiz.getAll());
		map.put("plist", Contant.getPosts());
		return "employee_update";
	}
	
	@RequestMapping("/update")
	public String update(Employee employee) {
		employeeBiz.edit(employee);
		return "redirect:list";
	}
	
	@RequestMapping("/remove")
	public String toUpdate(@Param("sn")String sn) {
		employeeBiz.remove(sn);
		return "redirect:list";
	}
	
}
