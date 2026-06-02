package com.jibo;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.person.model.Holiday;
import com.jibo.aws.integration.util.DateTimeUtils;
import com.segment.analytics.Analytics;
import com.segment.analytics.Properties;
import com.segment.analytics.Traits;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class JiboAnalytics {

    /* JADX INFO: renamed from: a */
    public static String f9199a = "app_download";

    /* JADX INFO: renamed from: b */
    public static String f9243b = "account_creation_start";

    /* JADX INFO: renamed from: c */
    public static String f9244c = "account_creation_finish";

    /* JADX INFO: renamed from: d */
    public static String f9245d = "setup_new_robot";

    /* JADX INFO: renamed from: e */
    public static String f9246e = "personalization_survey";

    /* JADX INFO: renamed from: f */
    public static String f9247f = "loop_invites_sent";

    /* JADX INFO: renamed from: g */
    public static String f9248g = "loop_invites_received";

    /* JADX INFO: renamed from: h */
    public static String f9249h = "loop_invite_accepted";

    /* JADX INFO: renamed from: i */
    public static String f9250i = "loop_invite_abandoned";

    /* JADX INFO: renamed from: j */
    public static String f9251j = "loop_invite_rejected";

    /* JADX INFO: renamed from: k */
    public static String f9252k = "post_to_loop_feed";

    /* JADX INFO: renamed from: l */
    public static String f9253l = "feed_opened";

    /* JADX INFO: renamed from: m */
    public static String f9254m = "account_deleted";

    /* JADX INFO: renamed from: n */
    public static String f9255n = "account_delete_started";

    /* JADX INFO: renamed from: o */
    public static String f9256o = "account_delete_finished";

    /* JADX INFO: renamed from: p */
    public static String f9257p = "ph_number_added_pre_account";

    /* JADX INFO: renamed from: q */
    public static String f9258q = "ph_number_added_post_account";

    /* JADX INFO: renamed from: r */
    public static String f9259r = "view_gallery";

    /* JADX INFO: renamed from: s */
    public static String f9260s = "view_image";

    /* JADX INFO: renamed from: t */
    public static String f9261t = "share_sheet_selected";

    /* JADX INFO: renamed from: u */
    public static String f9262u = "setup_new_jibo";

    /* JADX INFO: renamed from: v */
    public static String f9263v = "view_attribution_page";

    /* JADX INFO: renamed from: w */
    public static String f9264w = "tips_opened";

    /* JADX INFO: renamed from: x */
    public static String f9265x = "find_answer";

    /* JADX INFO: renamed from: y */
    public static String f9266y = "contact_support";

    /* JADX INFO: renamed from: z */
    public static String f9267z = "tips_item";

    /* JADX INFO: renamed from: A */
    public static String f9173A = "read_more_coppa";

    /* JADX INFO: renamed from: B */
    public static String f9174B = "location_set";

    /* JADX INFO: renamed from: C */
    public static String f9175C = "photo_deleted";

    /* JADX INFO: renamed from: D */
    public static String f9176D = "holiday";

    /* JADX INFO: renamed from: E */
    public static String f9177E = "guided_user_swiped_back";

    /* JADX INFO: renamed from: F */
    public static String f9178F = "guided_location_sync";

    /* JADX INFO: renamed from: G */
    public static String f9179G = "guided_custom_avatar_selected";

    /* JADX INFO: renamed from: H */
    public static String f9180H = "app_download";

    /* JADX INFO: renamed from: I */
    public static String f9181I = "email";

    /* JADX INFO: renamed from: J */
    public static String f9182J = "account_association";

    /* JADX INFO: renamed from: K */
    public static String f9183K = "$first_name";

    /* JADX INFO: renamed from: L */
    public static String f9184L = "$last_name";

    /* JADX INFO: renamed from: M */
    public static String f9185M = "acct_created_date";

    /* JADX INFO: renamed from: N */
    public static String f9186N = "date_of_birth";

    /* JADX INFO: renamed from: O */
    public static String f9187O = "age";

    /* JADX INFO: renamed from: P */
    public static String f9188P = "avatar_assigned";

    /* JADX INFO: renamed from: Q */
    public static String f9189Q = "#_invites_sent";

    /* JADX INFO: renamed from: R */
    public static String f9190R = "robot_ID";

    /* JADX INFO: renamed from: S */
    public static String f9191S = "#_invites_received";

    /* JADX INFO: renamed from: T */
    public static String f9192T = "#_invites_accepted";

    /* JADX INFO: renamed from: U */
    public static String f9193U = "existing_acct";

    /* JADX INFO: renamed from: V */
    public static String f9194V = "content_type";

    /* JADX INFO: renamed from: W */
    public static String f9195W = "people.append";

    /* JADX INFO: renamed from: X */
    public static String f9196X = "#_questions_answered";

    /* JADX INFO: renamed from: Y */
    public static String f9197Y = "questions_answered";

    /* JADX INFO: renamed from: Z */
    public static String f9198Z = "#_invites_enrolled";

    /* JADX INFO: renamed from: aa */
    public static String f9217aa = "#_invites_abandoned";

    /* JADX INFO: renamed from: ab */
    public static String f9218ab = "#_invites_rejected";

    /* JADX INFO: renamed from: ac */
    public static String f9219ac = "#_ppl_tagged";

    /* JADX INFO: renamed from: ad */
    public static String f9220ad = "message_reply_sent";

    /* JADX INFO: renamed from: ae */
    public static String f9221ae = "photo_destination";

    /* JADX INFO: renamed from: af */
    public static String f9222af = "#_photos_shared";

    /* JADX INFO: renamed from: ag */
    public static String f9223ag = "#_app_opens";

    /* JADX INFO: renamed from: ah */
    public static String f9224ah = "#_text_posts";

    /* JADX INFO: renamed from: ai */
    public static String f9225ai = "#_photo_posts";

    /* JADX INFO: renamed from: aj */
    public static String f9226aj = "viewed_from";

    /* JADX INFO: renamed from: ak */
    public static String f9227ak = "reason";

    /* JADX INFO: renamed from: al */
    public static String f9228al = "screen";

    /* JADX INFO: renamed from: am */
    public static String f9229am = ShareConstants.MEDIA_TYPE;

    /* JADX INFO: renamed from: an */
    public static String f9230an = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC;

    /* JADX INFO: renamed from: ao */
    public static String f9231ao = "manual";

    /* JADX INFO: renamed from: ap */
    public static String f9232ap = "holiday_name";

    /* JADX INFO: renamed from: aq */
    public static String f9233aq = "holiday_toggle";

    /* JADX INFO: renamed from: ar */
    public static String f9234ar = "timestamp";

    /* JADX INFO: renamed from: as */
    public static String f9235as = "direct";

    /* JADX INFO: renamed from: at */
    public static String f9236at = "invite";

    /* JADX INFO: renamed from: au */
    public static String f9237au = "new_robot";

    /* JADX INFO: renamed from: av */
    public static String f9238av = "existing_robot";

    /* JADX INFO: renamed from: aw */
    public static String f9239aw = "direct from store";

    /* JADX INFO: renamed from: ax */
    public static String f9240ax = "invite via deep link";

    /* JADX INFO: renamed from: ay */
    public static String f9241ay = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO;

    /* JADX INFO: renamed from: az */
    public static String f9242az = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO;

    /* JADX INFO: renamed from: aA */
    public static String f9200aA = "text";

    /* JADX INFO: renamed from: aB */
    public static String f9201aB = "push_notification";

    /* JADX INFO: renamed from: aC */
    public static String f9202aC = "organic";

    /* JADX INFO: renamed from: aD */
    public static String f9203aD = "jibo_no_use";

    /* JADX INFO: renamed from: aE */
    public static String f9204aE = "app_no_use";

    /* JADX INFO: renamed from: aF */
    public static String f9205aF = "app_malfunction";

    /* JADX INFO: renamed from: aG */
    public static String f9206aG = FacebookRequestErrorClassification.KEY_OTHER;

    /* JADX INFO: renamed from: aH */
    public static String f9207aH = "tips";

    /* JADX INFO: renamed from: aI */
    public static String f9208aI = "tab";

    /* JADX INFO: renamed from: aJ */
    public static String f9209aJ = "account_settings";

    /* JADX INFO: renamed from: aK */
    public static String f9210aK = "jibo_at_a_glance";

    /* JADX INFO: renamed from: aL */
    public static String f9211aL = "bot_basics";

    /* JADX INFO: renamed from: aM */
    public static String f9212aM = "caring_for_jibo";

    /* JADX INFO: renamed from: aN */
    public static String f9213aN = "the_loop";

    /* JADX INFO: renamed from: aO */
    public static String f9214aO = "talking_with_jibo";

    /* JADX INFO: renamed from: aP */
    public static String f9215aP = "how_to_videos";

    /* JADX INFO: renamed from: aQ */
    public static String f9216aQ = Holiday.CATEGORY_BIRTHDAY;

    /* JADX INFO: renamed from: a */
    private static String m9833a() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Calendar.getInstance().getTime());
    }

    /* JADX INFO: renamed from: h */
    private static void m9857h(Context context, String str) {
        Properties properties = new Properties();
        properties.put(f9234ar, (Object) m9833a());
        Analytics.with(context).track(str, properties);
    }

    /* JADX INFO: renamed from: a */
    private static void m9839a(Context context, String str, Object obj) {
        Properties properties = (Properties) obj;
        properties.put(f9234ar, (Object) m9833a());
        Analytics.with(context).track(str, properties);
    }

    /* JADX INFO: renamed from: a */
    public static void m9841a(Context context, boolean z) {
        Analytics.with(context).alias(UUID.randomUUID().toString());
        Properties properties = new Properties();
        properties.put(f9180H, (Object) (z ? f9236at : f9235as));
        m9839a(context, f9199a, properties);
    }

    /* JADX INFO: renamed from: a */
    public static void m9835a(Context context, Account account) {
        Analytics.with(context).identify(account.getId(), new Traits().putName(account.getFullName()).putEmail(account.getEmail()).putValue(f9234ar, (Object) m9833a()), null);
    }

    /* JADX INFO: renamed from: a */
    public static void m9837a(Context context, String str) {
        Properties properties = new Properties();
        properties.put(f9181I, (Object) str);
        m9839a(context, f9243b, properties);
    }

    /* JADX INFO: renamed from: a */
    public static void m9836a(Context context, Account account, boolean z, int i) {
        Properties properties = new Properties();
        if (z) {
            properties.put(f9182J, (Object) f9237au);
        } else {
            properties.put(f9182J, (Object) f9238av);
        }
        properties.put(f9183K, (Object) account.getFirstName());
        properties.put(f9184L, (Object) account.getLastName());
        properties.put(f9185M, (Object) DateTimeUtils.getCurrentDate(context, DateTimeUtils.ANALYTICS_FORMAT));
        if (account.getBirthday() != null) {
            properties.put(f9186N, (Object) DateTimeUtils.getFormattedDate(account.getBirthday().longValue(), DateTimeUtils.ANALYTICS_FORMAT));
            properties.put(f9187O, (Object) Integer.valueOf(DateTimeUtils.getAge(account.getBirthday())));
        }
        properties.put(f9223ag, (Object) Integer.valueOf(i));
        m9839a(context, f9244c, properties);
    }

    /* JADX INFO: renamed from: b */
    public static void m9844b(Context context, boolean z) {
        m9839a(context, f9245d, new Properties());
    }

    /* JADX INFO: renamed from: a */
    public static void m9838a(Context context, String str, long j) {
        Properties properties = new Properties();
        properties.put(f9189Q, (Object) 1);
        properties.put(f9190R, (Object) str);
        properties.put(f9216aQ, (Object) Long.valueOf(j));
        m9839a(context, f9247f, properties);
    }

    /* JADX INFO: renamed from: c */
    public static void m9847c(Context context, boolean z) {
        Properties properties = new Properties();
        properties.put(f9192T, (Object) 1);
        properties.put(f9198Z, (Object) 1);
        m9839a(context, f9249h, properties);
    }

    /* JADX INFO: renamed from: b */
    public static void m9843b(Context context, String str) {
        Properties properties = new Properties();
        properties.put(f9218ab, (Object) 1);
        properties.put(f9190R, (Object) str);
        m9839a(context, f9251j, properties);
    }

    /* JADX INFO: renamed from: c */
    public static void m9846c(Context context, String str) {
        Properties properties = new Properties();
        properties.put(f9226aj, (Object) str);
        m9839a(context, f9253l, properties);
    }

    /* JADX INFO: renamed from: d */
    public static void m9849d(Context context, String str) {
        Properties properties = new Properties();
        properties.put(f9227ak, (Object) str);
        m9839a(context, f9254m, properties);
    }

    /* JADX INFO: renamed from: a */
    public static void m9834a(Context context) {
        m9857h(context, f9255n);
    }

    /* JADX INFO: renamed from: b */
    public static void m9842b(Context context) {
        m9857h(context, f9256o);
    }

    /* JADX INFO: renamed from: c */
    public static void m9845c(Context context) {
        m9857h(context, f9257p);
    }

    /* JADX INFO: renamed from: d */
    public static void m9848d(Context context) {
        m9857h(context, f9259r);
    }

    /* JADX INFO: renamed from: e */
    public static void m9850e(Context context) {
        m9857h(context, f9261t);
    }

    /* JADX INFO: renamed from: f */
    public static void m9852f(Context context) {
        m9857h(context, f9262u);
    }

    /* JADX INFO: renamed from: g */
    public static void m9854g(Context context) {
        m9857h(context, f9264w);
    }

    /* JADX INFO: renamed from: h */
    public static void m9856h(Context context) {
        m9857h(context, f9265x);
    }

    /* JADX INFO: renamed from: e */
    public static void m9851e(Context context, String str) {
        Properties properties = new Properties();
        properties.put(f9228al, (Object) str);
        m9839a(context, f9266y, properties);
    }

    /* JADX INFO: renamed from: f */
    public static void m9853f(Context context, String str) {
        Properties properties = new Properties();
        properties.put(f9229am, (Object) str);
        m9839a(context, f9267z, properties);
    }

    /* JADX INFO: renamed from: i */
    public static void m9858i(Context context) {
        m9857h(context, f9173A);
    }

    /* JADX INFO: renamed from: g */
    public static void m9855g(Context context, String str) {
        Properties properties = new Properties();
        properties.put(f9229am, (Object) str);
        m9839a(context, f9174B, properties);
    }

    /* JADX INFO: renamed from: j */
    public static void m9859j(Context context) {
        m9857h(context, f9175C);
    }

    /* JADX INFO: renamed from: a */
    public static void m9840a(Context context, String str, boolean z) {
        Properties properties = new Properties();
        properties.put(f9232ap, (Object) str);
        properties.put(f9233aq, (Object) Boolean.valueOf(z));
        m9839a(context, f9176D, properties);
    }

    /* JADX INFO: renamed from: k */
    public static void m9860k(Context context) {
        m9857h(context, f9177E);
    }

    /* JADX INFO: renamed from: l */
    public static void m9861l(Context context) {
        m9857h(context, f9178F);
    }
}
