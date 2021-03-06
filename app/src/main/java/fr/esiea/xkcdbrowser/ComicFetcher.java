package fr.esiea.xkcdbrowser;

import android.os.AsyncTask;

public class ComicFetcher extends AsyncTask<Object, Integer, Comic> {
    private static final String TAG = "ComicFetcher";
    private ComicFetcherInterface callerActivity;

    @Override
    protected Comic doInBackground(Object... params) {
        ComicBuilder builder = ComicBuilder.getInstance();
        Comic newComic = builder.buildComic((String) params[0]);
        callerActivity = (ComicFetcherInterface) params[1];
        return newComic;
    }

    @Override
    protected void onPostExecute(Comic result) {
        callerActivity.getComics().add(result);
        callerActivity.getComicAdapter().notifyDataSetChanged();
    }
}