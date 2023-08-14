import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public enum SingletonClassEnum {
    SINGLETON_CLASS_ENUM_OBJ;

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // Object creation mechanisms

        SingletonClassEnum singletonClassEnum = SINGLETON_CLASS_ENUM_OBJ;

/*        Constructor constructor = singletonClassEnum.getClass().getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);
        SingletonClassEnum singletonClassEnum2 = (SingletonClassEnum) constructor.newInstance();*/

        /*
            Exception in thread "main" java.lang.NoSuchMethodException: SingletonClassEnum.<init>()
                at java.lang.Class.getConstructor0(Class.java:3082)
                at java.lang.Class.getDeclaredConstructor(Class.java:2178)
                at SingletonClassEnum.main(SingletonClassEnum.java:13)
        * */

        System.out.println("singletonClassEnum: " + singletonClassEnum.hashCode());
//        System.out.println("singletonClassEnum2: " + singletonClassEnum2.hashCode());

        Field instance = SingletonClassEnum.class.getDeclaredField("SINGLETON_CLASS_ENUM_OBJ");
        instance.setAccessible(true);
//        instance.set(instance, null);

        Constructor constructor2 = SingletonClassEnum.class.getDeclaredConstructor();
        constructor2.setAccessible(true);
        SingletonClassEnum singletonClassEnum3 = (SingletonClassEnum) constructor2.newInstance();

        System.out.println("singletonClassEnum3: " + singletonClassEnum3.hashCode());

    }

}
