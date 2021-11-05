package com.wema.myprofile.application.exception;

public class ProfileNotFoundException extends RuntimeException {

	public ProfileNotFoundException(Long id) {
		super("Could not find profile " + id);
	}
}