public class Bean {
    public Bean(){
        System.out.println("===Bean 객체 생성!! ===");
    }

    void sayHello(String beanName){
        System.out.println("=== I'm "+ beanName);
    }

    void initMethod(){
        System.out.println("Bean init()");
    }

    void destroyMethod(){
        System.out.println("Bean destroy()");
    }

}



