package com.example.a20190530_chandragudimetla_nycschools.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a20190530_chandragudimetla_nycschools.BR;
import com.example.a20190530_chandragudimetla_nycschools.data.School;
import com.example.a20190530_chandragudimetla_nycschools.databinding.SchoolRowBinding;

import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder> {

    private List<School> schools;
    private ListFragment.ItemClickListener clickListener;

    public SchoolAdapter(ListFragment.ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public SchoolViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        SchoolRowBinding view = SchoolRowBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new SchoolViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolViewHolder holder, int i) {
        School school = schools.get(i);
        holder.bind(school);
    }

    @Override
    public int getItemCount() {
        return schools == null ? 0 : schools.size();
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
        notifyDataSetChanged();
    }

    class SchoolViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private SchoolRowBinding binding;

        public SchoolViewHolder(@NonNull SchoolRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(this);
        }

        private void bind(School school) {
            binding.setVariable(BR.school, school);
            binding.executePendingBindings();
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition());
        }
    }
}

