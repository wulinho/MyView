package wulinhao.bwie.com.clock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.click);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SimpleDateFormat sDateFormat    =   new    SimpleDateFormat("yyyy-MM-dd    hh:mm:ss");
                String    date    =    sDateFormat.format(new    java.util.Date());
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("time",date);
                startActivity(intent);

            }
        });
    }
}
