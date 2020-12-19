package com.example.day4.adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day4.R;
import com.example.day4.bean.StudentBean;

import java.util.ArrayList;

public class StudentAdatper extends RecyclerView.Adapter<StudentAdatper.ViewHolder> {

    private Context context;
    private ArrayList<StudentBean.StudenlistBean> list;


    public StudentAdatper(Context context, ArrayList<StudentBean.StudenlistBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.student_rel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudentBean.StudenlistBean studenlistBean = list.get(position);
        holder.studentName.setText("姓名："+studenlistBean.getName());
        holder.studentSkill.setText("机试成绩："+studenlistBean.getSkill()+"分");
        holder.studentTheory.setText("理论成绩："+studenlistBean.getTheory()+"分");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView studentName;
        private TextView studentSkill;
        private TextView studentTheory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.student_name);
            studentSkill = itemView.findViewById(R.id.student_skill);
            studentTheory = itemView.findViewById(R.id.student_theory);
        }
    }
}
