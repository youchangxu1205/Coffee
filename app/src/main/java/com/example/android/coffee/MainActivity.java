package com.example.android.coffee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText coffeePriceEt;
    private TextView coffeePriceTv;
    private Button savePriceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coffeePriceEt = (EditText) findViewById(R.id.et_coffee_price);
        coffeePriceTv = (TextView) findViewById(R.id.tv_coffee_price);
        savePriceBtn = (Button) findViewById(R.id.btn_save_coffee);

        savePriceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePrice();
            }
        });
    }

    /**
     * 保存输入的咖啡单价,并显示在TextView上
     */
    private void savePrice() {
        String coffeePrice = coffeePriceEt.getText().toString();

        if (TextUtils.isEmpty(coffeePrice)) {
            coffeePriceTv.setText("您还没有输入咖啡的单价呢");
        } else {
            coffeePriceTv.setText("当前咖啡价格为" + coffeePrice + "元/杯");
        }
    }
}
