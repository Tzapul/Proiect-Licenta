package ro.ucv.ace.utility.impl;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Geo on 08.12.2016.
 */
public class Node {

    private String text;

    private String path;

    private String extension;

    private boolean file;

    private List<Node> children = new ArrayList<>();

    public Node(String text, String path, boolean file, String extension) {
        this.text = text;
        this.path = path;
        this.file = file;
        this.extension = extension;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return "Node{" +
                "text='" + text + '\'' +
                ", file=" + file +
                ", children=" + children +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public boolean isFile() {
        return file;
    }

    public void setFile(boolean file) {
        this.file = file;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}

