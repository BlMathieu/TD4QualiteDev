package ecommerceProxy;

import java.util.ArrayList;

public class Motif {
    ArrayList<Article> listArticle;

    public Motif(){
         listArticle =new ArrayList<>();
    }

    public boolean isFreq(){
        if(freq()>=0.5){
            return true;
        }
        return false;
    }

    public void ajouteArticle(Article article){
        listArticle.add(article);
    }
    public void supprArticle(Article article){
        listArticle.remove(article);
    }

    private Float freq(Transaction transaction) {
        int compteur=0;
        if (match(transaction)) {
            for(int y=0;y<transaction.getListArticle().size();y++) {
                for (int i = 0; i < listArticle.size(); i++) {
                    if(listArticle.get(i) == transaction.getListArticle().get(y)){
                           compteur++;
                    }
                }
            }
            return  (((float) (compteur / transaction.getListArticle().size())));
        }
        return 0.0f;
    }

    private boolean match(Transaction t){
        for(int i=0;i<listArticle.size();i++){
            if(t.getListArticle().contains(listArticle.get(i))){
                return true;
            }
        }
        return false;
    }
}
