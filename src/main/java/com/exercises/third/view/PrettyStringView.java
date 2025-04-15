package com.exercises.third.view;

import com.exercises.third.core.Node;

import java.util.List;

public class PrettyStringView implements ViewOption {
    @Override
    public String getView(List<Node> roots) {
        var result = new StringBuilder();

        for (Node root : roots) {
            result.append(recursiveViewBuild(root, ""));
        }

        result.deleteCharAt(result.length() - 1); // Delete last escape character from result

        return result.toString();
    }


    private static String recursiveViewBuild(Node node, String indent) {
        var result  = new StringBuilder();
        result.append(indent);
        result.append("- ");
        result.append(node.getName());
        result.append("\n");
        for (Node child : node.getChildren()) {
            result.append(recursiveViewBuild(child, indent + "  "));
        }
        return result.toString();
    }
}
