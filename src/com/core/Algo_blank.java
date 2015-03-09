package com.core;

import com.dao.*;
import com.core.*;
import com.model.*;
import java.util.*;

public class Algo_blank {

	
	float diff[];// 难度权重
	float weight[][];// 期望权重

	public static double[][] getWeight() {
		double weight[][] = new double[15][4];
		double chp[] = getChp();
		double diff[][] = getDiff();
		for (int i = 0; i < diff.length; i++)
			for (int j = 0; j < diff[i].length; j++) {
				weight[i][j] = chp[i] * diff[i][j];
		//		System.out.print("weight " + weight[i][j]);
			}
	//	System.out.println();
		return weight;

	}

	public static double[] getChp() {
		DbBasetableFactory bf = new DbBasetableFactory();
		int submit_page = 0, i = 0;
		double a[] = new double[15];
		Collection coll = bf.ListBlankChp(submit_page, "");
		Iterator it = coll.iterator();
		while (it.hasNext()) {
			BlankChp s = (BlankChp) it.next();
			a[i] = s.getChp_r();
			i++;

		}
		return a;
	}

	public static double[][] getDiff() {
		DbBasetableFactory bf = new DbBasetableFactory();
		int submit_page = 0, i = 0, j = 0;
		double a[][] = new double[15][4];
		ArrayList list = null;// 章节权重
		Collection coll = bf.ListBlankDiff(submit_page, "");
		Iterator it = coll.iterator();
		while (it.hasNext()) {
			BlankDiff s = (BlankDiff) it.next();
			a[i][j] = s.getD1_r();
			a[i][j + 1] = s.getD2_r();
			a[i][j + 2] = s.getD3_r();
			a[i][j + 3] = s.getD4_r();
			j = 0;
			i++;
		}
		return a;
	}

	public static void main(String args[]){
		int index[][]=getIndex();
	//	System.out.println(" "+index[57][0]+" "+index[57][1]);
	//	System.out.println(" "+index[58][0]+" "+index[58][1]);
		/*for(int i=0;i<index.length;i++){
			for(int j=0;j<index[i].length;j++){
				System.out.print(" "+index[i][j]);
				
			}
			System.out.println();
		}*/
	}
	public static int[][] getIndex() {
		double w[] = getSort();
		double temp = 0;
		int temp1;
		int ij[][] = new int[60][2];// ij数组是将位置数组转换为数据表中的i,j值
		int index[] = new int[60];// 定义一个位置数组，排序的同时位置也发生变化
		for (int i = 0; i < index.length; i++) {
			index[i] = i;
		}
		for (int i = 0; i < w.length; i++) {
			for (int j = i; j < w.length; j++) {
				if (w[j] > w[i]) {
					temp = w[i];
					w[i] = w[j];
					w[j] = temp;
					temp1 = index[i];
					index[i] = index[j];
					index[j] = temp1;
				}
			}
		
			for (int p = 0; p < 60; p++) {
				ij[p][0] = index[p] / 4 + 1;
				ij[p][1] = index[p] % 4 + 1;
			}
			
		}
		return ij;
		
	}
	public static double[] getSort() {
		double weight[][] = new double[15][4];
		weight = getWeight();
		double w[] = new double[60];// 将二维数组转化为一维数组
		int s = 0;

		// 二维数组转化为一维数组
		for (int i = 0; i < weight.length; i++) {
			for (int j = 0; j < weight[i].length; j++) {
				w[s] = weight[i][j];
				System.out.print("w[s] " + w[s]);
				s++;
			}
		}
		Arrays.sort(w);// 将数组按照从大到小的顺序排列
		return w;
	}
}