import com.iocStudy.dao.impl.MySqlDaoImpl;
import com.iocStudy.dao.impl.UserDaoImpl;
import com.iocStudy.service.UserService;
import com.iocStudy.service.impl.UserServiceImpl;
/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ $
 * @Param $
 * @return $
 */
public class MyTest {
    public static void main(String[] args) {
        UserService userService;
        userService = new UserServiceImpl();
        //userService.setUserDao(new MySqlDaoImpl());
        ((UserServiceImpl) userService).test();
        ((UserServiceImpl) userService).setUserDao(new UserDaoImpl());
        userService.getUser();
    }
}
