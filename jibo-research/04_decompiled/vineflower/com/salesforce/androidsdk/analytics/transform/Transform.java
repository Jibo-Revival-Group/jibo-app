package com.salesforce.androidsdk.analytics.transform;

import com.salesforce.androidsdk.analytics.model.InstrumentationEvent;
import org.json.JSONObject;

public interface Transform {
   JSONObject a(InstrumentationEvent var1);
}
