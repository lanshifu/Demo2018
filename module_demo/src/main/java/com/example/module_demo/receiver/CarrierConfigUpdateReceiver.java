package com.example.module_demo.receiver;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Base64;

import com.jess.arms.utils.LogUtils;

public class CarrierConfigUpdateReceiver extends BroadcastReceiver {

    Uri uri = Uri.parse("content://com.suntek.mway.carrierconfig/apis");

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("com.suntek.mway.carrier_configuation.intent.action.CARRIER_CONFIG_CHANGED".
                equals(intent.getAction())) {
            LogUtils.debugInfo("收到广播 carrier_configuation ConfigUpdateReceiver");

            if (queryIfDatabaseEmpty(context)){
                LogUtils.debugInfo("读取配置文件为空");
            }else {
                String configXml = readCarrierConfig(context);
                LogUtils.debugInfo("读取配置文件： "+configXml);
            }

        }
    }

    private String readCarrierConfig(Context context) {
        String xmlString = null;
        ContentResolver r = context.getContentResolver();
        Cursor cursor = r.query(uri, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            String config = cursor.getString(1);
            LogUtils.debugInfo("加密的配置文件 ：" +config);
            xmlString = new String(Base64.decode(config, Base64.NO_WRAP)); // 需要Base64解码
            cursor.close();
        }
        return xmlString;
    }

    public  boolean queryIfDatabaseEmpty(Context context) {
        ContentResolver cr = context.getContentResolver();
        Cursor c = cr.query(uri, null, null, null, null);
        if (c == null) {
            return true;
        }
        if (c.getCount() > 0) {
            c.close();
            return false;
        } else {
            c.close();
            return true;
        }

    }
}
