package indirimtakip.rt.com.indirimtakip.parser;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import indirimtakip.rt.com.indirimtakip.dto.FiyatBilgisiImpl;

/**
 * Created by Appledore on 03/10/2017.
 */

public class ParseErkek {

    private String url;
    private List<FiyatBilgisiImpl> fiyatBilgisiList = new ArrayList<>();

    public ParseErkek() {
        this.url = url;
    }

    // Description AsyncTask
    private class getInfos extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {
            try {

                // Connect to the web site
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select("div.tBody > ul > li.cell009");

                if (elements.size() > 0) {

                    for (int i = 0; i < elements.size(); i++) {
                        FiyatBilgisiImpl fiyatBilgisi = new FiyatBilgisiImpl();
                        fiyatBilgisi.set_markaWeb(url);
                        fiyatBilgisi.set_reqDate(new Date());
                        fiyatBilgisiList.add(fiyatBilgisi);
                    }
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
        }
    }
}
