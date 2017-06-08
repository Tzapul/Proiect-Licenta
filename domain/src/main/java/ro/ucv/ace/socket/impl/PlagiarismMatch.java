package ro.ucv.ace.socket.impl;

/**
 * Created by Geo on 04.12.2016.
 */
public class PlagiarismMatch {

    private int solution1;

    private int solution2;

    private String url;

    private float value;

    public int getSolution1() {
        return solution1;
    }

    public void setSolution1(int solution1) {
        this.solution1 = solution1;
    }

    public int getSolution2() {
        return solution2;
    }

    public void setSolution2(int solution2) {
        this.solution2 = solution2;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PlagiarismMatch{" +
                "solution1=" + solution1 +
                ", solution2=" + solution2 +
                ", url='" + url + '\'' +
                ", value=" + value +
                '}';
    }
}
