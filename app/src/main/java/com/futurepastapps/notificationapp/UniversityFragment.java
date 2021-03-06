package com.futurepastapps.notificationapp;

import android.content.Context;
import android.net.Uri;
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


public class UniversityFragment extends Fragment {

    private EmptyRecyclerView universityView;

    private View mainView, emptyView;
    private RelativeLayout mainLayout;

    private DatabaseReference universityRef;

    public UniversityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mainView = inflater.inflate(R.layout.fragment_university, container, false);

        mainLayout = mainView.findViewById(R.id.universityMainLayout);

        universityView = mainLayout.findViewById(R.id.universityView);
        universityView.setLayoutManager(new LinearLayoutManager(getContext()));

        emptyView = mainLayout.findViewById(R.id.universityLayout);

        universityView.setEmptyView(emptyView);
        universityView.setHasFixedSize(true);

        universityRef = FirebaseDatabase.getInstance().getReference();

        return mainView;
    }

    @Override
    public void onStart() {
        super.onStart();

        setLayout();
    }

    private void setLayout() {

        FirebaseRecyclerOptions<University> universityRecyclerOptions = new FirebaseRecyclerOptions.Builder<University>().setQuery(universityRef, University.class).build();

        final FirebaseRecyclerAdapter<University, UniversityViewHolder> universityRecyclerAdapter = new FirebaseRecyclerAdapter<University, UniversityViewHolder>(
                universityRecyclerOptions
        ) {
            @NonNull
            @Override
            public UniversityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            protected void onBindViewHolder(@NonNull UniversityViewHolder holder, int position, @NonNull University model) {

            }

            @Override
            public void onDataChanged() {
                super.onDataChanged();
            }
        };

        universityRecyclerAdapter.notifyDataSetChanged();
        universityView.setAdapter(universityRecyclerAdapter);
    }

    public static class UniversityViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public UniversityViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
        }
    }

}
