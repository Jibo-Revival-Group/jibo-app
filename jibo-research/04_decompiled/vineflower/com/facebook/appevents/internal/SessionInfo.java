package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import java.util.UUID;

class SessionInfo {
   private static final String INTERRUPTION_COUNT_KEY = "com.facebook.appevents.SessionInfo.interruptionCount";
   private static final String LAST_SESSION_INFO_END_KEY = "com.facebook.appevents.SessionInfo.sessionEndTime";
   private static final String LAST_SESSION_INFO_START_KEY = "com.facebook.appevents.SessionInfo.sessionStartTime";
   private static final String SESSION_ID_KEY = "com.facebook.appevents.SessionInfo.sessionId";
   private Long diskRestoreTime;
   private int interruptionCount;
   private UUID sessionId;
   private Long sessionLastEventTime;
   private Long sessionStartTime;
   private SourceApplicationInfo sourceApplicationInfo;

   public SessionInfo(Long var1, Long var2) {
      this(var1, var2, UUID.randomUUID());
   }

   public SessionInfo(Long var1, Long var2, UUID var3) {
      this.sessionStartTime = var1;
      this.sessionLastEventTime = var2;
      this.sessionId = var3;
   }

   public static void clearSavedSessionFromDisk() {
      Editor var0 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
      var0.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
      var0.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
      var0.remove("com.facebook.appevents.SessionInfo.interruptionCount");
      var0.remove("com.facebook.appevents.SessionInfo.sessionId");
      var0.apply();
      SourceApplicationInfo.clearSavedSourceApplicationInfoFromDisk();
   }

   public static SessionInfo getStoredSessionInfo() {
      Object var5 = null;
      SharedPreferences var6 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
      long var2 = var6.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", 0L);
      long var0 = var6.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", 0L);
      String var7 = var6.getString("com.facebook.appevents.SessionInfo.sessionId", null);
      SessionInfo var4 = (SessionInfo)var5;
      if (var2 != 0L) {
         var4 = (SessionInfo)var5;
         if (var0 != 0L) {
            if (var7 == null) {
               var4 = (SessionInfo)var5;
            } else {
               var4 = new SessionInfo(var2, var0);
               var4.interruptionCount = var6.getInt("com.facebook.appevents.SessionInfo.interruptionCount", 0);
               var4.sourceApplicationInfo = SourceApplicationInfo.getStoredSourceApplicatioInfo();
               var4.diskRestoreTime = System.currentTimeMillis();
               var4.sessionId = UUID.fromString(var7);
            }
         }
      }

      return var4;
   }

   public long getDiskRestoreTime() {
      long var1;
      if (this.diskRestoreTime == null) {
         var1 = 0L;
      } else {
         var1 = this.diskRestoreTime;
      }

      return var1;
   }

   public int getInterruptionCount() {
      return this.interruptionCount;
   }

   public UUID getSessionId() {
      return this.sessionId;
   }

   public Long getSessionLastEventTime() {
      return this.sessionLastEventTime;
   }

   public long getSessionLength() {
      long var1;
      if (this.sessionStartTime != null && this.sessionLastEventTime != null) {
         var1 = this.sessionLastEventTime - this.sessionStartTime;
      } else {
         var1 = 0L;
      }

      return var1;
   }

   public Long getSessionStartTime() {
      return this.sessionStartTime;
   }

   public SourceApplicationInfo getSourceApplicationInfo() {
      return this.sourceApplicationInfo;
   }

   public void incrementInterruptionCount() {
      this.interruptionCount++;
   }

   public void setSessionLastEventTime(Long var1) {
      this.sessionLastEventTime = var1;
   }

   public void setSessionStartTime(Long var1) {
      this.sessionStartTime = var1;
   }

   public void setSourceApplicationInfo(SourceApplicationInfo var1) {
      this.sourceApplicationInfo = var1;
   }

   public void writeSessionToDisk() {
      Editor var1 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
      var1.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", this.sessionStartTime);
      var1.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", this.sessionLastEventTime);
      var1.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.interruptionCount);
      var1.putString("com.facebook.appevents.SessionInfo.sessionId", this.sessionId.toString());
      var1.apply();
      if (this.sourceApplicationInfo != null) {
         this.sourceApplicationInfo.writeSourceApplicationInfoToDisk();
      }
   }
}
