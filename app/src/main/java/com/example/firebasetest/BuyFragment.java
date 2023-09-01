package com.example.firebasetest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class BuyFragment extends Fragment {
    public BuyFragment() {
        // Required empty public constructor
    }
    private RecyclerView mRecyclerView;
    private BuyAdapter mAdapter;
    private FirebaseStorage mStorage;
    private DatabaseReference mDatabaseRef;
    private List<Upload_Sell> mUploads;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buy, container, false);

        mRecyclerView = view.findViewById(R.id.recycler_buy);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mUploads = new ArrayList<>();

        mAdapter = new BuyAdapter(getContext(), mUploads);

        mRecyclerView.setAdapter(mAdapter);

        mStorage = FirebaseStorage.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("sell");
        mDatabaseRef.addValueEventListener(new ValueEventListener()
                                           {
                                               @Override
                                               public void onDataChange(@NonNull DataSnapshot snapshot) {

                                                   mUploads.clear();

                                                   for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                                       Upload_Sell upload_sell = postSnapshot.getValue(Upload_Sell.class);
                                                       upload_sell.setKey(postSnapshot.getKey());
                                                       mUploads.add(upload_sell);
                                                   }
                                                   mAdapter.notifyDataSetChanged();

                                               }

                                               @Override
                                               public void onCancelled(@NonNull DatabaseError error) {
                                                   Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                                               }
                                           }
        );
        return view;
    }
}