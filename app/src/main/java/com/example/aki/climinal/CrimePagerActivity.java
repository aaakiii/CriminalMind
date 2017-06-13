package com.example.aki.climinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import java.util.List;
import java.util.UUID;

/**
 * Created by AKI on 2017-06-12.
 */

public class CrimePagerActivity extends AppCompatActivity {
    private List<Crime> mCrimes;
    private ViewPager mViewPager;
    private static final String EXTRA_ID = "com.example.aki.climinal.extra_id";

    public static Intent newIntent(Context context, UUID crimeId) {
        Intent intent = new Intent(context, CrimePagerActivity.class);
        intent.putExtra(EXTRA_ID, crimeId);
        return intent;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crime_pager);
        mCrimes = CrimeLab.get(this).getCrimes();
        mViewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fm = getSupportFragmentManager();
        //保持するページ数を決められるデフォルトは３ページ
        //mViewPager.setOffscreenPageLimit(10);
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Crime crime = mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getId());
            }
            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_ID);
        for(int i = 0; i < mCrimes.size(); i++){
            if(mCrimes.get(i).getId().equals(crimeId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

}
