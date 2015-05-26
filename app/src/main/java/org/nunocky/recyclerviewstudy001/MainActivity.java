package org.nunocky.recyclerviewstudy001;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerview);
        SampleRecyclerAdapter adapter = new SampleRecyclerAdapter(this);
        rv.setAdapter(adapter);

        rv.setHasFixedSize(false);

        rv.setLayoutManager(new LinearLayoutManager(this));
        //rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        //rv.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        // MEMO: 標準のレイアウトマネージャーは以下のとおり
        //       * LinearLayoutManager
        //       * StaggeredGridLayoutManager
        //       * GridLayoutManager

        // MEMO: RecyclerViewに区切り線を付けたいときは ItemDecorationをセットする
        //       -> http://qiita.com/wasabeef_jp/items/6399432b899cb5613fb1
        rv.addItemDecoration(new DividerItemDecoration(this));

        rv.setItemAnimator(new DefaultItemAnimator());
    }
}
