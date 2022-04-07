public class ABB<Palavra extends Comparable> {

    private Node root; // raiz da árvore

    ABB() {
        // Cria uma árvore binária vazia
        root = null;
    }

    public boolean isEmpty() {
        // Verifica se a árvore está vazia
        return root == null;
    }

    public void addRoot(Node e) throws Exception {
        // adiciona raiz na árvore, caso não exista
        if (root != null)
            throw new Exception("Árvore já tem raiz!");
        root = e;
    }

    public Node getRoot() {
        // Devolve a raiz da árvore.
        return root;
    }

    public boolean isRoot(Node n) {
        //verifica se o nó n é raiz
        return n.getParent() == null;
    }

    public boolean isInternal(Node n) {
        // Verifica se um nó n é interno
        return n.getLeft() != null || n.getRight() != null;
    }

    public boolean isLeaf(Node n) {
        // Verifica se um nó n é uma folha
        return n.getLeft() == null && n.getRight() == null;
    }

    public Node left(Node e) {
        // Devolve o filho esquerdo do nó e.
        return e.getLeft();
    }

    public boolean hasLeft(Node e) {
        // Verifica se o nó e tem filho esquerdo
        return e.getLeft() != null;
    }

    public Node right(Node e) {
        // Devolve o filho direito do nó e.
        return e.getRight();
    }

    public boolean hasRight(Node e) {
        // Verifica se o nó e tem filho direito
        return e.getRight() != null;
    }

    public void executaInOrdem(Node no) {
        if (no == null) {
            return;
        }
        executaInOrdem(no.getLeft());
        System.out.println("\nPalavra: " + "\"" + no.getPalavra() + "\"" + " " + "\nOcorrências: " + no.getOcorrencias());
        executaInOrdem(no.getRight());
    }

    public void insere(Node z) {
        Node y = null;
        Node x = getRoot();
        if (x == null) {
            root = z;
        } else {
//            int cmp = z.getPalavra().compareTo(x.getPalavra());
            while (x != null) {
                y = x;
                if (z.getPalavra().compareTo(x.getPalavra()) < 0) {
                    x = x.getLeft();
                } else {
                    x = x.getRight();
                }
            }
            z.setParent(y);
            if (z.getPalavra().compareTo(y.getPalavra()) < 0) {
                y.setLeft(z);
            } else {
                y.setRight(z);
            }
        }
    }

    public Node busca(Node k) {
        Node y = getRoot();
        while (y != null) {
            int cmp = k.getPalavra().compareTo(y.getPalavra());
            if (cmp == 0) {
                return y;
            } else if (cmp < 0) {
                y = y.left;
            } else {
                y = y.right;
            }
        }
        return null;
    }

    public Node maximo(Node x) {
        //Node<E> x = root();
        while (x.getRight() != null) {
            x = x.getRight();
        }
        return x;
    }

    public Node minimo(Node n) {
        Node x = n;
        while (x.getLeft() != null) {
            x = x.getLeft();
        }
        return x;
    }

}