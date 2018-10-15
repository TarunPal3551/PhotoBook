package com.example.hp.instawar.Home;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.hp.instawar.GridImageAdapter;
import com.example.hp.instawar.R;
import com.example.hp.instawar.UploadAdapter;
import com.example.hp.instawar.modeldatabase.Album;
import com.example.hp.instawar.modeldatabase.Profile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Upload_review_activity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthlistener;
    private Context mContext;
    private static String userID;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mReference;
    private StorageReference mStorageReference;
    GridView review_grid_view;
    private static final String TAG = "Upload_review_activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_review_activity);

        review_grid_view = (GridView) findViewById(R.id.review_grid);
        mContext = Upload_review_activity.this;
        setupImageGrid();
        review_grid_view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                Query query = ref.child("album");
                query.removeEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                            Album album=new Album();




                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

//                query.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
//
//
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//                        Log.e(TAG, "onCancelled", databaseError.toException());
//                    }
//                });


                return false;
            }
        });


    }

    private void setupImageGrid() {
        final ArrayList<Album> albums= new ArrayList<>();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        Query query = reference.child("album").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                   albums.add(ds.getValue(Album.class));

                }
                int gridWidth = getResources().getDisplayMetrics().widthPixels;
                int imageWidth = gridWidth /4;
                review_grid_view.setColumnWidth(imageWidth);
                ArrayList<String> imgUrls = new ArrayList<String>();
                for (int i = 0; i < albums.size(); i++) {


                    imgUrls.add(albums.get(i).getImageUrl());


                }
                GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, "", imgUrls);
                review_grid_view.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
