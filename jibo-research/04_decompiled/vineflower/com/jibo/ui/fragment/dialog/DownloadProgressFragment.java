package com.jibo.ui.fragment.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Handler.Callback;
import android.support.v4.app.DialogFragment;
import com.bumptech.glide.signature.EmptySignature;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.jibo.JiboGlideModule;
import com.jibo.aws.integration.aws.services.media.model.Media;
import com.jibo.aws.integration.helpers.MediaHelper;
import com.jibo.db.DatabaseContract;
import com.jibo.db.EntityData;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.OriginalKey;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.cache.DiskLruCacheWrapper;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class DownloadProgressFragment extends DialogFragment {
   private Thread a;
   private Handler b;
   private Callback c = new Callback(this) {
      final DownloadProgressFragment a;

      {
         this.a = var1;
      }

      public boolean handleMessage(Message var1) {
         if (this.a.getActivity() != null && !this.a.getActivity().isFinishing() && !this.a.isDetached() && this.a.isResumed()) {
            if (var1.what >= 0) {
               ((ProgressDialog)this.a.getDialog()).setProgress(var1.what);
            } else {
               if (this.a.getTargetFragment() != null && this.a.getTargetFragment() instanceof DialogUtils.DialogFragmentWrapperClickListener) {
                  ((DialogUtils.DialogFragmentWrapperClickListener)this.a.getTargetFragment()).a(this.a.getTargetRequestCode(), -1, this.a.f);
               }

               this.a.getDialog().dismiss();
            }
         }

         return true;
      }
   };
   private int d = 0;
   private ArrayList<String> e;
   private ArrayList<String> f = new ArrayList<>();

   public DownloadProgressFragment() {
      this.b = new Handler(Looper.getMainLooper(), this.c);
   }

   private boolean a() {
      boolean var1;
      if (this.getActivity() != null && !this.getActivity().isFinishing() && !this.isDetached() && this.isResumed()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      if (var1 != null) {
         this.e = var1.getStringArrayList("ARG_IDS");
         this.f = var1.getStringArrayList("ARG_PATHS");
         this.d = var1.getInt("ARG_INDX", 0);
      } else if (this.getArguments() != null) {
         this.e = this.getArguments().getStringArrayList("ARG_IDS");
         this.d = 0;
      }

      ProgressDialog var2 = new ProgressDialog(this.getActivity());
      var2.setTitle(this.getString(2131755269));
      var2.setIndeterminate(false);
      var2.setProgressStyle(1);
      var2.setOnCancelListener(new OnCancelListener(this) {
         final DownloadProgressFragment a;

         {
            this.a = var1;
         }

         public void onCancel(DialogInterface var1) {
         }
      });
      var2.setCanceledOnTouchOutside(false);
      var2.setButton(-2, this.getString(17039360), new OnClickListener(this) {
         final DownloadProgressFragment a;

         {
            this.a = var1;
         }

         public void onClick(DialogInterface var1, int var2x) {
         }
      });
      return var2;
   }

   @Override
   public void onPause() {
      super.onPause();
      if (this.a != null && !this.a.isInterrupted()) {
         this.a.interrupt();
      }

      this.b.removeCallbacksAndMessages(null);
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.e != null && !this.e.isEmpty()) {
         ((ProgressDialog)this.getDialog()).setMax(this.e.size());
         ((ProgressDialog)this.getDialog()).setProgress(0);
         this.a = new Thread(
            new Runnable(this) {
               final DownloadProgressFragment a;

               {
                  this.a = var1;
               }

               // $VF: Duplicated exception handlers to handle obfuscated exceptions
               private void a(boolean var1, Media var2) {
                  try {
                     if (!this.a.a()) {
                        return;
                     }
                  } catch (Exception var15) {
                     return;
                  }

                  HttpURLConnection var18;
                  label85: {
                     File var4;
                     label69: {
                        int var3;
                        String var5;
                        try {
                           var5 = MediaHelper.getUrl(var1, var2);
                           var4 = new File(this.a.getActivity().getExternalCacheDir(), OriginalKey.a(var5));
                           StringBuilder var6 = new StringBuilder();
                           var16 = MediaHelper.getShareableFile(
                              var6.append(this.a.getActivity().getExternalCacheDir()).append("/").append("share").toString(), var2
                           );
                           if (var4.exists()) {
                              break label69;
                           }

                           URL var17 = new URL(var5);
                           var18 = (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(var17.openConnection()));
                           var18.setReadTimeout(10000);
                           var18.setConnectTimeout(5000);
                           var18.setRequestMethod("GET");
                           var18.setDoInput(true);
                           var18.connect();
                           var3 = var18.getResponseCode();
                           if (!this.a.a()) {
                              break label85;
                           }
                        } catch (Exception var14) {
                           return;
                        }

                        if (var3 != 200) {
                           break label85;
                        }

                        try {
                           InputStream var19 = var18.getInputStream();
                           DiskLruCacheWrapper var7 = (DiskLruCacheWrapper)JiboGlideModule.a(this.a.getActivity()).build();
                           OriginalKey var8 = new OriginalKey(var5, EmptySignature.a());
                           var7.a(var8, var19);
                        } catch (Exception var13) {
                           return;
                        }
                     }

                     label47: {
                        try {
                           if (!var4.exists() || !this.a.a()) {
                              break label47;
                           }

                           if (!var16.exists()) {
                              ImageUtils.a(var4, var16);
                           }
                        } catch (Exception var12) {
                           return;
                        }

                        try {
                           this.a.f.add(var16.getPath());
                        } catch (Exception var11) {
                           return;
                        }
                     }

                     try {
                        this.a.d++;
                     } catch (Exception var9) {
                     }

                     return;
                  }

                  try {
                     var18.disconnect();
                  } catch (Exception var10) {
                  }
               }

               // $VF: Duplicated exception handlers to handle obfuscated exceptions
               @Override
               public void run() {
                  Object var4 = null;

                  boolean var3;
                  try {
                     JiboGlideModule.b(this.a.getActivity());
                     var3 = SharedPreferencesUtil.g(this.a.getActivity().getApplicationContext());
                  } catch (Exception var36) {
                     return;
                  }

                  while (true) {
                     int var1;
                     int var2;
                     try {
                        if (this.a.a.isInterrupted() || !this.a.a()) {
                           break;
                        }

                        var1 = this.a.d;
                        var2 = this.a.e.size();
                     } catch (Exception var37) {
                        return;
                     }

                     if (var1 >= var2) {
                        break;
                     }

                     Object var5;
                     label219: {
                        label206: {
                           label205: {
                              label204: {
                                 label220: {
                                    try {
                                       var5 = this.a
                                          .getActivity()
                                          .getContentResolver()
                                          .query(DatabaseContract.MediaEntry.a(this.a.e.get(this.a.d)), DatabaseContract.MediaEntry.a, null, null, null);
                                    } catch (Exception var40) {
                                       var5 = var40;
                                       break label220;
                                    } finally {
                                       break label206;
                                    }

                                    var4 = var5;
                                    if (var4 == null) {
                                       break label204;
                                    }

                                    try {
                                       if (!var4.isClosed() && var4.moveToFirst()) {
                                          this.a(var3, EntityData.c((Cursor)var4));
                                       }
                                       break label204;
                                    } catch (Exception var38) {
                                       var5 = var38;
                                    } finally {
                                       break label206;
                                    }
                                 }

                                 var5 = var4;
                                 if (var4 != null) {
                                    try {
                                       var4.close();
                                       break label219;
                                    } catch (Exception var34) {
                                       return;
                                    }
                                 }
                                 break label205;
                              }

                              var5 = var4;
                              if (var4 != null) {
                                 try {
                                    var4.close();
                                    break label219;
                                 } catch (Exception var35) {
                                    return;
                                 }
                              }
                           }

                           var4 = var5;
                           break label219;
                        }

                        if (var4 != null) {
                           try {
                              var4.close();
                           } catch (Exception var32) {
                              return;
                           }
                        }

                        try {
                           throw var5;
                        } catch (Exception var31) {
                           return;
                        }
                     }

                     try {
                        var5 = new Message();
                        ((Message)var5).what = this.a.d;
                        this.a.b.sendMessage((Message)var5);
                     } catch (Exception var33) {
                        return;
                     }
                  }

                  try {
                     Message var42 = new Message();
                     var42.what = -1;
                     this.a.b.sendMessage(var42);
                  } catch (Exception var30) {
                  }
               }
            }
         );
         this.a.start();
      } else {
         this.getDialog().dismiss();
      }
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putStringArrayList("ARG_INDX", this.e);
      var1.putStringArrayList("ARG_PATHS", this.f);
      var1.putInt("ARG_INDX", this.d);
   }

   @Override
   public void onStart() {
      super.onStart();
   }
}
