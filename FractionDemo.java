package fractiondemo;
import static java.lang.Integer.parseInt;
import java.util.Scanner;


public class FractionDemo 
{

    public static void main(String[] args) 
    {
        Scanner frac = new Scanner(System.in);
        System.out.print("Enter the first fraction -> ");
        String[] firstFrac = frac.nextLine().split("/");
        Object first = new Fraction(Integer.parseInt(firstFrac[0]), Integer.parseInt(firstFrac[1]));
        System.out.print("Enter the second fraction -> ");
        String[] secondFrac = frac.nextLine().split("/");
        Object second = new Fraction(Integer.parseInt(secondFrac[0]), Integer.parseInt(secondFrac[1]));
        System.out.print("Enter the third fraction -> ");
        String[] thirdFrac = frac.nextLine().split("/");
        Object third = new Fraction(Integer.parseInt(thirdFrac[0]), Integer.parseInt(thirdFrac[1]));
        System.out.print("Enter the fourth fraction -> ");
        String[] fourthFrac = frac.nextLine().split("/");
        Object fourth = new Fraction(Integer.parseInt(fourthFrac[0]), Integer.parseInt(fourthFrac[1]));
        Fraction frac1 = (Fraction)first;
        Fraction frac2 = (Fraction)second;
        Fraction frac3 = (Fraction)third;
        Fraction frac4 = (Fraction)fourth;
        System.out.printf("%nf1 = %s, f2 = %s, f3 = %s, f4 = %s.%n%n", frac1, frac2, frac3, frac4);
        System.out.printf("f1 + f3 = %s%n", frac1.add(frac3));
        System.out.printf("f3 x (f4 - f2) / (f3 - f4) = %s%n", frac3.multiply(((Fraction)frac4.subtract(frac2)).divide(frac3.subtract(frac4))));
        System.out.printf("f3^6 = %s%n", frac3.multiply(frac3.multiply(frac3.multiply(frac3.multiply(frac3.multiply(frac3))))));
        System.out.printf("(f1 / f2) / (f2 + f4) = %s%n", ((Fraction)frac1.divide(frac2)).divide(frac2.add(frac4)));
        System.out.printf("5 / (f3 x f4) = %s%n", new Fraction(5).divide(frac3.multiply(frac4)));
        System.out.println("Is f1(f2 - f3) equal to f1f2 - f1f3? " + ((Fraction)frac1.multiply(frac2.subtract(frac3))).equals(((Fraction)(frac1.multiply(frac2))).subtract(frac1.multiply(frac3))));
        int comp = ((Fraction)(frac1.divide(frac2.add(frac3)))).compareTo(((Fraction)frac1.divide(frac2)).subtract(frac1.divide(frac3)));
        if(comp > 0)
            System.out.println("f1/(f2 + f3) is greater than f1/f2 - f1/f3");
        else if(comp < 0)
            System.out.println("f1/(f2 + f3) is less than f1/f2 - f1/f3");
        else
            System.out.println("f1/(f2 + f3) is less than f1/f2 - f1/f3");
    }
    
}
