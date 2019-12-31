import java.util.concurrent.atomic.AtomicBoolean;

public class Qubit {

    public int id;
    public String data;
    public int type;
    public long timestamp_in_seconds;
    public Qubit entangled;
    public int entanglment_id;
    public AtomicBoolean collapsed;

    public Qubit(String data,int type){

        this.data=data;
        this.type=type;
        this.timestamp_in_seconds=System.currentTimeMillis()/1000;
        this.entangled=null;
        this.entanglment_id=-1;
        this.collapsed=new AtomicBoolean(false);
    }

    public void collapse(){
        collapsed.compareAndSet(false,true);
        data="collapsed";


    }
}
