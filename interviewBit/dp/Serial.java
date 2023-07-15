package dp;

import java.io.*;

class Serial1 implements Serializable {

    private static final long serialVersionUID = -7087547868803043854L;

    static int anInt = 1000;
    transient int tI = 100;
    int anInt1 = 10;

}

class Serial2 implements Serializable {
    static int anInt = 1000;
    transient int tI = 100;
    int anInt1 = 10;
}

public class Serial {
    public static void main(String[] args) {

        Serial1 serial1 = new Serial1();
        Serial1 serialN = null;
        Serial2 serial2 = new Serial2();

        try {
            FileOutputStream fo
                    = new FileOutputStream("gfg.txt");
            ObjectOutputStream so
                    = new ObjectOutputStream(fo);
            so.writeObject(serial1);
            so.flush();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        serial1.anInt1 = 111;
        // Deserialization the car
        try {
            FileInputStream fi
                    = new FileInputStream("gfg.txt");
            ObjectInputStream si
                    = new ObjectInputStream(fi);
            serialN = (Serial1) si.readObject();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(serialN);



        Serial2 serialN2 = null;

        try {
            FileOutputStream fo
                    = new FileOutputStream("gfg.txt");
            ObjectOutputStream so
                    = new ObjectOutputStream(fo);
            so.writeObject(serial2);
            so.flush();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        serial2.anInt1 = 111;
        // Deserialization the car
        try {
            FileInputStream fi
                    = new FileInputStream("gfg.txt");
            ObjectInputStream si
                    = new ObjectInputStream(fi);
            serialN2 = (Serial2) si.readObject();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(serialN2);

    }
}