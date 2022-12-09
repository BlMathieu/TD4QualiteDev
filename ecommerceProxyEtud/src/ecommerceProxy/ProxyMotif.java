package ecommerceProxy;

import jdk.jfr.TransitionTo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProxyMotif implements IMotif {
    private Motif realMotif;
    private static ArrayList<Motif> freqMotif = new ArrayList<>();
    private static ArrayList<Motif> nFreqMotif = new ArrayList<>();
    public ProxyMotif(Motif m){
        this.realMotif=m;
    }

    public boolean checkAccess(){
        if(realMotif==null){
            realMotif=new Motif();
        }
        return true;
    }

    public boolean verifCache(){
        if(freqMotif.contains(realMotif)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isFreq() {

        if(verifCache()){
            return true;
        }
        else if(realMotif.isFreq()){
            freqMotif.add(realMotif);
            return true;
        }
        else{
            nFreqMotif.add(realMotif);
            return false;
        }
    }
}