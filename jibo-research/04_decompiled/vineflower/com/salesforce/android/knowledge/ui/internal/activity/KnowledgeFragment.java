package com.salesforce.android.knowledge.ui.internal.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.salesforce.android.knowledge.ui.R;
import com.salesforce.android.knowledge.ui.internal.ViewBinder;
import com.salesforce.android.knowledge.ui.internal.client.KnowledgeUIClientImpl;
import com.salesforce.android.knowledge.ui.internal.navigation.ViewState;

public class KnowledgeFragment extends Fragment {
   private ViewState a;
   private ViewBinder b;

   private ViewState a(KnowledgeActivity var1) {
      KnowledgeUIClientImpl var2 = var1.a();
      ViewState var3;
      if (var2 != null && var2.i() != null) {
         var3 = var2.i().a(var1);
      } else {
         var3 = null;
      }

      return var3;
   }

   @Override
   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      if (this.b != null) {
         this.getActivity().findViewById(R.id.knowledge_fragment_container).setBackgroundResource(this.b.e());
      }
   }

   @Override
   public void onAttach(Context var1) {
      super.onAttach(var1);
      if (var1 instanceof KnowledgeActivity) {
         this.a = this.a((KnowledgeActivity)var1);
         if (this.a != null) {
            this.b = this.a.a();
         }
      }
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (this.b != null) {
         this.setHasOptionsMenu(this.b.t_());
      }
   }

   @Override
   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      super.onCreateOptionsMenu(var1, var2);
      if (this.b != null) {
         this.b.a(var1, var2);
      }
   }

   @Override
   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4;
      if (this.b == null) {
         var4 = null;
      } else {
         var4 = this.b.a(var1, var2, var3);
         if (this.b.t_()) {
            ((AppCompatActivity)this.getActivity()).setSupportActionBar(this.b.d());
         }
      }

      return var4;
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
      if (this.a != null) {
         this.a.b();
      }

      if (this.b != null) {
         this.b.b();
      }
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem var1) {
      boolean var2;
      if (this.b != null && this.b.a(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   @Override
   public void onViewStateRestored(Bundle var1) {
      super.onViewStateRestored(var1);
      if (this.a != null) {
         this.a.c();
      }
   }

   static class Factory {
      KnowledgeFragment a() {
         return new KnowledgeFragment();
      }
   }
}
