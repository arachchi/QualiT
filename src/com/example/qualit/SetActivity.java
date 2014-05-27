package com.example.qualit;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SetActivity extends Activity {
	private final String phoneNumber="0789712771";
	private RadioGroup cupGroup;
	private RadioButton radioButton;
	private int value=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set);
		
		final Dialog dialog= new Dialog(SetActivity.this);
		dialog.setTitle("Welcome To QualiT");
		dialog.setContentView(R.layout.greeting);
	
		dialog.show();
		Handler handler = new Handler();
	    handler.postDelayed(new Runnable() {
	        public void run() {
	        	dialog.dismiss(); 
	            
	        }
	    }, 5000);
	    
		
		cupGroup=(RadioGroup)findViewById(R.id.radioGp);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.set, menu);
		return true;
	}

	public void confirm(View view){
			int selectedId=0;	
			selectedId= cupGroup.getCheckedRadioButtonId();
			 radioButton = (RadioButton) findViewById(selectedId);
			 switch(selectedId){
			 	case R.id.radioButton1:
			 		value=1;
			 		break;
			 	case R.id.radioButton2:
			 		value=2;
			 		break;
			 	case R.id.radioButton3:
			 		value=3;
			 		break;
			 	case R.id.radioButton4:
			 		value=4;
			 		break;
			 	case R.id.radioButton5:
					value=5;
					break;
				default:
					value=0;
					break;
			 }
			
			 if(value==0){
				 Toast.makeText(this, "Select the number of cups", Toast.LENGTH_SHORT);
			 }
			 else{
				Toast.makeText(this, "Sending Your Order ", Toast.LENGTH_SHORT).show();
				
				
				
		try {
			SmsManager.getDefault().sendTextMessage(phoneNumber, null, ""+value, null, null);
			} catch (Exception e) {
			AlertDialog.Builder alertDialogBuilder = new
			AlertDialog.Builder(this);
			AlertDialog dialog = alertDialogBuilder.create();


			dialog.setMessage(e.getMessage());


			dialog.show();
			}
		startActivity(new Intent(getApplicationContext(), Thank.class));
		SetActivity.this.finish();
		
			 }
	}
	public void exit(View view){
		SetActivity.this.finish();
	}
	public void configure(View view){
			
			
		final Dialog dialog= new Dialog(SetActivity.this);
		dialog.setTitle("Confirm Your Selection");
		dialog.setContentView(R.layout.confirm);
	
	
		dialog.show();
		
	}
	public void setValue(View view){
		
		
	}
	
	

}
