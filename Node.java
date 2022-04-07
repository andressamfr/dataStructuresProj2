public class Node {
    Palavra elemento; // elemento armazenado no nó
    Node left, right, parent; // apontadores do nó
    Node(Palavra elemento) {
        this.elemento = elemento;
        left = right = parent = null;
    }
    public Palavra getElemento() {
        // Devolve o elemento armazenado no nó
        return elemento;
    }
    public String getPalavra() {
        return elemento.palavra;
    }
    public int getOcorrencias() {
        return elemento.ocorrencias;
    }
    public void setOcorrencias() {
        this.elemento.ocorrencias += 1;
    }
    public void setElemento(Palavra palavra) {
        // Altera o elemento armazenado no nó
        this.elemento = palavra;
    }
    public Node getParent() {
        // Devolve o pai do nó
        return parent;
    }
    public void setParent(Node p) {
        // Altera o pai do nó para o nó p
        this.parent = p;
    }
    public Node getLeft() {
        // Devolve o nó armazenado à esquerda do nó
        return left;
    }
    public void setLeft(Node no) {
        // Altera o nó armazenado à esquerda para p
        this.left = no;
    }
    public Node getRight() {
        // Devolve o nó armazenado à direita do nó
        return right;
    }
    public void setRight(Node no) {
        // Altera o nó armazenado à direita para p
        this.right = no;
    }
}