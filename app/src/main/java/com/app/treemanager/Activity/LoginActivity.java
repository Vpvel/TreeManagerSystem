package com.app.treemanager.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.treemanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity {

    /************************************************************************************
     * Class      : LoginActivity
     * Created on : 09/03/2019
     * Updated on : 09/03/2019
     **************************************************************************************/

     private Unbinder viewUnBinder;
     private Intent intent;
     @BindView(R.id.forgotpassword_txt)
     TextView forgotpassword_txt;
     private Context context;
     @BindView(R.id.lbottom)
     LinearLayout lbottom;
     @BindView(R.id.button_signin)
     Button button_signin;
     @BindView(R.id.username_input)
     EditText username_input;
    @BindView(R.id.password_input)
     EditText password_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        viewUnBinder = ButterKnife.bind(this);
        context = LoginActivity.this;

    }


    @OnClick(R.id.forgotpassword_txt)
    public void btnForgotPassowrd(View view) {
        intent = new Intent(context, ForgotPasswordActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.lbottom)
    public void btnHelpCenter(View view) {
        intent = new Intent(context,HelpActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button_signin)
    public void btnSignIn(View view)
    {

        if(username_input.getText().toString().isEmpty()){
            ShowDialogError(getResources().getString(R.string.oops),getResources().getString(R.string.username_isEmpty));
        }else if (password_input.getText().toString().isEmpty()) {
            ShowDialogError(getResources().getString(R.string.oops),getResources().getString(R.string.password_hint));
        }
        else {
            intent = new Intent(context,DashBoardActivity.class);
            startActivity(intent);
        }


    }



    public void ShowDialogError(String Title,String Message){



        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.error_dialog_box, viewGroup, false);
        builder.setView(dialogView);
         final   AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alertDialog.show();

        ImageView imageView_help_center = (ImageView)dialogView.findViewById(R.id.imageView_help_center);

        TextView title_txt =(TextView)dialogView.findViewById(R.id.title_txt);
        TextView message_txt =(TextView)dialogView.findViewById(R.id.message_txt);

        title_txt.setText(Title);
        message_txt.setText(Message);


        imageView_help_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog.dismiss();
            }
        });

    }

}
