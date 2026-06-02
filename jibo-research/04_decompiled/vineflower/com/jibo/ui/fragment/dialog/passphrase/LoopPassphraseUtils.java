package com.jibo.ui.fragment.dialog.passphrase;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.aws.integration.aws.services.key.model.Backup;
import com.jibo.aws.integration.aws.services.key.model.RestoreRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.db.EntityData;
import com.jibo.ui.fragment.BaseFragment;

public class LoopPassphraseUtils {
   public static LoopPassphraseUtils.DialogType a(Context var0, String var1, boolean var2) {
      Object var7 = null;
      LoopPassphraseUtils.DialogType var8;
      if (a(var1, var0)) {
         var8 = (LoopPassphraseUtils.DialogType)var7;
      } else {
         long var5 = System.currentTimeMillis();
         SharedPreferences var9 = var0.getSharedPreferences(var0.getString(2131755063), 0);
         long var3 = var9.getLong("PREFERENCE_LOOP_PASSPHRASE_DIALOG_SHOW_DATE", 0L);
         var1 = var9.getString("PREFERENCE_LAST_SHOWN_DIALOG_TYPE", null);
         if (LoopPassphraseUtils.DialogType.FIRST_TIME.equalsName(var1)) {
            var8 = (LoopPassphraseUtils.DialogType)var7;
            if (var5 - var3 >= 86400000L) {
               var8 = (LoopPassphraseUtils.DialogType)var7;
               if (var2) {
                  var8 = LoopPassphraseUtils.DialogType.MEDIA_ADDED;
               }
            }
         } else if (LoopPassphraseUtils.DialogType.MEDIA_ADDED.equalsName(var1)) {
            var8 = (LoopPassphraseUtils.DialogType)var7;
            if (var5 - var3 >= 604800000L) {
               var8 = LoopPassphraseUtils.DialogType.WEEK_AFTER;
            }
         } else {
            var8 = (LoopPassphraseUtils.DialogType)var7;
            if (!LoopPassphraseUtils.DialogType.WEEK_AFTER.equalsName(var1)) {
               if (var2) {
                  var8 = LoopPassphraseUtils.DialogType.MEDIA_ADDED;
               } else {
                  var8 = LoopPassphraseUtils.DialogType.FIRST_TIME;
               }
            }
         }
      }

      return var8;
   }

   public static void a(Context var0) {
      var0.getSharedPreferences(var0.getString(2131755063), 0)
         .edit()
         .putLong("PREFERENCE_LOOP_PASSPHRASE_DIALOG_SHOW_DATE", System.currentTimeMillis())
         .putString("PREFERENCE_LAST_SHOWN_DIALOG_TYPE", LoopPassphraseUtils.DialogType.WEEK_AFTER.toString())
         .commit();
   }

   public static void a(Fragment var0, LoopPassphraseUtils.DialogType var1) {
      var0.getActivity()
         .getSharedPreferences(var0.getString(2131755063), 0)
         .edit()
         .putLong("PREFERENCE_LOOP_PASSPHRASE_DIALOG_SHOW_DATE", System.currentTimeMillis())
         .putString("PREFERENCE_LAST_SHOWN_DIALOG_TYPE", var1.toString())
         .commit();
      LoopPassphraseSetDialog var2 = new LoopPassphraseSetDialog();
      Bundle var3 = new Bundle();
      var3.putString("ARGS_DIALOG_TYPE", var1.toString());
      var2.setArguments(var3);
      var2.setTargetFragment(var0, 121);
      var2.show(var0.getFragmentManager(), var1.toString());
      var0.getFragmentManager().b();
   }

   public static void a(Fragment var0, LoopPassphraseUtils.DialogType var1, Loop var2) {
      LoopPassphraseRestoreDialog var3 = new LoopPassphraseRestoreDialog();
      Bundle var4 = new Bundle();
      var4.putString("ARGS_DIALOG_TYPE", var1.toString());
      var4.putParcelable(Loop.class.getSimpleName(), var2);
      var3.setArguments(var4);
      var3.setTargetFragment(var0, 122);
      var3.show(var0.getFragmentManager(), var1.toString());
      var0.getFragmentManager().b();
   }

   public static void a(Fragment var0, LoopPassphraseUtils.DialogType var1, String var2) {
      LoopPassphraseInfoDialog var4 = new LoopPassphraseInfoDialog();
      Bundle var3 = new Bundle();
      var3.putString("ARGS_DIALOG_TYPE", var1.toString());
      var3.putString("ARGS_PASSPHRASE", var2);
      var4.setArguments(var3);
      var4.setTargetFragment(var0, 123);
      var4.show(var0.getFragmentManager(), var1.toString());
      var0.getFragmentManager().b();
   }

   public static void a(String var0, BaseFragment var1, LoopPassphraseUtils.KeyBackupCheckListener var2) {
      EntityData.a(var1.getContext()).d().restoreEncryptedKey(var0, null, new AsyncHandler<RestoreRequest, Backup>(var1, var2) {
         final BaseFragment a;
         final LoopPassphraseUtils.KeyBackupCheckListener b;

         {
            this.a = var1;
            this.b = var2x;
         }

         public void a(RestoreRequest var1, Backup var2x) {
            this.a.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.b.a();
               }
            });
         }

         @Override
         public void onError(Exception var1) {
            this.a.a(new Runnable(this) {
               final <unrepresentable> a;

               {
                  this.a = var1;
               }

               @Override
               public void run() {
                  this.a.b.b();
               }
            });
         }
      });
   }

   public static boolean a(FragmentManager var0) {
      boolean var4 = false;
      LoopPassphraseUtils.DialogType[] var5 = LoopPassphraseUtils.DialogType.values();
      int var2 = var5.length;
      int var1 = 0;

      boolean var3;
      while (true) {
         var3 = var4;
         if (var1 >= var2) {
            break;
         }

         if (var0.a(var5[var1].toString()) != null) {
            var3 = true;
            break;
         }

         var1++;
      }

      return var3;
   }

   public static boolean a(String var0, Context var1) {
      return var1.getSharedPreferences(var1.getString(2131755063), 0).getBoolean("PREFERENCE_PASSPHRASE_LOOP_" + var0, false);
   }

   public enum DialogType {
      FIRST_TIME("FIRST_TIME"),
      FROM_SETTINGS("FROM_SETTINGS"),
      MEDIA_ADDED("MEDIA_ADDED"),
      NO_BACKUP_BY_TIMEOUT("NO_BACKUP_BY_TIMEOUT"),
      ON_CANCEL("ON_CANCEL"),
      ON_RECONNECT_TO_JIBO("ON_RECONNECT_TO_JIBO"),
      ON_RECONNECT_TO_JIBO_NO_BACKUP("ON_RECONNECT_TO_JIBO_NO_BACKUP"),
      ON_SET("ON_SET"),
      RESTORE("RESTORE"),
      RESTORE_BY_TIMEOUT("RESTORE_BY_TIMEOUT"),
      WEEK_AFTER("WEEK_AFTER");

      private static final LoopPassphraseUtils.DialogType[] $VALUES = new LoopPassphraseUtils.DialogType[]{
         LoopPassphraseUtils.DialogType.FIRST_TIME,
         LoopPassphraseUtils.DialogType.MEDIA_ADDED,
         LoopPassphraseUtils.DialogType.WEEK_AFTER,
         LoopPassphraseUtils.DialogType.FROM_SETTINGS,
         LoopPassphraseUtils.DialogType.ON_RECONNECT_TO_JIBO,
         LoopPassphraseUtils.DialogType.ON_RECONNECT_TO_JIBO_NO_BACKUP,
         LoopPassphraseUtils.DialogType.ON_CANCEL,
         LoopPassphraseUtils.DialogType.ON_SET,
         LoopPassphraseUtils.DialogType.RESTORE,
         LoopPassphraseUtils.DialogType.RESTORE_BY_TIMEOUT,
         LoopPassphraseUtils.DialogType.NO_BACKUP_BY_TIMEOUT
      };
      private final String name;

      DialogType(String var3) {
         this.name = var3;
      }

      public boolean equalsName(String var1) {
         boolean var2;
         if (var1 == null) {
            var2 = false;
         } else {
            var2 = this.name.equals(var1);
         }

         return var2;
      }

      @Override
      public String toString() {
         return this.name;
      }
   }

   public interface KeyBackupCheckListener {
      void a();

      void b();
   }
}
