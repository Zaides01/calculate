package com.example.calculate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText numbers;
    Button plus, minus, multy, divide, rezult;
    double a, b, c;
    char znak;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(MainActivity.this, AboutActivity.class);
        numbers = findViewById(R.id.numbers);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multy = findViewById(R.id.multy);
        divide = findViewById(R.id.divide);
        rezult = findViewById(R.id.rezult);

        rezult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numA = numbers.getText().toString();
                if(numA.equals("") || numA == null)
                    b = 0;
                else
                    b = Double.parseDouble(numA);
                numbers.setText("");
                switch (znak){
                    case '+':
                        c = a + b; break;
                    case '-':
                        c = a - b; break;
                    case '*':
                        c = a * b; break;
                    case '/':
                        if(b != 0)
                        c = a / b; break;
                    default: c = 0;
                }
                numbers.setText(Double.valueOf(c).toString());
            }
        });
    }

    public void firstNum(View button){
        String numA = numbers.getText().toString();
        if(numA.equals("") || numA == null)
            a = 0;
        else
            a = Double.parseDouble(numA);
        numbers.setText("");
        switch (button.getId()){
            case R.id.plus:
                znak = '+'; break;
            case R.id.minus:
                znak = '-'; break;
            case R.id.multy:
                znak = '*'; break;
            case R.id.divide:
                znak = '/';
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.about_item: startActivity(intent); break;
            case R.id.close_item: onDestroy(); break;
        }
        return true;

    }
}