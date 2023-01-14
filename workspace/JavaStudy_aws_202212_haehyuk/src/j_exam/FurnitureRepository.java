package j_exam;

import java.util.List;
import java.util.Scanner;


public class FurnitureRepository {
    private Furniture furniture;
    private List<Furniture> furnitures;
    private final Scanner scanner;

    private static final int CODE = 20230000;
    private static int ai = 1;

    public FurnitureRepository (List<Furniture> furnitures) {
        this.furnitures = furnitures;
        scanner = new Scanner(System.in);
    }

    public List<Furniture> getFurniture() {
        return furnitures;
    }

    private void addFurniture(){
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

    private void insertFurniture() {


        System.out.println("구매하실 제품의 정보를 입력해주세요");
        System.out.println();


        System.out.println("가구 종류: 침대, 의자, 책상");
        System.out.print("가구종류 입력: ");
        String type = scanner.nextLine();

        if (type.equals("침대")) {
            furniture = new Bed();
        }else if (type.equals("의자")) {
            furniture = new Chair();
        }else if (type.equals("책상")) {
            furniture = new Desk();
        }

        System.out.print("가구 색깔: ");
        String color = scanner.nextLine();

        System.out.print("제품이름: ");
        String productName = scanner.nextLine();

        System.out.println("============================");

        furniture.setFurnitureCode(CODE + ai);
        furniture.setType(type);
        furniture.setColor(color);
        furniture.setProductName(productName);

    }

    public void saveFurniture() {
        insertFurniture();
        addFurniture();
        FurnitureFactory.getInstance().make(furniture);
    }

    public void checkReservationByCode() {
        System.out.println("예약번호를 입력해주세요.");
        int checkCode = scanner.nextInt();
        scanner.nextLine();
        if(!(furniture.getFurnitureCode() == checkCode)) {
            System.out.println("조회하신 예약번호가 없습니다");
        }else {
            System.out.println("예약하신 제품은 " + furniture.getProductName() + furniture.getType() +" 입니다.");
        }
    }


}
