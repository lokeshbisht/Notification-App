package com.futurepastapps.notificationapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PlacementsFragment extends Fragment {

    private EmptyRecyclerView placementsView;

    private View mainView, emptyView;
    private RelativeLayout mainLayout;

    private DatabaseReference placementsRef;

    public PlacementsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mainView =  inflater.inflate(R.layout.fragment_placements, container, false);

        mainLayout = mainView.findViewById(R.id.placementsMainLayout);

        placementsView = mainLayout.findViewById(R.id.placementsView);
        placementsView.setLayoutManager(new LinearLayoutManager(getContext()));

        emptyView = mainLayout.findViewById(R.id.placementsLayout);
        placementsView.setEmptyView(emptyView);

        placementsView.setHasFixedSize(true);

        placementsRef = FirebaseDatabase.getInstance().getReference();


        return mainView;
    }

    @Override
    public void onStart() {
        super.onStart();

        setLayout();
    }

    private void setLayout() {

        final FirebaseRecyclerAdapter<Placements, PlacementsViewHolder> placementsRecyclerView = new FirebaseRecyclerAdapter<Placements, PlacementsViewHolder>(
                Placements.class, R.layout.placements_layout, PlacementsViewHolder.class, placementsRef) {

            @Override
            protected void populateViewHolder(final PlacementsViewHolder viewHolder, final Placements model, int position) {

                //final String bookName = getRef(position).getKey();
            }

            @Override
            public void onDataChanged() {
                super.onDataChanged();
            }
        };

            placementsRecyclerView.notifyDataSetChanged();
            placementsView.setAdapter(placementsRecyclerView);
        }

    public static class PlacementsViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public PlacementsViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }
    }
}




