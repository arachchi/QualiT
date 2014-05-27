package com.example.qualit;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.support.v4.app.NavUtils;
import android.app.Dialog;
import android.app.DialogFragment;


	public class DialogFrag extends DialogFragment {
		onSubmitListener mListener;
		EditText mEditText;
		
		interface onSubmitListener {
			void setOnSubmitListener(String arg);
		}
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
				final Dialog dialog= new Dialog(getActivity());
				dialog.setContentView(R.layout.activity_set);
			
				dialog.show();
				
				return dialog;
		}

		/**
		 * Set up the {@link android.app.ActionBar}.
		 */

	}
