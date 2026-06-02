package com.google.api.client.googleapis.testing.notifications;

import com.google.api.client.googleapis.notifications.StoredChannel;
import com.google.api.client.googleapis.notifications.UnparsedNotification;
import com.google.api.client.googleapis.notifications.UnparsedNotificationCallback;
import com.google.api.client.util.Beta;
import java.io.IOException;

@Beta
public class MockUnparsedNotificationCallback implements UnparsedNotificationCallback {
   private static final long serialVersionUID = 0L;
   private boolean wasCalled;

   @Override
   public void onNotification(StoredChannel var1, UnparsedNotification var2) throws IOException {
      this.wasCalled = true;
   }

   public boolean wasCalled() {
      return this.wasCalled;
   }
}
