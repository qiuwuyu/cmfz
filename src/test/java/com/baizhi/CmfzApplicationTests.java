package com.baizhi;

import com.baizhi.dao.AdminUserDao;
import com.baizhi.entity.AdminUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {
    @Autowired
    private AdminUserDao adminUserDao;

    @Test
    public void contextLoads() {
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername("admin");
        adminUser.setPassword("123456");
        AdminUser admin = adminUserDao.getAdminUser(adminUser);

        System.out.println(admin);
    }

}
