package com.chahatg.day3;

public class CustomException {
	public static void main(String[] args) {
		int num = 100;
		try {
			if(num > 25) {
				MyException e = new MyException("Number must be less than 25. It is " + num);
				throw e;
			}
		}
		catch(MyException me) {
			me.printStackTrace();
		}
	}
}

class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException(String errorMsg) {
        super(errorMsg);
    }
}
