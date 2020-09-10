package mx.tec.example.example_3_itesm_ad2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {
    Intent i;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        textView=findViewById(R.id.textView);
        i = getIntent();
        String auxString;
        auxString = i.getStringExtra( "myParam");
        textView.setText(auxString);


    }
}