package renxuan.oa.biz;

import renxuan.oa.entity.Employee;

public interface GlobalBiz {
    Employee login(String sn,String password);
    //�˳��йص���session���ڱ��ֲ�
    void changePassword(Employee employee);
}
