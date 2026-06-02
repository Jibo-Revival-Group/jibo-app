package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;

public class StaticLoggerBinder {
   public static String a = "1.6.99";
   private static final StaticLoggerBinder b = new StaticLoggerBinder();
   private static final String c = NOPLoggerFactory.class.getName();
   private final ILoggerFactory d = new NOPLoggerFactory();

   private StaticLoggerBinder() {
   }

   public static final StaticLoggerBinder a() {
      return b;
   }

   public ILoggerFactory b() {
      return this.d;
   }

   public String c() {
      return c;
   }
}
