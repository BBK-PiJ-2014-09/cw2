import java.util.Scanner;
/**
 * Class FractionCalculator - This class contains information and methods relating to the Fraction Calculator API.
 * 
 * @author Daryl Smith, MSc IT 
 * @version 20141118
 */
public class FractionCalculator
{
    private static String operator = null;
    private static String exitType = ""; 
/**
 * Accessor methods for the operator variable   
 */    
    public static String getOperator()
    {
        return operator;
    }
    
    public static void setOperator(String oper)
    {
        operator = oper;
    }
 
/**
 * Accessor methods for the exitType variable   
 */    
    public static String getExitType()
    {
        return exitType;
    }
    
    public static void setExitType(String exit)
    {
        exitType = exit;
    }

/**
 * Main method to exercise the FractionCalculator class
 */    
    public static void main(String[] args)
    {
        System.out.println("Welcome to FractionCalculator, written by Daryl Smith.");
        System.out.println("Please submit your calculation. Enter 'q', 'Q' to end.");
        Scanner in = new Scanner(System.in);
        String calculation = "";
        Fraction memory = new Fraction(0,1);

        while (!(calculation = in.nextLine()).toUpperCase().equals("Q"))  
        {
           if (calculation.equals(""))
           {
               setOperator(null);
           }
           else
           {
               memory = evaluate(memory, calculation);
               if (exitType == "exception")
               {
                   break;
               }
               else if (exitType == "quit")
               {
                   System.out.println("Output: " + memory);
                   break;
               }
               else
               {
                   System.out.println("Output: " + memory);
               }
           }
        }

        System.out.println("Goodbye");
    } 

    /**
     * Evaluate method - evaluates a line of mathematic operators, returning a result
     * 
     * @param  fraction -  input fraction to evaluate
     * @param  inputString -  the operands and operators to execute
     * @return - a revised fraction value with the result of the mathematical operation(s) 
     */
    public static Fraction evaluate(Fraction fraction, String inputString)
    {
        Scanner in = new Scanner(inputString);
        String operator = null;
        boolean hasOperator = false;
        String word = ""; 
        Fraction secondOperand = new Fraction(0,1);
        while (in.hasNext())
        {
            word = in.next();
            Scanner intCheck = new Scanner(word);

            //when you see a whole number, treat this a fraction whose denimonator is 1
            if (intCheck.hasNextInt())
            {
                word = word + "/1";
            }

            //when you see +, -, *, / remember tha operation (in a variable)
            if ((word.equals("+")) || (word.equals("-")) || 
            (word.equals("/")) || (word.equals("*")))
            {
                if (getOperator() == null)
                {
                    setOperator(word);
                    hasOperator = true;
                }
                else
                //if there is already an operation being remembered, 
                //print an appropriate error message and reset the "calculator" 
                {
                    System.out.println("Error: You have tried to implement two operators consecutively. This is not permitted.");
                    fraction.setNumerator(0);
                    fraction.setDenominator(1);
                    //setExitType("exception");
                    setOperator(null);
                    hasOperator = false;
                    return fraction;
                }
            }
            //when you see a or A or abs, take the absolute value of the fraction currently held by the calculator
            else if ((word.toUpperCase().equals("A")) || (word.toUpperCase().equals("ABS")))
            {
                fraction = fraction.absValue();
            }
            //when you see n or N or neg, change the sign of the value currently held by the calculator
            else if ((word.toUpperCase().equals("N")) || (word.toUpperCase().equals("NEG")))
            {
                fraction = fraction.negate();
            }
            //when you see c or C or clear, set the value currently held by the calculator to zero
            else if ((word.toUpperCase().equals("C")) || (word.toUpperCase().equals("CLEAR")))
            {
                fraction.setNumerator(0);
                fraction.setDenominator(1);
            }
 
            //when you see a fraction, if you have a remembered operation, 
            //perform the operation, with the value currently in the calculator 
            //as the first operand and the fraction as the second operand. 
            //The result becomes the new value in the calclator.
            //"Forget" the operation, since you have now used it.
            else if (word.contains("/") && word.length() > 1)
            {
                int i = word.indexOf("/");
                String numCheck = word.substring(0,i);
                String denomCheck= word.substring(i+1, word.length());
                boolean numeratorIsInt = false;
                boolean denomenatorIsInt = false;
                
                Scanner numCheck2 = new Scanner(numCheck);
                if (numCheck2.hasNextInt())
                {
                    numeratorIsInt = true;
                    secondOperand.setNumerator(Integer.parseInt(numCheck));
                }

                Scanner denomCheck2 = new Scanner(denomCheck);
                if (denomCheck2.hasNextInt())
                {
                    denomenatorIsInt = true;
                    secondOperand.setDenominator(Integer.parseInt(denomCheck));
                }

                if (numeratorIsInt && denomenatorIsInt)
                {
                }
                else
                {
                    System.out.println("Error: You have NOT submitted a valid fraction");
                    fraction.setNumerator(0);
                    fraction.setDenominator(1);
                    //setExitType("exception");
                    return fraction;
                }
                
                if (getOperator() != null)
                {
                    if (getOperator().equals("+"))
                    {
                        fraction = fraction.add(secondOperand);
                    }
                    if (getOperator().equals("-"))
                    {
                        fraction = fraction.subtract(secondOperand);
                    }
                    if (getOperator().equals("/"))
                    {
                        fraction = fraction.divide(secondOperand);
                    }
                    if (getOperator().equals("*"))
                    {
                        fraction = fraction.multiply(secondOperand);
                    }
                    setOperator(null);
                    hasOperator = false;
                }
                //If you do not have a remembered operation, then set the value in the calculator to the new fraction.
                else
                {
                    fraction.setNumerator(Integer.parseInt(numCheck));
                    fraction.setDenominator(Integer.parseInt(denomCheck));    
                }
            }
            else if (word.toUpperCase().equals("Q"))
            {
                setExitType("quit");
            }
            else
            {
                System.out.println("Error: Invalid input. The fraction in memory will be set to zero.");
                fraction.setNumerator(0);
                fraction.setDenominator(1);
                //setExitType("exception");
            }    
        }
        return fraction;
    }
}