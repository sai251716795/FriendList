package henry.com.friendlist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import henry.com.friendlist.bean.GroupItem;
import henry.com.friendlist.R;

/**
 * Date: 2016/10/25. 15:02
 * Creator: henry
 * Email: heneymark@gmail.com
 * Description:
 */
public class GroupItemAdapter extends RecyclerView.Adapter<GroupItemAdapter.ViewHolder> implements View.OnClickListener{

    private List<GroupItem> list;
    private OnRecyclerItemClickListener mOnItemClickListener;

    public GroupItemAdapter(List<GroupItem> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group, parent, false);
        view.setOnClickListener(this);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTitle.setText(list.get(position).getTitle());
        holder.mContent.setText(list.get(position).getContent());
        holder.itemView.setTag(position);
    }


    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    @Override
    public void onClick(View view) {
        //使用getTag方法获取数据
        if (mOnItemClickListener != null)
            mOnItemClickListener.onItemClick(view, list, (Integer) view.getTag());
    }

    /**
     * item点击事件
     *
     * @param listener
     */
    public void addOnItemClickListener(OnRecyclerItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitle;
        public TextView mContent;

        public ViewHolder(View view) {
            super(view);
            mTitle = (TextView) view.findViewById(R.id.title);
            mContent = (TextView) view.findViewById(R.id.content);
        }
    }

    public interface OnRecyclerItemClickListener {
        void onItemClick(View view, List data, int position);
    }
}
