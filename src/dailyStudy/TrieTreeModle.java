package dailyStudy;

/**
 * @ClassName: TrieTreeModle
 * @Description: 前缀树模版
 * @author: dk
 * @date: 2022/4/23 2:35 下午
 */

public class TrieTreeModle {

    public static class TrieNode {
        public int path;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            path = 0;   //有多少个结点到达过
            end = 0;    //有多少个字符串以这个结点结尾
            nexts = new TrieNode[26];  //通向子节点的路，如果题目所给的范围不确定就用map
        }
    }


    public static class Trie {

        private TrieNode root;


        public Trie() {
            //准备一个头结点
            root = new TrieNode();
        }


        //将一个单词插入
        public void insert( String word ) {
            if ( word == null ) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for ( int i = 0; i < chs.length; i++ ) {
                index = chs[i] - 'a';
                if ( node.nexts[index] == null ) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }


        //在结构中删除这个单词
        public void delete( String word ) {
            if ( search( word ) != 0 ) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for ( int i = 0; i < chs.length; i++ ) {
                    index = chs[i] - 'a';
                    if ( --node.nexts[index].path == 0 ) {
                        //如果某个结点-1之后==0，则说明此节点之后的结点也是-1之后==0，因此直接=null即可。
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }


        //查找某个单词插入了几次
        public int search( String word ) {
            if ( word == null ) {
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for ( int i = 0; i < chs.length; i++ ) {
                index = chs[i] - 'a';
                if ( node.nexts[index] == null ) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }


        //查某个字符串前缀数量是多少
        public int prefixNumber( String pre ) {
            if ( pre == null ) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for ( int i = 0; i < chs.length; i++ ) {
                index = chs[i] - 'a';
                if ( node.nexts[index] == null ) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }

    }


    public static void main( String[] args ) {
        Trie trie = new Trie();
        System.out.println( trie.search( "zuo" ) );
        trie.insert( "zuo" );
        System.out.println( trie.search( "zuo" ) );
        trie.delete( "zuo" );
        System.out.println( trie.search( "zuo" ) );
        trie.insert( "zuo" );
        trie.insert( "zuo" );
        trie.delete( "zuo" );
        System.out.println( trie.search( "zuo" ) );
        trie.delete( "zuo" );
        System.out.println( trie.search( "zuo" ) );
        trie.insert( "zuoa" );
        trie.insert( "zuoac" );
        trie.insert( "zuoab" );
        trie.insert( "zuoad" );
        trie.delete( "zuoa" );
        System.out.println( trie.search( "zuoa" ) );
        System.out.println( trie.prefixNumber( "zuo" ) );

    }

}
