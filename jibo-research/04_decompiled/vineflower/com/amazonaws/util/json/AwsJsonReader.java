package com.amazonaws.util.json;

import java.io.Reader;

public interface AwsJsonReader {
   void beginObject();

   void close();

   void endObject();

   Reader getReader();

   boolean hasNext();

   boolean isContainer();

   String nextName();

   String nextString();

   AwsJsonToken peek();

   void skipValue();
}
