import java.util.*;

class RandomizedSet {
    HashMap<Integer,Integer> set;
    List<Integer> fastRetrieval;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashMap<>();
        fastRetrieval = new ArrayList<>();
        random = new Random(1234546788);
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!set.containsKey(val)){
            set.put(val,fastRetrieval.size());
            fastRetrieval.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.containsKey(val)){
            int temp = fastRetrieval.get(fastRetrieval.size()-1);
            int index = set.get(val);
            fastRetrieval.set(index,temp);

            set.put(temp,index);

            fastRetrieval.remove(fastRetrieval.size()-1);
            set.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {

        int n = random.nextInt(fastRetrieval.size());
        return fastRetrieval.get(n);
    }
}
class Sol{
    public static void main(String args[]){
        RandomizedSet r = new RandomizedSet();
        System.out.println(r.insert(3));
        System.out.println(r.remove(3));
        System.out.println(r.remove(0));
        System.out.println(r.insert(3));
        System.out.println(r.getRandom());
        System.out.println(r.remove(0));

//        System.out.println(r.getRandom());


    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */