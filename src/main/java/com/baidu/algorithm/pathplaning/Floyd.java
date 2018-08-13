/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.algorithm.pathplaning;

/**
 * Floyed
 *
 * @author xuhaoran01
 */
public class Floyd {

    int[][] Matrix;
    char[] Nodes;

    private final int INF = Integer.MAX_VALUE;

    public Floyd(char[] Nodes, int[][] Matrix) {
        this.Nodes = Nodes;
        this.Matrix = Matrix;
    }

    // 找i和j之间通过编号不超过k（k从1到n）的节点的最短路径
    public void floyd() {

        int[][] distance = new int[Nodes.length][Nodes.length];

        // 初始化距离矩阵
        for (int i = 0; i < Nodes.length; i++) {
            for (int j = 0; j < Nodes.length; j++) {
                distance[i][j] = Matrix[i][j];
            }
        }

        //循环更新矩阵的值
        for (int k = 0; k < Nodes.length; k++) {
            for (int i = 0; i < Nodes.length; i++) {
                for (int j = 0; j < Nodes.length; j++) {
                    int temp = (distance[i][k] == INF || distance[k][j] == INF) ? INF : distance[i][k] + distance[k][j];
                    if (distance[i][j] > temp) {
                        distance[i][j] = temp;
                    }
                }
            }
        }

        // 打印floyd最短路径的结果
        System.out.printf("floyd: \n");
        for (int i = 0; i < Nodes.length; i++) {
            for (int j = 0; j < Nodes.length; j++)
                System.out.printf("%12d  ", distance[i][j]);
            System.out.printf("\n");
        }
    }

}
