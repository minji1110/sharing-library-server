import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanTest {
    public static void main(String[] args) {
        AbstractApplicationContext context=new GenericXmlApplicationContext("beans.xml");
        Bean bean1 = (Bean) context.getBean("myBean");
        Bean bean2 = (Bean) context.getBean("myBean");

        bean1.sayHello("bean1");
        bean2.sayHello("bean2");

        context.close();
    }
}

