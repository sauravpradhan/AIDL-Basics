package com.example.aidlactivity;

import com.saurav.aidl.IAdditionInterface;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MainActivity extends Activity {
	IAdditionInterface iadd;
	int  result;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ComponentName cn = new ComponentName("com.example.aidlservice", "com.example.aidlservice.AdditionService");
		Intent intent = new Intent();
		intent.setComponent(cn);
		bindService(intent, mconn, Context.BIND_AUTO_CREATE);
	}
	ServiceConnection mconn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			iadd = IAdditionInterface.Stub.asInterface((IBinder)service);
			Log.d("Saurav","onServiceConnected");
			try {
				result = iadd.add(10, 20);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.d("Saurav","Result of Addition is:"+result);
		}
	};
}
