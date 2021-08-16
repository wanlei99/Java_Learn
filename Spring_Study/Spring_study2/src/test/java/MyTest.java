import com.wl.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Mr_wan
 * @Description TODO $
 * @Date $ 2021.08.16$
 * @Param beans注入$
 * @return $
 */
public class MyTest {
    private static Student student;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        student =(Student) context.getBean("Student");
        System.out.println(student.toString());
        /**
         * Student{
         * name='琴江',
         * books=[红楼梦, 水浒传, 西游记, 三国演义],
         * address=Address{address='南京'},
         * hobbies=[打篮球, 看电影, 打游戏],
         * card={
         *  身份证=32038210009283838,
         *  银行卡=1212112412421412412
         * },
         * games=[LOL, COC, BOB],
         * wife='null',
         * info={user=admin, password=1qaz, url=www.baidu.com, driver=2312312131}}
         */
    }
}
