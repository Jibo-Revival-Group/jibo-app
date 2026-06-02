package com.facebook;

public interface FacebookDialog<CONTENT, RESULT> {
   boolean canShow(CONTENT var1);

   void registerCallback(CallbackManager var1, FacebookCallback<RESULT> var2);

   void registerCallback(CallbackManager var1, FacebookCallback<RESULT> var2, int var3);

   void show(CONTENT var1);
}
