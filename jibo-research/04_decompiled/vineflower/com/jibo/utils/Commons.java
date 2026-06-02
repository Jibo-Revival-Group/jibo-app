package com.jibo.utils;

import java.util.regex.Pattern;

public class Commons {
   public static final Pattern a = Pattern.compile(
      "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"
   );
   public static final Pattern b = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
   public static final Pattern c = Pattern.compile("\\w*[A-Z]\\w*");
   public static final Pattern d = Pattern.compile("\\w*[a-z]\\w*");
   public static final Pattern e = Pattern.compile(".*\\d+.*");
   public static final Pattern f = Pattern.compile("(([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3}))");
}
