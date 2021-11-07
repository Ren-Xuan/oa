package renxuan.oa.controller;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import renxuan.oa.biz.DepartmentBiz;
import renxuan.oa.entity.Department;

@Controller("departmentController")
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentBiz departmentBiz;
	
	@RequestMapping("/list")
	public String list(Map<String, Object> map) {
		map.put("list", departmentBiz.getAll());
		return "department_list";//department_list.jsp
	}
	
	@RequestMapping("/to_add")
	public String toAdd(Map<String, Object>map) {
		//为了满足使用SpringMCV的 form标签
		map.put("department", new Department());
		return "department_add";
	}
	
	@RequestMapping("/add")
	public String add(Department department) {
		departmentBiz.add(department);
		return "redirect:list";
	}
	
	@RequestMapping("/to_update")
	public String toUpdate(@Param("sn")String sn,Map<String, Object>map) {
		
		map.put("department", departmentBiz.get(sn));
		return "department_update";
	}
	
	@RequestMapping("/update")
	public String update(Department department) {
		departmentBiz.edit(department);
		return "redirect:list";
	}
	
	@RequestMapping("/remove")
	public String toUpdate(@Param("sn")String sn) {
		departmentBiz.remove(sn);
		return "redirect:list";
	}
	
}
