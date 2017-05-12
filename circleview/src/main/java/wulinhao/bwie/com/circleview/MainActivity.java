package wulinhao.bwie.com.circleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private RoundProgressBar roundProgressBar;
private  int progress = 0;
    private Button begin;
    private Button waiyuan;
    private Button button3;
    private Button button5;
    private Button buttonok;
    private Button RecyclerViews;
    private Button chekboxR;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
        roundProgressBar = (RoundProgressBar) findViewById(R.id.round);
        waiyuan = (Button) findViewById(R.id.button2);
        waiyuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
        Button button4= (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this,Main5Activity.class);
                startActivity(intent);
            }
        });
        RecyclerViews = (Button) findViewById(R.id.RecyclerViews);
        RecyclerViews.setOnClickListener(this);
        chekboxR = (Button) findViewById(R.id.chekboxR);
        chekboxR.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this,Main4Activity.class);
                startActivity(intent);
            }
        });
        buttonok = (Button) findViewById(R.id.buttonok);
        buttonok.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button5: //太极activity的监听
                Intent intent =new Intent(MainActivity.this,Main6Activity.class);
                startActivity(intent);
                break;
            case R.id.buttonok:
                Intent intent1=new Intent(MainActivity.this,Main7Activity.class);
                startActivity(intent1);
                break;
            case R.id.RecyclerViews:
                Intent intent2=new Intent(MainActivity.this,Main8Activity.class);
                startActivity(intent2);
                break;
            case R.id.chekboxR:
                startActivity(new Intent(MainActivity.this,Main10Activity.class));
                break;

            default:
                break;
        }
    }
}
