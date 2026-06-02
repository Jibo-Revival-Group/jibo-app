package com.amazonaws.util.json;

public enum AwsJsonToken {
   BEGIN_ARRAY,
   BEGIN_OBJECT,
   END_ARRAY,
   END_OBJECT,
   FIELD_NAME,
   UNKNOWN,
   VALUE_BOOLEAN,
   VALUE_NULL,
   VALUE_NUMBER,
   VALUE_STRING;

   private static final AwsJsonToken[] $VALUES = new AwsJsonToken[]{
      AwsJsonToken.BEGIN_ARRAY,
      AwsJsonToken.END_ARRAY,
      AwsJsonToken.BEGIN_OBJECT,
      AwsJsonToken.END_OBJECT,
      AwsJsonToken.FIELD_NAME,
      AwsJsonToken.VALUE_BOOLEAN,
      AwsJsonToken.VALUE_NULL,
      AwsJsonToken.VALUE_NUMBER,
      AwsJsonToken.VALUE_STRING,
      AwsJsonToken.UNKNOWN
   };
}
