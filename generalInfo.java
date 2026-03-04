import java.util.*;

public class general_info {
    static final int totalKey = 1 << 20;
    static final int repetitions = 30;

    public static void main(String[]args){
        List <String>keys = new ArrayList<>();
        for ( int i = 1; i <= totalKey; i++){
            keys.add(String.valueOf(i));
        }
        Collections.shuffle(keys);

        int[] percents = {75,80,85,90,95};

        System.out.println("           |N   | Open Hash(s) | Chained Hash(s)");
        for (int p : percents){
            int N = (totalKey*p)/100;
            int m = totalKey;

            double openAvg = 0;
            double chainedAvg = 0;

            for (int r =0;r<repetitions;r++){

                openHash open = new openHash(m);
                for ( int i =0;i<N;i++){
                    open.insert(keys.get(i), keys.get(i));
                }

                long start = System.currentTimeMillis();
                for ( int i =0;i<N;i++){
                    open.lookup(keys.get(i));
                }

                long end = System.currentTimeMillis();
                openAvg += (end - start)/1000.0;

                chainedHash chained = new chainedHash(m);
                for ( int i =0;i<N;i++){
                    chained.insert(keys.get(i), keys.get(i));
                }
                start = System.currentTimeMillis();
                for ( int i =0;i<N;i++){
                    chained.lookup(keys.get(i));
                }

                end = System.currentTimeMillis();
                chainedAvg += (end - start)/1000.0;
            }
            openAvg /= repetitions;
            chainedAvg /= repetitions;

            System.out.printf("    %d%%     |   %d   |      %.4f     |      %4f\n", p, N, openAvg, chainedAvg);

        }
    }
}
