package com.jibo.ui.fragment.invite;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder_ViewBinding implements Unbinder {
   private BaseSuggestionFragment.EmailSuggestionsListAdapter.EmailSuggestionViewHolder b;

   public BaseSuggestionFragment$EmailSuggestionsListAdapter$EmailSuggestionViewHolder_ViewBinding(
      BaseSuggestionFragment.EmailSuggestionsListAdapter.EmailSuggestionViewHolder var1, View var2
   ) {
      this.b = var1;
      var1.textDisplayName = Utils.b(var2, 2131296533, "field 'textDisplayName'", TextView.class);
      var1.textEmail = Utils.b(var2, 2131296546, "field 'textEmail'", TextView.class);
      var1.selectedCheck = Utils.b(var2, 2131296880, "field 'selectedCheck'", ImageView.class);
      var1.contactPhoto = Utils.b(var2, 16908294, "field 'contactPhoto'", ImageView.class);
   }

   @Override
   public void unbind() {
      BaseSuggestionFragment.EmailSuggestionsListAdapter.EmailSuggestionViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.textDisplayName = null;
      var1.textEmail = null;
      var1.selectedCheck = null;
      var1.contactPhoto = null;
   }
}
