package com.jibo.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import butterknife.BindView;
import com.jibo.aws.integration.aws.services.loop.model.Loop;

public class LoopSelectionListView extends ListView {
   private ListAdapter a;
   private LoopSelectionListView.OnLoopSelectedListener b;
   private OnItemClickListener c = new OnItemClickListener(this) {
      final LoopSelectionListView a;

      {
         this.a = var1;
      }

      public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
         Loop var6 = (Loop)this.a.a.getItem(var3);
         if (this.a.b != null) {
            this.a.b.a(var6);
         }
      }
   };

   public LoopSelectionListView(Context var1) {
      super(var1);
      this.a();
   }

   public LoopSelectionListView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a();
   }

   public LoopSelectionListView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a();
   }

   private void a() {
      this.setOnItemClickListener(this.c);
   }

   public void setAdapter(ListAdapter var1) {
      super.setAdapter(var1);
      this.a = var1;
   }

   public void setOnLoopSelectedListener(LoopSelectionListView.OnLoopSelectedListener var1) {
      this.b = var1;
   }

   static class MessagesLoopViewHolder {
      @BindView
      ImageView loopImage;
      @BindView
      TextView messageDateText;
      @BindView
      TextView messageText;
      @BindView
      TextView titleText;
      @BindView
      TextView unreadMessagesCount;
   }

   public interface OnLoopSelectedListener {
      void a(Loop var1);
   }
}
