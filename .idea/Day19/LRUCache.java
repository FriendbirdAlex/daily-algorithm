
class LRUCache {

    // 1. 定义双向链表节点类
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    // 2. 核心成员变量
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail; // 虚拟头尾节点

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        // 初始化虚拟头尾节点
        // head.next 是“最新”的数据
        // tail.prev 是“最旧”的数据
        head = new DLinkedNode();
        tail = new DLinkedNode();

        // 把头尾连起来
        head.next = tail;
        tail.prev = head;
    }

    // --- 核心业务逻辑 ---

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，然后把它移动到头部（标记为最近使用）
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            // 如果 key 不存在，创建一个新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加到双向链表的头部
            addToHead(newNode);
            size++;

            // 如果超出容量，删除双向链表的尾部节点
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                // 别忘了从哈希表中也删掉！
                cache.remove(tail.key);
                size--;
            }
        } else {
            // 如果 key 存在，修改 value，并移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    // --- 双向链表辅助方法 (O(1) 操作) ---

    // 1. 将节点移动到头部 (组合操作)
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 2. 在头部添加节点 (head 之后)
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    // 3. 删除一个中间节点 (断开链接)
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 4. 删除尾部节点 (淘汰最久未使用的)
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev; // 真正的最后一个有效节点
        removeNode(res);
        return res;
    }
}