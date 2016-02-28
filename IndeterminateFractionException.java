package fractiondemo;

public class IndeterminateFractionException extends NumberFormatException
{
    /**
     * A default constructor that creates an IndeterminateFractionException object
     */
    public IndeterminateFractionException()
    {
        super();
    }
    /**
     * creates an object of this class.
     * @param msg a string describing why the exception occurred.
     */
    public IndeterminateFractionException(String msg)
    {
        super(msg);
    }
}
