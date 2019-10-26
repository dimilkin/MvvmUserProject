package com.test.mvvmuserproject.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.mvvmuserproject.R;
import com.test.mvvmuserproject.model.UserModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersListAdapter extends RecyclerView.Adapter <UsersListAdapter.UsersViewHolder> {

    private List<UserModel> users;

    public UsersListAdapter(List<UserModel> users) {
        this.users = users;
    }

    public void updateUsers (List<UserModel> newUsers){
        users.clear();
        users.addAll(newUsers);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {

        holder.bind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.userFirstName)
        TextView firstName;

        @BindView(R.id.userLastName)
        TextView lastName;

        @BindView(R.id.userGender)
        TextView userGender;

        @BindView(R.id.userEmail)
        TextView userEmail;

        @BindView(R.id.userPhone)
        TextView userPhone;

        @BindView(R.id.profileImage)
        ImageView profileImageView;


        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(UserModel user){

            userGender.setText(user.getGender());
            userEmail.setText(user.getEmail());
            userPhone.setText(user.getPhone());
            firstName.setText(user.getName().getFirstName());
            lastName.setText(user.getName().getLastName());
            Util.loadImage(profileImageView, user.getPicture().getLargePicture(), Util.getProgressDrawable(profileImageView.getContext()));

        }
    }
}
