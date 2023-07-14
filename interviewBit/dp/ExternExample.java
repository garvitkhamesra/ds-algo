package dp;// Java program to demonstrate working of Externalization
// interface
import java.io.*;
class Exter implements Externalizable {
    static int age;
    String name;
    transient int year;

    public Exter()
    {
        System.out.println("Default Constructor called");
    }

    Exter(String n, int y)
    {
        this.name = n;
        this.year = y;
        age = 10;
    }

    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException
    {
        out.writeObject(name);
        out.writeInt(age);
        out.writeInt(year);
    }

    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException
    {
        name = (String)in.readObject();
        year = in.readInt();
        age = in.readInt();
    }

    @Override public String toString()
    {
        return ("Name: " + name + "\n"
                + "Year: " + year + "\n"
                + "Age: " + age);
    }
}

public class ExternExample {
    public static void main(String[] args)
    {
        Exter Exter = new Exter("Shubham", 1995);
        Exter newExter = null;

        // Serialize the Exter
        try {
            FileOutputStream fo
                    = new FileOutputStream("gfg.txt");
            ObjectOutputStream so
                    = new ObjectOutputStream(fo);
            so.writeObject(Exter);
            so.flush();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        // Deserialization the Exter
        try {
            FileInputStream fi
                    = new FileInputStream("gfg.txt");
            ObjectInputStream si
                    = new ObjectInputStream(fi);
            newExter = (Exter)si.readObject();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("The original Exter is:\n" + Exter);
        System.out.println("The new Exter is:\n" + newExter);
    }
}
