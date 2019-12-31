
import java.util.concurrent.ConcurrentHashMap;

public class database {

    int qubit_counter;
    int ent_counter;
    private ConcurrentHashMap<Integer,Qubit> qubits;
    private ConcurrentHashMap<Integer,Qubit[]> entanglments;

    public database(){
        this.qubits=new ConcurrentHashMap<Integer,Qubit>();
        this.entanglments=new ConcurrentHashMap<Integer,Qubit[]>();
        this.qubit_counter=0;
        this.ent_counter=0;

        startEraser();
        startTeleporter();
    }
    public void startEraser(){
        Runnable r1=() -> {
            while(true){
                for (Integer key : qubits.keySet()) {
                    long current_time=System.currentTimeMillis()/1000;
                    if(current_time-qubits.get(key).timestamp_in_seconds>10){
                        qubits.get(key).collapse();
                    }
                }
            }
        };

        Thread Eraser=new Thread(r1);
        Eraser.start();

    }

    public void startTeleporter(){

        Runnable r2=() -> {
            while(true){
                for (Integer key : entanglments.keySet()) {
                    long current_time=System.currentTimeMillis()/1000;
                    if(current_time-entanglments.get(key)[0].timestamp_in_seconds>8  ||
                            current_time-entanglments.get(key)[1].timestamp_in_seconds>8){
                        Qubit q1_copy=new Qubit(entanglments.get(key)[0].data,entanglments.get(key)[0].type);
                        Qubit q2_copy=new Qubit(entanglments.get(key)[1].data,entanglments.get(key)[1].type);
                        addQubit(q1_copy);
                        addQubit(q2_copy);
                        addEnt(q1_copy,q2_copy);
                        entanglments.get(key)[0].collapse();
                        entanglments.get(key)[1].collapse();
                        entanglments.remove(key);

                    }
                }
            }
        };

        Thread Teleporter=new Thread(r2);
        Teleporter.start();
    }

    public void addQubit(Qubit q){
        qubits.put(qubit_counter++,q);
    }

    public void addEnt(Qubit q1,Qubit q2){
        Qubit[] arr=new Qubit[2];
        arr[0]=q1;
        arr[1]=q2;
        entanglments.put(ent_counter++,arr);
        q1.entanglment_id=ent_counter;
        q1.entangled=q2;
        q2.entanglment_id=ent_counter;
        q2.entangled=q1;

    }

    public void print(){
        for (Integer key : qubits.keySet()) {
            System.out.println("Qubit no."+key + " data: " + qubits.get(key).data);
        }
        System.out.println();
       for (Integer key : entanglments.keySet()) {
           System.out.println("entnglment id:"+key + " <" + entanglments.get(key)[0].data+ " ," + entanglments.get(key)[1].data+">");
        }
        System.out.println("----------------------");
    }
}
