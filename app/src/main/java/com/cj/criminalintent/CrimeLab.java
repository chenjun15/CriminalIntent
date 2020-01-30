package com.cj.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private ArrayList<Crime> mCrimes;
    private HashMap<UUID, Integer> mMapIndex;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null)
            sCrimeLab = new CrimeLab(context);
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        mMapIndex = new HashMap<>();
        for (int i = 0; i < 100; ++i) {
            Crime crime = new Crime();
            crime.setIndex(i);
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            mCrimes.add(crime);
            mMapIndex.put(crime.getId(), i);
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        if (!mMapIndex.containsKey(id))
            return null;
        return mCrimes.get(mMapIndex.get(id));
    }
}
