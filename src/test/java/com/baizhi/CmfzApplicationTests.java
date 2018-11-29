package com.baizhi;

import com.baizhi.dao.AdminUserDao;
import com.baizhi.dao.AlbumMapper;
import com.baizhi.entity.AdminUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {
    @Autowired
    private AlbumMapper albumMapper;

    @Test
    public void contextLoads() {
        System.out.println(albumMapper.getAlbumAll(1,10));
    }

}
