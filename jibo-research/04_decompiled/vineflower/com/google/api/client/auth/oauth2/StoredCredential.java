package com.google.api.client.auth.oauth2;

import com.google.api.client.util.Beta;
import com.google.api.client.util.Objects;
import com.google.api.client.util.store.DataStore;
import com.google.api.client.util.store.DataStoreFactory;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Beta
public final class StoredCredential implements Serializable {
   public static final String DEFAULT_DATA_STORE_ID = StoredCredential.class.getSimpleName();
   private static final long serialVersionUID = 1L;
   private String accessToken;
   private Long expirationTimeMilliseconds;
   private final Lock lock = new ReentrantLock();
   private String refreshToken;

   public StoredCredential() {
   }

   public StoredCredential(Credential var1) {
      this.setAccessToken(var1.getAccessToken());
      this.setRefreshToken(var1.getRefreshToken());
      this.setExpirationTimeMilliseconds(var1.getExpirationTimeMilliseconds());
   }

   public static DataStore<StoredCredential> getDefaultDataStore(DataStoreFactory var0) throws IOException {
      return var0.getDataStore(DEFAULT_DATA_STORE_ID);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof StoredCredential)) {
            var2 = false;
         } else {
            var1 = var1;
            if (!Objects.equal(this.getAccessToken(), var1.getAccessToken())
               || !Objects.equal(this.getRefreshToken(), var1.getRefreshToken())
               || !Objects.equal(this.getExpirationTimeMilliseconds(), var1.getExpirationTimeMilliseconds())) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   public String getAccessToken() {
      this.lock.lock();

      try {
         return this.accessToken;
      } finally {
         this.lock.unlock();
      }
   }

   public Long getExpirationTimeMilliseconds() {
      this.lock.lock();

      try {
         return this.expirationTimeMilliseconds;
      } finally {
         this.lock.unlock();
      }
   }

   public String getRefreshToken() {
      this.lock.lock();

      try {
         return this.refreshToken;
      } finally {
         this.lock.unlock();
      }
   }

   @Override
   public int hashCode() {
      return Arrays.hashCode(new Object[]{this.getAccessToken(), this.getRefreshToken(), this.getExpirationTimeMilliseconds()});
   }

   public StoredCredential setAccessToken(String var1) {
      this.lock.lock();

      try {
         this.accessToken = var1;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public StoredCredential setExpirationTimeMilliseconds(Long var1) {
      this.lock.lock();

      try {
         this.expirationTimeMilliseconds = var1;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   public StoredCredential setRefreshToken(String var1) {
      this.lock.lock();

      try {
         this.refreshToken = var1;
      } finally {
         this.lock.unlock();
      }

      return this;
   }

   @Override
   public String toString() {
      return Objects.toStringHelper(StoredCredential.class)
         .add("accessToken", this.getAccessToken())
         .add("refreshToken", this.getRefreshToken())
         .add("expirationTimeMilliseconds", this.getExpirationTimeMilliseconds())
         .toString();
   }
}
