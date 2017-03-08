package com.example.android.coffee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText coffeePriceEt;
    private EditText coffeeNumEt;
    private TextView coffeePriceTv;
    private TextView totalPriceTv;
    private Button savePriceBtn;
    private Button addCoffeeBtn;
    private Button subCoffeeBtn;
    private Button showPriceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coffeePriceEt = (EditText) findViewById(R.id.et_coffee_price);
        coffeeNumEt = (EditText) findViewById(R.id.et_coffee_num);
        coffeePriceTv = (TextView) findViewById(R.id.tv_coffee_price);
        totalPriceTv = (TextView) findViewById(R.id.tv_total_price);
        savePriceBtn = (Button) findViewById(R.id.btn_save_coffee);
        addCoffeeBtn = (Button) findViewById(R.id.btn_add_coffee);
        subCoffeeBtn = (Button) findViewById(R.id.btn_sub_coffee);
        showPriceBtn = (Button) findViewById(R.id.btn_show_price);

        savePriceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePrice();
            }
        });

        addCoffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCoffee();
            }
        });
        subCoffeeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subCoffee();
            }
        });

        showPriceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPrice();
            }
        });

        coffeePriceEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                savePrice();
            }
        });
    }

    /**
     * 显示总价
     */
    private void showPrice() {
        String coffeePrice = coffeePriceEt.getText().toString();
        if (TextUtils.isEmpty(coffeePrice)) {
            coffeePriceTv.setText("您还没有输入咖啡的单价呢");
            return;
        }
        if(price==0){
            coffeePriceTv.setText("您还没有保存咖啡的单价呢");
        }
        price = Float.parseFloat(coffeePrice);
        if (num == 0) {
            totalPriceTv.setText("哦!您还没点咖啡呢");
        } else {
            float totalPrice = num * price;
            totalPriceTv.setText("您一共购买了" + num + "杯咖啡,需要付" + totalPrice + "元");
        }
    }

    /**
     * 减少咖啡的数量,因为订购咖啡不可能为负数,所以需要做判断
     */
    private void subCoffee() {
        if (num == 0) {
            totalPriceTv.setText("哦!不能在减少了,不然你就倒贴钱了");
        } else {
            num--;
        }
        coffeeNumEt.setText(String.valueOf(num));
    }

    /**
     * 添加咖啡的数量
     */
    private void addCoffee() {
        num++;
        coffeeNumEt.setText(String.valueOf(num));
    }

    private float price = 0f;
    private int num = 0;

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
        price = Float.parseFloat(coffeePrice);
    }
}
