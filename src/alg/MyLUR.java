package alg;



import pojo.Node;

import java.util.HashMap;

//最近最少访问算法
public class MyLUR {
    private Node head;
    private Node end;
    private int limit;
    private HashMap<String, Node> hashMap;

    public MyLUR(int limit){
        this.limit = limit;
        hashMap = new HashMap<String,Node>();
    }
    //访问结点
    public String get(String key){
        Node node = hashMap.get(key);//根据给的key值获取想应的“哈希结点”
        if(node == null){//如果改结点不存在
            return null;//返回null
        }
        refresh(node);//更新哈希链表，将刚访问的节点放到尾部
        return node.value;
    }

    public void put(String key,String value){
        Node node = hashMap.get(key);
        if(node == null){//若该结点不在哈希链表里
            if(hashMap.size() >= limit){//如果缓存容量到上限了
                String oldkey = removeNode(head);//删除左边第一个结点
                hashMap.remove(oldkey);
            }
            node = new Node(key,value);
            addNode(node);//将新结点插入尾部
            hashMap.put(key,node);
        }
        else{//若该结点在哈希链表里
            node.value = value;
            refresh(node);//更新哈希链表，将刚访问的节点放到尾部
        }
    }

    public void remove(String key){
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    private void refresh(Node node){
        if(node == end) return;//如果访问尾结点，则无需移动节点
        removeNode(node);//移出节点
        addNode(node);//重新插入节点
    }

    private String removeNode(Node node){
        if(node == head && node == end){//如果哈希链表只有一个节点
            head =null;
            end = null;
        }else if(node == end){//如果是尾节点
            end = end.pre;
            end.next = null;
        }
        else if(node == head){//如果是头节点
            head = head.next;
            head.pre = null;
        }
        else{//如果是中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    private void addNode(Node node){
        if(end != null){
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if(head == null){
            head = node;
        }
    }

    public static void main(String[] args) throws Exception{
        MyLUR myLUR = new MyLUR(5);
        myLUR.put("001","用户1");
        myLUR.put("002","用户2");
        myLUR.put("003","用户3");
        myLUR.put("004","用户4");
        myLUR.put("005","用户5");
        myLUR.get("002");
        myLUR.put("004","用户2更新");
        myLUR.put("006","用户6");
        System.out.println(myLUR.get("004"));
        System.out.println(myLUR.get("006"));
    }

}
