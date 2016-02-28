package fractiondemo;

public interface Arithmetic 
{
    /**
     * computes and returns the sum of two objects of a class
     * @param obj object
     * @return the sum of the two objects
     */
    public Object add(Object obj);
    
    /**
     * computes and returns the difference of two objects of a class
     * @param obj object
     * @return the difference of the two objects
     */
    public Object subtract(Object obj);
    
    /**
     * computes and returns the product of two objects of a class
     * @param obj object
     * @return the product of the two objects
     */
    public Object multiply(Object obj);
    
    /**
     * computes and returns the quotient of two objects of a class
     * @param obj object
     * @return the quotient of the two object
     */
    public Object divide(Object obj);
}
