// SPDX-FileCopyrightText: 2022 Synacor, Inc.
// SPDX-FileCopyrightText: 2022 Zextras <https://www.zextras.com>
//
// SPDX-License-Identifier: GPL-2.0-only

package com.zimbra.ldaputils;

import java.util.Map;

import com.zimbra.common.service.ServiceException;
import com.zimbra.common.util.ZimbraLog;
import com.zimbra.cs.account.NamedEntry;
import com.zimbra.cs.service.admin.AdminDocumentHandler;
import com.zimbra.common.soap.Element;
import com.zimbra.common.soap.LDAPUtilsConstants;
import com.zimbra.soap.ZimbraSoapContext;
/**
 * @author Greg Solovyev
 */
public class RenameLDAPEntry extends AdminDocumentHandler {

    public Element handle(Element request, Map<String, Object> context)
            throws ServiceException {

        ZimbraSoapContext lc = getZimbraSoapContext(context);
        String dn = request.getAttribute(LDAPUtilsConstants.E_DN);
        String newDN = request.getAttribute(LDAPUtilsConstants.E_NEW_DN);

        NamedEntry ne = LDAPUtilsHelper.getInstance().renameLDAPEntry(dn,  newDN);

        ZimbraLog.security.info(ZimbraLog.encodeAttrs(new String[] { "cmd",
                "RenameLDAPEntry", "dn", dn,"new_dn", newDN}, null));

        Element response = lc
                .createElement(LDAPUtilsConstants.RENAME_LDAP_ENTRY_RESPONSE);
        ZimbraLDAPUtilsService.encodeLDAPEntry(response, ne);

        return response;
    }
}
