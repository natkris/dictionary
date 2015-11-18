package dictionary;

import java.util.Map;

public class mapDictionary<K,V> implements dictionary<K, V> {

    private Map<K,V> m;
    private int size;
    
    //22.10.2015 tue ich erst mit treemap
    
    public mapDictionary(Map<K,V> m) { 
        
        this.m = m;
        
    }
    
	@Override
	public V insert(K key, V value) {
               size++;
               return m.put(key, value);
	}

	@Override
	public V search(K key) {

            return m.get(key);
	}

	@Override
	public V remove(K key) {
            size--;
            return m.remove(key);
	}

	@Override
	public int size() {
		
		return size;
	}
        
    @Override
        public String toString(){
            
        StringBuilder sb = new StringBuilder();
        sb.append("MapDicti: \n");
        for(Map.Entry<K,V> mp : m.entrySet()){
                sb.append(mp.getKey() + " -> " + mp.getValue() + "\n");
        }
            return sb.toString();
            
        }

}
