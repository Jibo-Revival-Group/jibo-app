package com.jibo.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.exception.ForbiddenRequestException;
import com.jibo.aws.integration.aws.services.exception.InvalidParameterValueException;
import com.jibo.aws.integration.aws.services.exception.InvalidRequestContentException;
import com.jibo.aws.integration.aws.services.exception.MethodNotAllowedException;
import com.jibo.aws.integration.aws.services.exception.NotAcceptableException;
import com.jibo.aws.integration.aws.services.exception.ResourceNotFoundException;
import com.jibo.aws.integration.aws.services.exception.ServiceException;
import com.jibo.aws.integration.aws.services.exception.UnauthorizedRequestException;
import com.jibo.aws.integration.aws.services.exception.UnprocessableEntityException;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ErrorHelper {
    /* JADX INFO: renamed from: a */
    private static String m11381a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List listAsList = Arrays.asList(context.getResources().getStringArray(R.array.error_codes));
        List listAsList2 = Arrays.asList(context.getResources().getStringArray(R.array.error_messages));
        int iIndexOf = listAsList.indexOf(str);
        if (iIndexOf == -1 || iIndexOf >= listAsList2.size()) {
            return null;
        }
        return (String) listAsList2.get(iIndexOf);
    }

    /* JADX INFO: renamed from: a */
    public static String m11382a(Context context, Throwable th) {
        StringBuilder sb = new StringBuilder();
        String strM11381a = th instanceof AmazonServiceException ? m11381a(context, ((AmazonServiceException) th).getErrorCode()) : null;
        if (!TextUtils.isEmpty(strM11381a)) {
            sb.append(strM11381a);
        } else if (th instanceof UnprocessableEntityException) {
            sb.append(context.getString(R.string.error_unprocessable_entity));
        } else if (th instanceof ServiceException) {
            sb.append(context.getString(R.string.error_service_exception));
        } else if ((th instanceof NotAcceptableException) || (th instanceof MethodNotAllowedException) || (th instanceof InvalidRequestContentException) || (th instanceof InvalidParameterValueException) || (th instanceof ForbiddenRequestException)) {
            sb.append(context.getString(R.string.error_invalid_request));
        } else if ((th instanceof AmazonClientException) && th.getMessage().contains("No address associated with hostname")) {
            sb.delete(0, sb.length());
            sb.append(context.getString(R.string.error_no_internet_connection));
        } else if (th instanceof KeyManager.NoKeyForLoopException) {
            sb.append(TextUtils.isEmpty(th.getLocalizedMessage()) ? th.toString() : th.getLocalizedMessage());
        } else {
            sb.append(context.getString(R.string.error_non_resolved_serverside_exception));
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m11384a(AmazonServiceException amazonServiceException) {
        return amazonServiceException.getStatusCode() == 503 && "MAINTENANCE_MODE".equals(amazonServiceException.getErrorCode());
    }

    /* JADX INFO: renamed from: b */
    public static boolean m11385b(AmazonServiceException amazonServiceException) {
        return (amazonServiceException instanceof ResourceNotFoundException) && "ACCOUNT_NOT_FOUND".equals(amazonServiceException.getErrorCode());
    }

    /* JADX INFO: renamed from: c */
    public static boolean m11386c(AmazonServiceException amazonServiceException) {
        return amazonServiceException.getStatusCode() == 401 && (amazonServiceException instanceof UnauthorizedRequestException) && "ACCOUNT_NOT_FOUND".equals(amazonServiceException.getErrorCode());
    }

    /* JADX INFO: renamed from: d */
    public static boolean m11387d(AmazonServiceException amazonServiceException) {
        return "ACCOUNT_NOT_ACTIVE".equals(amazonServiceException.getErrorCode());
    }

    /* JADX INFO: renamed from: a */
    public static boolean m11383a(AppCompatActivity appCompatActivity, Fragment fragment, Throwable th) {
        BaseActivity baseActivity;
        if (!(th instanceof AmazonServiceException)) {
            return false;
        }
        AmazonServiceException amazonServiceException = (AmazonServiceException) th;
        if (m11384a(amazonServiceException)) {
            if (fragment != null) {
                DialogUtils.m10523c(fragment, 100, fragment.getString(R.string.dialog_title_maintenance_mode), fragment.getString(R.string.dialog_message_maintenance_mode));
                return true;
            }
            if (appCompatActivity != null) {
                DialogUtils.m10522b((Fragment) null, appCompatActivity.getSupportFragmentManager(), 100, appCompatActivity.getString(R.string.dialog_title_maintenance_mode), appCompatActivity.getString(R.string.dialog_message_maintenance_mode));
                return true;
            }
        } else {
            if (!m11385b(amazonServiceException) && !m11386c(amazonServiceException)) {
                return false;
            }
            if (fragment != null) {
                baseActivity = (BaseActivity) fragment.getActivity();
            } else {
                baseActivity = (BaseActivity) appCompatActivity;
            }
            Toast.makeText(baseActivity, m11381a(baseActivity, amazonServiceException.getErrorCode()), 1).show();
            baseActivity.mo10195e();
        }
        return true;
    }
}
