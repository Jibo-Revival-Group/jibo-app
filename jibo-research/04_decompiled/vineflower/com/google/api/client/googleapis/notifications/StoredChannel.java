package com.google.api.client.googleapis.notifications;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Objects;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Beta
public final class StoredChannel implements Serializable {
   public static final String DEFAULT_DATA_STORE_ID = StoredChannel.class.getSimpleName();
   private static final long serialVersionUID = 1L;
   private String clientToken;
   private Long expiration;
   private final String id;
   private final Lock lock = new ReentrantLock();
   private final UnparsedNotificationCallback notificationCallback;
   private String topicId;

   public StoredChannel(UnparsedNotificationCallback var1) {
      this(var1, NotificationUtils.randomUuidString());
   }

   public StoredChannel(UnparsedNotificationCallback var1, String var2) {
      this.notificationCallback = Preconditions.checkNotNull(var1);
      this.id = Preconditions.checkNotNull(var2);
   }

   public static DataStore<StoredChannel> getDefaultDataStore(DataStoreFactory var0) throws IOException {
      return var0.getDataStore(DEFAULT_DATA_STORE_ID);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else if (!(var1 instanceof StoredChannel)) {
         var2 = false;
      } else {
         var1 = var1;
         var2 = this.getId().equals(var1.getId());
      }

      return var2;
   }

   public String getClientToken() {
      this.lock.lock();

      try {
         return this.clientToken;
      } finally {
         this.lock.unlock();
      }
   }

   public Long getExpiration() {
      this.lock.lock();

      try {
         return this.expiration;
      } finally {
         this.lock.unlock();
      }
   }

   public String getId() {
      this.lock.lock();

      try {
         return this.id;
      } finally {
         this.lock.unlock();
      }
   }

   public UnparsedNotificationCallback getNotificationCallback() {
      this.lock.lock();

      try {
         return this.notificationCallback;
      } finally {
         this.lock.unlock();
      }
   }

   public String getTopicId() {
      this.lock.lock();

      try {
         return this.topicId;
      } finally {
         this.lock.unlock();
      }
   }

   @Override
   public int hashCode() {
      return this.getId().hashCode();
   }

   public StoredChannel setClientToken(String var1) {
      this.lock.lock();

      try {
         this.clientToken = var1;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public StoredChannel setExpiration(Long var1) {
      this.lock.lock();

      try {
         this.expiration = var1;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public StoredChannel setTopicId(String var1) {
      this.lock.lock();

      try {
         this.topicId = var1;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public StoredChannel store(DataStore<StoredChannel> var1) throws IOException {
      this.lock.lock();

      try {
         var1.set(this.getId(), this);
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public StoredChannel store(DataStoreFactory var1) throws IOException {
      return this.store(getDefaultDataStore(var1));
   }

   @Override
   public String toString() {
      return Objects.toStringHelper(StoredChannel.class)
         .add("notificationCallback", this.getNotificationCallback())
         .add("clientToken", this.getClientToken())
         .add("expiration", this.getExpiration())
         .add("id", this.getId())
         .add("topicId", this.getTopicId())
         .toString();
   }
}
