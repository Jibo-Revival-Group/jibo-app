package com.jibo.p019ui.fragment.dialog.passphrase;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.key.model.Backup;
import com.jibo.aws.integration.aws.services.key.model.RestoreRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.fragment.BaseFragment;

/* JADX INFO: loaded from: classes.dex */
public class LoopPassphraseUtils {

    public interface KeyBackupCheckListener {
        /* JADX INFO: renamed from: a */
        void mo10588a();

        /* JADX INFO: renamed from: b */
        void mo10589b();
    }

    /* JADX INFO: renamed from: a */
    public static void m10581a(Fragment fragment, DialogType dialogType) {
        fragment.getActivity().getSharedPreferences(fragment.getString(R.string.app_name), 0).edit().putLong("PREFERENCE_LOOP_PASSPHRASE_DIALOG_SHOW_DATE", System.currentTimeMillis()).putString("PREFERENCE_LAST_SHOWN_DIALOG_TYPE", dialogType.toString()).commit();
        LoopPassphraseSetDialog loopPassphraseSetDialog = new LoopPassphraseSetDialog();
        Bundle bundle = new Bundle();
        bundle.putString("ARGS_DIALOG_TYPE", dialogType.toString());
        loopPassphraseSetDialog.setArguments(bundle);
        loopPassphraseSetDialog.setTargetFragment(fragment, 121);
        loopPassphraseSetDialog.show(fragment.getFragmentManager(), dialogType.toString());
        fragment.getFragmentManager().mo1477b();
    }

    /* JADX INFO: renamed from: a */
    public static void m10582a(Fragment fragment, DialogType dialogType, Loop loop) {
        LoopPassphraseRestoreDialog loopPassphraseRestoreDialog = new LoopPassphraseRestoreDialog();
        Bundle bundle = new Bundle();
        bundle.putString("ARGS_DIALOG_TYPE", dialogType.toString());
        bundle.putParcelable(Loop.class.getSimpleName(), loop);
        loopPassphraseRestoreDialog.setArguments(bundle);
        loopPassphraseRestoreDialog.setTargetFragment(fragment, 122);
        loopPassphraseRestoreDialog.show(fragment.getFragmentManager(), dialogType.toString());
        fragment.getFragmentManager().mo1477b();
    }

    /* JADX INFO: renamed from: a */
    public static void m10583a(Fragment fragment, DialogType dialogType, String str) {
        LoopPassphraseInfoDialog loopPassphraseInfoDialog = new LoopPassphraseInfoDialog();
        Bundle bundle = new Bundle();
        bundle.putString("ARGS_DIALOG_TYPE", dialogType.toString());
        bundle.putString("ARGS_PASSPHRASE", str);
        loopPassphraseInfoDialog.setArguments(bundle);
        loopPassphraseInfoDialog.setTargetFragment(fragment, 123);
        loopPassphraseInfoDialog.show(fragment.getFragmentManager(), dialogType.toString());
        fragment.getFragmentManager().mo1477b();
    }

    /* JADX INFO: renamed from: a */
    public static DialogType m10579a(Context context, String str, boolean z) {
        if (m10586a(str, context)) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), 0);
        long j = sharedPreferences.getLong("PREFERENCE_LOOP_PASSPHRASE_DIALOG_SHOW_DATE", 0L);
        String string = sharedPreferences.getString("PREFERENCE_LAST_SHOWN_DIALOG_TYPE", null);
        if (DialogType.FIRST_TIME.equalsName(string)) {
            if (jCurrentTimeMillis - j < 86400000 || !z) {
                return null;
            }
            return DialogType.MEDIA_ADDED;
        }
        if (DialogType.MEDIA_ADDED.equalsName(string)) {
            if (jCurrentTimeMillis - j >= 604800000) {
                return DialogType.WEEK_AFTER;
            }
            return null;
        }
        if (DialogType.WEEK_AFTER.equalsName(string)) {
            return null;
        }
        return z ? DialogType.MEDIA_ADDED : DialogType.FIRST_TIME;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m10586a(String str, Context context) {
        return context.getSharedPreferences(context.getString(R.string.app_name), 0).getBoolean("PREFERENCE_PASSPHRASE_LOOP_" + str, false);
    }

    public enum DialogType {
        FIRST_TIME("FIRST_TIME"),
        MEDIA_ADDED("MEDIA_ADDED"),
        WEEK_AFTER("WEEK_AFTER"),
        FROM_SETTINGS("FROM_SETTINGS"),
        ON_RECONNECT_TO_JIBO("ON_RECONNECT_TO_JIBO"),
        ON_RECONNECT_TO_JIBO_NO_BACKUP("ON_RECONNECT_TO_JIBO_NO_BACKUP"),
        ON_CANCEL("ON_CANCEL"),
        ON_SET("ON_SET"),
        RESTORE("RESTORE"),
        RESTORE_BY_TIMEOUT("RESTORE_BY_TIMEOUT"),
        NO_BACKUP_BY_TIMEOUT("NO_BACKUP_BY_TIMEOUT");

        private final String name;

        DialogType(String str) {
            this.name = str;
        }

        public boolean equalsName(String str) {
            if (str == null) {
                return false;
            }
            return this.name.equals(str);
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m10580a(Context context) {
        context.getSharedPreferences(context.getString(R.string.app_name), 0).edit().putLong("PREFERENCE_LOOP_PASSPHRASE_DIALOG_SHOW_DATE", System.currentTimeMillis()).putString("PREFERENCE_LAST_SHOWN_DIALOG_TYPE", DialogType.WEEK_AFTER.toString()).commit();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m10585a(FragmentManager fragmentManager) {
        for (DialogType dialogType : DialogType.values()) {
            if (fragmentManager.mo1470a(dialogType.toString()) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static void m10584a(String str, final BaseFragment baseFragment, final KeyBackupCheckListener keyBackupCheckListener) {
        EntityData.m10089a(baseFragment.getContext()).m10126d().restoreEncryptedKey(str, null, new AsyncHandler<RestoreRequest, Backup>() { // from class: com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseUtils.1
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                baseFragment.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseUtils.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        keyBackupCheckListener.mo10589b();
                    }
                });
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(RestoreRequest restoreRequest, Backup backup) {
                baseFragment.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseUtils.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        keyBackupCheckListener.mo10588a();
                    }
                });
            }
        });
    }
}
