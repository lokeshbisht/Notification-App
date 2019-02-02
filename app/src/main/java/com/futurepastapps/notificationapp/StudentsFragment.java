package com.futurepastapps.notificationapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentsFragment extends Fragment {

    private EmptyRecyclerView studentsView;

    private View mainView, emptyView;
    private RelativeLayout mainLayout;

    private DatabaseReference studentsRef;

    public StudentsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mainView = inflater.inflate(R.layout.fragment_students, container, false);

        mainLayout = mainView.findViewById(R.id.studentsMainLayout);

        studentsView = mainLayout.findViewById(R.id.studentsView);
        studentsView.setLayoutManager(new LinearLayoutManager(getContext()));

        emptyView = mainLayout.findViewById(R.id.studentsLayout);

        studentsView.setEmptyView(emptyView);
        studentsView.setHasFixedSize(true);

        studentsRef = FirebaseDatabase.getInstance().getReference();

        return mainView;
    }

    @Override
    public void onStart() {
        super.onStart();

        setLayout();
    }

    private void setLayout() {

        FirebaseRecyclerOptions<Students> studentsRecyclerOptions = new FirebaseRecyclerOptions.Builder<Students>().setQuery(studentsRef, Students.class).build();

        final FirebaseRecyclerAdapter<Students, StudentsViewHolder> studentsRecyclerAdapter = new FirebaseRecyclerAdapter<Students, StudentsViewHolder>(
                studentsRecyclerOptions
        ){
            @NonNull
            @Override
            public StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            protected void onBindViewHolder(@NonNull StudentsViewHolder holder, int position, @NonNull Students model) {

            }

            @Override
            public void onDataChanged() {
                super.onDataChanged();
            }
        };

        studentsRecyclerAdapter.notifyDataSetChanged();
        studentsView.setAdapter(studentsRecyclerAdapter);
    }

    public static class StudentsViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public StudentsViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
        }
    }
}
