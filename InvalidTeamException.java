package game;

import org.omg.CORBA.DynAnyPackage.Invalid;

/**
 * Created by Jason on 8/1/2018.
 */
public class InvalidTeamException extends Exception
{
    public InvalidTeamException(String message)
    {
        super(message);
    }
}
