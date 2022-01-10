// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.ldaputils;

import java.util.Map;

import com.zimbra.cs.account.NamedEntry;
import com.zimbra.cs.ldap.LdapException;
import com.zimbra.cs.ldap.ZAttributes;
/**
 * @author Greg Solovyev
 */
public class SambaDomain extends LDAPUtilEntry {

	private static final String A_sambaSID = "sambaSID";
	private static final String A_sambaDomainName = "sambaDomainName";	
	
	public SambaDomain(String dn, ZAttributes attrs, Map<String, Object> defaults) 
	throws LdapException {
        super(dn, attrs, defaults);
        mName = attrs.getAttrString(A_sambaSID);
        mId = attrs.getAttrString(A_sambaDomainName);
    }

    public String getId() {
        return getAttr(A_sambaSID);
    }

    public String getName() {
        return getAttr(A_sambaDomainName);
    }

    public int compareTo(Object obj) {
        if (!(obj instanceof NamedEntry))
            return 0;
        NamedEntry other = (NamedEntry) obj;
        return getName().compareTo(other.getName());
    }
}
