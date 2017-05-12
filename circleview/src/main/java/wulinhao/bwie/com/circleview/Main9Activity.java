package wulinhao.bwie.com.circleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import wulinhao.bwie.com.circleview.Adapters.ListAdapter;

public class Main9Activity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerview;
    private List<String> list;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        initView();//初始化控件
        initData();
        LinearLayoutManager manager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerview.setLayoutManager(manager);
        recyclerview.setHasFixedSize(true);
        adapter = new ListAdapter(list, this);
        recyclerview.setAdapter(adapter);
        //添加分割线
        recyclerview.addItemDecoration(new MyDecoration(this, MyDecoration.VERTICAL_LIST));
        adapter.setRecyclerViewOnItemClickListener(new ListAdapter.RecyclerViewOnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                //设置选中的项
                adapter.setSelectItem(position);
            }

            @Override
            public boolean onItemLongClickListener(View view, int position) {
                adapter.setShowBox();
                //设置选中的项
                adapter.setSelectItem(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void initData() {
//        File directory = Environment.getExternalStorageDirectory();
//        File[] files = directory.listFiles();
        String[] sw=new String[]{"a","b","c","d","e","f","g","h","i","g","k"};
        list = new ArrayList<>();
        for (int i = 0;i<sw.length;i++) {
            list.add(sw[i]);
        }
    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.list);
        findViewById(R.id.commit).setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //全选
            case R.id.all:
                Map<Integer, Boolean> map = adapter.getMap();
                for (int i = 0; i < map.size(); i++) {
                    map.put(i, true);
                    adapter.notifyDataSetChanged();
                }
                break;
            //全不选
            case R.id.no_all:
                Map<Integer, Boolean> m = adapter.getMap();
                for (int i = 0; i < m.size(); i++) {
                    m.put(i, false);
                    adapter.notifyDataSetChanged();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
        //获取你选中的item
        Map<Integer, Boolean> map = adapter.getMap();
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i)) {
                Log.d("TAG", "你选了第：" + i + "项");
            }
        }

    }
}
