package ecommerceProxy;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Transaction {
    private ArrayList<Article> listArticle;

    public Transaction(){
        listArticle=new ArrayList<>();
    }

    public void add(Article article) {
        listArticle.add(article);
    }
    public ArrayList<Article> getListArticle(){
        return this.listArticle;
    }
}
