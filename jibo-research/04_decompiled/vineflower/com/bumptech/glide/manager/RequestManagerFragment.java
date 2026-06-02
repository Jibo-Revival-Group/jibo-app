package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;

@TargetApi(11)
public class RequestManagerFragment extends Fragment {
   private final ActivityFragmentLifecycle a;
   private final RequestManagerTreeNode b = new RequestManagerFragment.FragmentRequestManagerTreeNode(this);
   private RequestManager c;
   private final HashSet<RequestManagerFragment> d = new HashSet<>();
   private RequestManagerFragment e;

   public RequestManagerFragment() {
      this(new ActivityFragmentLifecycle());
   }

   @SuppressLint("ValidFragment")
   RequestManagerFragment(ActivityFragmentLifecycle var1) {
      this.a = var1;
   }

   private void a(RequestManagerFragment var1) {
      this.d.add(var1);
   }

   private void b(RequestManagerFragment var1) {
      this.d.remove(var1);
   }

   ActivityFragmentLifecycle a() {
      return this.a;
   }

   public void a(RequestManager var1) {
      this.c = var1;
   }

   public RequestManager b() {
      return this.c;
   }

   public RequestManagerTreeNode c() {
      return this.b;
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);
      this.e = RequestManagerRetriever.a().a(this.getActivity().getFragmentManager());
      if (this.e != this) {
         this.e.a(this);
      }
   }

   public void onDestroy() {
      super.onDestroy();
      this.a.c();
   }

   public void onDetach() {
      super.onDetach();
      if (this.e != null) {
         this.e.b(this);
         this.e = null;
      }
   }

   public void onLowMemory() {
      if (this.c != null) {
         this.c.a();
      }
   }

   public void onStart() {
      super.onStart();
      this.a.a();
   }

   public void onStop() {
      super.onStop();
      this.a.b();
   }

   public void onTrimMemory(int var1) {
      if (this.c != null) {
         this.c.a(var1);
      }
   }

   private class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
      final RequestManagerFragment a;

      private FragmentRequestManagerTreeNode(RequestManagerFragment var1) {
         this.a = var1;
      }
   }
}
