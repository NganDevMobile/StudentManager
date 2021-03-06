package com.example.assignment.News;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsActivity extends AppCompatActivity {
    ListView lv;

    EditText edtNhaplink;
    Button btnGo;


    ArrayList<ReadNews> readNewsList =new ArrayList<ReadNews>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("News");
        setContentView( R.layout.activity_news);
       lv = findViewById(R.id.lv);
      edtNhaplink = findViewById(R.id.edtNhapLink);
     btnGo = findViewById(R.id.btnGoUrl);

     btnGo.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             readNewsList.clear();
             String link = edtNhaplink.getText().toString();
             new ReadXml().execute(link);
         }
     });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(NewsActivity.this, webViewActivity.class);
                intent.putExtra("link", readNewsList.get(i).link);
                startActivity(intent);
            }
        });

    }

    public class ReadXml extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... strings) {
            String kq = getXMLFromURL(strings[0]);
            return kq;
        }
        @Override
        protected void onPostExecute(String s) {
//            Toast.makeText(MainActivity.this, ""+s, Toast.LENGTH_SHORT).show();
            //--------?????c XML----//
            XMLDOMParser parser = new XMLDOMParser();
            //----b??? Xml v??o bi???n doc---//
            Document doc = parser.getDocument(s);
            //---L???y nh???ng g?? c?? t??n l?? item trong bi???n doc---//
            NodeList nodeListDecription;
            NodeList nodeList;
            nodeList = doc.getElementsByTagName("item");
            nodeListDecription = doc.getElementsByTagName("description");//coppy t??n th??? trong RSS ????? b???o ?????m ????ng t??n
            //-----Duy???t item ????? l???y Title----//
            String title = "";
            String img = "";
            String link = "";
            for (int i=0; i <nodeList.getLength();i++){
                //i+1 v?? b??? 1 th???ng Deription trong Rss kh??ng ch???a img..
                String cData = nodeListDecription.item(i +1).getTextContent();
                //-----?????c url c???a img
                Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher matcher = p.matcher(cData);
                if (matcher.find()){ //n??y m???i ??c,  t l??m r??n c??i h?? m??? lun =))
                    img = matcher.group(1);
                    Log.d("Img---",img);
                }
                Element e = (Element) nodeList.item(i);
                //------T??m nh???ng g?? c???n show t??? elemen-----//
                title = title + parser.getValue(e,"title");
                link = parser.getValue(e,"link");
                //----Add v??o m???ng----//
                readNewsList.add(new ReadNews(title,link,img));
            }
            adapterLv(lv);
//            Toast.makeText(MainActivity.this, kq    , Toast.LENGTH_SHORT).show();
            super.onPostExecute(s);

        }

    }
    public void adapterLv(ListView listView){
        Adapter adapter = new Adapter(NewsActivity.this,android.R.layout.simple_list_item_1,readNewsList);
        listView.setAdapter(adapter);
    }


    private String getXMLFromURL(String theUrl){
        StringBuilder content = new StringBuilder();
        try    {
            // create a url object
            URL url = new URL(theUrl);
            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)    {
            e.printStackTrace();
        }
        return content.toString();
    }
}
