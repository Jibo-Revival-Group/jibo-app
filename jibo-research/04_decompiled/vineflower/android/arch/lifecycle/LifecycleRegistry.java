package android.arch.lifecycle;

import android.arch.core.internal.FastSafeIterableMap;
import android.arch.core.internal.SafeIterableMap;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class LifecycleRegistry extends Lifecycle {
   private FastSafeIterableMap<LifecycleObserver, LifecycleRegistry.ObserverWithState> a = new FastSafeIterableMap<>();
   private Lifecycle.State b;
   private final WeakReference<LifecycleOwner> c;
   private int d = 0;
   private boolean e = false;
   private boolean f = false;
   private ArrayList<Lifecycle.State> g = new ArrayList<>();

   public LifecycleRegistry(LifecycleOwner var1) {
      this.c = new WeakReference<>(var1);
      this.b = Lifecycle.State.INITIALIZED;
   }

   static Lifecycle.State a(Lifecycle.State var0, Lifecycle.State var1) {
      if (var1 != null && var1.compareTo(var0) < 0) {
         var0 = var1;
      }

      return var0;
   }

   private void a(LifecycleOwner var1) {
      SafeIterableMap.IteratorWithAdditions var3 = this.a.c();

      while (var3.hasNext() && !this.f) {
         Entry var2 = (Entry)var3.next();
         LifecycleRegistry.ObserverWithState var4 = (LifecycleRegistry.ObserverWithState)var2.getValue();

         while (var4.a.compareTo(this.b) < 0 && !this.f && this.a.c((LifecycleObserver)var2.getKey())) {
            this.c(var4.a);
            var4.a(var1, e(var4.a));
            this.c();
         }
      }
   }

   static Lifecycle.State b(Lifecycle.Event var0) {
      Lifecycle.State var1;
      switch (<unrepresentable>.a[var0.ordinal()]) {
         case 1:
         case 2:
            var1 = Lifecycle.State.CREATED;
            break;
         case 3:
         case 4:
            var1 = Lifecycle.State.STARTED;
            break;
         case 5:
            var1 = Lifecycle.State.RESUMED;
            break;
         case 6:
            var1 = Lifecycle.State.DESTROYED;
            break;
         default:
            throw new IllegalArgumentException("Unexpected event value " + var0);
      }

      return var1;
   }

   private void b(Lifecycle.State var1) {
      if (this.b != var1) {
         this.b = var1;
         if (!this.e && this.d == 0) {
            this.e = true;
            this.d();
            this.e = false;
         } else {
            this.f = true;
         }
      }
   }

   private void b(LifecycleOwner var1) {
      Iterator var3 = this.a.b();

      while (var3.hasNext() && !this.f) {
         Entry var4 = (Entry)var3.next();
         LifecycleRegistry.ObserverWithState var2 = (LifecycleRegistry.ObserverWithState)var4.getValue();

         while (var2.a.compareTo(this.b) > 0 && !this.f && this.a.c((LifecycleObserver)var4.getKey())) {
            Lifecycle.Event var5 = d(var2.a);
            this.c(b(var5));
            var2.a(var1, var5);
            this.c();
         }
      }
   }

   private boolean b() {
      boolean var1 = true;
      if (this.a.a() != 0) {
         Lifecycle.State var3 = this.a.d().getValue().a;
         Lifecycle.State var2 = this.a.e().getValue().a;
         if (var3 == var2 && this.b == var2) {
            var1 = true;
         } else {
            var1 = false;
         }
      }

      return var1;
   }

   private Lifecycle.State c(LifecycleObserver var1) {
      Entry var3 = this.a.d(var1);
      Lifecycle.State var4;
      if (var3 != null) {
         var4 = ((LifecycleRegistry.ObserverWithState)var3.getValue()).a;
      } else {
         var4 = null;
      }

      Lifecycle.State var2;
      if (!this.g.isEmpty()) {
         var2 = this.g.get(this.g.size() - 1);
      } else {
         var2 = null;
      }

      return a(a(this.b, var4), var2);
   }

   private void c() {
      this.g.remove(this.g.size() - 1);
   }

   private void c(Lifecycle.State var1) {
      this.g.add(var1);
   }

   private static Lifecycle.Event d(Lifecycle.State var0) {
      Lifecycle.Event var1;
      switch (<unrepresentable>.b[var0.ordinal()]) {
         case 1:
            throw new IllegalArgumentException();
         case 2:
            var1 = Lifecycle.Event.ON_DESTROY;
            break;
         case 3:
            var1 = Lifecycle.Event.ON_STOP;
            break;
         case 4:
            var1 = Lifecycle.Event.ON_PAUSE;
            break;
         case 5:
            throw new IllegalArgumentException();
         default:
            throw new IllegalArgumentException("Unexpected state value " + var0);
      }

      return var1;
   }

   private void d() {
      LifecycleOwner var2 = this.c.get();
      if (var2 == null) {
         Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
      } else {
         while (!this.b()) {
            this.f = false;
            if (this.b.compareTo(this.a.d().getValue().a) < 0) {
               this.b(var2);
            }

            Entry var1 = this.a.e();
            if (!this.f && var1 != null && this.b.compareTo(((LifecycleRegistry.ObserverWithState)var1.getValue()).a) > 0) {
               this.a(var2);
            }
         }

         this.f = false;
      }
   }

   private static Lifecycle.Event e(Lifecycle.State var0) {
      Lifecycle.Event var1;
      switch (<unrepresentable>.b[var0.ordinal()]) {
         case 1:
         case 5:
            var1 = Lifecycle.Event.ON_CREATE;
            break;
         case 2:
            var1 = Lifecycle.Event.ON_START;
            break;
         case 3:
            var1 = Lifecycle.Event.ON_RESUME;
            break;
         case 4:
            throw new IllegalArgumentException();
         default:
            throw new IllegalArgumentException("Unexpected state value " + var0);
      }

      return var1;
   }

   @Override
   public Lifecycle.State a() {
      return this.b;
   }

   public void a(Lifecycle.Event var1) {
      this.b(b(var1));
   }

   public void a(Lifecycle.State var1) {
      this.b(var1);
   }

   @Override
   public void a(LifecycleObserver var1) {
      Lifecycle.State var3;
      if (this.b == Lifecycle.State.DESTROYED) {
         var3 = Lifecycle.State.DESTROYED;
      } else {
         var3 = Lifecycle.State.INITIALIZED;
      }

      LifecycleRegistry.ObserverWithState var4 = new LifecycleRegistry.ObserverWithState(var1, var3);
      if (this.a.a(var1, var4) == null) {
         LifecycleOwner var5 = this.c.get();
         if (var5 != null) {
            boolean var2;
            if (this.d == 0 && !this.e) {
               var2 = false;
            } else {
               var2 = true;
            }

            var3 = this.c(var1);
            this.d++;

            while (var4.a.compareTo(var3) < 0 && this.a.c(var1)) {
               this.c(var4.a);
               var4.a(var5, e(var4.a));
               this.c();
               var3 = this.c(var1);
            }

            if (!var2) {
               this.d();
            }

            this.d--;
         }
      }
   }

   @Override
   public void b(LifecycleObserver var1) {
      this.a.b(var1);
   }

   static class ObserverWithState {
      Lifecycle.State a;
      GenericLifecycleObserver b;

      ObserverWithState(LifecycleObserver var1, Lifecycle.State var2) {
         this.b = Lifecycling.a(var1);
         this.a = var2;
      }

      void a(LifecycleOwner var1, Lifecycle.Event var2) {
         Lifecycle.State var3 = LifecycleRegistry.b(var2);
         this.a = LifecycleRegistry.a(this.a, var3);
         this.b.a(var1, var2);
         this.a = var3;
      }
   }
}
