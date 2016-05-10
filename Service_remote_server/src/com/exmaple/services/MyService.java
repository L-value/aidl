package com.exmaple.services;

import com.example.inter.IUser;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service
{
	private MyUser iUser;
	@Override
	public IBinder onBind(Intent intent)
	{
		iUser = new MyUser();
		return  iUser;
	}
	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		super.onCreate();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	class MyUser extends IUser.Stub{
		private String name = "ctt";

		@Override
		public String getName() throws RemoteException
		{
			
			return name;
		}

		@Override
		public String getPassWord() throws RemoteException
		{
			
			return "123456";
		}

		@Override
		public void setName(String name) throws RemoteException
		{
			this.name = name;
			
		}
		
	}

}
