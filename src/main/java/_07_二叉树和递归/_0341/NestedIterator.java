package _07_二叉树和递归._0341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    Iterator<Integer> it = null;

    /**
     * 341. 扁平化嵌套列表迭代器
     *
     * todo 后序优化 惰性迭代器
     *
     * 类似一个多叉树的遍历，只取其中的叶子节点。
     * 这种方式有个弊端，入参很大时会撑爆内存
     * @param nestedList
     */
    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> list = new LinkedList<>();
        for(NestedInteger nested:nestedList) {
            inorder(nested,list);
        }
        this.it = list.iterator();
    }
    public void inorder(NestedInteger root,List<Integer> list) {
        if(root.isInteger()) {
            list.add(root.getInteger());
            return;
        }
        for(NestedInteger nested:root.getList()) {
            inorder(nested,list);
        }
    }

    @Override
    public Integer next() {
        return this.it.next();
    }

    @Override
    public boolean hasNext() {
        return this.it.hasNext();
    }
}