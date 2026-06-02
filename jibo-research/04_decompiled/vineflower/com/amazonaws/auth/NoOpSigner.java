package com.amazonaws.auth;

import com.amazonaws.Request;

public class NoOpSigner implements Signer {
   @Override
   public void sign(Request<?> var1, AWSCredentials var2) {
   }
}
