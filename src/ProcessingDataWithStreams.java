import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ProcessingDataWithStreams {

    public static void main(String args[]){

        new ProcessingDataWithStreams().processStreams();

    }

void processStreams(){

    List<Transaction> transactionList = new ArrayList<Transaction>();
    Transaction t1 = new Transaction(1001,TRANSACTIONTYPE.GROCERY,1000.0);
    Transaction t2 = new Transaction(1002,TRANSACTIONTYPE.ELECTRONICS,2000.0);
    Transaction t3 = new Transaction(1003,TRANSACTIONTYPE.GROCERY,4000.0);
    Transaction t4 = new Transaction(1004,TRANSACTIONTYPE.GROCERY,3000.0);

    transactionList.add(t1);
    transactionList.add(t2);
    transactionList.add(t3);
    transactionList.add(t4);


    List<Integer> transactionIds = transactionList.parallelStream().filter(t-> t1.getType()==TRANSACTIONTYPE.GROCERY)
            .sorted(Comparator.comparing(Transaction::getValue).reversed()).map(Transaction::getId).collect(Collectors.toList());

    transactionIds.forEach(new Consumer<Integer>() {
        @Override
        public void accept(Integer id) {
            System.out.println(id);
        }
    });


    }

}

    enum TRANSACTIONTYPE { GROCERY,ELECTRONICS};

    class Transaction {

        int Id;
        double value;
        TRANSACTIONTYPE type;

        Transaction(int Id, TRANSACTIONTYPE type, double value){
            this.Id = Id;
         this.type=type;
         this.value=value;
        }

        void setId(int Id){
            this.Id =Id;
        }

        int getId(){
            return Id;
        }

        double getValue(){
            return value;
        }

        void setValue(double value){
            this.value=value;
        }

        TRANSACTIONTYPE getType(){
            return type;
        }

        void setType(TRANSACTIONTYPE type){
            this.type= type;
        }

    }

