// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

/*
 * Created on Jun 1, 2004
 *
 */
package com.zimbra.ldaputils;

import com.zimbra.common.service.ServiceException;


/**
 * @author schemers
 * 
 */
@SuppressWarnings("serial")
public class ZimbraLDAPUtilsServiceException extends ServiceException {

    public static final String DN_EXISTS  = "zimblraldaputils.DN_EXISTS";
    
    private ZimbraLDAPUtilsServiceException(String message, String code, boolean isReceiversFault, Throwable cause) {
        super(message, code, isReceiversFault, cause);
    }
    
    public static ZimbraLDAPUtilsServiceException DN_EXISTS(String dn) {
    	return new ZimbraLDAPUtilsServiceException("dn already exists: "+dn, DN_EXISTS, SENDERS_FAULT, null);
    }
}
