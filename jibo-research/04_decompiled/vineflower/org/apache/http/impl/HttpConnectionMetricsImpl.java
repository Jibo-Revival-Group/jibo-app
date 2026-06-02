package org.apache.http.impl;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.HttpTransportMetrics;

@NotThreadSafe
public class HttpConnectionMetricsImpl implements HttpConnectionMetrics {
   public static final String RECEIVED_BYTES_COUNT = "http.received-bytes-count";
   public static final String REQUEST_COUNT = "http.request-count";
   public static final String RESPONSE_COUNT = "http.response-count";
   public static final String SENT_BYTES_COUNT = "http.sent-bytes-count";
   private final HttpTransportMetrics inTransportMetric;
   private Map<String, Object> metricsCache;
   private final HttpTransportMetrics outTransportMetric;
   private long requestCount = 0L;
   private long responseCount = 0L;

   public HttpConnectionMetricsImpl(HttpTransportMetrics var1, HttpTransportMetrics var2) {
      this.inTransportMetric = var1;
      this.outTransportMetric = var2;
   }

   @Override
   public Object getMetric(String var1) {
      Object var3;
      if (this.metricsCache != null) {
         var3 = this.metricsCache.get(var1);
      } else {
         var3 = null;
      }

      Object var2 = var3;
      if (var3 == null) {
         if ("http.request-count".equals(var1)) {
            var2 = this.requestCount;
         } else if ("http.response-count".equals(var1)) {
            var2 = this.responseCount;
         } else if ("http.received-bytes-count".equals(var1)) {
            if (this.inTransportMetric != null) {
               var2 = this.inTransportMetric.getBytesTransferred();
            } else {
               var2 = null;
            }
         } else {
            var2 = var3;
            if ("http.sent-bytes-count".equals(var1)) {
               if (this.outTransportMetric != null) {
                  var2 = this.outTransportMetric.getBytesTransferred();
               } else {
                  var2 = null;
               }
            }
         }
      }

      return var2;
   }

   @Override
   public long getReceivedBytesCount() {
      long var1;
      if (this.inTransportMetric != null) {
         var1 = this.inTransportMetric.getBytesTransferred();
      } else {
         var1 = -1L;
      }

      return var1;
   }

   @Override
   public long getRequestCount() {
      return this.requestCount;
   }

   @Override
   public long getResponseCount() {
      return this.responseCount;
   }

   @Override
   public long getSentBytesCount() {
      long var1;
      if (this.outTransportMetric != null) {
         var1 = this.outTransportMetric.getBytesTransferred();
      } else {
         var1 = -1L;
      }

      return var1;
   }

   public void incrementRequestCount() {
      this.requestCount++;
   }

   public void incrementResponseCount() {
      this.responseCount++;
   }

   @Override
   public void reset() {
      if (this.outTransportMetric != null) {
         this.outTransportMetric.reset();
      }

      if (this.inTransportMetric != null) {
         this.inTransportMetric.reset();
      }

      this.requestCount = 0L;
      this.responseCount = 0L;
      this.metricsCache = null;
   }

   public void setMetric(String var1, Object var2) {
      if (this.metricsCache == null) {
         this.metricsCache = new HashMap<>();
      }

      this.metricsCache.put(var1, var2);
   }
}
