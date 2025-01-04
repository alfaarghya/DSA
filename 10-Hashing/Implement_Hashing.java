import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

class HashMap<K, V> {

  class Node {
    K key;
    V value;

    Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  LinkedList<Node>[] bucket;
  static int N; // size of bucket array
  static int n; // number of Nodes in buckets

  /*---- HashMap constructor ----*/
  @SuppressWarnings("unchecked")
  public HashMap() {
    N = 10; // at beginning size of bucket array is 10
    n = 0;
    bucket = new LinkedList[N];

    // every index of bucket should have empty LinkedList
    storeEmptyLinkedList();
  }
  /*---- ----*/

  /*---- put a (key,value) pair in HashMap ----*/
  public void put(K key, V value) {
    // step1 => get index to put value in the bucket
    int bucketIndex = hashFunction(key);
    // step2 => search if key is present in the hashMap or not
    int dataIndex = searchInLL(bucketIndex, key);

    // step3 => put the key-value pair in the hashMap
    if (dataIndex == -1) { // key is not present -> so add new node
      n++;
      bucket[bucketIndex].add(new Node(key, value));
    } else { // key is present -> so just update the value
      bucket[bucketIndex].get(dataIndex).value = value;
    }

    // step4 => reshape the hashMap if lambda is greater than 5
    double lambda = n / N;
    if (lambda > 5.0) {
      reshape();
    }
  }
  /*---- ----*/

  /*---- remove a key-value pair from hashmap ----*/
  public V remove(K key) {
    // step1 => get index of target LinkedList in bucket
    int bucketIndex = hashFunction(key);
    // step2 => search if key is present in the hashMap or not
    int dataIndex = searchInLL(bucketIndex, key);

    // step3 => remove the key-value pair
    if (dataIndex == -1) { // key is not present -> so return null
      return null;
    } else { // key is present -> so delete it
      n--;
      return bucket[bucketIndex].remove(dataIndex).value;
    }
  }
  /*---- ----*/

  /*---- get a value based on key ----*/
  public V get(K key) {
    // step1 => get index of target LinkedList in bucket
    int bucketIndex = hashFunction(key);
    // step2 => search if key is present in the hashMap or not
    int dataIndex = searchInLL(bucketIndex, key);

    // step3 => return the value
    if (dataIndex == -1) { // key is not present -> so return null
      return null;
    } else { // key is present -> so just return the value
      return bucket[bucketIndex].get(dataIndex).value;
    }
  }
  /*---- ----*/

  /*---- get a value based on key ----*/
  public boolean containKey(K key) {
    // step1 => get index of target LinkedList in bucket
    int bucketIndex = hashFunction(key);
    // step2 => search if key is present in the hashMap or not
    int dataIndex = searchInLL(bucketIndex, key);

    // step3 => return the boolean value
    if (dataIndex == -1) { // key is not present
      return false;
    } else { // key is present
      return true;
    }
  }
  /*---- ----*/

  /*---- get size of hashMap ----*/
  public int size() {
    return n;
  }
  /*---- ----*/

  /*---- is HashMap empty? ----*/
  public boolean isEmpty() {
    return n == 0;
  }
  /*---- ----*/

  /*---- get key set ----*/
  public ArrayList<K> keySet() {
    ArrayList<K> keys = new ArrayList<>();

    for (LinkedList<Node> ll : bucket) {
      for (Node node : ll) {
        keys.add(node.key);
      }
    }
    return keys;
  }
  /*---- ----*/

  /*---- Helper functions ----*/
  private int hashFunction(K key) {
    /*
     * hashCode() method of Object class, returns the memory address of the object
     * in integer form. it can be a large number so we make it small
     */
    return Math.abs(key.hashCode()) % N;
  }

  private int searchInLL(int bucketIndex, K key) {
    /*
     * find if our key is already present in the LinkedList of bucket[bucketIndex]
     */
    LinkedList<Node> ll = bucket[bucketIndex];
    int index = 0;

    for (Node node : ll) {
      if (node.key.equals(key)) {
        return index; // key is present in LinkedList
      }
      index++;
    }
    // key is not present in LinkedList
    return -1;
  }

  @SuppressWarnings("unchecked")
  private void reshape() {
    /*
     * reshape the hashMap
     */
    // step1 => store old data into array of LinkedList
    LinkedList<Node>[] oldBucket = bucket;
    // step2 => increase the size of bucket
    N *= 2; // double the size of bucket
    bucket = new LinkedList[N];

    // step3 => every index of bucket should contain empty LinkedList
    storeEmptyLinkedList();

    // step4 => go through oldBucket and put key-value pair in bucket
    for (LinkedList<Node> ll : oldBucket) {
      for (int i = 0; i < ll.size(); i++) {
        Node node = ll.remove(i);
        put(node.key, node.value);
      }
    }

  }

  private void storeEmptyLinkedList() {
    /*
     * every index of bucket should contain empty LinkedList
     */
    for (int i = 0; i < N; i++) {
      bucket[i] = new LinkedList<>();
    }
  }
  /*---- ----*/

}

public class Implement_Hashing {
  public static void main(String[] args) {
    System.out.println("----------- HashMap implementation -----------");
    HashMap<String, Integer> hm = new HashMap<>();
    System.out.println(hm.size());

    hm.put("U", 1);
    hm.put("a", 2);
    hm.put("X", 3);
    hm.put("y", 4);
    hm.put("y", 5);
    hm.put("A", 6);
    hm.put("B", 7);

    System.out.println(hm.keySet());
    System.out.println(hm.size());
    System.out.println(hm.containKey("a"));
    System.out.println(hm.containKey("b"));
    System.out.println(hm.get("A"));
    System.out.println(hm.get("M"));
    System.out.println(hm.get("y"));
    System.out.println(hm.remove("y"));
    System.out.println(hm.remove("m"));
    System.out.println(hm.keySet());
    System.out.println(hm.size());
    System.out.println("---------------------- ----------------------");

    System.out.println("----------- HashSet -----------");
    /*
     * HashSet Implement using HashMap
     * null value allowed
     */
    HashSet<Integer> hs = new HashSet<>();

    hs.add(1);
    hs.add(6);
    hs.add(5);
    hs.add(5);
    hs.add(1);
    hs.add(3);

    System.out.println(hs);

    System.out.println(hs.contains(10));
    System.out.println(hs.contains(6));

    hs.remove(1);

    System.out.println(hs);
    System.out.println(hs.size());
    System.out.println(hs.isEmpty());
    System.out.println("---------------------- ----------------------");
    System.out.println("----------- LinkedHashMap -----------");
    /*
     * to implement it we use Array of DoublyLinkedList
     * it will maintain order as we insert values into it unlike HashMap which
     * change the order
     */
    LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
    lhm.put("IND", 130);
    lhm.put("CHINA", 120);
    lhm.put("US", 100);
    lhm.put("PAK", 30);
    System.out.println(lhm);
    System.out.println("---------------------- ----------------------");
    System.out.println("----------- LinkedHashSet -----------");
    /*
     * It maintain the order of key and it is implemented by LinedHashMap
     * null value allowed
     */
    LinkedHashSet<Character> lhs = new LinkedHashSet<>();

    lhs.add('c');
    lhs.add('x');
    lhs.add('c');
    lhs.add('W');
    lhs.add('b');
    lhs.add('A');
    lhs.add('a');

    System.out.println(lhs);
    System.out.println("---------------------- ----------------------");
    System.out.println("----------- TreeMap -----------");
    /*
     * To implement it we use Red Black Tree
     * it will sort itself according to key
     * that's why put(),remove(),get() all are in O(log n) Time Complexity
     */
    TreeMap<String, Integer> tm = new TreeMap<>();
    tm.put("IND", 130);
    tm.put("CHINA", 120);
    tm.put("US", 100);
    tm.put("PAK", 30);
    System.out.println(tm);
    System.out.println("---------------------- ----------------------");
    System.out.println("----------- TreeSet -----------");
    /*
     * TreeSet Implement using TreeMap
     * Sorted in ascending order
     * Null value not allowed
     */
    TreeSet<Character> ts = new TreeSet<>();

    ts.add('c');
    ts.add('x');
    ts.add('c');
    ts.add('W');
    ts.add('b');
    ts.add('A');
    ts.add('a');

    System.out.println(ts);
    System.out.println("---------------------- ----------------------");
  }
}