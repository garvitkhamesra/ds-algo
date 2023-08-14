import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.Permission;
import java.security.Policy;
import java.security.ProtectionDomain;

public class SingletonClassLazy implements Cloneable, Serializable {

    private static volatile SingletonClassLazy singletonClassObj;
    private SingletonClassLazy() {
        if (singletonClassObj != null)
            throw new IllegalStateException("You are not supposed to use this, try using get instance");
        Policy.setPolicy(new Policy() {
            @Override
            public boolean implies(ProtectionDomain domain, Permission permission) {
                return super.implies(domain, permission);
            }
        });
        System.setSecurityManager(new SecurityManager());
    }

    static SingletonClassLazy getInstance() {
        if (singletonClassObj == null) {
            synchronized (SingletonClassLazy.class) {
                if (singletonClassObj == null) {
                    singletonClassObj = new SingletonClassLazy();
                }
            }
        }
        return singletonClassObj;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return singletonClassObj;
    }

    protected Object readResolve() {
        return singletonClassObj;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, CloneNotSupportedException, IOException, ClassNotFoundException {

        SingletonClassLazy singletonClassLazy = getInstance();
        System.out.println("singletonClassEnum: " + singletonClassLazy.hashCode());

//        Constructor constructor = singletonClassLazy.getClass().getDeclaredConstructor(new Class[0]);
//        constructor.setAccessible(true);
//        SingletonClassLazy SingletonClassLazy1 = (SingletonClassLazy) constructor.newInstance();
//
//        System.out.println("singletonClassEnum1: " + SingletonClassLazy1.hashCode());

        System.out.println("SingletonClassLazyclone: " + singletonClassLazy.clone().hashCode());

//        Field instance = SingletonClassLazy.class.getDeclaredField("singletonClassObj");
//        instance.setAccessible(true);
//        instance.set(instance, null);
//
//        Constructor constructor2 = SingletonClassLazy.class.getDeclaredConstructor();
//        constructor2.setAccessible(true);
//        SingletonClassLazy SingletonClassLazy2 = (SingletonClassLazy) constructor2.newInstance();
//
//        System.out.println("SingletonClassLazy2: " + SingletonClassLazy2.hashCode());
//

        serialise("test.txt", singletonClassLazy);
        SingletonClassLazy singletonClassLazy1 = deserialize("test.txt");
        System.out.println("SingletonClassLazy3: " + singletonClassLazy1.hashCode());

    }

    public static void serialise(String filename, SingletonClassLazy singletonClassLazy) {
        try {
            FileOutputStream file = new FileOutputStream(filename);  //Saving of object in the file
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(singletonClassLazy);            //serialize object
            out.close();                    //closes the ObjectOutputStream
            file.close();                   //closes the file
            System.out.println("Object serialized");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static SingletonClassLazy deserialize(String filename) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(filename); // reading an object from a file
        ObjectInputStream is = new ObjectInputStream(file);
        SingletonClassLazy obj = (SingletonClassLazy)is.readObject();        //deserialize object
        is.close();                     //closes the ObjectInputStream
        file.close();
        return obj;
    }
}
// breaks in reflection