package com.employeeMgmt.Exception;

import java.io.Serializable;


public class EmployeMgmtAppException extends Exception implements Serializable
{
    private static final long serialVersionUID = 1L;
    public EmployeMgmtAppException() {
        super();
    }
    public EmployeMgmtAppException(String msg)   {
        super(msg);
    }
    public EmployeMgmtAppException(String msg, Exception e)  {
        super(msg, e);
    }
}