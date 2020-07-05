package view.tanuja.cse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button count;    //obj creation for button class
    TextView tv;
    Button b;
    int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = findViewById(R.id.incre);
        b=findViewById(R.id.decrement);
        tv = findViewById(R.id.text_view);

        if(savedInstanceState!=null && savedInstanceState.containsKey("COUNT"))
        {
            c=savedInstanceState.getInt("COUNT");
            tv.setText(""+c);
        }

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c++;
                tv.setText(""+c);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c--;
                tv.setText(" "+c);
            }
        });

    }

    public void toast(View view) {

        Toast.makeText(MainActivity.this,"value is: "+c,Toast.LENGTH_SHORT).show();


    }
/* this method will save all the values that u have to say for the new activity that arrives after configuration change(orientation) of activity*/
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {   //Bundle is a datastructure to store values in form keys and values
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT",c);
    }
}
