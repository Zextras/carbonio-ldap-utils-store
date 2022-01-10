// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.ldaputils;

import java.util.Map;

import com.zimbra.cs.ldap.LdapException;
import com.zimbra.cs.ldap.ZAttributes;
/**
 * @author Greg Solovyev
 */
public class PosixAccount extends LDAPUtilEntry {
	private static final String A_uidNumber = "uidNumber";

	public PosixAccount(String dn, ZAttributes attrs,
            Map<String, Object> defaults) throws LdapException {
	    super(dn, attrs, defaults);
	    mId = attrs.getAttrString(A_uidNumber);
	}
	
    public String getId() {
        return getAttr(A_uidNumber);
    }
}
