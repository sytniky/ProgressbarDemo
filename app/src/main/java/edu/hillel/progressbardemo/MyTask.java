package edu.hillel.progressbardemo;

import android.app.Activity;
import android.os.AsyncTask;


/**
 * Created by yuriy on 27.07.16.
 */
public class MyTask extends AsyncTask<Integer, Integer, Integer> {

    private Activity mParent;

    public MyTask(Activity mParent) {
        this.mParent = mParent;
    }

    @Override
    protected Integer doInBackground(Integer... objects) {
        int i = 0;
        do {
            publishProgress(i);
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (i < objects[0]);
        return i;
    }

    @Override
    protected void onPostExecute(Integer progress) {
        showProgress(progress);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        showProgress(values[0]);
    }

    private void showProgress(Integer progress) {
        if (mParent instanceof MainActivity) {
            ((MainActivity) mParent).showProgress(progress);
        }
    }
}
