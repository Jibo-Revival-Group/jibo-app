package com.jibo.p019ui.fragment.invite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.content.PermissionChecker;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jibo.R;
import org.joda.time.DateTime;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseSuggestionFragment extends BaseLoopInviteFragment {

    /* JADX INFO: renamed from: a */
    EmailSuggestionsListAdapter f10410a;

    public class EmailSuggestionsListAdapter extends CursorAdapter implements Filterable {

        /* JADX INFO: renamed from: a */
        public boolean f10415a;

        /* JADX INFO: renamed from: c */
        private ContentResolver f10417c;

        public class EmailSuggestionViewHolder_ViewBinding implements Unbinder {

            /* JADX INFO: renamed from: b */
            private EmailSuggestionViewHolder f10419b;

            public EmailSuggestionViewHolder_ViewBinding(EmailSuggestionViewHolder emailSuggestionViewHolder, View view) {
                this.f10419b = emailSuggestionViewHolder;
                emailSuggestionViewHolder.textDisplayName = (TextView) Utils.m5161b(view, R.id.display_name, "field 'textDisplayName'", TextView.class);
                emailSuggestionViewHolder.textEmail = (TextView) Utils.m5161b(view, R.id.email, "field 'textEmail'", TextView.class);
                emailSuggestionViewHolder.selectedCheck = (ImageView) Utils.m5161b(view, R.id.selected_check, "field 'selectedCheck'", ImageView.class);
                emailSuggestionViewHolder.contactPhoto = (ImageView) Utils.m5161b(view, android.R.id.icon, "field 'contactPhoto'", ImageView.class);
            }

            @Override // butterknife.Unbinder
            public void unbind() {
                EmailSuggestionViewHolder emailSuggestionViewHolder = this.f10419b;
                if (emailSuggestionViewHolder == null) {
                    throw new IllegalStateException("Bindings already cleared.");
                }
                this.f10419b = null;
                emailSuggestionViewHolder.textDisplayName = null;
                emailSuggestionViewHolder.textEmail = null;
                emailSuggestionViewHolder.selectedCheck = null;
                emailSuggestionViewHolder.contactPhoto = null;
            }
        }

        public EmailSuggestionsListAdapter(Context context, Cursor cursor, boolean z) {
            super(context, cursor, z);
            this.f10415a = false;
            this.f10417c = context.getContentResolver();
        }

        /* JADX INFO: renamed from: a */
        public EmailSuggestion m10686a(int i) {
            Cursor cursor = getCursor();
            cursor.moveToPosition(i);
            int columnIndex = cursor.getColumnIndex("display_name");
            return new EmailSuggestion(cursor.getString(cursor.getColumnIndex("data1")), cursor.getString(columnIndex), cursor.getString(cursor.getColumnIndex("photo_thumb_uri")), m10687a(cursor));
        }

        @Override // android.widget.CursorAdapter
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            return LayoutInflater.from(BaseSuggestionFragment.this.getActivity()).inflate(R.layout.item_loop_invite_email_suggestion, viewGroup, false);
        }

        @Override // android.widget.CursorAdapter
        public void bindView(View view, Context context, Cursor cursor) {
            int columnIndex = cursor.getColumnIndex("display_name");
            new EmailSuggestionViewHolder(view).m10688a(new EmailSuggestion(cursor.getString(cursor.getColumnIndex("data1")), cursor.getString(columnIndex), cursor.getString(cursor.getColumnIndex("photo_thumb_uri")), null));
        }

        @Override // android.widget.CursorAdapter
        public CharSequence convertToString(Cursor cursor) {
            if (this.f10415a) {
                return cursor.getString(cursor.getColumnIndexOrThrow("data1"));
            }
            return cursor.getString(cursor.getColumnIndexOrThrow("display_name"));
        }

        @Override // android.widget.CursorAdapter
        public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
            FilterQueryProvider filterQueryProvider = getFilterQueryProvider();
            if (filterQueryProvider != null) {
                return filterQueryProvider.runQuery(charSequence);
            }
            return this.f10417c.query(Uri.withAppendedPath(ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI, Uri.encode(charSequence.toString())), new String[]{"_id", "lookup", "display_name", "data1", "photo_thumb_uri"}, null, null, null);
        }

        /* JADX INFO: renamed from: a */
        public String m10687a(Cursor cursor) {
            String string;
            String string2 = cursor.getString(cursor.getColumnIndex("display_name"));
            Cursor cursorQuery = this.f10417c.query(ContactsContract.Data.CONTENT_URI, new String[]{"display_name", "data1", "data2", "mimetype"}, "data2=3 and mimetype = 'vnd.android.cursor.item/contact_event'", null, "display_name");
            if (cursorQuery.getCount() > 0) {
                string = null;
                while (cursorQuery.moveToNext()) {
                    if (string2.equals(cursorQuery.getString(cursorQuery.getColumnIndex("display_name")))) {
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("data1"));
                    }
                }
            } else {
                string = null;
            }
            cursorQuery.close();
            return string;
        }

        class EmailSuggestionViewHolder {

            @BindView
            ImageView contactPhoto;

            @BindView
            ImageView selectedCheck;

            @BindView
            TextView textDisplayName;

            @BindView
            TextView textEmail;

            public EmailSuggestionViewHolder(View view) {
                ButterKnife.m5154a(this, view);
            }

            /* JADX INFO: renamed from: a */
            public void m10688a(EmailSuggestion emailSuggestion) {
                if (EmailSuggestionsListAdapter.this.f10415a) {
                    this.textDisplayName.setText(emailSuggestion.m10681a());
                    this.textEmail.setVisibility(8);
                } else {
                    this.textDisplayName.setText(emailSuggestion.m10682b());
                    this.textEmail.setText(emailSuggestion.m10681a());
                    this.textEmail.setVisibility(0);
                }
                this.selectedCheck.setVisibility(8);
                Glide.m5254b(BaseSuggestionFragment.this.getContext()).m5279a(emailSuggestion.m10683c()).mo5235f(R.drawable.ic_unknown_user).mo5233e(R.drawable.ic_unknown_user).mo5231d(R.drawable.ic_unknown_user).mo5223b(DiskCacheStrategy.ALL).mo5239j().mo5216a(this.contactPhoto);
            }
        }
    }

    @Override // com.jibo.p019ui.fragment.invite.BaseLoopInviteFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m10680r();
    }

    /* JADX INFO: renamed from: r */
    private void m10680r() {
        if (PermissionChecker.m1896a(getActivity(), "android.permission.READ_CONTACTS") != 0) {
            requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 96);
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f10410a = new EmailSuggestionsListAdapter(getActivity(), null, true);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f10410a != null && this.f10410a.getCursor() != null) {
            this.f10410a.getCursor().close();
            this.f10410a.swapCursor(null);
        }
    }

    public static class EmailSuggestion {

        /* JADX INFO: renamed from: a */
        private String f10411a;

        /* JADX INFO: renamed from: b */
        private String f10412b;

        /* JADX INFO: renamed from: c */
        private String f10413c;

        /* JADX INFO: renamed from: d */
        private String f10414d;

        public EmailSuggestion(String str, String str2, String str3, String str4) {
            this.f10411a = str;
            this.f10412b = str2;
            this.f10413c = str3;
            this.f10414d = str4;
        }

        /* JADX INFO: renamed from: a */
        public String m10681a() {
            return this.f10411a;
        }

        /* JADX INFO: renamed from: b */
        public String m10682b() {
            return this.f10412b;
        }

        /* JADX INFO: renamed from: c */
        public String m10683c() {
            return this.f10413c;
        }

        /* JADX INFO: renamed from: d */
        public String m10684d() {
            return this.f10414d;
        }

        /* JADX INFO: renamed from: e */
        public long m10685e() {
            return new DateTime(this.f10414d).mo16580c();
        }
    }
}
