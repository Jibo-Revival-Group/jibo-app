package com.google.api.client.http;

import com.google.api.client.util.Beta;
import java.io.IOException;

@Deprecated
@Beta
public interface BackOffPolicy {
   long STOP = -1L;

   long getNextBackOffMillis() throws IOException;

   boolean isBackOffRequired(int var1);

   void reset();
}
