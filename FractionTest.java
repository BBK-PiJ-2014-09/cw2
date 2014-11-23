/**
 * Created by keith for the second coursework assignment.
 */
public class FractionTest {
    public static void main(String[] args) 
    {
        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        
        // test multiply
        Fraction f = new Fraction(4,10);
        Fraction g = new Fraction(1,2);
        Fraction h = new Fraction(4,5);
        if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");
        
        // test divide
        f = new Fraction(4,5);
        g = new Fraction(3,10);
        h = new Fraction(1,2);
        if (!f.equals(g.divide(h))) System.out.println("Division failed");

        // test add
        f = new Fraction(4,10);
        g = new Fraction(1,2);
        h = new Fraction(6,20);
        if (!f.equals(g.add(h))) System.out.println("Addition failed");

        // test subtract
        f = new Fraction(4,20);
        g = new Fraction(8,10);
        h = new Fraction(1,2);
        if (!f.equals(g.subtract(h))) System.out.println("Subtraction failed");

        // test equals
        test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
        test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
        test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
        test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
        test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");
    
        // test negate
        f = new Fraction(2,3);
        g = new Fraction(-2,3);
        if (!f.equals(g.negate())) System.out.println("Negation test 1 failed");
        
        f = new Fraction(2,3);
        g = new Fraction(2,3);
        if (!f.equals(g.negate())) System.out.println("Negation test 2 failed");
        
        f = new Fraction(2,-3);
        g = new Fraction(2,3);
        if (!f.equals(g.negate())) System.out.println("Negation test 3 failed");

        // test abs
        f = new Fraction(2,3);
        g = new Fraction(-2,3);
        if (!f.equals(g.absValue())) System.out.println("Negation test 1 failed");
        
        f = new Fraction(-2,3);
        g = new Fraction(-2,3);
        if (!f.equals(g.absValue())) System.out.println("Abs value test 2 failed");
        
        f = new Fraction(2,-3);
        g = new Fraction(2,3);
        if (!f.equals(g.absValue())) System.out.println("Abs value test 3 failed");
    }

    static void test(Fraction f1, Fraction f2, String msg){
        if (! f1.equals(f2))
        System.out.println(msg);
    }
}
