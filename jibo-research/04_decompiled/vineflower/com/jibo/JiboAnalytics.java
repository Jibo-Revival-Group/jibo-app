package com.jibo;

import android.content.Context;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.segment.analytics.Analytics;
import com.segment.analytics.Properties;
import com.segment.analytics.Traits;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class JiboAnalytics {
   public static String A = "read_more_coppa";
   public static String B = "location_set";
   public static String C = "photo_deleted";
   public static String D = "holiday";
   public static String E = "guided_user_swiped_back";
   public static String F = "guided_location_sync";
   public static String G = "guided_custom_avatar_selected";
   public static String H = "app_download";
   public static String I = "email";
   public static String J = "account_association";
   public static String K = "$first_name";
   public static String L = "$last_name";
   public static String M = "acct_created_date";
   public static String N = "date_of_birth";
   public static String O = "age";
   public static String P = "avatar_assigned";
   public static String Q = "#_invites_sent";
   public static String R = "robot_ID";
   public static String S = "#_invites_received";
   public static String T = "#_invites_accepted";
   public static String U = "existing_acct";
   public static String V = "content_type";
   public static String W = "people.append";
   public static String X = "#_questions_answered";
   public static String Y = "questions_answered";
   public static String Z = "#_invites_enrolled";
   public static String a = "app_download";
   public static String aA = "text";
   public static String aB = "push_notification";
   public static String aC = "organic";
   public static String aD = "jibo_no_use";
   public static String aE = "app_no_use";
   public static String aF = "app_malfunction";
   public static String aG = "other";
   public static String aH = "tips";
   public static String aI = "tab";
   public static String aJ = "account_settings";
   public static String aK = "jibo_at_a_glance";
   public static String aL = "bot_basics";
   public static String aM = "caring_for_jibo";
   public static String aN = "the_loop";
   public static String aO = "talking_with_jibo";
   public static String aP = "how_to_videos";
   public static String aQ = "birthday";
   public static String aa = "#_invites_abandoned";
   public static String ab = "#_invites_rejected";
   public static String ac = "#_ppl_tagged";
   public static String ad = "message_reply_sent";
   public static String ae = "photo_destination";
   public static String af = "#_photos_shared";
   public static String ag = "#_app_opens";
   public static String ah = "#_text_posts";
   public static String ai = "#_photo_posts";
   public static String aj = "viewed_from";
   public static String ak = "reason";
   public static String al = "screen";
   public static String am = "type";
   public static String an = "automatic";
   public static String ao = "manual";
   public static String ap = "holiday_name";
   public static String aq = "holiday_toggle";
   public static String ar = "timestamp";
   public static String as = "direct";
   public static String at = "invite";
   public static String au = "new_robot";
   public static String av = "existing_robot";
   public static String aw = "direct from store";
   public static String ax = "invite via deep link";
   public static String ay = "video";
   public static String az = "photo";
   public static String b = "account_creation_start";
   public static String c = "account_creation_finish";
   public static String d = "setup_new_robot";
   public static String e = "personalization_survey";
   public static String f = "loop_invites_sent";
   public static String g = "loop_invites_received";
   public static String h = "loop_invite_accepted";
   public static String i = "loop_invite_abandoned";
   public static String j = "loop_invite_rejected";
   public static String k = "post_to_loop_feed";
   public static String l = "feed_opened";
   public static String m = "account_deleted";
   public static String n = "account_delete_started";
   public static String o = "account_delete_finished";
   public static String p = "ph_number_added_pre_account";
   public static String q = "ph_number_added_post_account";
   public static String r = "view_gallery";
   public static String s = "view_image";
   public static String t = "share_sheet_selected";
   public static String u = "setup_new_jibo";
   public static String v = "view_attribution_page";
   public static String w = "tips_opened";
   public static String x = "find_answer";
   public static String y = "contact_support";
   public static String z = "tips_item";

   private static String a() {
      return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Calendar.getInstance().getTime());
   }

   public static void a(Context var0) {
      h(var0, n);
   }

   public static void a(Context var0, Account var1) {
      Analytics.with(var0).identify(var1.getId(), new Traits().putName(var1.getFullName()).putEmail(var1.getEmail()).putValue(ar, a()), null);
   }

   public static void a(Context var0, Account var1, boolean var2, int var3) {
      Properties var4 = new Properties();
      if (var2) {
         var4.put(J, au);
      } else {
         var4.put(J, av);
      }

      var4.put(K, var1.getFirstName());
      var4.put(L, var1.getLastName());
      var4.put(M, DateTimeUtils.getCurrentDate(var0, DateTimeUtils.ANALYTICS_FORMAT));
      if (var1.getBirthday() != null) {
         var4.put(N, DateTimeUtils.getFormattedDate(var1.getBirthday(), DateTimeUtils.ANALYTICS_FORMAT));
         var4.put(O, DateTimeUtils.getAge(var1.getBirthday()));
      }

      var4.put(ag, var3);
      a(var0, c, var4);
   }

   public static void a(Context var0, String var1) {
      Properties var2 = new Properties();
      var2.put(I, var1);
      a(var0, b, var2);
   }

   public static void a(Context var0, String var1, long var2) {
      Properties var4 = new Properties();
      var4.put(Q, 1);
      var4.put(R, var1);
      var4.put(aQ, var2);
      a(var0, f, var4);
   }

   private static void a(Context var0, String var1, Object var2) {
      var2 = var2;
      var2.put(ar, a());
      Analytics.with(var0).track(var1, var2);
   }

   public static void a(Context var0, String var1, boolean var2) {
      Properties var3 = new Properties();
      var3.put(ap, var1);
      var3.put(aq, var2);
      a(var0, D, var3);
   }

   public static void a(Context var0, boolean var1) {
      Analytics.with(var0).alias(UUID.randomUUID().toString());
      Properties var4 = new Properties();
      String var3 = H;
      String var2;
      if (var1) {
         var2 = at;
      } else {
         var2 = as;
      }

      var4.put(var3, var2);
      a(var0, a, var4);
   }

   public static void b(Context var0) {
      h(var0, o);
   }

   public static void b(Context var0, String var1) {
      Properties var2 = new Properties();
      var2.put(ab, 1);
      var2.put(R, var1);
      a(var0, j, var2);
   }

   public static void b(Context var0, boolean var1) {
      Properties var2 = new Properties();
      a(var0, d, var2);
   }

   public static void c(Context var0) {
      h(var0, p);
   }

   public static void c(Context var0, String var1) {
      Properties var2 = new Properties();
      var2.put(aj, var1);
      a(var0, l, var2);
   }

   public static void c(Context var0, boolean var1) {
      Properties var2 = new Properties();
      var2.put(T, 1);
      var2.put(Z, 1);
      a(var0, h, var2);
   }

   public static void d(Context var0) {
      h(var0, r);
   }

   public static void d(Context var0, String var1) {
      Properties var2 = new Properties();
      var2.put(ak, var1);
      a(var0, m, var2);
   }

   public static void e(Context var0) {
      h(var0, t);
   }

   public static void e(Context var0, String var1) {
      Properties var2 = new Properties();
      var2.put(al, var1);
      a(var0, y, var2);
   }

   public static void f(Context var0) {
      h(var0, u);
   }

   public static void f(Context var0, String var1) {
      Properties var2 = new Properties();
      var2.put(am, var1);
      a(var0, z, var2);
   }

   public static void g(Context var0) {
      h(var0, w);
   }

   public static void g(Context var0, String var1) {
      Properties var2 = new Properties();
      var2.put(am, var1);
      a(var0, B, var2);
   }

   public static void h(Context var0) {
      h(var0, x);
   }

   private static void h(Context var0, String var1) {
      Properties var2 = new Properties();
      var2.put(ar, a());
      Analytics.with(var0).track(var1, var2);
   }

   public static void i(Context var0) {
      h(var0, A);
   }

   public static void j(Context var0) {
      h(var0, C);
   }

   public static void k(Context var0) {
      h(var0, E);
   }

   public static void l(Context var0) {
      h(var0, F);
   }
}
