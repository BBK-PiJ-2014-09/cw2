/**
 * Class FractionCalculatorTest - This is class test class for FractionCalculator.
 * 
 * @author Daryl Smith, MSc IT 
 * @version 20141118
 */

public class FractionCalculatorTest {
    public static void main(String[] args) 
    {
        //test neg/n/N
        String s = ("-2/5 n q");
        Fraction f = new Fraction(0,1);
        Fraction result = new Fraction(2,5);
        FractionCalculator fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        if (!f.equals(result)) 
        {
            System.out.println("NegationTest1 failed");
        }
        else
        {
            System.out.println("NegationTest1 succeeded");
        }
        s = ("-2/5 N q");
        f = new Fraction(0,1);
        result = new Fraction(2,5);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        if (!f.equals(result)) 
        {
            System.out.println("NegationTest2 failed");
        }
        else
        {
            System.out.println("NegationTest2 succeeded");
        }
        s = ("-2/5 neg q");
        f = new Fraction(0,1);
        result = new Fraction(2,5);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        if (!f.equals(result)) 
        {
            System.out.println("NegationTest3 failed");
        }
        else
        {
            System.out.println("NegationTest3 succeeded");
        }

        //test abs/a/A
        s = ("-2/5 abs q");
        f = new Fraction(0,1);
        result = new Fraction(2,5);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        if (!f.equals(result)) 
        {
            System.out.println("AbsTest1 failed");
        }
        else
        {
            System.out.println("AbsTest1 succeeded");
        }
        s = ("-2/5 a q");
        f = new Fraction(0,1);
        result = new Fraction(2,5);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        if (!f.equals(result)) 
        {
            System.out.println("AbsTest2 failed");
        }
        else
        {
            System.out.println("AbsTest2 succeeded");
        }
        s = ("-2/5 A q");
        f = new Fraction(0,1);
        result = new Fraction(2,5);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        if (!f.equals(result)) 
        {
            System.out.println("AbsTest3 failed");
        }
        else
        {
            System.out.println("AbsTest3 succeeded");
        }
        
        //test c/C/clear    
        s = ("-2/5 c q");
        f = new Fraction(0,1);
        result = new Fraction(0,1);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        if (!f.equals(result)) 
        {
            System.out.println("ClearTest1 failed");
        }
        else
        {
            System.out.println("ClearTest1 succeeded");
        }
        s = ("-2/5 C q");
        f = new Fraction(0,1);
        result = new Fraction(0,1);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        if (!f.equals(result)) 
        {
            System.out.println("ClearTest2 failed");
        }
        else
        {
            System.out.println("ClearTest2 succeeded");
        }
        s = ("-2/5 clear q");
        f = new Fraction(0,1);
        result = new Fraction(0,1);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        if (!f.equals(result)) 
        {
            System.out.println("ClearTest3 failed");
        }
        else
        {
            System.out.println("ClearTest3 succeeded");
        }
        //test whole number calculations
        s = ("-2/5 + 12/5 q");
        f = new Fraction(0,1);
        result = new Fraction(2,1);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        if (!f.equals(result)) 
        {
            System.out.println("WholeNumberTest1 failed");
        }
        else
        {
            System.out.println("WholeNumberTest1 succeeded");
        }
        s = ("5 + 2 Q");
        f = new Fraction(0,1);
        result = new Fraction(6,1);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        if (!f.equals(result)) 
        {
            System.out.println("WholeNumberTest2 failed");
        }
        else
        {
            System.out.println("WholeNumberTest2 succeeded");
        }
        s = ("5 + 2 Q");
        f = new Fraction(0,1);
        result = new Fraction(7,1);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        if (!f.equals(result)) 
        {
            System.out.println("WholeNumberTest3 failed");
        }
        else
        {
            System.out.println("WholeNumberTest3 succeeded");
        }

        //test exceptions: invalid input
        s = ("-2/5 + this_should_error q");
        f = new Fraction(0,1);
        result = new Fraction(2,1);
        fc = new FractionCalculator();
        System.out.println("ExceptionTest1: invalid input string...");
        f = fc.evaluate(f, s);

        s = ("5 + 2.0 Q");
        f = new Fraction(0,1);
        result = new Fraction(6,1);
        fc = new FractionCalculator();
        System.out.println("ExceptionTest2: invalid input value...");
        f = fc.evaluate(f, s);

        //test exceptions: invalid fractions
        s = ("5 + 2/illegal Q");
        f = new Fraction(0,1);
        result = new Fraction(7,1);
        fc = new FractionCalculator();
        System.out.println("ExceptionTest3: invalid numerator...");
        f = fc.evaluate(f, s);

        s = ("5 + illegal/2 Q");
        f = new Fraction(0,1);
        result = new Fraction(7,1);
        fc = new FractionCalculator();
        System.out.println("ExceptionTest4: invalid denominator...");
        f = fc.evaluate(f, s);

        //test computations
        s = ("5 + 3/2 * 4/2 / 1/5 Q");
        f = new Fraction(0,1);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        System.out.println("CalculatorTest1: Expected result = 65");
        System.out.println("CalculatorTest1: Actual result = " + f);
        
        s = ("3/4 + 1/-3 * 7 / 5 q");
        f = new Fraction(0,1);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        System.out.println("CalculatorTest2: Expected result = 7/12");
        System.out.println("CalculatorTest2: Actual result = " + f);

        s = ("3/4 - 1/-3 * n 4 / 1/2 q");
        f = new Fraction(0,1);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        System.out.println("CalculatorTest3: Expected result = -26/3");
        System.out.println("CalculatorTest3: Actual result = " + f);

        s = ("3/4 - 1/-3 * n 4 / 1/2 abs q");
        f = new Fraction(0,1);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        System.out.println("CalculatorTest3: Expected result = 26/3");
        System.out.println("CalculatorTest3: Actual result = " + f);

        s = ("3/4 - 1/-3 * - n 4 / 1/2 q");
        f = new Fraction(0,1);
        fc = new FractionCalculator();
        f = fc.evaluate(f, s);
        System.out.println("CalculatorTest3: Expected result = consecutive operator exception");
        System.out.println("CalculatorTest3: Actual result = " + f);

    }
}
