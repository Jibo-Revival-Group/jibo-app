package com.google.api.client.extensions.android.json;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonWriter;
import com.google.api.client.extensions.android.AndroidUtils;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.JsonParser;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Charsets;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;

@TargetApi(11)
@Beta
public class AndroidJsonFactory extends JsonFactory {
   public AndroidJsonFactory() {
      AndroidUtils.checkMinimumSdkLevel(11);
   }

   public static AndroidJsonFactory getDefaultInstance() {
      return AndroidJsonFactory.InstanceHolder.INSTANCE;
   }

   @Override
   public JsonGenerator createJsonGenerator(OutputStream var1, Charset var2) {
      return this.createJsonGenerator(new OutputStreamWriter(var1, var2));
   }

   @Override
   public JsonGenerator createJsonGenerator(Writer var1) {
      return new AndroidJsonGenerator(this, new JsonWriter(var1));
   }

   @Override
   public JsonParser createJsonParser(InputStream var1) {
      return this.createJsonParser(new InputStreamReader(var1, Charsets.UTF_8));
   }

   @Override
   public JsonParser createJsonParser(InputStream var1, Charset var2) {
      JsonParser var3;
      if (var2 == null) {
         var3 = this.createJsonParser(var1);
      } else {
         var3 = this.createJsonParser(new InputStreamReader(var1, var2));
      }

      return var3;
   }

   @Override
   public JsonParser createJsonParser(Reader var1) {
      return new AndroidJsonParser(this, new JsonReader(var1));
   }

   @Override
   public JsonParser createJsonParser(String var1) {
      return this.createJsonParser(new StringReader(var1));
   }

   @Beta
   static class InstanceHolder {
      static final AndroidJsonFactory INSTANCE = new AndroidJsonFactory();
   }
}
