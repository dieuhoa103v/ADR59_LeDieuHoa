package vn.devpro.viewgroup.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.devpro.viewgroup.R;
import vn.devpro.viewgroup.models.User;

public class UserAdapter extends BaseAdapter {

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        ImageView avatar;
        TextView tvName;
        TextView tvEmail;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(parent.getContext(), R.layout.user_item, null);
            holder = new ViewHolder();
            holder.avatar = view.findViewById(R.id.avatar);
            holder.tvName = view.findViewById(R.id.tvName);
            holder.tvEmail = view.findViewById(R.id.tvEmail);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        User user = users.get(position);
        holder.avatar.setImageResource(user.getAvatar());
        holder.tvName.setText(user.getName());
        holder.tvEmail.setText(user.getEmail());

//        if (user.isSelected()) {
//
//        }

        return view;
    }

}
