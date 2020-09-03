package com.example.gadsleaderboard.UI.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.gadsleaderboard.R;
import com.google.android.material.appbar.AppBarLayout;

import java.util.Objects;

public class SubmitActivity extends AppCompatActivity {
    ImageButton imageButton;
    Button orange_btn;
    Dialog dialog;
    Dialog success,notSuccess;
    EditText email_et,link_et,firstName_et,secName_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
imageButton=findViewById(R.id.arrow);
orange_btn=findViewById(R.id.orange_submit_btn);
email_et=findViewById(R.id.email_et);
link_et=findViewById(R.id.githubLink_et);

firstName_et=findViewById(R.id.firstname_et);
secName_et=findViewById(R.id.secname_et);
        dialog=new Dialog(this);
        success=new Dialog(this);
        notSuccess=new Dialog(this);
        notSuccess.setContentView(R.layout.notsuccess_dialog);
        success.setContentView(R.layout.success_dialog);
        imageButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(SubmitActivity.this,LeaderBoardActivity.class);
        startActivity(intent);
    }
});
        orange_btn.setOnClickListener(new View.OnClickListener() {
    @Override
             public void onClick(View view) {

        if(email_et.getText().toString().equals(""))
            Toast.makeText(SubmitActivity.this, "Please, Enter your email address", Toast.LENGTH_LONG).show();
      else if(firstName_et.getText().toString().equals(""))
            Toast.makeText(SubmitActivity.this, "Please, Enter your name", Toast.LENGTH_LONG).show();
       else if(secName_et.getText().toString().equals(""))
            Toast.makeText(SubmitActivity.this, "Please, Enter your second name", Toast.LENGTH_LONG).show();
        else if(link_et.getText().toString().equals(""))
            Toast.makeText(SubmitActivity.this, "Please, Enter your project link", Toast.LENGTH_LONG).show();

        else{
        dialog.setContentView(R.layout.sure_dialog);
        ImageButton cancel=dialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        Button yes_btn=dialog.findViewById(R.id.yes_btn);
        yes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });
        dialog.show();
        }

    }
        });

    }

    private void submit() {
        Submit_ViewModel submit_viewModel=new ViewModelProvider(this).get(Submit_ViewModel.class);
        submit_viewModel.getResponse(firstName_et.getText().toString().trim(),secName_et.getText().toString().trim(),
                email_et.getText().toString().trim(),link_et.getText().toString().trim());
        submit_viewModel.submit_livedata.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                dialog.dismiss();
                if(aBoolean){

                    success.show();
                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            success.dismiss();

                        }
                    },2000);
                }
                else
                {
                    notSuccess.show();
                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            notSuccess.dismiss();
                        }
                    },2000);

                }


            }
        });




    }


}