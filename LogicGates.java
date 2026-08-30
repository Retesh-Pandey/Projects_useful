public class LogicGates {

    // AND gate
    public static boolean AND(boolean a, boolean b) {
        return a && b;
    }

    // OR gate
    public static boolean OR(boolean a, boolean b) {
        return a || b;
    }

    // NOT gate
    public static boolean NOT(boolean a) {
        return !a;
    }

    public static void main(String[] args) {
        boolean x = true;
        boolean y = false;

        System.out.println("Inputs: x = " + x + ", y = " + y);
        System.out.println("AND(x, y) = " + AND(x, y));
        System.out.println("OR(x, y)  = " + OR(x, y));
        System.out.println("NOT(x)    = " + NOT(x));
        System.out.println("NOT(y)    = " + NOT(y));
    }
}
