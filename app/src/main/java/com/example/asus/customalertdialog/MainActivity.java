package com.example.asus.customalertdialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button registerButton,toolbarBackDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerButton = (Button)findViewById(R.id.register_dialog);
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog);
        toolbarBackDialog = (Button)dialog.findViewById(R.id.toolbarback_dialog);
        registerClick(dialog);
        dialogClose(dialog);
    }


    public void registerClick(final Dialog dialog){

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogShow(dialog);
            }
        });
    }
    public void dialogShow(Dialog dialog){

        dialog.setCanceledOnTouchOutside(false);//When  screen touch the alertdialog don't close
        dialog.setCancelable(false);//When back button touch the alertdialog don't close
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);

        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.BOTTOM;//Alert dialog will be bottom inside map

        dialog.getWindow().setAttributes(wlp);

        dialog.show();
    }

    public void  dialogClose(final  Dialog dialog){

        toolbarBackDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
