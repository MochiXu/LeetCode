package Array_list;

class LRUCache {
    public class Page {
        public int key;
        public int value;
        public Page next;
        public Page pre;

        public Page(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public Page leftHeader;
    public Page rightHeader;
    public int capacity;
    public int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        //left与right能够统一插入删除逻辑
        leftHeader = new Page(-1, -1);
        rightHeader = new Page(-1, -1);
        leftHeader.next = rightHeader;
        leftHeader.pre=null;
        rightHeader.pre = leftHeader;
        rightHeader.next=null;
    }

    public int get(int key) {
        if (size == 0) return -1;
        //容量为1且刚好能够匹配
        if ( size == 1 && rightHeader.pre.key == key) {
           return rightHeader.pre.value;
        }
        Page curPage=leftHeader.next;
        int flag=0;
        while (curPage!=rightHeader){
            if(curPage.key==key){
                //找到了目标key，将该键值对进行位置更新
                flag=1;
                break;
            }
            curPage=curPage.next;
        }
        if (flag==0)return -1;
        //更新curPage的位置
        curPage.pre.next=curPage.next;
        curPage.next.pre=curPage.pre;
        curPage.pre=rightHeader.pre;
        rightHeader.pre.next=curPage;
        curPage.next=rightHeader;
        rightHeader.pre=curPage;
        return curPage.value;
    }

    public void put(int key, int value) {
        //缓存为空
        if (size == 0&&capacity>0) {
            Page page = new Page(key, value);
            leftHeader.next = page;
            page.next = rightHeader;
            page.pre = leftHeader;
            rightHeader.pre = page;
            size++;
            return;
        }
        //容量为1且刚好能够匹配
        if (size == 1 && rightHeader.pre.key == key) {
            rightHeader.pre.value = value;
            return;
        }
        //一般情况
        if (this.get(key) != -1) {
            //若缓存中存在该key则直接更新value
            rightHeader.pre.value = value;
        } else {
            //若缓存中不存在该key则在链表末尾新增page
            if (size == capacity) {
                //将首部淘汰
                leftHeader.next = leftHeader.next.next;
                leftHeader.next.pre = leftHeader;
                size--;
            }
            Page page = new Page(key, value);
            page.pre = rightHeader.pre;
            rightHeader.pre.next = page;
            page.next = rightHeader;
            rightHeader.pre = page;
            size++;
        }
    }
}