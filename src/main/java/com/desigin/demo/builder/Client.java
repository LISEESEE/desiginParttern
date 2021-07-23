package com.desigin.demo.builder;

/**
 * 产品 ：House
 * 抽象的建造者：HouseBuilder
 * 具体的建造者：CommonHouse、HighHouse
 * 指挥者：HouseDirect
 */
public class Client {

    public static void main(String[] args) {

        //盖普通房子
        CommonHouse commonHouse = new CommonHouse();
        //准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        //完成盖房子，返回产品(普通房子)
        House house = houseDirector.constructHouse();
        System.out.println(" 输 出 流 程 ");
        System.out.println("--------------------------");
        //盖高楼
        HighBuilding highBuilding = new HighBuilding();
        //重置建造者
        houseDirector.setHouseBuilder(highBuilding);
        //完成盖房子，返回产品(高楼)
        houseDirector.constructHouse();
    }
}

class CommonHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println(" 普通房子打地基 5 米 ");
    }
    @Override
    public void buildWalls() {
        System.out.println(" 普通房子砌墙 10cm ");
    }
    @Override
    public void roofed() {
        System.out.println(" 普通房子屋顶 ");
    }
}


class HighBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println(" 高楼的打地基 100 米 ");
    }
    @Override
    public void buildWalls() {
        System.out.println(" 高楼的砌墙 20cm ");
    }


    @Override
    public void roofed() {
        System.out.println(" 高楼的透明屋顶 ");
    }
}


// 产 品 ->Product
class House {
    private String baise;
    private String wall;
    private String roofed;

    public String getBaise() {
        return baise;
    }

    public void setBaise(String baise) {
        this.baise = baise;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
}
// 抽象的建造者
abstract class HouseBuilder {
    protected House house = new House();
    //将建造的流程写好, 抽象的方法
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void roofed();
    //建造房子好， 将产品(房子) 返回
    public House buildHouse() {
        return house;
    }
}

//指挥者，这里去指定制作流程，返回产品
class HouseDirector {
    HouseBuilder houseBuilder = null;

    //构造器传入 houseBuilder
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //通过 setter 传入 houseBuilder
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //如何处理建造房子的流程，交给指挥者
    public House constructHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}
