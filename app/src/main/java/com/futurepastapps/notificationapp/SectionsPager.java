package com.futurepastapps.notificationapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by HP on 27-01-2019.
 */

public class SectionsPager extends FragmentStatePagerAdapter {

    public SectionsPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 :
                SocitiesFragment socitiesFragment = new SocitiesFragment();
                return socitiesFragment;
            case 1 :
                UniversityFragment universityFragment = new UniversityFragment();
                return universityFragment;
            case 2 :
                PlacementsFragment placementsFragment = new PlacementsFragment();
                return placementsFragment;
            case 3 :
                StudentsFragment studentsFragment = new StudentsFragment();
                return studentsFragment;
            default :
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0 :
                return "Socities";
            case 1 :
                return "University";
            case 2 :
                return "Placements";
            case 3 :
                return "Students";
            default :
                return null;
        }
    }
}
