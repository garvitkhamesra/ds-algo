public class InterfaceImpl implements interface1, interface2 {
    @Override
    public int sum(int a, int b) {
        return interface1.super.sum(2, 3);
    }

    public static void main(String[] args) {
        InterfaceImpl i = new InterfaceImpl();
        System.out.println(i.sum(2, 4));
    }
}
