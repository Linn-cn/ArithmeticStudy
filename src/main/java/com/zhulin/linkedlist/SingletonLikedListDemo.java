package com.zhulin.linkedlist;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname SingletonList
 * @description
 * @create 2020-02-25 20:05
 **/
public class SingletonLikedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        SingletonLinkedList list = new SingletonLinkedList();
//        list.add(heroNode1);
//        list.add(heroNode3);
//        list.add(heroNode2);
        list.addByOrder(heroNode1);
        list.addByOrder(heroNode3);
        list.addByOrder(heroNode2);

        // 测试修改节点
        HeroNode newHeroNode1 = new HeroNode(3, "吴用1", "智多星");
        list.update(newHeroNode1);
        HeroNode newHeroNode2 = new HeroNode(4, "吴用1", "智多星");
        list.update(newHeroNode2);
        list.showList();
    }
}

// 定义SingletonLinkedList
class SingletonLinkedList {
    // 先初始化一个头节点，头节点不用动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到单向链表
    //思路，当不考虑编号顺序时，即无序
    //1.找到当前链表的最后节点.
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        // 因为头节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        // 遍历链表,找到最后
        while (true) {
            if (temp.next == null) break;
            // 如果没有找到最后，将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        temp.next = heroNode;
    }

    // 第二种添加的方式，根据排名将英雄插入到指定位置
    public void addByOrder(HeroNode heroNode){
        // 因为头节点不能懂，因此我们仍然通过一个temp临时节点来遍历
        // 因为是单链表，所以我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;   // 标志添加的标号已经存在，，默认为false
        // 遍历链表,找到最后
        while (true) {
            if (temp.next == null) break;
            if (temp.next.no > heroNode.no){    //位置找到，就在temp后面
                break;
            }else if (temp.next.no == heroNode.no){ //说明希望添加的heroNode编号已经存在
                flag = true;    //说明编号存在
                break;
            }
            // 后移，遍历当前列表
            temp = temp.next;
        }
        if (flag){
            System.out.println("准备插入的英雄的编号已经存在：" + heroNode.no);
        }else {
            // 加入到链表中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 修改节点的信息，根据no编号来修改
    public void update(HeroNode newHeroNode){
        // 判断是否为空
        if (head.next == null){
            System.out.println("链表为空~");
            return;
        }

        // 扎到需要修改的节点
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break; // 已经遍历完链表
            }
            if (temp.no == newHeroNode.no){
                // 找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag 判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else { //没有找到
            System.out.println("没有找到编号等于这个的节点：" + newHeroNode.no);
        }

    }



    // 显示链表[遍历]
    public void showList() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点，不能懂，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            // 输出节点信息
            System.out.println(temp);
            if (temp.next == null) break;
            // 将temp后移,这里注意
            temp = temp.next;
        }
    }
}

// 定义HeroNode,每个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    // 构造器
    public HeroNode(int hNo, String name, String nickname) {
        this.no = hNo;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
