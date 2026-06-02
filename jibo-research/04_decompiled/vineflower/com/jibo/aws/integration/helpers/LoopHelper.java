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

public class LoopHelper {
   public static String checkPreferredNameError(Loop var0, String var1) {
      String var3;
      if (var0 == null) {
         var3 = null;
      } else {
         Iterator var2 = var0.getMembers().iterator();

         while (true) {
            if (!var2.hasNext()) {
               var3 = null;
               break;
            }

            Member var4 = (Member)var2.next();
            if (var4.getNickname() != null && var4.getStatus() != Member.InvitationStatus.removed) {
               if (var4.getNickname().equalsIgnoreCase(var1)) {
                  var3 = var4.getAccount().getFullName();
                  break;
               }
            } else if (var4.getAccount() != null
               && var4.getAccount().getFirstName() != null
               && var4.getAccount().getFirstName().equalsIgnoreCase(var1)
               && var4.getStatus() != Member.InvitationStatus.removed) {
               var3 = var4.getAccount().getFullName();
               break;
            }
         }
      }

      return var3;
   }

   public static boolean doesLoopHavePlace(Loop var0) {
      boolean var1;
      if (16 > getActiveMembersCount(var0)) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static List<String> getAccountIds(Loop var0, Member.InvitationStatus var1, String... var2) {
      ArrayList var3 = new ArrayList();
      if (var0 != null) {
         List var6;
         if (var2 != null) {
            var6 = Arrays.asList(var2);
         } else {
            var6 = new ArrayList();
         }

         for (Member var4 : var0.getMembers()) {
            if (!TextUtils.isEmpty(var4.getAccountId())
               && var6.indexOf(var4.getAccountId()) == -1
               && var4.getAccount() != null
               && (
                  TextUtils.isEmpty(var4.getAccount().getEmail())
                     || !TextUtils.isEmpty(var4.getAccount().getEmail()) && var6.indexOf(var4.getAccount().getEmail()) == -1
               )
               && (var1 == null || var1 != null && var1 == var4.getStatus())) {
               var3.add(var4.getAccountId());
            }
         }
      }

      return var3;
   }

   public static int getActiveMembersCount(Loop var0) {
      int var1 = 0;
      if (var0 != null) {
         Iterator var2 = var0.getMembers().iterator();
         var1 = 0;

         while (var2.hasNext()) {
            Member var3 = (Member)var2.next();
            if (!var0.getRobot().equals(var3.getAccountId()) && isMemberActiveOrAdded(var3)) {
               var1++;
            }
         }
      }

      return var1;
   }

   public static Member getFirstUnenrolledMember(Loop var0) {
      Iterator var1 = null;
      Member var2;
      if (var0 == null) {
         var2 = var1;
      } else {
         var1 = var0.getMembers().iterator();

         do {
            if (!var1.hasNext()) {
               var2 = null;
               break;
            }

            var2 = (Member)var1.next();
         } while (var2.isEnrolled());
      }

      return var2;
   }

   public static Member getMemberByIdOrEmail(Loop var0, String var1) {
      Member var4;
      if (var0 != null && !TextUtils.isEmpty(var1)) {
         Iterator var3 = var0.getMembers().iterator();

         while (true) {
            if (!var3.hasNext()) {
               var4 = null;
               break;
            }

            Member var2 = (Member)var3.next();
            if (!isMemberRemoved(var2)) {
               var4 = var2;
               if (var2.getId().equals(var1)) {
                  break;
               }

               if (!TextUtils.isEmpty(var2.getAccountId())) {
                  var4 = var2;
                  if (var2.getAccountId().equals(var1)) {
                     break;
                  }
               }

               if (var2.getAccount() != null && !TextUtils.isEmpty(var2.getAccount().getEmail()) && var2.getAccount().getEmail().equals(var1)) {
                  var4 = var2;
                  break;
               }
            }
         }
      } else {
         var4 = null;
      }

      return var4;
   }

   public static Member getMemberForAccount(Loop var0, Account var1) {
      Member var2;
      if (var1 != null && var1 != null) {
         Member var3 = getMemberByIdOrEmail(var0, var1.getId());
         var2 = var3;
         if (var3 == null) {
            var2 = getMemberByIdOrEmail(var0, var1.getEmail());
         }
      } else {
         var2 = null;
      }

      return var2;
   }

   public static List<String> getMembersNicknames(Loop var0) {
      ArrayList var1 = new ArrayList();
      if (var0 != null) {
         for (Member var3 : var0.getMembers()) {
            if (isMemberActiveOrAdded(var3)) {
               if (var3.getNickname() != null && !var3.getNickname().isEmpty()) {
                  var1.add(var3.getNickname());
               } else if (var3.getAccount() != null && var3.getAccount().getFirstName() != null) {
                  var1.add(var3.getAccount().getFirstName());
               }
            }
         }
      }

      return var1;
   }

   public static Member getOwner(Loop var0) {
      return getMemberByIdOrEmail(var0, var0.getOwner());
   }

   public static Member getRobot(Loop var0) {
      return getMemberByIdOrEmail(var0, var0.getRobot());
   }

   public static int getUnenrolledMembersCount(Loop var0) {
      int var1 = 0;
      if (var0 != null) {
         Iterator var2 = var0.getMembers().iterator();
         var1 = 0;

         while (var2.hasNext()) {
            if (!((Member)var2.next()).isEnrolled()) {
               var1++;
            }
         }
      }

      return var1;
   }

   public static boolean hasInvitationsOnly(List<Loop> var0, String var1) {
      boolean var2;
      if (var0 != null && !var0.isEmpty()) {
         Iterator var3 = var0.iterator();

         while (true) {
            if (!var3.hasNext()) {
               var2 = true;
               break;
            }

            if (!isMemberInvited((Loop)var3.next(), var1)) {
               var2 = false;
               break;
            }
         }
      } else {
         var2 = false;
      }

      return var2;
   }

   public static boolean isCurrentUser(Member var0, Account var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if (var0 != null) {
         if (var1 == null) {
            var2 = var3;
         } else {
            var2 = var3;
            if (!TextUtils.isEmpty(var0.getAccountId())) {
               var2 = var3;
               if (var0.getAccountId().equals(var1.getId())) {
                  var2 = true;
               }
            }
         }
      }

      return var2;
   }

   public static boolean isMemberAccepted(Loop var0, String var1) {
      return isMemberAccepted(getMemberByIdOrEmail(var0, var1));
   }

   public static boolean isMemberAccepted(Member var0) {
      boolean var1;
      if (var0 == null
         || (DateTimeUtils.isAdult(var0.getAccount().getBirthday()) || var0.getStatus() != Member.InvitationStatus.accepted)
            && (
               !DateTimeUtils.isAdult(var0.getAccount().getBirthday())
                  || var0.getStatus() != Member.InvitationStatus.accepted
                  || TextUtils.isEmpty(var0.getAccount().getEmail())
            )) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static boolean isMemberAcceptedOrAdded(Member var0) {
      boolean var1;
      if (var0 == null
         || (DateTimeUtils.isAdult(var0.getAccount().getBirthday()) || var0.getStatus() != Member.InvitationStatus.accepted)
            && (!DateTimeUtils.isAdult(var0.getAccount().getBirthday()) || var0.getStatus() != Member.InvitationStatus.accepted)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static boolean isMemberActive(Member var0) {
      boolean var1;
      if (var0 == null || var0.getAccount() == null || !isMemberAccepted(var0) && !isMemberInvited(var0)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static boolean isMemberActiveOrAdded(Member var0) {
      boolean var1;
      if (var0 == null || var0.getAccount() == null || !isMemberAcceptedOrAdded(var0) && !isMemberInvited(var0)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public static boolean isMemberDeclined(Loop var0, String var1) {
      return isMemberDeclined(getMemberByIdOrEmail(var0, var1));
   }

   public static boolean isMemberDeclined(Member var0) {
      boolean var1;
      if (var0 != null && var0.getStatus() == Member.InvitationStatus.declined) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static boolean isMemberInvited(Loop var0, String var1) {
      return isMemberInvited(getMemberByIdOrEmail(var0, var1));
   }

   public static boolean isMemberInvited(Member var0) {
      boolean var1;
      if (var0 != null && var0.getStatus() == Member.InvitationStatus.invited) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static boolean isMemberRemoved(Member var0) {
      boolean var1;
      if (var0 != null && var0.getStatus() == Member.InvitationStatus.removed) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public static boolean isMemberShowable(boolean var0, Member var1) {
      boolean var3 = false;
      boolean var2;
      if (var1 == null) {
         var2 = var3;
      } else {
         boolean var4 = DateTimeUtils.isAdult(var1.getAccount().getBirthday());
         var2 = var3;
         if (var1.getAccount() != null) {
            var2 = var3;
            if (!TextUtils.isEmpty(var1.getAccount().getFirstName())) {
               var2 = var3;
               if (!TextUtils.isEmpty(var1.getAccount().getLastName())) {
                  if (var1.getStatus() != Member.InvitationStatus.accepted) {
                     var2 = var3;
                     if (var1.getStatus() != Member.InvitationStatus.invited) {
                        return var2;
                     }
                  }

                  if (!var0 && !var4) {
                     var2 = var3;
                     if (var4) {
                        return var2;
                     }

                     var2 = var3;
                     if (var1.getStatus() != Member.InvitationStatus.accepted) {
                        return var2;
                     }
                  }

                  var2 = true;
               }
            }
         }
      }

      return var2;
   }

   public static boolean isOwner(Loop var0, String var1) {
      boolean var2;
      if (var0 != null && !TextUtils.isEmpty(var1) && var1.equals(var0.getOwner())) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public static boolean isRobot(Loop var0, String var1) {
      boolean var2;
      if (var0 != null && !TextUtils.isEmpty(var1) && var1.equals(var0.getRobot())) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public static List<Member> sortMembers(Loop var0, Member var1) {
      ArrayList var3 = new ArrayList();
      if (var0 != null && var1 != null) {
         Member var4 = getOwner(var0);
         boolean var2 = isOwner(var0, var1.getAccountId());
         ArrayList var6 = new ArrayList();
         var6.addAll(var0.getMembers());
         var6.remove(var4);
         var6.remove(getRobot(var0));

         for (Member var5 : var6) {
            if (isMemberShowable(var2, var5)) {
               var3.add(var5);
            }
         }

         Collections.sort(var3, new LoopHelper.MemberComparator());
         var3.add(0, var4);
      }

      return var3;
   }

   public static void suspendLoop(String var0, Commons.AsyncCallback<Object> var1) {
      new JiboLoopAsyncClient(new BasicAWSCredentials("sj7ynQgDKXvjMCtZp3sr", "vwsXCWm1FF5oe946hvls5AxvGeLUXnq06BPWlVex"))
         .suspendLoop(var0, new AsyncHandler<SuspendLoopRequest, CommandResponse>(var1) {
            final Commons.AsyncCallback a;

            {
               this.a = var1;
            }

            @Override
            public void onError(Exception var1) {
               this.a.onError(var1);
            }

            public void onSuccess(SuspendLoopRequest var1, CommandResponse var2) {
               this.a.onSuccess(var1);
            }
         });
   }

   public static class MemberComparator implements Comparator<Member> {
      public int compare(Member var1, Member var2) {
         String var4;
         if (var1.getNickname() != null) {
            var4 = var1.getNickname();
         } else {
            var4 = var1.getAccount().getFirstName();
         }

         String var5;
         if (var2.getNickname() != null) {
            var5 = var2.getNickname();
         } else {
            var5 = var2.getAccount().getFirstName();
         }

         int var3;
         if (var1.getAccount() != null && var2.getAccount() != null) {
            var3 = var4.compareTo(var5);
         } else {
            var3 = 0;
         }

         return var3;
      }
   }
}
