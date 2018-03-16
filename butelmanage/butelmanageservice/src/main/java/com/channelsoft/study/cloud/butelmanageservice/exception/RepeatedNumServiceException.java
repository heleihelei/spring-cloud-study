package com.channelsoft.study.cloud.butelmanageservice.exception;

public class RepeatedNumServiceException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6093658367377425092L;

	public RepeatedNumServiceException() {
		super();
	}

	public RepeatedNumServiceException(String message) {
		super(message);
	}

	public RepeatedNumServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepeatedNumServiceException(Throwable cause) {
		super(cause);
	}
}
