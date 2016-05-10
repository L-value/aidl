package com.example.service_remote;





import com.example.inter.IUser;

import android.support.v7.app.ActionBarActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity
{
	IBinder inBinder;
	MyServiceConnection myServiceConnection;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		onBindService();
	}
	
	private void onBindService()
	{
		Intent intent = new Intent();
		intent.setAction("com.aidl.myservice");
		myServiceConnection = new MyServiceConnection();
		intent.setPackage("com.example.service_remote_server");
		this.bindService(intent, myServiceConnection, Context.BIND_AUTO_CREATE);
		
	}
	class MyServiceConnection implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service)
		{
			inBinder = service;
			IUser iUser = IUser.Stub.asInterface(service);
			try
			{
				System.out.println(iUser.getName()+"");
				System.out.println(iUser.getPassWord());
				iUser.setName("ÎÚË÷ÆÕ");
				System.out.println(iUser.getName());
				Toast.makeText(MainActivity.this, iUser.getName()+"", Toast.LENGTH_LONG).show();
			} catch (RemoteException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void onServiceDisconnected(ComponentName name)
		{
			
		}
		
	}

}
