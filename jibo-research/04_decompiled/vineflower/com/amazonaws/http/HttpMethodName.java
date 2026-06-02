package com.amazonaws.http;

public enum HttpMethodName {
   DELETE,
   GET,
   HEAD,
   POST,
   PUT;

   private static final HttpMethodName[] $VALUES = new HttpMethodName[]{
      HttpMethodName.GET, HttpMethodName.POST, HttpMethodName.PUT, HttpMethodName.DELETE, HttpMethodName.HEAD
   };
}
