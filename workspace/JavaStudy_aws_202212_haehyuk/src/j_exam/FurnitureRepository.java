package j_exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FurnitureRepository {
    private Furniture furniture;
    private List<Furniture> furnitures;

    private static final int CODE = 20230000;
    private static int ai = 1;

    private int furnitureCode;
    private String productName;
    private String type;
    private String colors;

    public FurnitureRepository () {
        furnitures = new ArrayList<>();

    }

    public void addFurniture(Furniture furniture){
        furniture.setFurnitureCode(CODE + ai);
        ai++;

        for (int i = 0; i < furnitures.size(); i++) {
            if(furnitures.get(i) == null) {
                furnitures.add(furniture);
                return;
            }
        }
        System.out.println();
    }

    public void insertFurniture(Furniture furniture) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구매하실 제품의 정보를 입력해주세요");

        System.out.print("가구의 종류: ");
        String type = scanner.nextLine();

        System.out.print("가구 색깔: ");
        String color = scanner.nextLine();

        System.out.print("제품이름: ");
        String productName = scanner.nextLine();

        System.out.println("============================");


        furniture.setFurnitureCode(CODE + ai);
        furniture.setType(type);
        furniture.setColor(color);
        furniture.setProductName(productName);

        addFurniture(furniture);
    }


}
