import com.baomidou.mybatisplus.core.toolkit.Assert;
import org.blank.Main;
import org.blank.dao.TestDao;
import org.blank.entity.User;
import org.blank.utils.DateUtil;
import org.blank.utils.JacksonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest(classes =Main.class)
public class MyTest {
    @Autowired
    private TestDao userMapper;
    @Autowired
    JacksonUtil jacksonUtil;
    @Autowired
    DateUtil dateUtil;


    @Test
    public void testSelect()  {

        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
//        Assert.isTrue(5 == userList.size(), "");
        String s = jacksonUtil.javaBeanToJson(userList);
        jacksonUtil.jsonToJavaBean(s,List.class).forEach(System.out::println);
        dateUtil.formatDate(new Date(),DateUtil.YYYY_MM);
        userList.forEach(System.out::println);
    }
    @Test
    public void testInsert(){
//        userMapper.insert(new User("123123123","54asd","普通用户","none"));
        userMapper.insert(new User("215458483","we84a","普通用户","none"));

    }
}
