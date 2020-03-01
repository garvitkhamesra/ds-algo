/**
 * Created by dot on 24/2/20 7:50 AM
 * Package: PACKAGE_NAME
 */
public class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            wait();
            printFoo.run();
            notify();
        }
        notifyAll();
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            wait();
            printBar.run();
            notify();
        }
        notifyAll();
    }
}
