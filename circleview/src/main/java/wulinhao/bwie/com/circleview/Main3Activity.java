package wulinhao.bwie.com.circleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private Neifangwaiyuan bbb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        bbb = (Neifangwaiyuan) findViewById(R.id.ccc);
        bbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main3Activity.this, "圆", Toast.LENGTH_SHORT).show();
            }
        });
        bbb.setOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main3Activity.this, "方", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
