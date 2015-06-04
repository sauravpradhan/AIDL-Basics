package com.example.aidlservice;

import com.saurav.aidl.IAdditionInterface;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AdditionService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return new IAdditionInterface.Stub() {
			
			@Override
			public int add(int value1, int value2) throws RemoteException {
				// TODO Auto-generated method stub
				return (value1+value2);
			}
		};
	}

}
