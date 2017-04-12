package com.zijin.wifi_teacher.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.zijin.wifi_teacher.R;
import com.zijin.wifi_teacher.utils.WifiApAdmin;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yin on 2017/4/9.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_create_ap,btn_close_ap;
    private Button login_btn_back,login_btn_next;
    private ImageView lv_wifiap;
    private TextView tv_ap_text;
    private EditText et_name,et_class;
    private ProgressBar creating_progressBar;

    private Context mContext = null;
    private WifiManager mWifiManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_login);

        btn_create_ap = (Button) findViewById(R.id.btn_create_ap);
        btn_close_ap = (Button) findViewById(R.id.btn_close_ap);
        login_btn_back = (Button) findViewById(R.id.login_btn_back);
        login_btn_next = (Button) findViewById(R.id.login_btn_next);
        lv_wifiap = (ImageView) findViewById(R.id.lv_wifiap);
        tv_ap_text = (TextView) findViewById(R.id.tv_ap_text);
        et_name = (EditText) findViewById(R.id.et_name);
        et_class = (EditText) findViewById(R.id.et_class);
        creating_progressBar = (ProgressBar) findViewById(R.id.creating_progressBar);

        btn_create_ap.setOnClickListener(this);
        btn_close_ap.setOnClickListener(this);
        login_btn_back.setOnClickListener(this);
        login_btn_next.setOnClickListener(this);


    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()){
            //创建热点
            case R.id.btn_create_ap:

                AlertDialog.Builder builder=new AlertDialog.Builder(this);  //先得到构造器
                builder.setTitle("提示"); //设置标题
                builder.setMessage("创建热点需关闭wifi，确认继续?"); //设置内容
                builder.setIcon(R.mipmap.ic_launcher);//设置图标，图片id即可
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { //设置确定按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String ssid = et_name.getText().toString();
                        if(null == ssid || "".equals(ssid)){
                            Toast.makeText(LoginActivity.this, "请输入您的名字", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            btn_create_ap.setVisibility(View.GONE);
                            creating_progressBar.setVisibility(View.VISIBLE);
                            tv_ap_text.setText("正在创建...");

                            final String wifissid = "一键点名" + "_" + ssid;
                            WifiApAdmin wifiAp = new WifiApAdmin(mContext);
                            wifiAp.startWifiAp(wifissid, "wifiService123");

                            //延时2秒执行
                            new Handler().postDelayed((new Runnable() {
                                @Override
                                public void run() {
                                    creating_progressBar.setVisibility(View.GONE);
                                    lv_wifiap.setVisibility(View.VISIBLE);
                                    tv_ap_text.setText("热点创建成功！\n\n" + wifissid);
                                    btn_close_ap.setVisibility(View.VISIBLE);
                                }
                            }), 2000);
                        }
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { //设置取消按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
                break;
            //关闭热点
            case R.id.btn_close_ap:
                AlertDialog.Builder builder1=new AlertDialog.Builder(this);  //先得到构造器
                builder1.setTitle("提示"); //设置标题
                builder1.setMessage("确认关闭热点?"); //设置内容
                builder1.setIcon(R.mipmap.ic_launcher);//设置图标，图片id即可
                builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() { //设置确定按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        WifiApAdmin wifiAp = new WifiApAdmin(mContext);
                        wifiAp.closeWifiAp(mWifiManager);
                        lv_wifiap.setVisibility(View.GONE);
                        tv_ap_text.setText("");
                        btn_close_ap.setVisibility(View.GONE);
                        btn_create_ap.setVisibility(View.VISIBLE);
                    }
                });
                builder1.setNegativeButton("取消", new DialogInterface.OnClickListener() { //设置取消按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder1.create().show();
                break;
            //返回
            case R.id.login_btn_back:
                Intent intent1 = new Intent(getApplicationContext(), WelcomeActivity.class);
                startActivity(intent1);
                break;
            //下一步
            case R.id.login_btn_next:
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
