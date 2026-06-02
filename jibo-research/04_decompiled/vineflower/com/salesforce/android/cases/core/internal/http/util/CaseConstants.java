package com.salesforce.android.cases.core.internal.http.util;

import android.annotation.SuppressLint;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SuppressLint("SimpleDateFormat")
public class CaseConstants {
   public static final Date a = new Date(0L);
   public static final Map<String, String> b = new HashMap<>();

   static {
      b.put("equals", "=");
      b.put("notEquals", "!=");
      b.put("lessThan", "<");
      b.put("greaterThan", ">");
      b.put("lessThanOrEqualTo", "<=");
      b.put("greaterThanOrEqualTo", ">=");
      b.put("like", "like");
   }
}
