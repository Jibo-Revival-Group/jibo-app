package org.slf4j.event;

public enum Level {
   DEBUG(10, "DEBUG"),
   ERROR(40, "ERROR"),
   INFO(20, "INFO"),
   TRACE(0, "TRACE"),
   WARN(30, "WARN");

   private static final Level[] $VALUES = new Level[]{Level.ERROR, Level.WARN, Level.INFO, Level.DEBUG, Level.TRACE};
   private int levelInt;
   private String levelStr;

   Level(int var3, String var4) {
      this.levelInt = var3;
      this.levelStr = var4;
   }

   public int toInt() {
      return this.levelInt;
   }

   @Override
   public String toString() {
      return this.levelStr;
   }
}
