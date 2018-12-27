import java.util.*;
import java.util.Stack;

/**
 * 顶点。链表。
 */
class Vertex {
    String data;
    LinkedList<Integer> list;
    boolean visited = false;

    public Vertex(String d) {
        data = d;
        list = new LinkedList<>();
    }
}

/**
 * 邻接表实现，有向图。
 */
public class Graph {
    ArrayList<Vertex> vertexs;

    public Graph() {
        vertexs = new ArrayList<Vertex>();
    }

    public void addVertex(String d) {
        vertexs.add(new Vertex(d));
    }

    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v1 >= vertexs.size() || v2 < 0 || v2 >= vertexs.size()) {
            return;
        }

        Vertex vt1 = vertexs.get(v1);
        vt1.list.add(v2);

    }

    /**
     * 广度优先遍历。
     * 使用队列
     * O(n) O(n)
     */
    public void BFT() {
        if (vertexs.size() == 0) return;

        LinkedList<Vertex> ll = new LinkedList<>();

        //  第一个为根顶点, 从根顶点出发搜索
        for (Vertex v : vertexs) {
            if (v.visited == false) {
                // 入队 前 访问并设置已访问标记。这样避免入队重复顶点。
                System.out.printf("%s\n", v.data);
                v.visited = true;
                ll.offer(v);
            }

            while (!ll.isEmpty()) {
                Vertex vv = ll.poll();
                // 把它的孩子加入queue。
                for (int vindex : vv.list) {
                    Vertex child = vertexs.get(vindex);
                    if (child.visited == false) {
                        System.out.printf("%s\n", child.data);
                        child.visited = true;
                        ll.offer(child);
                    }
                }
            }
        }
    }

    /**
     * 深度优先遍历。
     * O(n) O(n)
     */
    public void DFT() {
        //  第一个为根顶点, 从根顶点出发搜索
        for (Vertex v : vertexs) {
            if (v.visited == false) {
                DFT(v);
            }
        }

    }

    public void DFT(Vertex v) {
        if (v == null) return;
        if (v.visited == true) return;

        // 访问
        System.out.printf("%s\n", v.data);
        v.visited = true;

        // 递归访问每个孩子
        for (int vindex: v.list) {
            Vertex child = vertexs.get(vindex);
            if (child.visited == false) {
                DFT(child);
            }
        }
    }


    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 0);
        g.addEdge(1, 4);
        g.addEdge(1, 5);
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(3, 2);
        g.addEdge(3, 5);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(5, 1);
        g.addEdge(5, 2);
        g.addEdge(5, 3);
        g.BFT();
        g.DFT();
    }

}

