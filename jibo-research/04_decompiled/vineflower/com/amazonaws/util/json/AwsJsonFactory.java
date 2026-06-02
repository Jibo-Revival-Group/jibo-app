package com.amazonaws.util.json;

import java.io.Reader;

public interface AwsJsonFactory {
   AwsJsonReader getJsonReader(Reader var1);
}
