package com.amazonaws.auth;

public enum SigningAlgorithm {
   HmacSHA1,
   HmacSHA256;

   private static final SigningAlgorithm[] $VALUES = new SigningAlgorithm[]{SigningAlgorithm.HmacSHA1, SigningAlgorithm.HmacSHA256};
}
