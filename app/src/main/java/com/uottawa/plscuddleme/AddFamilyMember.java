package com.uottawa.plscuddleme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * Created by Yuhan on 11/29/2017.
 */

public class AddFamilyMember extends AppCompatActivity implements View.OnClickListener {

    //database References
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private DatabaseReference databaseFamilyMembers;

    private EditText editTextNickName;
    private Spinner userRole;
    private Button buttonSave;
    private String emailFromRegister;

    /**
     * This function checks whether the current userContext is null. If so will return to signin activity
     * gets a reference of all the UI components in the add_family_member view
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_family_member);

        //get the registered Email and use it to set the familyMember Email in the firebase
        Bundle extras = getIntent().getExtras();
        emailFromRegister = extras.getString("RegisteredEmail");

        //if the usercontext is null, should prompt the user to sign in (or signup) and should finish the activity
        //user context is not usually null, but when there is a direct deletion of the user in the database
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, SignInActivity.class));
        }

        //if a user context exist, we get the UI references for the view for adding a family member
        databaseReference = FirebaseDatabase.getInstance().getReference();
        editTextNickName = (EditText) findViewById(R.id.userNickName);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        userRole = (Spinner) findViewById(R.id.memberRole);

        buttonSave.setOnClickListener(this);
    }

    /***
     * onClick method implemented specifically for the onClick of the buttonSave
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSave:
                buttonSave();
                break;
        }
    }


    /**
     * This function checks if the fields required to enter are filled
     * Prevents the function execution if fields not entered
     * Calls addMemberInDb that passes name, memberRole, and emailFromRegister
     * After added, calls function openDrawer()
     */
    public void buttonSave() {
        String name = editTextNickName.getText().toString().trim();
        String memberRole = userRole.getSelectedItem().toString();

        //if the user enters an empty name, the method will make a toast message and return to the addmember activity
        //aka nothing happens
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "Please enter a nick name", Toast.LENGTH_LONG).show();
            return;
        }

        addFamilyMemberInDb(name, emailFromRegister, memberRole);
        openDrawer();
    }

    /**
     *
     * @param name = name of the family member
     * @param email = email of the family member (from registration)
     * @param memberRole = role (Adult or child) that the family picks
     */
    private void addFamilyMemberInDb(String name, String email, String memberRole) {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseFamilyMembers = FirebaseDatabase.getInstance().getReference("familyMembers");

        //gets the current usercontext. As the userId has a UId associated with it at creation,
        //we set the memberId = user UID so in the future we can get the UID when we have take a snapshot
        // of the member object
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String id = user.getUid();
        Member member = new Member(id, email, name, memberRole, 0, 0);
        databaseFamilyMembers.child(user.getUid()).setValue(member);
        Toast.makeText(this, "Family Member Added", Toast.LENGTH_LONG).show();
        editTextNickName.setText("");
        finish();
    }

    /**
     * Function starts the next activity that greets the user
     */
    private void openDrawer() {
        //goes to the drawerActivity
        Intent gotoDrawer = new Intent(this, DrawerActivity.class);
        startActivity(gotoDrawer);
    }
}
