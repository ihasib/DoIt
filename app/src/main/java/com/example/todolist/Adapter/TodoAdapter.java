package com.example.todolist.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.MainActivity;
import com.example.todolist.Model.ToDoModel;
import com.example.todolist.R;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.MyViewHolder> {
    private List<ToDoModel> toDoModelList;
    private MainActivity activity;

    public TodoAdapter(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public  void setToDoModelList(List<ToDoModel> toDoModelList) {
        this.toDoModelList = toDoModelList;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_layout, parent, false);
        return  new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(toDoModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return toDoModelList.size();
    }

//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        ToDoModel item = toDoModelList.get(position);
//        holder.checkBox.setText(item.getTask());
//        holder.checkBox.setChecked(item.isStatus());
//    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;

        MyViewHolder(View view) {
            super(view);
            checkBox = view.findViewById(R.id.checkbox);
        }

        public void bind(ToDoModel task) {
            checkBox.setText(task.getTask());
            checkBox.setChecked(task.isStatus());
        }
    }

}
