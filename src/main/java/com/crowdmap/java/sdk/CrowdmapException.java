/*****************************************************************************
 ** Copyright (c) 2010 - 2012 Crowdmap Inc
 ** All rights reserved
 ** Contact: team@Crowdmap.com
 ** Website: http://www.Crowdmap.com
 **
 ** GNU Lesser General Public License Usage
 ** This file may be used under the terms of the GNU Lesser
 ** General Public License version 3 as published by the Free Software
 ** Foundation and appearing in the file LICENSE.LGPL included in the
 ** packaging of this file. Please review the following information to
 ** ensure the GNU Lesser General Public License version 3 requirements
 ** will be met: http://www.gnu.org/licenses/lgpl.html.
 **
 **
 ** If you have questions regarding the use of this file, please contact
 ** Crowdmap developers at team@Crowdmap.com.
 **
 *****************************************************************************/
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
