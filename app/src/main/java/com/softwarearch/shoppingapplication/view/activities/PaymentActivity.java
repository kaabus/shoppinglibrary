package com.softwarearch.shoppingapplication.view.activities;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.softwarearch.shoppingapplication.R;

public class PaymentActivity extends AppCompatActivity {
    @BindView(R.id.rbtnCashOnDelivery)
    RadioButton rbtnCashOnDelivery;

    @BindView(R.id.rbtnVisaPayment)
    RadioButton rbtnVisaPayment;

    @BindView(R.id.card_textInput)
    TextInputEditText cardTextInput;

    @BindView(R.id.expire_textInput)
    TextInputEditText expireTextInput;

    @BindView(R.id.ccv_textInput)
    TextInputEditText ccvTextInput;

    @BindView(R.id.rl_card_payment)
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);
        rbtnCashOnDelivery.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    relativeLayout.setVisibility(View.INVISIBLE);
                } else {
                    relativeLayout.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @OnClick(R.id.btnMkPayment)
    public void onBtnMkPayment(View view){
        if (rbtnVisaPayment.isChecked()){
            if (cardTextInput.getText().toString().trim().length()==0){

                cardTextInput.setError("Please fill in these thinks");
                return;
            }

            if (ccvTextInput.getText().toString().trim().length()==0){

                ccvTextInput.setError("Please fill in these thinks");
                return;
            }
            if (expireTextInput.getText().toString().trim().length()==0){

                expireTextInput.setError("Please fill in these thinks");
                return;
            }

        }
    }
}
