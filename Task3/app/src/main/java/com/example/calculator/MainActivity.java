package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import javax.sql.StatementEvent;

public class MainActivity extends AppCompatActivity {
    double firstnum;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button num0=findViewById(R.id.num0);
        Button num1=findViewById(R.id.num1);
        Button num2=findViewById(R.id.num2);
        Button num3=findViewById(R.id.num3);
        Button num4=findViewById(R.id.num4);
        Button num5=findViewById(R.id.num5);
        Button num6=findViewById(R.id.num6);
        Button num7=findViewById(R.id.num7);
        Button num8=findViewById(R.id.num8);
        Button num9=findViewById(R.id.num9);

        Button on = findViewById(R.id.onbtn);
        Button off = findViewById(R.id.off);
        Button AC = findViewById(R.id.AC);
        Button del = findViewById(R.id.del);
        Button divide = findViewById(R.id.divide);
        Button multiply = findViewById(R.id.multiply);
        Button subtract = findViewById(R.id.sub);
        Button addition = findViewById(R.id.add);
        Button equals = findViewById(R.id.equals);
        Button period = findViewById(R.id.period);

        TextView screen = findViewById(R.id.screen);

        AC.setOnClickListener(view -> {
            firstnum = 0;
            screen.setText("0");
        });

        off.setOnClickListener(view -> screen.setVisibility(View.GONE));
        on.setOnClickListener(view -> {
            screen.setVisibility(View.VISIBLE);
            screen.setText("0");
        });

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);

        for (Button b : nums){
            b.setOnClickListener(View ->{
                if(!screen.getText().toString().equals("0")){
                    screen.setText(screen.getText().toString() + b.getText().toString());
                }else{
                    screen.setText(b.getText().toString());
                }
            });
        }

        ArrayList<Button> operators = new ArrayList<>();
        operators.add(divide);
        operators.add(multiply);
        operators.add(subtract);
        operators.add(addition);

        for (Button b : operators){
                b.setOnClickListener(view -> {
                    firstnum = Double.parseDouble(screen.getText().toString());
                    operation = b.getText().toString();
                    screen.setText("0");
                });
        }
        del.setOnClickListener(view -> {
            String num = screen.getText().toString();
            if(num.length()>1){
                screen.setText(num.substring(0, num.length()-1));
            }else if(num.length() == 1 && !num.equals("0")){
                screen.setText("0");
            }
        });

        period.setOnClickListener(view -> {
            if(!screen.getText().toString().contains(".")){
                screen.setText(screen.getText().toString() + ".");
            }
        });

        equals.setOnClickListener(view -> {
            double secondnum = Double.parseDouble(screen.getText().toString());
            double result;
            switch (operation){
                case "/":
                    result = firstnum/secondnum;
                    break;
                case "x":
                    result = firstnum*secondnum;
                    break;
                case "+":
                    result = firstnum+secondnum;
                    break;
                case "-":
                    result = firstnum-secondnum;
                    break;
                default:
                    result = firstnum+secondnum;
            }
            screen.setText(String.valueOf(result));
            firstnum = result;

        });
    }
}