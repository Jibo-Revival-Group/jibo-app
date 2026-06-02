package io.fabric.sdk.android.services.cache;

import android.content.Context;

public interface ValueCache<T> {
   T a(Context var1, ValueLoader<T> var2) throws Exception;
}
