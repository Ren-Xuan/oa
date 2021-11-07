package renxuan.oa.biz;

import renxuan.oa.entity.Employee;

public interface GlobalBiz {
    Employee login(String sn,String password);
    //退出有关的是session，在表现层
    void changePassword(Employee employee);
}
