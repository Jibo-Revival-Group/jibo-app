package android.support.v4.app;

import android.support.v4.util.LogWriter;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManagerImpl.OpGenerator {
   final FragmentManagerImpl a;
   ArrayList<BackStackRecord.Op> b = new ArrayList<>();
   int c;
   int d;
   int e;
   int f;
   int g;
   int h;
   boolean i;
   boolean j = true;
   String k;
   boolean l;
   int m = -1;
   int n;
   CharSequence o;
   int p;
   CharSequence q;
   ArrayList<String> r;
   ArrayList<String> s;
   boolean t = false;
   ArrayList<Runnable> u;

   public BackStackRecord(FragmentManagerImpl var1) {
      this.a = var1;
   }

   private void a(int var1, Fragment var2, String var3, int var4) {
      Class var6 = var2.getClass();
      int var5 = var6.getModifiers();
      if (!var6.isAnonymousClass() && Modifier.isPublic(var5) && (!var6.isMemberClass() || Modifier.isStatic(var5))) {
         var2.mFragmentManager = this.a;
         if (var3 != null) {
            if (var2.mTag != null && !var3.equals(var2.mTag)) {
               throw new IllegalStateException("Can't change tag of fragment " + var2 + ": was " + var2.mTag + " now " + var3);
            }

            var2.mTag = var3;
         }

         if (var1 != 0) {
            if (var1 == -1) {
               throw new IllegalArgumentException("Can't add fragment " + var2 + " with tag " + var3 + " to container view with no id");
            }

            if (var2.mFragmentId != 0 && var2.mFragmentId != var1) {
               throw new IllegalStateException("Can't change container ID of fragment " + var2 + ": was " + var2.mFragmentId + " now " + var1);
            }

            var2.mFragmentId = var1;
            var2.mContainerId = var1;
         }

         this.a(new BackStackRecord.Op(var4, var2));
      } else {
         throw new IllegalStateException(
            "Fragment " + var6.getCanonicalName() + " must be a public static class to be  properly recreated from" + " instance state."
         );
      }
   }

   private static boolean b(BackStackRecord.Op var0) {
      Fragment var2 = var0.b;
      boolean var1;
      if (var2 != null && var2.mAdded && var2.mView != null && !var2.mDetached && !var2.mHidden && var2.isPostponed()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public int a() {
      return this.m;
   }

   int a(boolean var1) {
      if (this.l) {
         throw new IllegalStateException("commit already called");
      }

      if (FragmentManagerImpl.a) {
         Log.v("FragmentManager", "Commit: " + this);
         PrintWriter var2 = new PrintWriter(new LogWriter("FragmentManager"));
         this.a("  ", null, var2, null);
         var2.close();
      }

      this.l = true;
      if (this.i) {
         this.m = this.a.a(this);
      } else {
         this.m = -1;
      }

      this.a.a(this, var1);
      return this.m;
   }

   Fragment a(ArrayList<Fragment> var1, Fragment var2) {
      int var3 = 0;
      Fragment var8 = var2;

      while (var3 < this.b.size()) {
         BackStackRecord.Op var9 = this.b.get(var3);
         int var4 = var3;
         var2 = var8;
         switch (var9.a) {
            case 1:
            case 7:
               var1.add(var9.b);
               var4 = var3;
               var2 = var8;
               break;
            case 2:
               Fragment var10 = var9.b;
               int var7 = var10.mContainerId;
               boolean var14 = false;
               int var5 = var1.size() - 1;
               var2 = var8;

               for (; var5 >= 0; var5--) {
                  Fragment var11 = (Fragment)var1.get(var5);
                  if (var11.mContainerId == var7) {
                     if (var11 == var10) {
                        var14 = true;
                     } else {
                        int var6 = var3;
                        var8 = var2;
                        if (var11 == var2) {
                           this.b.add(var3, new BackStackRecord.Op(9, var11));
                           var6 = var3 + 1;
                           var8 = null;
                        }

                        BackStackRecord.Op var13 = new BackStackRecord.Op(3, var11);
                        var13.c = var9.c;
                        var13.e = var9.e;
                        var13.d = var9.d;
                        var13.f = var9.f;
                        this.b.add(var6, var13);
                        var1.remove(var11);
                        var3 = var6 + 1;
                        var2 = var8;
                     }
                  }
               }

               if (var14) {
                  this.b.remove(var3);
                  var3--;
               } else {
                  var9.a = 1;
                  var1.add(var10);
               }

               var4 = var3;
               break;
            case 3:
            case 6:
               var1.remove(var9.b);
               var4 = var3;
               var2 = var8;
               if (var9.b == var8) {
                  this.b.add(var3, new BackStackRecord.Op(9, var9.b));
                  var4 = var3 + 1;
                  var2 = null;
               }
            case 4:
            case 5:
               break;
            case 8:
               this.b.add(var3, new BackStackRecord.Op(9, var8));
               var4 = var3 + 1;
               var2 = var9.b;
               break;
            default:
               var2 = var8;
               var4 = var3;
         }

         var3 = var4 + 1;
         var8 = var2;
      }

      return var8;
   }

   @Override
   public FragmentTransaction a(int var1, int var2) {
      return this.a(var1, var2, 0, 0);
   }

   @Override
   public FragmentTransaction a(int var1, int var2, int var3, int var4) {
      this.c = var1;
      this.d = var2;
      this.e = var3;
      this.f = var4;
      return this;
   }

   @Override
   public FragmentTransaction a(int var1, Fragment var2) {
      this.a(var1, var2, null, 1);
      return this;
   }

   @Override
   public FragmentTransaction a(int var1, Fragment var2, String var3) {
      this.a(var1, var2, var3, 1);
      return this;
   }

   @Override
   public FragmentTransaction a(Fragment var1) {
      this.a(new BackStackRecord.Op(3, var1));
      return this;
   }

   @Override
   public FragmentTransaction a(Fragment var1, String var2) {
      this.a(0, var1, var2, 1);
      return this;
   }

   @Override
   public FragmentTransaction a(String var1) {
      if (!this.j) {
         throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
      }

      this.i = true;
      this.k = var1;
      return this;
   }

   void a(int var1) {
      if (this.i) {
         if (FragmentManagerImpl.a) {
            Log.v("FragmentManager", "Bump nesting in " + this + " by " + var1);
         }

         int var3 = this.b.size();

         for (int var2 = 0; var2 < var3; var2++) {
            BackStackRecord.Op var5 = this.b.get(var2);
            if (var5.b != null) {
               Fragment var4 = var5.b;
               var4.mBackStackNesting += var1;
               if (FragmentManagerImpl.a) {
                  Log.v("FragmentManager", "Bump nesting of " + var5.b + " to " + var5.b.mBackStackNesting);
               }
            }
         }
      }
   }

   void a(BackStackRecord.Op var1) {
      this.b.add(var1);
      var1.c = this.c;
      var1.d = this.d;
      var1.e = this.e;
      var1.f = this.f;
   }

   void a(Fragment.OnStartEnterTransitionListener var1) {
      for (int var2 = 0; var2 < this.b.size(); var2++) {
         BackStackRecord.Op var3 = this.b.get(var2);
         if (b(var3)) {
            var3.b.setOnStartEnterTransitionListener(var1);
         }
      }
   }

   public void a(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      this.a(var1, var3, true);
   }

   public void a(String var1, PrintWriter var2, boolean var3) {
      if (var3) {
         var2.print(var1);
         var2.print("mName=");
         var2.print(this.k);
         var2.print(" mIndex=");
         var2.print(this.m);
         var2.print(" mCommitted=");
         var2.println(this.l);
         if (this.g != 0) {
            var2.print(var1);
            var2.print("mTransition=#");
            var2.print(Integer.toHexString(this.g));
            var2.print(" mTransitionStyle=#");
            var2.println(Integer.toHexString(this.h));
         }

         if (this.c != 0 || this.d != 0) {
            var2.print(var1);
            var2.print("mEnterAnim=#");
            var2.print(Integer.toHexString(this.c));
            var2.print(" mExitAnim=#");
            var2.println(Integer.toHexString(this.d));
         }

         if (this.e != 0 || this.f != 0) {
            var2.print(var1);
            var2.print("mPopEnterAnim=#");
            var2.print(Integer.toHexString(this.e));
            var2.print(" mPopExitAnim=#");
            var2.println(Integer.toHexString(this.f));
         }

         if (this.n != 0 || this.o != null) {
            var2.print(var1);
            var2.print("mBreadCrumbTitleRes=#");
            var2.print(Integer.toHexString(this.n));
            var2.print(" mBreadCrumbTitleText=");
            var2.println(this.o);
         }

         if (this.p != 0 || this.q != null) {
            var2.print(var1);
            var2.print("mBreadCrumbShortTitleRes=#");
            var2.print(Integer.toHexString(this.p));
            var2.print(" mBreadCrumbShortTitleText=");
            var2.println(this.q);
         }
      }

      if (!this.b.isEmpty()) {
         var2.print(var1);
         var2.println("Operations:");
         new StringBuilder().append(var1).append("    ").toString();
         int var5 = this.b.size();

         for (int var4 = 0; var4 < var5; var4++) {
            BackStackRecord.Op var7 = this.b.get(var4);
            String var6;
            switch (var7.a) {
               case 0:
                  var6 = "NULL";
                  break;
               case 1:
                  var6 = "ADD";
                  break;
               case 2:
                  var6 = "REPLACE";
                  break;
               case 3:
                  var6 = "REMOVE";
                  break;
               case 4:
                  var6 = "HIDE";
                  break;
               case 5:
                  var6 = "SHOW";
                  break;
               case 6:
                  var6 = "DETACH";
                  break;
               case 7:
                  var6 = "ATTACH";
                  break;
               case 8:
                  var6 = "SET_PRIMARY_NAV";
                  break;
               case 9:
                  var6 = "UNSET_PRIMARY_NAV";
                  break;
               default:
                  var6 = "cmd=" + var7.a;
            }

            var2.print(var1);
            var2.print("  Op #");
            var2.print(var4);
            var2.print(": ");
            var2.print(var6);
            var2.print(" ");
            var2.println(var7.b);
            if (var3) {
               if (var7.c != 0 || var7.d != 0) {
                  var2.print(var1);
                  var2.print("enterAnim=#");
                  var2.print(Integer.toHexString(var7.c));
                  var2.print(" exitAnim=#");
                  var2.println(Integer.toHexString(var7.d));
               }

               if (var7.e != 0 || var7.f != 0) {
                  var2.print(var1);
                  var2.print("popEnterAnim=#");
                  var2.print(Integer.toHexString(var7.e));
                  var2.print(" popExitAnim=#");
                  var2.println(Integer.toHexString(var7.f));
               }
            }
         }
      }
   }

   boolean a(ArrayList<BackStackRecord> var1, int var2, int var3) {
      boolean var11;
      if (var3 == var2) {
         var11 = false;
      } else {
         int var9 = this.b.size();
         int var5 = -1;
         int var6 = 0;

         while (var6 < var9) {
            BackStackRecord.Op var12 = this.b.get(var6);
            int var4;
            if (var12.b != null) {
               var4 = var12.b.mContainerId;
            } else {
               var4 = 0;
            }

            if (var4 != 0 && var4 != var5) {
               for (int var14 = var2; var14 < var3; var14++) {
                  BackStackRecord var13 = (BackStackRecord)var1.get(var14);
                  int var10 = var13.b.size();

                  for (int var7 = 0; var7 < var10; var7++) {
                     var12 = var13.b.get(var7);
                     int var8;
                     if (var12.b != null) {
                        var8 = var12.b.mContainerId;
                     } else {
                        var8 = 0;
                     }

                     if (var8 == var4) {
                        var11 = true;
                        return var11;
                     }
                  }
               }
            } else {
               var4 = var5;
            }

            var6++;
            var5 = var4;
         }

         var11 = false;
      }

      return var11;
   }

   @Override
   public boolean a(ArrayList<BackStackRecord> var1, ArrayList<Boolean> var2) {
      if (FragmentManagerImpl.a) {
         Log.v("FragmentManager", "Run: " + this);
      }

      var1.add(this);
      var2.add(false);
      if (this.i) {
         this.a.b(this);
      }

      return true;
   }

   Fragment b(ArrayList<Fragment> var1, Fragment var2) {
      int var3 = 0;
      Fragment var4 = var2;

      while (var3 < this.b.size()) {
         BackStackRecord.Op var5 = this.b.get(var3);
         var2 = var4;
         switch (var5.a) {
            case 1:
            case 7:
               var1.remove(var5.b);
               var2 = var4;
            case 2:
            case 4:
            case 5:
               break;
            case 3:
            case 6:
               var1.add(var5.b);
               var2 = var4;
               break;
            case 8:
               var2 = null;
               break;
            case 9:
               var2 = var5.b;
               break;
            default:
               var2 = var4;
         }

         var3++;
         var4 = var2;
      }

      return var4;
   }

   @Override
   public FragmentTransaction b() {
      if (this.i) {
         throw new IllegalStateException("This transaction is already being added to the back stack");
      }

      this.j = false;
      return this;
   }

   @Override
   public FragmentTransaction b(int var1, Fragment var2) {
      return this.b(var1, var2, null);
   }

   @Override
   public FragmentTransaction b(int var1, Fragment var2, String var3) {
      if (var1 == 0) {
         throw new IllegalArgumentException("Must use non-zero containerViewId");
      }

      this.a(var1, var2, var3, 2);
      return this;
   }

   @Override
   public FragmentTransaction b(Fragment var1) {
      this.a(new BackStackRecord.Op(6, var1));
      return this;
   }

   void b(boolean var1) {
      for (int var2 = this.b.size() - 1; var2 >= 0; var2--) {
         BackStackRecord.Op var3 = this.b.get(var2);
         Fragment var4 = var3.b;
         if (var4 != null) {
            var4.setNextTransition(FragmentManagerImpl.e(this.g), this.h);
         }

         switch (var3.a) {
            case 1:
               var4.setNextAnim(var3.f);
               this.a.i(var4);
               break;
            case 2:
            default:
               throw new IllegalArgumentException("Unknown cmd: " + var3.a);
            case 3:
               var4.setNextAnim(var3.e);
               this.a.a(var4, false);
               break;
            case 4:
               var4.setNextAnim(var3.e);
               this.a.k(var4);
               break;
            case 5:
               var4.setNextAnim(var3.f);
               this.a.j(var4);
               break;
            case 6:
               var4.setNextAnim(var3.e);
               this.a.m(var4);
               break;
            case 7:
               var4.setNextAnim(var3.f);
               this.a.l(var4);
               break;
            case 8:
               this.a.p(null);
               break;
            case 9:
               this.a.p(var4);
         }

         if (!this.t && var3.a != 3 && var4 != null) {
            this.a.f(var4);
         }
      }

      if (!this.t && var1) {
         this.a.a(this.a.l, true);
      }
   }

   boolean b(int var1) {
      int var4 = this.b.size();
      int var2 = 0;

      boolean var5;
      while (true) {
         if (var2 >= var4) {
            var5 = false;
            break;
         }

         BackStackRecord.Op var6 = this.b.get(var2);
         int var3;
         if (var6.b != null) {
            var3 = var6.b.mContainerId;
         } else {
            var3 = 0;
         }

         if (var3 != 0 && var3 == var1) {
            var5 = true;
            break;
         }

         var2++;
      }

      return var5;
   }

   @Override
   public FragmentTransaction c(Fragment var1) {
      this.a(new BackStackRecord.Op(7, var1));
      return this;
   }

   public void c() {
      if (this.u != null) {
         int var2 = this.u.size();

         for (int var1 = 0; var1 < var2; var1++) {
            this.u.get(var1).run();
         }

         this.u = null;
      }
   }

   @Override
   public int d() {
      return this.a(false);
   }

   @Override
   public int e() {
      return this.a(true);
   }

   @Override
   public void f() {
      this.b();
      this.a.b(this, false);
   }

   @Override
   public void g() {
      this.b();
      this.a.b(this, true);
   }

   void h() {
      int var2 = this.b.size();

      for (int var1 = 0; var1 < var2; var1++) {
         BackStackRecord.Op var3 = this.b.get(var1);
         Fragment var4 = var3.b;
         if (var4 != null) {
            var4.setNextTransition(this.g, this.h);
         }

         switch (var3.a) {
            case 1:
               var4.setNextAnim(var3.c);
               this.a.a(var4, false);
               break;
            case 2:
            default:
               throw new IllegalArgumentException("Unknown cmd: " + var3.a);
            case 3:
               var4.setNextAnim(var3.d);
               this.a.i(var4);
               break;
            case 4:
               var4.setNextAnim(var3.d);
               this.a.j(var4);
               break;
            case 5:
               var4.setNextAnim(var3.c);
               this.a.k(var4);
               break;
            case 6:
               var4.setNextAnim(var3.d);
               this.a.l(var4);
               break;
            case 7:
               var4.setNextAnim(var3.c);
               this.a.m(var4);
               break;
            case 8:
               this.a.p(var4);
               break;
            case 9:
               this.a.p(null);
         }

         if (!this.t && var3.a != 1 && var4 != null) {
            this.a.f(var4);
         }
      }

      if (!this.t) {
         this.a.a(this.a.l, true);
      }
   }

   boolean i() {
      boolean var3 = false;
      int var1 = 0;

      boolean var2;
      while (true) {
         var2 = var3;
         if (var1 >= this.b.size()) {
            break;
         }

         if (b(this.b.get(var1))) {
            var2 = true;
            break;
         }

         var1++;
      }

      return var2;
   }

   public String j() {
      return this.k;
   }

   @Override
   public boolean k() {
      return this.b.isEmpty();
   }

   @Override
   public String toString() {
      StringBuilder var1 = new StringBuilder(128);
      var1.append("BackStackEntry{");
      var1.append(Integer.toHexString(System.identityHashCode(this)));
      if (this.m >= 0) {
         var1.append(" #");
         var1.append(this.m);
      }

      if (this.k != null) {
         var1.append(" ");
         var1.append(this.k);
      }

      var1.append("}");
      return var1.toString();
   }

   static final class Op {
      int a;
      Fragment b;
      int c;
      int d;
      int e;
      int f;

      Op() {
      }

      Op(int var1, Fragment var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}
