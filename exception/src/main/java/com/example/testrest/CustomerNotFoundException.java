package com.example.testrest;


public class CustomerNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(int id) {
        super("Customer id not found : " + id);
    }

}