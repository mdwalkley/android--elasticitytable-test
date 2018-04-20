package us.walkley.mw.elasticitytablefragmenttest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatImageButton editE = (AppCompatImageButton) findViewById(R.id.e_frag_button);
        editE.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // Show back button in Navigation Bar
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                //findViewById(R.id.constraintLayout_e).setVisibility(View.GONE);

                //getSupportFragmentManager().beginTransaction().replace(R.id.frag_frame, new EValueListFragment()).commit();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.frag_frame, new EValueListFragment());
                transaction.addToBackStack(null);
                transaction.commit();

                //Intent eValueIntent = new Intent(MainActivity.this, EFragActivity.class);
                //startActivity(eValueIntent);
            }
        });

    }

    //If 0 fragments do normal back, else do endFragment()
    @Override
    public void onBackPressed(){
        if(getFragmentManager().getBackStackEntryCount() == 0){
            super.onBackPressed();
        }else {endFragment();}
    }

    //Do endFragment() when Navigation Bar back button is pressed
    @Override
    public boolean onSupportNavigateUp(){
        endFragment();
        return true;
    }

    public void endFragment(){
        // Hide Navigation Bar back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        // Make fragment view go away
        findViewById(R.id.frag_frame).setVisibility(View.GONE);
        // Make activity view visible
        findViewById(R.id.constraintLayout_e).setVisibility(View.VISIBLE);
        getFragmentManager().popBackStack();
    }
}
