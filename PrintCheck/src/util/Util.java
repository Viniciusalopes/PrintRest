/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author vinicius
 */
public class Util {

    /**
     * Gets a text about the reason for the exception.
     *
     * @param e Exception to get the message text.
     * @return
     */
    public static String getErrorMessage(Exception e) {
        return (e.getMessage() != null) ? e.getMessage()
                : ((e.getLocalizedMessage() != null) ? e.getLocalizedMessage()
                : ((e.getCause() != null) ? e.getCause().getMessage() : e.getStackTrace().toString()));
    }
}
