package com.jibo.ui.fragment.invite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.CommonDataKinds.Email;
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
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import org.joda.time.DateTime;

public abstract class BaseSuggestionFragment extends BaseLoopInviteFragment {
   BaseSuggestionFragment.EmailSuggestionsListAdapter a;

   private void r() {
      if (PermissionChecker.a(this.getActivity(), "android.permission.READ_CONTACTS") != 0) {
         this.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 96);
      }
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.r();
   }

   @Override
   public void onPause() {
      super.onPause();
      if (this.a != null && this.a.getCursor() != null) {
         this.a.getCursor().close();
         this.a.swapCursor(null);
      }
   }

   @Override
   public void onResume() {
      super.onResume();
      this.a = new BaseSuggestionFragment.EmailSuggestionsListAdapter(this, this.getActivity(), null, true);
   }

   public static class EmailSuggestion {
      private String a;
      private String b;
      private String c;
      private String d;

      public EmailSuggestion(String var1, String var2, String var3, String var4) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
      }

      public String a() {
         return this.a;
      }

      public String b() {
         return this.b;
      }

      public String c() {
         return this.c;
      }

      public String d() {
         return this.d;
      }

      public long e() {
         return new DateTime(this.d).c();
      }
   }

   public class EmailSuggestionsListAdapter extends CursorAdapter implements Filterable {
      public boolean a;
      final BaseSuggestionFragment b;
      private ContentResolver c;

      public EmailSuggestionsListAdapter(BaseSuggestionFragment var1, Context var2, Cursor var3, boolean var4) {
         super(var2, var3, var4);
         this.b = var1;
         this.a = false;
         this.c = var2.getContentResolver();
      }

      public BaseSuggestionFragment.EmailSuggestion a(int var1) {
         Cursor var4 = this.getCursor();
         var4.moveToPosition(var1);
         int var3 = var4.getColumnIndex("display_name");
         int var2 = var4.getColumnIndex("data1");
         var1 = var4.getColumnIndex("photo_thumb_uri");
         return new BaseSuggestionFragment.EmailSuggestion(var4.getString(var2), var4.getString(var3), var4.getString(var1), this.a(var4));
      }

      public String a(Cursor var1) {
         String var4 = var1.getString(var1.getColumnIndex("display_name"));
         Cursor var3 = this.c
            .query(
               Data.CONTENT_URI,
               new String[]{"display_name", "data1", "data2", "mimetype"},
               "data2=3 and mimetype = 'vnd.android.cursor.item/contact_event'",
               null,
               "display_name"
            );
         String var2;
         if (var3.getCount() > 0) {
            String var5 = null;

            while (true) {
               var2 = var5;
               if (!var3.moveToNext()) {
                  break;
               }

               if (var4.equals(var3.getString(var3.getColumnIndex("display_name")))) {
                  var5 = var3.getString(var3.getColumnIndex("data1"));
               }
            }
         } else {
            var2 = null;
         }

         var3.close();
         return var2;
      }

      public void bindView(View var1, Context var2, Cursor var3) {
         int var6 = var3.getColumnIndex("display_name");
         int var5 = var3.getColumnIndex("data1");
         int var4 = var3.getColumnIndex("photo_thumb_uri");
         BaseSuggestionFragment.EmailSuggestion var7 = new BaseSuggestionFragment.EmailSuggestion(
            var3.getString(var5), var3.getString(var6), var3.getString(var4), null
         );
         new BaseSuggestionFragment.EmailSuggestionsListAdapter.EmailSuggestionViewHolder(this, var1).a(var7);
      }

      public CharSequence convertToString(Cursor var1) {
         String var2;
         if (this.a) {
            var2 = var1.getString(var1.getColumnIndexOrThrow("data1"));
         } else {
            var2 = var1.getString(var1.getColumnIndexOrThrow("display_name"));
         }

         return var2;
      }

      public View newView(Context var1, Cursor var2, ViewGroup var3) {
         return LayoutInflater.from(this.b.getActivity()).inflate(2131427515, var3, false);
      }

      public Cursor runQueryOnBackgroundThread(CharSequence var1) {
         FilterQueryProvider var2 = this.getFilterQueryProvider();
         Cursor var3;
         if (var2 != null) {
            var3 = var2.runQuery(var1);
         } else {
            Uri var4 = Uri.withAppendedPath(Email.CONTENT_FILTER_URI, Uri.encode(var1.toString()));
            var3 = this.c.query(var4, new String[]{"_id", "lookup", "display_name", "data1", "photo_thumb_uri"}, null, null, null);
         }

         return var3;
      }

      class EmailSuggestionViewHolder {
         final BaseSuggestionFragment.EmailSuggestionsListAdapter a;
         @BindView
         ImageView contactPhoto;
         @BindView
         ImageView selectedCheck;
         @BindView
         TextView textDisplayName;
         @BindView
         TextView textEmail;

         public EmailSuggestionViewHolder(BaseSuggestionFragment.EmailSuggestionsListAdapter var1, View var2) {
            this.a = var1;
            ButterKnife.a(this, var2);
         }

         public void a(BaseSuggestionFragment.EmailSuggestion var1) {
            if (this.a.a) {
               this.textDisplayName.setText(var1.a());
               this.textEmail.setVisibility(8);
            } else {
               this.textDisplayName.setText(var1.b());
               this.textEmail.setText(var1.a());
               this.textEmail.setVisibility(0);
            }

            this.selectedCheck.setVisibility(8);
            Glide.b(this.a.b.getContext()).a(var1.c()).a(2131231079).b(2131231079).c(2131231079).a(DiskCacheStrategy.ALL).d().a(this.contactPhoto);
         }
      }
   }
}
