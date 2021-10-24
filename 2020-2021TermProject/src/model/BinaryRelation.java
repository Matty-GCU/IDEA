package model;

import view.MyTable;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 基于boolean[][]存储的二元关系类。
 * 提供以下功能：
 * 1）对关系的自反性、反自反性、对称性、反对称性和传递性的判断，以及自反闭包、对称闭包和传递闭包的求取；
 * 2）对等价关系的判断，以及划分的求取；
 * 3）对偏序关系的判断，以及极大值、极小值、最大值、最小值的求取。
 * @author Matty
 * @version 1.0
 */
public class BinaryRelation implements Cloneable {

    /**
     * 当前二元关系基于的基础集合（set）。
     */
    private final BasicSet SET;

    /**
     * 基础集合的元素个数。
     */
    private final int N;

    /**
     * 表示当前二元关系的关系矩阵（matrix of the relation）。
     * 若关系矩阵对应下标的的元素[i][j]为true，则基础集合的第i个元素与第j个元素具有关系。
     */
    private boolean[][] matrix;

    /**
     * 表示生成关系R的自反闭包t(R)。
     */
    public static final String CLOSURE_TYPE_REFLEXIVE = "r";

    /**
     * 表示生成关系R的自反闭包s(R)。
     */
    public static final String CLOSURE_TYPE_SYMMETRIC = "s";

    /**
     * 表示生成关系R的自反闭包t(R)。
     */
    public static final String CLOSURE_TYPE_TRANSITIVE = "t";

    /**
     * 实例化一个基于该基础集合的二元关系，并初始化关系矩阵。
     */
    public BinaryRelation(BasicSet basicSet) {
        SET = basicSet;
        N = basicSet.size();
        matrix = new boolean[N][N];
    }

    /**
     * 获取关系矩阵。
     */
    public boolean[][] getMatrix() {
        return matrix;
    }

    /**
     * 设置关系矩阵。
     */
    public void setMatrix(boolean[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * 添加有序偶。
     */
    public void addOrderedPair(int firstElement, int secondElement) {
        int i = SET.indexOf(firstElement);
        int j;
        if(firstElement == secondElement) {
            j = i;
        }
        else {
            j = SET.indexOf(secondElement);
        }
        matrix[i][j] = true;
    }

    /**
     * 根据定义判断关系的自反性（reflexive）。
     * 即：矩阵主对角线上的元素均为1(true)。
     */
    public boolean isReflexive() {
        for(int i = 0; i < N; i++) {
            if(! matrix[i][i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 根据定义判断关系的反自反性（anti-reflexive）。
     * 即：矩阵主对角线上的元素均为0(false)。
     */
    public boolean isAntiReflexive() {
        for(int i = 0; i < N; i++) {
            if(matrix[i][i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 根据定义判断关系的对称性（symmetric）。
     * 即：关于矩阵主对角线对称的两个元素相同。
     */
    public boolean isSymmetric() {
        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 根据定义判断关系的反对称性（anti-symmetric）。
     * 即：关于矩阵主对角线对称的两个元素，当其中一个为1(true)时，另一个必须为0(false)。
     */
    public boolean isAntiSymmetric() {
        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(matrix[i][j] && matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 利用复合矩阵法判断关系的传递性(transitive)。
     * 即：有矩阵M的平方M*M，即矩阵M2。当M[i,j]为0(false)时，M2[i,j]必须也0(false)。
     */
    public boolean isTransitive() {
        boolean[][] matrixM2 = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                boolean booSum = false;
                for(int k = 0; k < N; k++) {
                    booSum = booSum || (matrixM2[i][k] && matrix[k][j]);
                }
                matrixM2[i][j] = booSum;
            }
        }
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if((! matrix[i][j]) && matrixM2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 根据定义判断等价关系（equivalence relation）。
     * 非空集合A上的自反、对称和传递的关系，称为A上的等价关系。
     */
    public boolean isEquRelation() {
        return isReflexive() && isSymmetric() && isTransitive();
    }

    /**
     * 根据定义判断偏序关系（partial order relation）。
     * 非空集合A上的自反、反对称和传递的关系，称为A上的偏序关系。
     */
    public boolean isPartialOrder() {
        return isReflexive() && isAntiSymmetric() && isTransitive();
    }

    /**
     * 对于偏序关系R，根据参数生成不同的闭包（closure），如自反闭包r(R)、对称闭包s(R)、传递闭包t(R)。
     * @param type “r""s"或"t"。建议使用对应的类常量以避免错误。
     * @return 以二元关系形式表示的闭包
     */
    public BinaryRelation findClosure(String type) {
        BinaryRelation closure = clone();
        switch(type) {
            case CLOSURE_TYPE_REFLEXIVE:
                if (isReflexive()) {
                    return this;
                }
                else {
                    closure.toReflexive();
                }
                break;
            case CLOSURE_TYPE_SYMMETRIC:
                if (isSymmetric()) {
                    return this;
                }
                else {
                    closure.toSymmetric();
                }
                break;
            case CLOSURE_TYPE_TRANSITIVE:
                if (isTransitive()) {
                    return this;
                }
                else {
                    closure.toTransitive();
                }
                break;
            default:
                return null;
        }
        return closure;
    }

    /**
     * 返回当前二元关系的一个克隆对象，它包含相同的基础集合（相同引用）和相同的关系矩阵（不同引用）。
     */
    @Override
    public BinaryRelation clone() {
        BinaryRelation clone;
        try{
            clone = (BinaryRelation) super.clone();
        }
        catch(CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
        boolean[][] matrixClone = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            matrixClone[i] = matrix[i].clone();
        }
        clone.setMatrix(matrixClone);
        return clone;
    }

    /**
     * 通过修改矩阵上特定行列上的元素，将当前二元关系改为自反闭包（reflexive closure）。
     */
    public void toReflexive() {
        for(int i = 0; i < N; i++) {
            if(! matrix[i][i]) {
                matrix[i][i] = true;
            }
        }
    }

    /**
     * 通过修改矩阵上特定行列上的元素，将当前二元关系改为对称闭包（symmetric closure）。
     */
    public void toSymmetric() {
        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(matrix[i][j] != matrix[j][i]) {
                    if(matrix[i][j]) {
                        matrix[j][i] = true;
                    }
                    else {
                        matrix[i][j] = true;
                    }
                }
            }
        }
    }

    /**
     * 利用Warshall算法，通过修改矩阵上特定行列上的元素，将当前二元关系改为传递闭包（transitive closure）。
     */
    public void toTransitive() {
        for(int k = 0; k < N; k++) {
            //遍历第k列
            for(int i = 0; i < N; i++) {
                //若找到(i,k)
                if(matrix[i][k]) {
                    //就遍历第k行，找(k,j)
                    for(int j = 0; j < N; j++) {
                        //若有(k,j)，则(i,j)改为真；若没有，则(i,j)不变
                        matrix[i][j] = matrix[i][j] || matrix[k][j];
                    }
                }
            }
        }
    }

    /**
     * 以等价类为分类标准，对基础集合中的元素进行分类，即生成基础集合基于当前二元关系的划分（partition）。
     * 设R为非空集合A上的等价关系，以R的所有等价类（equivalence class）作为元素的集合，称为A关于R的商集（quotient set），也即A的一个划分。
     * @return 返回一个存储分类结果的链表。注意：链表元素是以基础集合形式表示的等价类。
     */
    public QuotientSet generatePartition() {
        if(! isEquRelation()) {
            return null;
        }
        QuotientSet quotientSet = new QuotientSet();
        HashSet<Integer> elementUsed = new HashSet<>();
        for(int i = 0; i < N - 1; i++) {
            if(elementUsed.contains(SET.get(i))) {
                i++;
            }
            else {
                BasicSet curEquClass = new BasicSet();
                curEquClass.add(SET.get(i));
                for(int j = i + 1; j < N; j++) {
                    if(matrix[i][j]) {
                        curEquClass.add(SET.get(j));
                        elementUsed.add(SET.get(j));
                    }
                }
                quotientSet.add(curEquClass);
            }
        }
        return quotientSet;
    }

    /**
     * 基于当前二元关系，生成一个表示关系矩阵的可视化表格，方便对关系矩阵进行查看和修改。
     * @return 返回一个JTable表格对象。在表格中，以“1”表示关系矩阵中值为true的元素，以“0”表示关系矩阵中值为false的元素。
     */
    public MyTable generateMyTable() {
        MyTable myTable;
        String[][] rowData = new String[N][N + 1];
        String[] columnNames = new String[N + 1];
        columnNames[0] = "";
        for(int i = 1; i < N + 1; i++) {
            columnNames[i] = SET.get(i - 1).toString();
            rowData[i - 1][0] = columnNames[i];
        }
        for(int i = 0; i < N; i++) {
            for(int j = 1; j < N + 1; j++) {
                rowData[i][j] = matrix[i][j - 1] ? "1" : "0";
            }
        }
        myTable = new MyTable(rowData, columnNames, this);
        return myTable;
    }

    /**
     * 根据定义找到极大元（maximal element）。
     * 对于集合A上的偏序关系R，如果A中存在元素a，使得A中没有其他元素x，满足aRx，则称a为A中的极大元。
     * 注意：极大元必定存在，且可能存在多个。
     * @return 一个包含所有极大元的链表。若当前二元关系不是偏序关系，则返回null。
     */
    public LinkedList<Integer> maxElements() {
        if(! isPartialOrder()) {
            return null;
        }
        LinkedList<Integer> maxElements = new LinkedList<>();
        for(int i = N - 1; i >= 0; i--) {
            boolean hasBiggerElement = false;
            for(int j = 0; j < N; j++) {
                if(matrix[i][j] && (i != j)) {
                    hasBiggerElement = true;
                    break;
                }
            }
            if(! hasBiggerElement) {
                maxElements.add(SET.get(i));
            }
        }
        return maxElements;
    }

    /**
     * 根据定义找到极小元（minimal element）。
     * 对于集合A上的偏序关系R，如果A中存在元素a，使得A中没有其他元素x，满足xRa，则称a为A中的极小元。
     * 注意：极小元必定存在，且可能存在多个。
     * @return 一个包含所有极小元的链表。若当前二元关系不是偏序关系，则返回null。
     */
    public LinkedList<Integer> minElements() {
        if(! isPartialOrder()) {
            return null;
        }
        LinkedList<Integer> minElements = new LinkedList<>();
        for(int j = 0; j < N; j++) {
            boolean hasSmallerElement = false;
            for(int i = 0; i < N; i++) {
                if(matrix[i][j] && (i != j)) {
                    hasSmallerElement = true;
                    break;
                }
            }
            if(! hasSmallerElement) {
                minElements.add(SET.get(j));
            }
        }
        return minElements;
    }

    /**
     * 若最大元存在，则根据定义找到最大元（greatest element）。
     * 对于集合A上的偏序关系R，如果A中存在元素a，使得对于A中任何元素x，都有xRa，则称a为A中的最大元。
     * 注意：最大元不一定存在，若存在则必定惟一。
     * @return 唯一的最大元；若最大元不存在，或当前二元关系不是偏序关系，则返回null。
     */
    public Integer greatestElement() {
        if(! isPartialOrder()) {
            return null;
        }
        for(int j = N - 1; j >= 0; j--) {
            boolean biggerThanAll = true;
            for(int i = 0; i < N; i++) {
                if(! matrix[i][j]) {
                    biggerThanAll = false;
                    break;
                }
            }
            if(biggerThanAll) {
               return SET.get(j);
            }
        }
        return null;
    }

    /**
     * 若最小元存在，则根据定义找到最小元（least element）。
     * 对于集合A上的偏序关系R，如果A中存在元素a，使得对于A中任何元素x，都有aRx，则称a为A中的最小元。
     * 注意：最小元不一定存在，若存在则必定惟一。
     * @return 唯一的最小元；若最小元不存在，或当前二元关系不是偏序关系，则返回null。
     */
    public Integer leastElement() {
        if(! isPartialOrder()) {
            return null;
        }
        for(int i = 0; i < N; i++) {
            boolean smallerThanAll = true;
            for(int j = 0; j < N; j++) {
                if(! matrix[i][j]) {
                    smallerThanAll = false;
                    break;
                }
            }
            if(smallerThanAll) {
                return SET.get(i);
            }
        }
        return null;
    }

    /**
     * 返回一个表示二元关系内容的String对象。例如：{(1, 1), (1, 2)}
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{");
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(matrix[i][j]){
                    str.append("(");
                    str.append(SET.get(i));
                    str.append(",");
                    str.append(SET.get(j));
                    str.append("), ");
                    count++;
                    if((count % 10) == 0) {
                        str.append("\n");
                    }
                }
            }
        }
        int len = str.length();
        if(count == 0) {
            return "{ }";
        }
        str.delete(len - 2, len);
        str.append("}");
        return str.toString();
    }

    /**
     * 在控制台打印出关系矩阵。若对应元素为true则打印1，为false则打印0。
     * 仅供控制台测试调用。
     */
    @Deprecated
    public void printMatrix() {
        System.out.print("   ");
        for(int i = 0; i < N - 1; i++) {
            System.out.print(SET.get(i));
            System.out.print("  ");
        }
        System.out.println(SET.get(N - 1));
        for(int i = 0; i < N; i++) {
            System.out.print(SET.get(i));
            System.out.print("  ");
            for(int j = 0; j < N - 1; j++) {
                System.out.print(matrix[i][j] ? 1 : 0);
                System.out.print("  ");
            }
            System.out.println(matrix[i][N - 1] ? 1 : 0);
        }
    }

}