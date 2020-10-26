package second.shortcuts;

import java.util.List;

public class ClassThatHaveItAll implements InterfaceOne {

    String name;
    Integer number;
    List<Long> list;

    public ClassThatHaveItAll() {
    }

    public ClassThatHaveItAll(String name, Integer number, List<Long> list) {
        this.name = name;
        this.number = number;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }

    public void printMe(String info) {
        System.out.println(info);
    }

    public void usageOfPrint() {
        printMe("Hi");
    }
}
