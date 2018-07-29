package com.example.module_demo.mvp.ui.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.TextView;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.module_demo.di.component.DaggerDeviceComponent;
import com.example.module_demo.di.module.DeviceModule;
import com.example.module_demo.mvp.contract.DeviceContract;
import com.example.module_demo.mvp.presenter.DevicePresenter;

import com.example.module_demo.R;
import com.jess.arms.utils.LogUtils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class DeviceActivity extends BaseActivity<DevicePresenter> implements DeviceContract.View {

    private TelephonyManager phone;
    private WifiManager wifi;
    private Display display;
    private DisplayMetrics metrics;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerDeviceComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .deviceModule(new DeviceModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_device; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @SuppressLint("WifiManagerLeak")
    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        phone = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        display = getWindowManager().getDefaultDisplay();

        metrics = getResources().getDisplayMetrics();

        init();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    private void init() {
        DisplayMetrics book = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(book);


        try {
            Class localClass = Class.forName("android.os.SystemProperties");
            Object localObject1 = localClass.newInstance();
            Object localObject2 = localClass.getMethod("get", new Class[]{String.class, String.class}).invoke(localObject1, new Object[]{"gsm.version.baseband", "no message"});
            Object localObject3 = localClass.getMethod("get", new Class[]{String.class, String.class}).invoke(localObject1, new Object[]{"ro.build.display.id", ""});


            setEditText(R.id.get, localObject2 + "");

            setEditText(R.id.osVersion, localObject3 + "");
        } catch (Exception e) {
            e.printStackTrace();
        }


        //获取网络连接管理者
        ConnectivityManager connectionManager = (ConnectivityManager)
                getSystemService(CONNECTIVITY_SERVICE);
        //获取网络的状态信息，有下面三种方式
        NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();

        setEditText(R.id.lianwang, networkInfo.getType() + "");
        setEditText(R.id.lianwangname, networkInfo.getTypeName());
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ArmsUtils.snackbarText("没有权限");
            ArmsUtils.makeText(getApplicationContext(),"没有权限");
            return;
        }
        setEditText(R.id.imei, phone.getDeviceId());
        setEditText(R.id.deviceversion,phone.getDeviceSoftwareVersion());
        setEditText(R.id.imsi, phone.getSubscriberId());
        setEditText(R.id.number, phone.getLine1Number());
        setEditText(R.id.simserial, phone.getSimSerialNumber());
        setEditText(R.id.simoperator,phone.getSimOperator());
        setEditText(R.id.simoperatorname, phone.getSimOperatorName());
        setEditText(R.id.simcountryiso, phone.getSimCountryIso());
        setEditText(R.id.workType,phone.getNetworkType()+"");
        setEditText(R.id.netcountryiso,phone.getNetworkCountryIso());
        setEditText(R.id.netoperator,phone.getNetworkOperator());
        setEditText(R.id.netoperatorname,phone.getNetworkOperatorName());


        setEditText(R.id.radiovis,android.os.Build.getRadioVersion());
        setEditText(R.id.wifimac, wifi.getConnectionInfo().getMacAddress());
        setEditText(R.id.getssid,wifi.getConnectionInfo().getSSID());
        setEditText(R.id.getbssid,wifi.getConnectionInfo().getBSSID());
        setEditText(R.id.ip,wifi.getConnectionInfo().getIpAddress()+"");
        setEditText(R.id.bluemac, BluetoothAdapter.getDefaultAdapter()
                .getAddress());
        setEditText(R.id.bluname, BluetoothAdapter.getDefaultAdapter().getName()
        );

        setEditText(R.id.cpu,getCpuName());


        setEditText(R.id.andrlid_id,
                Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID));
        setEditText(R.id.serial,android.os.Build.SERIAL);
        setEditText(R.id.brand,android.os.Build.BRAND);
        setEditText(R.id.tags, android.os.Build.TAGS);
        setEditText(R.id.device,android.os.Build.DEVICE);
        setEditText(R.id.fingerprint,android.os.Build.FINGERPRINT);
        setEditText(R.id.bootloader, Build.BOOTLOADER);
        setEditText(R.id.release, Build.VERSION.RELEASE);
        setEditText(R.id.sdk,Build.VERSION.SDK);
        setEditText(R.id.sdk_INT,Build.VERSION.SDK_INT+"");
        setEditText(R.id.codename,Build.VERSION.CODENAME);
        setEditText(R.id.incremental,Build.VERSION.INCREMENTAL);
        setEditText(R.id.cpuabi, android.os.Build.CPU_ABI);
        setEditText(R.id.cpuabi2, android.os.Build.CPU_ABI2);
        setEditText(R.id.board, android.os.Build.BOARD);
        setEditText(R.id.model, android.os.Build.MODEL);
        setEditText(R.id.product, android.os.Build.PRODUCT);
        setEditText(R.id.type, android.os.Build.TYPE);
        setEditText(R.id.user, android.os.Build.USER);
        setEditText(R.id.disply, android.os.Build.DISPLAY);
        setEditText(R.id.hardware, android.os.Build.HARDWARE);
        setEditText(R.id.host, android.os.Build.HOST);
        setEditText(R.id.changshang, android.os.Build.MANUFACTURER);
        setEditText(R.id.phonetype,phone.getPhoneType()+"");
        setEditText(R.id.simstate,phone.getSimState()+"");
        setEditText(R.id.b_id, Build.ID);
        setEditText(R.id.gjtime,android.os.Build.TIME+"");
        setEditText(R.id.width,display.getWidth()+"");
        setEditText(R.id.height,display.getHeight()+"");
        setEditText(R.id.dpi,book.densityDpi+"");
        setEditText(R.id.density,book.density+"");
        setEditText(R.id.xdpi,book.xdpi+"");
        setEditText(R.id.ydpi,book.ydpi+"");
        setEditText(R.id.scaledDensity,book.scaledDensity+"");



        //setEditText(R.id.wl,getNetworkState(this)+"");
        // 方法2
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int  height=dm.heightPixels;

        setEditText(R.id.xwidth,width+"");
        setEditText(R.id.xheight,height+"");

    }

    private void setEditText(int id, String s) {
        ((TextView) this.findViewById(id)).setText(s);
    }
    /**
     * 获取CPU型号
     * @return
     */
    public static String getCpuName(){

        String str1 = "/proc/cpuinfo";
        String str2 = "";

        try {
            FileReader fr = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(fr);
            while ((str2=localBufferedReader.readLine()) != null) {
                if (str2.contains("Hardware")) {
                    return str2.split(":")[1];
                }
            }
            localBufferedReader.close();
        } catch (IOException e) {
        }
        return null;

    }
}
