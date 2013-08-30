/*******************************************************************************
 * Copyright (c) 2010 - 2013 Ushahidi Inc.
 * All rights reserved
 * Website: http://www.ushahidi.com
 *
 * GNU AFFERO GENERAL PUBLIC LICENSE Version 3 Usage
 * This file may be used under the terms of the GNU AFFERO GENERAL
 * PUBLIC LICENSE Version 3 as published by the Free Software
 * Foundation and appearing in the file LICENSE included in the
 * packaging of this file. Please review the following information to
 * ensure the GNU AFFERO GENERAL PUBLIC LICENSE Version 3 requirements
 * will be met: http://www.gnu.org/licenses/agpl.html.
 ******************************************************************************/
package com.crowdmap.java.sdk;

/**
 * Handles all exception
 */
public class CrowdmapException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6639204130451563983L;

	/**
	 * Instantiates a new Crowdmap exception.
	 */
	public CrowdmapException() {
	}

	/**
	 * Instantiates a new Crowdmap exception.
	 * 
	 * @param cause
	 *            the cause
	 */
	public CrowdmapException(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 * @param message
	 *            The message be shown
	 */
	public CrowdmapException(String message) {
		super(message);
	}

	/**
	 * 
	 * @param message
	 *            The message to be shown.
	 * @param cause
	 *            The cause of the exception.
	 */
	public CrowdmapException(String message, Throwable cause) {
		super(message, cause);
	}
}
