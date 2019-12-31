public class sim {


    public static void main(String[] args){


        Qubit q1=new Qubit("a",0);
        Qubit q2=new Qubit("b",0);
        Qubit q3=new Qubit("c",0);
        Qubit q4=new Qubit("A",1);
        Qubit q5=new Qubit("B",1);
        Qubit q6=new Qubit("C",1);

        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        Qubit q7=new Qubit("X",0);
        Qubit q8=new Qubit("Y",0);
        Qubit q9=new Qubit("Z",0);




        database DB=new database();
        DB.addQubit(q1);DB.addQubit(q2);DB.addQubit(q3);DB.addQubit(q4);DB.addQubit(q5);DB.addQubit(q6);
        DB.addQubit(q7);DB.addQubit(q8);DB.addQubit(q9);
        DB.addEnt(q2,q3);DB.addEnt(q4,q1);DB.addEnt(q5,q6);DB.addEnt(q7,q8);

        for(int i=0;i<20;i++){
            DB.print();
            try
            {
                Thread.sleep(5000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }




/*
        long zero=System.currentTimeMillis()/1000;

        qubit q1=new qubit("aaa",0);

        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

       // System.out.println(q1.timestamp_in_seconds-zero);


        qubit q2=new qubit("111",1);

        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }




        qubit q3=new qubit("bbb",0);

        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }




        qubit q4=new qubit("222",0);

        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        */




    }
}

