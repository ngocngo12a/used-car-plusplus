package vn.plusplus.used.car.interfaces;

import java.util.List;

public class ParserInterface<T> {
    public abstract T parserDetail(String url);
    public abstract List<String> parserListLink(String url);
}
