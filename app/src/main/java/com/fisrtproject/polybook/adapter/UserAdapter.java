package com.fisrtproject.polybook.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fisrtproject.polybook.activity.HomeActivity;
import com.fisrtproject.polybook.activity.ListUser;
import com.fisrtproject.polybook.activity.UserActivity;
import com.fisrtproject.polybook.model.User;
import com.fisrtproject.polybook.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    public Context context;

    public UserAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    public List<User> users;

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item,viewGroup,false);

        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UserHolder userHolder, final int i) {
        userHolder.user = users.get(i);
        userHolder.tvHoTen.setText(userHolder.user.USER_FULL_NAME);
        userHolder.tvPhone.setText(userHolder.user.USER_PHONE);
        userHolder.btnDelUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeUser(i);
                Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(users == null)return 0;
        else
        return users.size();
    }

    public void removeUser(int position){
        users.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, users.size());
    }

    class UserHolder extends RecyclerView.ViewHolder {

        private Button btnDelUser;
        private User user;
        private TextView tvHoTen;
        private TextView tvPhone;
        public UserHolder(@NonNull final View itemView) {
            super(itemView);
            btnDelUser = itemView.findViewById(R.id.btnDelUser);
            tvHoTen = itemView.findViewById(R.id.tvHoTen);
            tvPhone = itemView.findViewById(R.id.tvPhone);

        }
    }


}
