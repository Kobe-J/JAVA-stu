package ja.fuxi;


import java.util.*;

/**
 * Java常用数据与结构复习
 * */
public class DataStructure {
    public static void main(String[] args) {

        //数组数组是相同数据类型的元素按一定顺序排列的集合，是一块连续的内存空间。数组的优点是：get和set操作时间上都是O(1)的；缺点是：add和remove操作时间上都是O(N)的。
        //Java中，Array就是数组，此外，ArrayList使用了数组Array作为其实现基础,它和一般的Array相比，最大的好处是，我们在添加元素时不必考虑越界，元素超出数组容量时，它会自动扩张保证容量。
        //Vector和ArrayList相比，主要差别就在于多了一个线程安全性，但是效率比较低下。如今java.util.concurrent包提供了许多线程安全的集合类（比如 LinkedBlockingQueue），所以不必再使用Vector了。
//        Integer[] ints = new Integer[10];
//        ints[9] = 600000000;
//        System.out.println(ints[9]);
//        System.out.println(ints.length);

        //链表是一种非连续、非顺序的结构，数据元素的逻辑顺序是通过链表中的指针链接次序实现的，链表由一系列结点组成。链表的优点是：add和remove操作时间上都是O(1)的；缺点是：get和set操作时间上都是O(N)的，而且需要额外的空间存储指向其他数据地址的项。
        //查找操作对于未排序的数组和链表时间上都是O(N)。
        //Java中，LinkedList 使用链表作为其基础实现。
//        List<Integer> linkedList =new ArrayList<>();
//        linkedList.add(0,6);
//        linkedList.set(0,99);
//        int a = linkedList.get(0);
//        System.out.println(a);
//        System.out.println(linkedList.contains(6));
//        System.out.println(linkedList.remove(0));
//        System.out.println(linkedList.contains(6));

        //队列
        //队列是一种特殊的线性表，特殊之处在于它只允许在表的前端进行删除操作，而在表的后端进行插入操作，亦即所谓的先进先出（FIFO）。
        //Java中，LinkedList实现了Deque，可以做为双向队列（自然也可以用作单向队列）。另外PriorityQueue实现了带优先级的队列，亦即队列的每一个元素都有优先级，且元素按照优先级排序。
//        Deque<Object> deque = new LinkedList<>();
//        deque.add(1);
//        deque.add(2);
//        deque.add(3);
//        deque.add(4);
//        System.out.println(deque.getFirst());
//        System.out.println(deque.getLast());
//        deque.offer("dsadas");
//        System.out.println(deque.contains(2));
//        System.out.println(deque.remove());
//        System.out.println(deque.poll());
//        System.out.println(deque.peek());
//        System.out.println(deque.element());

        //栈
        //栈（stack）又名堆栈，它是一种运算受限的线性表。其限制是仅允许在表的一端进行插入和删除运算。这一端被称为栈顶，相对地，把另一端称为栈底。它体现了后进先出（LIFO）的特点。
        //Java中，Stack实现了这种特性，但是Stack也继承了Vector，所以具有线程安全线和效率低下两个特性，最新的JDK8中，推荐用Deque来实现栈，比如：
//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.add(1);
//        deque.add(2);
//        deque.add(3);
//        deque.add(4);
//        deque.addFirst(5);
//        deque.pop();
//        System.out.println(deque.getFirst());


        //集合
        //集合是指具有某种特定性质的具体的或抽象的对象汇总成的集体，这些对象称为该集合的元素，其主要特性是元素不可重复。
        //在Java中，HashSet体现了这种数据结构，而HashSet是在MashMap的基础上构建的。LinkedHashSet继承了HashSet，使用HashCode确定在集合中的位置，使用链表的方式确定位置，所以有顺序。TreeSet实现了SortedSet 接口，是排好序的集合（在TreeMap 基础之上构建），因此查找操作比普通的Hashset要快（log(N)）；插入操作要慢（log（N））,因为要维护有序。
//        HashSet<Integer> hashSet =new HashSet<>();
//        hashSet.add(1);
//        hashSet.add(2);
//        hashSet.add(3);
//        System.out.println(hashSet.size());
//        System.out.println(hashSet.remove(3));
//        System.out.println(hashSet.size());
//        System.out.println(hashSet.contains(3));
//        System.out.println(hashSet.isEmpty());

        //散列表
        //散列表也叫哈希表，是根据关键键值(Keyvalue)进行访问的数据结构，它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度，这个映射函数叫做散列函数。
        //Java中HashMap实现了散列表，而Hashtable比它多了一个线程安全性，但是由于使用了全局锁导致其性能较低，所以现在一般用ConcurrentHashMap来实现线程安全的HashMap（类似的，以上的数据结构在最新的java.util.concurrent的包中几乎都有对应的高性能的线程安全的类）。
        // TreeMap实现SortMap接口，能够把它保存的记录按照键排序。LinkedHashMap保留了元素插入的顺序。WeakHashMap是一种改进的HashMap，它对key实行“弱引用”，如果一个key不再被外部所引用，那么该key可以被GC回收，而不需要我们手动删除。
//        HashMap<Integer,String> hashMap =new HashMap<>();
//        hashMap.put(1,"1");
//        System.out.println(hashMap.get(1));
//        System.out.println(hashMap.containsKey(2));


    }
}
