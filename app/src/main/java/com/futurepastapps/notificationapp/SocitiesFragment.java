package com.futurepastapps.notificationapp;


import android.os.Bundle;
import android.provider.ContactsContract;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class SocitiesFragment extends Fragment {

    private EmptyRecyclerView societiesView;

    private View mainView, emptyView;
    private RelativeLayout mainLayout;


    private DatabaseReference societiesRef;

    public SocitiesFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mainView = inflater.inflate(R.layout.fragment_socities, container, false);

        mainLayout = mainView.findViewById(R.id.societiesMainLayout);

        societiesView = mainLayout.findViewById(R.id.societiesView);
        societiesView.setLayoutManager(new LinearLayoutManager(getContext()));

        emptyView = mainView.findViewById(R.id.societiesLayout);

        societiesView.setEmptyView(emptyView);
        societiesView.setHasFixedSize(true);

        societiesRef = FirebaseDatabase.getInstance().getReference();

        return mainView;
    }

    @Override
    public void onStart() {
        super.onStart();

        setLayout();
    }

    private void setLayout() {

        final FirebaseRecyclerAdapter<Societies, SocietiesViewHolder> societiesRecyclerView = new FirebaseRecyclerAdapter<Societies, SocietiesViewHolder>(
                Societies.class, R.layout.societies_layout, SocietiesViewHolder.class, societiesRef
        ) {
            @Override
            protected void populateViewHolder(SocietiesViewHolder viewHolder, Societies model, int position) {

            }

            @Override
            public void onDataChanged() {
                super.onDataChanged();
            }
        };
    }

    public static class SocietiesViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public SocietiesViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
        }
    }


}
