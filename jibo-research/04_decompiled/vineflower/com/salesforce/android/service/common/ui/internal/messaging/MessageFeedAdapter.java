package com.salesforce.android.service.common.ui.internal.messaging;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.salesforce.android.service.common.ui.internal.android.LayoutInflaterFactory;
import com.salesforce.android.service.common.ui.internal.android.RecyclerViewAdapter;
import com.salesforce.android.service.common.ui.internal.android.RecyclerViewAdapterDelegate;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.ArrayList;
import java.util.List;

public class MessageFeedAdapter implements RecyclerViewAdapter<RecyclerView.ViewHolder> {
   private final ViewHolderFactory a;
   private final LayoutInflaterFactory b;
   private final RecyclerViewAdapterDelegate<RecyclerView.ViewHolder> c;
   private final long d;
   private RecyclerView e;
   private LinearLayoutManager f;
   private List<Object> g = new ArrayList<>();

   MessageFeedAdapter(MessageFeedAdapter.Builder var1) {
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.c.a(this);
      this.d = var1.d;
   }

   private void a(RecyclerView.ViewHolder var1) {
      if (var1 != null && var1 instanceof GroupableView) {
         ((GroupableView)var1).a();
      }
   }

   private boolean a(Message var1, Message var2) {
      boolean var3;
      if (var2.d().getTime() - var1.d().getTime() <= this.d) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   private boolean a(MultiActorMessage var1, MultiActorMessage var2) {
      boolean var3;
      if (this.a((Message)var1, (Message)var2) && var1.e().equals(var2.e())) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   private boolean a(Object var1, Object var2) {
      boolean var4 = false;
      boolean var3 = var4;
      if (var1 != null) {
         if (var2 == null) {
            var3 = var4;
         } else if (this.a(var1, var2, MultiActorMessage.class)) {
            var3 = this.a((MultiActorMessage)var1, (MultiActorMessage)var2);
         } else {
            var3 = var4;
            if (this.a(var1, var2, Message.class)) {
               var3 = var4;
               if (!this.b(var1, var2, MultiActorMessage.class)) {
                  var3 = this.a((Message)var1, (Message)var2);
               }
            }
         }
      }

      return var3;
   }

   private boolean a(Object var1, Object var2, Class var3) {
      boolean var4;
      if (var3.isInstance(var1) && var3.isInstance(var2)) {
         var4 = true;
      } else {
         var4 = false;
      }

      return var4;
   }

   private void b(RecyclerView.ViewHolder var1) {
      if (var1 != null && var1 instanceof GroupableView) {
         ((GroupableView)var1).b();
      }
   }

   private boolean b(Object var1, Object var2, Class var3) {
      boolean var4;
      if (!var3.isInstance(var1) && !var3.isInstance(var2)) {
         var4 = false;
      } else {
         var4 = true;
      }

      return var4;
   }

   public Object a(int var1) {
      Object var2;
      if (!this.g.isEmpty() && var1 < this.g.size() && var1 >= 0) {
         var2 = this.g.get(var1);
      } else {
         var2 = null;
      }

      return var2;
   }

   public void a() {
      this.g.clear();
      this.c.notifyDataSetChanged();
   }

   public void a(RecyclerView var1) {
      var1.setAdapter(this.c);
   }

   public void a(Object var1) {
      if (this.a(this.b(), var1)) {
         this.a(this.c());
      }

      this.g.add(var1);
      this.c.notifyItemInserted(this.g.indexOf(var1));
   }

   public Object b() {
      return this.a(this.g.size() - 1);
   }

   RecyclerView.ViewHolder c() {
      RecyclerView.ViewHolder var1;
      if (this.e != null && !this.g.isEmpty()) {
         var1 = this.e.findViewHolderForAdapterPosition(this.g.size() - 1);
      } else {
         var1 = null;
      }

      return var1;
   }

   @Override
   public int getItemCount() {
      return this.g.size();
   }

   @Override
   public long getItemId(int var1) {
      return this.c.getItemId(var1);
   }

   @Override
   public int getItemViewType(int var1) {
      Object var2 = this.g.get(var1);
      return this.a.a(var2);
   }

   @Override
   public void onAttachedToRecyclerView(RecyclerView var1) {
      this.e = var1;
      this.f = (LinearLayoutManager)var1.getLayoutManager();
   }

   @Override
   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      Object var3 = this.g.get(var2);
      if (this.a(var3, this.a(var2 + 1))) {
         this.a(var1);
      } else {
         this.b(var1);
      }

      this.a.a(var1, var1.getItemViewType(), var3);
   }

   @Override
   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      LayoutInflater var3 = this.b.a(var1.getContext());
      return this.a.a(var1, var2, var3);
   }

   @Override
   public void onDetachedFromRecyclerView(RecyclerView var1) {
      if (this.e == var1) {
         this.e = null;
         this.f = null;
      }
   }

   public static class Builder {
      ViewHolderFactory a;
      LayoutInflaterFactory b;
      RecyclerViewAdapterDelegate<RecyclerView.ViewHolder> c;
      Long d;

      public MessageFeedAdapter.Builder a(LayoutInflaterFactory var1) {
         this.b = var1;
         return this;
      }

      public MessageFeedAdapter.Builder a(ViewHolderFactory var1) {
         this.a = var1;
         return this;
      }

      public MessageFeedAdapter a() {
         Arguments.a(this.a, "Please provide a ViewHolderFactory instance to the MessageFeedAdapter.");
         if (this.b == null) {
            this.b = new LayoutInflaterFactory();
         }

         if (this.c == null) {
            this.c = new RecyclerViewAdapterDelegate<>();
         }

         if (this.d == null) {
            this.d = 60000L;
         }

         return new MessageFeedAdapter(this);
      }
   }
}
