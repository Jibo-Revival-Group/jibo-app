package com.jibo.ui.helpers;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.ui.view.proxima.CustomFontTextView;

public class ViewHolders$AttributionViewHolder_ViewBinding implements Unbinder {
   private ViewHolders.AttributionViewHolder b;

   public ViewHolders$AttributionViewHolder_ViewBinding(ViewHolders.AttributionViewHolder var1, View var2) {
      this.b = var1;
      var1.serviceIcon = Utils.b(var2, 2131296588, "field 'serviceIcon'", ImageView.class);
      var1.titleText = Utils.b(var2, 2131297019, "field 'titleText'", TextView.class);
      var1.urlText = Utils.b(var2, 2131297056, "field 'urlText'", TextView.class);
      var1.dateText = Utils.b(var2, 2131296513, "field 'dateText'", TextView.class);
      var1.image = Utils.b(var2, 2131296596, "field 'image'", ImageView.class);
      var1.imageDivider = Utils.a(var2, 2131296602, "field 'imageDivider'");
      var1.wasItCorrectButton = Utils.b(var2, 2131297074, "field 'wasItCorrectButton'", CustomFontTextView.class);
      var1.jiboImage = Utils.b(var2, 2131296619, "field 'jiboImage'", ImageView.class);
      var1.attributionRadioGroup = Utils.b(var2, 2131296326, "field 'attributionRadioGroup'", RadioGroup.class);
      var1.firstCard = Utils.b(var2, 2131296566, "field 'firstCard'", CardView.class);
      var1.backCard = Utils.b(var2, 2131296332, "field 'backCard'", CardView.class);
      var1.submit = Utils.b(var2, 2131296967, "field 'submit'", CustomFontTextView.class);
   }

   @Override
   public void unbind() {
      ViewHolders.AttributionViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.serviceIcon = null;
      var1.titleText = null;
      var1.urlText = null;
      var1.dateText = null;
      var1.image = null;
      var1.imageDivider = null;
      var1.wasItCorrectButton = null;
      var1.jiboImage = null;
      var1.attributionRadioGroup = null;
      var1.firstCard = null;
      var1.backCard = null;
      var1.submit = null;
   }
}
