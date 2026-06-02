package com.amazonaws.transform;

import com.amazonaws.AmazonServiceException;

public abstract class AbstractErrorUnmarshaller<T> implements Unmarshaller<AmazonServiceException, T> {
   protected final Class<? extends AmazonServiceException> exceptionClass;

   public AbstractErrorUnmarshaller() {
      this(AmazonServiceException.class);
   }

   public AbstractErrorUnmarshaller(Class<? extends AmazonServiceException> var1) {
      this.exceptionClass = var1;
   }

   protected AmazonServiceException newException(String var1) {
      return this.exceptionClass.getConstructor(String.class).newInstance(var1);
   }
}
