package com.jibo.aws.integration.helpers;

import android.text.TextUtils;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.loop.JiboLoopAsyncClient;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.aws.services.loop.model.Member;
import com.jibo.aws.integration.aws.services.loop.model.SuspendLoopRequest;
import com.jibo.aws.integration.util.Commons;
import com.jibo.aws.integration.util.DateTimeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LoopHelper {

    public static class MemberComparator implements Comparator<Member> {
        @Override // java.util.Comparator
        public int compare(Member member, Member member2) {
            String nickname = member.getNickname() != null ? member.getNickname() : member.getAccount().getFirstName();
            String nickname2 = member2.getNickname() != null ? member2.getNickname() : member2.getAccount().getFirstName();
            if (member.getAccount() == null || member2.getAccount() == null) {
                return 0;
            }
            return nickname.compareTo(nickname2);
        }
    }

    public static String checkPreferredNameError(Loop loop, String str) {
        if (loop == null) {
            return null;
        }
        for (Member member : loop.getMembers()) {
            if (member.getNickname() == null || member.getStatus() == Member.InvitationStatus.removed) {
                if (member.getAccount() != null && member.getAccount().getFirstName() != null && member.getAccount().getFirstName().equalsIgnoreCase(str) && member.getStatus() != Member.InvitationStatus.removed) {
                    return member.getAccount().getFullName();
                }
            } else if (member.getNickname().equalsIgnoreCase(str)) {
                return member.getAccount().getFullName();
            }
        }
        return null;
    }

    public static boolean doesLoopHavePlace(Loop loop) {
        return 16 > getActiveMembersCount(loop);
    }

    public static List<String> getAccountIds(Loop loop, Member.InvitationStatus invitationStatus, String... strArr) {
        ArrayList arrayList = new ArrayList();
        if (loop == null) {
            return arrayList;
        }
        List listAsList = strArr != null ? Arrays.asList(strArr) : new ArrayList();
        for (Member member : loop.getMembers()) {
            if (!TextUtils.isEmpty(member.getAccountId()) && listAsList.indexOf(member.getAccountId()) == -1 && member.getAccount() != null && (TextUtils.isEmpty(member.getAccount().getEmail()) || (!TextUtils.isEmpty(member.getAccount().getEmail()) && listAsList.indexOf(member.getAccount().getEmail()) == -1))) {
                if (invitationStatus == null || (invitationStatus != null && invitationStatus == member.getStatus())) {
                    arrayList.add(member.getAccountId());
                }
            }
        }
        return arrayList;
    }

    public static int getActiveMembersCount(Loop loop) {
        int i = 0;
        if (loop == null) {
            return 0;
        }
        Iterator<Member> it = loop.getMembers().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            Member next = it.next();
            if (!loop.getRobot().equals(next.getAccountId()) && isMemberActiveOrAdded(next)) {
                i2++;
            }
            i = i2;
        }
    }

    public static Member getFirstUnenrolledMember(Loop loop) {
        Member next;
        if (loop == null) {
            return null;
        }
        Iterator<Member> it = loop.getMembers().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!next.isEnrolled()) {
                break;
            }
        }
        return next;
    }

    public static Member getMemberByIdOrEmail(Loop loop, String str) {
        if (loop == null || TextUtils.isEmpty(str)) {
            return null;
        }
        for (Member member : loop.getMembers()) {
            if (!isMemberRemoved(member)) {
                if (member.getId().equals(str)) {
                    return member;
                }
                if (!TextUtils.isEmpty(member.getAccountId()) && member.getAccountId().equals(str)) {
                    return member;
                }
                if (member.getAccount() != null && !TextUtils.isEmpty(member.getAccount().getEmail()) && member.getAccount().getEmail().equals(str)) {
                    return member;
                }
            }
        }
        return null;
    }

    public static Member getMemberForAccount(Loop loop, Account account) {
        if (account == null || account == null) {
            return null;
        }
        Member memberByIdOrEmail = getMemberByIdOrEmail(loop, account.getId());
        return memberByIdOrEmail == null ? getMemberByIdOrEmail(loop, account.getEmail()) : memberByIdOrEmail;
    }

    public static List<String> getMembersNicknames(Loop loop) {
        ArrayList arrayList = new ArrayList();
        if (loop == null) {
            return arrayList;
        }
        for (Member member : loop.getMembers()) {
            if (isMemberActiveOrAdded(member)) {
                if (member.getNickname() != null && !member.getNickname().isEmpty()) {
                    arrayList.add(member.getNickname());
                } else if (member.getAccount() != null && member.getAccount().getFirstName() != null) {
                    arrayList.add(member.getAccount().getFirstName());
                }
            }
        }
        return arrayList;
    }

    public static Member getOwner(Loop loop) {
        return getMemberByIdOrEmail(loop, loop.getOwner());
    }

    public static Member getRobot(Loop loop) {
        return getMemberByIdOrEmail(loop, loop.getRobot());
    }

    public static int getUnenrolledMembersCount(Loop loop) {
        int i = 0;
        if (loop == null) {
            return 0;
        }
        Iterator<Member> it = loop.getMembers().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = !it.next().isEnrolled() ? i2 + 1 : i2;
        }
    }

    public static boolean hasInvitationsOnly(List<Loop> list, String str) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<Loop> it = list.iterator();
        while (it.hasNext()) {
            if (!isMemberInvited(it.next(), str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCurrentUser(Member member, Account account) {
        return (member == null || account == null || TextUtils.isEmpty(member.getAccountId()) || !member.getAccountId().equals(account.getId())) ? false : true;
    }

    public static boolean isMemberAccepted(Loop loop, String str) {
        return isMemberAccepted(getMemberByIdOrEmail(loop, str));
    }

    public static boolean isMemberAccepted(Member member) {
        return member != null && ((!DateTimeUtils.isAdult(member.getAccount().getBirthday()) && member.getStatus() == Member.InvitationStatus.accepted) || (DateTimeUtils.isAdult(member.getAccount().getBirthday()) && member.getStatus() == Member.InvitationStatus.accepted && !TextUtils.isEmpty(member.getAccount().getEmail())));
    }

    public static boolean isMemberAcceptedOrAdded(Member member) {
        return member != null && ((!DateTimeUtils.isAdult(member.getAccount().getBirthday()) && member.getStatus() == Member.InvitationStatus.accepted) || (DateTimeUtils.isAdult(member.getAccount().getBirthday()) && member.getStatus() == Member.InvitationStatus.accepted));
    }

    public static boolean isMemberActive(Member member) {
        return (member == null || member.getAccount() == null || (!isMemberAccepted(member) && !isMemberInvited(member))) ? false : true;
    }

    public static boolean isMemberActiveOrAdded(Member member) {
        return (member == null || member.getAccount() == null || (!isMemberAcceptedOrAdded(member) && !isMemberInvited(member))) ? false : true;
    }

    public static boolean isMemberDeclined(Loop loop, String str) {
        return isMemberDeclined(getMemberByIdOrEmail(loop, str));
    }

    public static boolean isMemberDeclined(Member member) {
        return member != null && member.getStatus() == Member.InvitationStatus.declined;
    }

    public static boolean isMemberInvited(Loop loop, String str) {
        return isMemberInvited(getMemberByIdOrEmail(loop, str));
    }

    public static boolean isMemberInvited(Member member) {
        return member != null && member.getStatus() == Member.InvitationStatus.invited;
    }

    public static boolean isMemberRemoved(Member member) {
        return member != null && member.getStatus() == Member.InvitationStatus.removed;
    }

    public static boolean isMemberShowable(boolean z, Member member) {
        if (member == null) {
            return false;
        }
        boolean zIsAdult = DateTimeUtils.isAdult(member.getAccount().getBirthday());
        if (member.getAccount() == null || TextUtils.isEmpty(member.getAccount().getFirstName()) || TextUtils.isEmpty(member.getAccount().getLastName())) {
            return false;
        }
        if (member.getStatus() == Member.InvitationStatus.accepted || member.getStatus() == Member.InvitationStatus.invited) {
            return z || zIsAdult || (!zIsAdult && member.getStatus() == Member.InvitationStatus.accepted);
        }
        return false;
    }

    public static boolean isOwner(Loop loop, String str) {
        return (loop == null || TextUtils.isEmpty(str) || !str.equals(loop.getOwner())) ? false : true;
    }

    public static boolean isRobot(Loop loop, String str) {
        return (loop == null || TextUtils.isEmpty(str) || !str.equals(loop.getRobot())) ? false : true;
    }

    public static List<Member> sortMembers(Loop loop, Member member) {
        ArrayList arrayList = new ArrayList();
        if (loop == null || member == null) {
            return arrayList;
        }
        Member owner = getOwner(loop);
        boolean zIsOwner = isOwner(loop, member.getAccountId());
        ArrayList<Member> arrayList2 = new ArrayList();
        arrayList2.addAll(loop.getMembers());
        arrayList2.remove(owner);
        arrayList2.remove(getRobot(loop));
        for (Member member2 : arrayList2) {
            if (isMemberShowable(zIsOwner, member2)) {
                arrayList.add(member2);
            }
        }
        Collections.sort(arrayList, new MemberComparator());
        arrayList.add(0, owner);
        return arrayList;
    }

    public static void suspendLoop(String str, final Commons.AsyncCallback<Object> asyncCallback) {
        new JiboLoopAsyncClient(new BasicAWSCredentials("sj7ynQgDKXvjMCtZp3sr", "vwsXCWm1FF5oe946hvls5AxvGeLUXnq06BPWlVex")).suspendLoop(str, new AsyncHandler<SuspendLoopRequest, CommandResponse>() { // from class: com.jibo.aws.integration.helpers.LoopHelper.1
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                asyncCallback.onError(exc);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            public void onSuccess(SuspendLoopRequest suspendLoopRequest, CommandResponse commandResponse) {
                asyncCallback.onSuccess(suspendLoopRequest);
            }
        });
    }
}
