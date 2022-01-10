// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.ldaputils;

import java.util.Map;

import com.zimbra.common.service.ServiceException;
import com.zimbra.cs.service.admin.AdminDocumentHandler;
import com.zimbra.common.soap.Element;
import com.zimbra.common.soap.LDAPUtilsConstants;
import com.zimbra.common.util.ZimbraLog;
import com.zimbra.soap.ZimbraSoapContext;

/**
 * @author Greg Solovyev
 */
public class DeleteLDAPEntry extends AdminDocumentHandler {

    public Element handle(Element request, Map<String, Object> context)
    throws ServiceException {
        ZimbraSoapContext lc = getZimbraSoapContext(context);
        String dn = request.getAttribute(LDAPUtilsConstants.E_DN);

        LDAPUtilsHelper.getInstance().deleteLDAPEntry(dn);

        ZimbraLog.security.info(ZimbraLog.encodeAttrs(
                new String[] {"cmd", "DeleteLDAPEntry","dn", dn}));

        Element response = lc.createElement(LDAPUtilsConstants.DELETE_LDAP_ENTRY_RESPONSE);
        return response;
    }

}
