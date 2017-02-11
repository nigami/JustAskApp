package com.justask.spring.exception;

public class JustAskException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JustAskException(String message)
	{
		super(message);
	}
	
	public JustAskException(String message, Throwable cause)
	{
		super(message,cause);
	}
}