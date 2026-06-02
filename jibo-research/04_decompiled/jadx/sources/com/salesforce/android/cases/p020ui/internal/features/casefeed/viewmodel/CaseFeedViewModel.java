package com.salesforce.android.cases.p020ui.internal.features.casefeed.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.internal.util.DateUtils;
import com.salesforce.android.cases.core.internal.util.StringUtils;
import com.salesforce.android.cases.core.model.Body;
import com.salesforce.android.cases.core.model.CaseDetailRecord;
import com.salesforce.android.cases.core.model.CaseFeed;
import com.salesforce.android.cases.core.model.CaseField;
import com.salesforce.android.cases.core.model.CaseLayoutData;
import com.salesforce.android.cases.core.model.CommentPost;
import com.salesforce.android.cases.core.model.Element;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class CaseFeedViewModel {

    /* JADX INFO: renamed from: a */
    List<Object> f12683a;

    /* JADX INFO: renamed from: b */
    private final Context f12684b;

    /* JADX INFO: renamed from: c */
    private final CaseDetailRecord f12685c;

    /* JADX INFO: renamed from: d */
    private final CaseLayoutData f12686d;

    /* JADX INFO: renamed from: e */
    private final CaseFeed f12687e;

    /* JADX INFO: renamed from: f */
    private final String f12688f;

    /* JADX INFO: renamed from: g */
    private final DateFormat f12689g;

    /* JADX INFO: renamed from: h */
    private final Date f12690h;

    public CaseFeedViewModel(Context context, CaseDetailRecord caseDetailRecord, CaseLayoutData caseLayoutData, CaseFeed caseFeed, String str) {
        Date dateMo12443c;
        this.f12684b = context;
        this.f12685c = caseDetailRecord;
        this.f12686d = caseLayoutData;
        this.f12687e = caseFeed;
        this.f12688f = str;
        Date dateMo12430u = caseDetailRecord.mo12430u();
        Iterator<? extends Element> it = caseFeed.mo12437a().iterator();
        while (true) {
            dateMo12443c = dateMo12430u;
            if (!it.hasNext()) {
                break;
            }
            Element next = it.next();
            if (dateMo12443c == null || (next.mo12443c() != null && dateMo12443c.before(next.mo12443c()))) {
                dateMo12443c = next.mo12443c();
            }
            dateMo12430u = dateMo12443c;
        }
        this.f12690h = dateMo12443c == null ? new Date() : dateMo12443c;
        this.f12689g = new SimpleDateFormat("MMM d, yyyy", Locale.getDefault());
        if (caseDetailRecord != null && caseFeed != null && !caseFeed.mo12437a().isEmpty()) {
            m12819e();
        }
    }

    /* JADX INFO: renamed from: a */
    public List<Object> m12820a() {
        return this.f12683a == null ? Collections.emptyList() : Collections.unmodifiableList(this.f12683a);
    }

    /* JADX INFO: renamed from: a */
    public List<Object> m12821a(CommentPost commentPost) {
        Date dateMo12829d = null;
        ArrayList arrayList = new ArrayList();
        if (commentPost == null || commentPost.mo12474a() == null || TextUtils.isEmpty(commentPost.mo12474a().mo12440a())) {
            return null;
        }
        Date dateMo12475b = commentPost.mo12475b();
        Date date = new Date();
        int size = this.f12683a.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            Object obj = this.f12683a.get(size);
            if (obj instanceof SentMessageModel) {
                dateMo12829d = ((SentMessageModel) obj).mo12829d();
                break;
            }
            if (!(obj instanceof ReceivedMessageModel)) {
                size--;
            } else {
                dateMo12829d = ((ReceivedMessageModel) obj).mo12829d();
                break;
            }
        }
        if (dateMo12829d == null && m12818a(date, commentPost.mo12475b())) {
            HorizontalRuleModel horizontalRuleModel = new HorizontalRuleModel(this.f12684b.getString(R.string.cases_horizontal_rule_today_text));
            this.f12683a.add(horizontalRuleModel);
            arrayList.add(horizontalRuleModel);
        } else if (dateMo12829d == null || !m12818a(dateMo12829d, dateMo12475b)) {
            HorizontalRuleModel horizontalRuleModel2 = new HorizontalRuleModel(this.f12689g.format(dateMo12475b));
            this.f12683a.add(horizontalRuleModel2);
            arrayList.add(horizontalRuleModel2);
        }
        SentMessageModel sentMessageModel = new SentMessageModel(StringUtils.m12619d(commentPost.mo12474a().mo12440a()), commentPost.mo12475b());
        this.f12683a.add(sentMessageModel);
        arrayList.add(sentMessageModel);
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    public String m12822b() {
        if (this.f12685c != null && !TextUtils.isEmpty(this.f12685c.mo12423n())) {
            return this.f12685c.mo12423n();
        }
        if (this.f12685c != null && this.f12685c.mo12411b() != null) {
            return this.f12684b.getString(R.string.cases_case_feed_default_title_text, this.f12685c.mo12411b());
        }
        return "";
    }

    /* JADX INFO: renamed from: c */
    public Date m12823c() {
        return this.f12690h;
    }

    /* JADX INFO: renamed from: d */
    public String m12824d() {
        return this.f12688f;
    }

    /* JADX INFO: renamed from: e */
    private void m12819e() {
        Date date;
        this.f12683a = new ArrayList();
        Date date2 = new Date();
        Date dateMo12428s = this.f12685c.mo12428s();
        Date date3 = dateMo12428s == null ? new Date(0L) : dateMo12428s;
        if (m12818a(date2, date3)) {
            this.f12683a.add(new HorizontalRuleModel(this.f12684b.getString(R.string.cases_horizontal_rule_today_text)));
        } else {
            this.f12683a.add(new HorizontalRuleModel(this.f12689g.format(date3)));
        }
        this.f12683a.add(new SentMessageModel(m12816a(this.f12685c), date3));
        ArrayList<Element> arrayList = new ArrayList(this.f12687e.mo12437a());
        Collections.reverse(arrayList);
        HashSet hashSet = new HashSet();
        Iterator<UserAccount> it = SalesforceSDKManager.m14403a().m14450o().m14277d().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().m14247g());
        }
        Date date4 = date3;
        for (Element element : arrayList) {
            Body bodyMo12444d = element.mo12444d();
            if (bodyMo12444d == null || TextUtils.isEmpty(bodyMo12444d.mo12440a())) {
                date = date4;
            } else {
                Date dateMo12443c = element.mo12443c();
                if (dateMo12443c == null) {
                    dateMo12443c = date3;
                }
                if (date4 == null && m12818a(date2, element.mo12443c())) {
                    this.f12683a.add(new HorizontalRuleModel(this.f12684b.getString(R.string.cases_horizontal_rule_today_text)));
                } else if (date4 == null || !m12818a(date4, dateMo12443c)) {
                    this.f12683a.add(new HorizontalRuleModel(this.f12689g.format(dateMo12443c)));
                }
                if (element.mo12445e() != null && hashSet.contains(element.mo12445e().mo12439b())) {
                    this.f12683a.add(new SentMessageModel(StringUtils.m12619d(bodyMo12444d.mo12440a()), dateMo12443c));
                } else if (element.mo12445e() != null) {
                    this.f12683a.add(new ReceivedMessageModel(StringUtils.m12619d(bodyMo12444d.mo12440a()), TextUtils.isEmpty(element.mo12445e().mo12438a()) ? "" : element.mo12445e().mo12438a(), TextUtils.isEmpty(element.mo12445e().mo12439b()) ? "" : element.mo12445e().mo12438a(), dateMo12443c));
                }
                date = dateMo12443c;
            }
            date4 = date;
        }
    }

    /* JADX INFO: renamed from: a */
    private String m12816a(CaseDetailRecord caseDetailRecord) {
        StringBuilder sb = new StringBuilder();
        for (CaseField caseField : this.f12686d.mo12458a()) {
            if (!caseField.mo12456i()) {
                String strM12619d = StringUtils.m12619d(m12817a(caseField, caseDetailRecord));
                if (!TextUtils.isEmpty(strM12619d)) {
                    if (sb.length() > 0) {
                        sb.append("\n").append("\n");
                    }
                    sb.append(caseField.mo12449b());
                    sb.append("\n");
                    sb.append(strM12619d);
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private boolean m12818a(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(date);
        calendar2.setTime(date2);
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    /* JADX INFO: renamed from: a */
    private String m12817a(CaseField caseField, CaseDetailRecord caseDetailRecord) {
        switch (caseField.mo12446a()) {
            case "Subject":
                return caseDetailRecord.mo12423n();
            case "Description":
                return caseDetailRecord.mo12425p();
            case "Id":
                return caseDetailRecord.mo12410a();
            case "Status":
                return caseDetailRecord.mo12421l();
            case "RecordTypeId":
                return caseDetailRecord.mo12420k();
            case "CreatedDate":
                return DateUtils.f12562a.format(caseDetailRecord.mo12428s());
            case "LastModifiedDate":
                return DateUtils.f12562a.format(caseDetailRecord.mo12430u());
            case "CaseNumber":
                return caseDetailRecord.mo12411b();
            case "ContactId":
                return caseDetailRecord.mo12412c();
            case "AssetId":
                return caseDetailRecord.mo12413d();
            case "FeedItemId":
                return caseDetailRecord.mo12414e();
            case "SourceId":
                return caseDetailRecord.mo12415f();
            case "CommunityId":
                return caseDetailRecord.mo12416g();
            case "SuppliedName":
                return caseDetailRecord.mo12417h();
            case "SuppliedEmail":
                return caseDetailRecord.mo12418i();
            case "Type":
                return caseDetailRecord.mo12419j();
            case "Reason":
                return caseDetailRecord.mo12422m();
            case "Priority":
                return caseDetailRecord.mo12424o();
            case "ClosedDate":
                return DateUtils.f12562a.format(caseDetailRecord.mo12426q());
            case "OwnerId":
                return caseDetailRecord.mo12427r();
            case "CreatedById":
                return caseDetailRecord.mo12429t();
            case "LastModifiedById":
                return caseDetailRecord.mo12431v();
            case "LastViewedDate":
                return DateUtils.f12562a.format(caseDetailRecord.mo12432w());
            case "LastReferencedDate":
                return DateUtils.f12562a.format(caseDetailRecord.mo12433x());
            case "CreatorFullPhotoUrl":
                return caseDetailRecord.mo12434y();
            case "CreatorSmallPhotoUrl":
                return caseDetailRecord.mo12435z();
            case "CreatorName":
                return caseDetailRecord.mo12408A();
            default:
                if (caseDetailRecord.mo12409B().containsKey(caseField.mo12446a())) {
                    return caseDetailRecord.mo12409B().get(caseField.mo12446a());
                }
                return caseField.mo12455h();
        }
    }
}
