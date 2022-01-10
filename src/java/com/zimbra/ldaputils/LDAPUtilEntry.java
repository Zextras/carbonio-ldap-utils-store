// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

/*
 * Created on Sep 23, 2004
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.zimbra.ldaputils;

import java.util.Map;

import com.zimbra.cs.account.NamedEntry;
import com.zimbra.cs.account.Provisioning;
import com.zimbra.cs.account.ldap.entry.LdapEntry;
import com.zimbra.cs.ldap.LdapException;
import com.zimbra.cs.ldap.ZAttributes;

/**
 * @author Greg Solovyev
 */
public class LDAPUtilEntry extends NamedEntry  implements LdapEntry {

    protected String mDn;
    
    LDAPUtilEntry(String dn, ZAttributes attrs, Map<String, Object> defaults) throws LdapException {
        super(attrs.getAttrString(Provisioning.A_cn),
                attrs.getAttrString(Provisioning.A_cn),
                attrs.getAttrs(), defaults, null);
        mDn = dn;
    }

    public String getDN() {
        return mDn;
    }

}