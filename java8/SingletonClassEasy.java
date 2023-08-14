import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class SingletonClassEasy implements Cloneable, Serializable {

    private static final SingletonClassEasy singletonClassObj = new SingletonClassEasy();
    private SingletonClassEasy() {
        if (singletonClassObj != null) {
            throw new IllegalStateException("instance already created.");
        }
        System.out.println("Singleton instance is being created.");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return singletonClassObj;
    }

    protected Object readResolve() {
        return singletonClassObj;
    }

    public static SingletonClassEasy getSingletonClassObj() {
        return singletonClassObj;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, CloneNotSupportedException, IOException, ClassNotFoundException {

        SingletonClassEasy singletonClassEasy = getSingletonClassObj();
        System.out.println("singletonClassEnum: " + singletonClassEasy.hashCode());

//        Constructor constructor = singletonClassEasy.getClass().getDeclaredConstructor(new Class[0]);
//        constructor.setAccessible(true);
//        SingletonClassEasy singletonClassEasy1 = (SingletonClassEasy) constructor.newInstance();
//
//        System.out.println("singletonClassEnum1: " + singletonClassEasy1.hashCode());

//        Field instance = SingletonClassEasy.class.getDeclaredField("singletonClassObj");
//        instance.setAccessible(true);
//        instance.set(instance, null);
//
//        Constructor constructor2 = SingletonClassEasy.class.getDeclaredConstructor();
//        constructor2.setAccessible(true);
//        SingletonClassEasy singletonClassEasy2 = (SingletonClassEasy) constructor2.newInstance();

//        System.out.println("singletonClassEasy2: " + singletonClassEasy2.hashCode());

        System.out.println("singletonClassEasy2: " + singletonClassEasy.clone().hashCode());

        serialise("test.txt", singletonClassEasy);
        SingletonClassEasy singletonClassEasy3 = deserialize("test.txt");
        System.out.println("singletonClassEasy3: " + singletonClassEasy3.hashCode());

    }

    public static void serialise(String filename, SingletonClassEasy singletonClassEasy) {
        try {
            FileOutputStream file = new FileOutputStream(filename);  //Saving of object in the file
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(singletonClassEasy);            //serialize object
            out.close();                    //closes the ObjectOutputStream
            file.close();                   //closes the file
            System.out.println("Object serialized");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static SingletonClassEasy deserialize(String filename) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(filename); // reading an object from a file
        ObjectInputStream is = new ObjectInputStream(file);
        SingletonClassEasy obj = (SingletonClassEasy)is.readObject();        //deserialize object
        is.close();                     //closes the ObjectInputStream
        file.close();
        return obj;
    }
}
