package com.example.detectincomingcall;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;


public class MyCallReceiver extends BroadcastReceiver {

    private static final String AUDIO_RECORDER_FOLDER = "CallRecorder";
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            // This code will execute when the phone has an incoming call

            // get the phone number 
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
//            Toast.makeText(context, "Call from:" +incomingNumber, Toast.LENGTH_LONG).show();
            String filepath = Environment.getExternalStorageDirectory().getPath();
            File file = new File(filepath, incomingNumber);
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(context, "Call from:" +incomingNumber+" File Exixtx : "+file.exists(), Toast.LENGTH_LONG).show();
//
//            String filepath = Environment.getExternalStorageDirectory().getPath();
//
//
//            File file = new File(filepath, AUDIO_RECORDER_FOLDER);
//            if (!file.exists()) {
//                file.mkdirs();
//                File f1 = new File("/storage/sdcard1/" + System.currentTimeMillis());
//                try {
//                    f1.createNewFile();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                Toast.makeText(context, "Detected call hangup event "+file.getAbsolutePath()+" File Exists : "+f1.exists(), Toast.LENGTH_LONG).show();
//            }
             
        } else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(
                TelephonyManager.EXTRA_STATE_IDLE)
                || intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(
                        TelephonyManager.EXTRA_STATE_OFFHOOK)) {
            // This code will execute when the call is disconnected
//            Toast.makeText(context, "Detected call hangup event", Toast.LENGTH_LONG).show();

            String filepath = Environment.getExternalStorageDirectory().getPath();


            File file = new File(filepath, "hi");
            if (!file.exists()) {
                Toast.makeText(context, "inside if", Toast.LENGTH_LONG).show();
                file.mkdirs();
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                Toast.makeText(context, "inside else", Toast.LENGTH_LONG).show();
            }

            Toast.makeText(context, "Detected call hangup event : "+filepath+" File exists : "+file.exists(), Toast.LENGTH_LONG).show();
//            File file = new File(filepath, AUDIO_RECORDER_FOLDER);
//            if (!file.exists()) {
//                file.mkdirs();
//            }
//
//            File f1 = new File("/storage/sdcard1/" + System.currentTimeMillis());
//            System.out.println("File Exists : "+f1.exists());
//            try {
//                f1.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Toast.makeText(context, "Detected call hangup event "+file.getAbsolutePath()+" File Exists : "+f1.exists(), Toast.LENGTH_LONG).show();
        }
	}

}
