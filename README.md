# 订购咖啡应用
##需求
1.	可以设置每杯咖啡的价格
2.	根据用户输入的数字,计算出用户需要付的金钱

##分析
1.	功能修改每杯咖啡的价格
	>提供一个输入框,输入咖啡的价格
2.	功能选择要几杯咖啡
	>提供一个输入框,输入咖啡的数量
3.	功能显示咖啡的总额
	>提供一个按钮,和一个文本框,显示总额


##实现
1.	打开Android Studio

	![打开开发工具](http://www.studyjamscn.com/forum.php?mod=image&aid=34239&size=300x300&key=29c85a111b772b99&nocache=yes&type=fixnone)
2.	创建项目

	1.	选择`Start a new Android Studio project`
	
		![填写相应的信息](http://www.studyjamscn.com/forum.php?mod=image&aid=34242&size=300x300&key=f13d103709fdbc05&nocache=yes&type=fixnone)
	2.	填写相关信息
	3.	![](http://www.studyjamscn.com/forum.php?mod=image&aid=34243&size=300x300&key=f90fd681e71dd4f7&nocache=yes&type=fixnone)
	4.	![](http://www.studyjamscn.com/forum.php?mod=image&aid=34244&size=300x300&key=95cfdb7e8205ddd8&nocache=yes&type=fixnone)
	5.	选择Empty Activity
	6.	![](http://www.studyjamscn.com/forum.php?mod=image&aid=34245&size=300x300&key=24bef291fb1ec01b&nocache=yes&type=fixnone)
	7.	这里不做任何的修改
	8.	到这里新的项目就创建完成了

3.	先画界面
	>打开activity_main.xml
	
	1.	首先实现修改咖啡价格的功能
	
			<?xml version="1.0" encoding="utf-8"?>
			<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
			    xmlns:tools="http://schemas.android.com/tools"
			    android:layout_width="match_parent"
			    android:layout_height="match_parent"
			    android:orientation="vertical"
			    tools:context="com.example.android.coffee.MainActivity">
			    <EditText
			        android:id="@+id/et_coffee_price"
			        android:layout_width="match_parent"
			        android:layout_height="wrap_content"
			        android:hint="@string/please_input_coffee_price"
			        android:inputType="numberDecimal" />
			    <TextView
			        android:id="@+id/tv_coffee_price"
			        android:layout_width="match_parent"
			        android:layout_height="wrap_content"
			        android:visibility="invisible" />		
			    <Button
			        android:id="@+id/btn_save_coffee"
			        android:text="@string/btn_save_coffee"
			        android:layout_width="match_parent"
			        android:layout_height="wrap_content" />
			</LinearLayout>

	2.	我们在xml里为三个控件设置id属性,以便我们在MainActivity里面获取
	3.	可以通过findViewById在MainActivity里获取
		
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
		通过以上的代码可以实现,输入价格,点击按钮显示价格

		可以发现,在输入的时候输入框只接受数字类型,这是我们给EditText加入了`input_type`属性

		![](http://www.studyjamscn.com/forum.php?mod=image&aid=34246&size=300x300&key=4785bc90c018f54e&nocache=yes&type=fixnone)
