package de.tewdreyer.android.touch2type;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class Touch2Type extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_touch_2_type);
		
		TextView tv = (TextView)findViewById(R.id.tv);
		if(tv == null){
			Toast.makeText(getApplicationContext(), "textView is null", Toast.LENGTH_LONG).show();
			return;
		}
		
		UsbManager manager = (UsbManager) getSystemService(Context.USB_SERVICE);
		if (manager == null) {
			tv.setText("manager is null");
			return;
		}
		
		HashMap<String, UsbDevice> h =  manager.getDeviceList();
		if (h == null) {
			tv.setText("hashmap is null");
			return;
		}
		
		String ds = "";
		for(String k  : h.keySet()) {
			ds += k + "\n";
		}
		
		UsbAccessory[] l = manager.getAccessoryList();
		if(l == null) {
			tv.setText("accessory list is null");
			return;
		}
		
		String as = "";
		for(UsbAccessory a : l) {
			as += a.toString() + "\n";
		}
		
		tv.setText("DEVICES:\n" + ds + "\nACCESSORIES:\n" + as);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.touch2_type, menu);
		return true;
	}

}
