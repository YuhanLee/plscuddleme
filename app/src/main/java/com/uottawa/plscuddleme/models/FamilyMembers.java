package com.uottawa.plscuddleme.models;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.uottawa.plscuddleme.adapters.FamilyMemberAdapter;
import com.uottawa.plscuddleme.R;

/**
 * Created by Yuhan on 11/19/2017.
 */

public class FamilyMembers extends Fragment {
    FamilyMemberAdapter adapter;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Family Members");

        displayAllMembers();
    }


    /**
     * This function reads all familyMembers from the database, and creates an array adapter containing all members
     */
    public void displayAllMembers() {
        DatabaseReference databaseFamilyMembers;
        databaseFamilyMembers = FirebaseDatabase.getInstance().getReference().child("familyMembers");
        databaseFamilyMembers.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int i = 0;
                // Create array of size = amount of familymembers in the datebase
                String[][] familyMemberList = new String[(int) dataSnapshot.getChildrenCount()][];
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Member member = snapshot.getValue(Member.class);
                    // Create an array
                    String[] itemPair = new String[2];
                    // Append family member name and user role
                    itemPair[0] = member.getfamilyMemberName();
                    itemPair[1] = member.getUserRole();
                    // append array to parent array
                    familyMemberList[i] = itemPair;
                    i = i + 1;

                }
                // Create custom array adapter with array of family members
                if (familyMemberList != null && familyMemberList.length > 0) {
                    ListView listView = (ListView) getView().findViewById(R.id.fam_listView);
                    adapter = new FamilyMemberAdapter(getContext(), familyMemberList);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nav_people, container, false);
    }
}
