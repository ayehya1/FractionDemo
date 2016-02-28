package fractiondemo;

public class Fraction implements Arithmetic, Comparable
{
    /**
     * The numerator
     */
    private int top;
    
    /**
     * The denominator.
     */
    private int bottom;
	
    /**
     * Computes the greatest common denominator of the specified
     * integers.
     * @param m an integer
     * @param n an integer
     * @return the greatest common denominator of the specified integer
     * or 1/0 when both integers are 0.	 
     */
    private int gCD(int m, int n)
    {
        if(m == 0)
        {
            if(n == 0)
                throw new IllegalArgumentException("gCD was invoked with both paramaters as 0.");
            else
                return Math.abs(n);
        }
        if(n == 0)
            return Math.abs(m);
        int remainder;
        m = Math.abs(m);
        n = Math.abs(n);
        int common = m;
        while(n != 0)
        {
            remainder = m % n;
            m = n;
            n = remainder;
            common = m;
        }
        return common;
    }

    /**
     * Creates 0/1
     */
    public Fraction()
    {
        top = 0;
        bottom = 1;
    }	
	
    /**
     * Creates a fraction with the specified numerator whose denominator is 1.
     * @param n numerator
     */
    public Fraction(int n)
    {
        top = n;
        bottom = 1;
    }    

    /**
     * Creates a fraction with the specified numerator and denominator
     * @param n numerator
     * @param d denominator
     * @throws IndeterminateFractionException when the denominator is 0
     */  
    public Fraction(int n, int d)
    {
        if(d == 0)
            throw new IndeterminateFractionException("The fraction constructor was invoked with a denominator 0.");
        top = n;
        bottom = d;
    }
    
    /**
     * Gives a string representation of this fraction in in-line notation
     * @return a string representation of this Fraction
     */
    @Override
    public String toString()
    {
        if(bottom < 0)
        {
            top = -top;
            bottom = -bottom;
        }
        return String.format("%d/%d", top, bottom);
    }   

    /**
     * Compares two fractions
     * @param obj fraction
     * @return true if the fractions are equal; otherwise, false.
     */
    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Fraction))
            return false;
        int common1 = gCD(top, bottom);
        Fraction f = (Fraction)obj;
        int common2 = gCD(f.top, f.bottom);
        return (top / common1) * (f.bottom / common2) == (bottom / common1) * (f.top / common2);
    }
    
    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public int compareTo(Object obj) 
    {
        if(!(obj instanceof Fraction))
            throw new IllegalArgumentException("The object does not hold a Fraction");
        return (top * ((Fraction)obj).bottom) - (bottom * ((Fraction)obj).top);
    }
    
    /**
     * Computes the sum of two fractions
     * @param obj object that holds a fraction
     * @return the sum of two fractions
     */
    @Override
    public Object add(Object obj) 
    {
        if(!(obj instanceof Fraction))
            throw new IllegalArgumentException("Addition was invoked with a non-Fraction paramter.");
        Fraction sum = new Fraction();
        Fraction f = (Fraction)obj;
        sum.top = (top * f.bottom) + (f.top * bottom);
        sum.bottom = bottom * f.bottom;
        int common = gCD(sum.top, sum.bottom);
        sum.top = sum.top / common;
        sum.bottom = sum.bottom / common;
        return sum;
    }

    /**
     * Computer the difference of two fractions
     * @param obj object that holds a fraction
     * @return the difference of two fractions
     */
    @Override
    public Object subtract(Object obj) 
    {
        if(!(obj instanceof Fraction))
            throw new IllegalArgumentException("Subtraction was invoked with a non-Fraction paramter.");
        Fraction difference = new Fraction();
        Fraction f = (Fraction)obj;
        difference.top = (top * f.bottom) - (f.top * bottom);
        difference.bottom = bottom * f.bottom;
        int common = gCD(difference.top, difference.bottom);
        difference.top = difference.top / common;
        difference.bottom = difference.bottom / common;
        return difference;
    }

    /**
     * Computes the product of two fractions
     * @param obj object that holds a fraction
     * @return the product of two fractions
     */
    @Override
    public Object multiply(Object obj) 
    {
        if(!(obj instanceof Fraction))
            throw new IllegalArgumentException("Multiplication was invoked with a non-Fraction paramter.");
        Fraction product = new Fraction();
        Fraction f = (Fraction)obj;
        product.top = top * f.top;
        product.bottom = bottom * f.bottom;
        int common = gCD(product.top, product.bottom);
        product.top = product.top / common;
        product.bottom = product.bottom / common;
        return product;
    }

    /**
     * Computes the quotient of two fractions
     * @param obj object that holds a fraction
     * @return the quotient of two fractions
     */
    @Override
    public Object divide(Object obj) 
    {
        if(!(obj instanceof Fraction))
            throw new IllegalArgumentException("Division was invoked with a non-Fraction paramter.");
        if(((Fraction)obj).top == 0)
            throw new ArithmeticException("Division was invoked with a divisor of 0.");
        Fraction f = (Fraction)obj;
        Fraction quotient = new Fraction();
        quotient.top = top * f.bottom;
        quotient.bottom = bottom * f.top;
        int common = gCD(quotient.top, quotient.bottom);
        quotient.top = quotient.top / common;
        quotient.bottom = quotient.bottom / common;
        return quotient;
    }

    
}
