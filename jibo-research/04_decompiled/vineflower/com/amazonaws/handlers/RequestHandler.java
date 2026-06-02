package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.util.TimingInfo;

@Deprecated
public interface RequestHandler {
   void afterError(Request<?> var1, Exception var2);

   void afterResponse(Request<?> var1, Object var2, TimingInfo var3);

   void beforeRequest(Request<?> var1);
}
