package henry.com.friendlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import henry.com.friendlist.adapter.GroupAdapter;
import henry.com.friendlist.bean.Group;
import henry.com.friendlist.bean.GroupItem;

public class MainActivity extends AppCompatActivity {
    RecyclerView rl_friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl_friend = (RecyclerView)findViewById(R.id.rv_friend);

        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        //显示底部位置
        mLayoutManager.setStackFromEnd(true);
        rl_friend.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rl_friend.setHasFixedSize(true);
        rl_friend.addItemDecoration(new DividerItemDecoration( this, DividerItemDecoration.HORIZONTAL_LIST));

        List<Group> groups = new ArrayList<>();

        for (int i=0;i<3;i++){
            List<GroupItem>groupItems = new ArrayList<>();
            for (int j=0;j<5;j++){
                GroupItem item = new GroupItem("tille"+j,"content"+j);
                groupItems.add(item);
            }

            Group group = new Group("name"+i,groupItems);
            groups.add(group);
        }

        GroupAdapter groupItemAdapter = new GroupAdapter(this,groups);
        rl_friend.setAdapter(groupItemAdapter);

    }
}
