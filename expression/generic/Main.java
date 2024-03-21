package expression.generic;

public class Main {
    public static void main(String[] args) {
        Tabulator table = new GenericTabulator();
        try {
            String md = args[0].substring(1);
            //System.out.println(args[0]);
            Object[][][] tbl = table.tabulate(md, args[1], -2, 2, -2, 2, -2, 2);
            for (int i = 0; i < 5; i++) {
                System.out.println("x: " + (-2 + i));
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        System.out.print(tbl[i][j][k] + "\t");
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
