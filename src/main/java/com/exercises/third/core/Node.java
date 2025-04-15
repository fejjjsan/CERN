package com.exercises.third.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
public class Node {
    private final String name;
    private final List<Node> children = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public void addChild(Node node) {
        children.add(node);
    }

}
