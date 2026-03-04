import java.util.LinkedList;

public class chainedHash {
    private static class Entry {
        String key;
        String value;

        Entry(String k, String v) {
            key = k;
            value = v;

        }
    }

    private LinkedList<Entry>[] table;
    private int m;

    public chainedHash(int m){
        this.m = m;
        table = new LinkedList[m];
        for(int i = 0; i<m; i++){
            table[i] = new LinkedList<>();
        }
    }
        l
    private int hash(String key) {
        return Math.abs(key.hashCode()) % m;
    }

    public void insert (String key, String value) {
        int index = hash(key);

        LinkedList<Entry> list = table[index];
        for ( Entry e : list){
            if ( e.key.equals(key)){
                e.value = value;
                return;
            }
        }
        list.add(new Entry (key, value));
    }

    public String lookup (String key, String value) {
        int index = hash(key);
        for (Entry e : table[index]) {
            if (e.key.equals(key)) {
                return e.value;

            }
        }
        return null;
    }

}

