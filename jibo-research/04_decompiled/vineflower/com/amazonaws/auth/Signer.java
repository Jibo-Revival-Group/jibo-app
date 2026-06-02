package com.amazonaws.auth;

import com.amazonaws.Request;

public interface Signer {
   void sign(Request<?> var1, AWSCredentials var2);
}
