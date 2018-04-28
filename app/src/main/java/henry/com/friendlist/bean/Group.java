package henry.com.friendlist.bean;

import java.util.List;

/**
 * Date: 2016/10/25. 14:46
 * Creator: henry
 * Email: heneymark@gmail.com
 * Description:分组
 */
public class Group {
    //分组名称
    private String mGroupName;
    //分组项目
    private List<GroupItem> mGroupItems;

    public Group(String GroupName, List<GroupItem> GroupItems) {
        this.mGroupName = GroupName;
        this.mGroupItems = GroupItems;
    }

    public String getGroupName() {
        return mGroupName;
    }

    public void setGroupName(String mGroupName) {
        this.mGroupName = mGroupName;
    }

    public List<GroupItem> getGroupItems() {
        return mGroupItems;
    }

    public void setGroupItems(List<GroupItem> mItems) {
        this.mGroupItems = mItems;
    }

    @Override
    public String toString() {
        String string = "GroupName=" + mGroupName + ";GroupItem=" + mGroupItems.toString();
        return string;
    }
}
