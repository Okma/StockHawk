package com.udacity.stockhawk.sync;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;

import timber.log.Timber;

public class QuoteJobService extends JobService {


    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Timber.d("Intent handled");
        Intent nowIntent = new Intent(getApplicationContext(), QuoteIntentService.class);
        nowIntent.setAction(QuoteIntentService.ACTION_REFRESH_ALL_QUOTES);
        getApplicationContext().startService(nowIntent);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }


}
