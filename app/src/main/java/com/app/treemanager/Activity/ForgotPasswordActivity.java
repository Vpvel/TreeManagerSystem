package com.app.treemanager.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
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

public class ForgotPasswordActivity extends AppCompatActivity {

    /************************************************************************************
     * Class      : ForgotPasswordActivity
     * Created on : 09/03/2019
     * Updated on : 09/03/2019
     **************************************************************************************/



    private Unbinder viewUnBinder;
    private Intent intent;
    private Context context;
    @BindView(R.id.button_sendlink)
    Button button_sendlink;
    @BindView(R.id.email_input)
    EditText email_input;
    @BindView(R.id.lbottom)
    LinearLayout lbottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        viewUnBinder = ButterKnife.bind(this);
        context = ForgotPasswordActivity.this;
    }

    @OnClick(R.id.lbottom)
    public void btnHelpCenter(View view) {
        intent = new Intent(context,HelpActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.button_sendlink)
    public void btnSendlink(View view)
    {

        if(email_input.getText().toString().isEmpty()){
            ShowDialogError(getResources().getString(R.string.oops),getResources().getString(R.string.email_isEmpty));
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
