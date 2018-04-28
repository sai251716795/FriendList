package henry.com.friendlist.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import henry.com.friendlist.DividerItemDecoration;
import henry.com.friendlist.bean.Group;
import henry.com.friendlist.R;

/**
 * Date: 2016/10/25. 15:17
 * Creator: henry
 * Email: heneymark@gmail.com
 * Description:
 */
public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    private List<Group> list;
    private Context mContext;
    private boolean isShowGroupItem = false;

    public GroupAdapter(Context context, List<Group> list) {
        this.list = list;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_group, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mName.setText(list.get(position).getGroupName());
        holder.mCount.setText(list.get(position).getGroupItems().size() + "");

        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        //显示底部位置
        mLayoutManager.setStackFromEnd(true);
        holder.mGroup.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        holder.mGroup.setHasFixedSize(true);
        GroupItemAdapter groupItemAdapter = new GroupItemAdapter(list.get(position).getGroupItems());
        holder.mGroup.addItemDecoration(new DividerItemDecoration(
                mContext, DividerItemDecoration.HORIZONTAL_LIST));
        holder.mGroup.setAdapter(groupItemAdapter);

        holder.mGroup.setVisibility(View.GONE);
        holder.mImg.setImageResource(R.drawable.ic_right);
        isShowGroupItem = false;

        groupItemAdapter.addOnItemClickListener(new GroupItemAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, List data, int position) {
                Toast.makeText(mContext, "Item " + position + " Click！", Toast.LENGTH_LONG).show();
            }
        });


        //给分组添加Click事件
        holder.mGroupLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isShowGroupItem) {
                    holder.mGroup.setVisibility(View.VISIBLE);
                    holder.mImg.setImageResource(R.drawable.ic_down);
                    isShowGroupItem = true;
                } else {
                    holder.mGroup.setVisibility(View.GONE);
                    holder.mImg.setImageResource(R.drawable.ic_right);
                    isShowGroupItem = false;
                }
            }
        });

    }
    
    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mName;
        public TextView mCount;
        public RecyclerView mGroup;
        public RelativeLayout mGroupLayout;
        public ImageView mImg;

        public ViewHolder(View view) {
            super(view);
            mName = (TextView) view.findViewById(R.id.name);
            mCount = (TextView) view.findViewById(R.id.count);
            mGroup = (RecyclerView) view.findViewById(R.id.rl_group);
            mGroupLayout = (RelativeLayout) view.findViewById(R.id.group_layout);
            mImg = (ImageView) view.findViewById(R.id.image);
        }
    }
}
