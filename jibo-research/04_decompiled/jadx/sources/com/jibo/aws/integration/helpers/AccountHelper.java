package com.jibo.aws.integration.helpers;

import com.jibo.aws.integration.aws.services.loop.model.MemberAccount;

/* JADX INFO: loaded from: classes.dex */
public class AccountHelper {
    public static String getName(MemberAccount memberAccount) {
        return memberAccount.getNickName() == null ? memberAccount.getFirstName() : memberAccount.getNickName();
    }
}
