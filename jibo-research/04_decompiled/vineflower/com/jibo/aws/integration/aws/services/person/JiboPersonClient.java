package com.jibo.aws.integration.aws.services.person;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.google.gson.JsonObject;
import com.jibo.aws.integration.aws.services.AbstractJiboClient;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.person.model.GetAccountPropertiesRequest;
import com.jibo.aws.integration.aws.services.person.model.GetLoopPropertiesRequest;
import com.jibo.aws.integration.aws.services.person.model.Holiday;
import com.jibo.aws.integration.aws.services.person.model.HolidaysSwitchRequest;
import com.jibo.aws.integration.aws.services.person.model.ListHolidaysRequest;
import com.jibo.aws.integration.aws.services.person.model.SetAccountPropertyRequest;
import com.jibo.aws.integration.aws.services.person.model.SetLoopPropertyRequest;
import com.jibo.aws.integration.aws.services.person.model.a.b;
import com.jibo.aws.integration.util.a;
import java.util.HashMap;
import java.util.List;

public class JiboPersonClient extends AbstractJiboClient {
   public static final String TAG = com.jibo.aws.integration.util.a.a(JiboPersonClient.class);

   public JiboPersonClient(AWSCredentials var1) {
      super(var1);
   }

   public JiboPersonClient(AWSCredentials var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboPersonClient(AWSCredentialsProvider var1) {
      super(var1);
   }

   public JiboPersonClient(AWSCredentialsProvider var1, ClientConfiguration var2) {
      super(var1, var2);
   }

   public JiboPersonClient(AWSCredentialsProvider var1, ClientConfiguration var2, HttpClient var3) {
      super(var1, var2, var3);
   }

   public HashMap<String, JsonObject> getAccountProperties(List<String> var1) {
      return this.a(new GetAccountPropertiesRequest(var1), null, new com.jibo.aws.integration.aws.services.person.model.a.a()).getAwsResponse();
   }

   public HashMap<String, JsonObject> getLoopProperties(String var1, List<String> var2) {
      return this.a(new GetLoopPropertiesRequest(var1, var2), null, new com.jibo.aws.integration.aws.services.person.model.a.a()).getAwsResponse();
   }

   public List<Holiday> listHolidays(String var1) {
      return this.a(new ListHolidaysRequest(var1), null, new b()).getAwsResponse();
   }

   public CommandResponse setAccountProperty(String var1, JsonObject var2) {
      return this.a(new SetAccountPropertyRequest(var1, var2), null, new com.jibo.aws.integration.aws.services.common.model.a.a()).getAwsResponse();
   }

   public CommandResponse setLoopProperty(String var1, String var2, JsonObject var3) {
      return this.a(new SetLoopPropertyRequest(var1, var2, var3), null, new com.jibo.aws.integration.aws.services.common.model.a.a()).getAwsResponse();
   }

   public CommandResponse switchHolidays(boolean var1, List<String> var2, String var3) {
      return this.a(new HolidaysSwitchRequest(var1, var2, var3), null, new com.jibo.aws.integration.aws.services.common.model.a.a()).getAwsResponse();
   }
}
