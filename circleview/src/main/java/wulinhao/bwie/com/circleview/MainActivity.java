package wulinhao.bwie.com.circleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private RoundProgressBar roundProgressBar;
private  int progress = 0;
    private Button begin;
    private Button waiyuan;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roundProgressBar = (RoundProgressBar) findViewById(R.id.round);
        waiyuan = (Button) findViewById(R.id.button2);
        waiyuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
        begin = (Button) findViewById(R.id.button);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress = 0;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(progress<=100){
                          progress +=3;
                            roundProgressBar.setProgress(progress);

                            try {
                                Thread.sleep(100);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();

            }
        });
    }
}
