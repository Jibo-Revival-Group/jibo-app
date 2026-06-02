package io.fabric.sdk.android.services.persistence;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public interface PreferenceStore {
   SharedPreferences a();

   boolean a(Editor var1);

   Editor b();
}
