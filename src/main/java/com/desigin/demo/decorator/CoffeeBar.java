package com.desigin.demo.decorator;

class CoffeeBar {
    public static void main(String[] args) {
        // 装饰者模式下的订单：2 份巧克力+一份牛奶的 LongBlack
        // 1.  点一份 LongBlack
        Drink order = new LongBlack();
        System.out.println("费用 1=" + order.cost());
        System.out.println("描述=" + order.getDes());
        // 2. order 加入一份牛奶
        order = new Milk(order);
        System.out.println("order 加入一份牛奶 费用 =" + order.cost());
        System.out.println("order 加入一份牛奶 描述 = " + order.getDes());
        // 3. order 加入一份巧克力
        order = new Chocolate(order);
        System.out.println("order 加入一份牛奶  加入一份巧克力	费 用 =" + order.cost());
        System.out.println("order 加入一份牛奶 加入一份巧克力 描述 = " + order.getDes());
        // 3. order 加入一份巧克力
        order = new Chocolate(order);
        System.out.println("order 加入一份牛奶  加入 2 份巧克力	费 用 =" + order.cost());
        System.out.println("order 加入一份牛奶 加入 2 份巧克力 描述 = " + order.getDes());
        System.out.println("===========================");
        Drink order2 = new DeCaf();
        System.out.println("order2 无因咖啡	费 用 =" + order2.cost());
        System.out.println("order2 无因咖啡 描述 = " + order2.getDes());
        order2 = new Milk(order2);
        System.out.println("order2 无因咖啡  加入一份牛奶	费 用 =" + order2.cost());
        System.out.println("order2 无因咖啡 加入一份牛奶 描述 = " + order2.getDes());
    }
}

abstract class Drink {
    public String des; // 描 述
    private float price = 0.0f;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    //计算费用的抽象方法
    //子类来实现
    public abstract float cost();

}


class Decorator extends Drink {
    private Drink obj;

    public Decorator(Drink obj) { //组合
        this.obj = obj;
    }

    @Override
    public float cost() {
		// getPrice 自己价格
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDes() {
	// obj.getDes() 输出被装饰者的信息
        return des + " " + getPrice() + " && " + obj.getDes();
    }
}

class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}

class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        setDes(" 牛 奶 ");
        setPrice(2.0f);
    }
}

class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setDes(" 豆浆	");
        setPrice(1.5f);
    }
}

class Chocolate extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        setDes(" 巧克力 ");
        setPrice(3.0f); // 调味品 的价格
    }
}



class ShortBlack extends Coffee {
    public ShortBlack() {
        setDes(" shortblack ");
        setPrice(4.0f);
    }
}

class DeCaf extends Coffee {
    public DeCaf() {
        setDes(" 无因咖啡 ");
        setPrice(1.0f);
    }
}

class Espresso extends Coffee {
    public Espresso() {
        setDes(" 意大利咖啡 ");
        setPrice(6.0f);
    }
}

class LongBlack extends Coffee {
    public LongBlack() {
        setDes(" longblack ");
        setPrice(5.0f);
    }
}