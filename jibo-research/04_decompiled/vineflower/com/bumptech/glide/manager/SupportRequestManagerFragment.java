package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;

public class SupportRequestManagerFragment extends Fragment {
   private RequestManager a;
   private final ActivityFragmentLifecycle b;
   private final RequestManagerTreeNode c = new SupportRequestManagerFragment.SupportFragmentRequestManagerTreeNode(this);
   private final HashSet<SupportRequestManagerFragment> d = new HashSet<>();
   private SupportRequestManagerFragment e;

   public SupportRequestManagerFragment() {
      this(new ActivityFragmentLifecycle());
   }

   @SuppressLint("ValidFragment")
   public SupportRequestManagerFragment(ActivityFragmentLifecycle var1) {
      this.b = var1;
   }

   private void a(SupportRequestManagerFragment var1) {
      this.d.add(var1);
   }

   private void b(SupportRequestManagerFragment var1) {
      this.d.remove(var1);
   }

   ActivityFragmentLifecycle a() {
      return this.b;
   }

   public void a(RequestManager var1) {
      this.a = var1;
   }

   public RequestManager b() {
      return this.a;
   }

   public RequestManagerTreeNode c() {
      return this.c;
   }

   @Override
   public void onAttach(Activity var1) {
      super.onAttach(var1);
      this.e = RequestManagerRetriever.a().a(this.getActivity().getSupportFragmentManager());
      if (this.e != this) {
         this.e.a(this);
      }
   }

   @Override
   public void onDestroy() {
      super.onDestroy();
      this.b.c();
   }

   @Override
   public void onDetach() {
      super.onDetach();
      if (this.e != null) {
         this.e.b(this);
         this.e = null;
      }
   }

   @Override
   public void onLowMemory() {
      super.onLowMemory();
      if (this.a != null) {
         this.a.a();
      }
   }

   @Override
   public void onStart() {
      super.onStart();
      this.b.a();
   }

   @Override
   public void onStop() {
      super.onStop();
      this.b.b();
   }

   private class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
      final SupportRequestManagerFragment a;

      private SupportFragmentRequestManagerTreeNode(SupportRequestManagerFragment var1) {
         this.a = var1;
      }
   }
}
