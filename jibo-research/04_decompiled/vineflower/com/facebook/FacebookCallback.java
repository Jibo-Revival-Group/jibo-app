package com.facebook;

public interface FacebookCallback<RESULT> {
   void onCancel();

   void onError(FacebookException var1);

   void onSuccess(RESULT var1);
}
