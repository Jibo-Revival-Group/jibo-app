package com.jibo.ui.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class LoopSelectionListView$MessagesLoopViewHolder_ViewBinding implements Unbinder {
   private LoopSelectionListView.MessagesLoopViewHolder b;

   public LoopSelectionListView$MessagesLoopViewHolder_ViewBinding(LoopSelectionListView.MessagesLoopViewHolder var1, View var2) {
      this.b = var1;
      var1.loopImage = Utils.b(var2, 2131296714, "field 'loopImage'", ImageView.class);
      var1.titleText = Utils.b(var2, 16908308, "field 'titleText'", TextView.class);
      var1.messageText = Utils.b(var2, 16908309, "field 'messageText'", TextView.class);
      var1.messageDateText = Utils.b(var2, 2131296730, "field 'messageDateText'", TextView.class);
      var1.unreadMessagesCount = Utils.b(var2, 2131297054, "field 'unreadMessagesCount'", TextView.class);
   }

   @Override
   public void unbind() {
      LoopSelectionListView.MessagesLoopViewHolder var1 = this.b;
      if (var1 == null) {
         throw new IllegalStateException("Bindings already cleared.");
      }

      this.b = null;
      var1.loopImage = null;
      var1.titleText = null;
      var1.messageText = null;
      var1.messageDateText = null;
      var1.unreadMessagesCount = null;
   }
}
