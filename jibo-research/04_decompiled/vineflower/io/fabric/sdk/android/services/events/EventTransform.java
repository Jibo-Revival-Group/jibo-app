package io.fabric.sdk.android.services.events;

import java.io.IOException;

public interface EventTransform<T> {
   byte[] a(T var1) throws IOException;
}
